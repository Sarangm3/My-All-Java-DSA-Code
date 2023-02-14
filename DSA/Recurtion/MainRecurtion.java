package DSA.Recurtion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class  Solution {
    public int name;
    //////////////RECURTION///////////////////////////////////////////////////////////////////////////////////////
    public void subSet(List<String> list, String up, String p) { //give hime list fuction add list and then return list
        if (up.length() == 0) {
            list.add(p);
            return;
        }
        subSet(list, up.substring(1), p + up.charAt(0));
        subSet(list, up.substring(1), p);
    }
    //or
    List<String>subSet4(String up,String p){
        if (up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> l = new ArrayList<>();
        List<String> r = new ArrayList<>();
        l = subSet4( up.substring(1), p + up.charAt(0));
        r = subSet4( up.substring(1), p);
        l.addAll(r);
        return l;
    }
    public ArrayList<ArrayList<Integer>> subSetIteration(int[] array) {//DP
        Arrays.sort(array);
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int i = 0; i < array.length; i++) {
            int n = outer.size();
            if (i != 0 && array[i - 1] == array[i]) {
                for (int j = n - 2; j < n; j++) {
                    ArrayList<Integer> inner = new ArrayList<>(outer.get(j));
                    inner.add(array[i]);
                    outer.add(inner);
                }// duplicate
            } else {
                for (int j = 0; j < n; j++) {
                    ArrayList<Integer> inner = new ArrayList<>(outer.get(j));
                    inner.add(array[i]);
                    outer.add(inner);
                }
            }
        }
        return outer;
    }
    //////////
    public ArrayList<String> permutations2(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i);
            // p = f + ch + s //don't use this
            ans.addAll(permutations2(f + ch + s, up.substring(1)));//f(p,up.substr(1))
            //after return function p change always in function call
            // if you want change in p then we do backtracking
            //for avoid backtracking some scenario use give direct attribute
            //that why after function complete p come in original p
        }
        return ans;
    }
    public String swap(int ind, int i, String ans) {
        StringBuilder sb = new StringBuilder(ans);
        sb.setCharAt(i, ans.charAt(ind));
        sb.setCharAt(ind, ans.charAt(i));
        return sb.toString();
    }
    public void permutations(int ind, String ans) {
        if (ind == ans.length()) {
            System.out.println(ans);
            return;
        }

        for (int i = ind; i < ans.length(); i++) {
//            ans = swap(ind,i,ans);
            permutations(ind + 1, swap(ind, i, ans)); // f(ind+1,ans)
            //if you return like this you want to backtarking that why
            //if posible to give direct atribut.
        }
    }
    List<String> letterCombinations(String up, String p) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<String>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        String letter = letter(up.charAt(0));
        for (int i = 0; i < letter.length(); i++) {
            ans.addAll(letterCombinations(up.substring(1), p + letter.charAt(i)));
        }
        return ans;
    }
    String letter(char a) {
        switch (a) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return "";
        }
    }
    List<String> dais(String p,int up){
        if (up==0)
        {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;

        }
        List<String> ans = new ArrayList<>();

        for (int i=1;i<=up;i++)
        {
            ans.addAll(dais(p + i, up-i));
        }
        return ans;
    }

    ////////////////////////BACKTRACING/////////////////////////////////////////////////////////////////////
    //MAZE1
