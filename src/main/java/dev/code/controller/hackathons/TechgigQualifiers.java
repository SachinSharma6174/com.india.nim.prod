package dev.code.controller.hackathons;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author sachin.sharma
 */
public class TechgigQualifiers {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases > 0) {
            Boolean isWinHoldsGood = Boolean.TRUE;
            testCases--;
            int n = sc.nextInt();
            int[] VillanStrength = new int[n + 1];
            int[] heroEnergy = new int[n + 1];
            for (int i = 0; i < n; i++) {
                VillanStrength[i] = sc.nextInt();
            }
            Arrays.sort(VillanStrength);
            for (int i = 0; i < n; i++) {
                heroEnergy[i] = sc.nextInt();
            }
            Arrays.sort(heroEnergy);

            for (int i = 0; i < n; i++) {
                if(VillanStrength[i] > heroEnergy[i]){
                    isWinHoldsGood = Boolean.FALSE;
                    break;
                }
            }

            if(isWinHoldsGood){
                System.out.println("WIN");
            }else{
                System.out.println("LOSE");
            }



        }
    }
}