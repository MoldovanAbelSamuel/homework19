package fasttrackit.org.Homework.Exceptions;

public class EntityDoesntExistException extends RuntimeException{
    private int entityId;

    public EntityDoesntExistException(String message, int entityId) {
        super(message);
        this.entityId = entityId;
    }

    public int getEntityId() {
        return entityId;
    }
}
