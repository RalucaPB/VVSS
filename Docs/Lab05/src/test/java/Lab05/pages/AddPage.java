package Lab05.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://www.elefant.ro/carti/carte/fictiune/moderni-contemporani/hotul-de-carti-157982.html")
public class AddPage extends PageObject {



    @FindBy(className = "product-adauga-in-cos-text")
    private WebElementFacade citit;


    public AddPage() {
    }


    public void click_citit() {
        citit.click();
    }


    public String getTitle() {
        WebElement articleTitle = find(By.id("cart_count"));
        String title= articleTitle.getText();

        return title;}
}