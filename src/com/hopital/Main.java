package com.hopital;

import HospitalControl.HospitalControl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HospitalControl hospitalControl = new HospitalControl();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 - Entrée d'un patient\n2 - Visualisation du séjour\n3 - Consultation\n4 - Sortie");
            String str = scanner.nextLine();
            switch (str) {
                case "1":
                    hospitalControl.entry();
                    break;
                case "2":
                    hospitalControl.visualization();
                    break;
                case "3":
                    hospitalControl.consultation();
                    break;
                case "4":
                    hospitalControl.exit();
                    break;
                default:
                    System.out.println("Commande invalide");
                    break;
            }
        }
    }
}
