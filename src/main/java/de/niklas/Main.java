package de.niklas;

import de.niklas.gui.App;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Enemy player = new Enemy();
        Playfield field = new Playfield();
        Checker checker = new Checker();
        PlayerInput playerInput = new PlayerInput();
        App app = new App();
        app.start();
        app.load(field);

        while(!checker.checkGameOver(field)){
            app.setStatus("Spieler 1 ist am Zug!");
            app.setInput(false);
            while(!app.isInput()){
                wait(100);
            }
            app.load(field);
            if(!checker.checkGameOver(field)) {
                app.setStatus("Spieler 2 ist am Zug!");
                player.claimField(field);
            }
            app.load(field);
        }
        app.setStatus("Spiel beendet.");
    }

    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
