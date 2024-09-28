package Project;

import java.util.ArrayList;
import java.util.Scanner;

class Task {
    int id;
    String description;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task ID: " + id + ", Description: " + description;
    }
}

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();
    private int nextId = 1;  // To assign unique IDs to tasks

    public void addTask(String description) {
        Task newTask = new Task(nextId++, description);
        tasks.add(newTask);
        System.out.println("Task added successfully.");
    }

    public void editTask(int id, String newDescription) {
        for (Task task : tasks) {
            if (task.id == id) {
                task.description = newDescription;
                System.out.println("Task updated successfully.");
                return;
            }
        }
        System.out.println("Task ID not found.");
    }

    public void deleteTask(int id) {
        for (Task task : tasks) {
            if (task.id == id) {
                tasks.remove(task);
                System.out.println("Task deleted successfully.");
                return;
            }
        }
        System.out.println("Task ID not found.");
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true) {
            System.out.println("\nTo-Do List Application");
            System.out.println("1. Add Task");
            System.out.println("2. Edit Task");
            System.out.println("3. Delete Task");
            System.out.println("4. List Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    taskManager.addTask(description);
                    break;

                case 2:
                    System.out.print("Enter task ID to edit: ");
                    int editId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new description: ");
                    String newDescription = scanner.nextLine();
                    taskManager.editTask(editId, newDescription);
                    break;

                case 3:
                    System.out.print("Enter task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    taskManager.deleteTask(deleteId);
                    break;

                case 4:
                    taskManager.listTasks();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
