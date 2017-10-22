package model;

public abstract class Entity implements IEntity{
    private long id;

    Entity(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }
}
