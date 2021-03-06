package com.vet_clinic;

import com.vet_clinic.command.CommandReader;

/**
 * javadoc
 * Main class
 * @autor Kamila LoL
 * @version 1.0
 */

/*
Задание по JAVA:

Консольное десктопное приложение — ветклиника

Минимальное ТЗ:
 ▪️ соблюдение java code convention
 ▪️ данные можно хранить в коллекциях (соответственно, при перезапуске приложения данные не будут сохранены)
 ▪️ взаимодействие с приложением построить через команды в консоли

 ▪️ Логин пользователя-админа перед началом работы с приложением (креды могут быть захардкожены).
 ▪️ Возможность создания докторов и пациентов в системе.
 ▪️ Возможность создания приема пациента к доктору в определенный день/время. У приема могут быть статусы: новый, в процессе, отменен, ожидает оплаты, завершен. Возможность менять статус приема. Возможность выводить все приемы определенного пациента.
 ▪️ Вывод всех пациентов в консоль: id, ФИО, дата регистрации в формате yyyy-mm-dd.
 ▪️ Редактирование ФИО пациентов.
 ▪️ Удаление пациентов.
Дополнительно (т.к. работу с файлами и БД будем изучать после лекции 4):
 ▪️ Можно сделать сохранение данных в файлах или в БД. В таком случае при перезапуске приложения данные будут сохранены.

Проект нужно загрузить в гит (например, в github)
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("Put your login and password.");

        Authentication authentication = new Authentication();
        authentication.authenticate();

        CommandReader.startReading();
    }
}
