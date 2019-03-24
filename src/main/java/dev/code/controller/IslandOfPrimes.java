package dev.code.controller;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @author sachin.sharma
 *
 * Problem Statement :
 * Given a two dimensional grid filled with positive integers, find the number of prime gangs.
 * A collection of adjacent primes forms a gang where adjacency is assumed vertical and horizontal.
 */
public class IslandOfPrimes {
    public static int ROW,COL=0;
    public static void main(String[] args) {
        int prime[] = new int[10005];

        Arrays.fill(prime,1);
        for (int p=2; p*p<=10001; p++)
        {
            if (prime[p] == 1)
            {
                for (int i=p*p; i<=10001; i += p)
                    prime[i] = 0;
            }
        }

        prime[0] = 0;
        prime[1] = 0;
        /**
         * print prime numbers in the Range 1 to 100000*/
        for(int i = 2; i <= 10001; i++)
        {
            if(prime[i] == 1)
                System.out.print(i + " ");
        }


        Scanner sc = new Scanner(System.in);
        int  t = sc.nextInt();
        for (int test=0;test<t;test++)
        {
            int n,m;
            n = sc.nextInt();
            m = sc.nextInt();

            int[][] a = new int[n+5][m+5];

            for(int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    a[i][j] = sc.nextInt();
                    a[i][j] = prime[a[i][j]];
                    //System.out.print(a[i][j] + " ");
                }
                //System.out.println();
            }
            ROW = n;
            COL = m;
            int numOfIslands = countIslands(a,n,m);
            System.out.println("Number of islands is "+ numOfIslands );
        }

    }


    public static boolean isSafe(int M[][], int row, int col,
                                 boolean visited[][])
    {
            return (row >= 0) && (row < ROW) &&
                (col >= 0) && (col < COL) &&
                (M[row][col]==1 && !visited[row][col]);
    }


    public static void DFS(int M[][], int row, int col, boolean visited[][])
    {
           int rowNbr[] = new int[] { -1,   0, 0,  1};
        int colNbr[] = new int[] {  0,  -1, 1,  0};


        visited[row][col] = true;


        for (int k = 0; k < 4; ++k)
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited) )
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
    }


    public static int countIslands(int M[][] , int ROW , int COL)
    {
        boolean visited[][] = new boolean[ROW][COL];

        int count = 0;
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (M[i][j]==1 && !visited[i][j])
                {
                    DFS(M, i, j, visited);
                    ++count;
                }

        return count;
    }
}


/*
* Sample Input :

1 1
1
1 1
2
4 2
1 1
2 2
1 1
2 2
3 3
1 2 1
2 1 2
1 2 1
2 2
2 2
2 2
2 2
1 1
1 1
5 5
2 1 1 1 2
1 2 2 2 1
1 2 1 2 1
1 2 2 2 1
2 1 1 1 2
5 5
2 7 9 5 9
3 4 2 3 8
9 9 1 5 6
2 9 7 3 4
3 6 1 7 5
10 10
6 8 7 1 8 2 4 7 2 6
9 3 5 3 8 5 4 6 2 8
5 9 2 8 8 6 4 5 4 8
7 1 9 9 1 9 6 7 4 9
4 2 9 9 6 8 3 9 8 3
6 4 4 3 7 6 6 6 8 6
2 7 3 9 4 5 6 2 6 6
3 3 8 3 5 7 8 7 6 6
7 4 6 6 8 5 3 5 8 9
6 2 9 8 8 9 4 7 2 8
15 15
1 8 8 9 4 4 3 4 3 9 8 6 2 6 6
8 5 6 4 5 2 6 2 5 2 1 5 8 7 5
1 1 6 9 5 6 7 5 3 7 5 2 2 5 9
9 3 3 3 8 2 1 7 5 7 2 1 8 2 1
8 9 7 4 7 9 5 5 2 6 7 4 6 5 7
2 4 2 3 4 6 4 5 8 1 9 6 8 2 8
4 9 1 4 4 8 8 3 9 2 9 7 6 4 3
2 3 3 9 6 2 3 4 9 2 9 8 3 2 4
7 1 8 5 1 4 6 4 2 5 8 7 1 5 3
7 2 6 3 8 2 7 5 1 4 5 9 9 8 2
6 1 2 9 8 7 5 3 9 7 2 7 1 5 2
1 2 7 5 8 4 9 5 8 4 2 3 2 5 2
3 3 4 2 9 5 6 3 8 7 2 1 4 7 1
4 3 9 3 9 5 7 2 4 4 3 7 7 3 5
3 2 1 7 3 5 5 4 9 4 5 7 9 6 3

* */



/**
 * sample Ouput
 0
 1
 2
 4
 1
 0
 5
 3
 12
 18
 * */
