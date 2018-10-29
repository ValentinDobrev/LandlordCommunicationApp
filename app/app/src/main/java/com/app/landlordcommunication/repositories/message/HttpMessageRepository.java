package com.app.landlordcommunication.repositories.message;

import com.app.landlordcommunication.http.HttpRequester;
import com.app.landlordcommunication.models.Message;
import com.app.landlordcommunication.parsers.base.JsonParser;
import com.app.landlordcommunication.repositories.message.base.MessageRepository;

import java.io.IOException;
import java.util.List;

public class HttpMessageRepository implements MessageRepository {

    private final HttpRequester mHttpRequester;
    private final String mServerUrl;
    private final JsonParser<Message> mJsonParser;

    public HttpMessageRepository(HttpRequester httpRequester, String serverUrl, JsonParser jsonParser) {
        mHttpRequester = httpRequester;
        mServerUrl = serverUrl;
        mJsonParser = jsonParser;
    }

    @Override
    public Message sendMessage(Message message) throws IOException {
        String requestBody = mJsonParser.toJson(message);
        String responseBody = mHttpRequester.post(mServerUrl, requestBody);
        return mJsonParser.fromJson(responseBody);
    }

    @Override
    public void deleteMessage(int messageId) throws IOException {
        String url = mServerUrl + "/" + messageId;
        mHttpRequester.delete(url);
    }

    @Override
    public List<Message> getAllMessagesByReceiverIdAndByResidenceId(int receiverId, int residenceId) throws IOException {
        String url = mServerUrl + "/for-receiver/" + receiverId + "/" + residenceId;
        String json = mHttpRequester.get(url);
        return mJsonParser.fromJsonArray(json);
    }

    @Override
    public List<Message> getAllMessagesBetweenReceiverAndSender(int receiverId, int senderId) throws IOException {
        String url = mServerUrl + "/for-receiver-by-sender/" + receiverId + "/" + senderId;
        String json = mHttpRequester.get(url);
        return mJsonParser.fromJsonArray(json);
    }
}
