package ru.netology;

public class Manager {

    //Вам необходимо реализовать менеджер товаров, который умеет:
    //добавлять товары в репозиторий,
    //искать товары

    //Разработайте менеджера, который умеет добавлять Product в репозиторий и осуществлять поиск по ним.
    //Для этого вам нужно создать класс, конструктор которого будет принимать параметром репозиторий,
    //а также с методом publiс void add(Product product) и методом поиска searchBy(String text)

    private Repository repo;

    public Manager(Repository repo) {
        this.repo = repo;
    }

    //метод добавления товаров в репозиторий
    public void add(Product product) {
        repo.add(product);
    }


    //методе удаления removeById

    public void removeById(int id) {
        repo.removeById(id);
    }

    //У менеджера должен быть метод searchBy(String text), который возвращает массив найденных товаров
    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repo.findAll()) {
            if (matches(product, text)) {
                // "добавляем в конец" массива result продукт product
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[result.length] = product;
                result = tmp;
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }


}
