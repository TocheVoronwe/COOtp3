package HospitalFactory;

import hospitalData.Patient;
import hospitalData.ResidenceCard;
import hospitalData.Speciality;

import java.util.*;

public class Hospital {
    private List<Speciality> specialities;
    private Map<String, Patient> patients;
    public Hospital()
    {
        String[] names1 = {"patrick", "jean", "plop", "ploup"};
        String[] names2 = { "canard", "pingouin", "knarf"};
        String[] names3 = {"jkj", "jfk", "paté"};
        String[] names4 = {"ramon", "jamon", "jambon", "ham"};
        specialities = new ArrayList<>();
        specialities.add(new Speciality("Cardiologie",
                new ArrayList<String>(Arrays.asList(names1))));

        specialities = new ArrayList<>();
        specialities.add(new Speciality("Scientologie",
                new ArrayList<String>(Arrays.asList(names2))));

        specialities = new ArrayList<>();
        specialities.add(new Speciality("Hématologie",
                new ArrayList<String>(Arrays.asList(names3))));

        specialities = new ArrayList<>();
        specialities.add(new Speciality("Cardiologie",
                new ArrayList<String>(Arrays.asList(names4))));

        this.patients = new HashMap<>();
    }

    public Patient createPatient(String nom, String security_number, String address, int age)
    {
        return this.patients.put(nom, new Patient(nom, security_number, address, age));
    }

    public boolean checkIfPatientAlreadyExists(String name)
    {
        return this.patients.containsKey(name);
    }

    public boolean addResidenceCardToPatient(Patient patient, ResidenceCard residenceCard)
    {
        if (!this.patients.containsKey(patient.getName()))
            return false;
        patient.setResidenceCard(residenceCard);
        this.patients.put(patient.getName(), patient);
        return true;
    }

    public void addPatient(Patient patient)
    {
        this.patients.put(patient.getName(), patient);
    }
}
