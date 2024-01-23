package SpringCore;

public class Alien {
   private int age;
   public Computer com;

    Alien(int age, Computer com){
        this.age = age;
        this.com = com;
    }
    Alien(int age){
        this.age = age;
    }
    Alien(){
        System.out.println("Alien Bean Created");
    }
    public void code(){

        System.out.println("I am coding");
        com.compile();
    }


    public Computer getCom() {
        return com;
    }

    public void setCom(Computer com) {
        this.com = com;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        System.out.println("age assigned via setter");
    }
}
