package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Exceptions.TrainException;
import asgn2RollingStock.FreightCar;
import asgn2RollingStock.RollingStock;

public class RollingStockTest extends Object{
	
	private RollingStock RollingStockTest;
	
	
	/*@Test
	public void testConstructorWithValidWeight() throws TrainException{
		Integer validWeight = 100;
		String validGoodType = "R";
		RollingStockTest = new RollingStock(validWeight, validGoodType);
		assertTrue(validWeight == RollingStockTest.getGrossWeight());
	}*/
	
	@Test
	public void testConstructorWithValidGoodType() throws TrainException{
		int validWeight = 100;
		String validGoodType = "R";
		RollingStockTest = new FreightCar(validWeight, validGoodType);
		if(RollingStockTest instanceof FreightCar){
			assertTrue(validGoodType == ((FreightCar) RollingStockTest).GoodsType());
		}
	}
	


}
