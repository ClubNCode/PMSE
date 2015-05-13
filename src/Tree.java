import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Tree {

    private class Node {
        public int value;
        public ArrayList<Node> children = new  ArrayList<Node>();
        public ArrayList<Node> parents = new  ArrayList<Node>();
         int  INFINITY = Integer.MAX_VALUE;

        public void addChild(Node n) {
            children.add(n);
        }

        public void addParent(Node n) {
            parents.add(n);
        }

        public int getValue() {return value;}

        //What is the value from H -> I -> L (H+I+L):
        int getValueToNode(Node Destination, HashSet<Node> s) {
           int minValue = INFINITY;
           int value = 0;

           if(s.contains(this)) return INFINITY; //we already checked this
           s.add(this);
           if(this.equals(Destination)) return Destination.getValue();

           for(int i = 0; i < children.size(); i++) {
               Node c = children.get(i);
               int value1 = c.getValueToNode(Destination, s);
               if (value1 != Integer.MAX_VALUE && value1 < minValue) {
                   minValue = value1 + this.getValue();
               }
           }

           for(int i = 0; i < parents.size(); i++) {
               Node p = parents.get(i);
               value = p.getValueToNode(Destination, s);
               if (value != Integer.MAX_VALUE && value < minValue) {
                   minValue = value + this.getValue();
               }
           }
           return minValue;
        }

        //Who will be affected if H changes. H -> B,C,D -> A
        public int getDependency(ArrayList<Node> affected) {
          for(int i = 0; i < children.size(); i++) {
               Node c = children.get(i);
               affected.add(c);
           }

           for(int i = 0; i < parents.size(); i++) {
               Node p = parents.get(i);
               affected.add(p);
           }
		return INFINITY;
        }

        //What are the dependencies of H? F, G, E.
        List<Node> getDependency() {
           List<Node> dependency = new ArrayList<Node>();
           for(int i = 0; i < parents.size(); i++) {
               Node p = parents.get(i);
               for(int j= 0 ; j < p.children.size(); j++) {
                   Node c = p.children.get(i);
                   if(!c.equals(this)) dependency.add(c);
               }
           }
           return dependency;
        }
    }

    //data here.
    private Map<String, Node> mapping = new HashMap<String, Node>();

    public void connectParentToChild(String parent, String child) {
        Node p = getNode(parent);
        Node c = getNode(child);
        p.addChild(c);
        c.addParent(p);
    }

    public int getValue(String first, String second) {
        Node a = getNode(first);
        Node b = getNode(second);
        HashSet<Node> s = new HashSet<Node>();
        return a.getValueToNode(b, s);
    }

    private Node getNode(String s) {
        if(!mapping.containsKey(s)) {
           mapping.put(s, new Node());
        }
        return mapping.get(s);
    }

    public static void main(String[] args) {
        Tree t=new Tree();
        t.connectParentToChild("A", "D");
        t.connectParentToChild("A", "B");
        t.connectParentToChild("A", "C");
        t.connectParentToChild("B", "C");
        t.connectParentToChild("B", "H");
        t.connectParentToChild("B", "F");
        t.connectParentToChild("B", "E");
        //Set all other nodes
        t.getValue("H", "L");
    }
}