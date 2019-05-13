package Lab05.features.search;

import Lab05.steps.serenity.LoginSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

   // @ManagedPages(defaultUrl = "http://www.elefant.ro/autentificare")
    public Pages pages;

    @Steps
    public LoginSteps endUser;

    @Test
    public void successfully_log_in() {
        endUser.is_the_home_page();
        endUser.logs_in("petrusralucab97@yahoo.ro", "raluelefant");
        endUser.check_if_logged_in_success();
    }

    @Test
    public void failed_log_in() {
        endUser.is_the_home_page();
        endUser.logs_in("blabla@yahoo.com", "blabla");
        endUser.check_if_logged_in_fail();
    }
}
