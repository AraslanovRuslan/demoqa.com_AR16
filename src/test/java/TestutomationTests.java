import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestutomationTests {

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
    @Test
    void formTests(){
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Ivanov@mail.ru");
        $("#gender-radio-3").doubleClick();
        $("#userNumber").setValue("89000765432");
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__day--026").click();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("Painting");
        $("#subjectsInput").pressTab();
        $("#hobbies-checkbox-2").parent().click();
        $("[id=uploadPicture]").uploadFile(new File("src/test/resources/paddington-g51aae444a_640.jpg"));
        $("#currentAddress").setValue("Some Address111");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();
        $("#submit").click();

        $(".modal-content").shouldBe(Condition.visible);
        $(".modal-content").shouldHave(text("Ivan Ivanov"));
        $(".modal-content").shouldHave(text("Ivanov@mail.ru"));
        $(".modal-content").shouldHave(text("Other"));
        $(".modal-content").shouldHave(text("89000765432"));
        $(".modal-content").shouldHave(text("26 May,1990"));
        $(".modal-content").shouldHave(text("Painting"));
        $(".modal-content").shouldHave(text("Reading"));
        $(".modal-content").shouldHave(text("paddington-g51aae444a_640.png"));
        $(".modal-content").shouldHave(text("Some Address111"));
        $(".modal-content").shouldHave(text("Uttar Pradesh Agra"));
        $("#closeLargeModal").click();

    }



}
