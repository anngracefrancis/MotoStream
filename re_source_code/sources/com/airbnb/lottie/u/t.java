package com.airbnb.lottie.u;

import android.graphics.Rect;
import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: LottieCompositionParser.java */
/* JADX INFO: loaded from: classes.dex */
public class t {
    public static com.airbnb.lottie.d a(JsonReader jsonReader) throws IOException {
        c.e.h<com.airbnb.lottie.s.d> hVar;
        HashMap map;
        float fE = com.airbnb.lottie.v.f.e();
        c.e.d<com.airbnb.lottie.s.k.d> dVar = new c.e.d<>();
        ArrayList arrayList = new ArrayList();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        c.e.h<com.airbnb.lottie.s.d> hVar2 = new c.e.h<>();
        com.airbnb.lottie.d dVar2 = new com.airbnb.lottie.d();
        jsonReader.beginObject();
        int iNextInt = 0;
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        int iNextInt2 = 0;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "assets":
                    hVar = hVar2;
                    map = map4;
                    b(jsonReader, dVar2, map2, map3);
                    continue;
                    map4 = map;
                    hVar2 = hVar;
                    break;
                case "layers":
                    hVar = hVar2;
                    map = map4;
                    e(jsonReader, dVar2, arrayList, dVar);
                    continue;
                    map4 = map;
                    hVar2 = hVar;
                    break;
                case "h":
                    hVar = hVar2;
                    map = map4;
                    iNextInt2 = jsonReader.nextInt();
                    continue;
                    map4 = map;
                    hVar2 = hVar;
                    break;
                case "v":
                    hVar = hVar2;
                    map = map4;
                    String[] strArrSplit = jsonReader.nextString().split("\\.");
                    if (com.airbnb.lottie.v.f.h(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        continue;
                    } else {
                        dVar2.a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    map4 = map;
                    hVar2 = hVar;
                    break;
                case "w":
                    hVar = hVar2;
                    map = map4;
                    iNextInt = jsonReader.nextInt();
                    continue;
                    map4 = map;
                    hVar2 = hVar;
                    break;
                case "fr":
                    hVar = hVar2;
                    map = map4;
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    continue;
                    map4 = map;
                    hVar2 = hVar;
                    break;
                case "ip":
                    hVar = hVar2;
                    map = map4;
                    fNextDouble = (float) jsonReader.nextDouble();
                    continue;
                    map4 = map;
                    hVar2 = hVar;
                    break;
                case "op":
                    hVar = hVar2;
                    map = map4;
                    fNextDouble2 = ((float) jsonReader.nextDouble()) - 0.01f;
                    continue;
                    map4 = map;
                    hVar2 = hVar;
                    break;
                case "chars":
                    c(jsonReader, dVar2, hVar2);
                    break;
                case "fonts":
                    d(jsonReader, map4);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
            hVar = hVar2;
            map = map4;
            map4 = map;
            hVar2 = hVar;
        }
        jsonReader.endObject();
        dVar2.n(new Rect(0, 0, (int) (iNextInt * fE), (int) (iNextInt2 * fE)), fNextDouble, fNextDouble2, fNextDouble3, arrayList, dVar, map2, map3, hVar2, map4);
        return dVar2;
    }

    private static void b(JsonReader jsonReader, com.airbnb.lottie.d dVar, Map<String, List<com.airbnb.lottie.s.k.d>> map, Map<String, com.airbnb.lottie.g> map2) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            c.e.d dVar2 = new c.e.d();
            jsonReader.beginObject();
            String strNextString = null;
            String strNextString2 = null;
            String strNextString3 = null;
            int iNextInt = 0;
            int iNextInt2 = 0;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "layers":
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            com.airbnb.lottie.s.k.d dVarA = s.a(jsonReader, dVar);
                            dVar2.k(dVarA.b(), dVarA);
                            arrayList.add(dVarA);
                        }
                        jsonReader.endArray();
                        break;
                    case "h":
                        iNextInt2 = jsonReader.nextInt();
                        break;
                    case "p":
                        strNextString2 = jsonReader.nextString();
                        break;
                    case "u":
                        strNextString3 = jsonReader.nextString();
                        break;
                    case "w":
                        iNextInt = jsonReader.nextInt();
                        break;
                    case "id":
                        strNextString = jsonReader.nextString();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            if (strNextString2 != null) {
                com.airbnb.lottie.g gVar = new com.airbnb.lottie.g(iNextInt, iNextInt2, strNextString, strNextString2, strNextString3);
                map2.put(gVar.c(), gVar);
            } else {
                map.put(strNextString, arrayList);
            }
        }
        jsonReader.endArray();
    }

    private static void c(JsonReader jsonReader, com.airbnb.lottie.d dVar, c.e.h<com.airbnb.lottie.s.d> hVar) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.airbnb.lottie.s.d dVarA = j.a(jsonReader, dVar);
            hVar.k(dVarA.hashCode(), dVarA);
        }
        jsonReader.endArray();
    }

    private static void d(JsonReader jsonReader, Map<String, com.airbnb.lottie.s.c> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("list")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.airbnb.lottie.s.c cVarA = k.a(jsonReader);
                    map.put(cVarA.b(), cVarA);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    private static void e(JsonReader jsonReader, com.airbnb.lottie.d dVar, List<com.airbnb.lottie.s.k.d> list, c.e.d<com.airbnb.lottie.s.k.d> dVar2) throws IOException {
        jsonReader.beginArray();
        int i2 = 0;
        while (jsonReader.hasNext()) {
            com.airbnb.lottie.s.k.d dVarA = s.a(jsonReader, dVar);
            if (dVarA.d() == com.airbnb.lottie.s.k.d.a.Image) {
                i2++;
            }
            list.add(dVarA);
            dVar2.k(dVarA.b(), dVarA);
            if (i2 > 4) {
                com.airbnb.lottie.c.d("You have " + i2 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.endArray();
    }
}
