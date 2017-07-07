import java.util.ArrayList;

public class CompanyActivity {
    private static int quantity_product; //кількість продукції в компанії

    public static void main(String[] args) {
        Owner owner = Owner.getInstance();
        owner.setSurname("Романчук");
        SalesManager salesManager1 = new SalesManager(3200, 1.5, "Makarenko", Employee.Education.First_cycle_of_higher_education, true);
        Accountant accountant = new Accountant(4000, 2, "Melnik", Employee.Education.Second_cycle_of_higher_education, true);
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(salesManager1);
        employees.add(accountant);
        salesManager1.work();
        salesManager1.relax();
        System.out.println(salesManager1.getSurname() + " отримав " + salesManager1.receive_salary());
        salesManager1.haveReward(1000);
        accountant.work();
        accountant.relax();
        System.out.println(accountant.getSurname() + " отримав " + accountant.receive_salary());
        owner.signContract();
        owner.layOff(salesManager1, employees);
        SalesManager salesManager2 = new SalesManager(3200, 3, "Kvitko", Employee.Education.First_cycle_of_higher_education, true);
        owner.haveReward("званням кращого підприємця!", "почесним дипломом!");
    }
    public static int getQuantity_product() {
        return quantity_product;
    }
    public static void sell (int quantity) {
        quantity_product -= quantity;
    }
    public static void deliveryProduct(int quantity) {
        if (quantity_product < 5) {
            quantity += quantity_product;
        }
    }
}
