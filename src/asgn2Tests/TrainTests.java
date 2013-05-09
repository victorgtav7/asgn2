package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Exceptions.TrainException;
import asgn2RollingStock.FreightCar;
import asgn2RollingStock.Locomotive;
import asgn2RollingStock.PassengerCar;
import asgn2RollingStock.RollingStock;
import asgn2Train.DepartingTrain;

public class TrainTests {
	private Integer validWeight = 90;
	private Integer validBoardNumber = 50;
	private Integer validSeatNumber = 75;
	private String validGoodType = "R";
	private String validClassification = "9D";
	
	
	/**
	 * Create a new Departing Train instance and immediately call next carriage before
	 * adding new carriage. Expect nextCarriage to return null before addCarriage.
	 * @throws TrainException
	 */
	@Test 
	public void testNextCarriageBeforeAddCarriage() throws TrainException{
		DepartingTrain TrainTest = new DepartingTrain();
		TrainTest.nextCarriage();
		assertTrue(TrainTest.nextCarriage() == null);
		Locomotive testLocomotive = new Locomotive(validWeight, validClassification);
		TrainTest.addCarriage(testLocomotive);
	}
	
	/**
	 *  Create a new Departing Train instance and immediately call first carriage before
	 *  adding new carriage. Expect firstCarriage to return null before addCarriage.
	 * @throws TrainException
	 */
	@Test 
	public void testFirstCarriageBeforeAddCarriage() throws TrainException {
		DepartingTrain TrainTest = new DepartingTrain();
		TrainTest.firstCarriage();
		assertTrue(TrainTest.firstCarriage() == null);
		Locomotive testLocomotive = new Locomotive(validWeight, validClassification);
		TrainTest.addCarriage(testLocomotive);
	}
	
	/**
	 * Create 2 new Departing Train instances and add the same carriage on both
	 * instances. Both firstCarriage and nextCarriage should be the same.
	 * @throws TrainException
	 */
	@Test
	public void testNextCarriageActAsFirstCarriage() throws TrainException{
		DepartingTrain TrainTest1 = new DepartingTrain();
		DepartingTrain TrainTest2 = new DepartingTrain();
		Locomotive testLocomotive = new Locomotive(validWeight, validClassification);
		TrainTest1.addCarriage(testLocomotive);
		TrainTest2.addCarriage(testLocomotive);
		assertTrue(TrainTest1.firstCarriage() == TrainTest2.nextCarriage());
	}
	
	/**
	 *  Create a new Departing Train instance and call Board with valid argument
	 * @throws TrainException
	 */
	@Test
	public void testBoardWithValidArgument() throws TrainException{
		DepartingTrain TrainTest = new DepartingTrain();
		
		Locomotive testLocomotive = new Locomotive(validWeight, validClassification);
		PassengerCar testPassenger = new PassengerCar(validWeight, validSeatNumber);
		TrainTest.addCarriage(testLocomotive);
		TrainTest.addCarriage(testPassenger);
		TrainTest.board(validBoardNumber);
		assertTrue(TrainTest.numberOnBoard() == validBoardNumber);
	}
	
	/**
	 *  Create a new Departing Train instance and Board with excess number of 
	 *  passengers. The number on board should be matched with the number of seat
	 * @throws TrainException
	 */
	@Test
	public void testBoardExcessPassenger() throws TrainException{
		DepartingTrain TrainTest = new DepartingTrain();
		Integer excessBoardNumber = 100;
		
		Locomotive testLocomotive = new Locomotive(validWeight, validClassification);
		PassengerCar testPassenger = new PassengerCar(validWeight, validSeatNumber);
		TrainTest.addCarriage(testLocomotive);
		TrainTest.addCarriage(testPassenger);
		TrainTest.board(excessBoardNumber);
		
		assertTrue(TrainTest.numberOnBoard() == TrainTest.numberOfSeats());
	}
	
