/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitmask.fpgrowth.operations;

import com.bitmask.fpgrowth.datastructure.Node;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author ioi
 */
public class Initializer {
    
    Node root;
    
    ArrayList<ArrayList<String>> list;
    ArrayList<Count> countList;
    
    private class Count {
        String element;
        Integer count;

        Count(String str, Integer c){
            element = str;
            count = c;
        }       
    } 
    
    private class CountComparator implements Comparator<Count>{
        
            static final int ASCENDING = 1;
            static final int DECENDING = 2;
            private int mode;
            CountComparator(int MODE){
                mode = MODE;
            }
            @Override
            public int compare(Count a, Count b){
                if(mode == ASCENDING){
                    return a.count.compareTo(b.count);  
                }else{
                    return b.count.compareTo(a.count);  
                }                
            }
    };
    
    public Initializer(){
        list = new ArrayList<ArrayList<String>>();
    }


    public void addSequence(ArrayList<String> sequence){        
        list.add(sequence);
    }
    
    public void performCountAndSort(){
        HashMap<String, Integer> counter = new HashMap<String, Integer>();
        for(int i = 0; i < list.size(); i++){
            ArrayList<String> items = list.get(i);
            for(int j = 0; j < items.size(); j++){
                String item = items.get(j);
                if(!counter.containsKey(item)){
                    counter.put(item, 1);
                }else{
                    counter.put(item, counter.get(item) + 1);
                }
            }
        }
        if(countList == null){
            countList = new ArrayList<Count>();
        }else{
            countList.clear();
        }
        Set<String> items = counter.keySet();
        Iterator<String> item = items.iterator();
        while(item.hasNext()){
            String itm = item.next();
            Count count = new Count(itm, counter.get(itm));
            countList.add(count);
        }
        Collections.sort(countList, new CountComparator(CountComparator.DECENDING)); 
        
        for(int i=0; i<countList.size();i++)
        {
            Count c = countList.get(i);
            System.out.println(c.element + " : " + c.count);
        }
    }
}
