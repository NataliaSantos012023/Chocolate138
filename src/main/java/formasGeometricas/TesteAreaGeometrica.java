package formasGeometricas;

 public class TesteAreaGeometrica {


    public static void main(String[] args) {
        int ladoB = 5;
        int ladoA = 5;
        System.out.println("AreaDoQuadrado: " + CalcularFormulas.MultiplicarQuadrado(ladoA, ladoB));

        int base = 3;
        int altura = 8;
        System.out.println("AreaDoTriângulo: " + CalcularFormulas.MultiplicarTriangulo(base, altura));

        int baseRetangulo = 4;
        int alturaRentangulo = 6;
        System.out.println("AreaDoRetangulo: " + CalcularFormulas.MultiplicarRetangulo(base, altura));

        double raio = 5;
        System.out.println("AreaDoCirculo: " + CalcularFormulas.CalcularCirculo(5));



    }
 }

