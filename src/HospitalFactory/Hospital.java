package HospitalFactory;

import hospitalData.*;

import java.util.*;

public class Hospital {
    private List<Speciality> specialities;
    private Map<String, Patient> patients;
    private HospitalDataBase hospitalDataBase;

    public Hospital() {
        String[] names1 = {"patrick", "jean", "plop", "ploup"};
        String[] names2 = {"canard", "pingouin", "knarf"};
        String[] names3 = {"jkj", "jfk", "paté"};
        String[] names4 = {"ramon", "jamon", "jambon", "ham"};
        specialities = new ArrayList<>();
        specialities.add(new Speciality("Cardiologie",
                new ArrayList<String>(Arrays.asList(names1))));
        specialities.add(new Speciality("Scientologie",
                new ArrayList<String>(Arrays.asList(names2))));
        specialities.add(new Speciality("Hématologie",
                new ArrayList<String>(Arrays.asList(names3))));
        specialities.add(new Speciality("Rhumatologie",
                new ArrayList<String>(Arrays.asList(names4))));

        this.patients = new HashMap<>();
/*        this.hospitalData     Base = new HospitalDataBase(patients, specialities);*/
    }

    public Patient createPatient(String nom, String security_number, String address, int age) {
        return this.patients.put(nom, new Patient(nom, security_number, address, age));
    }

    public boolean checkIfPatientAlreadyExists(String name) {
        return this.patients.containsKey(name);
    }

    public boolean addResidenceCardToPatient(Patient patient, ResidenceCard residenceCard) {
        if (!this.patients.containsKey(patient.getName()))
            return false;
        residenceCard.getSpecialityList().forEach( speciality ->
        {
            if (patient.getScoreCardByName(speciality) == null)
                patient.addScoreCard(new ScoreCard(speciality));
        });
        patient.setResidenceCard(residenceCard);
        this.patients.put(patient.getName(), patient);
        return true;
    }

    public Patient addPatient(Patient patient) {
        return this.patients.put(patient.getName(), patient);
    }

    public boolean specialityExists(String name)
    {
        Iterator<Speciality> it = specialities.iterator();
        while (it.hasNext())
        {
            Speciality speciality = it.next();
            if (speciality.getSpecialityName().contentEquals(name))
                return true;
        }
        return false;
    }

    public Patient getPatientByName(String name)
    {
        return  this.patients.get(name);
    }

    public Speciality getSpecialityByName(String name){
        Iterator<Speciality> it = specialities.iterator();
        while (it.hasNext())
        {
            Speciality speciality = it.next();
            if (speciality.getSpecialityName().contentEquals(name))
                return speciality;
        }
        return null;
    }
}
