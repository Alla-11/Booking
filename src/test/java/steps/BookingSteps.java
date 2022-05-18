package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;

public class BookingSteps {

    private String city;

    @Given("User is looking for hotel in {string} city")
    public void userIsLookingForHotelInLondonCity(String city) {
        this.city = city;
    }

    @When("User does search")
    public void userDoesSearch() {
        Selenide.open("https://www.booking.com/");
        $(By.xpath("//input[@type='search']")).sendKeys(city);
        $(By.xpath("//button[@data-sb-id='main']")).click();

    }

    @Then("Hotel {string} sould be on the first page")
    public void hotelJuzzHolidayLetsSouldBeOnTheFirstPage(String hotel) {
        ArrayList<String > hotelsNames = new ArrayList<>();
        for (SelenideElement element : Selenide.$$(By.xpath("//div[@data-testid='title']"))) {
            hotelsNames.add(element.getText());
        }
        Assert.assertTrue(hotelsNames.contains(hotel));
    }

    @Given("User is looking for rating for hotel in {string} city")
    public void userIsLookingForRatingForHotel(String city) {
        this.city = city;
    }


    @Then("Hotel {string} has a rating of {string}")
    public void hotelJuzzHolidayLetsHasARatingOf(String hotel, String rating) {
        String actualReting = "";
        ArrayList<String > hotelsNames = new ArrayList<>();
        for (SelenideElement element : Selenide.$$(By.xpath("//div[@data-testid='title']"))) {
            hotelsNames.add(element.getText());
        }
        for (String hotelName:hotelsNames) {
            if (hotelName.equals(hotel)){
                actualReting = $(By.xpath("//div[@aria-label='Оценка 9,9']")).getText();
            }
        }
        Assert.assertEquals(actualReting,rating);
    }
}
