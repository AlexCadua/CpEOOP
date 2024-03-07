import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class MainButton extends JFrame implements ItemListener, ActionListener{
    JButton exitButton = new JButton("Exit");
    int shirtCount = 5;
    JRadioButton shirtButton[] = new JRadioButton[shirtCount];
    Double prices[] = {500.0,700.0,1000.0,800.0,600.0};
    String shirtNames[] = {"T-shirt ", "Polo shirt ", "Hoodie ", "Turtleneck ", "Vneck "};
    ButtonGroup gradesGroup = new ButtonGroup();
    JLabel resultLabel = new JLabel();
    JLabel changeField = new JLabel();
    JTextField numbertextField = new JTextField("Enter a number...");
    JTextField paymentField = new JTextField("Enter Amount");
    double DblNumber, totalCost, amountPaid;

    public MainButton(){

        setLayout(new FlowLayout(FlowLayout.LEFT));
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(new JLabel("Quantity: "));
        topPanel.add(numbertextField);
        topPanel.setMaximumSize(new Dimension(10,10));

        JPanel midPanel = new JPanel();
        midPanel.setLayout(new GridLayout(5,1,1,1));
        TitledBorder titleBorder = new TitledBorder("Select a shirt");
        for(int s = 0; s < shirtCount; s++){
            shirtButton[s] = new JRadioButton(shirtNames[s] + prices[s].toString() + " pesos");
            shirtButton[s].addItemListener(this);
            gradesGroup.add(shirtButton[s]);
            midPanel.add(shirtButton[s]);
        }
        midPanel.setBorder(titleBorder);


        JPanel bottomPanel = new JPanel();
        FlowLayout flow = new FlowLayout(FlowLayout.LEFT, 2, 2);
        bottomPanel.add(new JLabel("total: ", JLabel.CENTER));
        bottomPanel.add(resultLabel);
        bottomPanel.setLayout(flow);
        bottomPanel.setSize(10,10);


        JPanel PaymentSection = new JPanel();
        PaymentSection.setLayout(new GridLayout(2,2,1,1));
        PaymentSection.add(new JLabel("Amount Paid: "));
        paymentField.addActionListener(this);
        PaymentSection.add(paymentField);
        PaymentSection.add(new JLabel("change: "));
        PaymentSection.add(changeField);
        PaymentSection.setBorder(new TitledBorder("Payment"));
        
        

        add(topPanel, BorderLayout.NORTH);
        add(midPanel, BorderLayout.WEST);
        add(bottomPanel);
        add(PaymentSection);
        JPanel exitPanel = new JPanel();
        exitPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        exitPanel.add(exitButton, FlowLayout.LEFT);
        add(exitPanel);
        
        exitButton.addActionListener(this);

        setSize(220, 400);
        setLocation(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Use RadioButton");
        setVisible(true);

    }

    public void itemStateChanged(ItemEvent e){
        Object source = e.getSource();
        for(int s = 0; s < shirtCount; s++){
            if(source == shirtButton[s]){
            DblNumber = Double.parseDouble(numbertextField.getText());
            totalCost = prices[s] * DblNumber;
            resultLabel.setText("" + totalCost);
            }
        }

    }

    public void actionPerformed(ActionEvent evt){
        Object source = evt.getSource();
        if (source == exitButton){
            System.exit(1);
        }

        if(source == paymentField){
            Double c = (Double.parseDouble(paymentField.getText()) - totalCost);
            changeField.setText(c.toString() + " pesos");
        }
    }

    public static void main(String[] args){
        MainButton m = new MainButton();
    }
}