package api;

import org.jetbrains.annotations.NotNull;

public class NodeData implements node_data, Comparable<node_data>{

    private int key, tag;
    private String info;
    private double w;
    private geo_location location;

    public NodeData(int key, geo_location location){
        this.key = key;
        this.info = "White";
        this.tag = -1;
        this.location = location;
    }

    public NodeData(node_data n) {
    }

    @Override
    public int getKey() {
        return key;
    }

    @Override
    public geo_location getLocation() {
        return location;
    }

    @Override
    public void setLocation(geo_location p) {
        location = p;
    }

    @Override
    public double getWeight() {
        return w;
    }

    @Override
    public void setWeight(double w) {
        this.w = w;
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public void setInfo(String s) {
        this.info = s;
    }

    @Override
    public int getTag() {
        return tag;
    }

    @Override
    public void setTag(int t) {
        tag = t;
    }

    @Override
    public int compareTo(@NotNull node_data o) {

        double w1 = this.getWeight();
        double w2 = o.getWeight();

        return Double.compare(w1, w2);

    }

    @Override
    public String toString() {
        return "";
    }
}
