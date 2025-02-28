package com.consultador; 
import org.springframework.stereotype.Component;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

@Component 
public class ConsultaCep {
    private static final String BASE_URL = "https://viacep.com.br/ws/";

    public String consultaCEP(String cep) throws Exception {
        String url = BASE_URL + cep + "/json";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(request);

        try {
            if (response.getStatusLine().getStatusCode() == 200) {
                return EntityUtils.toString(response.getEntity());
            } else {
                throw new Exception("Erro ao consultar o CEP: " + response.getStatusLine().getStatusCode());
            }
        } finally {
            response.close();
        }
    }

    public static void main(String[] args) {
        ConsultaCep consulta = new ConsultaCep();
        try {
            System.out.println(consulta.consultaCEP("01001000"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
