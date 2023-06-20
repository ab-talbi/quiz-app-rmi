/**
 * @author TALBI Ayoub
 * @date 18-06-2023
 */

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

    /**
     * Pour initialiser les questions
     */
    private void initialiserLesQuestions() {
        questions = new Question[TAILLE_QUESTION];

        questions[0] = new Question("",
                new String[]{"", "", "", ""}, 1);

    }

    /**
     * L'implementation de la qustionSuivante() ou il y a la condition
     * Est ce qu'on a terminer les qustions ou non
     * @return La question suivante de type Question ou null
     * @throws RemoteException
     */
    @Override
    public Question questionSuivante() throws RemoteException {
        if (questionCourrante < questions.length) {
            return questions[questionCourrante++];
        } else {
            //la fin de quiz
            return null;
        }
    }

    /**
     * On valide la réponse, si juste on incremente le score
     * @param question c'est l'id de la question
     * @param reponse c'est l'id de la reponse
     * @return true si juste, false sinon
     * @throws RemoteException
     */
    @Override
    public boolean validerLaReponse(int question, int reponse) throws RemoteException {
        if (questions[question].getChoixCorrecte() == reponse) {
            score++;
            return true;
        }
        return false;
    }

    /**
     * Renvoyer le score finale
     * @return le score
     * @throws RemoteException
     */
    @Override
    public int getScore() throws RemoteException {
        return score;
    }

    /**
     * Pour savoir le nombre de questions
     * @return nombre de questions
     * @throws RemoteException
     */
    @Override
    public int getNombreDeQuestion() throws RemoteException {
        return 0;
    }
}
