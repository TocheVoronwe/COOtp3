package HospitalControl;

import HospitalFactory.Hospital;
import HospitalFactory.PatientService;
import HospitalFactory.ResidenceCardService;
import HospitalFactory.SpecialityService;
import hospitalData.Patient;

import java.util.Scanner;

public class HospitalControl {
    static Hospital hospital;
    public HospitalControl()
    {
        hospital = new Hospital();
    }
    public static boolean entry() {
        System.out.println("Entrée d'un patient :\nNom du patient");
        Scanner scanner = new Scanner(System.in);
        PatientService patientService = new PatientService();
        Patient patient;
        String name = scanner.nextLine();
        if (!hospital.checkIfPatientAlreadyExists(name))
            hospital.addPatient(patientService.registerNewPatient(name));
        patient = hospital.getPatientByName(name);
        if (!patient.haveAResidenceCard())
            setUpResidenceCard(patient);
        else
            System.out.println("Le patient " + patient.getName() + " a déjà une fiche de séjour");
        return true;
    }

    public static boolean visualization() {
        System.out.println("Visualisation de la fiche de séjour d'un patient :\nNom du patient : ");
        Scanner scanner = new Scanner(System.in);
        Patient patient;
        String name = scanner.nextLine();
        patient = hospital.getPatientByName(name);
        if (patient == null || patient.getResidenceCard() == null)
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

    public static boolean consultation() {
        System.out.println("Consultation dans un service :\nNom du Service : ");
        SpecialityService specialityService = new SpecialityService();

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        return specialityService.patientVisit(hospital, hospital.getSpecialityByName(name));
    }

    public static boolean exit() {
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

    public static boolean setUpResidenceCard(Patient patient) {
        System.out.println("Création de la fiche de séjour");
        ResidenceCardService residenceCardService = new ResidenceCardService();
        return hospital.addResidenceCardToPatient(patient, residenceCardService.setUpResidenceCard(hospital));
    }

}
