package com.airbnb.lottie.u;

import android.util.JsonReader;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: compiled from: ContentModelParser.java */
/* JADX INFO: loaded from: classes.dex */
class g {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x003d  */
    static com.airbnb.lottie.s.j.b a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        com.airbnb.lottie.s.j.b bVarA;
        String strNextString;
        jsonReader.beginObject();
        byte b2 = 2;
        int iNextInt = 2;
        while (true) {
            bVarA = null;
            if (!jsonReader.hasNext()) {
                strNextString = null;
                break;
            }
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (!strNextName.equals("d")) {
                if (strNextName.equals("ty")) {
                    strNextString = jsonReader.nextString();
                    break;
                }
                jsonReader.skipValue();
            } else {
                iNextInt = jsonReader.nextInt();
            }
        }
        if (strNextString == null) {
            return null;
        }
        switch (strNextString.hashCode()) {
            case 3239:
                if (!strNextString.equals("el")) {
                    b2 = -1;
                } else {
                    b2 = 0;
                }
                break;
            case 3270:
                if (!strNextString.equals("fl")) {
                    b2 = -1;
                } else {
                    b2 = 1;
                }
                break;
            case 3295:
                if (!strNextString.equals("gf")) {
                    b2 = -1;
                }
                break;
            case 3307:
                if (!strNextString.equals("gr")) {
                    b2 = -1;
                } else {
                    b2 = 3;
                }
                break;
            case 3308:
                if (!strNextString.equals("gs")) {
                    b2 = -1;
                } else {
                    b2 = 4;
                }
                break;
            case 3488:
                if (!strNextString.equals("mm")) {
                    b2 = -1;
                } else {
                    b2 = 5;
                }
                break;
            case 3633:
                if (!strNextString.equals("rc")) {
                    b2 = -1;
                } else {
                    b2 = 6;
                }
                break;
            case 3646:
                if (!strNextString.equals("rp")) {
                    b2 = -1;
                } else {
                    b2 = 7;
                }
                break;
            case 3669:
                if (!strNextString.equals("sh")) {
                    b2 = -1;
                } else {
                    b2 = 8;
                }
                break;
            case 3679:
                if (!strNextString.equals("sr")) {
                    b2 = -1;
                } else {
                    b2 = 9;
                }
                break;
            case 3681:
                if (!strNextString.equals("st")) {
                    b2 = -1;
                } else {
                    b2 = 10;
                }
                break;
            case 3705:
                if (!strNextString.equals("tm")) {
                    b2 = -1;
                } else {
                    b2 = 11;
                }
                break;
            case 3710:
                if (!strNextString.equals("tr")) {
                    b2 = -1;
                } else {
                    b2 = 12;
                }
                break;
            default:
                b2 = -1;
                break;
        }
        switch (b2) {
            case 0:
                bVarA = e.a(jsonReader, dVar, iNextInt);
                break;
            case 1:
                bVarA = e0.a(jsonReader, dVar);
                break;
            case 2:
                bVarA = m.a(jsonReader, dVar);
                break;
            case 3:
                bVarA = f0.a(jsonReader, dVar);
                break;
            case 4:
                bVarA = n.a(jsonReader, dVar);
                break;
            case 5:
                bVarA = v.a(jsonReader);
                dVar.a("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case 6:
                bVarA = a0.a(jsonReader, dVar);
                break;
            case 7:
                bVarA = b0.a(jsonReader, dVar);
                break;
            case 8:
                bVarA = g0.a(jsonReader, dVar);
                break;
            case 9:
                bVarA = z.a(jsonReader, dVar);
                break;
            case 10:
                bVarA = h0.a(jsonReader, dVar);
                break;
            case 11:
                bVarA = i0.a(jsonReader, dVar);
                break;
            case 12:
                bVarA = c.a(jsonReader, dVar);
                break;
            default:
                Log.w("LOTTIE", "Unknown shape type " + strNextString);
                break;
        }
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        return bVarA;
    }
}
