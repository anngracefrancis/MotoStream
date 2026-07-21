package com.airbnb.lottie.u;

import android.util.JsonReader;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: compiled from: MaskParser.java */
/* JADX INFO: loaded from: classes.dex */
class u {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:24:0x0055  */
    /* JADX WARN: Code duplicated, block: B:7:0x001e  */
    static com.airbnb.lottie.s.j.g a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        jsonReader.beginObject();
        com.airbnb.lottie.s.j.g.a aVar = null;
        com.airbnb.lottie.s.i.h hVarK = null;
        com.airbnb.lottie.s.i.d dVarH = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "o":
                    dVarH = d.h(jsonReader, dVar);
                    break;
                case "pt":
                    hVarK = d.k(jsonReader, dVar);
                    break;
                case "mode":
                    String strNextString = jsonReader.nextString();
                    strNextString.hashCode();
                    switch (strNextString) {
                        case "a":
                            aVar = com.airbnb.lottie.s.j.g.a.MaskModeAdd;
                            break;
                        case "i":
                            dVar.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            aVar = com.airbnb.lottie.s.j.g.a.MaskModeIntersect;
                            break;
                        case "s":
                            aVar = com.airbnb.lottie.s.j.g.a.MaskModeSubtract;
                            break;
                        default:
                            Log.w("LOTTIE", "Unknown mask mode " + strNextName + ". Defaulting to Add.");
                            aVar = com.airbnb.lottie.s.j.g.a.MaskModeAdd;
                            break;
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.airbnb.lottie.s.j.g(aVar, hVarK, dVarH);
    }
}
