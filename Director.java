import java.util.ArrayList;

public class Director extends Person {
    private double percentOfEquity;

    public Director(String id, String name, String phoneNumber, int numberOfWorkingDays, int dailySalary, double percentOfEquity) {
        super(id, name, phoneNumber, numberOfWorkingDays, dailySalary);
        if (percentOfEquity <= 1){
            this.percentOfEquity = percentOfEquity;
        }
    }

    public double getpercentOfEquity() {
        return this.percentOfEquity;
    }

    public void setpercentOfEquity(double percentOfEquity) {
        this.percentOfEquity = percentOfEquity;
    }

    public int calculateDirectorSalary(int numberOfWorkingDays){
        return 300 * numberOfWorkingDays;
    }

    public int calculateDirectorIncome(int numberOfWorkingDays){
        return (int) (this.calculateDirectorSalary(numberOfWorkingDays) + this.percentOfEquity * 200000); //200000 is the compamny's profit
}
