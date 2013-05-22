package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.TrainException;
import asgn2RollingStock.Locomotive;
import asgn2RollingStock.RollingStock;

public class LocomotiveTest {
	
	private RollingStock RollingStockTest;
	final Integer validWeight = 100;
	final String validClassification = "1E";
	
	/**
	 * Create a new Locomotive instance and provide valid weight.
	 * @throws TrainException
	 */
	@Test
	public void testConstructorWithValidWeight() throws TrainException{
		RollingStockTest = new Locomotive(validWeight, validClassification);
		assertTrue(validWeight == RollingStockTest.getGrossWeight());
	}
	
	/**
	 * Create a new Locomotive instance and provide zero weight.
	 * Expect a TrainException.
	 * @throws TrainException
	 */
	@Test (expected = TrainException.class)
	public void testConstructorWithZeroWeight() throws TrainException{
		int zeroWeight = 0;
		RollingStockTest = new Locomotive(zeroWeight, validClassification);
	}

	
	/**
	 * Create a new Locomotive instance and provide negative weight.
	 * Expect a TrainException.
	 * @throws TrainException
	 */
	@Test (expected = TrainException.class)
	public void testConstructorWithNegativeWeight() throws TrainException{
		int negativeWeight = -1;
		RollingStockTest = new Locomotive(negativeWeight, validClassification);
	}
	
	/**
	 * Create a new Locomotive instance and provide the lowest power.
	 * @throws TrainException
	 */
	@Test
	public void testConstructorWithLowestPowerClass() throws TrainException{
		char[] powerChar;
		powerChar = validClassification.toCharArray();
		int powerClass = Integer.parseInt(String.valueOf(powerChar[0]))*100;
		
		RollingStockTest = new Locomotive(validWeight, validClassification);
		if (RollingStockTest instanceof Locomotive){
			assertTrue(powerClass == ((Locomotive) RollingStockTest).power());
		}
	}
	
	/**
	 * Create a new Locomotive instance and provide highest weight.
	 * @throws TrainException
	 */
	@Test
	public void testConstructorWithHighestPowerClass() throws TrainException{
		char[] powerChar;
		powerChar = validClassification.toCharArray();
		int powerClass = Integer.parseInt(String.valueOf(powerChar[0]))*100;
		
		RollingStockTest = new Locomotive(validWeight, validClassification);
		if (RollingStockTest instanceof Locomotive){
			assertTrue(powerClass == ((Locomotive) RollingStockTest).power());
		}
	}
	
	/**
	 * Create a new Locomotive instance and provide power less than its bound.
	 * Expect a TrainException.
	 * @throws TrainException
	 */
	@Test (expected = TrainException.class)
	public void testConstructorWithLessPowerClass() throws TrainException{
		int validWeight = 100;
		String invalidLowerClassification = "0E";
		RollingStockTest = new Locomotive(validWeight, invalidLowerClassification);
	}
	
	/**
	 * Create a new Locomotive instance and provide power more than its bound.
	 * Expect a TrainException.
	 * @throws TrainException
	 */
	@Test (expected = TrainException.class)
	public void testConstructorWithMorePowerClass() throws TrainException{
		int validWeight = 100;
		String invalidUpperClassification = "10E";
		RollingStockTest = new Locomotive(validWeight, invalidUpperClassification);
	}

}
