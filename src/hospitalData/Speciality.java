package hospitalData;

import java.util.ArrayList;
import java.util.List;

public class Speciality {
    String specialityName;
    List<String> specialistNames;

    public Speciality(String specialityName, List<String> specialistNames)
    {
        this.specialityName = specialityName;
        this.specialistNames = new ArrayList<>();
        this.specialistNames.addAll(specialistNames);
    }

    public String getSpecialityName()
    {
        return this.specialityName;
    }

    public boolean checkSpecialistExistence(String name)
    {
        return this.specialistNames.contains(name);
    }
}
