import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main extends JFrame implements ActionListener {

    JComboBox<String> comboBox;
    JTextArea textArea;

    public static void main(String[] args) {
        new Main().sortuInterfazea();
    }

    void sortuInterfazea() {
        // JFrame sorrera
        JFrame frame = new JFrame("Test Events: Files");
        // Ixterakoan duen portaera
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Kontainer nagusiak BorderLayout kudeatzaile bat izango du
        frame.setLayout(new BorderLayout());
        // frame-aren tamaina definitu
        frame.setPreferredSize(new Dimension(600, 200));

        //-----------------------------------------------------------------

        // JPanel sorrera
        JPanel panel1 = new JPanel();
        // JPanela konfiguratzen dugu iparraldeko zatia izateko. BorderLayout
        frame.add(panel1, BorderLayout.NORTH);
        // Sortu FlowLayout panelean
        FlowLayout f = new FlowLayout();
        panel1.setLayout(f);
        f.setAlignment(FlowLayout.LEFT);
        f.setHgap(20);

        //-----------------------------------------------------------------

        // Combobox-a sortu eta aukerak gehitu
        String[] aukerak = {"java.txt", "python.txt", "c.txt"};
        comboBox = new JComboBox<>(aukerak);
        comboBox.setPreferredSize(new Dimension(200, 20));
        comboBox.addActionListener(this); // ActionListener gehitu
        // ComboBox-a panelean gehitu
        panel1.add(comboBox);

        //-----------------------------------------------------------------

        // Botoia "Clear" sortu eta gehitu
        JButton clear = new JButton("Clear");
        clear.setPreferredSize(new Dimension(65, 20));
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(""); // JTextArea garbitu
            }
        });
        // Botoia panelera gehitu
        panel1.add(clear);

        //-----------------------------------------------------------------

        // JPanel --> JTextArea eta JScrollPane -rako
        JPanel textPanel = new JPanel(new BorderLayout());

        // JTextArea sortu
        textArea = new JTextArea("", 5, 3);
        textArea.setEditable(false); // Text area-ez editablea izatea
        textArea.setLineWrap(true); // Line wrap aktibatu
        textArea.setWrapStyleWord(true); // Word wrap aktibatu

        // JTextArea-ri  tamaina ezarri
        textArea.setPreferredSize(new Dimension(300, 100));

        // JScrollPane gehitu JTextAreari
        JScrollPane scrollPane = new JScrollPane(textArea);
        textPanel.add(scrollPane, BorderLayout.CENTER);

        // "konponente" hutsa gehitu BorderLayout-ean (ezkerrean), horrela  TextAreari espazioa emateko
        textPanel.add(Box.createHorizontalGlue(), BorderLayout.WEST);

        //-----------------------------------------------------------------

        // Panela gehitu frame-a layout-ean
        frame.add(textPanel, BorderLayout.CENTER);

        //-----------------------------------------------------------------

        // Close botoia
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Framea itxi
            }
        });
        // Botoia panelera gehitu
        frame.add(closeButton, BorderLayout.SOUTH);
        closeButton.setPreferredSize(new Dimension(65, 20));

        //-----------------------------------------------------------------

        // Leihoa automatikoki ajustatu
        frame.pack();
        // Leihoa bistaratzea
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // JComboBox ean aukeratutako aukera hartu
        String aukeratua = (String) comboBox.getSelectedItem();

        // txt-aren ruta
        String ruta = ""; // Aquí se almacenará la ruta completa al archivo
        if (aukeratua.equals("java.txt")) {
            ruta = "D:\\3.Ebaluaketa\\Programazioa 2. mugarria\\Mugarria 2\\src\\java.txt";
        } else if (aukeratua.equals("python.txt")) {
            ruta = "D:\\3.Ebaluaketa\\Programazioa 2. mugarria\\Mugarria 2\\src\\python.txt";
        } else if (aukeratua.equals("c.txt")) {
            ruta = "D:\\3.Ebaluaketa\\Programazioa 2. mugarria\\Mugarria 2\\src\\c.txt";
        }

        try {
            // txt-an idatzitakoa irakurri eta JTextArean idatzi
            BufferedReader reader = new BufferedReader(new FileReader(ruta));
            String lerroa;
            StringBuilder edukia = new StringBuilder();
            while ((lerroa = reader.readLine()) != null) {
                edukia.append(lerroa).append("\n");
            }
            reader.close();
            textArea.setText(edukia.toString());
        } catch (IOException ex) {
            // Errorea baldinbadago, mezu hau erakustea:
            JOptionPane.showMessageDialog(this, "Errorea: Fitxategia ez da existitzen", "Errorea", JOptionPane.ERROR_MESSAGE);
        }
    }
}
