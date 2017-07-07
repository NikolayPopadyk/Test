public abstract class Employee { //найманий працівник
    private int salary; //базовий оклад
    private double experience;
    private String surname;
    private Education level;

    enum Education {
        General_secondary_education, Short_cycle_of_higher_education, First_cycle_of_higher_education,
        Second_cycle_of_higher_education
    }

    public Employee(int salary, double experience, String surname, Education level) {
        this.salary = salary;
        this.experience = experience;
        this.surname = surname;
        this.level = level;
    }
    public abstract void work();
    public abstract double receive_salary(); //отримання з/п

    public void relax() {
        System.out.println(getSurname() + " відпочиває!");
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double getExperience() {
        return experience;
    }

    public String getSurname() {
        return surname;
    }

    public Education getLevel() {
        return level;
    }
}