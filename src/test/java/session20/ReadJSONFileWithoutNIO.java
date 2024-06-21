package session20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;

public class ReadJSONFileWithoutNIO {

    private static final String XRAY_API_URL = "https://xray.cloud.getxray.app/api/v2/import/execution/cucumber";
    private static final String AUTHORIZATION = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnQiOiI5NmU5YzEzMi04ZWNiLTM5Y2MtOWE0MC1mYWIwYmJmOTQ5ZDIiLCJhY2NvdW50SWQiOiI1ZTRlZWZmMGFiOTAyMTBjOGRlMWFkMGEiLCJpc1hlYSI6ZmFsc2UsImlhdCI6MTcxNjE5NTkxOSwiZXhwIjoxNzE2MjgyMzE5LCJhdWQiOiI5NDg1MDY1MDcxOTg0MjE0OEQ2MTlCQTRFQzQxMjVDNiIsImlzcyI6ImNvbS54cGFuZGl0LnBsdWdpbnMueHJheSIsInN1YiI6Ijk0ODUwNjUwNzE5ODQyMTQ4RDYxOUJBNEVDNDEyNUM2In0.sbeZfCqPxl9amrkJQ6qJ-m4GCIMeRDZPTcJnlJFMr1k";

    public static void main(String[] args) throws IOException {
        // Create a BufferedReader object to read the JSON file.
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\210076\\Downloads\\cucumber_report.json"));

        // Read the JSON file line by line.
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        // Close the BufferedReader object.
        reader.close();

        // Convert the StringBuilder object to a string.
        String json = sb.toString();

        // Print the JSON string to the console.
        System.out.println(json);

        uploadResultsToXray(json);
    }


    private static void uploadResultsToXray(String jsonReport) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(XRAY_API_URL);

        httpPost.setHeader("Authorization", AUTHORIZATION);
        httpPost.setHeader("Content-Type", "application/json");

        StringEntity entity = new StringEntity(jsonReport);
        httpPost.setEntity(entity);

        String response = EntityUtils.toString(httpClient.execute(httpPost).getEntity());
        System.out.println("Response from Xray: " + response);

        httpClient.close();
    }
}
