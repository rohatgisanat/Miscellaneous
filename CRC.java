/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package singlefile;

import java.util.Scanner;

/**
 *
 * @Sanat Rohatgi
 */
public class CRC {

    public static void main(String[] args)throws Exception {
            
        String c,k;
        int len;
        
        char code[],codecopy[],key[];
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Code then Enter Key");
       c= sc.nextLine();
       k=sc.nextLine();
        len=c.length();
        
       for(int i=0;i<k.length()-1;i++){
           c=c+"0";
       }
       
        System.out.println("code becomes"+c);
            code=c.toCharArray();
            codecopy=c.toCharArray();
            key=k.toCharArray();
            int t=0;
            
            for(int y=0;y<(code.length-key.length);y++){
                if(code[y]=='0'){
                    continue;
                }
                else{
                    t=y;
                    for(int e=0;e<key.length;e++){
                        code[t]=((code[t]!=key[e])?('1'):('0'));
                        t++;
                    }
                }
                
            }
           
            for(int i=len;i<code.length;i++)
            codecopy[i]=code[i];
            System.out.println("Final code is");
            for(int i=0;i<codecopy.length;i++)
            System.out.print(codecopy[i]);
    }
    
    

}
