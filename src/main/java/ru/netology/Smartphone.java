package ru.netology;

public class Smartphone extends Product {

    //Разработайте унаследованных от Product класс: Smartphone с текстовыми полями «название» и «производитель»;
    //общие поля вынесите в родителя

    private String vendor;

    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.vendor = manufacturer;
    }

}

