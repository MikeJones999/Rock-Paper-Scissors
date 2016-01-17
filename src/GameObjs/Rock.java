package GameObjs;

public class Rock extends GameObj {

	@Override
	public int beats(Scissors paper) {
	
		return 1;
	}

	@Override
	public int beats(Paper paper) {
		
		return -1;
	}

	@Override
	public int beats(Rock rock) {
		
		return 0;
	}

	@Override
	public String toString() {
		return "Rock";
	}


}
