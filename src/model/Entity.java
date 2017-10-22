package model;

public abstract class Entity implements IEntity{
    private int id;

    Entity(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }
}
