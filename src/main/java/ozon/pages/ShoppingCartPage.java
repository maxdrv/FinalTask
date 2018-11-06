package ozon.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static ozon.util.TestData.getDescriprionItem;
import static ozon.util.TestData.getPriceItem;
import static ozon.util.TestDriver.getDriver;

public class ShoppingCartPage extends  BasePage{

    public ShoppingCartPage() {
        PageFactory.initElements(getDriver(), this);
    }


    @FindBy(xpath = "//span[@class = 'jsInnerContentpage_title']")
    WebElement titleOfShoppingCard;

    @FindBy(xpath = "//div[@class = 'eCartControls_buttons']")
    List<WebElement> removeButtonsList;

    //span[@class = 'eCartItem_nameValue']
    @FindBy(xpath = "//span[@class = 'eCartItem_nameValue']")
    List<WebElement> itemNameInCardList;

    @FindBy(xpath = "//div[@class = 'eCartItem_price']")
    List<WebElement> itemPriceInCardList;

    @FindBy(xpath = "//div[@class = 'bFlatButton mHuge mGreen jsMakeOrder']")
    WebElement confirmTheOrderButton;

    @FindBy(xpath = "//a[@class = 'bFlatButton mHuge']")
    WebElement startShoppingButton;

    public void checkSoppingCartForItems() {
        Assert.assertEquals("Items in cart is not found", 1, itemNameInCardList.size());

        String actualText = itemNameInCardList.get(0).getText();
        String expectedText = getDescriprionItem();
        Assert.assertEquals("Names of items is not equal", actualText, expectedText);


        String[] priceFromPage = itemPriceInCardList.get(0).getText().split(",");
        String actualPrice = priceFromPage[0];
        actualPrice = actualPrice.replaceAll("\\s+","");
        int actualPriceInt = Integer.parseInt(actualPrice);

        int expectedPrice = getPriceItem();
        Assert.assertEquals("Names of items is not equal", actualPriceInt, expectedPrice);
    }

    public void deleteItemsFromCart() {

        waitForClickable(confirmTheOrderButton);
        //new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(confirmTheOrderButton));
        Assert.assertEquals("Delete button is not found", 1, removeButtonsList.size());

        waitForClickable(removeButtonsList.get(0));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        click(removeButtonsList.get(0));

    }

    public void checkSoppingCartForEmpty() {

        waitForClickable(startShoppingButton);
        checkText(titleOfShoppingCard, "Корзина пуста");
    }

}
