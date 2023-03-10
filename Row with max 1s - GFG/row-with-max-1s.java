//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        int row = 0, col = m - 1;
        int count = 0, maxCount = Integer.MIN_VALUE, maxRow = -1;
        while (row < n && col >= 0) {
            if (arr[row][col] == 1) {
                col--;
                count++;
            } else {
                //count = m - 1 - col;
                if (count > maxCount) {
                    maxRow = row;
                    maxCount = count;
                }
                row++;
            }
        }
        if (count == 0) {
            return -1;
        } else if (col < 0) {
            return row;    
        }
        
        return maxRow;
    }
}