import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class todolist {
    private ArrayList<Task> tasks ;

    public todolist(){
        tasks =new ArrayList<>();
    }
    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTaskByID(int id) {
        tasks.removeIf(t -> t.getId() == id);
    }
    public void editTask(int id,String title, String description,boolean isDone) {
        for(Task new_task : tasks) {
            if (new_task.getId()==id){

        if (title != "") {
            new_task.setTitle(title);
        }
        if (description != "") {
        new_task.setDescription(description);
        }
        new_task.setDone(isDone);
            }
        }

    }
    public void getTaskByID(int id) {
        for(Task new_task : tasks) {
            if (new_task.getId()==id){

        if (new_task.isDone()) {
            System.out.println("Task [ID: " + new_task.getId() + ", Title: " + new_task.getTitle() +
                    ", Description: " + new_task.getDescription() + ", Done ]");
        }
        else {
            System.out.println("Task [ID: " + new_task.getId() + ", Title: " + new_task.getTitle() +
                    ", Description: " + new_task.getDescription() + ", Not Done ]");
        }

            }}
    }



    public void displayTasks() {
        System.out.printf(Locale.ENGLISH, "| %-5s | %-20s | %-25s | %-10s |\n", "ID", "Title", "Description", "Status");
        System.out.println("-------------------------------------------------------------------------");

        for (Task task : tasks) {
            String status = task.isDone() ? "Done" : "Not Done";
            System.out.printf(Locale.ENGLISH, "| %-5d | %-20s | %-25s | %-10s |\n",
                    task.getId(), task.getTitle(), task.getDescription(), status);
        }
        System.out.println("\n");

    }


    public void exportToCSV(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("ID,Title,Description,Status\n");
            for (Task task : tasks) {
                writer.append(task.getId() + ",")
                        .append(task.getTitle() + ",")
                        .append(task.getDescription() + ",")
                        .append(task.isDone() ? "Done" : "Not Done")
                        .append("\n");
            }
            System.out.println("Tasks exported successfully to: " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }
    }
}