//    int mazeProblems(int m,int n) {
//        if (m==1||n==1)
//        {
//            return 1;
//        }
//
//        int l=0, r=0;
//        l = mazeProblems(m-1,n);
//        r = mazeProblems(m,n-1);
//
//        return l+r;
//    }
    //MAZE2
    List<String> mazeProblems(String p,int r,int c)
    {
        if (c==1 && r==1)
        {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> left = new ArrayList<>();
        List<String> right = new ArrayList<>();
        if (r>1) {
            left = mazeProblems(p + 'D', r - 1, c);
        }
        if (c>1) {
            right = mazeProblems(p + 'R', r, c - 1);
        }
        left.addAll(right);

        return left;
    }
    List<String> mazeProblemsinDigonal(String p,int r,int c)
    {
        if (c==1 && r==1)
        {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> left = new ArrayList<>();
        List<String> right = new ArrayList<>();
        List<String> digonal = new ArrayList<>();
        if (r>1) {
            left = mazeProblemsinDigonal(p + 'D', r - 1, c);
        }
        if (c>1) {
            right = mazeProblemsinDigonal(p + 'R', r, c - 1);
        }
        if (r>1 && c>1)
        {
            digonal = mazeProblemsinDigonal(p+ "dig" , r-1,c-1);
        }
        left.addAll(digonal);
        left.addAll(right);

        return left;
    }
    List<String> mazeProblemsinDigonalAndRiver(int [][] table,String p ,int r,int c )
    //sorry for some problem you can do like (0,0) t0 (2,2)
    //but some simplicity at start problem we use (3,3) to (1,1)
    //some problem occur in your mind
    {
        if ( r==1 && c == 1)
        {
            List<String> list  = new ArrayList<>();
            list.add(p);
            return list;
        }
        int newrow = (r-1)%2;
        int newcol = (c-1)%2;
        if (table[newrow][newcol]==0){
            return new ArrayList<>();
        }
        List<String> right = new ArrayList<>();
        List<String> left = new ArrayList<>();
        List<String> digonal = new ArrayList<>();
        if (r>2){
            right = mazeProblemsinDigonalAndRiver(table, p+ 'V',r-1,c);
        }
        if (c>2){
            left = mazeProblemsinDigonalAndRiver(table,p+'H',r,c-1);
        }
        if (c>1 && r>1){
            digonal = mazeProblemsinDigonalAndRiver(table,p+'D',r-1,c-1);
        }
        left.addAll(right);
        left.addAll(digonal);

        return left;
    }

//    int [][] newtable(int [][] table,int r,int c){ //you can make new 2-d array for all recursion
    //for avoid backtracking but it's required more space so we use backtracking
//        int [][]n
//        for (int i=0 ;i<table.length;i++)
//        {
//            for (int j=0 ; j<table[i].length;i++)
//            {
//
//            }
//        }
//    }

    List<String> mazeProblemInAllDirection(int [][] table,String p ,int r,int c,int [][]path,int step)
    //sorry for some problem we can do like (0,0) t0 (2,2)

    {
        if ( r==2 && c == 2)
        {
            path[r][c]=step;
            System.out.println(Arrays.toString(path[0]));
            System.out.println(Arrays.toString(path[1]));
            System.out.println(Arrays.toString(path[2]));
            System.out.println(p);
            List<String> list  = new ArrayList<>();
            list.add(p);
            return list;
        }

        if (table[r][c] == 0){
            return new ArrayList<>();
        }
        List<String> right = new ArrayList<>();
        List<String> left = new ArrayList<>();
        List<String> up = new ArrayList<>();
        List<String> down = new ArrayList<>();
        table[r][c]=0;
        path[r][c]=step;
        if (c<2){
            right = mazeProblemInAllDirection(table, p+ 'R',r,c+1,path,step+1);
        }
        if (r<2){
            down = mazeProblemInAllDirection(table,p+'D',r+1,c,path,step+1);
        }
        if (r>0){
            up = mazeProblemInAllDirection(table,p+'U',r-1,c,path,step+1);
        }
        if (c>0){
            left = mazeProblemInAllDirection(table,p+'L',r,c-1,path,step+1);
        }
        table[r][c]=1;
        path[r][c]=0;
        left.addAll(right);
        left.addAll(up);
        left.addAll(down);

        return left;
    }
//////////////////////////////////////////////////////////////////////////////////
    boolean chack_Q(List<String> table,int r,int c)
    {

        int newr = r;
        int newc = c;
        while (newr>=0)
        {
            char ch = table.get(newr).charAt(newc);
            if (ch == 'Q')
            {
                return false;
            }

            newr--;
        }
        newr=r;
        while (newr>=0 && newc>=0)
        {
            char ch = table.get(newr).charAt(newc);
            if (ch=='Q')
            {
                return false;
            }
            newr--;
            newc--;
        }
        newr = r;
        newc = c;
        while (newr>=0 && newc < table.size() )
        {
            char ch = table.get(newr).charAt(newc);
            if (ch== 'Q')
            {
                return false;
            }
            newr--;
            newc++;
        }
        return true;
    }
    List<List<String>> N_Queens (int n){
        List<String> N_table = new ArrayList<>();
        StringBuilder dot = new StringBuilder();
        for (int i = 0; i < n; i++) {
            dot.append('.');
        }
        for (int i = 0; i < n; i++) {
            N_table.add(dot.toString());
        }
        List<List<String>> ans = new ArrayList<>();
        helper(ans,N_table,n,0);
        return ans;
    }
    void helper(List<List<String>> ans,List<String> table,int n,int r)
    {
        if (r==n)
        {
            ans.add(new ArrayList<>(table));////////not allow ans.add(table)/////// i don't no
            return ;
        }
        for (int i=0 ;i< n;i++) {

            if (chack_Q(table, r, i)) {
                table.set(r, table.get(r).substring(0, i) + 'Q' + table.get(r).substring(i + 1));
                helper(ans,table, n, r + 1);
                table.set(r, table.get(r).substring(0, i) + '.' + table.get(r).substring(i + 1));
            }

        }
    }
    void print(boolean [] array)
    {
        for (boolean element :
                array) {
            if (element){
                System.out.print("K ");
            }
            else
            {
                System.out.print("X ");
            }
        }
        System.out.println();
    }
    int count=0;
//////////////////////////////////////////////////////////////////////////////////
    void N_knight(boolean [][] board,int row,int col,int knights)
    {
        if (knights == 0)
        {
            print(board[0]);
            print(board[1]);
            print(board[2]);
            print(board[3]);
            System.out.println();
            count=count+1;
            System.out.println(count);
            return;
        }
        if (col==board.length && row == board.length-1)
        {
            return;
        }
        if (col== board.length)
        {
            N_knight(board,row+1,0,knights);
            return;
        }
        if (isSafe(board,row,col))
        {
            board[row][col] = true;
            N_knight(board,row,col+1,knights-1);
            board[row][col] = false;
        }
        N_knight(board,row,col+1,knights);
    }
    private boolean isSafe(boolean [][] board, int row, int col)
    {
        if (isvaild(board, row-2, col-1))
        {
            if (board[row-2][col-1])
            {
                return false;
            }
        }
        if (isvaild(board, row-2, col+1))
        {
            if (board[row-2][col+1])
            {
                return false;
            }
        }
        if (isvaild(board, row-1, col-2))
        {
            if (board[row-1][col-2])
            {
                return false;
            }
        }
        if (isvaild(board, row-1, col+2))
        {
            if (board[row-1][col+2])
            {
                return false;
            }
        }
        return true;
    }
    private boolean isvaild(boolean [][] board,int row,int col)
    {
        return (row>=0&&row<board.length) && (col>=0&&col< board.length);
    }
     boolean isSafem(int [][] grid,int row,int col,int i){

        int n = (int) Math.sqrt(grid.length);
        for (int num : grid[row] )
        {
            if (num==i)
            {
                return false;
            }
        }
        for (int j = 0; j < grid.length; j++) {
            if (grid[j][col]==i)
            {
                return false;
            }
        }
        row = row - row % n;
        col = col - col % n;
        for (int j =  0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                if (grid[row+j][col+k]==i)
                {
                    return false;
                }
            }
        }

        return true;
    }
/////////////////////////////////////////////////////////////////////////////
    void print(int[][] grid)
    {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
    }

    void solveSudoku(int [][] grid,int row,int col)
    {

        if (row== grid.length)
        {
            print(grid);
            return;
        }
        if (col== grid.length) {
            solveSudoku(grid,row+1,0);
            return;
        }

        if (grid[row][col]!=0) {
            solveSudoku(grid, row, col+1);
        }
        else
        {
            for (int i = 1; i <= grid.length; i++) {
                if (isSafem(grid,row,col,i)) {
                    grid[row][col]=i;
                    solveSudoku(grid, row, col+1);
                    grid[row][col]=0;
                }
            }
        }

    }
     boolean solve(int[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true;

        // this is how we are replacing the r,c from arguments
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            // if you found some empty element in row, then break
            if (emptyLeft == false) {
                break;
            }
        }

        if (emptyLeft == true) {
            return true;
            // soduko is solved
        }

        // backtrack
        for (int number = 1; number <= 9; number++) {
            if (isSafem(board,row,col,number)) {
                board[row][col] = number;
                if (solve(board)) {
                    // found the answer
                    return true;
                } else {
                    // backtrack
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }
}
public class MainRecurtion {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();


        Solution s = new Solution();
        String name= "ABC";
        s.subSet(list,name,"");
        System.out.println(list);
        list = s.subSet4(name,"");
        System.out.println(list);

        int [] array = {1,2,2,2};
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans = s.subSetIteration(array);
        System.out.println(ans);

        s.permutations(0,name);
        ArrayList<String> ans2 = s.permutations2("",name);
        System.out.println(ans2);

        List<String> ans3 = new ArrayList<String>();
        ans3 = s.letterCombinations("23","");
        System.out.println(ans3);

        list = s.dais("",4);
        System.out.println(list);

        list = s.mazeProblems("",3,3);
        System.out.println(list);
        list = s.mazeProblemsinDigonal("",3,3);
        System.out.println(list);

        int [][]table = new int[3][3];
        int [][] path = new int[3][3];
        for (int[] row: table) {
            Arrays.fill(row, 1);
        }
        for (int[] row: path) {
            Arrays.fill(row, 0);
        }
//        list = s.mazeProblemsinDigonalAndRiver(table,"",table.length,table[0].length);
//        System.out.println(list);
        list = s.mazeProblemInAllDirection(table,"",0,0,path,1);
        System.out.println(list);
        List<String> N_table = new ArrayList<>();

        List<List<String>> ans5 = new ArrayList<>();
        ans5 = s.N_Queens(4);
        System.out.println(ans5);

        boolean [][] board = new boolean[4][4];
        for (boolean[] row: board) {
            Arrays.fill(row, false);
        }
        s.N_knight(board,0,0,4);



        int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };


        s.solveSudoku(grid,0,0);
        int [][]newgrid= { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
        if(s.solve(newgrid));
        System.out.println();
            s.print(newgrid);
        }
    }




