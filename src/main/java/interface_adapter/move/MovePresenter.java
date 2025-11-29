package interface_adapter.move;

import API.MoveStaticMapInterface;
import use_case.move.MoveOutputBoundary;
import use_case.move.MoveOutputData;

import javax.swing.*;

public class MovePresenter implements MoveOutputBoundary {

    private final MoveViewModel moveViewModel;
    private final MoveStaticMapInterface staticMapService;

    public MovePresenter(MoveViewModel moveViewModel, MoveStaticMapInterface staticMapService) {
        this.moveViewModel = moveViewModel;
        this.staticMapService = staticMapService;
    }

    @Override

    public void present(MoveOutputData moveOutputData) {
        MoveState moveState = moveViewModel.getState();

        moveState.setLeftButtonEnabled(moveOutputData.isCanMoveLeft());
        moveState.setRightButtonEnabled(moveOutputData.isCanMoveRight());
        moveState.setCurrentLocationName(moveOutputData.getCurrentLocationName());
        moveState.setMonster(moveOutputData.getMonster());
//        state.setItem(outputData.getItem());
        String linearMap = formatLinearMap(
                moveOutputData.getCurrentIndex(),
                moveOutputData.getMapSize()
        );
        moveState.setLinearMap(linearMap);

        ImageIcon mapImage = staticMapService.getMapImage(
                moveOutputData.getLatitude(),
                moveOutputData.getLongitude()
        );
        moveState.setStaticMapImage(mapImage);

        moveViewModel.firePropertyChange();
    }

<<<<<<< Updated upstream
=======
    @Override
    public void switchToBattleView(User user, Monster monster) {
        Battle_State battleState = battleViewModel.getState();

        // Reset battle state for new battle
        battleState.setUser(user);
        battleState.setMonster(monster);
        battleState.setBattleEnded(false);
        battleState.setUserWon(false);
        battleState.setBattleMessage("Battle is starting...");

        battleViewModel.firePropertyChange();

        viewManagerModel.setState(battleViewModel.getViewName());
        viewManagerModel.firePropertyChange();
    }

>>>>>>> Stashed changes
    private String formatLinearMap(int currentIndex, int mapSize) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mapSize; i++) {
            if (i == currentIndex) {
                sb.append("■");
            } else {
                sb.append("□");
            }

            if (i < mapSize - 1) {
                sb.append(" — ");
            }
        }
        return sb.toString();
    }
}
