package ru.netology.service;

import org.junit.jupiter.api.Test;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServiceTest {
    private Service service = new Service();

    @Test
    public void shouldThrowUncheckedException() {
        assertThrows(NotFoundException.class, () -> service.throwNotFoundException());
    }
}

