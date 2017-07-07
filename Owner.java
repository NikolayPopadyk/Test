import java.util.List;

public class Owner implements ReceiveReward {
    private String surname;

    private Owner() {
    }

    private static class SingletonOwner {
        private static Owner instance = new Owner();
    }

    public static Owner getInstance() {
        return SingletonOwner.instance;
    }

    public void layOff(Employee human, List allEmployee) {
        for (int i = 0; i<allEmployee.size(); i++) {
            if (allEmployee.get(i).equals(human)) {
                System.out.println(getSurname() + " звільнив " + allEmployee.get(i).getClass().getName());
                allEmployee.remove(i);
            }
        }
    }
    public <T> void haveReward(T ... args) { //отримання нагород за успішну діяльність компанії
        for (T reward : args) {
            System.out.println(getSurname() + " нагороджений " + reward);
        }
    }
    public void signContract() {
        if(CompanyActivity.getQuantity_product() < 5) {
            System.out.println("Власник " +getSurname() + " підписав договір на поставку продукції");
            CompanyActivity.deliveryProduct(100);
        }
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
}
