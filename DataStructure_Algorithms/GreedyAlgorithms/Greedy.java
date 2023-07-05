package Knowledge.DataStructure_Algorithms.GreedyAlgorithms;

public class Greedy {
    public static void main(String[] args) {
        // 1: activity selection
        int[] s = {1, 3, 0, 5, 8, 5};
        int[] f = {2, 4, 6, 7, 9, 9};

        System.out.println(activitySelection(s, f));

        // 2: knapsack
        int[] v = {60, 100, 120};
        int[] w = {10, 20, 30};
        int W = 50;

        System.out.println(knapsack(v, w, W));

        // 3: coin change
        int[] coins = {1, 5, 10, 25};
        int amount = 30;

        System.out.println(coinChange(coins, amount));
    }

    // 1: activity selection
    private static int activitySelection(int[] s, int[] f) {
        int n = s.length;
        int i = 0;
        int count = 1;

        for (int j = 1; j < n; j++) {
            if (s[j] >= f[i]) {
                count++;
                i = j;
            }
        }

        return count;
    }

    // 2: knapsack
    private static int knapsack(int[] v, int[] w, int W) {
        int n = v.length;
        int[] x = new int[n];
        int weight = 0;
        int profit = 0;

        for (int i = 0; i < n; i++) {
            if (weight + w[i] <= W) {
                x[i] = 1;
                weight += w[i];
                profit += v[i];
            } else {
                x[i] = 0;
            }
        }

        return profit;
    }

    // 3: coin change
    private static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] x = new int[n];
        int sum = 0;

        for (int i = n-1; i >= 0; i--) {
            x[i] = amount / coins[i];
            amount -= x[i] * coins[i];
            sum += x[i];
        }

        return sum;
    }
}
