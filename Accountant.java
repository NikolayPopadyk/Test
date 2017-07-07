public class Accountant extends Employee {
    public static int document;
    private int report;
    private boolean program_1c;
    private double coefficient; //коефіцієнт надбавки заробітної плати;

    public Accountant(int salary, double experience, String surname, Education level, boolean program_1c) {
        super(salary, experience, surname, level);
        this.program_1c = program_1c;
    }
    public void work() {
        System.out.println("Бухгалтер " + getSurname() + " почав працювати.");
        documentProcessing();
    }
    private void documentProcessing() {
        if (document > 0) {
            System.out.println(getSurname() + " працює над документами.");
            reportGeneration();
        }
    }
    private void reportGeneration() {
        report++;
        System.out.println(getSurname() + " сформував новий звіт.");
    }

    public double receive_salary() {
        if (getExperience()>=0.5 && getExperience()<2) {
            coefficient+=0.1;
        }
        else if (getExperience()>=2 && getExperience()<4) {
            coefficient+=0.2;
        }
        else if (getExperience()>=4) {
            coefficient+=0.3;
        }
        switch (getLevel()) {
            case Short_cycle_of_higher_education:
                coefficient+=0.05;
                break;
            case First_cycle_of_higher_education:
                coefficient+=0.15;
                break;
            case Second_cycle_of_higher_education:
                coefficient+=0.2;
                break;
        }
        return getSalary()+(getSalary()*coefficient);
    }

    public static int getDocument() {
        return document;
    }

    public int getReport() {
        return report;
    }
}
