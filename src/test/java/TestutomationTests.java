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
        $("#subjectsInput").pressEnter();
        $("#subjectsInput").pressTab();
        $("#hobbies-checkbox-2").parent().click();
        $("#uploadPicture").uploadFile(new File("src/test/resources1/paddington-g51aae444a_640.png"));
        $("#currentAddress").setValue("Some Address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-content").shouldBe(Condition.visible);
        $(".modal-content").shouldHave(text("Mike Turilov"));
        $(".modal-content").shouldHave(text("example@google.com"));
        $(".modal-content").shouldHave(text("Male"));
        $(".modal-content").shouldHave(text("9001546995"));
        $(".modal-content").shouldHave(text("12 January,1985"));
        $(".modal-content").shouldHave(text("Maths"));
        $(".modal-content").shouldHave(text("Sports"));
        $(".modal-content").shouldHave(text("1.png"));
        $(".modal-content").shouldHave(text("Some Address"));
        $(".modal-content").shouldHave(text("NCR Delhi"));
        $("#closeLargeModal").click();

    }



}
