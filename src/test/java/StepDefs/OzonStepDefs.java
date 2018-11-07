package StepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import ozon.steps.OzonScenario1;

import java.util.List;

public class OzonStepDefs {

    OzonScenario1 scenario1 = new OzonScenario1();

    @Когда("^Выбрать пункт меню – (.+)$")
    public void choseMenuItem(String menuItem) {
        scenario1.choseMenuItem(menuItem);
    }

    @Когда("^Выбрать категорию – (.+)$")
    public void choseCategory(String category) {
        scenario1.choseCategory(category);
    }

    @Когда("^Выбрать производителя – (.+)$")
    public void choseManufacturer(String manufacturerOne) {
        scenario1.choseManufacturerOne(manufacturerOne);
    }

    @Когда("^Выбрать производителя$")
    public void choseManufacturer(List<String> stringList) {
        scenario1.choseManufacturer(stringList);
    }

    @Тогда("^Заполнить цена от – (\\d+)$")
    public void choseMinPrice(int minPrice) {
        scenario1.choseMinPrice(minPrice);
    }

    @Тогда("^Добавить первый товар в корзину, запомнить название и цену$")
    public void addFirstItemToChoppingCart(){
        scenario1.addFirstItemToChoppingCart();
    }

    @Когда("^Перейти в корзину$")
    public void moveToShoppingCart(){
        scenario1.moveToShoppingCart();
    }

    @Тогда("^Проверить, что в корзине есть добавленный товар$")
    public void checkSoppingCartForItems() {
        scenario1.checkSoppingCartForItems();
    }

    @Тогда("^Нажать на удалить все$")
    public void deleteItemsFromCart() {
        scenario1.deleteItemsFromCart();
    }

    @Тогда("^Проверить, что корзина пуста$")
    public void checkSoppingCartForEmpty() {
        scenario1.checkSoppingCartForEmpty();
    }
}
