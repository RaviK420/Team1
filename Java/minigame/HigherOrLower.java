import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.lang.Thread;
 

public class HigherOrLower extends JFrame{
    static JFrame f;
    static JLabel l;
    static boolean winner;
    static boolean clicked;
    public static boolean game(){ 
        f=new JFrame("Higher or Lower");//creating instance of JFrame  
        String randomNumber1 = Integer.toString((int)(Math.random()*101));
        int randomNumber2 = (int)(Math.random()*101);
        JButton b=new JButton("Higher");//creating instance of JButton  
        b.setBounds(130,100,100, 40);//x axis, y axis, width, height            
        f.add(b);//adding button in JFrame  
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JLabel correctLabel;
                if (randomNumber2>Integer.parseInt(randomNumber1)){
                    correctLabel = new JLabel("You guessed correct!\n the next number was "+randomNumber2);
                    winner = true;
                }
                else{
                    correctLabel = new JLabel("Oh No!\n the next number was "+randomNumber2);
                }
                JPanel p3 = new JPanel();
                p3.add(correctLabel);
                p3.setBounds(50,200,300,50);
                f.add(p3);
                f.setVisible(true); 
                // Use java swing timer
                clicked = true;
           }
        });
        JButton a = new JButton("Lower");
        a.setBounds(240,100,100,40);
        f.add(a);
        a.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JLabel correctLabel;
                if (randomNumber2<Integer.parseInt(randomNumber1)){
                    correctLabel = new JLabel("You guessed correct!\n the next number was "+randomNumber2);
                    winner = true;
                    
                }
                else{
                    correctLabel = new JLabel("Oh No!\n the next number was "+randomNumber2);
                }
                JPanel p3 = new JPanel();
                p3.add(correctLabel);
                p3.setBounds(50,200,300,50);
                f.add(p3);
                f.setVisible(true); 
                clicked = true;
            }
        });
        l = new JLabel(randomNumber1);
        JLabel Label2 = new JLabel("Would the next number be higher or lower?");
        JPanel p = new JPanel();
        JPanel p2 = new JPanel();
        p.add(l);
        p2.add(Label2);
        p.setBounds(150,50,100,40);
        p2.setBounds(130,25,250,40);
        f.add(p);
        f.add(p2);
        f.setSize(400,500);//400 width and 500 height  
        f.setLayout(null);//using no layout managers  
        f.setVisible(true);//making the frame visible 

        while (clicked == false){
            System.out.println("This is not working");
        } 
        try{
        TimeUnit.SECONDS.sleep(5);}
            catch(Exception z){System.out.println(z);}
        f.dispose();    
        return(winner);
        }
}
