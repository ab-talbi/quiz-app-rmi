package com.ayoub.quiz_app_devoir_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Serveur extends UnicastRemoteObject implements IServeur {
    private static final int TAILLE_QUESTION = 10;
    private Question[] questions;
    private int questionCourrante;
    private int score;

    public Serveur() throws RemoteException {
        super();
        initialiserLesQuestions();
        questionCourrante = 0;
        score = 0;
    }

    private void initialiserLesQuestions() {
        questions = new Question[TAILLE_QUESTION];

        questions[0] = new Question("",
                new String[]{"", "", "", ""}, 1);

    }

    @Override
    public Question questionSuivante() throws RemoteException {
        if (questionCourrante < questions.length) {
            return questions[questionCourrante++];
        } else {
            //la fin de quiz
            return null;
        }
    }

    @Override
    public boolean validerLaReponse(int question, int reponse) throws RemoteException {
        if (questions[question].getChoixCorrecte() == reponse) {
            score++;
            return true;
        }
        return false;
    }

    @Override
    public int getScore() throws RemoteException {
        return score;
    }

    @Override
    public int getNombreDeQuestion() throws RemoteException {
        return 0;
    }
}
