package eu.sige.daterbackend.service;

import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Component;

@Component
public class HttpService {

    private final OkHttpClient okHttpClient;

    public HttpService() {
        this.okHttpClient = new OkHttpClient();
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }
}
