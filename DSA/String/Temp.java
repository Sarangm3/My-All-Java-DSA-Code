package DSA.String;

public class Temp {
    static String removeChar(String str,int index)
    {
        if (index==-1)
        {
            return "";
        }
        if (str.charAt(index)=='a'){
           return removeChar(str,index-1);
        }
        else
        {
            return removeChar(str,index-1)+str.charAt(index);
        }
    }
    static String removeWard(String str,String ans,String word)
    {
        if (ans=="")
        {
            return "";
        }
        if (ans.startsWith(word))
        {
            return removeWard(str,ans.substring(word.length()),word);
        }
        else
        {
            return ans.charAt(0)+ removeWard(str,ans.substring(1),word);
        }
    }

    public static void main(String[] args) {
        String str = "dacfadf";
        String asn = removeChar(str,str.length()-1);
        System.out.println(asn);
        String name = "sarang apple avadiya";
        System.out.println(name.startsWith("sarang"));
        System.out.println(name.substring(2));
        System.out.println(removeWard(name,name,"apple"));

    }
}
