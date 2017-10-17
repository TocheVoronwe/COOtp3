package HospitalFactory;

import hospitalData.Patient;

import java.util.Scanner;

public class PatientService {

    public Patient createPatient(String name, String security_number, String address, int age)
    {
        return new Patient(name, security_number, address, age);
    }

    public Patient registerNewPatient()
    {
        String name, security_number, adress;
        int age;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nom");
        name = scanner.nextLine();
        System.out.println("Numéro de sécurité sociale");
        security_number = scanner.nextLine();
        System.out.println("Addresse");
        adress = scanner.nextLine();
        System.out.println("Age");
        age = Integer.parseInt(scanner.nextLine());
        return createPatient(name, security_number, adress, age);
    }
}