	/**
	 *  Create a new Departing Train instance and call two locomotive carriages.
	 *  Expect a TrainException.
	 * @throws TrainException
	 */
	@Test (expected = TrainException.class)
	public void testTwoLocomotive() throws TrainException{
		DepartingTrain TrainTest = new DepartingTrain();
		Locomotive Locomotive1 = new Locomotive(validWeight, validClassification);
		Locomotive Locomotive2 = new Locomotive(validWeight, validClassification);
		TrainTest.addCarriage(Locomotive1);
		TrainTest.addCarriage(Locomotive2);
	}
	
	/**
	 *  Create a new Departing Train instance and add locomotive carriage with 
	 *  valid argument.
	 * @throws TrainException
	 */
	@Test
	public void testLocomotiveWithValidArgument() throws TrainException{
		DepartingTrain TrainTest = new DepartingTrain();
		Locomotive testLocomotive = new Locomotive(validWeight, validClassification);
		TrainTest.addCarriage(testLocomotive);
	}
	
	/**
	 *  Create a new Departing Train instance and add passenger carriages with
	 *  valid argument.
	 * @throws TrainException
	 */
	@Test
	public void testPassengerCarWithValidArgument() throws TrainException{
		DepartingTrain TrainTest = new DepartingTrain();
		Locomotive testLocomotive = new Locomotive(validWeight, validClassification);
		PassengerCar PassengerCar1 = new PassengerCar(validWeight, validSeatNumber);
		PassengerCar PassengerCar2 = new PassengerCar(validWeight, validSeatNumber);
		TrainTest.addCarriage(testLocomotive);
		TrainTest.addCarriage(PassengerCar1);
		TrainTest.addCarriage(PassengerCar2);
	}
	
	/**
	 *  Create a new Departing Train instance and add freight carriages with
	 *  valid argument.
	 * @throws TrainException
	 */
	@Test
	public void testFreightCarWithValidArgument() throws TrainException{
		DepartingTrain TrainTest = new DepartingTrain();
		Locomotive testLocomotive = new Locomotive(validWeight, validClassification);
		FreightCar FreightCar1 = new FreightCar(validWeight, validGoodType);
		FreightCar FreightCar2 = new FreightCar(validWeight, validGoodType);
		TrainTest.addCarriage(testLocomotive);
		TrainTest.addCarriage(FreightCar1);
		TrainTest.addCarriage(FreightCar2);
	}
	
	/**
	 *  Create a new Departing Train instance and add passenger carriage before locomotive.
	 *  Expect a TrainException.
	 * @throws TrainException
	 */
	@Test (expected = TrainException.class)
	public void testAddPassengerCarBeforeLocomotive() throws TrainException{
		DepartingTrain TrainTest = new DepartingTrain();
		Locomotive testLocomotive = new Locomotive(validWeight, validClassification);
		PassengerCar testPassengerCar = new PassengerCar(validWeight, validSeatNumber);
		TrainTest.addCarriage(testPassengerCar);
		TrainTest.addCarriage(testLocomotive);
	}
	
	/**
	 *  Create a new Departing Train instance and add freight carriage before locomotive.
	 *  Expect a TrainException.
	 * @throws TrainException
	 */
	@Test (expected = TrainException.class)
	public void testAddFreightCarBeforeLocomotive() throws TrainException{
		DepartingTrain TrainTest = new DepartingTrain();
		Locomotive testLocomotive = new Locomotive(validWeight, validClassification);
		FreightCar testFreightCar = new FreightCar(validWeight, validGoodType);
		TrainTest.addCarriage(testFreightCar);
		TrainTest.addCarriage(testLocomotive);
	}
	
	/**
	 *  Create a new Departing Train instance and add freight carriage before 
	 *  passenger carriage.
	 *  Expect a TrainException.
	 * @throws TrainException
	 */
	@Test (expected = TrainException.class)
	public void testAddFreightCarBeforePassenger() throws TrainException{
		DepartingTrain TrainTest = new DepartingTrain();
		Locomotive testLocomotive = new Locomotive(validWeight, validClassification);
		PassengerCar testPassengerCar = new PassengerCar(validWeight, validSeatNumber);
		FreightCar testFreightCar = new FreightCar(validWeight, validGoodType);
		TrainTest.addCarriage(testLocomotive);
		TrainTest.addCarriage(testFreightCar);
		TrainTest.addCarriage(testPassengerCar);
	}
	
