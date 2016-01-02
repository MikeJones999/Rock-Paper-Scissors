package GameObjs;

public class Paper extends GameObj {

	public int beats(Rock rock) {

		return 1;
	}

	public int beats(Scissors scissors) {
	
		return -1;
	}

	public int beats(Paper paper2) 
	{
	
		return 0;
	}

	
	
}
