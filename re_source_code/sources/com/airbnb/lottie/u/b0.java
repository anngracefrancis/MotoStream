package com.airbnb.lottie.u;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: RepeaterParser.java */
/* JADX INFO: loaded from: classes.dex */
class b0 {
    static com.airbnb.lottie.s.j.k a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        String strNextString = null;
        com.airbnb.lottie.s.i.b bVarF = null;
        com.airbnb.lottie.s.i.b bVarF2 = null;
        com.airbnb.lottie.s.i.l lVarA = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "c":
                    bVarF = d.f(jsonReader, dVar, false);
                    break;
                case "o":
                    bVarF2 = d.f(jsonReader, dVar, false);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "tr":
                    lVarA = c.a(jsonReader, dVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.airbnb.lottie.s.j.k(strNextString, bVarF, bVarF2, lVarA);
    }
}
