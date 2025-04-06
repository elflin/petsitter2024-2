package Logic;

import Model.BeautyDog;
import Model.Dog;
import Model.Player;
import Model.SmartDog;
import java.util.Scanner;

public class Game {

    private Dog myActiveDog;
    private Player currentPlayer;
    private Scanner scan;

    public Game() {
        this.scan = new Scanner(System.in);
        this.myActiveDog = null;
        this.currentPlayer = new Player();
    }

    public Player Start(Player currentPlayer) {
        int action = 0;
        this.currentPlayer = currentPlayer;

        System.out.println("~~WELCOME TO PETSITTER~~");

        do {
            System.out.println("\n\n--MENU--");
            System.out.println("1. Buy Pet");
            System.out.println("2. Sell A Dog");
            System.out.println("3. Change Dog");
            System.out.println("4. play with Pet");
            System.out.println("5. Train Pet");
            System.out.println("6. Bath Pet");
            System.out.println("7. Feed Pet");
            System.out.println("8. Let Pet Sleep");
            System.out.println("9. Sell Pet");
            System.out.println("10. Show Pet Status");
            System.out.println("11. Buy food stock");
            System.out.println("0. Logout");
            System.out.print("Choose you action: ");
            action = scan.nextInt();
            System.out.println("");

            if (myActiveDog == null) {
                switch (action) {
                    case 1 -> {
                        System.out.println("Buying a dog cost 50. Your current money is " + this.currentPlayer.getMoney());

                        int dogKindInput = 0;
                        Dog newDog = null;

                        do {
                            System.out.println("What kind of dog do you want to buy?");
                            System.out.println("1. Regular Dog");
                            System.out.println("2. Smart Dog");
                            System.out.println("3. Beauty Dog");
                            System.out.println("Choose:");
                            dogKindInput = scan.nextInt();
                        } while (dogKindInput < 1 || dogKindInput > 3);

                        System.out.print("Enter your pet's name: ");
                        String dogName = scan.next() + scan.nextLine();

                        switch (dogKindInput) {
                            case 1 ->
                                newDog = new Dog(dogName);
                            case 2 ->
                                newDog = new SmartDog(dogName);
                            case 3 ->
                                newDog = new BeautyDog(dogName);
                        }

                        this.currentPlayer.buyADog(newDog);
                        this.myActiveDog = newDog;
                        System.out.println("Hai, " + myActiveDog.getName());
                    }
                    case 0 ->
                        System.out.println("~~THANK YOU FOR PLAYING PETSITTER~~");
                    default ->
                        System.out.println("Please buy a pet first before");
                }
            } else {
                switch (action) {
                    case 1 -> {
                        System.out.println("Buying a dog cost 50. Your current money is " + this.currentPlayer.getMoney());

                        if (this.currentPlayer.getMoney() >= 50) {
                            int dogKindInput = 0;
                            Dog newDog = null;

                            do {
                                System.out.println("What kind of dog do you want to buy?");
                                System.out.println("1. Regular Dog");
                                System.out.println("2. Smart Dog");
                                System.out.println("3. Beauty Dog");
                                System.out.println("Choose:");
                                dogKindInput = scan.nextInt();
                            } while (dogKindInput < 1 || dogKindInput > 3);

                            System.out.print("Enter your pet's name: ");
                            String dogName = scan.next() + scan.nextLine();

                            switch (dogKindInput) {
                                case 1 ->
                                    newDog = new Dog(dogName);
                                case 2 ->
                                    newDog = new SmartDog(dogName);
                                case 3 ->
                                    newDog = new BeautyDog(dogName);
                            }

                            this.currentPlayer.buyADog(newDog);
                            this.myActiveDog = newDog;
                            System.out.println("Hai, " + myActiveDog.getName());
                        } else {
                            System.out.println("Sorry you dont have enough money (" + this.currentPlayer.getMoney() + ")");
                        }
                    }
                    case 2 -> {
                        if (myActiveDog == null) {
                            System.out.println("Choose a dog first!!");
                        } else {
                            this.currentPlayer.sellADog(myActiveDog);
                            System.out.println("You have sold a dog named " + myActiveDog.getName());
                            myActiveDog = null;
                        }
                    }
                    case 3 -> {
                        this.currentPlayer.showPetsNames();
                        System.out.println("Choose the number");
                        int nomor = scan.nextInt();
                        this.myActiveDog = currentPlayer.getADog(nomor - 1);
                        System.out.println("You are now interacting wih " + myActiveDog.getName());
                    }
                    case 4 -> {
                        System.out.println(myActiveDog.getName() + " is playing");
                        myActiveDog.play();
                        myActiveDog = this.isPetDie(myActiveDog);
                    }
                    case 5 -> {
                        System.out.println(myActiveDog.getName() + " trained ");
                        myActiveDog.train();
                        myActiveDog = this.isPetDie(myActiveDog);
                    }
                    case 6 -> {
                        System.out.println(myActiveDog.getName() + " bathed ");
                        myActiveDog.bath();
                        myActiveDog = this.isPetDie(myActiveDog);
                    }
                    case 7 -> {
                        if (this.currentPlayer.getFoodStock() >= this.myActiveDog.getFood_amount()) {
                            System.out.println(myActiveDog.getName() + " feed ");
                            this.currentPlayer.decreaseFoodStock(myActiveDog.getFood_amount());
                            myActiveDog.eat();
                            myActiveDog = this.isPetDie(myActiveDog);
                        } else {
                            System.out.println("Not Enough food stock");
                        }
                    }
                    case 8 -> {
                        System.out.println(myActiveDog.getName() + " is sleeping");
                        myActiveDog.sleep();
                        myActiveDog = this.isPetDie(myActiveDog);
                    }
                    case 9 -> {
                        System.out.print("Would you like to sell " + myActiveDog.getName() + "? [Y/N]");
                        char sell = scan.next().charAt(0);
                        if (sell == 'y' || sell == 'Y') {
                            myActiveDog = null;
                            System.out.println("You sell your pet");
                        }
                    }
                    case 10 ->
                        myActiveDog.showStatus();
                    case 11 -> {
                        this.currentPlayer.buyFoodStock(20, 10);
                    }

                    case 0 ->
                        System.out.println("~~THANK YOU FOR PLAYING PETSITTER~~");
                    default ->
                        System.out.println("Action not available");
                }
            }
        } while (action != 0);

        return this.currentPlayer;
    }

    private Dog isPetDie(Dog myActiveDog) {
        myActiveDog.showStatus();

        if (myActiveDog.isDie()) {
            System.out.println(myActiveDog.getName() + " dead");
            return null;
        }

        return myActiveDog;
    }
}
