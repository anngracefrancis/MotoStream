package com.airbnb.lottie.u;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: compiled from: AnimatableTransformParser.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static com.airbnb.lottie.s.i.l a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_OBJECT;
        if (z) {
            jsonReader.beginObject();
        }
        com.airbnb.lottie.s.i.e eVar = null;
        com.airbnb.lottie.s.i.g gVar = null;
        com.airbnb.lottie.s.i.d dVar2 = null;
        com.airbnb.lottie.s.i.m<PointF, PointF> mVarB = null;
        com.airbnb.lottie.s.i.b bVarF = null;
        com.airbnb.lottie.s.i.b bVarF2 = null;
        com.airbnb.lottie.s.i.b bVarF3 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "a":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if (jsonReader.nextName().equals("k")) {
                            eVar = a.a(jsonReader, dVar);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    continue;
                    break;
                case "o":
                    dVar2 = d.h(jsonReader, dVar);
                    continue;
                    break;
                case "p":
                    mVarB = a.b(jsonReader, dVar);
                    continue;
                    break;
                case "r":
                    break;
                case "s":
                    gVar = d.j(jsonReader, dVar);
                    continue;
                    break;
                case "eo":
                    bVarF3 = d.f(jsonReader, dVar, false);
                    continue;
                    break;
                case "rz":
                    dVar.a("Lottie doesn't support 3D layers.");
                    break;
                case "so":
                    bVarF2 = d.f(jsonReader, dVar, false);
                    continue;
                    break;
                default:
                    jsonReader.skipValue();
                    continue;
                    break;
            }
            bVarF = d.f(jsonReader, dVar, false);
        }
        if (z) {
            jsonReader.endObject();
        }
        if (eVar == null) {
            Log.w("LOTTIE", "Layer has no transform property. You may be using an unsupported layer type such as a camera.");
            eVar = new com.airbnb.lottie.s.i.e();
        }
        com.airbnb.lottie.s.i.e eVar2 = eVar;
        if (gVar == null) {
            gVar = new com.airbnb.lottie.s.i.g(new com.airbnb.lottie.w.d(1.0f, 1.0f));
        }
        com.airbnb.lottie.s.i.g gVar2 = gVar;
        if (dVar2 == null) {
            dVar2 = new com.airbnb.lottie.s.i.d();
        }
        return new com.airbnb.lottie.s.i.l(eVar2, mVarB, gVar2, bVarF, dVar2, bVarF2, bVarF3);
    }
}
