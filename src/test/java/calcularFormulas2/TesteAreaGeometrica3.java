package calcularFormulas2;

import formasGeometricas.CalcularFormulas;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TesteAreaGeometrica3 {

    @DataProvider(name = " MassaQuadrado")
    public Object[][] MultiplicarQuadrado(){
        return new Object[][]{
                {5, 5, 25}
        };
    }

    @DataProvider(name = " MassaTriangulo")
    public Object[][] MultiplicarTriangulo(){
            return new Object[][]{
                    { 3, 8, 12 }

            };
    }

    @DataProvider(name = " MassaRetangulo")
    public Object[][] MultiplicarRetangulo(){
            return new Object[][]{
                    { 4, 6, 24 }

            };
    }

    @DataProvider(name = " MassaCirculo")
    public Object[][] CalcularCirculo(){
        return new Object[][]{
            { 5, 78.53981633974483 }
        };

    }

    @Test(dataProvider = " MassaQuadrado")
    public void MultiplicarQuadradoDD( int ladoA, int ladoB, int resultadoEsperado) {

        int resultadoAtual = CalcularFormulas.MultiplicarQuadrado(ladoA, ladoB);

        Assert.assertEquals(resultadoAtual, resultadoEsperado);

    }

    @Test(dataProvider = " MassaTriangulo")
    public void MultiplicarTrianguloDD( int base, int altura, int resultadoEsperado){

        int resultadoAtual = CalcularFormulas.MultiplicarTriangulo(base, altura);

        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test(dataProvider = " MassaRetangulo")
    public void MultiplicarRetangulo(int base, int altura, int resultadoEsperado ){

        int resultadoAtual = CalcularFormulas.MultiplicarRetangulo(base, altura);

        Assert.assertEquals(resultadoAtual, resultadoEsperado);

    }

    @Test(dataProvider = " MassaCirculo")
    public void CalcularCirculo(double raio, double resultadoEsperado){

        double resultadoAtual = CalcularFormulas.CalcularCirculo(raio);

        Assert.assertEquals(resultadoAtual, resultadoEsperado);

    }


}





