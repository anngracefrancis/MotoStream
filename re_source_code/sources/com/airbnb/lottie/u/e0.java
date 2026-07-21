package com.airbnb.lottie.u;

import android.graphics.Path;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: ShapeFillParser.java */
/* JADX INFO: loaded from: classes.dex */
class e0 {
    static com.airbnb.lottie.s.j.m a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        String strNextString = null;
        com.airbnb.lottie.s.i.a aVarC = null;
        com.airbnb.lottie.s.i.d dVarH = null;
        int iNextInt = 1;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "fillEnabled":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "c":
                    aVarC = d.c(jsonReader, dVar);
                    break;
                case "o":
                    dVarH = d.h(jsonReader, dVar);
                    break;
                case "r":
                    iNextInt = jsonReader.nextInt();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.airbnb.lottie.s.j.m(strNextString, zNextBoolean, iNextInt == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVarC, dVarH);
    }
}
