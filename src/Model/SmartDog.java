package Model;

public class SmartDog extends Dog {
    
    private int lipi; //this is not an atribute. This is just a helpful variable to check the increasing price;
    private boolean dec3yo, dec7yo; //these are not attributes of Dog. They are help variables to check whether proce has been decreased once the dog reaches age of 3 and 7 yoa
    

    public SmartDog(String name) {
        super(name);
        this.price = 60;
        this.food_amount = 15;
    }

    @Override
    public void train() {
        intelligence += 2;
        fullness -= 1;
        if (happiness < 0) {
            happiness = 0;
        }
        if (fullness < 0) {
            fullness = 0;
        }
        if (intelligence > 100) {
            intelligence = 100;
        }
        //For each 10 point intelligence increase, the price will be increased by 10%
        changePrice();
        //When dogs’ fullness is below 3 or cleniness is below 2, then their helth decreases by 1
        if (fullness < 3) {
            health -= 1;
        }
        if (health <= 0) {
            die = true;
        }
    }
    
    //this is a method that only be invoked inside this class, that is why it is private.
    //this method will change price of a dog based on its age and intelligence
    protected void changePrice() {
        //price will increase 10% when intelligence increase by 10.
        if (intelligence - lipi >= 10) {
            price += 0.1 * price;
            lipi = intelligence;
        }

        if (age > 7) {
            if (!dec7yo) {
                price -= 0.5 * price;
                dec7yo = true; // make it true so the price won't keep decreasing.
            }
        } else if (age > 3) {
            if (dec3yo == false) {
                price -= 0.25 * price;
                dec3yo = true; // make it true so the price won't keep decreasing.
            }
        }

    }
}
