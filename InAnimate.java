
public abstract class InAnimate extends Entity{
	
	public InAnimate ( Room r ){
		super(r);		
	}
	public InAnimate ( Room r ,Location loc ){
		super(r , loc);		
	}
	public abstract String getDisplayString() ;
}
