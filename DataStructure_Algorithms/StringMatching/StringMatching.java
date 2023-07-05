package Knowledge.DataStructure_Algorithms.StringMatching;

public class StringMatching {
    private static int naiveStringMatching(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;

            while (j < m && text.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }

            if (j == m) {
                return i;
            }
        }

        return -1;
    }

    private static int rabinKarp(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int d = 256;
        int q = 101;
        int h = 1;
        int p = 0;
        int t = 0;

        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        for (int i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        for (int i = 0; i <= n - m; i++) {
            if (p == t) {
                int j = 0;

                while (j < m && text.charAt(i + j) == pattern.charAt(j)) {
                    j++;
                }

                if (j == m) {
                    return i;
                }
            }

            if (i < n - m) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;

                if (t < 0) {
                    t += q;
                }
            }
        }

        return -1;
    }

    private static int automataMatching(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[][] dfa = new int[256][m];
        int x = 0;

        dfa[pattern.charAt(0)][0] = 1;

        for (int j = 1; j < m; j++) {
            for (int c = 0; c < 256; c++) {
                dfa[c][j] = dfa[c][x];
            }

            dfa[pattern.charAt(j)][j] = j + 1;
            x = dfa[pattern.charAt(j)][x];
        }

        int i = 0;
        int j = 0;

        for (; i < n && j < m; i++) {
            j = dfa[text.charAt(i)][j];
        }

        if (j == m) {
            return i - m;
        }

        return -1;
    }

    public static void main(String[] args) {
        String text = "AABAACAADAABAAABAA";
        String pattern = "AABA";

        // result and time taken comparison
        long startTime = System.nanoTime();
        int result = naiveStringMatching(text, pattern);
        long endTime = System.nanoTime();
        System.out.println("naiveStringMatching: " + result + ", time taken: " + (endTime - startTime));

        startTime = System.nanoTime();
        result = rabinKarp(text, pattern);
        endTime = System.nanoTime();
        System.out.println("rabinKarp: " + result + ", time taken: " + (endTime - startTime));

        startTime = System.nanoTime();
        result = automataMatching(text, pattern);
        endTime = System.nanoTime();
        System.out.println("automataMatching: " + result + ", time taken: " + (endTime - startTime));
    }



}