	/**
	 *  Create a new Departing Train instance and immediately call board before adding
	 *  any carriages. The number on board should be zero.
	 * @throws TrainException
	 */
	@Test 
	public void testBoardBeforeAddCarriage() throws TrainException{
		DepartingTrain TrainTest = new DepartingTrain();
		Integer zeroPassengerBoard = 0;
		TrainTest.board(validBoardNumber);
		assertTrue(TrainTest.numberOnBoard() == zeroPassengerBoard);
		
	}
	
	/**
	 *  Create a new Departing Train instance and call board with only locomotive carriage.
	 *  The number on board should be zero.
	 * @throws TrainException
	 */
	@Test
	public void testBoardWithOnlyLocomotiveCarriage() throws TrainException{
		DepartingTrain TrainTest = new DepartingTrain();
		Integer zeroPassengerBoard = 0;
		
		Locomotive testLocomotive = new Locomotive(validWeight, validClassification);
		TrainTest.addCarriage(testLocomotive);
		TrainTest.board(validBoardNumber);
		
		assertTrue(TrainTest.numberOnBoard() == zeroPassengerBoard);
	}
	
	/**
	 *  Create a new Departing Train instance with valid train configuration (contain passenger)
	 *  After all the passengers have alight, attempt to remove a carriage.
	 * @throws TrainException
	 */
	@Test
	public void testAddRemoveCarriageAfterShuntingOperation() throws TrainException{
		Integer validAlightNumber = validBoardNumber;
		DepartingTrain TrainTest = new DepartingTrain();
		Locomotive testLocomotive = new Locomotive(validWeight, validClassification);
		PassengerCar testPassengerCar1 = new PassengerCar(validWeight, validSeatNumber);
		TrainTest.addCarriage(testLocomotive);
		TrainTest.addCarriage(testPassengerCar1);
		TrainTest.board(validBoardNumber);
		testPassengerCar1.alight(validAlightNumber);
		TrainTest.removeCarriage();
	}
	
	/**
	 *  Create a new Departing Train instance with valid train configuration (contain passenger).
	 *  After all the passengers have alight, attempt to add a carriage
	 * @throws TrainException
	 */
	@Test
	public void testAddNewCarriageAfterShuntingOperation() throws TrainException{
		Integer validAlightNumber = validBoardNumber;
		DepartingTrain TrainTest = new DepartingTrain();
		Locomotive testLocomotive = new Locomotive(validWeight, validClassification);
		PassengerCar testPassengerCar1 = new PassengerCar(validWeight, validSeatNumber);
		PassengerCar testPassengerCar2 = new PassengerCar(validWeight, validSeatNumber);
		TrainTest.addCarriage(testLocomotive);
		TrainTest.addCarriage(testPassengerCar1);
		TrainTest.board(validBoardNumber);
		testPassengerCar1.alight(validAlightNumber);
		TrainTest.addCarriage(testPassengerCar2);
	}
	
	/**
	 *  Create a new Departing Train instance with excess number of alight passengers.
	 *  Expect a TrainException.
	 * @throws TrainException
	 */
	@Test (expected = TrainException.class)
	public void testExcessAlight() throws TrainException{
		Integer excessAlightNumber = validBoardNumber + 1;
		DepartingTrain TrainTest = new DepartingTrain();
		Locomotive testLocomotive = new Locomotive(validWeight, validClassification);
		PassengerCar testPassengerCar = new PassengerCar(validWeight, validSeatNumber);
		TrainTest.addCarriage(testLocomotive);
		TrainTest.addCarriage(testPassengerCar);
		TrainTest.board(validBoardNumber);
		testPassengerCar.alight(excessAlightNumber);
	}
	
