import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.lang.Thread;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Blackjack extends JFrame{
    static JFrame f;
    public static boolean game(){
        String[][] number = {{"2","3","4","5","6","7","8","9","10","king","queen","ace"},{"2","3","4","5","6","7","8","9","10","king","queen","ace "},{"2","3","4","5","6","7","8","9","10","king","queen","ace "},{"2","3","4","5","6","7","8","9","10","king","queen","ace "}};
        String []Nsuits = {"clubs","diamonds","hearts","spades"};
        Random rand = new Random();
        int suit = rand.nextInt(4);
        int Nnumber = rand.nextInt(12);
        String path = "Java/minigame/Cards/"+number[suit][Nnumber]+"_of_"+Nsuits[suit]+".png";
        f=new JFrame("Blackjack");
        JButton hit=new JButton("Hit");
        JButton stand=new JButton("Stand");
        hit.setBounds(130,300,100, 40);
        f.add(hit);
        stand.setBounds(230,300,100, 40);
        f.add(stand);
        JLabel Label1 = new JLabel();
        Label1.setBounds(130,200,100,200);
        try {
            BufferedImage img = ImageIO.read(new File(path));
            BufferedImage img2 = ImageIO.read(new File("Java/minigame/Cards/back.jpg"));
            Image dimg = img.getScaledInstance(Label1.getWidth(), Label1.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imgaeIcone = new ImageIcon(dimg);
            JLabel pic = new JLabel(imgaeIcone);
            JLabel pic2 = new JLabel(new ImageIcon(img2));
            pic.setBounds(130,75,100,200);
            pic2.setBounds(230,75,100,200);
            f.add(pic);
            f.add(pic2);
        } catch (IOException e) {
            System.out.print("not working");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        f.setSize(600,700);//400 width and 500 height  
        f.setLayout(null);//using no layout managers 
        //f.getContentPane().setBackground(Color.Darkgreen);
        f.setVisible(true);//making the frame visible 
        return(true);
    }
}
