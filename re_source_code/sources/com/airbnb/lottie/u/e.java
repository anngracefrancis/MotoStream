package com.airbnb.lottie.u;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: CircleShapeParser.java */
/* JADX INFO: loaded from: classes.dex */
class e {
    static com.airbnb.lottie.s.j.a a(JsonReader jsonReader, com.airbnb.lottie.d dVar, int i2) throws IOException {
        boolean z = i2 == 3;
        String strNextString = null;
        com.airbnb.lottie.s.i.m<PointF, PointF> mVarB = null;
        com.airbnb.lottie.s.i.f fVarI = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "d":
                    if (jsonReader.nextInt() != 3) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                    break;
                case "p":
                    mVarB = a.b(jsonReader, dVar);
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
        return new com.airbnb.lottie.s.j.a(strNextString, mVarB, fVarI, z);
    }
}
