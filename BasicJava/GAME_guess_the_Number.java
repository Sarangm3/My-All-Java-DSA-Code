package BasicJava;

import java.util.Random;
import java.util.Scanner;

class Guess_number
{
    int number;
    int noOfguesses;
    public Guess_number()
    {
        Random num = new Random();
        number = num.nextInt(101);
    }

    public int getNoOfguesses()
    {
        return noOfguesses;
    }

}
public class GAME_guess_the_Number {
    static int isCorrectNumber(int num1,int  num2)
    {
        if (num1==num2)
        {
            return 1;
        }
        else if (num1>num2)
        {
            System.out.println("ENTER LOWER NUMBER");
        }
        else if (num1<num2)
        {
            System.out.println("ENTER HIGHER NUMBER");
        }
        return 0;
    }
    public static void main(String[] args) {

        int guesses_number;
        Scanner Gnumber= new Scanner(System.in);

        System.out.print("guess number:");
        guesses_number =Gnumber.nextInt();

        // for class
        Guess_number num = new Guess_number();
        num.noOfguesses=1;
        while (isCorrectNumber(guesses_number,num.number)!=1)
        {
            System.out.print("guess number:");
            guesses_number =Gnumber.nextInt();
            num.noOfguesses++;
        }
        System.out.println("\nyou take Attempt "+num.getNoOfguesses());
    }
}
