package ozon.pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ozon.util.TestDriver.getDriver;

public abstract class BasePage {

    public void scroll(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(false);", element);
    }

    public void click(WebElement element) {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public String getText(WebElement element) {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public void fillFieldNotWorking(WebElement field, String value){
        field.clear();
        field.sendKeys(value);
    }

    public void fillField(WebElement field, String value){
        field.sendKeys(Keys.CONTROL + "a");
        field.sendKeys(Keys.DELETE);
        field.sendKeys(value);
        field.sendKeys(Keys.ENTER);
    }

    public void checkText(WebElement element, String expectedText) {
        String actualText = element.getText();
        Assert.assertEquals("actual text is not equals expectedText", expectedText, actualText);
    }

    public String getElementXPath(WebElement element) {
        return (String)((JavascriptExecutor) getDriver()).executeScript("gPt=function(c){if(c.id!==''){return'id(\"'+c.id+'\")'}if(c===document.body){return c.tagName}var a=0;var e=c.parentNode.childNodes;for(var b=0;b<e.length;b++){var d=e[b];if(d===c){return gPt(c.parentNode)+'/'+c.tagName+'['+(a+1)+']'}if(d.nodeType===1&&d.tagName===c.tagName){a++}}};return gPt(arguments[0]).toLowerCase();", element);
    }

}
