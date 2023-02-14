package DSA.binary_and_binarySearch;


import java.util.ArrayList;

public class b1 {
    //power set or subset solve useing bit

    static ArrayList<Integer> powerset(int [] q)//bruet forst

        {
        ArrayList<Integer> ans = new ArrayList();

        int n= 3;
        int sum=0;
        for (int i=0; i< 1<<n ;i++)
        {
            sum=0;
            for (int j=0;j<n;j++)
            {
                if ((i & (1<<j))>0)
                {
                    sum=sum+q[j];
                }
            }
            ans.add(i,sum);
        }
        return ans;
    }

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();
        int [] que={3,1,2};
        numbers.addAll(powerset(que));

        for(int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
    }
}
