package lesson5;

/*Создать массив из 5 сотрудников
* Пример:
* Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
* persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312",
* * 30000, 30); // потом для каждой ячейки массива задаем объект
* persArray[1] = new Person(...);
* ...
* persArray[4] = new Person(...);
*С помощью цикла вывести информацию только о сотрудниках старше 40 лет;*/

public class Main {
    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Петр Петров", "Грузчик", "petr@mailbox.com", "555-555-55-1", 15000, 50);
        persArray[1] = new Person("Иван Иванов", "Разнорабочий", "ivan@mailbox.com", "555-55-55-2", 13500, 55);
        persArray[2] = new Person("Савелий Селиванов", "CEO", "saveliy@mailbox.com", "555-55-55-3", 100000, 21);
        persArray[3] = new Person("Грекацап Грекацапыч", "CMM", "grekazap@mailbox.com", "555-55-55-4", 150000, 18);
        persArray[4] = new Person("Космодемьян", "HR", "cosmos@mailbox.com", "555-55-55-5", 135000, 25);

        for (int i = 0; i < persArray.length - 1; i++) {
            if (persArray[i].age > 40) {
                persArray[i].showInfo();
            }
        }
    }
}
