package com.jaisonbrooks.github.treehouse.crystalmagic.app;

import java.util.Random;

/**
 * Created by Jaisonbrooks on 6/5/2014.
 */
public class CrystalMagic {

    //Variables
    String[] mAnswers = {"It's affirmative", "Its defiantly going to happen", "All signs point YES", "The stars are not aligned", "Pry not going to happen", "It is very doubtful", "I'd better not tell you now", "Concentrate and try again", "I cant think of anything"};
    String mAnswer;
    int randomNumber;
    int mPosition;


    //Methods
    public String getAnswer() {
        Random answerGenerater = new Random(); // Construct Generator
        randomNumber = answerGenerater.nextInt(mAnswers.length); // Create and limit number
        mAnswer = mAnswers[randomNumber];
        return mAnswer;
    }

    public int getInt() {
        mPosition = randomNumber;
        return mPosition;

    }

}
