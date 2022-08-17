package de.niklas;

public class Checker {
    public boolean checkGameOver(Playfield playfield) {

        for(int player = 1; player <= 2; player++) {
            //Check Vertical
            for (int i = 0; i <= 2; i++) {
                if (playfield.get(i, 0) == player && playfield.get(i, 1) == player && playfield.get(i, 2) == player) {
                    return true;
                }
            }

            //Check Diagonal
            if (playfield.get(1, 1) == player) {
                if (playfield.get(0, 0) == player && playfield.get(2, 2) == player) {
                    return true;
                } else if (playfield.get(0, 2) == player && playfield.get(2, 0) == player) {
                    return true;
                }
            }

            //Check Horizontal
            for (int i = 0; i <= 2; i++) {
                if (playfield.get(0, i) == player && playfield.get(1, i) == player && playfield.get(2, i) == player) {
                    return true;
                }
            }
        }

        if(playfield.returnClaimedFields() == 9){
            System.out.println("Unentschieden!");
            return true;
        }

        return false;
    }
}
