import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class MainSunButton extends JFrame implements ItemListener, ActionListener{

    int dessertCount = 5;

    JCheckBox dessertSelection[] = new JCheckBox[dessertCount];
    String desserts[] = {"Leche Flan", "Halo-Halo Supreme", "Mango Float", "Buko Pandan", "Maja Blanca"};
    Double prices[] = {80.0, 120.0, 150.0, 90.0, 85.0};
    Double total = 0.0;
    JLabel totalLabel = new JLabel("Total: ", JLabel.CENTER);
    JButton exitButton = new JButton("Exit");
    JButton orderButton = new JButton("Order");

    public MainSunButton(){
        setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel titlePanel = new JPanel();
        titlePanel.add(new JLabel("Alex's Dessert Delights"), JLabel.CENTER);
        
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(5,1,2,2));
        for(int d = 0 ; d < dessertCount; d++){
            dessertSelection[d] = new JCheckBox((desserts[d] + " (Php " + prices[d] + ")"));
            dessertSelection[d].addItemListener(this);
            menuPanel.add(dessertSelection[d]);
        }
        menuPanel.setBorder(new TitledBorder("Menu"));

        //JPanel totalPanel = new JPanel();
        //totalPanel.add(totalLabel);

        JPanel exitPanel = new JPanel();
        exitPanel.setLayout(new GridLayout(1,2,1,1));
        exitPanel.add(totalLabel);
        exitPanel.add(orderButton);
        exitPanel.add(exitButton);
        exitButton.addActionListener(this);


        add(titlePanel);
        add(menuPanel);
        //add(totalPanel);
        add(exitPanel, FlowLayout.RIGHT);


        setSize(250, 300);
        setLocation(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Use CheckBoxes");
        setVisible(true);

    }

    public void itemStateChanged(ItemEvent e){
        Object source = e.getSource();
        for(int d = 0; d < dessertCount; d++){
            if(source == dessertSelection[d]){
                if(dessertSelection[d].isSelected()){
                    total += prices[d];
                } else{
                    total -= prices[d];
                }
            
            totalLabel.setText("total: " + total);
            }
        }
    }

    public void actionPerformed(ActionEvent evt){
        Object source = evt.getSource();
        if(source == exitButton){
            System.exit(1);
        }

    }

    public static void main(String[] args){
        MainSunButton m = new MainSunButton();
    }

}
