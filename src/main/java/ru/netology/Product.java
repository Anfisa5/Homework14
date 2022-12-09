package ru.netology;

public class Product {

    //Разработайте базовый класс Product, содержащий ID, название, стоимость
    //общие поля вынесите в родителя.

    protected int id;
    protected String name;
    protected int price;


    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}

