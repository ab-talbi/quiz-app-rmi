package com.ayoub.quiz_app_devoir_rmi;

public class UtilisateurMain2 {
    public static void main(String[] args) {
        try {
            new Utilisateur();
            System.out.println("l'utilisateur 2 passe le quiz...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
