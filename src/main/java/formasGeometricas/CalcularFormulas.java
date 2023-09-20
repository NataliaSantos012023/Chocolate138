package formasGeometricas;

public class CalcularFormulas {
    public static int MultiplicarQuadrado(int ladoA, int ladoB){
        int multiplicar = ladoA * ladoB;
        System.out.println("Multiplicação de " + ladoA + " * " + ladoB + " = " + multiplicar);
        return multiplicar;

    }

    public static int MultiplicarTriangulo(int base, int altura){
        int area = (base * altura / 2);
        System.out.println("Multiplicação de " + base + " * " + altura  + " = " + area);
        return (base * altura / 2);

    }

    public static int MultiplicarRetangulo( int base, int altura){
        int area = (base * altura);
        System.out.println("Multiplicação de " + base + " * " + altura + " = " + area);
        return area;

    }


    public static double CalcularCirculo(double raio){
        double area = Math.PI * raio * raio;
        System.out.println("Multiplicação de " + raio + " * " + raio + " = " + area );
        return area;



    }







}
