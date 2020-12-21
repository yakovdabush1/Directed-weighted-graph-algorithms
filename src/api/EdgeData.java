package api;

import java.awt.*;
import java.io.Serializable;

public class EdgeData implements edge_data, Serializable {

     int src, dest;
     double w;
     String info;
     Color tag;

//    node_data source;
//    node_data destination;

   public EdgeData(int src,int dest,double w){
       this.src = src;
       this.dest = dest;
       this.w = w;
   }

    public EdgeData(node_data source, node_data destination, double w){

        this.w = w;
//        this.source = source;
//        this.destination = destination;
        this.info = "";
        this.tag = Color.RED;
    }

    public EdgeData(EdgeData edge) {
        src = edge.getSrc();
        dest = edge.getDest();
        w = edge.getWeight();

//        source = edge.source;
//        destination =edge.getDestination();

        info = edge.getInfo();
        tag = new Color(edge.getTag());
    }

    /**
     * The id of the source node of this edge.
     * @return
     */

    public int getSrc(){
        return src;
    }

    /**
     * The id of the destination node of this edge
     * @return
     */
    public int getDest(){
        return dest;
    }
    /**
     * @return the weight of this edge (positive value).
     */
    public double getWeight(){
        return w;
    }
    /**
     * Returns the remark (meta data) associated with this edge.
     * @return
     */
    public String getInfo(){
        return info;
    }
    /**
     * Allows changing the remark (meta data) associated with this edge.
     * @param s
     */
    public void setInfo(String s){
        info = s;
    }
    /**
     * Temporal data (aka color: e,g, white, gray, black)
     * which can be used be algorithms
     * @return
     */
    public int getTag(){
        return tag.getRGB();
    }
    /**
     * This method allows setting the "tag" value for temporal marking an edge - common
     * practice for marking by algorithms.
     * @param t - the new value of the tag
     */
    public void setTag(int t){
        tag = new Color (t);
    }

//    public node_data getSource() {
//        return source;
//    }
//    public node_data getDestination() {
//        return destination;
//    }


    @Override
    public String toString() {
        return "";
    }
}