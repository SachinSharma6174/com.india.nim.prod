package dev.code.controller.hackathons;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author sachin.sharma
 */

/***
 *
 * For each test case, print the ticket numbers in a single line forming the maximum sum
 * in the format similar to Sample Test Case.
 * TEST CASES
 *
 * 5
 * 5
 * -1 7 8 -5 4
 * 4
 * 3 2 1 -1
 * 4
 * 11 12 -2 -1
 * 4
 * 4 5 4 3
 * 4
 * 5 10 4 -1
 *
 *
 *
 * 48
 * 13
 * 12
 * 44
 * 10
 */


public class TechgigQualifiers2 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test > 0) {

            test--;
            int n = sc.nextInt();
            int[] tickets = new int[n + 1];

            for (int i = 0; i < n; i++) {
                tickets[i] = sc.nextInt();
            }

            computeBestFit(tickets);
            System.out.println();

        }
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static void computeBestFit(int[] tickets) {
        int size = tickets.length;
        int cumm_max[] = new int[size + 1];
        /** Base cases **/
        cumm_max[0] = max(tickets[0], 0);
        cumm_max[1] = max(tickets[1], 0);
        cumm_max[2] = max(tickets[2] + tickets[0], tickets[2]);
        for (int i = 3; i < size; i++) {
            cumm_max[i] = max(max(cumm_max[i - 2], cumm_max[i - 3]) + tickets[i], max(cumm_max[i - 2], cumm_max[i - 3]));
        }

        int max = Arrays.stream(cumm_max).max().getAsInt();
        //System.out.println(max);

        displayMaxSubSequence(tickets,cumm_max);
    }

    private static void displayMaxSubSequence(int[] tickets, int[] cumm_max) {
        int max = Arrays.stream(cumm_max).max().getAsInt();
            int index = getIndexOf(cumm_max,max) ;
        System.out.print(tickets[index]);
        int tmp = max - tickets[index];
        for(int i=index;i>=0;i--){

            if(tmp==cumm_max[i] && tickets[i]>0 ){
                System.out.print(tickets[i]);
                tmp = tmp- tickets[i];
            }
            if(tmp==0){
                return;
            }
        }
    }

    private static int getIndexOf(int[] cumm_max, int max) {
        int index = -1;
        for(int i=0;i<cumm_max.length;i++){
            if(cumm_max[i]  == max){
                index =i;
                break;
            }
        }
        return index;
    }
}

