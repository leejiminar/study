package org.example.network.restapi;

import java.io.IOException;
import java.net.*;

public class URLExample {
    public static void main(String[] args) throws IOException, URISyntaxException {
        try {
            URI uri = new URI("http://elice.io:8282/student/phones?os=android#samsung");
            URL url = uri.toURL();

            System.out.println("Protocol = " + url.getProtocol());
            System.out.println("Host = " + url.getHost());
            System.out.println("Path = " + url.getPath());
            System.out.println("Port = " + url.getPort());
            System.out.println("Query = " + url.getQuery());
            System.out.println("Authority = " + url.getAuthority());
            System.out.println("UserInfo = " + url.getUserInfo());

            URLConnection urlConnection = url.openConnection();
            System.out.println(urlConnection);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
