package Collage.ADA;

public class Practical_07 {
//    static void brutForce(String pattern,String txt){
//        for (int i = 0; i <=txt.length()-pattern.length(); i++) {
//            if (pattern.charAt(0) == txt.charAt(i)) {
//                if (check(pattern, txt, i)) {
//                    System.out.println("Pattern is found at position: " + (i));
//                }
//            }
//        }
//    }
//    private static boolean check(String pattern, String txt, int i) {
//        for (int j = 1; j < pattern.length(); j++) {
//            if(txt.charAt(i+j)!=pattern.charAt(j)){
//                return false;
//            }
//        }
//        return true;
//    }

    public final static int d = 10;
    static void rabinKarpAlgorithm(String pat, String txt, int q)
    {
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int h = 1;


        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;

        for (i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        for (i = 0; i <= N - M; i++) {

            if (p == t) {
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                }
                if (j == M)
                    System.out.println(
                            "Pattern found at index " + i);
            }

            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h)
                        + txt.charAt(i + M))
                        % q;

                if (t < 0)
                    t = (t + q);
            }
        }
    }

    public static void main(String[] args) {

        String txt = "ABAEFGCDD";
        String pattern = "CDD";
        int q = 13;
        rabinKarpAlgorithm(pattern, txt, q);
//        brutForce(pattern,txt);
    }
}