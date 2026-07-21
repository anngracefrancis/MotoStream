package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* JADX INFO: loaded from: classes2.dex */
public class JsonEOFException extends JsonParseException {
    protected final JsonToken _token;

    public JsonEOFException(JsonParser jsonParser, JsonToken jsonToken, String str) {
        super(jsonParser, str);
        this._token = jsonToken;
    }
}
