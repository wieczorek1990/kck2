import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Zad2 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Framstick test = new Framstick();
		test.load("test.txt");
		// test.print();
		JPanel panel = new JPanel();
		JTextField text1 = new JTextField("1.0f");
		JTextField text2 = new JTextField("1.0f");
		JTextField text3 = new JTextField("10.0f");
		JTextField text4 = new JTextField("10.0f");
		JLabel label1 = new JLabel("wx:");
		JLabel label2 = new JLabel("wy:");
		JLabel label3 = new JLabel("scaleX:");
		JLabel label4 = new JLabel("scaleY:");
		panel.add(label1);
		panel.add(text1);
		panel.add(label2);
		panel.add(text2);
		panel.add(label3);
		panel.add(text3);
		panel.add(label4);
		panel.add(text4);
		JFrame mainFrame = new JFrame("3D");
		mainFrame.setSize(400, 424);
		mainFrame.getContentPane().add(
				new MyCanvas(400, 400, text1, text2, text3, text4, test.getObjects()));
		mainFrame.getContentPane().add(panel);
		mainFrame.setVisible(true);
	}

}
