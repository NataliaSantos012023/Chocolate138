// 1 Pacote
package webtest;

// 2 Biblioteca
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

// 3 Classes
 public class seleniumSimples {
    // 3.1 Atributos
    WebDriver driver; // Objeto do Selenium WebDriver


    // 3.2 Funções e Métodos de apoio
    // Não vamos criar

    // 3.3 Antes do Teste
    @BeforeMethod
    public void setUp(){
        // Instalar e configurar o driver do navegador/browser
        WebDriverManager.chromedriver().setup();

        // Configurar as opções para o driver do navegador(a partir do selenium 4.8.0)
        ChromeOptions options = new ChromeOptions(); // objeto de configuração para o chrome Driver
        options.addArguments("--remote-allow-origins=*"); // permitir qualquer origem remota

        // Instaciar o Selenium com driver de um navegador especifico
        driver =  new ChromeDriver(options); // Instancia o Selenium para o chrome Driver com opções
        // Configura o tempo geral de espera de elementos em até 5 segundos
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize(); // maximiza a janela do navegador

    }

    // 3.4 Depois do teste
    @AfterMethod
    public void tearDown(){
        driver.quit(); // destroi o objeto do selenium WebDriver
    }

    // 3.5 Teste em Si
    @Test
    public void testarSelectBackdrop(){ // Selecionar mochila
        driver.get("https://www.saucedemo.com");

        // Digitar o usuário e senha
        // Clicar no elemento antes de escrever
        WebElement username = driver.findElement(By.id("user-name")); // Controla a caixa de texto
        username.click(); // clica na caixa de texto username
        username.clear(); // Limpa a caixa de texto
        username.sendKeys("standard_user"); // escreve na caixa de texto (colar o texto)
        //username.sendKeys(Keys.chord("standard_user")); // escreve na caixa de texto (letra por letra)

        driver.findElement(By.id("password")).sendKeys("secret_sauce"); // Digitar a senha

        driver.findElement(By.id("login-button")).click(); // Clicar na caixa Login

        // Transição de  página / Carregamento de nova página (lentidão)

        // Verificar se estamos na página interna (se conseguimos antrar)
        // Verifica a palavra "Products" em determinado elemento
        assertEquals(driver.findElement(By.cssSelector("span.title")).getText(), "Products");
        // Verifica se está presente o elemnto do carinho de compras
        assertTrue(driver.findElement(By.id("shopping_cart_container")).isDisplayed());
        // Transição de tela para a página do produto

        driver.findElement(By.id("item_4_title_link")).click();

        // Validar o nome e o valor
        assertEquals(driver.findElement(By.cssSelector("div.inventory_details_name.large_size")).getText(),
               "Sauce Labs Backpack");
        assertEquals(driver.findElement(By.cssSelector("div.inventory_details_price")).getText(),
               "$29.99");

        // clicar no botão Adicionar no Carrinho
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        // Clicar no carrinho, para verificar a compra
        driver.findElement(By.id("shopping_cart_container")).click();

        // Outra transição/carregamento de página

        // Verificar o Titulo de Página, nome do produto, quantidade e preço

        assertEquals(driver.findElement(By.cssSelector("span.title")).getText(),"Your Cart");
        assertEquals(driver.findElement(By.id("item_4_title_link")).getText(), "Sauce Labs Backpack");
        assertEquals(driver.findElement(By.cssSelector("div.cart_quantity")).getText(), "1");
        assertEquals(driver.findElement(By.cssSelector("div.inventory_item_price")).getText(), "$29.99");

    }
 }
