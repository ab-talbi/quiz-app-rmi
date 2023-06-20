/**
 * @author TALBI Ayoub
 * @date 18-06-2023
 */

package com.ayoub.quiz_app_devoir_rmi;

import java.io.Serializable;

public class Question implements Serializable {
    private String question;
    private String[] choix;
    private int choixCorrecte;

    public Question(String question, String[] choix, int choixCorrecte) {
        this.question = question;
        this.choix = choix;
        this.choixCorrecte = choixCorrecte;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getChoix() {
        return choix;
    }

    public int getChoixCorrecte() {
        return choixCorrecte;
    }
}
