package OOPS;

public class Engineer implements Person {

    public String name;
    public int status;
    public int health = 200;

    public Engineer(String str){
        name = str;
    }

    public Engineer(int status){
        this.status = status;

    }



    @Override
    public void prof() {
        System.out.println("soft eng");
    }
}
