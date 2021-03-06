package hospitalData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ScoreCard {
    List<Report> reports;
    String speciality_name;

    public ScoreCard(String speciality_name){
        this.reports = new ArrayList<>();
        this.speciality_name = speciality_name;
    }

    public Report getReportByDate(String date)
    {
        Iterator<Report> it = reports.iterator();
        while (it.hasNext())
        {
            Report report = it.next();
            if (report.getDate().matches(date))
                return report;
        }
        return null;
    }

    public boolean addReport(Report report)
    {
        if (!this.reports.contains(report))
            return this.reports.add(report);
        return false;
    }
}
