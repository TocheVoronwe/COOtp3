package hospitalData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ScoreCard {
    private List<Report> reports;
    private String speciality_name;

    public ScoreCard(String speciality_name) {
        this.reports = new ArrayList<>();
        this.speciality_name = speciality_name;
    }

    public Report getReportByDate(String date) {
        Iterator<Report> it = reports.iterator();
        while (it.hasNext()) {
            Report report = it.next();
            if (report.getDate().matches(date))
                return report;
        }
        return null;
    }

    public void printAllReports() {
        System.out.println(speciality_name);
        if (reports.size() == 0)
            System.out.println("Aucun rapport existant");
        reports.forEach(report -> {
            System.out.println(report.getDate() + " " + report.getSpecialistName() + " " + report.getClass());
        });
    }

    public List<Report> getReports() {
        return reports;
    }

    public String getSpeciality_name() {
        return speciality_name;
    }

    public boolean addReport(Report report) {
        if (!this.reports.contains(report))
            return this.reports.add(report);
        return false;
    }
}
