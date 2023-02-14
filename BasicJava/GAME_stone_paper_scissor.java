package BasicJava;

import java.util.Random;
import java.util.Scanner;

public class GAME_stone_paper_scissor {

    public static void main(String[] args) {
        Random s = new Random();
        Scanner sc = new Scanner(System.in);
        int random;
        String player;
        System.out.println("\t\t\t\tWELCOME TO PLAY STONE,PAPER AND SCISSOR");

        System.out.print("Enter stone,paper or scissor:");
        player = sc.nextLine();

        System.out.print("computer choose is:");
        random = s.nextInt(3);
        switch (random) {
            case 0 -> System.out.println("stone");
            case 1 -> System.out.println("paper");
            default -> System.out.println("scissor");
        }
        if (random == 0 && player.equalsIgnoreCase("stone") || random == 1 && player.equalsIgnoreCase("paper") || random == 2 && player.equalsIgnoreCase("scissor"))
        {
            System.out.println("DROW");
        }
        else if (random == 0 && player.equalsIgnoreCase("paper") || random == 1 && player.equalsIgnoreCase("scissor") || random == 2 && player.equalsIgnoreCase("stone"))
        {
            System.out.println("PLAYER IS WINNER");
        }
        else if (random == 0 && player.equalsIgnoreCase("scissor") || random == 1 && player.equalsIgnoreCase("stone") || random== 2 && player.equalsIgnoreCase("paper"))
        {
            System.out.println("COMPUTER IS WINNER");
        }
    }
    }

