package com.hopital;

import HospitalFactory.Hospital;
import HospitalFactory.PatientService;
import HospitalFactory.ResidenceCardService;
import HospitalFactory.SpecialityService;
import hospitalData.Patient;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PatientService patientService = new PatientService();
        Hospital hospital = new Hospital();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Entrer nom patient :");
            String name = scanner.nextLine();
            if (!hospital.checkIfPatientAlreadyExists(name))
                hospital.addPatient(patientService.registerNewPatient(name));
            System.out.println("test : " + hospital.getPatientByName(name));
            if (!hospital.getPatientByName(name).haveAResidenceCard())
                setUpResidenceCard(hospital, hospital.getPatientByName(name));
            if (hospital.getPatientByName(name).getResidenceCard().hasAnotherConsultation())
                visitService(hospital, hospital.getPatientByName(name), hospital.getPatientByName(name)
                        .getResidenceCard().nextSpeciality());
            else
                endVisit(hospital.getPatientByName(name));

        }
    }

    private static boolean setUpResidenceCard(Hospital hospital, Patient patient) {
        System.out.println("Création de la fiche de séjour");
        ResidenceCardService residenceCardService = new ResidenceCardService();
        return hospital.addResidenceCardToPatient(patient, residenceCardService.setUpResidenceCard(hospital));
    }

    private static boolean visitService(Hospital hospital, Patient patient, String specialityName) {
        SpecialityService specialityService = new SpecialityService();

        return specialityService.patientVisit(patient, hospital.getSpecialityByName(specialityName));
    }

    private static void endVisit(Patient patient) {
        System.out.println("Le patient " + patient.getName() + "n'a plus de consultations, suppresion de sa fiche de séjour");
        patient.deleteResidenceCard();
    }
}
