package beadando.playercommunicator;

import beadando.Action;

public class LocalPlayer implements PlayerCommunicator{
    @Override
    public Action getStep() {
        //TODO
        //get what kind of action was commited
        return null;
    }

    @Override
    public void updateState(Action[] message) {
        //TODO
        //update the ui
    }
}
