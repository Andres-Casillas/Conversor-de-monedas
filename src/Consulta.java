import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consulta {
    public Conversor consultaConversor(String monedaBase, String monedaObjetivo, Double monto) throws IOException, InterruptedException{
        String direccion = "https://v6.exchangerate-api.com/v6/09e5ebe1ce983f2b83449a42/pair/"+ monedaBase + "/" + monedaObjetivo + "/" + monto;
        URI url = URI.create(direccion);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();
        HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

        return new Gson().fromJson(response.body(), Conversor.class);
    }
}