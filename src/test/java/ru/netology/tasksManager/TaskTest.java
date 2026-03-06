package ru.netology.tasksManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void matchSimpleTask() {
        SimpleTask task = new SimpleTask(1, "купить продукты");
        Assertions.assertTrue(task.matches("продукты"));
    }

    @Test
    public void unmatchSimpleTask() {
        SimpleTask task = new SimpleTask(2, "Купить продукты");
        Assertions.assertFalse(task.matches("товары"));
    }

    @Test
    public void matchEpic() {
        String[] subtasks = {"купить хлеб ", "Позвонить отцу", "Сделать отчёт"};
        Epic epic = new Epic(3, subtasks);
        Assertions.assertTrue(epic.matches("отцу"));
    }


    @Test
    public void unmatchEpic() {
        String[] subtasks = {"купить хлеб ", "Позвонить отцу", "Сделать отчёт"};
        Epic epic = new Epic(4, subtasks);
        Assertions.assertFalse(epic.matches("кофе"));
    }

    @Test
    public void matchMeeting1() {
        Meeting meeting = new Meeting(5, "Обсуждение бюджета", "Проект Вега", "Сегодня к 15:00");
        Assertions.assertTrue(meeting.matches("бюджет"));
    }

    @Test
    public void matchMeeting2() {
        Meeting meeting = new Meeting(6, "Обсуждение бюджета", "Проект Вега", "Сегодня к 15:00");
        Assertions.assertTrue(meeting.matches("Вега"));
    }

    @Test
    public void matchMeeting3() {
        Meeting meeting = new Meeting(7, "Обсуждение бюджета", "Проект Вега", "Сегодня к 15:00");
        Assertions.assertFalse(meeting.matches("Альфа"));
    }
}