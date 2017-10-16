package HospitalFactory;

import hospitalData.ResidenceCard;

import java.util.List;

public class ResidenceCardService {
    public ResidenceCardService()
    {
    }

    public ResidenceCard createResidenceCard(List<String> specialities, String entry_date)
    {
        return new ResidenceCard(specialities, entry_date);
    }
}
