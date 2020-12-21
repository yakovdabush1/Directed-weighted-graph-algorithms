package api;
//import com.google.gson.*;
//
//import java.awt.*;
//import java.io.*;
//import java.util.*;

import java.awt.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DWGraph_Algo implements dw_graph_algorithms {
    directed_weighted_graph d;


    @Override
    public void init(directed_weighted_graph g) {
        this.d = g ;
    }

    @Override
    public directed_weighted_graph getD() { return d; }

    @Override
    public directed_weighted_graph copy() {
        if (d.getV().size() >0) {
            DWGraph_DS ans = new DWGraph_DS();

            for (node_data a : this.d.getV()) {
                ans.addNode(new NodeData(a));

            for (edge_data b : this.d.getE(a.getKey())) {
                  if(!ans.hasNode(b.getDest())){
                  ans.addNode(new NodeData(((EdgeData) b).destination));
                  }
             ans.connect(a.getKey(), b.getDest(), b.getWeight());
            }
            return ans;
        }

    }
        return null;
    }
    @Override
        public boolean isConnected() {
            Collection<node_data> v = d.getV();
            Iterator<node_data> iter = v.iterator();
            while(iter.hasNext()) {
                node_data n = iter.next();
                clear();
                // start DFS from first node
                DFS( d, n.getKey());

                for (node_data node: d.getV())
                    if (node.getTag()!= new Color(1).getRGB())
                        return false;
            }
            return true;
        }
        private void clear() {
            Collection<node_data> v = d.getV();
            Iterator<node_data> it = v.iterator();
            while(it.hasNext()) {
                node_data n = it.next();
                n.setWeight(Double.MAX_VALUE);
                n.setTag(0);
                n.setInfo(null);
            }
        }
        private static void DFS(directed_weighted_graph d2, int v){
            // mark current node as visited
            d2.getNode(v).setTag(1);
            Collection<edge_data> edges = d2.getE(v);
            // do for every edge (v -> u)
            for (edge_data u : edges){
                // u is not visited
                if (d2.getNode(u.getDest()).getTag() != new Color(1).getRGB())
                    DFS(d2, u.getDest());
            }
        }
    @Override
    public double shortestPathDist(int src, int dest) {

        return 1.0;
//        clear();
//        Queue <node_data> pq = new LinkedList<node_data>();
//        node_data source = d.getNode(src);
//        source.setWeight(0);
//        pq.add(source)
//        while(source != null) {
//            //mark visit
//            source.setTag(1);
//            //array list of edges getting out from source
//            Collection<edge_data> eSrc = d.getE(source.getKey());
//            //checking every node weight and change it if needed
//            for (edge_data e : eSrc) {
//                node_data neighbor = d.getNode(e.getDest());
//                if (neighbor.getWeight() > source.getWeight() + e.getWeight()) {
//                    neighbor.setWeight(source.getWeight() + e.getWeight());
//                    neighbor.setInfo("" + source.getKey());
//                    pq.add(neighbor);
//                }
//            }
//            //remove first from queue
//            pq.poll();
//            source = pq.peek();
//
//        }
//        if (d.getNode(dest).getWeight() == Double.MAX_VALUE) {
//            System.out.println("there is no path between "+ src + " and " + dest);
//            return Double.POSITIVE_INFINITY;
//        }
//        else {
//            return d.getNode(dest).getWeight();
//        }
    }



    @Override
    public List<node_data> shortestPath(int src, int dest) {
        return null;
    }

    @Override
       public boolean save(String file) {
        return false;
        }

    @Override
    public boolean load(String file) {
        return false;
    }
}
