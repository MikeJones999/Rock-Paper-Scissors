package GameObjs;

/**
 * Paper GameObj - extends GameObj class
 * @author mike
 *
 */
public class Paper extends GameObj {


	//each object could be provided with it won ID - 
	//however when extending to new classes this cannot be enforced unless static counter used.
	//private int ranking = 0;

	@Override
	public String toString() {
		return "Paper";
	}



	
}
