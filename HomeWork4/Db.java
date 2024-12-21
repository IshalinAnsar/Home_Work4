package ru.gb.dz.lesson4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Db {
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static void add() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Person person = new Person("Ivan", "Antonovich", 28);
        session.save(person);
        person = new Person("Anton", "Ivanovich", 42);
        session.save(person);
        person = new Person("Alex", "Vladimirovich", 21);
        session.save(person);
        person = new Person("Olga", "Petrovna", 31);
        session.save(person);
        person = new Person("Inna", "Alexeevna", 25);
        session.save(person);
        session.getTransaction().commit();
        session.close();
    }

    public static void createTable() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE `test`.`person`");
            statement.execute("CREATE TABLE `test`.`person` (\n" +
                    "                                `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "                                `Имя` VARCHAR(45) NULL,\n" +
                    "                                `Фамилия` VARCHAR(45) NULL,\n" +
                    "                                `Возраст` INT NULL,\n" +
                    "                                PRIMARY KEY (`id`));");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
