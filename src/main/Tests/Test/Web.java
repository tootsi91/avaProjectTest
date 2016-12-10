package main.Tests.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

class Web{
    public static String getWeb(String address)throws Exception{
        String webpage = "";
        String inputLine = "";
        URL url = new URL(address);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()));
        while ((inputLine = in.readLine()) != null)
            webpage += inputLine;
        in.close();
        return webpage;
    }
}
