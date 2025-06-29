class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int id, String name, String status) {
        this.taskId = id;
        this.taskName = name;
        this.status = status;
        this.next = null;
    }
}

public class TaskManager {
    Task head;

    void addTask(Task newTask) {
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
    }

    void deleteTask(int id) {
        if (head == null) return;
        if (head.taskId == id) {
            head = head.next;
            return;
        }
        Task current = head;
        while (current.next != null && current.next.taskId != id) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    Task searchTask(int id) {
        Task current = head;
        while (current != null) {
            if (current.taskId == id) return current;
            current = current.next;
        }
        return null;
    }

    void displayTasks() {
        Task current = head;
        while (current != null) {
            System.out.println("ID: " + current.taskId + ", Task: " + current.taskName + ", Status: " + current.status);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.addTask(new Task(1, "Design UI", "Pending"));
        manager.addTask(new Task(2, "Write Backend", "In Progress"));
        manager.displayTasks();

        System.out.println("\nAfter deleting task ID 1:");
        manager.deleteTask(1);
        manager.displayTasks();
    }
}

