package ru.netology.service;

import ru.netology.exception.NotFoundException;

public class Service {

    public void throwNotFoundException() {
        throw new NotFoundException();
    }
}
