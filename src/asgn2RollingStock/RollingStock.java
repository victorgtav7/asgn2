package asgn2RollingStock;

import asgn2Exceptions.TrainException;

public abstract class RollingStock extends Object{
	
	int weight, seats;
	public RollingStock (Integer grossWeight) throws TrainException {
		if (grossWeight < 0){
			throw new TrainException("The gross weight must be positive");
		}
			this.weight = grossWeight;
	}
	
	public Integer getGrossWeight(){
		return weight;
	}
	
	@Override 
	public abstract String toString();


	


}
