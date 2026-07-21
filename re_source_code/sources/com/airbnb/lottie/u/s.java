package com.airbnb.lottie.u;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: LayerParser.java */
/* JADX INFO: loaded from: classes.dex */
public class s {
    public static com.airbnb.lottie.s.k.d a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        ArrayList arrayList;
        com.airbnb.lottie.s.k.d.b bVar = com.airbnb.lottie.s.k.d.b.None;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        jsonReader.beginObject();
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        com.airbnb.lottie.s.k.d.b bVar2 = bVar;
        com.airbnb.lottie.s.k.d.a aVar = null;
        String strNextString = null;
        com.airbnb.lottie.s.i.l lVarA = null;
        com.airbnb.lottie.s.i.j jVarD = null;
        com.airbnb.lottie.s.i.k kVarA = null;
        com.airbnb.lottie.s.i.b bVarF = null;
        long jNextInt = 0;
        long jNextInt2 = -1;
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        int iNextInt = 0;
        int iNextInt2 = 0;
        int color = 0;
        float fNextDouble3 = 1.0f;
        float fNextDouble4 = 0.0f;
        int iNextInt3 = 0;
        int iNextInt4 = 0;
        String strNextString2 = null;
        String strNextString3 = "UNSET";
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "parent":
                    jNextInt2 = jsonReader.nextInt();
                    continue;
                    break;
                case "shapes":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.airbnb.lottie.s.j.b bVarA = g.a(jsonReader, dVar);
                        if (bVarA != null) {
                            arrayList3.add(bVarA);
                        }
                    }
                    jsonReader.endArray();
                    continue;
                    break;
                case "h":
                    iNextInt4 = (int) (jsonReader.nextInt() * com.airbnb.lottie.v.f.e());
                    continue;
                    break;
                case "t":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals("a")) {
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                kVarA = b.a(jsonReader, dVar);
                            }
                            while (jsonReader.hasNext()) {
                                jsonReader.skipValue();
                            }
                            jsonReader.endArray();
                        } else if (strNextName2.equals("d")) {
                            jVarD = d.d(jsonReader, dVar);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    continue;
                    break;
                case "w":
                    iNextInt3 = (int) (jsonReader.nextInt() * com.airbnb.lottie.v.f.e());
                    continue;
                    break;
                case "cl":
                    strNextString2 = jsonReader.nextString();
                    continue;
                    break;
                case "ef":
                    jsonReader.beginArray();
                    ArrayList arrayList4 = new ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String strNextName3 = jsonReader.nextName();
                            strNextName3.hashCode();
                            if (strNextName3.equals("nm")) {
                                arrayList4.add(jsonReader.nextString());
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                    }
                    jsonReader.endArray();
                    dVar.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList4);
                    continue;
                    break;
                case "ip":
                    fNextDouble = (float) jsonReader.nextDouble();
                    continue;
                    break;
                case "ks":
                    lVarA = c.a(jsonReader, dVar);
                    continue;
                    break;
                case "nm":
                    strNextString3 = jsonReader.nextString();
                    continue;
                    break;
                case "op":
                    fNextDouble2 = (float) jsonReader.nextDouble();
                    continue;
                    break;
                case "sc":
                    color = Color.parseColor(jsonReader.nextString());
                    continue;
                    break;
                case "sh":
                    iNextInt2 = (int) (jsonReader.nextInt() * com.airbnb.lottie.v.f.e());
                    continue;
                    break;
                case "sr":
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    continue;
                    break;
                case "st":
                    fNextDouble4 = (float) jsonReader.nextDouble();
                    continue;
                    break;
                case "sw":
                    iNextInt = (int) (jsonReader.nextInt() * com.airbnb.lottie.v.f.e());
                    continue;
                    break;
                case "tm":
                    bVarF = d.f(jsonReader, dVar, false);
                    continue;
                    break;
                case "tt":
                    bVar2 = com.airbnb.lottie.s.k.d.b.values()[jsonReader.nextInt()];
                    break;
                case "ty":
                    int iNextInt5 = jsonReader.nextInt();
                    aVar = com.airbnb.lottie.s.k.d.a.Unknown;
                    if (iNextInt5 < aVar.ordinal()) {
                        aVar = com.airbnb.lottie.s.k.d.a.values()[iNextInt5];
                        break;
                    }
                    break;
                case "ind":
                    jNextInt = jsonReader.nextInt();
                    break;
                case "refId":
                    strNextString = jsonReader.nextString();
                    break;
                case "masksProperties":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList2.add(u.a(jsonReader, dVar));
                    }
                    jsonReader.endArray();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        float f2 = fNextDouble / fNextDouble3;
        float f3 = fNextDouble2 / fNextDouble3;
        ArrayList arrayList5 = new ArrayList();
        if (f2 > 0.0f) {
            arrayList = arrayList5;
            arrayList.add(new com.airbnb.lottie.w.a(dVar, fValueOf2, fValueOf2, null, 0.0f, Float.valueOf(f2)));
        } else {
            arrayList = arrayList5;
        }
        if (f3 <= 0.0f) {
            f3 = dVar.f();
        }
        arrayList.add(new com.airbnb.lottie.w.a(dVar, fValueOf, fValueOf, null, f2, Float.valueOf(f3)));
        arrayList.add(new com.airbnb.lottie.w.a(dVar, fValueOf2, fValueOf2, null, f3, Float.valueOf(Float.MAX_VALUE)));
        if (strNextString3.endsWith(".ai") || "ai".equals(strNextString2)) {
            dVar.a("Convert your Illustrator layers to shape layers.");
        }
        return new com.airbnb.lottie.s.k.d(arrayList3, dVar, strNextString3, jNextInt, aVar, jNextInt2, strNextString, arrayList2, lVarA, iNextInt, iNextInt2, color, fNextDouble3, fNextDouble4, iNextInt3, iNextInt4, jVarD, kVarA, arrayList, bVar2, bVarF);
    }

    public static com.airbnb.lottie.s.k.d b(com.airbnb.lottie.d dVar) {
        Rect rectB = dVar.b();
        return new com.airbnb.lottie.s.k.d(Collections.emptyList(), dVar, "__container", -1L, com.airbnb.lottie.s.k.d.a.PreComp, -1L, null, Collections.emptyList(), new com.airbnb.lottie.s.i.l(), 0, 0, 0, 0.0f, 0.0f, rectB.width(), rectB.height(), null, null, Collections.emptyList(), com.airbnb.lottie.s.k.d.b.None, null);
    }
}
