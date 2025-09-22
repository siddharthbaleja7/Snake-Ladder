import java.util.HashMap;
import java.util.Map;

public class Board {
    private int size;
    private Map<Integer, BoardEntity> entities;

    public Board(int size) {
        this.size = size;
        this.entities = new HashMap<>();
    }

    public void addEntity(BoardEntity entity) {
        entities.put(entity.getStart(), entity);
    }

    public int getFinalPosition(int currentPosition) {
        BoardEntity entity = entities.get(currentPosition);
        if (entity != null) {
            System.out.println(entity.getMessage());
            return entity.getEnd();
        }
        return currentPosition;
    }

    public int getSize() {
        return size;
    }
}