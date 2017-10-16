package com.hopital;

import HospitalFactory.Hospital;
import HospitalFactory.PatientService;
import hospitalData.Patient;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PatientService patientService = new PatientService();
        Hospital hospital = new Hospital();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Entrer nom patient :");
            String str = scanner.nextLine();
            System.out.println("Le super patient " + str);
            if (!hospital.checkIfPatientAlreadyExists(str))
                hospital.addPatient(patientService.registerNewPatient());
            else
                System.out.println("Le patient existe");
        }
    }
}
