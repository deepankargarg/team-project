package interface_adapter.quiz;

import interface_adapter.Battle.BattleViewModel;
import interface_adapter.ViewManagerModel;
import use_case.quiz.SubmitQuizOutputBoundary;
import use_case.quiz.SubmitQuizOutputData;

public class QuizPresenter implements SubmitQuizOutputBoundary {

    private final QuizViewModel viewModel;
    private final BattleViewModel battleViewModel;
    private final ViewManagerModel viewManagerModel;

    public QuizPresenter(QuizViewModel viewModel, BattleViewModel battleViewModel, ViewManagerModel viewManagerModel) {
        this.viewModel = viewModel;
        this.battleViewModel = battleViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void present(SubmitQuizOutputData data) {
        QuizState quizState = viewModel.getState();
        quizState.setQuizId(data.getQuizId());
        quizState.setCompleted(data.isCompleted());
        quizState.setStatus(data.getStatus());
        quizState.setFeedbackMessage(data.getMessage());

        // notify view of the state change
        viewModel.firePropertyChange();
    }

    @Override
    public void switchToBattleView() {
        viewManagerModel.setState(battleViewModel.getViewName());
        viewManagerModel.firePropertyChange();
    }
}
