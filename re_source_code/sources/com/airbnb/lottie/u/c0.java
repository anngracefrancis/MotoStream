package com.airbnb.lottie.u;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: compiled from: ScaleXYParser.java */
/* JADX INFO: loaded from: classes.dex */
public class c0 implements j0<com.airbnb.lottie.w.d> {
    public static final c0 a = new c0();

    private c0() {
    }

    @Override // com.airbnb.lottie.u.j0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.airbnb.lottie.w.d a(JsonReader jsonReader, float f2) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        float fNextDouble = (float) jsonReader.nextDouble();
        float fNextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (z) {
            jsonReader.endArray();
        }
        return new com.airbnb.lottie.w.d((fNextDouble / 100.0f) * f2, (fNextDouble2 / 100.0f) * f2);
    }
}
