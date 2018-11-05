package com.app.landlordcommunication.repositories.user;

import com.app.landlordcommunication.Constants;
import com.app.landlordcommunication.http.HttpRequester;
import com.app.landlordcommunication.models.AuthorisationInfo;
import com.app.landlordcommunication.models.LoginInfo;
import com.app.landlordcommunication.models.Rating;
import com.app.landlordcommunication.models.User;
import com.app.landlordcommunication.parsers.base.JsonParser;
import com.app.landlordcommunication.repositories.user.base.UserRepository;

import java.io.IOException;
import java.util.List;

public class HttpUserRepository implements UserRepository {

    private final HttpRequester mHttpRequester;
    private final String mServerUrl;
    private final JsonParser<User> mJsonParserUser;
    private final JsonParser<Rating> mJsonParserRating;
    private final JsonParser<AuthorisationInfo> mAuthorisationInfoJsonParser;
    private final JsonParser<LoginInfo> mLoginInfoJsonParser;

    public HttpUserRepository(HttpRequester mHttpRequester, String mServerUrl, JsonParser<User> mJsonParserUser, JsonParser<Rating> mJsonParserRating, JsonParser<AuthorisationInfo> mAuthorisationInfoJsonParser, JsonParser<LoginInfo> mLoginInfoJsonParser) {
        this.mHttpRequester = mHttpRequester;
        this.mServerUrl = mServerUrl;
        this.mJsonParserUser = mJsonParserUser;
        this.mJsonParserRating = mJsonParserRating;
        this.mAuthorisationInfoJsonParser = mAuthorisationInfoJsonParser;
        this.mLoginInfoJsonParser = mLoginInfoJsonParser;
    }

    @Override
    public User getUserById(int userId) throws IOException {
        String url = mServerUrl + "/" + userId;
        String json = mHttpRequester.get(url);
        return mJsonParserUser.fromJson(json);
    }

    @Override
    public void createUser(User user) {
        //TODO
    }

    @Override
    public void modifyUser(int userId, User user) throws IOException {
        String url = mServerUrl + "/" + userId;
        String requestBody = mJsonParserUser.toJson(user);
        mHttpRequester.put(url, requestBody);
    }

    @Override
    public List<User> getAllUsers() throws IOException {
        String url = mServerUrl;
        String json = mHttpRequester.get(url);
        return mJsonParserUser.fromJsonArray(json);
    }

    @Override
    public List<User> getAllLandlords() throws IOException {
        String url = mServerUrl + "/landlords";
        String json = mHttpRequester.get(url);
        return mJsonParserUser.fromJsonArray(json);
    }

    @Override
    public List<Rating> getUserRatings(int userId) throws IOException {
        String url = mServerUrl + "/rating/" + userId;
        String jsonArray;
        jsonArray = mHttpRequester.get(url);
        return mJsonParserRating.fromJsonArray(jsonArray);
    }

    @Override
    public List<User> getUsersByResidence(int residenceId) throws IOException {
        String url = mServerUrl + "/in-residence/" + residenceId;
        String jsonArray;
        jsonArray = mHttpRequester.get(url);

        return mJsonParserUser.fromJsonArray(jsonArray);
    }

    @Override
    public void payRentFromTenantToLandlord(int tenantId, int landlordId, int residenceId) throws IOException {
        String url = mServerUrl + "/pay-rent/" + tenantId + "/" + landlordId + "/" + residenceId;
        mHttpRequester.put(url, null);
    }

    public AuthorisationInfo getUserByEmail(LoginInfo loginInfo) {

        String requestBody = mLoginInfoJsonParser.toJson(loginInfo);

        String url = Constants.BASE_SERVER_URL + "/authentication";

        String json;

        AuthorisationInfo authorisationInfo = null;

        try {
            json = mHttpRequester.post(url, requestBody);
            authorisationInfo = mAuthorisationInfoJsonParser.fromJson(json);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return authorisationInfo;

    }
}
