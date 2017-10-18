package HospitalFactory;

import hospitalData.Patient;
import hospitalData.Report;
import hospitalData.ScoreCard;
import hospitalData.Speciality;

import java.util.Scanner;

public class SpecialityService {
    public boolean patientVisit(Patient patient, Speciality speciality)
    {
        if (speciality == null)
            return false;
        System.out.println(patient.getName() + " consulte " + speciality.getSpecialityName());
        Scanner scanner = new Scanner(System.in);
        String name, date, corps;
        System.out.println("Nom du praticien");
        name = scanner.nextLine();
        if (!speciality.checkSpecialistExistence(name))
            return false;
        System.out.println("Date");
        date = scanner.nextLine();
        System.out.println("Corps");
        corps = scanner.nextLine();
        if (date.length() <= 0 || corps.length() <=0)
            return false;
        //TODO : check if scorecard exists before adding report
        ScoreCard scoreCard = patient.getScoreCardByName(speciality.getSpecialityName());
        if (scoreCard == null) {
            scoreCard = new ScoreCard(speciality.getSpecialityName());
            if (!patient.addScoreCard(scoreCard))
                return false;
        }
        patient.getScoreCardByName(speciality.getSpecialityName())
                .addReport(new Report(name, date, corps));
        return true;
    }
}
