package de.niklas;

import java.util.Random;

public class Enemy {
    Random rand = new Random();

    public Playfield claimFieldRandom(Playfield playfield, int value){
        Main.wait(250);
        while (true) {
            int x = rand.nextInt(3);
            int y = rand.nextInt(3);
            System.out.print("Enemy checking: " + x + "," + y);
            if(playfield.get(x,y) == 0){
                System.out.println(" Okay");
                playfield.set(x,y,value);
                return playfield;
            } else {
                System.out.println(" Not Okay. Try Again.");
            }
        }
    }

    public Playfield claimField(Playfield playfield) {

        //Check for two claimed fields vertical next to each other
        System.out.println("-- Pruefe Vertikal --");
        for (int i = 0; i <= 2; i++) {
            Main.wait(100);

            int emptyFields = 0;
            int playerFields = 0;
            int enemyFields = 0;

            for (int j = 0; j <= 2; j++) {
                if (playfield.get(i, j) == 0) {
                    emptyFields++;
                } else if (playfield.get(i, j) == 1) {
                    playerFields++;
                } else if (playfield.get(i, j) == 2) {
                    enemyFields++;
                }
            }

            System.out.println("emptyFields:" + emptyFields + " playerFields:" + playerFields + " enemyFields:" + enemyFields);

            if (emptyFields == 1 && playerFields >= 2) {
                for (int j = 0; j <= 2; j++) {
                    if (playfield.get(i, j) == 0) {
                        System.out.println("Freies Feld gefunden! Position: " + j);
                        playfield.set(i, j, 2);
                        return playfield;
                    }
                }
            }
        }

        //Check for two claimed fields horizontal next to each other
        System.out.println("-- Pruefe Horizontal --");
        for (int i = 0; i <= 2; i++) {
            Main.wait(100);

            int emptyFields = 0;
            int playerFields = 0;
            int enemyFields = 0;

            for (int j = 0; j <= 2; j++) {
                if (playfield.get(j, i) == 0) {
                    emptyFields++;
                } else if (playfield.get(j, i) == 1) {
                    playerFields++;
                } else if (playfield.get(j, i) == 2) {
                    enemyFields++;
                }
            }

            System.out.println("emptyFields:" + emptyFields + " playerFields:" + playerFields + " enemyFields:" + enemyFields);

            if (emptyFields == 1 && playerFields >= 2) {
                for (int j = 0; j <= 2; j++) {
                    if (playfield.get(j, i) == 0) {
                        System.out.println("Freies Feld gefunden! Position: " + j);
                        playfield.set(j, i, 2);
                        return playfield;
                    }
                }
            }
        }

        //Check for two claimed fields diagonal next to each other
        System.out.println("-- Pruefe Diagonal --");
        Main.wait(100);

        int emptyFields = 0;
        int playerFields = 0;
        int enemyFields = 0;

        for (int j = 0; j <= 2; j++) {
            if (playfield.get(j,j) == 0) {
                emptyFields++;
            } else if (playfield.get(j,j) == 1) {
                playerFields++;
            } else if (playfield.get(j,j) == 2) {
                enemyFields++;
            }
        }

        System.out.println("emptyFields:" + emptyFields + " playerFields:" + playerFields + " enemyFields:" + enemyFields);

        if (emptyFields == 1 && playerFields >= 2) {
            for (int j = 0; j <= 2; j++) {
                if (playfield.get(j,j) == 0) {
                    System.out.println("Freies Feld gefunden! Position: " + j);
                    playfield.set(j,j, 2);
                    return playfield;
                }
            }
        }

        Main.wait(100);

        emptyFields = 0;
        playerFields = 0;
        enemyFields = 0;

        for (int j = 0; j <= 2; j++) {
            if (playfield.get(2-j,j) == 0) {
                emptyFields++;
            } else if (playfield.get(2-j,j) == 1) {
                playerFields++;
            } else if (playfield.get(2-j,j) == 2) {
                enemyFields++;
            }
        }

        System.out.println("emptyFields:" + emptyFields + " playerFields:" + playerFields + " enemyFields:" + enemyFields);

        if (emptyFields == 1 && playerFields >= 2) {
            for (int j = 0; j <= 2; j++) {
                if (playfield.get(2-j,j) == 0) {
                    System.out.println("Freies Feld gefunden! Position: " + j);
                    playfield.set(2-j,j, 2);
                    return playfield;
                }
            }
        }



        //Check if center is free
        if (playfield.returnClaimedFields() <= 1) {
            if (playfield.get(1, 1) == 0) {
                //Check if all corners are free
                if (playfield.get(0, 0) == 0 && playfield.get(0, 2) == 0 && playfield.get(2, 0) == 0 && playfield.get(2, 2) == 0) {
                    playfield.set(0, 0, 2);
                } else {
                    playfield.set(1, 1, 2);
                }
            } else {
                playfield.set(0, 0, 2);
            }
            return playfield;
        }

        //Fallback
        playfield = claimFieldRandom(playfield,2);
        return playfield;
    }
}

//TODO Pick random coordinates between 0-2
//TODO Check if field is unclaimed
//TODO Claim field
