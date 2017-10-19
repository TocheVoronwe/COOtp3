package hospitalData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ResidenceCard {
    private List<String> specialityList;
    private String entry_date;
    private Iterator<String> it;

    public ResidenceCard(List<String> specialities, String entry_date){
        this.specialityList = new ArrayList<>();
        this.specialityList.addAll(specialities);
        this.entry_date = entry_date;
        it = specialityList.iterator();
    }

    public ResidenceCard(String entry_date){
        this.specialityList = new ArrayList<>();
        this.entry_date = entry_date;
        it = specialityList.iterator();
    }

    public boolean hasAnotherConsultation()
    {
        return it.hasNext();
    }

    public List<String> getSpecialityList() {
        return specialityList;
    }

    public String nextSpeciality()
    {
            String speciality = it.next();
            return speciality;
    }

    public boolean addSpeciality(String name)
    {
        return this.specialityList.add(name);
    }

    public String getEntry_date() {
        return entry_date;
    }
}
