package br.com.iterasys;

public class AreasAula {

    public static double CalcularQuadrado(double lado) {return Math.pow(lado, 2);}

    public static double CalcularRetangulo(double largura, double comprimento) {return largura * comprimento;}

    public static double CalcularTriangulo(double largura, double comprimento) {return largura * comprimento / 2;}

    public static double CalcularCirculo(double raio) {return Math.PI * Math.pow(raio, 2);}
}

