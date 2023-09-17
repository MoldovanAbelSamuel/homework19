package fasttrackit.org.Homework.Exceptions;

public class EntityAlreadyExistsException extends RuntimeException{
    private int entityId;

    public EntityAlreadyExistsException(String message, int entityId) {
        super(message);
        this.entityId = entityId;
    }

    public int getEntityId() {
        return entityId;
    }
}
