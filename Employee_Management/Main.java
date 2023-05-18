import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String chooseOption = chooseAnOption(sc);
        ArrayList<Director> directorList = new ArrayList<>();
        ArrayList<DepartmentHead> departmentHeadList = new ArrayList<>();
        ArrayList<Employee> employeeList = new ArrayList<>();
        ArrayList<ArrayList> listOfAllWorkers = new ArrayList<>();
        listOfAllWorkers.add(directorList);
        listOfAllWorkers.add(departmentHeadList);
        listOfAllWorkers.add(employeeList);
        while (!(chooseOption.equals("Exit"))){
            listOfAllWorkers = manage(sc, chooseOption, listOfAllWorkers);
            chooseOption = chooseAnOption(sc);
        }
    }

    public static ArrayList<ArrayList> manage(Scanner sc, String option, ArrayList<ArrayList> listOfAllWorkers) {
        switch (option) {
            case "1":
                ArrayList<Director> listDirector1 = listOfAllWorkers.get(0);
                ArrayList<DepartmentHead> listDepartmentHead1 = listOfAllWorkers.get(1);
                System.out.println("Input workers info: ");

                //Input info of directors
                System.out.println("Input director's salary: ");
                int numberOfDirectors = sc.nextInt();
                //create an array list of directors
                for (int i = 1; i <= numberOfDirectors; i++) {
                    System.out.println("Input Id of director number " + i + ":");
                    String Id = sc.next();
                    System.out.println("Input name of director number " + i + ":");
                    String name = sc.next();
                    System.out.println("Input phone number of director number " + i + ":");
                    String phoneNumber = sc.next();
                    System.out.println("Input number of working days of director number " + i + ":");
                    int numberOfWorkingDays = sc.nextInt();
                    System.out.println("Input percentage of equity that director number " + i + " is having:");
                    double percentageOfEquity = sc.nextDouble();
                    Director newDirectorObj = new Director(Id, name, phoneNumber, numberOfWorkingDays, 300, percentageOfEquity); //300 is daily salary of directors
                    listDirector1.add(newDirectorObj);
                    System.out.println("Print out directors' info: ");
                    for (Director gd : listDirector1) gd.personInfo();
                }

                //Input department heads' info
                System.out.println("Input number of department heads: ");
                int numberOfDepartmentHeads = sc.nextInt();
                //create an array list of department heads
                for (int i = 1; i <= numberOfDepartmentHeads; i++) {
                    System.out.println("Input Id of department head number " + i + ":");
                    String Id = sc.next();
                    System.out.println("Input name of department head number " + i + ":");
                    String name = sc.next();
                    System.out.println("Input phone number of department head number " + i + ":");
                    String phoneNumber = sc.next();
                    System.out.println("Input phone number of working days of department head number " + i + ":");
                    int numberOfWorkingDays = sc.nextInt();
                    System.out.println("Input number of employees of department head number " + i + ":");
                    int numberOfEmployees = sc.nextInt();
                    DepartmentHead newDepartmentHeadObj = new DepartmentHead(Id, name, phoneNumber, numberOfWorkingDays, 200, numberOfEmployees);
                    listDepartmentHead1.add(newDepartmentHeadObj);
                    System.out.println("Print out department heads info: ");
                    for (DepartmentHead tp : listDepartmentHead1) {
                        tp.personInfo();
                        System.out.println("number of employees: " + tp.getNumberOfEmployee());
                    }
                }
                break;

            case "2":
                //get the list of all workers then get the list of current head of departments
                ArrayList<DepartmentHead> listDepartmentHead2 = listOfAllWorkers.get(1);
                ArrayList<NhanVien> listOfEmployee2 = listOfAllWorkers.get(2);
                //Input the info of deapartment head receiving new employee(s)
                System.out.println("Input Id of the Department Head: ");
                String idOfDepartmentHead = sc.next();
                //Calculate the number of employees that Head of Department with Id idOfDepartmentHead need to be added 
                int numberOfEmployeeToBeAddes = 0;
                for (int i = 0; i < listDepartmentHead2.size(); i++){
                    if (listDepartmentHead2.get(i).getId().equals(idOfDepartmentHead)){
                        numberOfEmployeeToBeAddes = listDepartmentHead2.get(i).getNumberOfEmployees() - listDepartmentHead2.get(i).getEmployeeList().size();
                    }
                }
                System.out.println("Department head with Id " + idOfDepartmentHead + " need to have " + numberOfEmployeeToBeAddes + " to be added" );
                //Input employee(s) info to be added
                //If the department head have all the number of employee (s)he has been asigned but still want to add more employee(s)
                if (numberOfEmployeeToBeAddes == 0){
                    System.out.println("This department head has all the employees (s)he has been assigned. Do you still want to add more employee(s) for him(her) ?. Say yes if you want to add");
                    String addOrNot = sc.next();
                    if (addOrNot.equalsIgnoreCase("yes")){
                        System.out.println("Input employee id:");
                        String id = sc.next();
                        System.out.println("Input employee name:");
                        String name = sc.next();
                        System.out.println("Input employee id phone number:");
                        String phoneNumber = sc.next();
                        System.out.println("Input employee number of working days:");
                        int numberOfWorkingDays = sc.nextInt();
                        NhanVien employeeObj = new Employee(id, name, phoneNumber, numberOfWorkingDays, 100, idOfDepartmentHead);
                        listOfEmployee2.add(employeeObj);
                        System.out.println("After adding, the employee list of the Department head with Id " + idOfDepartmentHead + "is: ");
                        for (Employee nv : listOfEmployee2){
                            nv.personInfo();
                        }
                    }
                }
                //If the department head has not had the number of employees (s)he has been assigned
                else {
                    for (int i = 1; i <= numberOfEmployeeToBeAddes; i++){
                        System.out.println("Input employee " + i + " id:");
                        String id = sc.next();
                        System.out.println("Input employee " + i + " name:");
                        String name = sc.next();
                        System.out.println("Input employee " + i + " phone number:");
                        String phoneNumber = sc.next();
                        System.out.println("Input employee " + i + " number of working days:");
                        int numberOfWorkingDays = sc.nextInt();
                        Employee employeeObj = new Employee(id, name, phoneNumber, numberOfWorkingDays, 100, idOfDepartmentHead);
                        listOfEmployee2.add(employeeObj);
                    }
                    System.out.println("After adding, the employee list of the Department head with Id " + idOfDepartmentHead + "is: ");
                    for (Employee nv : listOfEmployee2){
                        nv.personInfo();
                    }
                }
                break;

            case "3":
                ArrayList<Employee> listOfEmployee3 = listOfAllWorkers.get(2);
                System.out.println("Do you need to change employee's info or delete employee(s) info? Enter change/delete: ");
                String changeOrDelete = sc.next();
                if (changeOrDelete.equalsIgnoreCase("change")){
                    System.out.println("Input employee id need to be change info: ");
                    String id = sc.next();
                    for (int i = 0; i < listOfEmployee3.size(); i++){
                        listOfEmployee3.get(i).personInfo();
                        if (listOfEmployee3.get(i).getId().equals(id)){
                            System.out.println("Input info need to be changed (name/phone number/number of working days):");
                            String infoToBeChange = sc.next();
                            if (infoToBeChange.equalsIgnoreCase("name")){
                                System.out.println("Input employee name: ");
                                String name = sc.nextLine();
                                listOfEmployee3.get(i).setName(name);
                                System.out.println("After changing name, employee with " + id + " has the name as:");
                                listOfEmployee3.get(i).personInfo();
                            }
                        }
                }
                if (changeOrDelete.equalsIgnoreCase("delete")){
                    System.out.println("Input employee id need to be delete info: ");
                    String id = sc.next();
                    for (int i = 0; i < listOfEmployee3.size(); i++) {
                        listOfEmployee3.remove(i);
                    }
                    System.out.println("Employee list after deleting empployee with id " + id + ":");
                    for (Employee nv : listOfEmployee3){
                        nv.personInfo();
                    }
                }
                }

            case "4":
                System.out.println("List of all current workers in the company: ");
                for (int i = 0; i < listOfAllWorkers.size(); i++){
                    System.out.println(listOfAllWorkers.get(i));
                }
                System.out.println("List of all current directors in the company: ");
                ArrayList<Director> directorList4 = listOfAllWorkers.get(0);
                for (int i = 0; i < directorList4.size() ; i++){
                    directorList4.get(i).personInfo();
                }
                System.out.println("List of all current department heads in the company: ");
                ArrayList<DepartmentHead> departmentHeadList4 = listOfAllWorkers.get(1);
                for (DepartmentHead tp : departmentHeadList4){
                    tp.personInfo();
                }
                System.out.println("List of all current employees in the company: ");
                ArrayList<Employee> employeeList = listOfAllWorkers.get(2);
                for (Employee nv : employeeList){
                    nv.personInfo();
                }
                break;

            case "5":
                //the sum of directors' salary
                int sumOfDirectorSalary = 0;
                ArrayList<Director> directorList5 = listOfAllWorkers.get(0);
                for (Director gd : directorList5){
                    sumOfDirectorSalary += gd.getDailySalary() * gd.getNumberOfWorkingDays();
                }
                System.out.println("Sum of directors' salary: " + sumOfDirectorSalary);
                //the sum of DepartmentHead' salary
                int sumOfDepartmentHeadSalary = 0;
                ArrayList<DepartmentHead> departmentHeadList5 = listOfAllWorkers.get(1);
                for (DepartmentHead tp : departmentHeadList5){
                    sumOfDepartmentHeadSalary += tp.getDailySalary() * tp.getNumberOfWorkingDays();
                }
                System.out.println("Sum of Department Heads' salary: " + sumOfDepartmentHeadSalary);
                //the sum of employees' salary
                int sumOfEmployeeSalary = 0;
                ArrayList<Employee> employeeList5 = listOfAllWorkers.get(2);
                for (Employee nv : employeeList5){
                    sumOfEmployeeSalary += nv.getDailySalary() * nv.getNumberOfWorkingDays();
                }
                System.out.println("Sum of Employees' salary: " + sumOfEmployeeSalary);

                System.out.println("Sum of all workers' salary: " + String.valueOf(sumOfDirectorSalary + sumOfDepartmentHeadSalary + sumOfEmployeeSalary));
                break;

            case "6":
                ArrayList<Employee> employeeList6 = listOfAllWorkers.get(2);
                ArrayList<Integer> employeeSalaryList = new ArrayList<>();
                for (Employee nv : employeeList6){
                    employeeSalaryList.add(nv.getDailySalary() * nv.getNumberOfWorkingDays());
                }
                int maxSalaryAmongEmployee = 0;
                int indexOfMaxSalary = 0;
                for (int i = 0; i < employeeSalaryList.size(); i++){
                    if (maxSalaryAmongEmployee < employeeSalaryList.get(i)){
                        maxSalaryAmongEmployee = employeeSalaryList.get(i);
                        indexOfMaxSalary = i;
                    }
                }
                System.out.println("Employee with id " + employeeList6.get(indexOfMaxSalary).getId() + " has the highest salary in this month");
                break;

            case "7":
                ArrayList<DepartmentHead> departmentHeadList7 = listOfAllWorkers.get(1);
                //maxEmployeeNumber = maxNumberOfEmployeesUnderDepartment
                int maxEmployeeNumber = 0;
                //idMax = indexOfDepartmentHeadWithMaxNumberOfEmployees
                int idMax = 0;
                for (int i = 0; i < departmentHeadList7.size(); i++){
                    if (maxEmployeeNumber < departmentHeadList7.get(i).getNumberOfEmployees()){
                        maxEmployeeNumber = departmentHeadList7.get(i).getNumberOfEmployees();
                        idMax = i;
                    }
                }
                System.out.println("Department Head with id " + departmentHeadList7.get(idMax).getId() + " is the one that has" +
                        " the max number of employees under his/her management (" + departmentHeadList7.get(idMax).getNumberOfEmployees() +" employees)" );

            case "8":
                ArrayList<Employee> employeeList8 = listOfAllWorkers.get(2);
                Map<String, Employee> map = new HashMap<>();
                for (int i = 0; i < employeeList8.size(); i++){
                    map.put(employeeList8.get(i).getName(), employeeList8.get(i));
                }
                TreeMap<String, Employee> sorted = new TreeMap<>(map);
                System.out.println("After sorting following ascending alphabetical order, the employee list is: ");
                Iterator<Employee> iterator = sorted.values().iterator();
                while(iterator.hasNext()){
                    iterator.next().personInfo();
                }

            case "9":
                ArrayList<Employee> employeeList9 = listOfAllWorkers.get(2);
                Map<Integer, Employee> sortedSalaryMap = new TreeMap<Integer, Employee>(Collections.reverseOrder());
                for (int i = 0; i < employeeList9.size(); i++){
                    Integer employeeSalary = 100 * employeeList9.get(i).getNumberOfWorkingDays();
                    sortedSalaryMap.put(employeeSalary, employeeList9.get(i));
                }
                System.out.println("After sorting following descending employee's salary order, the employee list is: ");
                Iterator<Employee> salaryIterator = sortedSalaryMap.values().iterator();
                while(salaryIterator.hasNext()){
                    salaryIterator.next().personInfo();
                }
                break;

            case "10":
                ArrayList<Director> directorList10 = listOfAllWorkers.get(0);
                double maxEquity = 0;
                int indexMaxEquity = 0;
                for (int i = 0; i < directorList10.size(); i++){
                    if (maxCoPhanNamGiu < directorList10.get(i).getpercentOfEquity()){
                        maxCoPhanNamGiu = directorList10.get(i).getpercentOfEquity();
                        indexMaxEquity = i;
                    }
                }
                System.out.println("The director that has the max equity is the one that has id: " + directorList10.get(indexMaxEquity).getId());
                break;

            case "11":
                ArrayList<Director> directorList11 = listOfAllWorkers.get(0);
                for (int i = 0; i < directorList11.size(); i++){
                    System.out.println("The director with id " + directorList11.get(i).getId() + " has this month's income is: " + directorList11.get(i).calculateDirectorIncome(directorList11.get(i).getNumberOfWorkingDays()));
                }
                break;
        }
        return listOfAllWorkers;
    }

    public static String chooseAnOption(Scanner sc){
        System.out.println("Functions: ");
        System.out.println("1. Input workers info");
        System.out.println("2. Input employee info under each department head");
        System.out.println("3. Add, delete employee info");
        System.out.println("4. Print out all workers info");
        System.out.println("5- Print out all workers' salary info");
        System.out.println("6. Find the employee with highest salary in this month");
        System.out.println("7. Find the department head with highest number of employees under management");
        System.out.println("8. Print out employee list following ascending alphabetical order of their names");
        System.out.println("9. Print out employee list following descending order of their salaries");
        System.out.println("10. Find the director with highest equity");
        System.out.println("11. Print out each director's income");
        System.out.println("Exit");

        System.out.println("Choose one function: ");
        String option = sc.next();
        return option;
    }


}
