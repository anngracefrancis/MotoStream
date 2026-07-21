package com.airbnb.lottie.u;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: ShapePathParser.java */
/* JADX INFO: loaded from: classes.dex */
class g0 {
    static com.airbnb.lottie.s.j.o a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        String strNextString = null;
        com.airbnb.lottie.s.i.h hVarK = null;
        int iNextInt = 0;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "ks":
                    hVarK = d.k(jsonReader, dVar);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "ind":
                    iNextInt = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.airbnb.lottie.s.j.o(strNextString, iNextInt, hVarK);
    }
}
