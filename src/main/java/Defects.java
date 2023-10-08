import java.time.*;

public class Defects {
    
    public int ID;
    public String name;
    public String description;
    public LocalDateTime createdAt;
    public String status;
    public int createdBy;
    public int assignedTo;

    public Defects(int ID, String name, String description,
                        String status, int createdBy, int assignedTo) {
            this.ID = ID;
            this.name = name;
            this.description = description;
            this. createdAt = LocalDateTime.now();
            this.status = status;
            this.createdBy = createdBy;
            this.assignedTo = assignedTo;
    }

    public int getID(){
        return ID;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public String getStatus(){
        return status;
    }

    public int getCreatedBy(){
        return createdBy;
    }

    public int getAssignedTo(){
        return assignedTo;
    }

}
