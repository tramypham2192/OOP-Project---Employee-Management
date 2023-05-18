import java.util.ArrayList;

public class DepartmentHead extends Person {
    private int numberOfEmployees;
    ArrayList<Employee> employeeList = new ArrayList<>();
    //constructor
    public DepartmentHead(String id, String name, String phoneNumber, int numberOfWorkingDays, int dailySalary, int numberOfEmployees) {
        super(id, name, phoneNumber, numberOfWorkingDays, dailySalary);
        this.numberOfEmployees = numberOfEmployees;
    }

    //getter setter
    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public void setEmployeeList(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public ArrayList<Employee> getEmployeeList() {
        return this.employeeList;
    }

    public void addEmployee(Employee nv){
        this.numberOfEmployees++;
        employeeList.add(nv);
    }

    public int calculateSalary(int numberOfWorkingDays){
        return 200 * numberOfWorkingDays * this.numberOfEmployees; //daily salary of department head is 200
    }


}
