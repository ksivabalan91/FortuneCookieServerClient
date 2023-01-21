package sg.edu.nus.iss;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }
    public static void main(String[] args) throws IOException,FileNotFoundException{

        String dirPath = "data2";
        File newDirectory = new File(dirPath);

        if (newDirectory.exists()){
            System.out.println("Directory already exists");
        } else{
            newDirectory.mkdir();
        }

        Cookie cookie = new Cookie();
        cookie.readCookieFile();
        // cookie.returnCookie();
        // cookie.showCookies();       
        

        ServerSocket ss = new ServerSocket(4269);
        
        while(true){
            Socket s = ss.accept();
            CookieClientHandler cookieHandler = new CookieClientHandler(s,cookie);
            cookieHandler.run();
        }

    }

}

