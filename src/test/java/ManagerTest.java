import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.*;


public class ManagerTest {

    @Test
    public void testAddIdBook() {

        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Книга1", 100, "Автор1");
        Book book2 = new Book(2, "Книга2", 50, "Автор2");
        Book book3 = new Book(3, "Книга3", 10, "Автор3");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book1, book2, book3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testsearchBy() {

        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Книга1", 100, "Автор1");
        Book book2 = new Book(2, "Книга1", 50, "Автор1");
        Book book3 = new Book(3, "Книга3", 10, "Автор3");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book1, book2};
        Product[] actual = manager.searchBy("Книга1");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void testAddIdSmartphone() {

        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Smartphone smartphone1 = new Smartphone(1, "Смартфон1", 100, "Производитель1");
        Smartphone smartphone2 = new Smartphone(1, "Смартфон2", 50, "Производитель2");
        Smartphone smartphone3 = new Smartphone(1, "Смартфон3", 10, "Производитель1");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    // тест на удаление товара по ID (удаление существующего в списке id)
    public void testRemove1() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Книга1", 100, "Автор1");
        Book book2 = new Book(2, "Книга2", 50, "Автор2");
        Book book3 = new Book(3, "Книга3", 10, "Автор3");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.removeById(2);

        Product[] expected = {book1, book3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    // тест на удаление товара по ID (удаление несуществующего в списке id)
    public void testRemove2() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Книга1", 100, "Автор1");
        Book book2 = new Book(2, "Книга2", 50, "Автор2");
        Book book3 = new Book(3, "Книга3", 10, "Автор3");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Assertions.assertThrows(NotFoundException.class,
                () -> manager.removeById(6));
    }
}

