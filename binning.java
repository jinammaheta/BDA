/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bda3;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author s16it31
 */
public class binning {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String aa[] = s.split(", ");
        int a[] = new int[aa.length];
        for (int i = 0; i < aa.length; i++) {
            a[i] = Integer.parseInt(aa[i]);
        }
        Arrays.sort(a);
        System.out.println("Enter the depth");
        int d = sc.nextInt();
        int t;
        if (aa.length % d == 0) {
            t = aa.length / d;
        } else {
            t = aa.length / d + 1;
        }

        int fre[][] = new int[t][];
        int k = 0;
        for (int j = 0; j < t; j++) {
            int temp = aa.length - k;
            if (d <= temp) {
                fre[j] = new int[d];
            } else {
                fre[j] = new int[aa.length - k];
            }
            for (int i = 0; i < d; i++) {
                fre[j][i] = Integer.parseInt(aa[k++]);
                if (k == aa.length) {
                    break;
                }
            }
        }
        System.out.println("Binnin1");
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < fre[i].length; j++) {
                System.out.print(fre[i][j] + " ");
            }
            System.out.println("");
        }
        int avg[] = new int[t];
        for (int i = 0; i < t; i++) {
            int sum = 0;
            for (int j = 0; j < fre[i].length; j++) {
                sum += fre[i][j];
            }
            avg[i] = Math.round((float) sum / fre[i].length);

        }
        int smooth[][] = new int[t][];
        for (int i = 0; i < t; i++) {
            smooth[i] = new int[fre[i].length];
            for (int j = 0; j < fre[i].length; j++) {
                smooth[i][j] = avg[i];
            }
        }
        System.out.println("Binning2");
         for (int i = 0; i < t; i++) {
            for (int j = 0; j < fre[i].length; j++) {
                System.out.print(smooth[i][j] + " ");
            }
            System.out.println("");
        }
        int bound[][] = new int[t][];
        for (int i = 0; i < t; i++) {
            bound[i] = new int[fre[i].length];
            for (int j = 0; j < fre[i].length; j++) {
                int t1 = fre[i][j] - fre[i][0];
                int t2 = fre[i][fre[i].length - 1] - fre[i][j];
                if (t1 <= t2) {
                    bound[i][j] = fre[i][0];
                } else {
                    bound[i][j] = fre[i][fre[i].length - 1];
                }
            }

        }
        System.out.println("Binning3");
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < fre[i].length; j++) {
                System.out.print(bound[i][j] + " ");
            }
            System.out.println("");
            //4, 8, 9, 15, 21, 21, 24, 25, 26, 28, 29, 34
            //13, 15, 16, 16, 19, 20, 20, 21, 22, 22, 25, 25, 25, 25, 30, 33, 33, 35, 5, 35, 35, 36, 40, 45, 46, 52, 70 
        }
    
}
}