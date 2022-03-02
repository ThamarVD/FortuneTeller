import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    JPanel mainPnl;
    JPanel topPnl;
    JPanel midPnl;
    JPanel botPnl;

    JLabel title;
    ImageIcon titIco;
    Random rand = new Random();
    int prevIndx = -1;
    JTextArea textArea = new JTextArea(5,40);
    String[] fortunes = {
            "You will get a 1998 Nissan Pulsar",
            "You might find a fish in a pond",
            "You will miss too many assignments",
            "There's treasure inside you ♡ Go ahead open your stomach and check!",
            "I see cashews in the near future",
            "You will learn about a new billionaire",
            "Fish tacos sound good right now",
            "You should not lick that Himalayan salt lamp",
            "Learning a new skill is hard, so you shouldn't do it",
            "There will be a career fair in the future",
            "You will have to catch up on 6 programming assignments",
            "I see a school day in your future"
    };

    public FortuneTellerFrame(){
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createTopPnl();
        createMidPnl();
        createBotPnl();
        mainPnl.add(topPnl, BorderLayout.NORTH);
        mainPnl.add(midPnl, BorderLayout.CENTER);
        mainPnl.add(botPnl, BorderLayout.SOUTH);

        add(mainPnl);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((screenSize.width * 3) / 4, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void createTopPnl(){
        topPnl = new JPanel();

        titIco = new ImageIcon("src/fortTell.png");
        titIco = new ImageIcon(titIco.getImage().getScaledInstance(120, 120, Image.SCALE_FAST));
        title = new JLabel("Fortune Teller", titIco, JLabel.CENTER);
        title.setFont(new Font("Verdana", Font.PLAIN, 36));

        title.setVerticalTextPosition(JLabel.BOTTOM);
        title.setHorizontalAlignment(JLabel.CENTER);

        topPnl.add(title);
    }
    public void createMidPnl(){
        midPnl = new JPanel();

        JScrollPane scrollPane = new JScrollPane(textArea);
        midPnl.add(scrollPane, BorderLayout.CENTER);
    }
    public void createBotPnl(){
        botPnl = new JPanel();
        JButton readFort = new JButton("Read My Fortune!");
        JButton quitApp = new JButton("Quit");
        readFort.addActionListener((ActionEvent ae) -> {
            int randIndx;
            do {
                randIndx=rand.nextInt(fortunes.length);
            }while (randIndx == prevIndx);
            prevIndx = randIndx;
            textArea.append(fortunes[randIndx]+"\n");
        });
        quitApp.addActionListener((ActionEvent ae) -> {System.exit(0);});
        botPnl.add(readFort, BorderLayout.WEST);
        botPnl.add(quitApp, BorderLayout.EAST);
    }
}
