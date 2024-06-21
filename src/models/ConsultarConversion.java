package models;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarConversion {
    public DataConversion ConsultarMoneda (){
        //Gson gson = new Gson();
        String URL = "https://v6.exchangerate-api.com/v6/c6f53a062b31d5a36fb5b146/latest/USD";
        HttpClient client = HttpClient.newHttpClient();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();

            return new Gson().fromJson(jsonObject.get("conversion_rates").getAsJsonObject(), DataConversion.class);
            //return jsonObject.get("conversion_rates").getAsJsonObject();
            //System.out.println("Conversion a json: "+jsonObject.get("conversion_rates").getAsJsonObject());
            //System.out.println("Conversion a json: "+dataConversion);
        } catch (IOException | InterruptedException | NullPointerException e) {
            System.out.println("Ocurrio un error: ");
            System.out.println(e.getMessage());
            //throw new RuntimeException("Conexion con la API fallida");
        }
        return null;
    }
}
