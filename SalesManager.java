import java.util.ArrayList;
import java.util.Random;

public class SalesManager extends Employee implements ReceiveReward {
    private int client;
    private int sold_product;
    private boolean english;
    private double coefficient; //коефіцієнт надбавки заробітної плати;

    public SalesManager(int salary, double experience, String surname, Education level, boolean english) {
        super(salary, experience, surname, level);
        this.english = english;
    }

    public void work() {
        System.out.println("Менеджер " + getSurname() + " почав працювати.");
        giveConsult();
    }
    private void giveConsult() {
        System.out.println("Менеджер " + getSurname() + " надає консультацію клієнту.");
        client++;
        if (Math.random()*10 > 2) {
            System.out.println("Консультація пройшла успішно і менеджер " + getSurname() + " продає продукцію компанії!");
            trade(new Random().nextInt(5));
        }
    }
    private void trade(int order) {
        if (CompanyActivity.getQuantity_product() >= order) { //перевірка наявності товару в достатній кількості
            Accountant.document++;
            CompanyActivity.sell(order);
            sold_product += order;
        }
    }

    public double receive_salary() { //отримання заробітної плати
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
        coefficient += english == true ? 0.35 : 0;

        if (sold_product >= 20) {
            coefficient+=0.3;
        }
        else if (sold_product >= 35) {
            coefficient+=0.45;
        }
        return getSalary()+(getSalary()*coefficient);
    }
    public <T> void haveReward(T ... args) {
        ArrayList<T> reward = new ArrayList<>();
        if (args.length > 0) {
            for (int i =0; i<args.length; i++) {
                reward.add(args[i]);
            }
        }
        System.out.println(getSurname() + " отримав всі свої нагороди!");
    }

    public int getClient() {
        return client;
    }

    public int getSold_product() {
        return sold_product;
    }

    public boolean isEnglish() {
        return english;
    }
}

