package com.example.masha.testfork3.api;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static Retrofit retrofit = null;

    static {
        Retrofit.Builder builder = new Retrofit.Builder().
                baseUrl(BASE_URL).
                client(getHttpClient().build())
                .addConverterFactory(GsonConverterFactory.create());
        retrofit = builder.build();
    }

    private static OkHttpClient.Builder getHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addNetworkInterceptor(chain -> {
            final Request original = chain.request();
            final Request request = original.newBuilder().
                    header("Content-Type", "application/json").
                    method(original.method(), original.body()).
                    build();
            return chain.proceed(request);
        }).addInterceptor(logging);
        return httpClient;
    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }
}