package Model;

import java.util.ArrayList;

public class Player {

    private int foodStock;
    private double money;
    private ArrayList<Dog> pets = new ArrayList<>();

    public Player() {
        foodStock = 50;
        money = 100;
    }

    //buy dog, mobey will decrease
    public void buyADog(Dog newDog) {
        pets.add(newDog);
        money = money - newDog.getPrice();
    }

    public void sellADog(Dog soldDog) {
        pets.remove(soldDog);
        money += soldDog.getPrice();
    }

    public int getPetsNumber() {
        return pets.size();
    }

    public void showPetsNames() {
        int no = 1;
        for (Dog d : pets) {
            System.out.println(no + ". " + d.getName());
            no++;
        }
    }

    public Dog getADog(int index) {
        return pets.get(index);
    }

    public void decreaseFoodStock(int amount) {
        foodStock -= amount;
    }
    
    public void buyFoodStock(int price, int amount) {
        money -= price;
        foodStock += amount;
    }
    
    public double getMoney(){
        return this.money;
    }
    
    public double getFoodStock(){
        return this.foodStock;
    }
}
