package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ProductManagerTest {
    @Mock
    private ProductRepository repository;
    @InjectMocks
    private ProductManager manager;

    @Test
    public void shouldSearchByOneItem() {
        Book first = new Book(1, "Sherlock_Holmes", 150, "Arthur Conan Doyle");
        Book second = new Book(2, "Toilers of the Sea", 200, "Victor Hugo");
        Smartphone third = new Smartphone(3, "Nokia", 2000, "Finland");
        Smartphone fourth = new Smartphone(4, "Sony", 3000, "Japan");
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        Product[] returned = new Product[]{first, second, third, fourth};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Nokia");
        Product[] expected = new Product[]{third};
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldSearchByZeroItems() {
        Book first = new Book(1, "Sherlock_Holmes", 150, "Arthur Conan Doyle");
        Book second = new Book(2, "Toilers of the Sea", 200, "Victor Hugo");
        Smartphone third = new Smartphone(3, "Nokia", 2000, "Finland");
        Smartphone fourth = new Smartphone(4, "Sony", 3000, "Japan");
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        Product[] returned = new Product[]{first, second, third, fourth};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Iphone");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldSearchByTwoItems() {
        Book first = new Book(1, "Sherlock_Holmes", 150, "Arthur Conan Doyle");
        Book second = new Book(2, "Toilers of the Sea", 200, "Victor Hugo");
        Smartphone third = new Smartphone(3, "Nokia", 2000, "Finland");
        Smartphone fourth = new Smartphone(4, "Sony", 3000, "Japan");
        Book fifth = new Book(5, "The Nose", 100, "Nikolai Vasilievich Gogol");
        Book sixth = new Book(6, "Dead Souls", 150, "Nikolai Vasilievich Gogol");
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        Product[] returned = new Product[]{first, second, third, fourth, fifth, sixth};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Nikolai Vasilievich Gogol");
        Product[] expected = new Product[]{fifth, sixth};
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldSearchByProducer() {
        Book first = new Book(1, "Sherlock_Holmes", 150, "Arthur Conan Doyle");
        Book second = new Book(2, "Toilers of the Sea", 200, "Victor Hugo");
        Smartphone third = new Smartphone(3, "Nokia", 2000, "Finland");
        Smartphone fourth = new Smartphone(4, "Sony", 3000, "Japan");
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        Product[] returned = new Product[]{first, second, third, fourth};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Japan");
        Product[] expected = new Product[]{fourth};
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldSearchByBookName() {
        Book first = new Book(1, "Sherlock_Holmes", 150, "Arthur Conan Doyle");
        Book second = new Book(2, "Toilers of the Sea", 200, "Victor Hugo");
        Smartphone third = new Smartphone(3, "Nokia", 2000, "Finland");
        Smartphone fourth = new Smartphone(4, "Sony", 3000, "Japan");
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        Product[] returned = new Product[]{first, second, third, fourth};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Toilers of the Sea");
        Product[] expected = new Product[]{second};
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }
//        @Test
//        public void shouldSearchBy() {
//            ProductManager manager = new ProductManager(new ProductRepository());
//            Book first = new Book(1, "Sherlock_Holmes", 150, "Arthur Conan Doyle");
//            Book second = new Book(2, "Toilers of the Sea", 200, "Victor Hugo");
//            Smartphone third = new Smartphone(3, "Nokia", 2000, "Finland");
//            Smartphone fourth = new Smartphone(4, "Sony", 3000, "Japan");
//            manager.add(first);
//            manager.add(second);
//            manager.add(third);
//            manager.add(fourth);
//
//        manager.searchBy("Nokia");
//
//        Product[] actual = manager.searchBy("Nokia");
//        Product[] expected = new Product[]{third};
//
//        assertArrayEquals(expected, actual);
//    }
}
