package Lab05.steps.serenity;

import Lab05.pages.AddPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class AddSteps extends ScenarioSteps {
    AddPage mPage;



    @Step
    public void sign_up() {
        mPage.click_citit();
    }

    @Step
    public void check_if_sign_up_success() {
        assertThat( mPage.getTitle(), not(0));
    }



    @Step
    public void is_the_home_page() {
        mPage.open();
    }

    @Step
    public void sing_up_a() {

        sign_up();
    }
}