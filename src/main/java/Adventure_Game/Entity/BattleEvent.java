package Adventure_Game.Entity;

import Battle_System.User.Monster;
import Battle_System.User.User;

public class BattleEvent implements Event{

    private boolean isDefeated = false;
    private final Monster monster;

    public BattleEvent(Monster monster) {
        this.monster = monster;
    }

    @Override
    public EventResult execute(User user) {
        if (isDefeated) {
            return new EventResult(EventResultType.ALREADY_EXECUTED);
        }
        isDefeated = true;

        return new EventResult(EventResultType.BATTLE, monster);
    }
}
