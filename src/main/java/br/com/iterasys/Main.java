package br.com.iterasys;

import formasGeometricas.CalcularFormulas;

public class Main {

    

    public static void main(String[] args) {
        System.out.println("Olá Mundo");
        chamarEncomenda();
        Calculadora.somarInteiros(5,7);
        Calculadora.subtrairInteiros(7,5);
        Calculadora.multiplicarInteiros(2,3);
        Calculadora.dividirInteiros(8,2);
        CalcularFormulas.MultiplicarQuadrado(5,5);
        CalcularFormulas.MultiplicarTriangulo(3,8);
        CalcularFormulas.MultiplicarRetangulo(4, 6);
        CalcularFormulas.CalcularCirculo(5);








    }




    public static void chamarEncomenda(){
        int barras = 30;

        Encomenda.calcularBarrasDeChocolatesPorCaixa(barras);
    }

    public static void chamarCalcularFormulaso(){
        int ladoA = 5;
        int ladoB = 5;
        int base = 3;
        int altura = 8;
        int baseRebtangulo = 4;
        int baseRetangulo = 6;
        double raio = 5;






    }


}




























