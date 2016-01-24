package GameObjs;


/**
 * Generic Pair class to hold two items - specifically used to hold String and Integer
 * This class holds the string name of a GameObject and its incremented value
 * @author mike
 *
 * @param <X>
 * @param <Y>
 */
public class Pair<X,Y> {

	private final X obj;
	private final Y value;
	
	public X getObj() {
		return obj;
	}

	public Y getValue() {
		return value;
	}

	public Pair(X obj, Y value)
	{
		this.obj = obj;
		this.value = value;
	}
	
	@Override
	public int hashCode()
	{
		return obj.hashCode() ^ value.hashCode();
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(!(o instanceof Pair)) return false;
		Pair p = (Pair) o;
		return this.obj.equals(p.getObj()) && this.value.equals(p.getValue());
	}

	@Override
	public String toString() {
		return "Pair [obj=" + obj + ", value=" + value + "]";
	}
	

	
}
