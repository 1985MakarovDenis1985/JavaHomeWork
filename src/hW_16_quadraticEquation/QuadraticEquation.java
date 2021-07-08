package hW_16_quadraticEquation;

public class QuadraticEquation {

    public int a;
    public int b;
    public int c;
    public int d = resQ();

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
        return d;
    }

    public void shoeQE(){
        if (d > 0) {
            double q2 = (-b - Math.sqrt(d))/2*a; // => формулу корня нашел к сожалению только в интернете.
            System.out.println("2 корня");
        } else if(d==0){
            double q1 = (-b + Math.sqrt(d))/2*a;
            System.out.println("1 корень");
        }else if (d < 0){
            System.out.println("нет корней");
        }
    }

    public void display(){
        System.out.println("Квадратное уровнение: ");
        System.out.println(a + "x^2+" + b+"x+" + c + "=0");
    }

    public static void main(String[] args) {
        QuadraticEquation qEquation = new QuadraticEquation(7,5,-6);
        qEquation.display();
        qEquation.shoeQE();
    }
}
