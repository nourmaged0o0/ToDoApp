import java.util.Scanner;


public class Main {
    static int id=0;
    public static void mainMenu(todolist myList) {
        while (true){
            System.out.println("1. Add Task");
            System.out.println("2. Show List of Tasks");
            System.out.println("3. Edit Task");
            System.out.println("4. Remove Task");
            System.out.println("5. Export Tasks List to exel file");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice1 = scanner.nextInt();
            scanner.nextLine();
            switch (choice1) {
                case 1->{
                    System.out.println("Enter title: ");
                    String taskName =scanner.nextLine();
                    System.out.println("Enter task description: ");
                    String taskDescription =scanner.nextLine();
                    Task task = new Task(taskName, taskDescription);
                    id++;
                    task.setId(id);
                    myList.addTask(task);
                    System.out.println("Task added successfully");
                }
                case 2->{
                    myList.displayTasks();
                }
                case 3->{
                    myList.displayTasks();
                    System.out.println("Enter Task ID: ");
                    int taskID = scanner.nextInt();
                    scanner.nextLine();
                    myList.getTaskByID(taskID);
                    System.out.println("Enter new title: ");
                    String taskTitle = scanner.nextLine();
                    System.out.println("Enter new description: ");
                    String taskDescription = scanner.nextLine();
                    System.out.println("Done? Y/N");
                    String answer = scanner.nextLine();
                    if (answer.toLowerCase().equals("y")) {
                        myList.editTask(taskID,taskTitle,taskDescription,true);
                        System.out.println("task Edited successfully");
                    }
                    else if (answer.toLowerCase().equals("n")) {
                        myList.editTask(taskID,taskTitle,taskDescription,false);
                        System.out.println("task Edited successfully");
                    }
                    else {
                        System.out.println("Invalid Choice! Try Again.");
                    }
                }
                case 4->{
                    myList.displayTasks();
                    System.out.println("choose a task to remove by ID");
                    int taskID = scanner.nextInt();
                    scanner.nextLine();
                    myList.removeTaskByID(taskID);
                    System.out.println("task removed successfully");
                }
                case 5 -> {
                    System.out.println("Enter the CSV file path (e.g., tasks.csv): ");
                    String filePath = scanner.nextLine();
                    myList.exportToCSV(filePath);
                }
                case 6 -> {
                    System.exit(0);
                }
            }
        }
    }



    public static void main(String[] args) {
        todolist myList = new todolist();
    mainMenu(myList);
    }

}