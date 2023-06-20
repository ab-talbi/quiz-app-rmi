package com.ayoub.quiz_app_devoir_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServeur extends Remote {

    Question questionSuivante() throws RemoteException;

    boolean validerLaReponse(int question, int reponse) throws RemoteException;

    int getScore() throws RemoteException;

    int getNombreDeQuestion() throws RemoteException;
}