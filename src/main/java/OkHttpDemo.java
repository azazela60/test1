
//1. С помощью http запроса получить в виде json строки погоду в Санкт-Петербурге на период времени,
// пересекающийся со следующим занятием (например, выборка погода на следующие 5 дней - подойдет)
//2. Подобрать источник самостоятельно. Можно использовать api accuweather, порядок следующий: зарегистрироваться,
// зарегистрировать тестовое приложение для получения api ключа, найдите нужный endpoint и изучите документацию.
// Бесплатный тарифный план предполагает получение погоды не более чем на 5 дней вперед
// (этого достаточно для выполнения д/з).


import okhttp3.*;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class OkHttpDemo {


    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .followRedirects(true)
                .retryOnConnectionFailure(true)
                .build();


        MediaType JSON = MediaType.parse("application/json");

        String authBodyString = "{" +
                "\"username\": \"azazela60@yandex.ru\", " +
                "\"password\": \"qwerty123\"" + "}";
        System.out.println(authBodyString);
        RequestBody requestBody = RequestBody.create(authBodyString, JSON);


        Request request = new Request.Builder()
                .url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212?apikey=H6ldpZ8Uej2NF2cOGdMmZa5wo1wWr0vq")
                .post(requestBody)
                .build();

        Response responseWithToken = client.newCall(request).execute();
        String responseBody = Objects.requireNonNull(responseWithToken.body()).string();
        System.out.println(responseBody);
        String token = responseBody.split(":")[1];
        token = token.replaceAll("[^\\p{L}\\p{Nd}]+", "");
        System.out.println(token);


        Response response = client.newCall(request).execute();

        System.out.println(response.code());
        System.out.println(response.headers());
        System.out.println(response.isRedirect());
        System.out.println(response.isSuccessful());
        System.out.println(response.protocol());
        System.out.println(response.receivedResponseAtMillis());


    }

}