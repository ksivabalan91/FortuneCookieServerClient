package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cookie {
    String dirPath = "data2";
    String fileName = "cookie.txt";
    List<String> cookieItems = null;
    
    public void readCookieFile() throws IOException, FileNotFoundException{

        cookieItems = new ArrayList<>();
        File file = new File(dirPath+File.separator+fileName);

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String readString;

        while((readString = br.readLine())!=null){
            cookieItems.add(readString);
        }        
        br.close();
    }    

    public String returnCookie(){
        Random rand = new Random();
        
        if(cookieItems != null){
            return cookieItems.get(rand.nextInt(cookieItems.size()));

        } else{
            return "No cookie found";
        }
    }

    public void showCookies(){
        if (cookieItems!=null){
            // cookieItems.forEach(cook->System.out.println(cook)); // either this or the one below
            for (String s:cookieItems)
            System.out.println(s);
        }
    }
}
