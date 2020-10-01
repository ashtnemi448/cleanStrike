package Entities;

import Constant.Color;

public class Coins 
{
	private int availableRedCoins;
	private int availableBlackCoins;
	
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
	public void decrement(int decrementFactor,Color color) 
	{
		if(color == Color.RED) 
		{
			if(availableRedCoins>0)
				availableRedCoins -=  decrementFactor;
			return;
		}
		if(availableBlackCoins>0)
			availableBlackCoins -=  decrementFactor;
		return;
	}
}