	/**
	 *  Create a new Departing Train instance and call alight before calling board.
	 *  Expect a TrainException.
	 * @throws TrainException
	 */
	@Test (expected = TrainException.class)
	public void testAlightBeforeBoard() throws TrainException{
		Integer validAlightNumber = validSeatNumber - validBoardNumber;
		DepartingTrain TrainTest = new DepartingTrain();
		Locomotive testLocomotive = new Locomotive(validWeight, validClassification);
		PassengerCar testPassengerCar = new PassengerCar(validWeight, validSeatNumber);
		TrainTest.addCarriage(testLocomotive);
		TrainTest.addCarriage(testPassengerCar);
		testPassengerCar.alight(validAlightNumber);
		TrainTest.board(validBoardNumber);
	}
	
	/**
	 *  Create a new Departing Train instance and call alight with valid argument.
	 * @throws TrainException
	 */
	@Test
	public void testAlightWorking() throws TrainException{
		Integer validAlightNumber = validSeatNumber - validBoardNumber;
		Integer expectedResult = validBoardNumber - validAlightNumber;
		DepartingTrain TrainTest = new DepartingTrain();
		Locomotive testLocomotive = new Locomotive(validWeight, validClassification);
		PassengerCar testPassengerCar = new PassengerCar(validWeight, validSeatNumber);
		TrainTest.addCarriage(testLocomotive);
		TrainTest.addCarriage(testPassengerCar);
		TrainTest.board(validBoardNumber);
		testPassengerCar.alight(validAlightNumber);
		assertTrue(TrainTest.numberOnBoard() == expectedResult);
		
	}
	
	/**
	 *  Create a new Departing Train instance and remove carriages with valid argument
	 * @throws TrainException
	 */
	@Test
	public void testRemoveCarriageWorking() throws TrainException{
		DepartingTrain TrainTest = new DepartingTrain();
		Locomotive testLocomotive = new Locomotive(validWeight, validClassification);
		FreightCar testFreightCar = new FreightCar(validWeight, validGoodType);
		TrainTest.addCarriage(testLocomotive);
		TrainTest.addCarriage(testFreightCar);
		TrainTest.removeCarriage();
		TrainTest.removeCarriage();
	}
	
	/**
	 *  Create a new Departing Train instance and attempt to add carriage with
	 *  passengers on board.
	 *  Expect a TrainException.
	 * @throws TrainException
	 */
	@Test (expected = TrainException.class)
	public void testAddCarriageWithPassenger() throws TrainException{
		DepartingTrain TrainTest = new DepartingTrain();
		Locomotive testLocomotive = new Locomotive(validWeight, validClassification);
		PassengerCar testPassengerCar = new PassengerCar(validWeight, validSeatNumber);
		FreightCar testFreightCar = new FreightCar(validWeight, validGoodType);
		TrainTest.addCarriage(testLocomotive);
		TrainTest.addCarriage(testPassengerCar);
		TrainTest.board(validBoardNumber);
		TrainTest.addCarriage(testFreightCar);
	}
	
	/**
	 *  Create a new Departing Train instance and attempt to remove carriage with 
	 *  passengers on board.
	 *  Expect a TrainException.
	 * @throws TrainException
	 */
	@Test (expected = TrainException.class)
	public void testRemoveCarriageWithPassenger() throws TrainException{
		DepartingTrain TrainTest = new DepartingTrain();
		Locomotive testLocomotive = new Locomotive(validWeight, validClassification);
		PassengerCar testPassengerCar = new PassengerCar(validWeight, validSeatNumber);
		TrainTest.addCarriage(testLocomotive);
		TrainTest.addCarriage(testPassengerCar);
		TrainTest.board(validBoardNumber);
		TrainTest.removeCarriage();
	}
	
