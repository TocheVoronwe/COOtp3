package hospitalData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Patient {
    String name;
    String security_number;
    String address;
    int age;
    List<ScoreCard> scoreCards;
    ResidenceCard residenceCard;

    public Patient(String name, String security_number, String address, int age)
    {
        this.name = name;
        this.security_number = security_number;
        this.address = address;
        this.age = age;
        this.scoreCards = new ArrayList<>();
    }

    public String getName()
    {
        return this.name;
    }

    public String getaddress() {
        return address;
    }

    public String getSecurity_number() {
        return security_number;
    }

    public int getAge() {
        return age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNom(String nom) {
        this.name = nom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setResidenceCard(ResidenceCard residenceCard) {
        this.residenceCard = residenceCard;
    }

    public void deleteResidenceCard()
    {
        this.residenceCard = null;
    }

    public List<ScoreCard> getScoreCards() {
        return scoreCards;
    }

    public ScoreCard getScoreCardByName(String specialityName)
    {
        Iterator<ScoreCard> it = scoreCards.iterator();
        while (it.hasNext())
        {
            ScoreCard scoreCard = it.next();
            if (scoreCard.getSpeciality_name().contentEquals(specialityName))
                return scoreCard;
        }
        return  null;
    }
}
