package HospitalFactory;

import hospitalData.ResidenceCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResidenceCardService {
    public ResidenceCardService() {
    }

    public ResidenceCard createResidenceCard(List<String> specialities, String entry_date) {

        return new ResidenceCard(specialities, entry_date);
    }

    public ResidenceCard setUpResidenceCard(Hospital hospital)
    {
        Scanner scanner = new Scanner(System.in);
        List<String> services = new ArrayList<>();
        boolean addSpeciality = true;
        System.out.println("Date");
        String date = scanner.nextLine();
        if (date.isEmpty())
            return null;
        while (addSpeciality)
        {
            System.out.println("Nom de la spécialité, entrer une chaine vide pour quitter");
            String str = scanner.nextLine();
            addSpeciality = !str.isEmpty();
            if (addSpeciality && hospital.specialityExists(str))
                services.add(str);
            else
                System.out.println("Spécialité inconnue");
        }
        return createResidenceCard(services, date);
    }
}
