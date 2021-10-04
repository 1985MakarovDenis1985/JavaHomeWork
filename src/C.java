import java.util.LinkedList;

public class C{
    LinkedList<Entity> entities = new LinkedList<>();

    // O(1+n)
    public void add(Entity entity) {
        entities.add(entity);
        entities.sort((a, b) -> a.getValue() - b.getValue() );
    }

    // O(1)
    public Entity removeMaxValue() {
        if (entities.size() == 0) return null;
        Entity maxValue = entities.getLast();
        entities.remove(maxValue);
        return maxValue;
    }
}
