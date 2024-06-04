import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class gitSolutionsEnterprize {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1080x720";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void hohoHoverTest() {

        open("/");
        $$("button").findBy(text("Solutions")).hover();
        $$("a.HeaderMenu-dropdown-link").findBy(text("Enterprise")).click();
        $("#hero-section-brand-heading").shouldBe(visible).shouldHave(allOf(text("The AI-powered"), text("developer platform.")));
    }

    @Test
    void dragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b")));
        $("#column-a").shouldHave(text("B"));
    }
}