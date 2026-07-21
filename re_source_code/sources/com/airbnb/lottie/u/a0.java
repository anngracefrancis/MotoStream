package com.airbnb.lottie.u;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: RectangleShapeParser.java */
/* JADX INFO: loaded from: classes.dex */
class a0 {
    static com.airbnb.lottie.s.j.j a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        String strNextString = null;
        com.airbnb.lottie.s.i.m<PointF, PointF> mVarB = null;
        com.airbnb.lottie.s.i.f fVarI = null;
        com.airbnb.lottie.s.i.b bVarE = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "p":
                    mVarB = a.b(jsonReader, dVar);
                    break;
                case "r":
                    bVarE = d.e(jsonReader, dVar);
                    break;
                case "s":
                    fVarI = d.i(jsonReader, dVar);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.airbnb.lottie.s.j.j(strNextString, mVarB, fVarI, bVarE);
    }
}
