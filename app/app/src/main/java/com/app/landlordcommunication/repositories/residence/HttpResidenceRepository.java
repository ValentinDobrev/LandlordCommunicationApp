package com.app.landlordcommunication.repositories.residence;

import com.app.landlordcommunication.http.HttpRequester;
import com.app.landlordcommunication.models.Residence;
import com.app.landlordcommunication.parsers.base.JsonParser;
import com.app.landlordcommunication.repositories.residence.base.ResidenceRepository;

import java.io.IOException;
import java.util.List;

public class HttpResidenceRepository implements ResidenceRepository {

    private final HttpRequester mHttpRequester;
    private final String mServerUrl;
    private final JsonParser<Residence> mJsonParser;

    public HttpResidenceRepository(HttpRequester httpRequester, String serverUrl, JsonParser jsonParser) {
        mHttpRequester = httpRequester;
        mServerUrl = serverUrl;
        mJsonParser = jsonParser;
    }

    @Override
    public List<Residence> getResidencesByUser(int userId) throws IOException {
        String url = mServerUrl + "/" + userId;
        String json = mHttpRequester.get(url);
        return mJsonParser.fromJsonArray(json);
    }
}
