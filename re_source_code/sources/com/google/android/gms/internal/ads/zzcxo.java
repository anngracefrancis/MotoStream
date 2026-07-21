package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import okhttp3.HttpUrl;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcxo {
    public final List<String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f15738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f15739e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f15740f;

    zzcxo(JsonReader jsonReader) throws IllegalStateException, JSONException, IOException, NumberFormatException {
        List<String> listEmptyList = Collections.emptyList();
        jsonReader.beginObject();
        String strNextString = HttpUrl.FRAGMENT_ENCODE_SET;
        String strNextString2 = HttpUrl.FRAGMENT_ENCODE_SET;
        long jNextLong = 0;
        int iNextInt = 0;
        int iNextInt2 = 0;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if ("nofill_urls".equals(strNextName)) {
                listEmptyList = zzazc.b(jsonReader);
            } else if ("refresh_interval".equals(strNextName)) {
                iNextInt = jsonReader.nextInt();
            } else if ("gws_query_id".equals(strNextName)) {
                strNextString = jsonReader.nextString();
            } else if ("analytics_query_ad_event_id".equals(strNextName)) {
                strNextString2 = jsonReader.nextString();
            } else if ("response_code".equals(strNextName)) {
                iNextInt2 = jsonReader.nextInt();
            } else if ("latency".equals(strNextName)) {
                jNextLong = jsonReader.nextLong();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        this.a = listEmptyList;
        this.f15737c = iNextInt;
        this.f15736b = strNextString;
        this.f15738d = strNextString2;
        this.f15739e = iNextInt2;
        this.f15740f = jNextLong;
    }
}
