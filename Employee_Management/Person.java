public class Person implements Comparable<Person> {
    private String id;
    private String name;
    private String phoneNumber;
    private int numberofWorkingDays;
    private int dailySalary;

    public Person(String id, String name, String phoneNumber, int numberofWorkingDays, int dailySalary) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.numberofWorkingDays = numberofWorkingDays;
        this.dailySalary = dailySalary;
    }
    
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getNumberOfWorkingDays() {
        return numberofWorkingDays;
    }

    public int getDailySalary() {
        return dailySalary;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setNumberOfWorkingDays(int numberofWorkingDays) {
        this.numberofWorkingDays = numberofWorkingDays;
    }

    public void setDailySalary(int dailySalary) {
        this.dailySalary = dailySalary;
    }
    //toString
    public void personInfo(){
        System.out.println("Id:" + this.getId() + " Name:"  + this.getName() + " Phone number:" + this.getPhoneNumber() + " Number of working days:" + this.getNumberOfWorkingDays() + " Daily salary:" + this.getDailySalary());
    }

    @Override
    public int compareTo(Person o) {
        return (int)(this.getId().compareTo(o.getId()));
    }
}
