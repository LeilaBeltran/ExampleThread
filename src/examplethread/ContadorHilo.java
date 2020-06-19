package examplethread;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

public class ContadorHilo extends Thread{
    private JTextField txtV;
    private boolean isRun = false;
    public ContadorHilo(JTextField txtV){
        this.txtV=txtV;
    }
    
public synchronized void detener(){
    isRun=false;
}

    @Override
    public void run(){
        isRun=true;
        while(true){
             try {
                long v= Long.parseLong(txtV.getText());
                v++;
                txtV.setText(String.valueOf(v)); 
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ContadorHilo.class.getName()).log(Level.SEVERE, null, ex);
            }
                  
        }
    }
    
}
