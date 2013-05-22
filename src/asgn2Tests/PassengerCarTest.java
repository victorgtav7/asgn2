package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Exceptions.TrainException;
import asgn2RollingStock.PassengerCar;
import asgn2RollingStock.RollingStock;

public class PassengerCarTest {
	
	private RollingStock RollingStockTest;
	final Integer validWeight = 90;
	final Integer validNumberofSeat = 50;
	
	/**
	 * Create a new FreightCar instance and provide valid weight.
	 * @throws TrainException
	 */
	@Test
	public void testConstructorWithValidWeight() throws TrainException{
		RollingStockTest = new PassengerCar(validWeight, validNumberofSeat);
		assertTrue(validWeight == RollingStockTest.getGrossWeight());
	}
	
	/**
	 * Create a new FreightCar instance and provide invalid weight.
	 * @throws TrainException
	 */
	@Test (expected = TrainException.class)
	public void testConstructorWithInvalidWeight() throws TrainException{
		Integer invalidWeight = 0;
		RollingStockTest = new PassengerCar(invalidWeight, validNumberofSeat);
	}
	
	/**
	 * Create a new FreightCar instance and provide zero weight.
	 * @throws TrainException
	 */
	@Test (expected = TrainException.class)
	public void testConstructorWithNegativeWeight() throws TrainException{
		Integer negativeWeight = -1;
		RollingStockTest = new PassengerCar(negativeWeight, validNumberofSeat);
	}
	
	/**
	 * Create a new FreightCar instance and provide valid seat number.
	 * @throws TrainException
	 */
	@Test
	public void testConstructorWithValidSeat() throws TrainException{
		RollingStockTest = new PassengerCar(validWeight, validNumberofSeat);
		if (RollingStockTest instanceof PassengerCar){
			assertTrue(validNumberofSeat == ((PassengerCar) RollingStockTest).numberofSeat());
		}
	}
	
	/**
	 * Create a new FreightCar instance and provide invalid seat number.
	 * @throws TrainException
	 */
	@Test (expected = TrainException.class)
	public void testConstructorWithInvalidSeat() throws TrainException{
		Integer invalidNumberofSeat = -1;
		RollingStockTest = new PassengerCar(validWeight, invalidNumberofSeat);
	}
	
	/**
	 * Create a new FreightCar instance and zero number of seat.
	 * @throws TrainException
	 */
	@Test 
	public void testConstructorWithZeroSeat() throws TrainException{
		Integer zeroNumberofSeat = 0;
		RollingStockTest = new PassengerCar(validWeight, zeroNumberofSeat);
		if (RollingStockTest instanceof PassengerCar){
			assertTrue(zeroNumberofSeat == ((PassengerCar) RollingStockTest).numberofSeat());
		}
	}
	
	/**
	 * Create a new FreightCar instance and provide negative number of passenger boarding.
	 * @throws TrainException
	 */
	@Test (expected = TrainException.class)
	public void testInvalidNumberofPassengerBoard() throws TrainException{
		RollingStockTest = new PassengerCar(validWeight, validNumberofSeat);
		if (RollingStockTest instanceof PassengerCar){
			((PassengerCar) RollingStockTest).board(-1);
		}
	}
	
	/**
	 * Create a new FreightCar instance and excess number of passengers alighting.
	 * Expected a TrainException.
	 * @throws TrainException
	 */
	@Test (expected = TrainException.class)
	public void testDepartingPassengerExceedBoard() throws TrainException{
		Integer validBoardNumber = 40;
		Integer exceedBoardNumber = validBoardNumber + 1;
		RollingStockTest = new PassengerCar(validWeight, validNumberofSeat);
		if (RollingStockTest instanceof PassengerCar){
			((PassengerCar) RollingStockTest).board(validBoardNumber);
			((PassengerCar) RollingStockTest).alight(exceedBoardNumber);
		}
	}
	
	/**
	 * Create a new FreightCar instance and provide valid alight argument.
	 * @throws TrainException
	 */
	@Test 
	public void testAlightWorking() throws TrainException{
		Integer validBoardNumber = 40;
		Integer validAlightNumber = 30;
		Integer expectedResult = validBoardNumber - validAlightNumber;
		RollingStockTest = new PassengerCar(validWeight, validNumberofSeat);
		if (RollingStockTest instanceof PassengerCar){
			((PassengerCar) RollingStockTest).board(validBoardNumber);
			((PassengerCar) RollingStockTest).alight(validAlightNumber);
			assertTrue(expectedResult == ((PassengerCar) RollingStockTest).numberOnBoard());
		}
	}
	
	/**
	 * Create a new FreightCar instance and call alight before board.
	 * Expect a TrainException.
	 * @throws TrainException
	 */
	@Test (expected = TrainException.class)
	public void testAlightBeforeBoard() throws TrainException{
		Integer validBoardNumber = 40;
		Integer validAlightNumber = 30;
		RollingStockTest = new PassengerCar(validWeight, validNumberofSeat);
		if (RollingStockTest instanceof PassengerCar){
			((PassengerCar) RollingStockTest).alight(validAlightNumber);
			((PassengerCar) RollingStockTest).board(validBoardNumber);
		}
	}
	
	/**
	 * 
	 * @throws TrainException
	 */
	@Test (expected = TrainException.class)
	public void testInvalidNumberofPassengerAlight() throws TrainException{
		Integer validBoardNumber = 40;
		RollingStockTest = new PassengerCar(validWeight, validNumberofSeat);
		if (RollingStockTest instanceof PassengerCar){
			((PassengerCar) RollingStockTest).board(validBoardNumber);
			((PassengerCar) RollingStockTest).alight(-1);
		}
	}
	
	public void testValidNumberofPassengerBoard() throws TrainException{
		Integer validBoardNumber = 40;
		RollingStockTest = new PassengerCar(validWeight, validNumberofSeat);
		if (RollingStockTest instanceof PassengerCar){
			((PassengerCar) RollingStockTest).board(validBoardNumber);
			assertTrue(((PassengerCar) RollingStockTest).board(validBoardNumber) == 
					((PassengerCar) RollingStockTest).numberOnBoard());
		}
	}
	
	@Test
	public void testBoardIncrement() throws TrainException{
		Integer firstBoard = 20;
		Integer secondBoard = 30;
		Integer totalBoard = firstBoard + secondBoard;
		RollingStockTest = new PassengerCar(validWeight, validNumberofSeat);
		if (RollingStockTest instanceof PassengerCar){
			((PassengerCar) RollingStockTest).board(firstBoard);
			((PassengerCar) RollingStockTest).board(secondBoard);
			assertTrue(((PassengerCar) RollingStockTest).numberOnBoard() == totalBoard);
		}
	
	}
}
