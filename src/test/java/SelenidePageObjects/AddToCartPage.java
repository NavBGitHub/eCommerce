package SelenidePageObjects;

import CommonAttributes.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Collection;
import java.util.Collections;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class AddToCartPage {


    public AddToCartPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    }


    By linkShop = By.xpath("//a[text()='Shop']");
    By cartCount = By.xpath("//a[@class='cart-page-link']/span");
    By buttonAddToCart = By.xpath("//button[@name='add-to-cart']");
    By iconShoppingCart = By.xpath("//i[@class='tg-icon tg-icon-shopping-cart']");
    By removeCartItem= By.xpath("//a[@class='remove']");



    public void clickOnShopLink(){
        String productPageTitle;
        $(linkShop)
                .shouldBe(visible).click();

        productPageTitle= title();
        assertEquals("Title of shop page does not matched", Constants.TITLE_SHOP, productPageTitle);
    }

    public void verifyCartCount(int count){
        int cartcount;
        cartcount = Integer.parseInt($(cartCount)
                .shouldBe(visible).getText());

        if(cartcount !=0){
            $(iconShoppingCart)
                    .shouldBe(visible).click();
            $$(removeCartItem)
                    .removeAll(Collections.emptyList());
        }
        sleep(3000);
        cartcount = Integer.parseInt($(cartCount)
                .shouldBe(visible).getText());
        System.out.println(cartcount);
//        assertEquals("cart count does not matched...", count, cartcount);
    }

    public void verifyNewCartCount(int count){
        int cartcount;
        cartcount = Integer.parseInt($(cartCount)
                .shouldBe(visible).getText());
        assertEquals("cart count does not matched...", count, cartcount);
    }

    public void addProductToCart(String product){
        $(By.xpath("//h2[text()='"+product+"']"))
                .shouldBe(visible).click();

        $(buttonAddToCart)
                .shouldBe(visible).click();
    }


}
