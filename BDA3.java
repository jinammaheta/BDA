/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bda3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import sun.util.locale.StringTokenIterator;


public class BDA3 {
static Scanner sc=new Scanner(System.in);
    static float min_max(int a[])
    {
        
        int i=0;
        int max;
        int min;
        Arrays.sort(a);
        min=a[0];
        max=a[a.length-1];
        System.out.println("Enter your new range");
        int new_min=sc.nextInt();
        int new_max=sc.nextInt();
        System.out.println("Enter V");
        int v=sc.nextInt();
        float b=0;
        b=((v-min)/(float)(max-min))*(new_max-new_min)+new_min;
        return b; 
         
    }
    static void decimal(int a[])
    {
        Arrays.sort(a);
        int max=a[a.length-1];
        int len= Integer.toString(max).length();
        double di=Math.pow((double)10, (double)len);
        double b[]=new double[a.length];
        for(int i=0;i<a.length;i++)
        {
            b[i]=a[i]/(double)di;
        }
        for(int i=0;i<a.length;i++)
        {
            System.out.println(b[i]);
        }
    }
   static void z_score(int a[])
   {
       int sum=0;
       float avg;
       int i;
       for( i=0;i<a.length;i++)
       {
           sum+=a[i];
       }
       avg=(float)sum/a.length;
       float var = 0;
      
       for( i=0;i<a.length;i++)
       {
           var+=(a[i]-avg)*(a[i]-avg);
       }
       var=var/a.length;
      
       double std=Math.pow(var, 0.5);
       System.out.println("Enter V");
        int v=sc.nextInt();
        float vc=(v-avg)/(float)std;
        System.out.println(vc);
       
   }
    public static void main(String[] args) {
      
        String s=sc.nextLine();
        String aa[] =s.split(",");
        int a[]=new int[aa.length];
        for(int i=0;i<aa.length;i++)
            a[i]=Integer.parseInt(aa[i]);
        
         System.out.println("Enter your Choice\n 1. MIN-MAX\n 2. decimal\n 3. z-score");
         int ch=sc.nextInt();
         switch(ch)
         {
             case 1:System.out.println(min_max(a));
                 break;
             case 2:decimal(a);
             break;
             case 3:z_score(a);
                 
         }
        
    }
    
}
