package de.niklas;

public class Playfield {
    int[][] field = new int[3][3];
    int claimedFields;

    public int get(int x, int y){
        return field[x][y];
    }

    public void set(int x,int y, int value){
        field[x][y] = value;
        claimedFields++;
    }

    public void view() {
        for (int i = 0; i < 3; i++) {
            System.out.println(" ");
            for (int j = 0; j < 3; j++) {
                //System.out.print(field[j][i]);
                switch(field[j][i]){
                    case 0:
                        System.out.print("[ ] ");
                        break;
                    case 1:
                        System.out.print("[X] ");
                        break;
                    case 2:
                        System.out.print("[O] ");
                        break;
                }
            }
        }
        System.out.println(" ");
    }

    public int returnClaimedFields(){
        return claimedFields;
    }
}
