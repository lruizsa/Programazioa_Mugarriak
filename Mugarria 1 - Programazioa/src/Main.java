    import javax.swing.*;
    import java.awt.*;

    public class Main extends JFrame {
        public static void main(String[] args) {

            new Main().sortuInterfazea();

        }

        void sortuInterfazea(){

            //JFrame sorrera
            JFrame frame = new JFrame("Try yourself");

            //Ixterakoan duen portaera
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Kontainer nagusiak BorderLayout kudeatzaile bat izango du
            frame.setLayout(new BorderLayout());

            // frame-aren tamaina definitu
            frame.setPreferredSize(new Dimension(300, 200));

            //-----------------------------------------------------------------

            //JPanel sorrera
            JPanel panel1 = new JPanel();

            // JPanela konfiguratzen dugu iparraldeko zatia izateko. BorderLayout
            frame.add(panel1, BorderLayout.NORTH);

            //Sortu FlowLayout panelean
            FlowLayout f = new FlowLayout();
            panel1.setLayout(f);
            f.setAlignment(FlowLayout.CENTER);
            f.setHgap(20);
            setLayout(f);


            //Botoiak sortu
            JCheckBox button1 = new JCheckBox("Katniss");
            JCheckBox button2 = new JCheckBox("Peeta");

            //Botoiak panel1-ean sartu
            panel1.add(button1);
            panel1.add(button2);


            //-----------------------------------------------------------------

            //Leihoa automatikoki ajustatu
            frame.pack();

            //leihoa bistaratzea
            frame.setVisible(true);

            //-----------------------------------------------------------------


            //Bigarren JPanel-aren sorrera
            JPanel panel2 = new JPanel();

            // JPanela konfiguratzen dugu iparraldeko zatia izateko. BorderLayout
            frame.add(panel2, BorderLayout.EAST);

           //Sortu FlowLayout panelean
            FlowLayout f3 = new FlowLayout();
            panel2.setLayout(f3);
            f3.setAlignment(FlowLayout.LEFT);
            f3.setHgap(20);
            setLayout(f3);


            //Botoiak sortu
            JRadioButton Jbutton1 = new JRadioButton("OPT 1");
            JRadioButton Jbutton2 = new JRadioButton("OPT 2");
            JRadioButton Jbutton3 = new JRadioButton("OPT 3");

            // OPT1 botoia hautatua egoteko
            Jbutton1.setSelected(true);


            //Botoiak panel2-ean sartu
            panel2.add(Jbutton1);
            panel2.add(Jbutton2);
            panel2.add(Jbutton3);

            //-----------------------------------------------------------------


            //Hirugarren JPanel-aren sorrera
            JPanel panel3 = new JPanel();

            // JPanela konfiguratzen dugu iparraldeko zatia izateko. BorderLayout
            frame.add(panel3, BorderLayout.SOUTH);

            panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
            panel3.add(new JButton("BUT 1 " ));
            panel3.add(new JButton("BUT 2"));

            setSize(200,300);



            // Ezkerrean geratzeko eta bata bestearen ondoan.
            panel3.setLayout(new FlowLayout(FlowLayout.LEFT));


            //-----------------------------------------------------------------

            // GridLayout 2x2 sortu
            JPanel panel4 = new JPanel(new GridLayout(2, 2));

            // ImageIcon argazkia aukeratzeko
                ImageIcon argazkia = new ImageIcon(".\\tulipanak.jpg");

            // Jlabel bat sortu lauki bakoitzerako
            JLabel label1 = new JLabel(argazkia);
            JLabel label2 = new JLabel(argazkia);
            JLabel label3 = new JLabel(argazkia);
            JLabel label4 = new JLabel(argazkia);

            // etiketak gehitu
            panel4.add(label1);
            panel4.add(label2);
            panel4.add(label3);
            panel4.add(label4);

            // panel4 erdian jarri
            frame.add(panel4, BorderLayout.CENTER);



        }
    }