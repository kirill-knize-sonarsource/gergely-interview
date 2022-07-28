package eu.sige.daterbackend.service;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

@Service
public class DogServiceFlickr implements DogService {

    private final HttpService httpService;
    private final Random random;

    private final CacheService<String> cacheService;

    @Autowired
    public DogServiceFlickr(HttpService httpService, CacheService<String> cacheService) {
        this.httpService = httpService;
        this.cacheService = cacheService;
        refillCache().start();
        try {
            this.random = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getDogApi() {
        String apiResponse = cacheService.getAndRemoveElement();
        refillCache().start();
        return apiResponse;
    }

    private String getDogApiFromFlickr() {
        Request request = new Request.Builder().url(getDogUrl()).build();
        Call call = httpService.getOkHttpClient().newCall(request);

        try (
                Response response = call.execute()
        ) {
            String dogApiResponse = "";
            if (response.body() != null) {
                dogApiResponse = response.body().string();
                dogApiResponse = createValidJson(dogApiResponse);
            }
            return dogApiResponse;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @NotNull
    private String createValidJson(String dogApiResponse) {
        dogApiResponse = dogApiResponse.substring(15);
        dogApiResponse = dogApiResponse.substring(0, dogApiResponse.length() - 1);
        return dogApiResponse;
    }

    private String getDogUrl() {
        HttpUrl url = HttpUrl.parse("https://www.flickr.com/services/feeds/photos_public.gne");
        if (url == null) {
            return "";
        }

        HttpUrl.Builder urlBuilder = url.newBuilder();
        String tagmode = getTagmodeWithWeigh();
        urlBuilder.addQueryParameter("tagmode", tagmode);
        urlBuilder.addQueryParameter("tags", getTags(tagmode));
        urlBuilder.addQueryParameter("format", "json");

        return urlBuilder.build().toString();
    }

    private String getTagmodeWithWeigh() {
        String[] tagModsWeighted = {"all", "all", "any"};
        return tagModsWeighted[random.nextInt(3)];
    }

    private String getTags(String tagmode) {
        if (tagmode.equals("any")) {
            return "wiener dog, sausage dog";
        }
        return "dachshund, wiener dog, sausage dog";
    }

    public Thread refillCache() {
        return new Thread(() -> {
            while (cacheService.getActualSize() <= CacheService.CACHE_CAPACITY) {
                cacheService.add(getDogApiFromFlickr());
            }
        });
    }

}
