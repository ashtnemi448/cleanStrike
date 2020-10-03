package ai.sahaj.cleanstrike.player;

public class Player 
{
	private int id;
	private int points;
	private int foul;
	private int consecutiveLoseCount;
	
	public Player(int id) 
	{
		this.id = id;
		points=0;
		foul=0;
		consecutiveLoseCount=0;
	}
	
	public int getConsecutiveLoseCount() 
	{
		return consecutiveLoseCount;
	}

	public void setConsecutiveLoseCount(int consecutiveLoseCount) 
	{
		this.consecutiveLoseCount = consecutiveLoseCount;
	}

	public int getId() 
	{
		return id;
	}

	public int getPoints() 
	{
		return points;
	}

	public int getFoul()
	{
		return foul;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public void setPoints(int points) 
	{
		this.points = points;
	}

	public void setFoul(int foul) 
	{
		this.foul = foul;
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
	
	public void incrementConsecutiveLoseCount()
	{
		consecutiveLoseCount++;
	}
	
	public void setConsecutiveLoseCountToZero()
	{
		consecutiveLoseCount=0;
	}
}
