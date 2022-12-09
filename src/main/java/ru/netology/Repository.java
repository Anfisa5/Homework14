package ru.netology;

public class Repository {

    //Разработайте репозиторий, позволяющий сохранять Product, получать все сохранённые Product и
    //удалять по ID. Для этого репозиторий будет хранить у себя поле с типом Product[] (массив товаров).

    private Product[] products = new Product[0];

    //метод сохранения (добавления) Product
    public void add(Product product) {
        //создание нового массива, который по размеру на единицу больше, чем старый
        Product[] tmp = new Product[products.length + 1];
        //скопируем в новый массив все элементы из старого массива
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        //расчет последней ячейки
        tmp[tmp.length - 1] = product;
        // переложим новый массив в старый
        products = tmp;
    }

    //метод получение всех сохранённых Product
    public Product[] findAll() {
        return products;
    }

    //метод удаление по ID
    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(id);
        }
        Product[] tmp = new Product[products.length - 1];
        int copyindex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyindex] = product;
                copyindex++;
            }
            products = tmp;
        }
    }

    //метод findById, предназначенный для поиска товара в репозитории по его ID.
    //Так, он должен принимать параметр ID искомого товара, пробегаться по всем товарам репозитория
    //и сверять их ID с искомым, в случае совпадения делать return этого товара.
    //Если же, пробежав все товары репозитория, ни один подходящий найден не был,
    //то есть цикл закончился без вызова return внутри него, то следует сделать return null.

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

}
