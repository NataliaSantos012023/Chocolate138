package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 public class InventoryPage extends BasePage {
    // Mapeamento

     //@FindBy(css = "span.title") -->DOIS ELEMENTOS IGUAIS, NESTA PÁGINA E NA CARTPAGE.
     //WebElement lblTituloPagina; --> ESSES ELEMENTOS FORAM PARA BASEPAGE

    // @FindBy(id = "item_4_title_link")
    // WebElement lnkTituloProduto;

    // Construtor
    public InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Funções e Métodos

     //public String lerTituloDaPagina() {
     // return lblTituloPagina.getText(); // retorna o que estiver escrito no elemento
     // } --> MESMO CASO, ELEMENTOS IGUAIS EM DUAS PÁGINAS

    public void clicarNoTituloDoProduto(String productId){
        String idDinamico = "item_" + productId + "_title_link";
        driver.findElement(By.id(idDinamico)).click();
    }

 }

