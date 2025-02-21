package Model;

public class Dog {

    //    Attibute
    private String name;
    private int happiness, fullness, cleaness, health, intelligence, food_amount, age, price;
    private boolean die;

    //    Constructor: Function that is run when class became an object
    public Dog() {
        name = "";
        happiness = 3;
        fullness = 3;
        cleaness = 3;
        health = 3;
        intelligence = 0;
        food_amount = 10;
        age = 0;
        price = 50;
        die = false;
    }

    //    Function Overloading
    public Dog(String name) {
        this.name = name;
        happiness = 3;
        fullness = 3;
        cleaness = 3;
        health = 3;
        intelligence = 0;
        food_amount = 10;
        age = 0;
        price = 50;
        die = false;
    }

    //  Function/Behavior
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    
    public void play() {
        happiness += 2;
        cleaness -= 2;
        fullness--;
        this.setDie();
    }

    public void train() {
        happiness -= 2;
        intelligence++;
        fullness--;
        this.setDie();
    }

    public void eat() {
        fullness = 5;
        this.setDie();
    }

    public void bath() {
        cleaness = 5;
        happiness -= 3;
        this.setDie();
    }

    public void sleep() {
        fullness--;
        intelligence--;
        health++;
        age += (float) 0.5;
        this.setDie();
    }

    public void showStatus() {
        System.out.println("\n" + name + " Status");
        System.out.println("happiness: " + happiness);
        System.out.println("fullness: " + fullness);
        System.out.println("Cleaness: " + cleaness);
        System.out.println("health: " + health);
        System.out.println("intelligence: " + intelligence);
        System.out.println("age: " + age);
        System.out.println("price: " + price);
    }

    private void UpperLimit() {
        if (this.happiness >= 5) {
            this.happiness = 5;
        }

        if (this.fullness >= 5) {
            this.fullness = 5;
        }

        if (this.cleaness >= 5) {
            this.cleaness = 5;
        }

        if (this.health >= 5) {
            this.health = 5;
        }
    }

    private void BottomLimit() {
        if (this.happiness < 0) {
            this.happiness = 0;
        }

        if (this.fullness < 0) {
            this.fullness = 0;
        }

        if (this.cleaness < 0) {
            this.cleaness = 0;
        }

        if (this.health < 0) {
            this.health = 0;
        }

        if (this.intelligence < 0) {
            this.intelligence = 0;
        }
    }

    private void setDie() {

        UpperLimit();
        BottomLimit();

        if (this.fullness < 3 || this.cleaness < 2) {
            this.health -= 1;
        }

        if (this.health <= 0) {
            this.health = 0;
            this.die = true;
        }
    }

    public boolean isDie() {
        return die;
    }
}
