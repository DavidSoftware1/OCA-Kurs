import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Todo implements Serializable {
    private String subject; //null
    private boolean checked; //false

    private LocalDateTime created; //null


    // Wenn wir keinen Konstruktor definieren, generiert der Compiler
    // einen eigenen no-args Konstruktor

    Todo(String s) {
        subject = s;
        created = LocalDateTime.now();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        if(subject != null) {
            this.subject = subject;
        }
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "subject='" + subject + '\'' +
                ", checked=" + checked +
                ", created=" + created +
                '}';
    }
}
