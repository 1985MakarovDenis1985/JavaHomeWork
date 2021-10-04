import java.util.LinkedList;


public class A implements EntityCollection{
    LinkedList<Entity> entities = new LinkedList<>();

    // O(1)
    @Override
    public void add(Entity entity) {
        entities.add(entity);
    }

    // O(1+n)
    @Override
    public Entity removeMaxValue() {
        if (entities.size() == 0) return null;
        entities.sort((a, b) -> a.getValue() - b.getValue());
        Entity maxValue = entities.getLast();
        entities.remove(maxValue);
        return maxValue;
    }
}

