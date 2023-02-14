package OOPs.Collage.Practical8;

import java.io.*;
import java.util.*;
class Practical_06 {
    public static void main(String[] args) {
        if(args.length==1){
            String fileName = args[0];
            TreeSet<String> set = new TreeSet<>();
            File file = new File(fileName);
            try {
                Scanner s = new Scanner(file);
                while (s.hasNext()){
                    set.add(s.next());
                }
                System.out.println(set);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Please, Pass the File Name as Command Line Argument");
        }
    }
}
