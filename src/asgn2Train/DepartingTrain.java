package asgn2Train;

import asgn2RollingStock.*;
import asgn2Exceptions.TrainException;

import java.util.ArrayList;


public class DepartingTrain extends Object{

	//RollingStock[] arrayofTrain = new RollingStock[10];
	ArrayList<RollingStock> trainArray = new ArrayList();
	public int index =0;
	public boolean carriageFlag = false;
	int seats;
	public int trainIndex = 0;
	public DepartingTrain() {
	}
	
	public RollingStock firstCarriage(){
		if (trainIndex == 0){
			return null;
		} 
		else {
			carriageFlag = true;
			return trainArray.get(0);
		}
	}


	public RollingStock nextCarriage(){
		if (trainIndex == 0){
			return null;
		}
		if (index == 0 && carriageFlag == false){
			carriageFlag = true;
			return trainArray.get(0);
		}
		else if (index >= trainIndex-1){
			return null;
		}
		else if (index == 0 && carriageFlag == true){
			index++;
			return trainArray.get(index);
		}
		else{
			index++;
			return trainArray.get(index);
		}
	}
	
	public Integer numberOnBoard() throws TrainException{
		Integer totalBoard = 0;
		Integer x=0, i=0;
		while (i < trainIndex){
			if (trainArray.get(i) instanceof PassengerCar)
			{
				PassengerCar temp = (PassengerCar)trainArray.get(i);			 
				x = temp.numberOnBoard();
				totalBoard = totalBoard + x;
			}
			i++;
		}
		return totalBoard;
	}
	
	
	public Integer numberOfSeats() throws TrainException{
		int x=0 , i=0, totalSeat= 0;
		while (i < trainIndex)
		{
			if (trainArray.get(i) instanceof PassengerCar)
			{
				PassengerCar temp = (PassengerCar)trainArray.get(i);			 
				x = temp.numberofSeat();
				totalSeat = totalSeat + x;
			}
			i++;
		}
		return totalSeat;
	}
	
	public Integer board(Integer newPassengers) throws TrainException{
		if (newPassengers < 0){
			throw new TrainException("Number of new passenger cannot be negative");
		}
		int x=0 , i=0;
		while(i < trainIndex){
			if (trainArray.get(i) instanceof PassengerCar)
			{
				PassengerCar temp = (PassengerCar)trainArray.get(i);			 
				x = temp.board(newPassengers);	
				newPassengers = x;
			}
		i++;
		}
		return newPassengers;
	}
	
	public boolean trainCanMove(){
		int totalWeight = 0, x= 0, power = 0;
		boolean canMove = false;
		for(int i = 0; i < trainIndex;i++){
			x = trainArray.get(i).getGrossWeight();			 
			totalWeight = totalWeight +x;
		}
		Locomotive temp = (Locomotive)trainArray.get(0);
		if(temp.power() >= totalWeight)
			canMove = true;
		return canMove;
	}
	
	public void addCarriage(RollingStock newCarriage) throws TrainException{
		if (this.numberOnBoard() > 0)
			throw new TrainException("asd");
		
		if(trainIndex == 0)
		{
			if (newCarriage instanceof Locomotive)
			{
				trainArray.add(newCarriage);
				trainIndex++;
			}
			else 
			{
				throw new TrainException("this will cause incorrect configuration");
			}
		}
		else if (trainIndex > 0)
		{
			//condition where Passenger car comes after Loco
			if ((newCarriage instanceof PassengerCar) && (trainIndex == 1))
			{
				trainArray.add(newCarriage);
				trainIndex++;
			}
			//condition where Passenger car comes after Loco-Pass
			else if((newCarriage instanceof PassengerCar)&&(trainIndex > 1)&&(trainArray.get(trainIndex-1) instanceof PassengerCar))
			{
				trainArray.add(newCarriage);
				trainIndex++;
			}
			//condition where freight car comes after Loco
			else if((newCarriage instanceof FreightCar)&& (trainIndex == 1))
			{
				trainArray.add(newCarriage);
				trainIndex++;
			}
			//condition where freight car comes after Loco-Pass
			else if((newCarriage instanceof FreightCar)&& (trainIndex>1)&&(trainArray.get(trainIndex-1) instanceof PassengerCar))
			{
				trainArray.add(newCarriage);
				trainIndex++;	
			}
			//condition where freight car comes after Loco-Pass-Freight
			else if ((newCarriage instanceof FreightCar)&& (trainIndex>1)&&(trainArray.get(trainIndex-1) instanceof FreightCar))
			{
				trainArray.add(newCarriage);
				trainIndex++;
			}
			//condition where locomotive comes after anything else after Loco
			else if(newCarriage instanceof Locomotive)
			{
				throw new TrainException("");
			}
			
			//condition where Pass come after Freight
			else if((newCarriage instanceof PassengerCar)&&(trainArray.get(trainIndex-1) instanceof FreightCar))
			{
				throw new TrainException("after freight");
			}
		}
	
		
	}

