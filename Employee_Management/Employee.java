import java.time.LocalDate;
import java.time.Period;

public class Employee {
	private String Code;
	private String name;
	private LocalDate birthday;
	private String gender;
	private int numberOfChildren;
	private double salary;
	
	public Employee() {};
	public Employee (String Code, String name, LocalDate birthday, 
			String gender, int numberOfChildren, double salary) {
		this.Code = Code;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.numberOfChildren = numberOfChildren;
		this.salary = salary;
	}
	
	//setters getters
	public void setCode(String Code) {
		this.Code = Code;
		this.name = name;
		this.birthday = birthday;
		this.numberOfChildren = numberOfChildren;
		this.salary = salary;
	}
	public String getCode() {
		return this.Code;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public LocalDate getBirthday() {
		return this.birthday;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGender() {
		return this.gender;
	}
	
	public void setNumberOfChildren(int numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}
	public int getNumberOfChildren() {
		return this.numberOfChildren;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getSalary() {
		return this.salary;
	}
	
	//toString method
	public String toString() {
		return String.format(this.getCode() + "  " +  this.getName()+ "  " + this.getBirthday()+ "  " +
				this.getGender()+ "  " + this.getNumberOfChildren()+ "  " + this.getSalary());
	}
	
	public int calculateAge() {
		return Period.between(this.getBirthday(), LocalDate.now()).getYears();
	}
	
	public double calculateIncome() {
		double allowance = 0;
		if (this.getNumberOfChildren() <= 2) {
			allowance = 1;
		} else if (this.getNumberOfChildren() == 0) {
			allowance  = 0;
		} else {
			allowance = 1.5;
		}
		return this.getSalary() + allowance;
	}
}
