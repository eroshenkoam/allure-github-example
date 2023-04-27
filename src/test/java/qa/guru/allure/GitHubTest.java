package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class GitHubTest {

    @BeforeAll
    public static void setupSelenide() {
        Configuration.remote = "http://localhost:4444/wd/hub";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Test
    @DisplayName("Search for issue with number 79")
    public void searchForIssue() {
        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("allure-example");
        $(".header-search-input").submit();

        $(By.linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();

        $(withText("#79")).should(Condition.exist);
    }

    @Test
    @DisplayName("Search for issue with number 80")
    public void searchForIssue1() {
        step("Open main page", () -> {
            open("https://github.com");
        });
        step("Search for repository", () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys("allure-example");
            $(".header-search-input").submit();
        });
        step("Open repository by link", () -> {
            $(By.linkText("eroshenkoam/allure-example")).click();
        });
        step("Open Issues tab", () -> {
            $("#issues-tab").click();
        });
        step("Should see issue with number 80", () -> {
            $(withText("#80")).should(Condition.exist);
        });
    }

    @Test
    @DisplayName("Search for issue with number 81")
    public void searchForIssue2() {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository("allure-example");
        steps.openRepositoryByLink("eroshenkoam/allure-example");
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(81);
    }
}
