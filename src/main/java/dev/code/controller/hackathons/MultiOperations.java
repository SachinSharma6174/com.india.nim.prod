package dev.code.controller.hackathons;

import java.util.Scanner;

/**
 * @author sachin.sharma
 */
public class MultiOperations {

    public static void main(String[] args){

        Scanner sc  = new Scanner(System.in);
        int test = sc.nextInt();

        for(int i=0;i<test;i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int n_arr[] = new int[n+1];
            int m_arr[] = new int[m+1];


            for(int j=0;i<n;j++){
                n_arr[j] = sc.nextInt();
            }

            for(int j=0;i<m;j++){
                m_arr[j] = sc.nextInt();
            }

            int op = sc.nextInt();

            switch(op){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;

            }

        }
    }
}
