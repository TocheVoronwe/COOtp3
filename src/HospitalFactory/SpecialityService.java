package HospitalFactory;

import hospitalData.Patient;
import hospitalData.Report;
import hospitalData.ScoreCard;
import hospitalData.Speciality;

import java.util.Scanner;

public class SpecialityService {
    public boolean patientVisit(Hospital hospital, Speciality speciality) {
        Scanner scanner = new Scanner(System.in);
        String practicienName, patientName;

        if (speciality == null)
            return false;
        System.out.println("Spécialité : " + speciality.getSpecialityName());

        System.out.println("Nom du praticien");
        practicienName = scanner.nextLine();
        if (!speciality.checkSpecialistExistence(practicienName)) {
            System.out.println("Spécialiste inconnu");
            return false;
        }

        System.out.println("Nom du patient");
        patientName = scanner.nextLine();
        Patient patient = hospital.getPatientByName(patientName);
        if (patient == null || !patient.haveAResidenceCard()) {
            System.out.println("Erreur patient");
            return false;
        }
        printReports(hospital, patient, speciality);
        return createReport(hospital, patient, speciality, practicienName);
/*        date = patient.getResidenceCard().getEntry_date();
        System.out.println("Corps");
        corps = scanner.nextLine();
        if (date.length() <= 0 || corps.length() <= 0)
            return false;
        //TODO : check if scorecard exists before adding report
        scoreCard = patient.getScoreCardByName(speciality.getSpecialityName());
        if (scoreCard == null) {
            scoreCard = new ScoreCard(speciality.getSpecialityName());
            if (!patient.addScoreCard(scoreCard))
                return false;
        }
        patient.getScoreCardByName(speciality.getSpecialityName())
                .addReport(new Report(practicienName, date, corps));
        return true;*/
    }

    public boolean createReport(Hospital hospital, Patient patient, Speciality speciality, String practicienName) {
        String corps;
        ScoreCard scoreCard;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Corps");
        corps = scanner.nextLine();
        //TODO : check if scorecard exists before adding report
        scoreCard = patient.getScoreCardByName(speciality.getSpecialityName());
        if (scoreCard == null) {
            scoreCard = new ScoreCard(speciality.getSpecialityName());
            if (!patient.addScoreCard(scoreCard))
                return false;
        }
        patient.getScoreCardByName(speciality.getSpecialityName())
                .addReport(new Report(practicienName, patient.getResidenceCard().getEntry_date(), corps));
        return true;
    }

    public void printReports(Hospital hospital, Patient patient, Speciality speciality) {
        System.out.println("Rapport déjà existants pour la spécialité " + speciality.getSpecialityName());
        ScoreCard scoreCard = patient.getScoreCardByName(speciality.getSpecialityName());
        if (scoreCard == null)
        {
            System.out.println("Aucun rapport existant");
            return;
        }
        scoreCard.printAllReports();
    }
}
