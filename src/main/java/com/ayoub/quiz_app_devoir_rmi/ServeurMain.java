/**
 * @author TALBI Ayoub
 * @date 18-06-2023
 */

package com.ayoub.quiz_app_devoir_rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServeurMain {
    public static void main(String[] args) {
        try {
            Serveur serveur = new Serveur();

            LocateRegistry.createRegistry(1099);
            Naming.bind("irisi-quiz",serveur);

            System.out.println("Le serveur est pret...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
