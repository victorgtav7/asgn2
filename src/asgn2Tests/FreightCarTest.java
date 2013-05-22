package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Exceptions.TrainException;
import asgn2RollingStock.FreightCar;
import asgn2RollingStock.RollingStock;

public class FreightCarTest {
	
	private RollingStock RollingStockTest;
	final Integer validWeight = 90;
	final String validGoodType = "R";
	
	
	/**
	 * Create a new FreightCar instance and provide valid weight.
	 * @throws TrainException
	 */
	@Test
	public void testConstructorWithValidWeight() throws TrainException{
		RollingStockTest = new FreightCar(validWeight, validGoodType);
		assertTrue(validWeight == RollingStockTest.getGrossWeight());
	}
	
	
	/**
	 * Create a new FreightCar instance and provide weight zero.
	 * Expect a TrainException.
	 * @throws TrainException
	 */
	@Test (expected = TrainException.class)
	public void testConstructorWithZeroWeight() throws TrainException{
		int zeroWeight = 0;
		RollingStockTest = new FreightCar(zeroWeight, validGoodType);
	}
	
	/**
	 * Create a new FreightCar instance and provide negative weight.
	 * Expect a TrainException.
	 * @throws TrainException
	 */
	@Test (expected = TrainException.class)
	public void testConstructorWithNegativeWeight() throws TrainException{
		int negativeWeight = -1;
		RollingStockTest = new FreightCar(negativeWeight, validGoodType);
	}

	
	/**
	 * Create a new FreightCar instance and provide valid good type.
	 * @throws TrainException
	 */
	@Test
	public void testConstructorWithValidGoodType() throws TrainException{
		RollingStockTest = new FreightCar(validWeight, validGoodType);
		if (RollingStockTest instanceof FreightCar){
			assertTrue(validGoodType == ((FreightCar) RollingStockTest).GoodsType());
		}
	}
	
	/**
	 * Create a new FreightCar instance and provide invalid good type.
	 * Expected a TrainException.
	 * @throws TrainException
	 */
	@Test (expected = TrainException.class)
	public void testConstructorWithInvalidGoodType() throws TrainException{
		String invalidGoodType = "A";
		RollingStockTest = new FreightCar(validWeight, invalidGoodType);
	}
		
}
