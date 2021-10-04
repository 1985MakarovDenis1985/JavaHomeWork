import java.util.TreeSet;

public class B implements EntityCollection{
    TreeSet<Entity> entities = new TreeSet<>();

    // O(log n)
    @Override
    public void add(Entity entity) {
        entities.add(entity);
    }

    // O(log n)
    @Override
    public Entity removeMaxValue() {
        entities.remove(entities.last());
        return null;
    }
}