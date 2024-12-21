package ru.gb.dz.lesson4;

import javax.xml.stream.XMLInputFactory;

/**
 * Настройте связь между вашим приложением и базой данных MySQL с использованием Hibernate.
 * Создайте несколько объектов Person и сохраните их в базу данных.
 */

public class Program {
    public static void main(String[] args) {
        Db.createTable();
        Db.add();
    }
}
