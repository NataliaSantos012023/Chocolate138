     // 1 - Pacote
package br.com.iterasys;
     // 2 - Biblioteca
import juntos.Calculadora2;
import org.testng.Assert;
import org.testng.annotations.Test;
     // 3 - Classe
public class Calculadora2Test {
     // 3.1 - atributos

     //3.2 - Métodos e Funções


    @Test
    public void testesomar(){
        // Configura - Arrange
         double num1 = 5;
         double num2 = 7;
         double resultadoEsperado = 12;

        // Executa - Act
         double resultadoAtual = Calculadora2.somar(num1, num2);

        // Valida - Assert
        Assert.assertEquals(resultadoAtual, resultadoEsperado);

    }

    @Test
    public void testeSubtrair() {
        // Arrange
        double num1 = 7;
        double num2 = 5;
        double resultadoEsperado = 2;

        // Act
        double resultadoAtual = Calculadora2.subtrair(num1, num2);

        // Assert
        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test
    public void testeMultiplicar() {
        // Arrange
        double num1 = 7;
        double num2 = 5;
        double resultadoEsperado = 35;

        // Act
        double resultadoAtual = Calculadora2.multiplicar(num1, num2);

        // Assert
        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }


    @Test
    public void testeDividir() {
        // Arrange
        double num1 = 8;
        double num2 = 2;
        double resultadoEsperado = 4;

        // Act
        double resultadoAtual = Calculadora2.dividir(num1, num2);

        // Assert
        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test
    public void testeDividirPorZero() {
        // Arrange
        double num1 = 8;
        double num2 = 0;
        double resultadoEsperado = Double.NaN;

        // Act
        double resultadoAtual = Calculadora2.dividir(num1, num2);

        // Assert
        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }
}
