package com.app.landlordcommunication.parsers;

import com.app.landlordcommunication.parsers.base.JsonParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;

public class GsonJsonParser<T> implements JsonParser<T> {
    private final Class<T> mKlass;
    private final Class<T[]> mArrayKlass;
    private final Gson mGson;


    public GsonJsonParser(Class<T> klass, Class<T[]> arrayKlass) {
        mKlass = klass;
        mArrayKlass = arrayKlass;
        mGson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();
    }

    @Override
    public List<T> fromJsonArray(String jsonString) {
        T[] result = mGson.fromJson(jsonString, mArrayKlass);
        return Arrays.asList(result);
    }

    @Override
    public T fromJson(String jsonString) {
        return mGson.fromJson(jsonString, mKlass);
    }

    @Override
    public String toJson(T object) {
        return mGson.toJson(object);
    }

}
