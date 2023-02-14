package BasicJava;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

class solution {
    String answer = "";
    Stack<Character> st = new Stack<>();
    int op2;
    int op1;
    //////bracket valo delete so 

    //////////first
    public String answer_of_que(String que) {
        for (int i = 0; i < que.length(); i++) {

            if (que.charAt(i) == ')' || que.charAt(i) == ']' || que.charAt(i) == '}') {
                while (!st.empty() && !(st.peek() == '(' || st.peek() == '{' || st.peek() == '[')) {
                    answer = answer + st.peek();
                    st.pop();
                }
                st.pop();
            } else if (que.charAt(i) == '(' || que.charAt(i) == '[' || que.charAt(i) == '{') {
                st.push(que.charAt(i));
            } else if (que.charAt(i) == '+' || que.charAt(i) == '-' || que.charAt(i) == '*' || que.charAt(i) == '/') {

                while ((!st.empty()) && (st.peek() == '*' || st.peek() == '/')) {
                    answer = answer + st.peek();
                    st.pop();
                }

                st.push(que.charAt(i));
            } else {
                answer = answer + que.charAt(i);
            }
        }


        while (!st.empty()) {
            answer = answer + st.peek();
            st.pop();
        }
        return answer;

    }

    //////////second

    private int function(int op1, int op2, char opt) {
        switch (opt) {
            case '+' -> {
                return op1 + op2;
            }
            case '-' -> {
                return op1 - op2;
            }
            case '*' -> {
                return op1 * op2;
            }
            case '/' -> {
                return op1 / op2;
            }
            default -> {
                System.out.println("some error");
                return 0;
            }
        }

    }

    public int answer_of_equation(String que) {

        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < que.length(); i++) {
            if (que.charAt(i) == '+' || que.charAt(i) == '-' || que.charAt(i) == '*' || que.charAt(i) == '/') {

                    op2 = s.peek();
                    s.pop();
                    op1 = s.peek();
                    s.pop();

                s.push(function(op1, op2, que.charAt(i)));
            } else {
                int op = Character.getNumericValue(que.charAt(i));
                s.push(op);
            }
        }

        return s.peek();
    }

    int peekIndexOfMountain(int [] mountainArr)
    {
        int s = 0;
        int e = mountainArr.length-1;
        int mid;
        while(s<=e) // s = e = mid
        {
            mid = s + (e-s)/2;
            if(mountainArr[mid]>mountainArr[mid+1] && mountainArr[mid]>mountainArr[mid-1])
            {
                return mid;
            }
            if (mountainArr[mid]>mountainArr[mid+1])
            {
                // we in dec order
                e = mid+1;// bcoz e may answer
            }
            else
            {
                // we in asc order
                s = mid+1;
            }
        }
        return -1;
    }

    public int findPivot(int[] arr) {
        int s = 0;
        int e = arr.length-1;
        int mid ;
        while(s<e)
        {
            mid= s + (e-s)/2;
            if (arr[s]>arr[mid])
            {
                e = mid-1;
            }
            if (arr[s]<arr[mid])
            {
                s = mid ;
            }
        }
        return s;
    }
}
    public class A1 {
        public static void main(String[] args) {

            String que1 = "{(A+B)*C-D}";
            String que = "23*54*+9-"; //23*976+-+


            solution so = new solution();

            System.out.println(so.answer_of_que(que1));
            System.out.println(so.answer_of_equation(que));
            //binary search//            int[] array = {1,2,3,5,4,2};
//            int ans = so.peekIndexOfMountain(array);
            int [] array1 = {4,5,6,7,0,1,2};
            int ans1 = so.findPivot(array1);
            Scanner s = new Scanner(System.in);
            //laout for hashmap or graph .
            Node [] array = new Node[3];

            for (int i = 0; i < 3; i++) {
                System.out.print("Enter value of node:");
                int num = s.nextInt();
                array[i] = new Node(num);
            }
            System.out.println();
            for (int i = 0; i < 3; i++) {
                System.out.print(array[i].data);
            }
            System.out.println();
            //for java in build
            ArrayList<LinkedList<Integer>> list = new ArrayList<>();
            list.add(new LinkedList<>());
            list.add(new LinkedList<>());
            list.add(new LinkedList<>());

            list.get(0).add(1);
            list.get(0).add(2);
            list.get(0).add(3);
            list.get(1).add(2);
            list.get(1).add(3);
            list.get(1).add(4);
            list.get(2).add(3);
            list.get(2).add(4);
            list.get(2).add(5);
            list.get(2).add(10);

            for (int i = 0; i < 3; i++) {
                System.out.println(list.get(i));
            }
            System.out.println(list.get(0).get(0));
            boolean [] bool = new boolean[1];
            System.out.println(bool[0]);
        }
    }
    class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

