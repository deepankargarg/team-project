package adventure_game.use_case.show_results;

import adventure_game.entity.AdventureGame;

/**
 * Data access interface for showing results.
 */
public interface ShowResultsGameDataAccessInterface {
    /**
     * Returns the current game state.
     * @return the adventure game
     */
    AdventureGame get();
}
