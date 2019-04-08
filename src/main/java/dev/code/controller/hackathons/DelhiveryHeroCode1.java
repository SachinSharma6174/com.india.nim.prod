package dev.code.controller.hackathons;

import java.io.DataInputStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * @author sachin.sharma
 */
public class DelhiveryHeroCode1 {



    public static void main(String[] args) throws IOException {
        Scanner sc =new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            t = t - 1;
            int m = sc.nextInt();
            int[] manufacturedCakes = new int[m + 1];
            Set<Integer> hash_Set = new HashSet<>();
            for (int i = 0; i < m; i++) {
                manufacturedCakes[i] = sc.nextInt();
                //System.out.println(manufacturedCakes[i]);
            }




            int requiredAmountcake = sc.nextInt();

            boolean isCakePossible = checkIfCakeCombinationExists(manufacturedCakes, m, requiredAmountcake);

            if (isCakePossible) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }


    static boolean checkIfCakeCombinationExists(int set[],
                                                int n, int sum) {

        boolean subset[][] =
                new boolean[sum + 1][n + 1];


        for (int i = 0; i <= n; i++)
            subset[0][i] = true;


        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;


        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                if(subset[sum][n]==true) return true;
                subset[i][j] = subset[i][j - 1];
                if (i >= set[j - 1])
                    subset[i][j] = subset[i][j] ||
                            subset[i - set[j - 1]][j - 1];
            }
        }
        return subset[sum][n];
    }


    static boolean checkIfCakeCombinationExistsV2(int arr[], int n, int sum)
    {
        boolean subset[][] = new boolean[2][sum + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {


                if (j == 0)
                    subset[i % 2][j] = true;

                else if (i == 0)
                    subset[i % 2][j] = false;
                else if (arr[i - 1] <= j)
                    subset[i % 2][j] = subset[(i + 1) % 2]
                            [j - arr[i - 1]] || subset[(i + 1) % 2][j];
                else
                    subset[i % 2][j] = subset[(i + 1) % 2][j];
            }
        }

        return subset[n % 2][sum];
    }

}
