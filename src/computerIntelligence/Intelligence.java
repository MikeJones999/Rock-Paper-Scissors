package computerIntelligence;

/**
 * Interface to stipulate that all implementing classes have the ability to make a choice();
 * How that level of intelligence makes a choice is up to the creator of the class.
 * For example. research indicates levels of opening moves - most likely rock or scissors. 
 * Therefore could program a slightly bias choosing method. 
 * Or the level of intelligence could review moves made and store them...choosing next most likely
 * @author mike
 *
 */
public interface Intelligence {

	
	/**
	 * How an AI player makes a choice of gameObject
	 * @return String name of Game Object so that it can be passed via reflection
	 */
	public String makeChoice();



	
	
	
	
}