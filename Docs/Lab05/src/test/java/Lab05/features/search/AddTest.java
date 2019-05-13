package Lab05.features.search;

import Lab05.steps.serenity.AddSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class AddTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    // @ManagedPages(defaultUrl = "http://www.elefant.ro/autentificare")
    public Pages pages;

    @Steps
    public AddSteps endUser;

    @Test
    public void successfully_log_in() {
        endUser.is_the_home_page();
        endUser.sing_up_a();
        endUser.check_if_sign_up_success();
    }

}
