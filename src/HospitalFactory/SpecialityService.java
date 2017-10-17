package HospitalFactory;

import hospitalData.Patient;
import hospitalData.Speciality;

import java.util.Scanner;

public class SpecialityService {
    public boolean patientVisit(Patient patient, Speciality speciality)
    {
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
        patient.
        return true;
    }
}
