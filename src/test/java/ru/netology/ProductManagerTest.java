package ru.netology;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exception.NotFoundException;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductManagerTest {
    @Test
    public void shouldRemoveIfExists() {
        ProductManager manager = new ProductManager(new ProductRepository());
        Book first = new Book(1, "Sherlock_Holmes", 150, "Arthur Conan Doyle");
        Book second = new Book(2, "Toilers of the Sea", 200, "Victor Hugo");
        Smartphone third = new Smartphone(3, "Nokia", 2000, "Finland");
        Smartphone fourth = new Smartphone(4, "Sony", 3000, "Japan");
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        int idToRemove = 1;
        manager.removeById(idToRemove);

        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{fourth, third, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        ProductManager manager = new ProductManager(new ProductRepository());
        Book first = new Book(1, "Sherlock_Holmes", 150, "Arthur Conan Doyle");
        Book second = new Book(2, "Toilers of the Sea", 200, "Victor Hugo");
        Smartphone third = new Smartphone(3, "Nokia", 2000, "Finland");
        Smartphone fourth = new Smartphone(4, "Sony", 3000, "Japan");
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        int idToRemove = 5;

        manager.removeById(idToRemove);

        assertThrows(NotFoundException.class, () -> manager.throwNotFoundException());

//        Product[] actual = manager.getAll();
//        Product[] expected = new Product[]{fourth, third, second, first};
//
//        assertArrayEquals(expected, actual);
    }

//    @Test
//    public void shouldSearchBy() {
//        ProductManager manager = new ProductManager(new ProductRepository());
//        Book first = new Book(1, "Sherlock_Holmes", 150, "Arthur Conan Doyle");
//        Book second = new Book(2, "Toilers of the Sea", 200, "Victor Hugo");
//        Smartphone third = new Smartphone(3, "Nokia", 2000, "Finland");
//        Smartphone fourth = new Smartphone(4, "Sony", 3000, "Japan");
//        manager.add(first);
//        manager.add(second);
//        manager.add(third);
//        manager.add(fourth);
//
//        manager.searchBy("Nokia");
//
//        Product[] actual = manager.searchBy("Nokia");
//        Product[] expected = new Product[]{third};
//
//        assertArrayEquals(expected, actual);
//    }
}
