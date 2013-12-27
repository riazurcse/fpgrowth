/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

import com.bitmask.fpgrowth.datastructure.Node;
import com.bitmask.fpgrowth.operations.Initializer;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ioi
 */
public class Thesis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Node n = new Node();        
        Scanner input = new Scanner(System.in);
        Initializer data = new Initializer();
        while(input.hasNextLine())
        {
            String sc = input.nextLine();
            if(sc.equalsIgnoreCase("quit")){
                break;
            }
            int length = sc.length();
            ArrayList<String> list = new ArrayList<String>();
            for(int i = 0; i < length; i++){
                String ch = sc.substring(i, i + 1);
                list.add(ch);
            }
            data.addSequence(list);
        }
        
        
        data.performCountAndSort();
        
    }
}
