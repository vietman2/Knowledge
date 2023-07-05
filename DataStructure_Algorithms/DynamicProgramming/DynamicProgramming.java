package Knowledge.DataStructure_Algorithms.DynamicProgramming;

public class DynamicProgramming {
    // 1: fibonacci
    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int[] fib = new int[n + 1];

        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }

        return fib[n];
    }
    private static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // 2: matrix chain multiplication
    private static int matrixChainMultiplication(int[] p, int n) {
        int[][] m = new int[n][n];

        for (int i = 1; i < n; i++) {
            m[i][i] = 0;
        }

        for (int l = 2; l < n; l++) {
            for (int i = 1; i < n - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k+1][j] + p[i-1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                    }
                }
            }
        }

        return m[1][n-1];
    }
    private static int matrixChainMultiplicationRecursive(int[] p, int i, int j) {
        if (i == j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int count = matrixChainMultiplicationRecursive(p, i, k) +
                    matrixChainMultiplicationRecursive(p, k+1, j) +
                    p[i-1] * p[k] * p[j];

            if (count < min) {
                min = count;
            }
        }

        return min;
    }
    
    // 3: longest common subsequence
    private static int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] l = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            l[i][0] = 0;
        }

        for (int j = 0; j <= n; j++) {
            l[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j= 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    l[i][j] = l[i-1][j-1] + 1;
                } else {
                    l[i][j] = Math.max(l[i-1][j], l[i][j-1]);
                }
            }
        }

        return l[m][n];
    }
    private static int longestCommonSubsequenceRecursive(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (s1.charAt(m-1) == s2.charAt(n-1)) {
            return 1 + longestCommonSubsequenceRecursive(s1, s2, m-1, n-1);
        } else {
            return Math.max(longestCommonSubsequenceRecursive(s1, s2, m-1, n),
                    longestCommonSubsequenceRecursive(s1, s2, m, n-1));
        }
    }

    public static void main(String[] args) {
        // compare performance of fibonacci and fibonacciRecursive

        int n = 40;
        long startTime = System.nanoTime();
        int result = fibonacci(n);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("fibonacci(" + n + ") = " + result);
        System.out.println("fibonacci(" + n + ") took " + duration + " nanoseconds");

        startTime = System.nanoTime();
        int resultRecursive = fibonacciRecursive(n);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("fibonacciRecursive(" + n + ") = " + resultRecursive);
        System.out.println("fibonacciRecursive(" + n + ") took " + duration + " nanoseconds");

        // compare performance of matrixChainMultiplication and matrixChainMultiplicationRecursive

        int[] p = {10, 100, 5, 50, 1};
        int size = p.length;
        startTime = System.nanoTime();
        int resultMatrixChainMultiplication = matrixChainMultiplication(p, size);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("matrixChainMultiplication(" + size + ") = " + resultMatrixChainMultiplication);
        System.out.println("matrixChainMultiplication(" + size + ") took " + duration + " nanoseconds");

        startTime = System.nanoTime();
        int resultMatrixChainMultiplicationRecursive = matrixChainMultiplicationRecursive(p, 1, size - 1);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("matrixChainMultiplicationRecursive(" + size + ") = " + resultMatrixChainMultiplicationRecursive);
        System.out.println("matrixChainMultiplicationRecursive(" + size + ") took " + duration + " nanoseconds");

        // compare performance of longestCommonSubsequence and longestCommonSubsequenceRecursive

        String s1 = "AGGTABQBEWAHQAWESTY";
        String s2 = "GXTXAYB";
        startTime = System.nanoTime();
        int resultLongestCommonSubsequence = longestCommonSubsequence(s1, s2);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("longestCommonSubsequence(" + s1 + ", " + s2 + ") = " + resultLongestCommonSubsequence);
        System.out.println("longestCommonSubsequence(" + s1 + ", " + s2 + ") took " + duration + " nanoseconds");

        startTime = System.nanoTime();
        int resultLongestCommonSubsequenceRecursive = longestCommonSubsequenceRecursive(s1, s2, s1.length(), s2.length());
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("longestCommonSubsequenceRecursive(" + s1 + ", " + s2 + ") = " + resultLongestCommonSubsequenceRecursive);
        System.out.println("longestCommonSubsequenceRecursive(" + s1 + ", " + s2 + ") took " + duration + " nanoseconds");

    }





}
