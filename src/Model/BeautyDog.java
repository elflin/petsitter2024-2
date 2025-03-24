package Model;

public class BeautyDog extends Dog {
    
    //    Attributes
    private double hairLength;
    private String hairColor;
    
//    Constructor
    public BeautyDog(String name){
        super(name);
        this.price = 100;
        this.hairLength = 0;
        this.hairColor = "";
    } 
    
//    Function
    public double getHairLength() {
        return hairLength;
    }

    public String getHairColor() {
        return hairColor;
    }
    
    @Override
    public void bath(){
        this.cleaness = 5;
        hairLength += 0.1;
    }
    
    @Override
    public void showStatus() {
        super.showStatus();
        System.out.println("Hair Length: " + hairLength);
        System.out.println("Hair Colow : " + hairColor);
    }
    
}
