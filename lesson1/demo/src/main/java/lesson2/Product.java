package lesson2;

// Проект представляет собой простую модель онлайн-магазина, в котором имеются следующие основные компоненты:
// 1.Product: Класс, представляющий продукт. У каждого продукта есть идентификатор, название, цена и
// количество.
// 2.Shop: Класс, представляющий магазин. У каждого магазина есть список продуктов, которые он предлагает.
// 3.Cart: Класс, представляющий корзину покупателя. В корзину можно добавлять и удалять товары, а также
// рассчитывать общую стоимость товаров в корзине.
// 4.TextUserInterface: Класс, представляющий текстовый пользовательский интерфейс, который предлагает
// пользователю варианты действий, такие как просмотр продуктов магазина, добавление и удаление товаров из
// корзины

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
    }

    public double getPrice() {
        return this.price;
    }

    // Геттеры и сеттеры
}