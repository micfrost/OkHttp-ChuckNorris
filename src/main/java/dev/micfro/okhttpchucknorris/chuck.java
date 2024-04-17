package dev.micfro.okhttpchucknorris;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

public class chuck {
    public static void main(String[] args) {
        System.out.println("- - - - -");
        System.out.println("Hello, Chuck Norris API here!");
        System.out.println("");
        fetchChuckNorrisJoke();
    }
    private static void fetchChuckNorrisJoke() {
        // Define the URL
        String url = "https://api.chucknorris.io/jokes/random";

        OkHttpClient okHttpClient = new OkHttpClient();
        // create a request object with the URL
        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            // execute newCall method to make synchronous call request
            // to the URL and get the response as an object of Response class
            Response response = okHttpClient.newCall(request).execute();
            // check if the response is successful - status code 200
            if (response.isSuccessful() && response.body() != null) {
                // get the response body as a string
                String responseBodyAsString = response.body().string();
                parseAndDisplayJoke(responseBodyAsString);
            } else {
                // print the error message
                System.out.println("Error occurred while sending GET request");
            }
        } catch (Exception e) {
            System.out.println("Error occurred while sending GET request: " + e.getMessage());
        }
    }
    private static void parseAndDisplayJoke(String responseBodyAsString) {
        JSONObject jsonObject = new JSONObject(responseBodyAsString);
        String joke = jsonObject.getString("value");
        System.out.println("Random Chuck Norris Joke: " + joke);
        System.out.println("");
        System.out.println("Hahahaha. Goodbye, Chuck Norris API!");
        System.out.println("- - - - -");
    }
}
