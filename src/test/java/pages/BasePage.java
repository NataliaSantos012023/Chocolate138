package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {

    @FindBy(id = "shopping_cart_container")
    WebElement imgCarrinho;

    @FindBy(css = "span.title")
    WebElement lblTituloPagina;

    @FindBy(css = "button.btn btn_primary btn_small btn_inventory")
    WebElement btnAdicionarOuRemoverDoCarrinho;

    public WebDriver driver;

    public BasePage(WebDriver driver) {

        this.driver = driver;
    }

    // Função para retornar o titulo escrito na guia do browser
    public String LerTituloAba(){

        return driver.getTitle();
    }

    public void clicarNoCarrinho(){
        imgCarrinho.click();  // clicar na imagem do carrinho
    }

    public String lerTituloDaPagina() {
        return lblTituloPagina.getText(); // retorna o que estiver escrito no elemento
    }

    // Esta função e apenas um exemplo, ela não vai ser usada no exercício
    public String lerTextoDoBotaoAdicionarOuRemoverDoCarrinho(){
        return btnAdicionarOuRemoverDoCarrinho.getText();
    }

    public void clicarNoBotaoAdicionarOuRemoverDoCarinho(){
        btnAdicionarOuRemoverDoCarrinho.click();
    }

}
