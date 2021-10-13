package ps.webapi.automation;

import java.util.Scanner;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpGetExample {
    public HttpGetExample() {
    }

    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("https://api.github.com");
        System.out.println("Request Type: " + httpget.getMethod());
        HttpResponse httpresponse = httpclient.execute(httpget);
        Scanner sc = new Scanner(httpresponse.getEntity().getContent());
        System.out.println(httpresponse.getStatusLine());

        while(sc.hasNext()) {
            System.out.println(sc.nextLine());
        }

    }
}