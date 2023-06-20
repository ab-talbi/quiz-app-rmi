package com.ayoub.quiz_app_devoir_rmi;

public class UtilisateurMain1 {
    public static void main(String[] args) {
        try {
            new Utilisateur();
            System.out.println("l'utilisateur 1 passe le quiz...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
