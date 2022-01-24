package ar.com.eduit.curso.java.web.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteHttp {
        
    public static String responseBody(String url) throws InterruptedException, IOException {
        java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //if(response.statusCode()==200){
        //    System.out.println("\033[32mstatus: "+response.statusCode()+"\033[0m");
        //}else{
        //    System.out.println("\033[31mstatus: "+response.statusCode()+"\033[0m");
        //}
        //response.headers().map().forEach((k, v) -> System.out.println(k + " " + v));
        return response.body();
    }
}
