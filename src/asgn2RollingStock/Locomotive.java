package asgn2RollingStock;

import asgn2Exceptions.TrainException;

public class Locomotive extends RollingStock {

	/**
	 * @author Leander Beesie Liengkie N8682879
	 */
	Integer weight, power;
	public String trainClass;
	String trainType;
	char type;
	public char[] powerDeterminer;
	public Locomotive(Integer grossWeight, String classification) throws TrainException
	{
		super(grossWeight);
		weight = grossWeight;
		trainClass = classification;
		powerDeterminer = trainClass.toCharArray();
		int powerClass = Integer.parseInt(String.valueOf(powerDeterminer[0]));

		if (grossWeight < 1)
			throw new TrainException("It is not a valid weight!");
		if (powerDeterminer.length < 2)
			throw new TrainException("It is not a valid classification!");
		
		if (powerDeterminer.length == 3)
		{
			power = Integer.parseInt(String.valueOf(powerDeterminer[0])+String.valueOf(powerDeterminer[1]))*100;
			
			type = powerDeterminer[2];
			switch (type) {
            case 'D':  trainType = "Diesel";
                     break;
            case 'S':  trainType = "Steam";
                     break;
            case 'E':  trainType = "Electric";
                     break;
			}
		}
		else 
		{
			power = powerClass * 100;
			type = powerDeterminer[1];
			
			switch (type) {
            case 'D':  trainType = "Diesel";
                     break;
            case 'S':  trainType = "Steam";
                     break;
            case 'E':  trainType = "Electric";
                     break;          
			}
		}
		
		if ((powerClass < 1 || powerDeterminer.length > 2)|| (type != 'E' && type != 'D' && type != 'S'))
			throw new TrainException("It is not a valid classification!");
	}
	
	public int power()
	{
		return power;
	}
	
	public String toString()
	{
		return "Locomotive with power ="+" "+power+" "+"with gross weight"+" "+weight+" "+"and type"+" "+trainType;
	}

	
}
