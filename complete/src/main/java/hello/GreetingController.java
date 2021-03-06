package hello;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.concurrent.atomic.AtomicLong;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private static final String templateReminder = "Thanks, %s!";
    public static JDialog frame = null;
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/reminder")
    public Greeting reminder(@RequestParam(value="reminder", defaultValue="schedule") String name) {
    	testPopUp();
        return new Greeting(13,
                String.format(templateReminder, name));
    }
    
    public void testPopUp(){
    	String message = "Notification message to drink water"; 
		String header = "<HTML><B>Its time to Drink water</B></HTML>"; 
		
		
		frame = new JDialog();
		Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();// size of the screen
		Insets toolHeight = Toolkit.getDefaultToolkit().getScreenInsets(frame.getGraphicsConfiguration());// height of the task bar
		
		frame.setSize(400,300);
		frame.setUndecorated(true);
		frame.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints(); 
		constraints.gridx = 0; 
		constraints.gridy = 0; 
		constraints.weightx = 1.0f; 
		constraints.weighty = 1.0f; 
		constraints.insets = new Insets(5, 5, 5, 5); 
		constraints.fill = GridBagConstraints.BOTH; 
		JLabel headingLabel = new JLabel(header); 
		headingLabel .setIcon(new ImageIcon("C:\\Ranjani\\captainBOTIcon.PNG")); // --- use image icon you want to be as heading image. 



		headingLabel.setOpaque(false); 
		frame.add(headingLabel, constraints); 



		constraints.gridx++; 



		constraints.weightx = 0f; 



		constraints.weighty = 0f; 



		constraints.fill = GridBagConstraints.NONE; 



		constraints.anchor = GridBagConstraints.NORTH; 



		JButton cloesButton = new JButton(new AbstractAction("x") {
	        @Override
	        public void actionPerformed(final ActionEvent e) {
	               frame.dispose();
	        }
		});
 



		cloesButton.setMargin(new Insets(1, 4, 1, 4)); 



		cloesButton.setFocusable(false); 



		frame.add(cloesButton, constraints); 



		constraints.gridx = 0; 



		constraints.gridy++; 



		constraints.weightx = 1.0f; 



		constraints.weighty = 1.0f; 



		constraints.insets = new Insets(5, 5, 5, 5); 




		constraints.fill = GridBagConstraints.BOTH; 



		JLabel messageLabel = new JLabel("<HtMl>"+message); 



		frame.add(messageLabel, constraints); 



		frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE); 
		frame.setBackground(Color.blue);
		frame.setLocation(scrSize.width - frame.getWidth(), scrSize.height - toolHeight.bottom - frame.getHeight());

		frame.setVisible(true); 
		/*new Thread(){
		      @Override
		      public void run() {
		           try {
		                  Thread.sleep(5000); // time after which pop up will be disappeared.
		                  frame.dispose();
		           } catch (InterruptedException e) {
		                  e.printStackTrace();
		           }
		      };
		}.start();*/
    }
}
