package fr.gsbcr.views;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.UnsupportedLookAndFeelException;

public class StartApp {

    private JDialog dialog;
    protected void initUI() throws MalformedURLException, InterruptedException {
        showSplashScreen();
        //wait(1000);
        Thread.sleep(2000);
        hideSplashScreen();
    }

    protected void hideSplashScreen() {
        dialog.setVisible(false);
        dialog.dispose();
    }

    protected void showSplashScreen() throws MalformedURLException, InterruptedException {
        dialog = new JDialog((Frame) null);
        dialog.setModal(false);
        dialog.setUndecorated(true);
        JLabel background = new JLabel(new ImageIcon("bitmap.png"));
        background.setLayout(new BorderLayout());
        dialog.add(background);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);


    }

    public static void startApp() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException  {
                try {
                    new StartApp().initUI();
                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
   
    }
