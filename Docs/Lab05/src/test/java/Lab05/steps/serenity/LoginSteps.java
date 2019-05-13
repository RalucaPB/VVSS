package Lab05.steps.serenity;

import Lab05.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LoginSteps extends ScenarioSteps {
    LoginPage facebookLoginPage;

    @Step
    public void enters_email_and_password(String email, String password) {
        facebookLoginPage.enter_email(email);
        facebookLoginPage.enter_password(password);
    }

    @Step
    public void logs_in() {
        facebookLoginPage.click_login();
    }

    @Step
    public void check_if_logged_in_success() {
        assertThat( facebookLoginPage.checkIfLogged(), is(true));
    }

    @Step
    public void check_if_logged_in_fail() {
        assertThat( facebookLoginPage.checkIfLogged(), is(false));
    }

    @Step
    public void is_the_home_page() {
        facebookLoginPage.open();
    }

    @Step
    public void logs_in(String email, String password) {
        enters_email_and_password(email, password);
        logs_in();
    }
}