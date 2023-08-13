package qa.quru.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MVideoPage {
    SelenideElement
            catalogOpen = $(".catalog-button"),
            resultCheck = $(".left-menu"),
            checkAnother = $(".content-main-title"),
            anotherPage = $(".left-menu");

    public MVideoPage openWebSite() {
        open("https://www.mvideo.ru/");
        return this;
    }

    public MVideoPage openCatalog() {
        catalogOpen.click();
        return this;
    }

    public MVideoPage checkResult(String result) {
        resultCheck.shouldHave(text(result));
        return this;
    }

    public MVideoPage clickOnResult(String value) {
        anotherPage.shouldHave(text(value)).click();
        return this;
    }

    public MVideoPage checkAnotherPage(String check) {
        checkAnother.shouldHave(text(check));
        return this;
    }

}
