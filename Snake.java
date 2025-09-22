public class Snake extends BoardEntity {
    public Snake(int start, int end) {
        super(start, end);
    }

    @Override
    public String getMessage() {
        return "Go down from " + start + " to " + end;
    }
}