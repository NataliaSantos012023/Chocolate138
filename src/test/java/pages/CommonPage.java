package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonPage{

    @FindBy(id = "shopping_cart_container")
    public WebElement imgCarrinho;

    @FindBy(css = "span.title")
    WebElement lblTituloPagina;

    @FindBy(css = "button.btn.btn_primary btn_small.btn_inventory")
    WebElement btnAdicionarNoCarrinho;

    public WebDriver driver;

    public CommonPage(WebDriver driver) {
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
        return btnAdicionarNoCarrinho.getText();
    }

    public void clicarNoBotaoAdicionarOuRemoverDoCarinho(){
        btnAdicionarNoCarrinho.click();
    }

}
