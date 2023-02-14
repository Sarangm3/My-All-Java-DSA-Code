package DSA.String;

class Solution{
    public String reverseOnlyLetters(String s) {

        char [] ch = s.toCharArray();
        int start = 0;
        int end = s.length()-1;
        while(end>start)
        {

            if(!(ch[start]>=65 && ch[start]<=90 || ch[start]>=97 && ch[start]<=122))
            {
                start++;
                continue;
            }
            if(!(ch[end]>=65 && ch[end]<=90 || ch[end]>=97 && ch[end]<=122))
            {
                end--;
                continue;
            }

            swipe(ch,start,end);
            start++;
            end--;
        }
        return String.valueOf(ch);
    }
    private void swipe(char [] s, int a,int b)
    {
        s[a] = (char)(s[a] ^ s[b]);
        s[b] = (char)(s[a] ^ s[b]);
        s[a] = (char)(s[a] ^ s[b]);
    }
    public String reorderSpaces(String text) {
        int spaceCount =0;
        int wordCount  =0;
        int space = 0;
        int extraSpace = 0;
        int i=0;
        while(i<text.length())
        {

            if (text.charAt(i)==' ')
            {
                if(i+1!=text.length() && text.charAt(i+1)!=' ')
                {
                    wordCount++;
                }
                spaceCount++;
            }
            i++;
        }
        if(wordCount==1)
        {
            space = spaceCount ;
            extraSpace = spaceCount;
        }
        else{
            space = spaceCount / (wordCount-1);
            extraSpace = spaceCount % (wordCount-1);
        }
        StringBuilder sb1 = new StringBuilder();
        for (int j = 0; j < space; j++) {
            sb1.append(' ');
        }
        String mystr = sb1.toString();
        String[] arr = text.trim(). split("\\s+");
        StringBuilder ans = new StringBuilder();
        for (int j = 0; j < arr.length; j++) {
            if (j < arr.length-1)
            {
                ans.append(arr[j]+mystr);
            }
            else
            {
                ans.append(arr[j]);
            }
        }
        for (int j = 0; j < extraSpace; j++) {
            ans.append(' ');
        }
        return ans.toString();
    }

}
public class Strings {

    public static void main(String[] args) {

//        String que = "Hello, World.";
//        //you can directly change char of string
//        //so you need convert in to char array
//        //or you can use stringBuilder or string method's
//        System.out.println(convert_camel(que));
//        System.out.println(convert_snake(que));
//        System.out.println(convert_kebab(que));
//        System.out.println(convert_pascal(que));
//        System.out.println(convert_uppercasesnake(que));
        Solution str =  new Solution();
//        str.reverseOnlyLetters("7_28]");
//        str.reorderSpaces(" practice   makes   perfect ");
        String name = str.reorderSpaces("hello   world");
        System.out.println(name);
    }

    static String convert_camel(String que){
        char [] ch = que.toCharArray();
        ch[0] = (char)(ch[0]+32);
        int count=0;
        for (int i = 0; i < que.length(); i++) {
            if (ch[i]>=65 && ch[i]<=90 || ch[i]>=97 && ch[i]<=122 )
            {
                ch[count] = ch[i];
                count++;
            }
        }
        return String.valueOf(ch,0,count);
    }
    static String convert_snake(String que)
    {
        que = que.replace(' ','_');
        que = que.toLowerCase();
        char [] ch = que.toCharArray();
        int count=0;
        for (int i = 0; i < que.length(); i++) {
            if (ch[i]>=65 && ch[i]<=90 || ch[i]>=97 && ch[i]<=122 || ch[i]=='_')
            {
                ch[count] = ch[i];
                count++;
            }
        }
        return String.valueOf(ch,0,count);
    }
    static String convert_kebab(String que)
    {
        que = que.replace(' ','-');
        que = que.toLowerCase();
        char [] ch = que.toCharArray();
        int count=0;
        for (int i = 0; i < que.length(); i++) {
            if (ch[i]>=65 && ch[i]<=90 || ch[i]>=97 && ch[i]<=122 || ch[i]=='-')
            {
                ch[count] = ch[i];
                count++;
            }
        }
        return String.valueOf(ch,0,count);
    }
    private static String convert_pascal(String que) {

        char [] ch = que.toCharArray();
        int count=0;
        for (int i = 0; i < que.length(); i++) {
            if (ch[i]>=65 && ch[i]<=90 || ch[i]>=97 && ch[i]<=122)
            {
                ch[count] = ch[i];
                count++;
            }
        }
        return String.valueOf(ch,0,count);
    }

    private static String convert_uppercasesnake(String que) {

        que = que.replace(' ','_');
        que = que.toUpperCase();
        char [] ch = que.toCharArray();
        int count=0;
        for (int i = 0; i < que.length(); i++) {
            if (ch[i]>=65 && ch[i]<=90 || ch[i]>=97 && ch[i]<=122||ch[i]=='_')
            {
                ch[count] = ch[i];
                count++;
            }
        }
        return String.valueOf(ch,0,count);
    }
}
