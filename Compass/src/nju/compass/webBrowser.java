package nju.compass;

import java.awt.Toolkit;

import javafx.scene.image.Image;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.browser.Browser;

public class webBrowser implements Runnable{
	/**
	 * Launch the application.
	 * @param args
	 */
	private String input;
	private Display display;
	public static void main(String args[]) {
		webBrowser pp = new webBrowser("www.baidu.com");
		Thread myThread = new Thread(pp);
		myThread.start();
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public webBrowser(String webSite) {
		input = webSite;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		go();
	}
	
	public void go() {
		display = new Display(); 
        Shell shell = new Shell(display); 
        shell.setText("财经新闻浏览"); 
        shell.setSize(800,600); 
		shell.setLayout(new FormLayout());
		shell.setImage(new org.eclipse.swt.graphics.Image(Display.getCurrent(),
                "image/image_2.jpg"));
		// 居中显示
		int nLocationX = Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x / 2;  
	    int nLocationY = Display.getCurrent().getClientArea().height / 2 - shell.getSize().y / 2;  
	    shell.setLocation(nLocationX, nLocationY); 
	    
		Label label = new Label(shell, SWT.NONE);
		FormData fd_label = new FormData();
		fd_label.left = new FormAttachment(0, 10);
		fd_label.top = new FormAttachment(0, 10);
		label.setLayoutData(fd_label);
		label.setText("Input url:");
		
		final Text text = new Text(shell, SWT.BORDER);
		fd_label.right = new FormAttachment(text, -39);
		FormData fd_text = new FormData();
		fd_text.left = new FormAttachment(0, 101);
		fd_text.top = new FormAttachment(0, 7);
		text.setLayoutData(fd_text);
		
		Button btnGo = new Button(shell, SWT.NONE);
		fd_text.right = new FormAttachment(100, -212);
		FormData fd_btnGo = new FormData();
		fd_btnGo.top = new FormAttachment(label, -5, SWT.TOP);
		fd_btnGo.left = new FormAttachment(text, 35);
		fd_btnGo.right = new FormAttachment(100, -126);
		btnGo.setLayoutData(fd_btnGo);
		btnGo.setText("go");
		
		final Browser browser = new Browser(shell, SWT.NONE);
		FormData fd_browser = new FormData();
		fd_browser.left = new FormAttachment(0, 10);
		fd_browser.right = new FormAttachment(100, -10);
		fd_browser.bottom = new FormAttachment(100, -5);
		fd_browser.top = new FormAttachment(0, 37);
		browser.setLayoutData(fd_browser);
	
        text.setText(input);
        browser.setUrl(input);
        
        btnGo.addListener(SWT.Selection, new Listener() 
        { 
            @Override
			public void handleEvent(Event event) 
            { 
                String input=text.getText().trim(); 
                if(input.length()==0)return; 
                if(!input.startsWith("http://")) 
                { 
                    input="http://"+input; 
                    text.setText(input); 
                } 
                browser.setUrl(input); 
            } 
        });
        
        shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
