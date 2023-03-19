package StepDefinitions;

import SelenidePageObjects.AddToCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;


public class AddToCartStepDefinitions {

    private final AddToCartPage addToCartPage;

    public AddToCartStepDefinitions(){
        addToCartPage=new AddToCartPage(CommonStepData.driver);
    }

    @Given("I click on Shop link on Home Page")
    public void iClickOnShopLinkOnHomePage() {
        addToCartPage.clickOnShopLink();
    }

    @And("^I verify the cart count as (.+)$")
    public void iVerifyTheCartCountAsOldCartCount(int count) {
        addToCartPage.verifyCartCount(count);
    }

    @And("^I verify the new cart count as (.+)$")
    public void iVerifyTheNewCartCountAsOldCartCount(int count) {
        addToCartPage.verifyNewCartCount(count);
    }

    @And("^I added (.+) to cart$")
    public void iAddedProductToCart(String product) {
        addToCartPage.addProductToCart(product);
    }
}
