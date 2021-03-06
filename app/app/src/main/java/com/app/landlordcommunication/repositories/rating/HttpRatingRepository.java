package com.app.landlordcommunication.repositories.rating;

import com.app.landlordcommunication.http.HttpRequester;
import com.app.landlordcommunication.models.Rating;
import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.models.UserRating;
import com.app.landlordcommunication.parsers.base.JsonParser;
import com.app.landlordcommunication.repositories.rating.base.RatingRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpRatingRepository implements RatingRepository {

    private final HttpRequester mHttpRequester;
    private final String mServerUrl;
    private final JsonParser<UserRating> mJsonParser;
    private final JsonParser<Rating> mRatingRecordJsonParser;

    public HttpRatingRepository (HttpRequester httpRequester, String serverUrl, JsonParser<UserRating> jsonParser, JsonParser<Rating> ratingRecordJsonParser) {
        mHttpRequester = httpRequester;
        mServerUrl = serverUrl;
        mJsonParser = jsonParser;
        mRatingRecordJsonParser = ratingRecordJsonParser;
    }

    @Override
    public UserRating getRatingByUserId(int id) throws IOException {
        String url = mServerUrl + "/" + id;
        String json = mHttpRequester.get(url);
        return mJsonParser.fromJson(json);
    }

    @Override
    public List<UserRating> getAllRatings(List<User> users) throws IOException {
        List<UserRating> result = new ArrayList<>();

        for (User u : users) {
            result.add(getRatingByUserId(u.getUserId()));
        }

        return result;
    }

    @Override
    public Rating addRatingRecord(Rating ratingRecord) throws IOException {
        String requestBody = mRatingRecordJsonParser.toJson(ratingRecord);
        String responseBody = mHttpRequester.post(mServerUrl, requestBody);
        return mRatingRecordJsonParser.fromJson(responseBody);
    }
}
