package me.meczka.bloxx.graphics;

import java.awt.DisplayMode;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.image.BufferStrategy;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;

public class ScreenManager {
	
	private GraphicsDevice device;
	public ScreenManager()
	{
		GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		device = environment.getDefaultScreenDevice();
	}
	public void setFullScreenWindow(DisplayMode displayMode)
	{
		final JFrame frame = new JFrame();
		frame.setUndecorated(true);
        frame.setIgnoreRepaint(true);
        frame.setResizable(false);
        device.setFullScreenWindow(frame);
        if(displayMode != null && device.isDisplayChangeSupported())
        {
        	try{
        		device.setDisplayMode(displayMode);
        	}
        	catch(IllegalArgumentException ex) {}
        	frame.setSize(displayMode.getWidth(), displayMode.getHeight());
        	try {
                try {
					EventQueue.invokeAndWait(new Runnable() {
					    public void run() {
					        frame.createBufferStrategy(2);
					    }
					});
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            catch (InterruptedException ex) {
                // ignorowane
            }
        }
	}
	public Graphics2D getGraphics()
	{
		Window window = device.getFullScreenWindow();
		if(window != null)
		{
			BufferStrategy buffer = window.getBufferStrategy();
			return (Graphics2D) buffer.getDrawGraphics();
		}
		else
		{
			return null;
		}
	}
	public JFrame getFullScreenWindow()
	{
		return (JFrame) device.getFullScreenWindow();
	}
	public void update() {
        Window window = device.getFullScreenWindow();
        if (window != null) {
            BufferStrategy strategy = window.getBufferStrategy();
            if (!strategy.contentsLost()) {
                strategy.show();
            }
        }
        // Operacja Sync, dzia³aj¹ca w niektórych systemach
        // (w systemie Linux naprawia problem z kolejk¹ zdarzeñ).
        Toolkit.getDefaultToolkit().sync();
    }
	public void restoreScreen() {
        Window window = device.getFullScreenWindow();
        if (window != null) {
            window.dispose();
        }
        device.setFullScreenWindow(null);
    }
	/**
    Zwraca szerokoœæ okna u¿ytego obecnie w trybie pe³noekranowym.
    Zwraca 0, je¿eli urz¹dzenie nie jest w trybie pe³noekranowym.
*/
public int getWidth() {
    Window window = device.getFullScreenWindow();
    if (window != null) {
        return window.getWidth();
    }
    else {
        return 0;
    }
}


/**A
    Zwraca wysokoœæ okna u¿ytego obecnie w trybie pe³noekranowym.
    Zwraca 0, je¿eli urz¹dzenie nie jest w trybie pe³noekranowym.
*/
public int getHeight() {
    Window window = device.getFullScreenWindow();
    if (window != null) {
        return window.getHeight();
    }
    else {
        return 0;
    }
}
	
	

}
