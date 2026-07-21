package com.airbnb.lottie.u;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: ShapeStrokeParser.java */
/* JADX INFO: loaded from: classes.dex */
class h0 {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:63:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:7:0x0027  */
    static com.airbnb.lottie.s.j.p a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String strNextString = null;
        com.airbnb.lottie.s.i.b bVar = null;
        com.airbnb.lottie.s.i.a aVarC = null;
        com.airbnb.lottie.s.i.d dVarH = null;
        com.airbnb.lottie.s.i.b bVarE = null;
        com.airbnb.lottie.s.j.p.b bVar2 = null;
        com.airbnb.lottie.s.j.p.c cVar = null;
        float fNextDouble = 0.0f;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "c":
                    aVarC = d.c(jsonReader, dVar);
                    break;
                case "d":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String strNextString2 = null;
                        com.airbnb.lottie.s.i.b bVarE2 = null;
                        while (jsonReader.hasNext()) {
                            String strNextName2 = jsonReader.nextName();
                            strNextName2.hashCode();
                            if (strNextName2.equals("n")) {
                                strNextString2 = jsonReader.nextString();
                            } else if (strNextName2.equals("v")) {
                                bVarE2 = d.e(jsonReader, dVar);
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                        strNextString2.hashCode();
                        switch (strNextString2) {
                            case "d":
                            case "g":
                                arrayList.add(bVarE2);
                                break;
                            case "o":
                                bVar = bVarE2;
                                break;
                        }
                    }
                    jsonReader.endArray();
                    if (arrayList.size() != 1) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                        break;
                    }
                    break;
                case "o":
                    dVarH = d.h(jsonReader, dVar);
                    break;
                case "w":
                    bVarE = d.e(jsonReader, dVar);
                    break;
                case "lc":
                    bVar2 = com.airbnb.lottie.s.j.p.b.values()[jsonReader.nextInt() - 1];
                    break;
                case "lj":
                    cVar = com.airbnb.lottie.s.j.p.c.values()[jsonReader.nextInt() - 1];
                    break;
                case "ml":
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.airbnb.lottie.s.j.p(strNextString, bVar, arrayList, aVarC, dVarH, bVarE, bVar2, cVar, fNextDouble);
    }
}
