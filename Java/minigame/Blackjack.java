import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.lang.Thread;
 

public class Blackjack extends JFrame{
    static JFrame f;
    public static boolean game(){
        f=new JFrame("Blackjack");
        JButton hit=new JButton("Hit");
        JButton stand=new JButton("Stand");
        hit.setBounds(130,100,100, 40);
        f.add(hit);
        stand.setBounds(230,100,100, 40);
        f.add(stand);

        f.setSize(400,500);//400 width and 500 height  
        f.setLayout(null);//using no layout managers  
        f.setVisible(true);//making the frame visible 
        return(true);
    }
}
