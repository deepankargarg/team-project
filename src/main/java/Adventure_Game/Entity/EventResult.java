package Adventure_Game.Entity;

public class EventResult {
    private final EventResultType type;
    private final Object payload;

    public EventResult(EventResultType type, Object payload) {
        this.type = type;
        this.payload = payload;
    }

    public EventResult(EventResultType type) {
        this(type, null);
    }

    public EventResultType getType() { return type; }

    // NOTE: use casting to use payload
    public Object getPayload() { return payload; }
}
