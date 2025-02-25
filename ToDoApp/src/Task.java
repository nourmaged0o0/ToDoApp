public class Task {
    private int id;
    private String title;
    private String description;
    private boolean done = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
