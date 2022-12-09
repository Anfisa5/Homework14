import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.*;

public class RepositoryTest {

    Product product1 = new Product(1, "книга1", 50);
    Product product2 = new Product(2, "книга2", 150);
    Product product3 = new Product(3, "книга3", 100);


    @Test
    public void testAdd1() {
        Repository repo = new Repository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.removeById(product2.getId());

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    //тест на удаление товара по ID (удаление несуществующего в списке id)
    public void testRemoveNotId() {
        Repository repo = new Repository();

        Book book1 = new Book(1, "Книга1", 100, "Автор1");
        Book book2 = new Book(3, "Книга2", 50, "Автор2");
        Book book3 = new Book(5, "Книга3", 10, "Автор3");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(8));
    }


    }






