package Collage.ADA;
public class Practical_08 {
    void findPrefix(String pattern, int m, int prefArray[]) {
        int length = 0;
        prefArray[0] = 0;

        for(int i = 1; i<m; i++) {
            if(pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                prefArray[i] = length;
            }else {
                if(length != 0) {
                    length = prefArray[length - 1];
                    i--;
                }else
                    prefArray[i] = 0;
            }
        }
    }

    void kmpPattSearch(String mainString, String pattern, int [] locArray, int loc) {
        int n, m, i = 0, j = 0;
        n = mainString.length();
        m = pattern.length();
        int prefixArray[]= new int [m];
        findPrefix(pattern, m, prefixArray);
        loc = 0;

        while(i < n) {
            if(mainString.charAt(i) == pattern.charAt(j)) {
                i++; j++;
            }

            if(j == m) {
                locArray[loc] = i-j;
                loc++;
                j = prefixArray[j-1];
            }else if(i < n && pattern.charAt(j) != mainString.charAt(i)) {
                if(j != 0)
                    j = prefixArray[j-1];
                else
                    i++;
            }
        }
    }
    static void timeTakeaInsertionSort(String str,String patt,int [] locationArray,int index){

        Practical_08 obj = new Practical_08();
        long start = System.nanoTime();
        obj.kmpPattSearch(str, patt, locationArray, index);
        long end = System.nanoTime();
        long execution = end - start;
        System.out.println("Execution time of insertionSort: " + execution + " nanoseconds");
    }
    public static void main(String[] args) {
        String str = "AAAABAAAAABBBAAAAB";
        String patt = "AAAB";
        int locationArray[] = new int[str.length()+1];
        int index=0;
        timeTakeaInsertionSort(str, patt, locationArray, index);
        int i=0;
        while(locationArray[i]!=0){
            System.out.println("Pattern found at index " + locationArray[i]);
            i++;
        }
    }
}
