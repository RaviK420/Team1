import javax.imageio.ImageIO;
import javax.swing.*;
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
    static boolean clicked = false;
    static boolean hidden;
    static int Uscore;
    static int UserX;
    static int suit;
    static int Nnumber;
    static int Nopp;
    static boolean winner;
    static int aceCounter;
    static int UaceCounter;
    static int hitCounter;
    //UaceCounter for the start do that
    public static boolean game(){
        hitCounter =2;
        aceCounter = 0;
        UaceCounter = 0;
        Uscore =0;
        String[][] number = {{"2","3","4","5","6","7","8","9","10","king","queen","ace"},{"2","3","4","5","6","7","8","9","10","king","queen","ace"},{"2","3","4","5","6","7","8","9","10","king","queen","ace"},{"2","3","4","5","6","7","8","9","10","king","queen","ace"}};
        String []Nsuits = {"clubs","diamonds","hearts","spades"};
        Random rand = new Random();
        suit = rand.nextInt(4);
        Nnumber = rand.nextInt(12);
        String path = "Java/minigame/Cards/"+number[suit][Nnumber]+"_of_"+Nsuits[suit]+".png";
        String opp = number[suit][Nnumber];
        if (opp =="king"||opp == "queen"||opp =="ace"){
            if(opp=="ace"){
                Nopp = 11;
                aceCounter += 1;
            }
            else{
                Nopp = 10;
            }
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
            if(number[suit][Nnumber]=="ace"){
                if(Nopp+11>21){
                    Nopp+=1;
                }
                else{
                    aceCounter+=1;
                    Nopp+=1;
                }
            }
            else{
            Nopp +=10;
        }
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

            if(number[suit][Nnumber]=="king"||number[suit][Nnumber]=="queen"||number[suit][Nnumber]=="ace"){
                if(number[suit][Nnumber]=="ace"){
                    Uscore = 11;
                    UaceCounter = 1;
                }
                else{
                    Uscore = 10;
                }
            }
            else{
                Uscore = Integer.parseInt(number[suit][Nnumber]);
            }

            number [suit][Nnumber] = "0";
            suit = rand.nextInt(4);
            Nnumber = rand.nextInt(12);
            while(number[suit][Nnumber] == "0"){
                Nnumber = rand.nextInt(12);
            }

            if(number[suit][Nnumber]=="king"||number[suit][Nnumber]=="queen"||number[suit][Nnumber]=="ace"){
                    if(number[suit][Nnumber]=="ace"){
                        if(Uscore+11>21){
                            Uscore+=1;
                        }
                        else{
                            UaceCounter+=1;
                            Uscore+=11;
                        }
                    }
                    else{
                        Uscore+=10;
                    }
                }
                else{
                    Uscore += Integer.parseInt(number[suit][Nnumber]);
                    if (Uscore>21 && UaceCounter>0){
                        Uscore-=10;
                        UaceCounter-=1;
                    }
                }

            BufferedImage img4 = ImageIO.read(new File("Java/minigame/Cards/"+number[suit][Nnumber]+"_of_"+Nsuits[suit]+".png"));
            number [suit][Nnumber] = "0";
            suit = rand.nextInt(4);
            Nnumber = rand.nextInt(12);
            while(number[suit][Nnumber] == "0"){
                Nnumber = rand.nextInt(12);
            }
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
            UserX = 330;
            f.add(pic);
            f.add(pic2);
            f.add(pic3);
            f.add(pic4);
            if (Uscore ==21){
                clicked =true;
                winner = true;
            }
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
                System.out.println(hiddenCard);
                BufferedImage img = ImageIO.read(new File(hiddenCard));
                Image dimg = img.getScaledInstance(Label1.getWidth(), Label1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imgaeIcone = new ImageIcon(dimg);
                JLabel HiddenCard =new JLabel(imgaeIcone);
                HiddenCard.setBounds(230,75,100,200);
                f.add(HiddenCard);
                UserX = 330;
                System.out.println(Nopp);
                System.out.print("this is what is what");
                while(Nopp<17){
                    BufferedImage img3 = ImageIO.read(new File("Java/minigame/Cards/"+number[suit][Nnumber]+"_of_"+Nsuits[suit]+".png"));
                    Image dimg2 = img3.getScaledInstance(Label1.getWidth(), Label1.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon imgaeIcone2 = new ImageIcon(dimg2);
        
                    JLabel pic = new JLabel(imgaeIcone2);
                    pic.setBounds(UserX,75,100,200);
                    f.add(pic);
                    UserX+=100;
                    if(number[suit][Nnumber]=="king"||number[suit][Nnumber]=="queen"||number[suit][Nnumber]=="ace"){
                        if(number[suit][Nnumber]=="ace"){
                            if(Nopp+11>21){
                                Nopp+=1;
                            }
                            else{
                                aceCounter+=1;
                                Nopp+=11;
                            }
                        }
                        else{
                            if(Nopp+10>21 && aceCounter>0){
                                aceCounter-=1;
                            }
                            else{
                                Nopp+=10;
                            }
                        }
                    }
                    else{
                        Nopp += Integer.parseInt(number[suit][Nnumber]);
                        if (Nopp>21 && aceCounter>0){
                            Nopp-=10;
                            aceCounter-=1;
                        }
                    }
                    number [suit][Nnumber] = "0";
                    suit = rand.nextInt(4);
                    Nnumber = rand.nextInt(12);
                    while(number[suit][Nnumber] == "0"){
                        Nnumber = rand.nextInt(12);
                    }
                }
                if(Nopp<Uscore){
                    winner = true;
                }
                else{
                    if (Nopp>21){
                        winner =true;
                    }
                    else{
                        winner = false;
                    }
                }
                hidden = false;
                clicked = true;
                }
                catch(IOException z){
                    ((Throwable) z).printStackTrace();

                }
            }
        });

        hit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            try {
                f.repaint();
                BufferedImage img3 = ImageIO.read(new File("Java/minigame/Cards/"+number[suit][Nnumber]+"_of_"+Nsuits[suit]+".png"));
                Image dimg = img3.getScaledInstance(Label1.getWidth(), Label1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imgaeIcone = new ImageIcon(dimg);
    
                JLabel pic = new JLabel(imgaeIcone);
                pic.setBounds(UserX,350,100,200);
                f.add(pic);
                hitCounter+=1;
                UserX+=100;
                if(number[suit][Nnumber]=="king"||number[suit][Nnumber]=="queen"||number[suit][Nnumber]=="ace"){
                    if(number[suit][Nnumber]=="ace"){
                        if(Uscore+11>21){
                            Uscore+=1;
                        }
                        else{
                            UaceCounter+=1;
                            Uscore+=11;
                        }
                    }
                    else{
                        if(Uscore+10>21 && UaceCounter>0){
                            UaceCounter-=1;
                        }
                        else{
                            Uscore+=10;
                        }
                    }
                }
                else{
                    Uscore += Integer.parseInt(number[suit][Nnumber]);
                    if (Uscore>21 && UaceCounter>0){
                        Uscore-=10;
                        UaceCounter-=1;
                    }
                }
                number [suit][Nnumber] = "0";
                suit = rand.nextInt(4);
                Nnumber = rand.nextInt(12);
                while(number[suit][Nnumber] == "0"){
                    Nnumber = rand.nextInt(12);
                }
                if(Uscore>=21||hitCounter==5){
                    f.remove(pic2);
                    f.revalidate();
                    f.repaint();
                    BufferedImage img = ImageIO.read(new File(hiddenCard));
                    Image dimg2 = img.getScaledInstance(Label1.getWidth(), Label1.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon imgaeIcone2 = new ImageIcon(dimg2);
                    JLabel HiddenCard =new JLabel(imgaeIcone2);
                    HiddenCard.setBounds(230,75,100,200);
                    f.add(HiddenCard);
                    if(Uscore == 21||hitCounter==5){
                        winner = true;
                    }
                    clicked = true;
                }
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            }
        });


        f.setSize(800,900);//400 width and 500 height  
        f.setLayout(null);//using no layout managers 

        //f.getContentPane().setBackground(Color.Darkgreen);
        f.setVisible(true);//making the frame visible 
        while(clicked == false){
            System.out.println(Uscore);
        }
        JLabel outcome;
        if (winner == false){
             outcome = new JLabel("Better luck next time!");
        }
        else{
            outcome = new JLabel("Congrats!");
        }
        outcome.setBounds(330,270,150,100);
        f.add(outcome);
        f.remove(hit);
        f.remove(stand);
        f.repaint();
        try{
            TimeUnit.SECONDS.sleep(3);}
                catch(Exception z){System.out.println(z);} 
        System.out.println("This has now worked");
        f.dispose();
        return(winner);
    }
}