package com.seamfix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {


        int n =0;
        int d=0;
        float median = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of days there is transaction data for and he number of prior days the bank uses to calculate median spending \n");

        n = sc.nextInt();
        d= sc.nextInt();
        if( n<1 || n> 20000){
            System.out.println("true");
            throw new RuntimeException("The number of transaction days must be greater than 1 and less than 20,000");
        }
        if (d<1 || d>=n){
            throw new RuntimeException("The number of days the bank uses to calculate median spending must be greater than 1 and less than number of transaction days: "+d+"");
        }

        int[] arr= new int[n];
        int[] mid = new int[d];
        for(int i =0; i<n;i++){
            arr[i] = sc.nextInt();
            if (i ==n){
                sc.close();
            }
        }

        for (int i =0; i<d; i++){
            mid[i] = arr[i];
        }
        Arrays.sort(mid);

        if (d % 2 == 0 ){
            int medianNo = d/2;
            System.out.println(mid[medianNo]);
            int medianNo2 = medianNo-1;
            System.out.println(mid[medianNo2]);
            int total =  (mid[medianNo] + mid[medianNo2]);
            System.out.println(total);
            median = (float) (total/2.0);
            System.out.println("median "+ median);
        }else {
            double b = (double) d/2;
            double c = Math.ceil(b);
            System.out.println(c);
            int z = (int) c;
            System.out.println(z);
            median= mid[(int) c];
            System.out.println(median);
        }
        float deter = median *2;
        int output = 0;
        for (int i=d-1; i<n; i++){
            if (arr[i]>=deter){
            output++;
            }
        }
        System.out.println(output);

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int num = Integer.parseInt(br.readLine()); //Length of Array
//        String s= br.readLine(); //Input the number seperated by space
//        int[] arr= new int[num];
//        String[] s1 = s.split(" ");
//        for(int i=0;i<num;i++)
//        {
//            arr[i]=Integer.parseInt(s1[i]);
//        }
//        n =arr[0];
//        d =arr[1];
    }
}
