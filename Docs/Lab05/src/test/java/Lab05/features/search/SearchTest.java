package Lab05.features.search;


import Lab05.steps.serenity.SearchSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class SearchTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://www.elefant.ro")
    public Pages pages;

    @Steps
    public SearchSteps endUser;

    @Test
    public void search_T() {
        endUser.is_the_home_page();
        endUser.looks_for("micul print");

    }
    @Test
    public void search_F() {
        endUser.is_the_home_page();
        endUser.looks_for("asdfghjhgfds");

    }

}
