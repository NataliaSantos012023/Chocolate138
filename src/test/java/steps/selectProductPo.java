package steps;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import pages.BasePage;
import pages.HomePage;
import pages.InventoryPage;
import pages.InventoryItemPage;
import pages.CartPage;


public class selectProductPo {

    // Atributos
    // Selenium sempre tem um atributo (Objeto)
    // Objeto para guardar o driver -> WebDriver

    //Classe - Objeto = Objeto herda da classe
    final WebDriver driver; // este é objeto final do Selenium (Uma única bola em campo)
    static String userForCookie;

     // Definindo os objetos para receber os mapeamnetos de páginas já importados
    private HomePage homePage;
    private InventoryPage inventoryPage;
    private InventoryItemPage inventoryItemPage;
    private CartPage cartPage;

    private static BasePage basePage;

    // Construtor
    public selectProductPo(BasePage basePage){
        this.driver = basePage.driver; // Passagem de bola = integração Selenium dentro e fora
    }


    @BeforeAll // Execute antes de todos os blocos de passos --> usar do Cucumber
    public static void setUp() {
        ChromeOptions options = new ChromeOptions(); // Instancia o objeto de opções do ChromeDriver
        options.addArguments("--remote-allow-origins+*"); // Permite qualquer origem remota
        WebDriverManager.chromedriver().setup(); // Baixarr a versão mais atual do Chrome

        basePage = new BasePage(this.driver);  // Instancia Base com o Driver
        homoPage = new HomePage(this.driver);  // Instancia a HomePage

        basePage.driver = new ChromeDriver(options); // instancia o objeto do Selenium como ChromeDriver

        // Estabelece uma espera implicita de 5 segundos para o carregar qualquer elemento
        basePage.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        basePage.driver.manage().window().maximize(); // Maximiza a janela do navegador
    }

    @AfterAll// Executa depois de todos os blocos de passos --> Usar do Cucumber
    public static void tearDown() throws InterruptedException {

        basePage.driver.quit();   // Encerrar o Objeto Selenium Driver
    }

    @Given("I access SauceDemo store PO")
    public void i_access_sauce_demo_store() {
        driver.get("https://www.saucedemo.com");
    }

    @When("I filled a user {string} and password {string} PO")
    public void i_filled_a_user_and_password(String user, String password) {
        homePage.Logar(user, password);

    }

    @And("I click in Login PO")
    public void i_click_in_login() {
        driver.findElement(By.id("login-button")).click(); // clico no botão login
    }

    //@Then("show page's title {string}")
    @Then("I verify the page's title {string} PO")
    public void show_page_s_title(String pageTitle) {
        // Verifica se o titulo da página coincide com o informado na feature
        assertEquals(driver.findElement(By.cssSelector("span.title")).getText(), pageTitle);
    }

    @And("show cart's link PO")
    public void show_cart_s_link() {
        // Verifica se o elemento do carrinho de compras esta visivel
       assertTrue(driver.findElement(By.id("shopping_cart_container")).isDisplayed());
    }

    @When("I click in product {string} PO")
    public void i_click_in_product(String productId) {
        // Clica no elemento correspondente ao código do produto informado na feature
        driver.findElement(By.id("item_" + productId + "_title_link")).click();
    }

    @Then("I verify the product title {string} PO")
    public void i_verify_the_product_title(String productTitle) {
        // Verifica se o titulo do produto corresponde ao informado na feature
        assertEquals(driver.findElement(By.cssSelector("div.inventory_details_name.large_size")).getText(),
                productTitle);
    }

    @And("I verify the product price {string} PO")
    public void i_verify_the_product_price(String productPrice) {
        // Verifica se o preço do produto corresponde ao informado na feature
        assertEquals(driver.findElement(By.cssSelector("div.inventory_details_price")).getText(), productPrice);
    }

    @And("I click in add to cart PO")
    public void i_click_in_add_to_cart() {
        // Clica no botão de adicionar no carrinho
       // driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.cssSelector("button.btn.btn_primary.btn_small.btn_inventory")).click();
    }

    @And("I click in Cart icon PO")
    public void i_click_in_cart_icon() {
        // Clica no icone do carrinho de compras
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    @Then("I verify the product title {string} in cart PO")
    public void i_verify_the_product_title_in_cart(String productTitle) throws InterruptedException {

        List<WebElement> Lista = driver.findElements(By.cssSelector("div.inventory_item_name"));

        for (int i = 1; i < Lista.size() ; i++) {
            driver.findElement(By.cssSelector("button.btn.btn_secondary.btn_small.cart_button")).click();
        }

        assertEquals(driver.findElement(By.cssSelector("div.inventory_item_name")).getText(),
         productTitle);
        Thread.sleep(2000);

    }

    @And("I verify the quantity is {string} PO")
    public void i_verify_the_quantity_is(String quantity) {
        // Verifica se a quantidade corresponde a feature
        assertEquals(driver.findElement(By.cssSelector("div.cart_quantity")).getText(), quantity);
    }

    @Then("I verify the product price {string} in cart PO")
    public void i_verify_the_product_price_in_cart(String productPrice){
        assertEquals(driver.findElement(By.cssSelector("div.inventory_item_price")).getText(),
                productPrice);
    }

}
