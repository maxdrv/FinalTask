package ozon.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static ozon.util.TestData.setDescriprionItem;
import static ozon.util.TestData.setPriceItem;
import static ozon.util.TestDriver.getDriver;

public class CategoryPage extends  BasePage{

    public CategoryPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//div[contains(text(), 'Бренды')]//..//span[@class = 'show-text']")
    List<WebElement> showAllBrandsButton;

    @FindBy(xpath = "//a[@href = '/context/cart']")
    List<WebElement> moveToCardButton;

    @FindBy(xpath = "//button[@class = 'buy-button blue-cream enlarged button flat-button tile-buy-button']/span[contains(text(), 'корзину')]")
    List<WebElement> addToCartButtons;

    @FindBy(xpath = "//div[contains(text(), 'Бренды')]//..//input[@class = 'input']")
    List<WebElement> inputBrand;

    public void choseManufacturer(String manufacturer) {

        if(showAllBrandsButton.get(0).isDisplayed()){
            Assert.assertEquals("Show All Brands button is not found", 1, showAllBrandsButton.size());
            click(showAllBrandsButton.get(0));
        }

        Assert.assertEquals("Input brand is not found", 1, inputBrand.size());
        click(inputBrand.get(0));
        fillField(inputBrand.get(0), manufacturer);

        List<WebElement> preloader = getDriver().findElements(By.xpath("//div[@class = 'five-dots preloader m-full-preloader']"));
        if(preloader.get(0).isDisplayed()){
            new WebDriverWait(getDriver(), 5).until(ExpectedConditions.invisibilityOf(preloader.get(0)));
        }
    }

    public void choseManufacturer(List<String> manufacturer) {

        if(showAllBrandsButton.get(0).isDisplayed()){
            Assert.assertEquals("Show All Brands button is not found", 1, showAllBrandsButton.size());
            click(showAllBrandsButton.get(0));
        }

        for (String text : manufacturer) {
            Assert.assertEquals("Input brand is not found", 1, inputBrand.size());
            click(inputBrand.get(0));
            fillField(inputBrand.get(0), text);

            List<WebElement> preloader = getDriver().findElements(By.xpath("//div[@class = 'five-dots preloader m-full-preloader']"));
            Assert.assertEquals("Preloader is is not found", 1, preloader.size());
            if(preloader.get(0).isDisplayed()){
                new WebDriverWait(getDriver(), 5).until(ExpectedConditions.invisibilityOf(preloader.get(0)));
            }
        }
    }

    public void choseMinPrice(int minPrice) {
        List<WebElement> inputMinPrice = getDriver().findElements(By.xpath("//div[@class = 'input-item']/label[contains(text(), 'от')]/../input[@class = 'input']"));
        Assert.assertEquals("Input minimum price is not found", 1, inputMinPrice.size());
        click(inputMinPrice.get(0));
        fillField(inputMinPrice.get(0), Integer.toString(minPrice));

        List<WebElement> preloader = getDriver().findElements(By.xpath("//div[@class = 'five-dots preloader m-full-preloader']"));
        Assert.assertEquals("Preloader is is not found", 1, preloader.size());
        if(preloader.get(0).isDisplayed()){
            new WebDriverWait(getDriver(), 5).until(ExpectedConditions.invisibilityOf(preloader.get(0)));
        }
    }

    public void addFirstItemToChoppingCart() {

        List<WebElement> itemsOnPage = getDriver().findElements(By.xpath("//div[@class = 'tile' and @data-index != '-1']"));
        int size = itemsOnPage.size();
        String patern = getElementXPath(itemsOnPage.get(size - 1));
        System.out.println(patern);

        // xpath добавить в козину
        String toCardXpath = String.format("%s//button[@class = 'buy-button blue-cream enlarged button flat-button tile-buy-button']/span", patern);

        // хpath имени предмета
        String nameItemXpath = String.format("%s//p[@class = 'name']", patern);
        // Получаем название предмета
        String descriptionItem = getDriver().findElement(By.xpath(nameItemXpath)).getText();
        // И сохраняем название в переменную
        setDescriprionItem(descriptionItem);

        // xpath цены предмета
        String priceItemXpath = String.format("%s//span[@class = 'price-number']/span", patern);
        // Получаем строку со стоимостью предмета
        String priceItem = getDriver().findElement(By.xpath(priceItemXpath)).getText();
        // Удаляем пробельные симсолы из строки
        priceItem = priceItem.replaceAll("\\s+","");
        // Строку в интовую переменную
        int priceItemInt = Integer.parseInt(priceItem);


        setPriceItem(priceItemInt);
        setDescriprionItem(descriptionItem);

        click(getDriver().findElement(By.xpath(toCardXpath)));
    }

    public void moveToShoppingCart() {
        Assert.assertEquals("Cart button is is not found", 1, moveToCardButton.size());
        click(moveToCardButton.get(0));
    }

}
