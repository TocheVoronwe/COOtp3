package hospitalData;

import java.util.*;

public class HospitalDataBase {
    private Map<String, Patient> patients;
    private List<Speciality> specialities;

    public HospitalDataBase() {
        initData();
    }

    public HospitalDataBase(Map<String, Patient> patients, List<Speciality> specialities) {
        initData();
        this.patients.putAll(patients);
        this.specialities.addAll(specialities);

    }

    private void initData() {
        this.patients = new HashMap<>();
        this.specialities = new ArrayList<>();
    }

    public void addPatientMap(Map<String, Patient> patients) {
        this.patients = patients;
    }

    public void addSpecialityList(List<Speciality> specialities)
    {
        this.specialities = specialities;
    }

    public HospitalDataBase getHospitalDatabase()
    {
        return this;
    }

    public Map<String, Patient> getPatients() {
        return patients;
    }

    public List<Speciality> getSpecialities() {
        return specialities;
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
}
