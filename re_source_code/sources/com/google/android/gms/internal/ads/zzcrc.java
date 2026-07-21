package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import com.google.android.gms.ads.internal.zzk;
import java.io.IOException;
import okhttp3.HttpUrl;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcrc {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f15558b;

    public zzcrc(JsonReader jsonReader) throws IllegalStateException, JSONException, IOException, NumberFormatException {
        jsonReader.beginObject();
        String strNextString = HttpUrl.FRAGMENT_ENCODE_SET;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if ((strNextName == null ? HttpUrl.FRAGMENT_ENCODE_SET : strNextName).equals("params")) {
                strNextString = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        this.a = strNextString;
        jsonReader.endObject();
    }

    final zzcrc a(Bundle bundle) {
        try {
            this.f15558b = zzk.zzlg().N(bundle).toString();
        } catch (JSONException unused) {
            this.f15558b = "{}";
        }
        return this;
    }
}
