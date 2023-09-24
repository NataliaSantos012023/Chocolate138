package stepsPO;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.Base;


import java.time.Duration;

public class Hooks {
    static Base base;

    public Hooks(Base base){
        this.base = base;
    }

    @Before // Execute antes de todos os blocos de passos --> usar do Cucumber
    public static void setUp() {
        ChromeOptions options = new ChromeOptions(); // Instancia o objeto de opções do ChromeDriver
        options.addArguments("--remote-allow-origins=*"); // Permite qualquer origem remota
        WebDriverManager.chromedriver().setup(); // Baixarr a versão mais atual do Chrome


        base.driver = new ChromeDriver(options); // instancia o objeto do Selenium como ChromeDriver

        // Estabelece uma espera implicita de 5 segundos para o carregar qualquer elemento
        base.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        base.driver.manage().window().maximize(); // Maximiza a janela do navegador
    }

    @After // Executa depois de todos os blocos de passos --> Usar do Cucumber
    public void tearDown() {
        base.driver.quit();   // Encerrar o Objeto Selenium Driver
    }
}
