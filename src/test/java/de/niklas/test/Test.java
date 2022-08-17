package de.niklas.test;

import de.niklas.Checker;
import de.niklas.Enemy;
import de.niklas.Playfield;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test {

    Playfield testField = new Playfield();

    @org.junit.jupiter.api.Test
    void testSet(){
        testField.set(1,1,2);
        testField.set(0,2,1);
        assertEquals(testField.get(1,1),2);
        assertEquals(testField.get(0,2),1);
    }

    @org.junit.jupiter.api.Test
    void testChecker(){
        Checker testChecker = new Checker();

        Playfield testField1 = new Playfield();
        testField1.set(0,0,1);
        testField1.set(0,1,1);
        testField1.set(0,2,1);
        assertTrue(testChecker.checkGameOver(testField1));

        Playfield testField2 = new Playfield();
        testField2.set(0,0,1);
        testField2.set(1,1,1);
        testField2.set(2,2,1);
        assertTrue(testChecker.checkGameOver(testField2));

        Playfield testField3 = new Playfield();
        testField3.set(0,1,1);
        testField3.set(1,1,1);
        testField3.set(2,1,1);
        assertTrue(testChecker.checkGameOver(testField3));

        Playfield testField4 = new Playfield();
        testField4.set(0,0,2);
        testField4.set(0,1,2);
        testField4.set(0,2,2);
        assertTrue(testChecker.checkGameOver(testField4));

        Playfield testField5 = new Playfield();
        testField5.set(0,0,2);
        testField5.set(1,1,2);
        testField5.set(2,2,2);
        assertTrue(testChecker.checkGameOver(testField5));

        Playfield testField6 = new Playfield();
        testField6.set(0,2,2);
        testField6.set(1,2,2);
        testField6.set(2,2,2);
        assertTrue(testChecker.checkGameOver(testField6));
    }

    @org.junit.jupiter.api.Test
    void testEnemy(){
        Playfield testField = new Playfield();
        Enemy player2 = new Enemy();
        testField.set(0,0,1);
        testField.view();
        testField = player2.claimField(testField);
        testField.view();
        assertEquals(2, testField.get(1,1));

        Playfield testField2 = new Playfield();
        testField2.set(1,1,1);
        testField2.view();
        testField2 = player2.claimField(testField2);
        testField2.view();
        assertEquals(2,testField2.get(0,0));

        Playfield testField3 = new Playfield();
        testField3.set(0,0,1);
        testField3.set(0,1,1);
        testField3.set(1,1,2);
        testField3.view();
        player2.claimField(testField3);
        testField3.view();
        assertEquals(2,testField3.get(0,2));

        Playfield testField4 = new Playfield();
        testField4.set(0,0,1);
        testField4.set(1,0,1);
        testField4.set(1,1,2);
        testField4.view();
        player2.claimField(testField4);
        testField4.view();
        assertEquals(2,testField4.get(2,0));

        Playfield testField5 = new Playfield();
        testField5.set(0,0,2);
        testField5.set(2,0,1);
        testField5.set(1,1,1);
        testField5.view();
        player2.claimField(testField5);
        testField5.view();
        assertEquals(2,testField5.get(0,2));

    }
}
