/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitmask.fpgrowth.datastructure;

import java.util.ArrayList;
import java.util.Iterator;

/*
 *
 * @author ioi
 */
public class Node {

    private String product;
    private Integer count;
    private ArrayList<Node> children;
    private Node parent;

    public Node(String string) {
        product = string;
        parent = null;
        count = 1;
        children = new ArrayList<Node>();
    }

    public Node(String string, Node parent) {
        this.parent = parent;
        product = string;
        count = 1;
        children = new ArrayList<Node>();
    }

    public Node() {
        product = null;
        parent = null;
        count = null;
        children = new ArrayList<Node>();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void assignChildren(ArrayList<String> sequence) {
        int length = sequence.size();
        Node c = new Node(sequence.get(0), this);
        Iterator<Node> iterator = children.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Node t = iterator.next();
            if (t.product.equalsIgnoreCase(c.product)) {
                c = t;
                c.count++;
                found = true;
                break;
            }
        }
        if (!found) {
            addChildren(c);
        }
        if (length > 1) {
            sequence.remove(0);
            c.assignChildren(sequence);
        }
    }

    public void addChildren(Node child) {
        children.add(child);
    }

    public void removeChild(Integer id) {
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

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void printInLine() {
        System.out.print(product + "(" + count + ") ");
        if (children.size() > 0) {
            for (int i = 0; i < children.size(); i++) {
                children.get(i).printInLine();
            }
        }
    }
}
