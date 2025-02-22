package five;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Task task = new Task("Сервис по загрузке Фото", "Нужно, чтобы клиет загружал фото на сайт", 3);
        System.out.println(task.toString());


        task.changeStatus(StatusEnum.IN_PROGRESS);
        System.out.println(task.toString());

        task.changeStatus(StatusEnum.TESTING);
        System.out.println(task.toString());
        Task task2 = new Task("Сервис по загрузке Фото", "Нужно, чтобы клиет загружал фото на сайт", 3);
        Task task3 = new Task("Сервис по загрузке Фото", "Нужно, чтобы клиет загружал фото на сайт", 3);
        List<Task> tasks = new ArrayList<>();
        tasks.add(task);
        tasks.add(task2);
        tasks.add(task3);


    }
}
