package com.airbnb.lottie.u;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: AnimatableTextPropertiesParser.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static com.airbnb.lottie.s.i.k a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        jsonReader.beginObject();
        com.airbnb.lottie.s.i.k kVarB = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("a")) {
                kVarB = b(jsonReader, dVar);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return kVarB == null ? new com.airbnb.lottie.s.i.k(null, null, null, null) : kVarB;
    }

    private static com.airbnb.lottie.s.i.k b(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        jsonReader.beginObject();
        com.airbnb.lottie.s.i.a aVarC = null;
        com.airbnb.lottie.s.i.a aVarC2 = null;
        com.airbnb.lottie.s.i.b bVarE = null;
        com.airbnb.lottie.s.i.b bVarE2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "t":
                    bVarE2 = d.e(jsonReader, dVar);
                    break;
                case "fc":
                    aVarC = d.c(jsonReader, dVar);
                    break;
                case "sc":
                    aVarC2 = d.c(jsonReader, dVar);
                    break;
                case "sw":
                    bVarE = d.e(jsonReader, dVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.airbnb.lottie.s.i.k(aVarC, aVarC2, bVarE, bVarE2);
    }
}
