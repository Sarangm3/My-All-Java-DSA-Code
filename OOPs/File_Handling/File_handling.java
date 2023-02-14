package OOPs.File_Handling;

import java.io.*;
import java.util.*;

public class File_handling {
    public static void main(String[] args){

        //create a file
        File newfile = new File("123.txt");//just pointer to point to file
        try{
            newfile.createNewFile();
        }
        catch(Exception e){
            System.out.println(e);
        }
        try{
            FileWriter filew = new FileWriter("123.txt");
            filew.write("hello world my exam start in few hour \n aslkflkasdj \naskdjflajflkdsj");
            filew.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        try{
            Scanner sc = new Scanner(newfile);
            while (sc.hasNextLine())
            {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        if(newfile.delete())
        {
            System.out.println("file was deleted");
        }
        else{
            System.out.println("error");
        }

//        File newfile = new File("test.txt");
//
//        try {
//            newfile.createNewFile();//might be file not create.
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        //write in file

//        try {
//            FileWriter fileWriter = new FileWriter("test.txt");
//            fileWriter.write("This is first time in java some file written by me.\njava file very easy and simple");
//            fileWriter.close(); //don't forget to close file
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        //read file

//        File newFile = new File("test.txt");
//        try {
//            Scanner sc = new Scanner(newFile);
//            while(sc.hasNextLine())
//            {
//                System.out.println(sc.nextLine());
//            }
//            sc.close(); //close scanner stream
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }

        //delete file
//        File myFile = new File("test.txt");
//        if(myFile.delete())
//        {
//            System.out.println("File is deleted and name is "+ myFile.getName());
//        }
//        else {
//            System.out.println("error");
//        }

    }
}
