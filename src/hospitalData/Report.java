package hospitalData;

public class Report {
    private String specialistName;
    private String date;
    private String report;

    public Report(String specialistName, String date, String report)
    {
        this.specialistName = specialistName;
        this.date = date;
        this.report = report;
    }

    Report getReport()
    {
        return this;
    }

    String getDate()
    {
        return this.date;
    }

    String getSpecialistName()
    {
        return this.specialistName;
    }
}
