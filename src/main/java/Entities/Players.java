package Entities;

public class Players 
{
	private int id;
	private int points;
	private int foul;
	private int noConsecutivePocketScoredCount;
	
	public Players(int id) 
	{
		this.id = id;
		points=0;
		foul=0;
		noConsecutivePocketScoredCount=0;
	}
	
	public void incrementFoulCount()
	{
		foul++;
	}
	
	public void setFoulCountToZero()
	{
		foul=0;
	}

	public void incrementPoints(int incrementFactor)
	{
		points+=incrementFactor;
	}
	
	public void decrementPoints(int incrementFactor)
	{
		points-=incrementFactor;
	}
	
	public void incrementNoConsecutivePocketScoredCount()
	{
		noConsecutivePocketScoredCount++;
	}
	
	public void setNoConsecutivePocketScoredCountToZero()
	{
		noConsecutivePocketScoredCount=0;
	}
}
