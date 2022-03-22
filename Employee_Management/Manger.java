
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.*;

public class Manger {
	ArrayList<Employee> employeeLst;
	public Manger(ArrayList<Employee> employeeLst) {
		this.employeeLst = employeeLst;
	}
	
	public void inputList(int size) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 1; i <= size; i++) {
			System.out.println("Enter employee " + i + " info: ");
			
			System.out.println("Enter employee " + i + " code: ");
			String Code = sc.next();

			System.out.println("Enter employee " + i + " name: ");
			String name = sc.next();

			System.out.println("Enter employee " + i + " birthday: ");
			LocalDate birthday = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());

			System.out.println("Enter employee " + i + " gender: ");
			String gender = sc.next();

			System.out.println("Enter employee " + i + " number of children: ");
			int numberOfChildren = sc.nextInt();

			System.out.println("Enter employee " + i + " salary: ");
			double salary = sc.nextDouble();

			employeeLst.add(new Employee(Code, name, birthday, 
					gender, numberOfChildren, salary));
		}
	}
	
	public void showList() {
		for (Employee e: employeeLst) {
			System.out.println(e.toString());
		}
	}
	
	public int count() {
		int count = 0;
		for (Employee e: employeeLst) {
			if (e.getGender() == "female" && e.getNumberOfChildren() == 0) {
				count++;
			}
		}
		return count;
	}
	
	public void showSocon(int n) {
		for (Employee e: employeeLst) {
			if (e.getNumberOfChildren() < n) {
				System.out.println(e.toString());
			}
		}
	}
	
	public void sortBySalary() {
		ArrayList<Employee> maleEmployee = new ArrayList<Employee>();
		for (Employee e: employeeLst) {
			if (e.getGender() == "male") {
				maleEmployee.add(e);
			}
		}
		Collections.sort(maleEmployee, new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				if (e1.getSalary() == e2.getSalary()) {
					return 0;
				} else {
					return e1.getSalary() > e2.getSalary() ? -1 : 1;
				}
			}
		});
        for (Employee e: maleEmployee){
            System.out.println(e.toString());
        }
	}
	
	public void delete(int n) {
        employeeLst.removeIf(s -> (s.getGender().equals("male") && s.getNumberOfChildren() > n));
	}
	
	public void showByName(String name) {
		for (Employee e: employeeLst) {
			if (e.getName().equals(name)) {
				System.out.println(e.toString());
			}
		}
	}
	
	public void updateSalary() {
		for (Employee e: employeeLst) {
			if (e.calculateAge() < 30) {
				e.setSalary(e.getSalary() * 1.05);
			} else if (e.calculateAge() >= 30 && e.calculateAge() < 40) {
				e.setSalary(e.getSalary() * 1.1);
			} else {
				e.setSalary(e.getSalary() * 1.15);
			}
		}
	}
	
	
}
