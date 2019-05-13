package Lab05.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://www.elefant.ro")
public class SearchPage extends PageObject {

    @FindBy(id="query")
    private WebElementFacade searchTerms;

    @FindBy(id="searchsubmit")
    private WebElementFacade lookupButton;

    public void enter_keywords(String keyword) {
        searchTerms.type(keyword);
    }

    public void lookup_terms() {
        lookupButton.click();
    }

   /* public String getTitle() {
        WebElement articleTitle = find(By.id("cuvant_tradus"));
        String title= articleTitle.getText();

        return title;
    }*/
   public boolean checkIfFound() {
       return getDriver().getCurrentUrl().equals("http://www.elefant.ro/search?query=micul+print");
   }
    public boolean checkIfNotFound() {
        return getDriver().getCurrentUrl().equals("http://www.elefant.ro/search?query=asdfghjhgfds");
    }
}
