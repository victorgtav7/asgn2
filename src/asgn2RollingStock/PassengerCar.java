package asgn2RollingStock;

import asgn2Exceptions.*;

public class PassengerCar extends RollingStock {
	
	int weight;
	public int seats;
	public int numberofPassenger;	
	public PassengerCar(int grossWeight, int numberofSeat) throws TrainException
	{
		super(grossWeight);
		weight = grossWeight;
		seats = numberofSeat;
		numberofPassenger = 0;
		if (numberofSeat < 0)
			throw new TrainException("not a valid seat number");
		if (grossWeight < 1)
			throw new TrainException("not a valid weight");
	}

	//|| departingPassenger > numberofPassenger
	public void alight(int departingPassenger) throws TrainException
	{
		if(departingPassenger < 0 || departingPassenger > numberofPassenger)
			throw new TrainException("not a valid number of departing passenger or " +
					"number of departing passengers exceeds the number on board!");
		numberofPassenger = numberofPassenger - departingPassenger;

	}
	
	public int board(int boardingPassenger) throws TrainException
	{
		int remainingPassenger = 0;
		numberofPassenger = numberofPassenger + boardingPassenger;
		if (numberofPassenger > seats)
		{
			remainingPassenger = numberofPassenger - seats;
			numberofPassenger = seats;
		}
		if( boardingPassenger < 0)
			throw new TrainException("that is not a valid number of passenger");
		return remainingPassenger;
	}
	
	public int numberOnBoard()
	{
		return numberofPassenger;
	}
	
	public int numberofSeat()
	{
		return seats;
	}
	
	@Override
	public String toString() {
		return "Passenger Car with weight of "+ weight+ " and the passenger amoung is " + numberofPassenger+" out of " +seats ;
	}

}
