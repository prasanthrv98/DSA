package OOPS;

public class Demo {

    public static void main(String[] args) {

        Person obj1 = new Engineer("rv");
        Engineer eng = new Engineer(1);

        System.out.println();

        Car obj = new Car() {
            @Override
            void engine() {
                System.out.println("engine method");
            }
        };

        obj.engine();
    }
}
