/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitmask.fpgrowth.datastructure;

import java.util.ArrayList;

/**
 *
 * @author ioi
 */
public class Node {
    
    String product;
    Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }
    
    public void addChildren(Node child){
        children.add(child);
    }
    
    public void removeChild(Integer id){
        children.remove(id);
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
    
    ArrayList<Node> children;
    Node parent;
    
    public String getProduct(){
        return product;
    }
    
    public void setProduct(String product){
        this.product = product;
    }
}
