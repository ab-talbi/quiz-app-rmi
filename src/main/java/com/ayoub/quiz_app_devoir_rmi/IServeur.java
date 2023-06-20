/**
 * @author TALBI Ayoub
 * @date 18-06-2023
 */

package com.ayoub.quiz_app_devoir_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServeur extends Remote {

    //Pour passer à la question suivante
    Question questionSuivante() throws RemoteException;

    //Pour voir la réponse est ce qu'elle est juste
    boolean validerLaReponse(int question, int reponse) throws RemoteException;

    //Retourner le score de l'utilisateur
    int getScore() throws RemoteException;

    //Retourner le nombre des qustions pour l'affichage
    int getNombreDeQuestion() throws RemoteException;
}