package calcularFormulas2;

import formasGeometricas.CalcularFormulas;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TesteAreaGeometrica2 {

    @Test
    public void MultiplicarQuadrado() {
        int ladoA = 5;
        int ladoB = 5;
        int resultadoEsperado = 25;

        int resultadoAtual = CalcularFormulas.MultiplicarQuadrado(ladoA, ladoB);

        Assert.assertEquals(resultadoAtual, resultadoEsperado);



    }

    @Test
    public void MultiplicarTriangulo(){
        int base = 3;
        int altura = 8;
        int resultadoEsperado = 12;

        int resultadoAtual = CalcularFormulas.MultiplicarTriangulo(base, altura);

        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test
    public void MultiplicarRetangulo(){
        int base = 4;
        int altura = 6;
        int resultadoEsperado = 24;

        int resultadoAtual = CalcularFormulas.MultiplicarRetangulo(base, altura);

        Assert.assertEquals(resultadoAtual, resultadoEsperado);



    }

   @Test
    public void CalcularCirculo(){
        double raio = 5;
        double resultadoEsperando = 78.53981633974483;

        double resultadoAtual = CalcularFormulas.CalcularCirculo(raio);

        Assert.assertEquals(resultadoAtual, resultadoEsperando);

    }




}



