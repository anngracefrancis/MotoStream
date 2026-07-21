package com.airbnb.lottie.u;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: AnimatablePathValueParser.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static com.airbnb.lottie.s.i.e a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(w.a(jsonReader, dVar));
            }
            jsonReader.endArray();
            r.b(arrayList);
        } else {
            arrayList.add(new com.airbnb.lottie.w.a(p.e(jsonReader, com.airbnb.lottie.v.f.e())));
        }
        return new com.airbnb.lottie.s.i.e(arrayList);
    }

    static com.airbnb.lottie.s.i.m<PointF, PointF> b(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        jsonReader.beginObject();
        com.airbnb.lottie.s.i.e eVarA = null;
        com.airbnb.lottie.s.i.b bVarE = null;
        com.airbnb.lottie.s.i.b bVarE2 = null;
        boolean z = false;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "k":
                    eVarA = a(jsonReader, dVar);
                    continue;
                    break;
                case "x":
                    if (jsonReader.peek() == JsonToken.STRING) {
                        jsonReader.skipValue();
                        break;
                    } else {
                        bVarE = d.e(jsonReader, dVar);
                    }
                    break;
                case "y":
                    if (jsonReader.peek() == JsonToken.STRING) {
                        jsonReader.skipValue();
                        break;
                    } else {
                        bVarE2 = d.e(jsonReader, dVar);
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    continue;
                    break;
            }
            z = true;
        }
        jsonReader.endObject();
        if (z) {
            dVar.a("Lottie doesn't support expressions.");
        }
        return eVarA != null ? eVarA : new com.airbnb.lottie.s.i.i(bVarE, bVarE2);
    }
}
