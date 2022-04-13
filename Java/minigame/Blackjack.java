import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.ComponentUI;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Blackjack extends JFrame{
    static JFrame f;
    static JLabel pic2;
    static String hiddenCard;
    public static boolean game(){
        String[][] number = {{"2","3","4","5","6","7","8","9","10","king","queen","ace"},{"2","3","4","5","6","7","8","9","10","king","queen","ace"},{"2","3","4","5","6","7","8","9","10","king","queen","ace"},{"2","3","4","5","6","7","8","9","10","king","queen","ace"}};
        String []Nsuits = {"clubs","diamonds","hearts","spades"};
        Random rand = new Random();
        int suit = rand.nextInt(4);
        int Nnumber = rand.nextInt(12);
        String path = "Java/minigame/Cards/"+number[suit][Nnumber]+"_of_"+Nsuits[suit]+".png";
        String opp = number[suit][Nnumber];
        int Nopp;
        if (opp =="king"||opp == "queen"||opp =="ace"){
            Nopp = 10;
        }
        else{
            Nopp = Integer.parseInt(opp);
        }
        number [suit][Nnumber] = "0";
        suit = rand.nextInt(4);
        Nnumber = rand.nextInt(12);
        while(number[suit][Nnumber] == "0"){
            Nnumber = rand.nextInt(12);
        }
        hiddenCard = "Java/minigame/Cards/"+number[suit][Nnumber]+"_of_"+Nsuits[suit]+".png";
        if(number[suit][Nnumber]=="king"||number[suit][Nnumber]=="queen"||number[suit][Nnumber]=="ace"){
            Nopp +=10;
            hiddenCard =number[suit][Nnumber];
        }
        else{
            Nopp+= Integer.parseInt(number[suit][Nnumber]);
        }
        number [suit][Nnumber] = "0";
        suit = rand.nextInt(4);
        Nnumber = rand.nextInt(12);
        while(number[suit][Nnumber] == "0"){
            Nnumber = rand.nextInt(12);
        }

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
            BufferedImage img3 = ImageIO.read(new File("Java/minigame/Cards/"+number[suit][Nnumber]+"_of_"+Nsuits[suit]+".png"));

            number [suit][Nnumber] = "0";
            suit = rand.nextInt(4);
            Nnumber = rand.nextInt(12);
            while(number[suit][Nnumber] == "0"){
                Nnumber = rand.nextInt(12);
            }
            BufferedImage img4 = ImageIO.read(new File("Java/minigame/Cards/"+number[suit][Nnumber]+"_of_"+Nsuits[suit]+".png"));

            Image dimg = img.getScaledInstance(Label1.getWidth(), Label1.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imgaeIcone = new ImageIcon(dimg);

            JLabel pic = new JLabel(imgaeIcone);
            pic2 = new JLabel(new ImageIcon(img2));

            dimg = img3.getScaledInstance(Label1.getWidth(), Label1.getHeight(), Image.SCALE_SMOOTH);
            JLabel pic3 = new JLabel(new ImageIcon(dimg));

            dimg = img4.getScaledInstance(Label1.getWidth(), Label1.getHeight(), Image.SCALE_SMOOTH);
            JLabel pic4 = new JLabel(new ImageIcon(dimg));

            pic.setBounds(130,75,100,200);
            pic2.setBounds(230,75,100,200);
            pic3.setBounds(130,350,100,200);
            pic4.setBounds(230,350,100,200);

            f.add(pic);
            f.add(pic2);
            f.add(pic3);
            f.add(pic4);

        } catch (IOException e) {
            System.out.print("not working");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        stand.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f.remove(pic2);
                f.revalidate();
                f.repaint();
                try{
                BufferedImage img = ImageIO.read(new File(hiddenCard));
                Image dimg = img.getScaledInstance(Label1.getWidth(), Label1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imgaeIcone = new ImageIcon(dimg);
                JLabel HiddenCard =new JLabel(imgaeIcone);
                HiddenCard.setBounds(230,75,100,200);
                f.add(HiddenCard);
                }
                catch(IOException z){
                    ((Throwable) z).printStackTrace();

                }
            }
        });

        f.setSize(600,700);//400 width and 500 height  
        f.setLayout(null);//using no layout managers 

        //f.getContentPane().setBackground(Color.Darkgreen);
        f.setVisible(true);//making the frame visible 
        return(true);
    }
}
