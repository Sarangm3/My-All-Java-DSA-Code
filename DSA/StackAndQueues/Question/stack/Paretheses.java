package DSA.StackAndQueues.Question.stack;

import java.util.ArrayList;
import java.util.Stack;

class Solution1{
    public boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) { //dont't use s.charAt becouse take O(n)
            //time so use charArray but take space O(n)
            //simple if you wont juset travel use foreach loop
            //char a : s.toCharArray()
            if (s.charAt(i)=='['||s.charAt(i)=='{'||s.charAt(i)=='(')
            {
                stack.push(s.charAt(i));
            }
            else {
                if (!stack.isEmpty() && helper(stack.peek()) == s.charAt(i)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if(stack.empty())
        {
            return true;
        }
        return  false;
    }
    private char helper(char peek) {
        if(peek=='[') return ']';
        if (peek=='{') return '}';
        if(peek=='(') return ')';
        else return '.';
    }
    public void postPix(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {//dont't use s.charAt becouse take O(n)
            //time so use charArray but take space O(n)
            //simple if you wont juset travel use foreach loop
            //char a : s.toCharArray()
            if(s.charAt(i)=='(')
            {
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i)==')')
            {
                while(!stack.isEmpty()&&stack.peek()!='(')
                {
                    System.out.print(stack.pop());
                }
                stack.pop();
            }
            else if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='*'||s.charAt(i)=='/') {
                while(!stack.isEmpty() && Prec(s.charAt(i)) <= Prec(stack.peek()))
                {
                    System.out.print(stack.pop());
                }
                stack.push(s.charAt(i));
            }
            else {
                System.out.print(s.charAt(i));
            }
        }
        while(!stack.isEmpty())
        {
            System.out.print(stack.pop());
        }
    }
    int Prec(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
    public int postFixAnswer(String s)
    {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {//dont't use s.charAt becouse take O(n)
            //time so use charArray but take space O(n)
            //simple if you wont juset travel use foreach loop
            //char a : s.toCharArray()
            if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='*'||s.charAt(i)=='/')
            {
                int opt2 = stack.pop();
                int opt1 = stack.pop();
                stack.push(help(s.charAt(i),opt1,opt2));
            }
            else{
                stack.push(Character.getNumericValue(s.charAt(i)));
            }
        }
        return stack.pop();
    }
    private int help(char opt,int n1,int n2)
    {
        if(opt=='+')    return n1+n2;
        if(opt=='-')    return n1-n2;
        if(opt=='*')    return n1*n2;
        if(opt=='/')    return n1/n2;

        return -1;
    }
    public int evalRPN(ArrayList<String> A) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0 ;i<A.size();i++)
        {
            if(A.get(i)=="+"||A.get(i)=="*"||A.get(i)=="/"||A.get(i)=="-")
            {
                int opt2 = stack.pop();
                int opt1 = stack.pop();
                stack.push(build(A.get(i),opt1,opt2));
            }
            else
            {
                stack.push(Integer.valueOf(A.get(i)));
            }
        }
        return stack.pop();
    }
    private int build(String str,int a,int b)
    {
        if(str.charAt(0)=='+') return a+b;
        if(str.charAt(0)=='*') return a*b;
        if(str.charAt(0)=='/') return a/b;
        if(str.charAt(0)=='-') return a-b;
        return -1;
    }
}

public class Paretheses {

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.println(s.isValid("[()()}"));
        s.postPix("((2+7)*3-2)/5");
        System.out.println();
        System.out.println(s.postFixAnswer("27+3*2-5/"));
        ArrayList<String> que1 = new ArrayList<>();
        que1.add("2");
        que1.add("2");
        que1.add("/");
        System.out.println(s.evalRPN(que1));
    }
}
