package lab3;

public class TestClass {

    private static int id = 1665;
    private long miliseconds = 0;

    public TestClass() {
        this.id++;
        this.miliseconds = System.currentTimeMillis();
    }
    @Override
    public String toString() {
        return "[" + Long.toString(this.id) + " " + Long.toString(this.miliseconds) + "]";
    }

    public static void main(String[] args){
        if(args.length > 0){
            int count = Integer.parseInt(args[0]);
            for(int i=0; i<count; i++){
                TestClass test = new TestClass();
                System.out.println((i+1)+". "+test.toString());
            }
        System.out.println("Liczba obiektów: "+count);
        }
        else {
            System.out.println("Brak argumentów programu.");
        }

    }
}