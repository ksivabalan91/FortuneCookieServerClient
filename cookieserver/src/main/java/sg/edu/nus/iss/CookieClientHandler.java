package sg.edu.nus.iss;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class CookieClientHandler implements Runnable{

    private Socket s = new Socket();
    private Cookie cookie;

    public CookieClientHandler(Socket s, Cookie cookie) {
        this.s = s;
        this.cookie = cookie;
    }

    @Override
    public void run(){
        try{
            InputStream is = s.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);
            OutputStream os = s.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);

            String msgRecieved = "";

            while(!msgRecieved.equals("close")){
                msgRecieved = dis.readUTF();

                if(msgRecieved.equalsIgnoreCase("get-cookie")){
                    String cookieValue = cookie.returnCookie();
                    dos.writeUTF(cookieValue);
                    dos.flush();
                }
            }
                            
            
        }catch (EOFException e){
            try {
                s.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            // ss.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }
    

    
}
