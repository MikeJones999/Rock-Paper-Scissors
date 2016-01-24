package GameObjs;

/**
 * NullObj class used as part of NullObject design pattern - instead of throwing an exception 
 * a nullobject is return which on comparison demands that player chooses another object
 * @author mike
 *
 */
public class NullObj extends GameObj{


	@Override
	public String toString() {
		return "Null Object";
	}

	@Override
	public int beats(GameObj obj) {
		//failsafe - cause program to halt if it manages to get past reflection
		//should never get to this point
		return -5;
	}
	

	
	
}
