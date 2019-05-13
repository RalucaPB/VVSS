package Lab05.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://www.elefant.ro/autentificare")
public class LoginPage extends PageObject {

    @FindBy(id = "login_password")
    private WebElementFacade password;

    @FindBy(id = "login_username")
    private WebElementFacade email;

    @FindBy(id = "login_classic")
    private WebElementFacade loginButton;


    public LoginPage() {
    }

    public void enter_email(String email) {
        this.email.type(email);
    }

    public void enter_password(String password) {
        this.password.type(password);
    }

    public void click_login() {
        loginButton.click();
    }

    public boolean checkIfLogged() {
        return getDriver().getCurrentUrl().equals("http://www.elefant.ro/#__scGV0cnVzcmFsdWNhYjk3QHlhaG9vLnJv");
    }
}