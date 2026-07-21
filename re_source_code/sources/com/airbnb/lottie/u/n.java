package com.airbnb.lottie.u;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: GradientStrokeParser.java */
/* JADX INFO: loaded from: classes.dex */
class n {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0032  */
    static com.airbnb.lottie.s.j.e a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String strNextString = null;
        com.airbnb.lottie.s.j.f fVar = null;
        com.airbnb.lottie.s.i.c cVarG = null;
        com.airbnb.lottie.s.i.d dVarH = null;
        com.airbnb.lottie.s.i.f fVarI = null;
        com.airbnb.lottie.s.i.f fVarI2 = null;
        com.airbnb.lottie.s.i.b bVarE = null;
        com.airbnb.lottie.s.j.p.b bVar = null;
        com.airbnb.lottie.s.j.p.c cVar = null;
        float fNextDouble = 0.0f;
        com.airbnb.lottie.s.i.b bVar2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            com.airbnb.lottie.s.i.b bVar3 = bVar2;
            float f2 = fNextDouble;
            switch (strNextName) {
                case "d":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String strNextString2 = null;
                        com.airbnb.lottie.s.i.b bVarE2 = null;
                        while (jsonReader.hasNext()) {
                            String strNextName2 = jsonReader.nextName();
                            strNextName2.hashCode();
                            com.airbnb.lottie.s.j.p.c cVar2 = cVar;
                            if (strNextName2.equals("n")) {
                                strNextString2 = jsonReader.nextString();
                            } else if (strNextName2.equals("v")) {
                                bVarE2 = d.e(jsonReader, dVar);
                            } else {
                                jsonReader.skipValue();
                            }
                            cVar = cVar2;
                        }
                        com.airbnb.lottie.s.j.p.c cVar3 = cVar;
                        jsonReader.endObject();
                        if (strNextString2.equals("o")) {
                            bVar3 = bVarE2;
                        } else if (strNextString2.equals("d") || strNextString2.equals("g")) {
                            arrayList.add(bVarE2);
                        }
                        cVar = cVar3;
                    }
                    com.airbnb.lottie.s.j.p.c cVar4 = cVar;
                    jsonReader.endArray();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    bVar2 = bVar3;
                    fNextDouble = f2;
                    cVar = cVar4;
                    continue;
                    break;
                case "e":
                    fVarI2 = d.i(jsonReader, dVar);
                    break;
                case "g":
                    jsonReader.beginObject();
                    int iNextInt = -1;
                    while (jsonReader.hasNext()) {
                        String strNextName3 = jsonReader.nextName();
                        strNextName3.hashCode();
                        if (strNextName3.equals("k")) {
                            cVarG = d.g(jsonReader, dVar, iNextInt);
                        } else if (strNextName3.equals("p")) {
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
                case "s":
                    fVarI = d.i(jsonReader, dVar);
                    break;
                case "t":
                    fVar = jsonReader.nextInt() == 1 ? com.airbnb.lottie.s.j.f.Linear : com.airbnb.lottie.s.j.f.Radial;
                    break;
                case "w":
                    bVarE = d.e(jsonReader, dVar);
                    break;
                case "lc":
                    bVar = com.airbnb.lottie.s.j.p.b.values()[jsonReader.nextInt() - 1];
                    break;
                case "lj":
                    cVar = com.airbnb.lottie.s.j.p.c.values()[jsonReader.nextInt() - 1];
                    break;
                case "ml":
                    fNextDouble = (float) jsonReader.nextDouble();
                    bVar2 = bVar3;
                    continue;
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
            bVar2 = bVar3;
            fNextDouble = f2;
        }
        return new com.airbnb.lottie.s.j.e(strNextString, fVar, cVarG, dVarH, fVarI, fVarI2, bVarE, bVar, cVar, fNextDouble, arrayList, bVar2);
    }
}
