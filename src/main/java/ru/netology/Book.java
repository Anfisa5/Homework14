package ru.netology;

public class Book extends Product {

    //Разработайте унаследованных от Product класс: Book с текстовыми полями «название» и «автор»
    //общие поля вынесите в родителя

    private String author;

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

}
    
