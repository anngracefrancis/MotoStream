package com.airbnb.lottie.u;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: ShapeGroupParser.java */
/* JADX INFO: loaded from: classes.dex */
class f0 {
    static com.airbnb.lottie.s.j.n a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String strNextString = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("it")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.airbnb.lottie.s.j.b bVarA = g.a(jsonReader, dVar);
                    if (bVarA != null) {
                        arrayList.add(bVarA);
                    }
                }
                jsonReader.endArray();
            } else if (strNextName.equals("nm")) {
                strNextString = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        return new com.airbnb.lottie.s.j.n(strNextString, arrayList);
    }
}
