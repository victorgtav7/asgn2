package asgn2RollingStock;

import asgn2Exceptions.TrainException;

public class FreightCar extends RollingStock {

	/***
	 * @author Leander Beesie Liengkie N8682879
	 */
	Integer weight;
	public String type;
	public FreightCar(Integer grossWeight, String goodsType) throws TrainException
	{
		super(grossWeight);
		if (grossWeight < 1)
			throw new TrainException("It is not a valid weight!");
		if (goodsType.equals("R")||goodsType.equals("D")||goodsType.equals("G"))
		{
			weight = grossWeight;
			type = goodsType;
		}
		else
			throw new TrainException("it is not a valid goods type!");
	}
	
	public String GoodsType()
	{
		return type;
	}
	
	public String toString()
	{
		return "Freight Car with max weight = "+" "+ weight + " "+"and goods type" + " " + type;
	}

}
