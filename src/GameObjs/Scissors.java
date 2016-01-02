package GameObjs;

public class Scissors extends GameObj {

	public int beats(Rock rock) {
		
		return -1;
	}

	public int beats(Paper paper) {

		return 1;
	}

	public int beats(Scissors scissors) {
	
		return 0;
	}

}
