package br.com.iterasys;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AreasAulaTest {

    @Test

    public void testarCalcularQuadrado(){
        //Configura
        double lado = 3;
        double resultadoEsperado = 9;

        //Executa
        Double resultadoAtual = AreasAula.CalcularQuadrado(lado);

        //Valida

        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }




    @Test

    public void testarCalcularRetangulo(){
        double largura = 3;
        double comprimento = 4;
        double resultadoEsperado = 12;

        double resultadoAtual = AreasAula.CalcularRetangulo(largura, comprimento);

        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test

 public void testarCalcularTriangulo(){

        double largura = 3;
        double comprimento = 4;
        double resultadoEsperado = 6;

    double resultadoAtual = AreasAula.CalcularTriangulo(largura, comprimento);

    Assert.assertEquals(resultadoAtual, resultadoEsperado);
}

 @Test

    public void testarCalcularCirculo(){

        double raio = 3;
        double resultadoEsperado = Math.PI * Math.pow(raio, 2);

     double resultadoAtual = AreasAula.CalcularCirculo(raio);


     Assert.assertEquals(resultadoAtual, resultadoEsperado);
 }



}