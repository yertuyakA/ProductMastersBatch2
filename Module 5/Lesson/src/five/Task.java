package five;

public class Task {
    private String title;
    private String description;
    private int level;
    private StatusEnum status;

    public Task(String title, String description, int level) {
        this.title = title;
        this.description = description;
        this.level = level;
        this.status = StatusEnum.BACKLOG;
    }

    public void changeStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", level=" + level +
                ", status='" + status + '\'' +
                '}';
    }
}
