package qa.guru.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Open main page")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Search for repository {repo}")
    public void searchForRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }

    @Step("Open repository by link {link}")
    public void openRepositoryByLink(String link) {
        $(By.linkText(link)).click();
    }

    @Step("Open Issues tab")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Should see issue with number {num}")
    public void shouldSeeIssueWithNumber(int num) {
        $(withText("#" + num)).should(Condition.exist);
    }

}
