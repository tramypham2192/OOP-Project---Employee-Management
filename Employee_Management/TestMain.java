import java.time.LocalDate;
import java.util.*;

public class TestMain {
	public static void main(String[] args) {
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		Manger mg = new Manger(employeeList);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("OPTIONS: ");
		System.out.println("TC1-Enter the employee list");
		System.out.println("TC2- Display the employee list");
		System.out.println("TC3- Counts the number of female employees with no allowances");
		System.out.println("TC4- Displays employees with the number &lt;given number.");
		System.out.println("TC5- Arranging an increasing number of male employees&#39; salaries.");
		System.out.println("TC6- Removing male employees according to the number of entries entered\n"
				+ "from the keyboard.");
		System.out.println("TC7- Display employees by name.");
		System.out.println("TC8- Update salary");
		System.out.println("Exit");
		
		System.out.println("Please choose option: ");
		String option = sc.next();
		manage(sc, option, mg);	
	}
	
	public static void manage(Scanner sc, String option, Manger mg) {
			switch (option) {
			case "TC1":
				mg.inputList(3);
				System.out.println("Please choose option: ");
				option = sc.next();
				manage(sc, option, mg);
				break;
			case "TC2":
				mg.showList();
				System.out.println("Please choose option: ");
				option = sc.next();
				manage(sc, option, mg);
				break;
			case "TC3":
				mg.count();
                System.out.println("Number of non-allowance female worker: " + mg.count());
				System.out.println("Please choose option: ");
				option = sc.next();
				manage(sc, option, mg);
				break;
			case "TC4":
				mg.showSocon(3);
				System.out.println("Please choose option: ");
				option = sc.next();
				manage(sc, option, mg);
				break;
			case "TC5":
				mg.sortBySalary();
				System.out.println("Please choose option: ");
				option = sc.next();
				manage(sc, option, mg);
				break;
			case "TC6":
				mg.delete(0);
				System.out.println("Please choose option: ");
				option = sc.next();
				manage(sc, option, mg);
				break;
			case "TC7":
				mg.showByName("man");
				System.out.println("Please choose option: ");
				option = sc.next();
				manage(sc, option, mg);
				break;
			case "TC8":
				mg.updateSalary();
				System.out.println("Please choose option: ");
				option = sc.next();
				manage(sc, option, mg);
				break;
			
		}	
		
	}
}
