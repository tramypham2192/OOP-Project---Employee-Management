public class Employee extends Person {
    private String managerId = null;

    public Employee(String id, String name, String phoneNumber, int numberOfWorkingDays, int dailySalary, String managerId) {
        super(id, name, phoneNumber, numberOfWorkingDays, dailySalary);
        this.managerId = managerId;
    }

    //getter setter
    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public int calculateEmployeeSalary(int numberOfWorkingDays){
        return 100 * numberOfWorkingDays; //employee daily salary is 100
    }
}
