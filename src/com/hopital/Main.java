package com.hopital;

import HospitalFactory.Hospital;
import HospitalFactory.PatientService;
import HospitalFactory.ResidenceCardService;
import HospitalFactory.SpecialityService;
import hospitalData.Patient;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 - Entrée d'un patient\n2 - Visualisation du séjour\n3 - Consultation\n4 - Sortie");
            String str = scanner.nextLine();
            switch (str) {
                case "1":
                    entry(hospital);
                    break;
                case "2":
                    visualization(hospital);
                    break;
                case "3":
                    consultation(hospital);
                    break;
                case "4":
                    exit(hospital);
                    break;
                default:
                    System.out.println("Commande invalide");
                    break;
            }
        }
    }

    private static boolean entry(Hospital hospital) {
        System.out.println("Entrée d'un patient :\nNom du patient");
        Scanner scanner = new Scanner(System.in);
        PatientService patientService = new PatientService();
        Patient patient;
        String name = scanner.nextLine();
        if (!hospital.checkIfPatientAlreadyExists(name))
            hospital.addPatient(patientService.registerNewPatient(name));
        patient = hospital.getPatientByName(name);
        if (!patient.haveAResidenceCard())
            setUpResidenceCard(hospital, patient);
        else
            System.out.println("Le patient " + patient.getName() + " a déjà une fiche de séjour");
        return true;
    }

    private static boolean visualization(Hospital hospital) {
        System.out.println("Visualisation de la fiche de séjour d'un patient :\nNom du patient : ");
        Scanner scanner = new Scanner(System.in);
        PatientService patientService = new PatientService();
        Patient patient;
        String name = scanner.nextLine();
        patient = hospital.getPatientByName(name);
        if (patient == null)
            return false;
        if (patient.getScoreCards() != null)
            patient.getScoreCards().forEach(scoreCard -> {
                System.out.println(scoreCard.getSpeciality_name());
                if (scoreCard.getReports().size() > 0) {
                    String corps = scoreCard.getReportByDate(patient.getResidenceCard().getEntry_date()).getReport();
                    if (corps.length() > 0)
                        System.out.println(scoreCard.getSpeciality_name() + "\n" + corps);
                } else
                    System.out.println("Pas de rapport disponible");
            });
        else
            System.out.println("Pas de fiches de séjour");
        return true;
    }

    private static boolean consultation(Hospital hospital) {
        System.out.println("Consultation dans un service :\nNom du Service : ");
        SpecialityService specialityService = new SpecialityService();

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        return specialityService.patientVisit(hospital, hospital.getSpecialityByName(name));
    }

    private static boolean exit(Hospital hospital) {
        System.out.println("Sortie d'un patient\nNom du patient : ");
        Scanner scanner = new Scanner(System.in);
        Patient patient;
        String name = scanner.nextLine();
        patient = hospital.getPatientByName(name);
        if (patient == null || !patient.haveAResidenceCard())
            return false;
        patient.deleteResidenceCard();
        return true;
    }

    private static boolean setUpResidenceCard(Hospital hospital, Patient patient) {
        System.out.println("Création de la fiche de séjour");
        ResidenceCardService residenceCardService = new ResidenceCardService();
        return hospital.addResidenceCardToPatient(patient, residenceCardService.setUpResidenceCard(hospital));
    }

}
