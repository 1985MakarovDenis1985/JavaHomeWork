package hW_16_quadraticEquation;

public class QuadraticEquation {

    public int a;
    public int b;
    public int c;

    QuadraticEquation(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }
    public int getB() {
        return b;
    }
    public void setB(int b) {
        this.b = b;
    }
    public int getC() {
        return c;
    }
    public void setC(int c) {
        this.c = c;
    }

    private int resQ(){
        int d = b*b - 4*a*c;
        System.out.println(d);
        return d;
    }

    public void shoeQE(){
        int d = resQ();
        if (d > 0) {
            System.out.println("2 корня");
        } else if(d==0){
            System.out.println("1 корень");
        }else {
            System.out.println("нет корней");
        }
    }

    public void display(){
        System.out.println("Квадратное уровнение: ");
        System.out.println(a + "x^2+" + b+"x+" + c);
    }


    public static void main(String[] args) {
//        a.QuadraticEquation qEquation = new a.QuadraticEquation(10,-10, 10);
//        qEquation.display();
//        qEquation.resQ();
//        qEquation.shoeQE();
    }
}
