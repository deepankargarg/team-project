package Adventure_Game.Entity;

import Battle_System.User.User;

public class PickEvent implements Event{

    private final Item item;
    private boolean isPicked = false;

    public PickEvent(Item item) {
        this.item = item;
    }

    @Override
    public EventResult execute(User user) {
        if (isPicked) {
            return new EventResult(EventResultType.ALREADY_EXECUTED);
        }
        isPicked = true;

        return new EventResult(EventResultType.PICK, item);
    }
}
