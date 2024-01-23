package SpringCore;

public class Desktop implements Computer{

    @Override
    public void compile() {
        System.out.println("Code compiled in the Desktop");
    }
}
