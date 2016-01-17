package GameObjs;

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
