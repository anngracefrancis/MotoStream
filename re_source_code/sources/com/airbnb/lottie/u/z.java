package com.airbnb.lottie.u;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: PolystarShapeParser.java */
/* JADX INFO: loaded from: classes.dex */
class z {
    static com.airbnb.lottie.s.j.i a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        String strNextString = null;
        com.airbnb.lottie.s.j.i.a aVarG = null;
        com.airbnb.lottie.s.i.b bVarF = null;
        com.airbnb.lottie.s.i.m<PointF, PointF> mVarB = null;
        com.airbnb.lottie.s.i.b bVarF2 = null;
        com.airbnb.lottie.s.i.b bVarE = null;
        com.airbnb.lottie.s.i.b bVarE2 = null;
        com.airbnb.lottie.s.i.b bVarF3 = null;
        com.airbnb.lottie.s.i.b bVarF4 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "p":
                    mVarB = a.b(jsonReader, dVar);
                    break;
                case "r":
                    bVarF2 = d.f(jsonReader, dVar, false);
                    break;
                case "ir":
                    bVarE = d.e(jsonReader, dVar);
                    break;
                case "is":
                    bVarF3 = d.f(jsonReader, dVar, false);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "or":
                    bVarE2 = d.e(jsonReader, dVar);
                    break;
                case "os":
                    bVarF4 = d.f(jsonReader, dVar, false);
                    break;
                case "pt":
                    bVarF = d.f(jsonReader, dVar, false);
                    break;
                case "sy":
                    aVarG = com.airbnb.lottie.s.j.i.a.g(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.airbnb.lottie.s.j.i(strNextString, aVarG, bVarF, mVarB, bVarF2, bVarE, bVarE2, bVarF3, bVarF4);
    }
}