	/**
	 * Create a new Departing Train instance and remove carriages more than it should.
	 * Expect a TrainException.
	 * @throws TrainException
	 */
	@Test (expected = TrainException.class)
	public void testRemoveCarraigeWithNoCarriage() throws TrainException{
		DepartingTrain TrainTest = new DepartingTrain();
		Locomotive testLocomotive = new Locomotive(validWeight, validClassification);
		FreightCar testFreightCar = new FreightCar(validWeight, validGoodType);
		TrainTest.addCarriage(testLocomotive);
		TrainTest.addCarriage(testFreightCar);
		TrainTest.removeCarriage();
		TrainTest.removeCarriage();
		TrainTest.removeCarriage();
	}
	
	/**
	 * Create a new Departing Train instance and see if train can move with 
	 * valid train configuration.
	 * @throws TrainException
	 */
	@Test
	public void testTrainCanMoveWithValidArgument() throws TrainException{
		DepartingTrain TrainTest = new DepartingTrain();
		Locomotive testLocomotive = new Locomotive(validWeight, validClassification);
		PassengerCar testPassengerCar = new PassengerCar(validWeight, validSeatNumber);
		FreightCar testFreightCar = new FreightCar(validWeight, validGoodType);
		TrainTest.addCarriage(testLocomotive);
		TrainTest.addCarriage(testPassengerCar);
		TrainTest.addCarriage(testFreightCar);
		assertTrue(TrainTest.trainCanMove());
	}
	
	/**
	 * Create a new Departing Train instance and see if train cannot move with
	 * invalid train configuration.
	 * @throws TrainException
	 */
	@Test
	public void testTrainCannotMoveWithInvalidArgument() throws TrainException{
		Integer maxWeightLoco = 180;
		DepartingTrain TrainTest = new DepartingTrain();
		Locomotive testLocomotive = new Locomotive(maxWeightLoco, validClassification);
		PassengerCar testPassengerCar1 = new PassengerCar(validWeight, validSeatNumber);
		PassengerCar testPassengerCar2 = new PassengerCar(validWeight, validSeatNumber);
		PassengerCar testPassengerCar3 = new PassengerCar(validWeight, validSeatNumber);
		PassengerCar testPassengerCar4 = new PassengerCar(validWeight, validSeatNumber);
		PassengerCar testPassengerCar5 = new PassengerCar(validWeight, validSeatNumber);
		PassengerCar testPassengerCar6 = new PassengerCar(validWeight, validSeatNumber);
		PassengerCar testPassengerCar7 = new PassengerCar(validWeight, validSeatNumber);
		PassengerCar testPassengerCar8 = new PassengerCar(validWeight, validSeatNumber);
		FreightCar testFreightCar = new FreightCar(validWeight, validGoodType);
		TrainTest.addCarriage(testLocomotive);
		TrainTest.addCarriage(testPassengerCar1);
		TrainTest.addCarriage(testPassengerCar2);
		TrainTest.addCarriage(testPassengerCar3);
		TrainTest.addCarriage(testPassengerCar4);
		TrainTest.addCarriage(testPassengerCar5);
		TrainTest.addCarriage(testPassengerCar6);
		TrainTest.addCarriage(testPassengerCar7);
		TrainTest.addCarriage(testPassengerCar8);
		TrainTest.addCarriage(testFreightCar);
		assertFalse(TrainTest.trainCanMove());
	}
	
	/**
	 * Create a new Departing Train instance and continuously call nextCarriage,
	 * even though that particular carriage does not exist. Expecting null value.
	 * @throws TrainException
	 */
	@Test
	public void testExcessNextCarriage() throws TrainException{
		DepartingTrain TrainTest = new DepartingTrain();
		Locomotive testLocomotive = new Locomotive(validWeight, validClassification);
		PassengerCar testPassengerCar = new PassengerCar(validWeight, validSeatNumber);
		FreightCar testFreightCar = new FreightCar(validWeight, validGoodType);
		TrainTest.addCarriage(testLocomotive);
		TrainTest.addCarriage(testPassengerCar);
		TrainTest.addCarriage(testFreightCar);
		TrainTest.firstCarriage();
		TrainTest.nextCarriage();
		TrainTest.nextCarriage();
		assertTrue(TrainTest.nextCarriage() == null);
	}
}
