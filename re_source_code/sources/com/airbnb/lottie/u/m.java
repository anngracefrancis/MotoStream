package com.airbnb.lottie.u;

import android.graphics.Path;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: GradientFillParser.java */
/* JADX INFO: loaded from: classes.dex */
class m {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x001e  */
    static com.airbnb.lottie.s.j.d a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        String strNextString = null;
        com.airbnb.lottie.s.j.f fVar = null;
        Path.FillType fillType = null;
        com.airbnb.lottie.s.i.c cVarG = null;
        com.airbnb.lottie.s.i.d dVarH = null;
        com.airbnb.lottie.s.i.f fVarI = null;
        com.airbnb.lottie.s.i.f fVarI2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            int iNextInt = -1;
            switch (strNextName) {
                case "e":
                    fVarI2 = d.i(jsonReader, dVar);
                    break;
                case "g":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals("k")) {
                            cVarG = d.g(jsonReader, dVar, iNextInt);
                        } else if (strNextName2.equals("p")) {
                            iNextInt = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "o":
                    dVarH = d.h(jsonReader, dVar);
                    break;
                case "r":
                    fillType = jsonReader.nextInt() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case "s":
                    fVarI = d.i(jsonReader, dVar);
                    break;
                case "t":
                    fVar = jsonReader.nextInt() == 1 ? com.airbnb.lottie.s.j.f.Linear : com.airbnb.lottie.s.j.f.Radial;
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.airbnb.lottie.s.j.d(strNextString, fVar, fillType, cVarG, dVarH, fVarI, fVarI2, null, null);
    }
}
