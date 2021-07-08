package HW_15_quadraticEquation;

public class QuadraticEquation {

    public double a;
    public double b;
    public double c;

    QuadraticEquation(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }
    public double getB() {
        return b;
    }
    public void setB(int b) {
        this.b = b;
    }
    public double getC() {
        return c;
    }
    public void setC(int c) {
        this.c = c;
    }

    private double resQ(){
        double d = b*b - 4*a*c;
        return d;
    }

    public void shoeQE(){
        double d = resQ();
        if (d > 0) {
            double q2 = (-b - Math.sqrt(d))/2*a;
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
