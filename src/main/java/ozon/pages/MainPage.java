package ozon.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static ozon.util.TestDriver.getDriver;

public class MainPage extends  BasePage{

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void choseMenuItem(String menuItem) {

        List<WebElement> item = getDriver().findElements(By.xpath("//div[@class = 'bHeaderCategoryLinks ']/a[contains(text(), '"+ menuItem +"')]"));
        Assert.assertEquals("MenuItem " + menuItem + " is not found", 1, item.size());
        click(item.get(0));

    }

    public void choseCategory(String category) {
        List<WebElement> href = getDriver().findElements(By.xpath("//div[@class = 'category-filter']//a[contains(text(), '" + category+ "')]"));
        Assert.assertEquals("Category " + category + " is not found", 1, href.size());
        click(href.get(0));


    }

}
