package eu.sige.daterbackend.service;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Random;

@Service
public class DogServiceFlickr implements DogService {

    final HttpService httpService;

    @Autowired
    public DogServiceFlickr(HttpService httpService) {
        this.httpService = httpService;
    }

    @Override
    public String getDogApi() {
        Request request = new Request.Builder().url(getDogUrl()).build();
        Call call = httpService.getOkHttpClient().newCall(request);
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            String dogApiResponse = response.body().string();
            dogApiResponse = createValidJson(dogApiResponse);
            return dogApiResponse;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    private String createValidJson(String dogApiResponse) {
        dogApiResponse = dogApiResponse.substring(15);
        dogApiResponse = dogApiResponse.substring(0, dogApiResponse.length() - 1);
        return dogApiResponse;
    }

    private String getDogUrl() {
        HttpUrl.Builder urlBuilder
                = HttpUrl.parse("https://www.flickr.com/services/feeds/photos_public.gne").newBuilder();
        String tagmode = getTagmodeWithWeigh();
        urlBuilder.addQueryParameter("tagmode", tagmode);
        urlBuilder.addQueryParameter("tags", getTags(tagmode));
        urlBuilder.addQueryParameter("format", "json");

        System.out.println(urlBuilder.build().toString());

        return urlBuilder.build().toString();
    }

    private String getTagmodeWithWeigh() {
        String[] tagModsWeighted = {"all", "all", "any"};
        Random random = new Random();
        return tagModsWeighted[random.nextInt(3)];
    }

    private String getTags(String tagmode) {
        if (tagmode.equals("any")) {
            return "wiener dog, sausage dog";
        }
        return "dachshund, wiener dog, sausage dog";
    }

}
