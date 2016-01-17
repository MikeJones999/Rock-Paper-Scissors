package GameObjs;

public class NullObj extends GameObj{

	@Override
	public int beats(Rock rock) {
		return 0;
	}

	@Override
	public int beats(Paper paper) {
		return 0;
	}

	@Override
	public int beats(Scissors paper) {
		return 0;
	}

	@Override
	public String toString() {
		return "Null Object";
	}

	@Override
	public int beats(GameObj obj) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	
	
}
