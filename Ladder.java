public class Ladder extends BoardEntity {
    public Ladder(int start, int end) {
        super(start, end);
    }

    @Override
    public String getMessage() {
        return "Climb up from " + start + " to " + end;
    }
} 