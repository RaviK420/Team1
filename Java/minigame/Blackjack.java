import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.lang.Thread;
import java.awt.image.BufferedImage;
 

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
        JLabel Label1 = new JLabel();
        Label1.setBounds(130,200,100,200);
        try {
            BufferedImage img = ImageIO.read(new File("Java/minigame/Cards/2_of_clubs.png"));
            Image dimg = img.getScaledInstance(Label1.getWidth(), Label1.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imgaeIcone = new ImageIcon(dimg);
            JLabel pic = new JLabel(imgaeIcone);
            JLabel pic2 = new JLabel(new ImageIcon(img));
            pic.setBounds(130,200,200,400);
            pic2.setBounds(230,200,100,200);
            f.add(pic);
        } catch (IOException e) {
            System.out.print("not working");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        f.setSize(400,500);//400 width and 500 height  
        f.setLayout(null);//using no layout managers 
        //f.getContentPane().setBackground(Color.Darkgreen);
        f.setVisible(true);//making the frame visible 
        return(true);
    }
}
