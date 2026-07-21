package com.airbnb.lottie.u;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: MergePathsParser.java */
/* JADX INFO: loaded from: classes.dex */
class v {
    static com.airbnb.lottie.s.j.h a(JsonReader jsonReader) throws IOException {
        String strNextString = null;
        com.airbnb.lottie.s.j.h.a aVarG = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("mm")) {
                aVarG = com.airbnb.lottie.s.j.h.a.g(jsonReader.nextInt());
            } else if (strNextName.equals("nm")) {
                strNextString = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        return new com.airbnb.lottie.s.j.h(strNextString, aVarG);
    }
}
