package lesson5;

/*  * Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
    * Конструктор класса должен заполнять эти поля при создании объекта;
    * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
    *
 * */

public class Person {
    public String name;
    public String position;
    public String email;
    public String phone;
    public int salary;
    public int age;


    public Person(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void showInfo() {
        System.out.printf("Сотрудник: %s.\nДолжнотсть: %s.\nemail: %s.\nтелефон: %s.\nзарплата: %d.\nвозраст: %d.\n\n",
                name, position, email, phone, salary, age);
    }


}

