import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashSet;
import java.util.StringTokenizer;

public class Validator {

    public static void main(String[] args) {
	    FastReader fr = new FastReader();
        HashSet<Pair> set = new HashSet<>();
        String outerLine = fr.nextLine();
        String[] outerLineArr = outerLine.split(" ");
        if (outerLineArr.length == 2){
            int n = Integer.parseInt(outerLineArr[0]);
            int m = Integer.parseInt(outerLineArr[1]);
            if (n <= 100000 && n >= 1 && m <= 100000 && m >= 1){
                for(int y = 0; y < m; y++){
                    String innerLine = fr.nextLine();
                    String[] innerLineArr = innerLine.split(" ");
                    if (innerLineArr.length == 2){
                        int i = Integer.parseInt(innerLineArr[0]);
                        int j = Integer.parseInt(innerLineArr[1]);
                        Pair temp = new Pair(i,j);
                        if(i >= 1 && j <= n && i != j){
                            if (!set.contains(temp)){
                                set.add(temp);

                            }
                            else{
                                System.exit(0);
                                //return 0;
                            }

                        }
                        else{
                            System.exit(1);
                            //return 1;
                        }
                    }
                    else{
                        System.exit(2);
                        //return 2;
                    }
                }
            }
            else{
                System.exit(3);
                //return 3;
            }

        }
        else{
            System.exit(4);
            //return 4;
        }
    System.exit(42);
    //return 42;
    }

    public static class Pair{
        int i;
        int j;

        public Pair (int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    //source: https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
}