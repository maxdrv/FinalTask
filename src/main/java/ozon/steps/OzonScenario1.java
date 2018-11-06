package ozon.steps;

//import ru.yandex.qatools.allure.annotations.Step;
import io.qameta.allure.Step;
import ozon.pages.CategoryPage;
import ozon.pages.MainPage;
import ozon.pages.ShoppingCartPage;

import java.util.List;

public class OzonScenario1 {

    MainPage mainPage = new MainPage();
    CategoryPage categoryPage = new CategoryPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Step("Выбрать пункт меню")
    public void choseMenuItem(String menuItem) {
        mainPage.choseMenuItem(menuItem);
    }

    @Step("Выбрать категорию")
    public void choseCategory(String category) {
        mainPage.choseCategory(category);
    }

    @Step("Выбрать одного производителя")
    public void choseManufacturerOne(String manufacturer) {
        categoryPage.choseManufacturer(manufacturer);
    }

    @Step("Выбрать производителей")
    public void choseManufacturer(List<String> manufacturer) {
        categoryPage.choseManufacturer(manufacturer);
    }

    @Step("Заполнить цена от")
    public void choseMinPrice(int minPrice) {
        categoryPage.choseMinPrice(minPrice);
    }

    @Step("Добавить первый товар в корзину, запомнить цену и название")
    public void addFirstItemToChoppingCart() {
        categoryPage.addFirstItemToChoppingCart();
    }

    @Step("Перейти в корзину")
    public void moveToShoppingCart() {
        categoryPage.moveToShoppingCart();
    }

    @Step("Проверить товары в корзине ")
    public void checkSoppingCartForItems() {
        shoppingCartPage.checkSoppingCartForItems();
    }

    @Step("Удалить все товары в корзине")
    public void deleteItemsFromCart() {
        shoppingCartPage.deleteItemsFromCart();
    }

    @Step("Проверить, что корзина пуста")
    public void checkSoppingCartForEmpty() {
        shoppingCartPage.checkSoppingCartForEmpty();
    }
}
