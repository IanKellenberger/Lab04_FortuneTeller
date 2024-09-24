import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private JTextArea textArea;
    private ArrayList<String> fortunes;
    private int lastFortuneIndex = -1;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setLayout(new BorderLayout());

        // Top Panel - JLabel with resized image and text
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/fortuneteller.png"));
        ImageIcon resizedIcon = resizeImageIcon(originalIcon, 150, 150);  // Resize the image to 150x150

        JLabel titleLabel = new JLabel("Fortune Teller");
        titleLabel.setIcon(resizedIcon);  // Set the resized image icon
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);  // Centers text relative to the image
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);    // Places text below the image
        titleLabel.setFont(new Font("Serif", Font.BOLD, 36));  // Set font size for the title

        JPanel topPanel = new JPanel();
        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);

        // Middle Panel - JTextArea in JScrollPane for fortunes
        textArea = new JTextArea(10, 30);
        textArea.setFont(new Font("SansSerif", Font.PLAIN, 18));
        textArea.setEditable(false); // Makes the JTextArea non-editable
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom Panel - Buttons
        JButton readFortuneButton = new JButton("Read My Fortune!");
        readFortuneButton.setFont(new Font("SansSerif", Font.PLAIN, 24));
        JButton quitButton = new JButton("Quit");
        quitButton.setFont(new Font("SansSerif", Font.PLAIN, 24));

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Create the list of fortunes
        createFortunes();

        // Button action listeners using lambdas
        readFortuneButton.addActionListener(e -> readFortune());
        quitButton.addActionListener(e -> System.exit(0));

        // Set frame size and position using Toolkit
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int frameWidth = screenSize.width * 3 / 4;
        int frameHeight = screenSize.height * 3 / 4;
        setSize(frameWidth, frameHeight);
        setLocationRelativeTo(null);  // Center the frame
    }

    // Method to resize the image
    public ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();  // Get the original image from the icon
        Image resizedImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);  // Resize the image
        return new ImageIcon(resizedImage);  // Return the resized ImageIcon
    }

    private void createFortunes() {
        fortunes = new ArrayList<>();
        fortunes.add("You will have a pleasant surprise today.");
        fortunes.add("Be careful what you wish for.");
        fortunes.add("A great opportunity is coming your way.");
        fortunes.add("A fresh start will put you on your way.");
        fortunes.add("Happiness will find you.");
        fortunes.add("Don’t give up! Great things take time.");
        fortunes.add("An unexpected adventure awaits.");
        fortunes.add("A dream you have will come true.");
        fortunes.add("Your smile will tell you what makes you feel good.");
        fortunes.add("Now is the time to try something new.");
        fortunes.add("You will conquer obstacles to achieve success.");
        fortunes.add("The harder you work, the luckier you get.");
    }

    private void readFortune() {
        Random rand = new Random();
        int newFortuneIndex;

        do {
            newFortuneIndex = rand.nextInt(fortunes.size());
        } while (newFortuneIndex == lastFortuneIndex);

        lastFortuneIndex = newFortuneIndex;
        String fortune = fortunes.get(newFortuneIndex);

        textArea.append(fortune + "\n");
    }
}