	public void removeCarriage() throws TrainException{
		if (trainIndex < 1){
			throw new TrainException("No rolling stock on the train or " +
					"");
		}
		if(this.numberOnBoard() > 0)
			throw new TrainException("passenger(s) exist on board");
		/*PassengerCar temp; 
		
		if (trainArray.get(trainArray.size()-1) instanceof PassengerCar){
			temp = (PassengerCar)trainArray.get(trainArray.size()-1);
			if(temp.numberofPassenger > 0)
				throw new TrainException("passenger(s) exist on board");
		}*/
		trainArray.remove(trainArray.size()-1);
		trainIndex--;
	}
	
	@Override
	public String toString(){
		String locoStat="", passStat = "", freiStat = "";
		Locomotive tempLoco;
		PassengerCar tempPass;
		FreightCar tempFreight;
		for(int i = 0; i < trainIndex;i++)
		{
			if(i == 0)
			{
				tempLoco = (Locomotive)trainArray.get(0);
				locoStat = "Loco("+tempLoco.trainClass+")";
			}
			if(trainArray.get(i) instanceof PassengerCar)
			{
				tempPass = (PassengerCar)trainArray.get(i);
				passStat = passStat +" - Passenger ("+tempPass.numberofPassenger+"/"+tempPass.seats+")";
			}
			if(trainArray.get(i) instanceof FreightCar)
			{
				tempFreight = (FreightCar)trainArray.get(i);
				freiStat = freiStat +" - Freight ("+tempFreight.type+")";
			}
			
		}
		return locoStat +passStat+freiStat;
	}
	
	
	public static void main(String[] args) throws TrainException {
		
		
		DepartingTrain test = new DepartingTrain();
		Locomotive x = new Locomotive(200, "9D");
		
		PassengerCar z = new PassengerCar(100, 50);
		
		PassengerCar a = new PassengerCar(100, 60);
		
		FreightCar y = new FreightCar(100, "R");
		
		FreightCar v = new FreightCar(100, "D");
		
		test.addCarriage(x);
	
		test.addCarriage(z);
		test.addCarriage(a);
		test.addCarriage(y);
		
		test.addCarriage(v);
		System.out.println("Number of Seats Availabel on this Train = " + test.numberOfSeats());
		
		System.out.println("remaining Passenger that cannot Board = "+ test.board(90));
		System.out.println(test.numberOnBoard());

		System.out.println(test.firstCarriage() == test.nextCarriage());
		
		System.out.println(test.firstCarriage());
		System.out.println(test.nextCarriage());
		System.out.println(test.nextCarriage());
		System.out.println(test.nextCarriage());
		System.out.println(test.nextCarriage());
		System.out.println(test.nextCarriage());
		System.out.println(test.trainCanMove());
		System.out.println(test);
		/*
		FreightCar o = new FreightCar(100, "D");
		z.alight(50);
		a.alight(40);
		System.out.println(test.numberOnBoard());
		System.out.println(test);
		//test.addCarriage(o);
		test.removeCarriage();
		test.removeCarriage();
		System.out.println(test.trainCanMove());*/
		
		
	}
	

}
