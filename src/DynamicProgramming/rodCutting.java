package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dmanzelmann on 4/7/2015.
 */
// length: 1 2 3 4   5   6   7   8   9   10
// price : 1 5 8 9   10  17  17  20  24  30
// n = rod of length n

public class rodCutting {
    int[] revenue;
    int[] optimalFirstCutLength;

    public rodCutting(int[] prices, int rodLength) {
        int n = prices.length;
        revenue = new int[n];
        optimalFirstCutLength = new int[n];

        revenue[0] = 0;

        for (int j = 1; j < n; j++) {
            int q = -1;

            for (int i = 1; i <= j; i++) {
                if (q < prices[i] + revenue[j - i]) 
                {
                    q = prices[i] + revenue[j - i];
                    optimalFirstCutLength[j] = i;
                }
            }

            revenue[j] = q;
        }
    }

    public static void main(String[] args) {
        int[] prices = new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20};
        
        rodCutting test = new rodCutting(prices, 8);
        for(int i =0; i< test.revenue.length; i++){
        	System.out.print(i + " ");
        }System.out.println();
        
        for (Integer i : prices)
            System.out.print(i + " ");
        
        System.out.println();
        for (Integer i : test.revenue)
            System.out.print(i + " ");
        System.out.println();

        for (Integer i : test.optimalFirstCutLength)
            System.out.print(i + " ");
        
        
    }
}