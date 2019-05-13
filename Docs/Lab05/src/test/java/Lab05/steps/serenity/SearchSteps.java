package Lab05.steps.serenity;

import Lab05.pages.SearchPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.MatcherAssert;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

public class SearchSteps extends ScenarioSteps {

    SearchPage mainPage;

    @Step
    public void enters(String keyword) {
        mainPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        mainPage.lookup_terms();
    }


    @Step
    public void is_the_home_page() {
        mainPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
    @Step
    public void check_if_added_in_success() {
        MatcherAssert.assertThat(mainPage.checkIfFound(), is(true));
    }
    @Step
    public void check_if_added_in_error() {
        MatcherAssert.assertThat(mainPage.checkIfNotFound(), is(true));
    }

}
