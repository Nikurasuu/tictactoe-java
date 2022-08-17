package de.niklas;

import java.util.Scanner;

public class PlayerInput {

    Scanner input = new Scanner (System.in);

    int x,y;

    public Playfield input(int player, Playfield playfield){

        System.out.println("Spieler " + player + " Eingabe:");
        while (true) {
            while (true) {
                System.out.println("X:");
                x = input.nextInt();
                if (x >= 0 && x <= 2) {
                    break;
                }
            }

            while (true) {
                System.out.println("Y:");
                y = input.nextInt();
                if (y >= 0 && y <= 2) {
                    break;
                }
            }

            if (playfield.get(x, y) == 0) {
                playfield.set(x, y, player);
                return playfield;
            } else {
                System.out.println("Dieses Feld wurde bereits benutzt.");
            }
        }
    }
}

//TODO Fix Input outside the Array DONE
//TODO Check if field is already claimed DONE
//TODO What happens if no one wins DONE