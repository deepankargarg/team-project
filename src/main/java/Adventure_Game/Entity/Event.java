package Adventure_Game.Entity;

import Battle_System.User.User;

public interface Event {
    public EventResult execute(User user);
}
