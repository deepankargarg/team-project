package adventure_game.interface_adapter.results;

import adventure_game.interface_adapter.ViewModel;

/**
 * ViewModel for the results screen.
 */
public class ResultsViewModel extends ViewModel<ResultsState> {
    public static final String TITLE_LABEL = "Game Results";
    public static final String BACK_BUTTON_LABEL = "Back to Game";

    public ResultsViewModel() {
        super("results");
        setState(new ResultsState());
    }
}
