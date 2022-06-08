package eu.sige.daterbackend.service;

import okhttp3.HttpUrl;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DogServiceFlickr implements DogService {

    @Override
    public String getDogUrl() {
        HttpUrl.Builder urlBuilder
                = HttpUrl.parse("https://www.flickr.com/services/feeds/photos_public.gne").newBuilder();
        String tagmode = getTagmodeWithWeigh();
        urlBuilder.addQueryParameter("tagmode", tagmode);
        urlBuilder.addQueryParameter("tags", getTags(tagmode));
        urlBuilder.addQueryParameter("format", "json");

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
