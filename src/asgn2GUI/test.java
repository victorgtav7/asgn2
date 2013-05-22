package asgn2GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import asgn2Exceptions.TrainException;
import asgn2Train.DepartingTrain;
import asgn2Exceptions.TrainException;
import asgn2RollingStock.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JPanel;
import java.awt.ScrollPane;
import java.awt.Font;
import java.awt.Color;

public class test {

	private JFrame frame;
	private final JRadioButton rdbtnLocomotive = new JRadioButton("Locomotive");
	private JTextField txtWeight;
	private JTextField txtVarious;
	
	private DepartingTrain Train = new DepartingTrain();
	private RollingStock newCarriage;
	private JPanel panel;
	int trainLabelIndex, weight, power, freightCount = 0;
	final JLabel[] trainLabel;
	final JLabel[] trainStatusLabel;
	private JTextField txtBoarding;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		trainLabelIndex = 0;
		weight = 0;
		trainLabel = new JLabel[30];
		trainStatusLabel = new JLabel[30];
		initialize();

	}
	
	
	/**
	 * Method for Update label on the top of each train image
	 */
	public void Update()
	{
		Train.firstCarriage();
		for(int i = 1; i < (Train.trainIndex);i++)
		{
			if(Train.nextCarriage() instanceof FreightCar)
				break;
			Train.index--;
			PassengerCar temp = (PassengerCar)Train.nextCarriage();
			trainStatusLabel[i].setText(temp.numberofPassenger+"/"+temp.seats);
	
		}
		
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 603, 431);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		rdbtnLocomotive.setBounds(174, 7, 0, 0);
		frame.getContentPane().add(rdbtnLocomotive);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 277, 151);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnRemoveLastTrain = new JButton("Remove Last Train");
		btnRemoveLastTrain.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		btnRemoveLastTrain.setBounds(106, 92, 137, 23);
		panel.add(btnRemoveLastTrain);
		
		JButton btnAddTrain = new JButton("Add Train");
		btnAddTrain.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAddTrain.setBounds(6, 92, 89, 23);
		panel.add(btnAddTrain);
		
		final JLabel lblVarious = new JLabel("Power :");
		lblVarious.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblVarious.setBounds(6, 64, 75, 14);
		panel.add(lblVarious);
		
		
		lblVarious.setHorizontalAlignment(SwingConstants.TRAILING);
		lblVarious.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		txtVarious = new JTextField();
		txtVarious.setBounds(96, 61, 86, 20);
		panel.add(txtVarious);
		txtVarious.setColumns(10);
		
		
		txtWeight = new JTextField();
		txtWeight.setBounds(97, 34, 86, 20);
		panel.add(txtWeight);
		txtWeight.setColumns(10);
		final JLabel lblGrossWeight = new JLabel("Gross Weight :");
		lblGrossWeight.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGrossWeight.setBounds(10, 37, 75, 14);
		panel.add(lblGrossWeight);
		
		
		lblGrossWeight.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGrossWeight.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblGrossWeight.setVerticalAlignment(SwingConstants.BOTTOM);
		
		final JRadioButton rdoLocomotive = new JRadioButton("Locomotive");
		rdoLocomotive.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdoLocomotive.setBounds(6, 7, 79, 23);
		panel.add(rdoLocomotive);
		
		final JRadioButton rdoPassengerCar = new JRadioButton("Passenger Car");
		rdoPassengerCar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdoPassengerCar.setBounds(87, 7, 95, 23);
		panel.add(rdoPassengerCar);
		
		final JRadioButton rdoFreightCar = new JRadioButton("Freight Car");
		rdoFreightCar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdoFreightCar.setBounds(184, 7, 79, 23);
		panel.add(rdoFreightCar);
		
		final Panel panel_1 = new Panel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(293, 10, 278, 152);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPassengerBoarding = new JLabel("Passenger Boarding");
		lblPassengerBoarding.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassengerBoarding.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPassengerBoarding.setBounds(10, 11, 162, 14);
		panel_1.add(lblPassengerBoarding);
		
		txtBoarding = new JTextField();
		txtBoarding.setBounds(182, 8, 86, 20);
		panel_1.add(txtBoarding);
		txtBoarding.setColumns(10);
		
		JLabel lblNumberOfSeat = new JLabel("Number of Seat Available");
		lblNumberOfSeat.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNumberOfSeat.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNumberOfSeat.setBounds(10, 39, 162, 14);
		panel_1.add(lblNumberOfSeat);
		
		final JLabel lblSeatAvailable = new JLabel("x");
		lblSeatAvailable.setBounds(182, 39, 46, 14);
		panel_1.add(lblSeatAvailable);
		
		JLabel lblTrainStatus = new JLabel("Train Status");
		lblTrainStatus.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTrainStatus.setBounds(39, 64, 133, 14);
		panel_1.add(lblTrainStatus);
		
		final JLabel lblStatus = new JLabel("Full");
		lblStatus.setBounds(182, 64, 46, 14);
		panel_1.add(lblStatus);
		
		JLabel lblExcessivePassenger = new JLabel("Excessive Passenger");
		lblExcessivePassenger.setHorizontalAlignment(SwingConstants.TRAILING);
		lblExcessivePassenger.setBounds(49, 89, 123, 14);
		panel_1.add(lblExcessivePassenger);
		
		final JLabel lblExcesivePassenger = new JLabel("x");
		lblExcesivePassenger.setBounds(182, 89, 46, 14);
		panel_1.add(lblExcesivePassenger);
		
		JButton btnNewButton = new JButton("Board");
		
		btnNewButton.setBounds(83, 113, 185, 23);
		panel_1.add(btnNewButton);
		
		final Panel panel_2 = new Panel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 168, 561, 215);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		//Action listener for freight car radio button click
		rdoFreightCar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			lblVarious.setText("Goods Type :");
			rdoLocomotive.setSelected(false);
			rdoPassengerCar.setSelected(false);
			}
		});
		
		//Action listener for passenger car radio button click
		rdoPassengerCar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblVarious.setText("Seat :");
				rdoLocomotive.setSelected(false);
				rdoFreightCar.setSelected(false);

			}
		});
		
		//Action listener for locomotive radio button click
		rdoLocomotive.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblVarious.setText("Power :");
				rdoPassengerCar.setSelected(false);
				rdoFreightCar.setSelected(false);
			}
		});
		
		//Action listener for adding train
		btnAddTrain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//method if locomotive is added
				if (rdoLocomotive.isSelected())
				{
					try {
						newCarriage = new Locomotive(Integer.parseInt(txtWeight.getText()),txtVarious.getText());
						Locomotive temp = (Locomotive)newCarriage;
						power = temp.power();
						weight = weight+temp.getGrossWeight();
						//check if train have enough power to pull the train
						if(power<weight)
						{
							power = 0;
							weight = weight - temp.getGrossWeight();
							JOptionPane.showMessageDialog(null, "Train too heavy!");
							return;
						}
						Train.addCarriage(newCarriage);						
						
						//creating train images
						trainLabel[trainLabelIndex] = new JLabel(new ImageIcon("src/asgn2GUI/Resources/Locomotive.jpg"));
						trainLabel[trainLabelIndex].setBounds(10,51, 66, 55);
						panel_2.add(trainLabel[trainLabelIndex]);
						trainLabel[trainLabelIndex].setHorizontalAlignment(SwingConstants.TRAILING);
						trainLabel[trainLabelIndex].setAlignmentX(Component.RIGHT_ALIGNMENT);
						trainLabel[trainLabelIndex].setVerticalAlignment(SwingConstants.BOTTOM);
						
						//creating status label on the top of each images
						trainStatusLabel[trainLabelIndex] = new JLabel(temp.trainClass);
						trainStatusLabel[trainLabelIndex].setBounds(35,10,20,30);
						panel_2.add(trainStatusLabel[trainLabelIndex]);
						trainStatusLabel[trainLabelIndex].setHorizontalAlignment(SwingConstants.TRAILING);
						trainStatusLabel[trainLabelIndex].setAlignmentX(Component.RIGHT_ALIGNMENT);
						trainStatusLabel[trainLabelIndex].setVerticalAlignment(SwingConstants.BOTTOM);
						
						trainLabelIndex++;
						
					}  catch (TrainException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}
				else if(rdoPassengerCar.isSelected())
				{
					try {
						newCarriage = new PassengerCar(Integer.parseInt(txtWeight.getText()),Integer.parseInt(txtVarious.getText()));
						
						PassengerCar temp = (PassengerCar)newCarriage;
						weight = weight+temp.getGrossWeight();
						
						//check if firstCarriage is not Loco
						if (!(Train.firstCarriage() instanceof Locomotive)){
							JOptionPane.showMessageDialog(null, "Invalid Train Configuration! select Locomotive first!");
							return;
						}
						
						//check if train have enough power to pull the train
						if(power<weight)
						{
							weight = weight - temp.getGrossWeight();
							JOptionPane.showMessageDialog(null, "Train too heavy!");
							return;
						}
						Train.addCarriage(newCarriage);
												
						//creating train images
						trainLabel[trainLabelIndex] = new JLabel(new ImageIcon("src/asgn2GUI/Resources/Passenger.jpg"));
						if(trainLabelIndex<8)
						trainLabel[trainLabelIndex].setBounds(10+(trainLabelIndex*66), 51, 66, 55);
						if(trainLabelIndex>7)
						trainLabel[trainLabelIndex].setBounds(10+((trainLabelIndex-7)*66), 146, 66, 55);	
						panel_2.add(trainLabel[trainLabelIndex]);
						trainLabel[trainLabelIndex].setHorizontalAlignment(SwingConstants.TRAILING);
						trainLabel[trainLabelIndex].setAlignmentX(Component.RIGHT_ALIGNMENT);
						trainLabel[trainLabelIndex].setVerticalAlignment(SwingConstants.BOTTOM);

						//creating status label on the top of each images
						trainStatusLabel[trainLabelIndex] = new JLabel(temp.numberofPassenger+"/"+temp.seats);
						if(trainLabelIndex<8)
						trainStatusLabel[trainLabelIndex].setBounds(10+(trainLabelIndex*66),10,40,30);
						if(trainLabelIndex>7)
						trainStatusLabel[trainLabelIndex].setBounds(10+((trainLabelIndex-7)*66),110,40,30);	
						panel_2.add(trainStatusLabel[trainLabelIndex]);
						trainStatusLabel[trainLabelIndex].setHorizontalAlignment(SwingConstants.TRAILING);
						trainStatusLabel[trainLabelIndex].setAlignmentX(Component.RIGHT_ALIGNMENT);
						trainStatusLabel[trainLabelIndex].setVerticalAlignment(SwingConstants.BOTTOM);
						
						Integer seatavailable = Train.numberOfSeats()-Train.numberOnBoard();
						lblSeatAvailable.setText(seatavailable.toString());
						lblStatus.setText("Vacant");
						
						trainLabelIndex++;
					} catch (TrainException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(rdoFreightCar.isSelected())
				{
					try {
						FreightCar y = new FreightCar(Integer.parseInt(txtWeight.getText()), txtVarious.getText());
						Train.addCarriage(y);
						System.out.println(Train.nextCarriage());
						System.out.println(Train.nextCarriage());
						System.out.println(txtVarious.getText());
						newCarriage = new FreightCar(Integer.parseInt(txtWeight.getText()), txtVarious.getText());
						
						FreightCar temp = (FreightCar)newCarriage;
						weight = weight+temp.getGrossWeight();
						
						
						//check if firstCarriage is not Loco
						if (!(Train.firstCarriage() instanceof Locomotive)){
							JOptionPane.showMessageDialog(null, "Invalid Train Configuration! select Locomotive first!");
							return;
						}
						
						//check if train have enough power to pull the train
						if(power<weight)
						{
							weight = weight - temp.getGrossWeight();
							JOptionPane.showMessageDialog(null, "Train too heavy!");
							return;
						}
						Train.addCarriage(newCarriage);
						
						//creating train images
						trainLabel[trainLabelIndex] = new JLabel(new ImageIcon("src/asgn2GUI/Resources/FreightCar.jpg"));
						if(trainLabelIndex<8)
						trainLabel[trainLabelIndex].setBounds(10+(trainLabelIndex*66), 51, 66, 55);
						if(trainLabelIndex>7)
						trainLabel[trainLabelIndex].setBounds(10+((trainLabelIndex-7)*66), 146, 66, 55);	
						panel_2.add(trainLabel[trainLabelIndex]);
						trainLabel[trainLabelIndex].setHorizontalAlignment(SwingConstants.TRAILING);
						trainLabel[trainLabelIndex].setAlignmentX(Component.RIGHT_ALIGNMENT);
						trainLabel[trainLabelIndex].setVerticalAlignment(SwingConstants.BOTTOM);
					
						//creating status label on the top of each images
						trainStatusLabel[trainLabelIndex] = new JLabel(temp.GoodsType());
						if(trainLabelIndex<8)
						trainStatusLabel[trainLabelIndex].setBounds(10+(trainLabelIndex*66),10,40,30);
						if(trainLabelIndex>7)
						trainStatusLabel[trainLabelIndex].setBounds(10+((trainLabelIndex-7)*66),110,40,30);	
						panel_2.add(trainStatusLabel[trainLabelIndex]);
						trainStatusLabel[trainLabelIndex].setHorizontalAlignment(SwingConstants.TRAILING);
						trainStatusLabel[trainLabelIndex].setAlignmentX(Component.RIGHT_ALIGNMENT);
						trainStatusLabel[trainLabelIndex].setVerticalAlignment(SwingConstants.BOTTOM);

						freightCount++;
						trainLabelIndex++;
					}  catch (TrainException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
	
		//method to remove last train on the sequence
		btnRemoveLastTrain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				trainLabel[trainLabelIndex-1].setVisible(false);
				trainLabel[trainLabelIndex-1] = null;
				trainStatusLabel[trainLabelIndex-1].setVisible(false);
				trainStatusLabel[trainLabelIndex-1] = null;
				trainLabelIndex--;
				try {
					Train.removeCarriage();
				} catch (TrainException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		//method to board passenger
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					lblExcesivePassenger.setText(Train.board(Integer.parseInt(txtBoarding.getText())).toString());
					System.out.println("Number of seat: " + Train.numberOfSeats());
					System.out.println("Number on board: " + Train.numberOnBoard());
					if(Train.numberOfSeats() <= Train.numberOnBoard())
						lblStatus.setText("Full");
					else
						lblStatus.setText("Vacant");
					Integer seatavailable = Train.numberOfSeats()-Train.numberOnBoard();
					lblSeatAvailable.setText(seatavailable.toString());
					Update();
				} catch (TrainException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
