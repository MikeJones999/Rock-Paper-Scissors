package stateMachine;

import java.io.IOException;

public interface GameState {

	public void updateState() throws IOException;

	public void initiateState() throws IOException;
	
	
}
