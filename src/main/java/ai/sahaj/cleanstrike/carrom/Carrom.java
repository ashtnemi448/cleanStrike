package ai.sahaj.cleanstrike.carrom;

public class Carrom 
{
	public int availableRedCoins;
	public int availableBlackCoins;
	
	public Carrom(int availableRedCoins, int availableBlackCoins) 
	{
		this.availableRedCoins = availableRedCoins;
		this.availableBlackCoins = availableBlackCoins;
	}
	
	public void restoreToDefault()
	{
		availableRedCoins=1;
		availableBlackCoins=9;
	}
	
	public int getAvailableRedCoins() 
	{
		return availableRedCoins;
	}
	
	public int getAvailableBlackCoins() 
	{
		return availableBlackCoins;
	}
	
	public void setAvailableRedCoins(int availableRedCoins) 
	{
		this.availableRedCoins = availableRedCoins;
	}
	public void setAvailableBlackCoins(int availableBlackCoins) 
	{
		this.availableBlackCoins = availableBlackCoins;
	}
	
	public void decrement(int decrementFactor,Colors color) 
	{
		if(color == Colors.RED) 
		{
			if(availableRedCoins>0)
				availableRedCoins -=  decrementFactor;
			return;
		}
		if(availableBlackCoins>0)
			availableBlackCoins -=  decrementFactor;
		return;
	}

	@Override
	public String toString() {
		return "Carrom [availableRedCoins=" + availableRedCoins + ", availableBlackCoins=" + availableBlackCoins + "]";
	}
}

