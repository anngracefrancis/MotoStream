package com.airbnb.lottie.u;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: ShapeTrimPathParser.java */
/* JADX INFO: loaded from: classes.dex */
class i0 {
    static com.airbnb.lottie.s.j.q a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        String strNextString = null;
        com.airbnb.lottie.s.j.q.a aVarG = null;
        com.airbnb.lottie.s.i.b bVarF = null;
        com.airbnb.lottie.s.i.b bVarF2 = null;
        com.airbnb.lottie.s.i.b bVarF3 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "e":
                    bVarF2 = d.f(jsonReader, dVar, false);
                    break;
                case "m":
                    aVarG = com.airbnb.lottie.s.j.q.a.g(jsonReader.nextInt());
                    break;
                case "o":
                    bVarF3 = d.f(jsonReader, dVar, false);
                    break;
                case "s":
                    bVarF = d.f(jsonReader, dVar, false);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.airbnb.lottie.s.j.q(strNextString, aVarG, bVarF, bVarF2, bVarF3);
    }
}
