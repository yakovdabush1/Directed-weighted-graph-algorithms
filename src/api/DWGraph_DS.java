package api;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class DWGraph_DS implements directed_weighted_graph, Serializable {

    private HashMap<Integer,HashMap<Integer,edge_data>> Ni;
    private HashMap<Integer,node_data> graphMap;

    private int EdgeCount;
    private int MC;

    public DWGraph_DS(){
        this.graphMap = new HashMap<Integer, node_data>();
        this.Ni = new HashMap<Integer,HashMap<Integer,edge_data>>();

        EdgeCount = 0;
        MC = 0;
    }


    @Override
    public node_data getNode(int key) {
        if(graphMap.containsKey(key)){
            return graphMap.get(key);
        }
        return null;
    }

    private boolean hasEdge(int node1, int node2) {
        if(Ni.get(node1).containsKey(node2)){
            return true;
        }
        return false;
    }

    @Override
    public edge_data getEdge(int src, int dest) {
        if(hasEdge(src,dest) && src != dest){
            return Ni.get(src).get(dest);
        }
        return null;
    }

    @Override
    public void addNode(node_data n) {
        if(!graphMap.containsKey(n.getKey())){

            MC++;

            graphMap.put(n.getKey(), n);
            Ni.put(n.getKey(), new HashMap<Integer, edge_data>());
        }
    }

    @Override
    public void connect(int src, int dest, double w) {
        if(graphMap.containsKey(src) && graphMap.containsKey(dest) && src != dest && w >= 0) {

//            if (!Ni.containsKey(src)) {
//                Ni.put(src, new HashMap<Integer, edge_data>());
//            }

            if (!hasEdge(src, dest)) {
                EdgeData newEdge = new EdgeData(src, dest, w);
                Ni.get(src).put(dest, newEdge);
                MC++;
                EdgeCount++;
            }
        }
    }

    @Override
    public Collection<node_data> getV() {
        return graphMap.values();
    }

    @Override
    public Collection<edge_data> getE(int node_id) {
        if(graphMap.containsKey(node_id)) {
            return Ni.get(node_id).values();
        }
        return null;
    }

    @Override
    public node_data removeNode(int key) {
        if(graphMap.containsKey(key)){

            MC++;

            node_data removedNode = this.getNode(key);
            if(Ni.containsKey(key)) {
                Iterator<node_data> iterator = getV().iterator();
                while ((iterator.hasNext())) {
                    int destKey = iterator.next().getKey();
                    removeEdge(key, destKey);
                    removeEdge(iterator.next().getKey(), key);
                }
                Ni.remove(key);
            }

            graphMap.remove(key);

            return removedNode;
        }
        return null;
    }

    @Override
    public edge_data removeEdge(int src, int dest) {
        if(hasEdge(src,dest) && src != dest){

//            edge_data edge = Ni.get(src).get(dest);

            EdgeCount--;
            MC++;

            return Ni.get(src).remove(dest);
        }
        return null;
    }

    @Override
    public int nodeSize() {
        return graphMap.keySet().size();
    }

    @Override
    public int edgeSize() {
        return EdgeCount;
    }

    @Override
    public int getMC() {
        return MC;
    }

    public boolean hasNode(int dest) {
        return graphMap.containsKey(dest);
    }


    @Override
    public int hashCode() {
        return Objects.hash(graphMap, Ni, EdgeCount, MC);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof DWGraph_DS)) {
            return false;
        }

        DWGraph_DS other = (DWGraph_DS) obj;

        return EdgeCount == other.edgeSize()
                && MC == other.getMC()
                && Objects.equals(graphMap, other.graphMap)
                && Objects.equals(Ni, other.Ni);
    }

}