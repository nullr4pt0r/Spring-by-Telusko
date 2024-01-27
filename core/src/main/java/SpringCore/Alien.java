package SpringCore;

public class Alien {
   private int age;
   public Laptop laptop;



    Alien(){
        System.out.println("Alien Bean Created");
    }
    public void code(){

        System.out.println("I am coding");
        laptop.compile();
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        System.out.println("age assigned via setter");
    }
}
