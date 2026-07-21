package com.airbnb.lottie.u;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: DocumentDataParser.java */
/* JADX INFO: loaded from: classes.dex */
public class h implements j0<com.airbnb.lottie.s.b> {
    public static final h a = new h();

    private h() {
    }

    @Override // com.airbnb.lottie.u.j0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.airbnb.lottie.s.b a(JsonReader jsonReader, float f2) throws IOException {
        jsonReader.beginObject();
        String strNextString = null;
        String strNextString2 = null;
        double dNextDouble = 0.0d;
        double dNextDouble2 = 0.0d;
        double dNextDouble3 = 0.0d;
        double dNextDouble4 = 0.0d;
        int iNextInt = 0;
        int iNextInt2 = 0;
        int iD = 0;
        int iD2 = 0;
        boolean zNextBoolean = true;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "f":
                    strNextString2 = jsonReader.nextString();
                    break;
                case "j":
                    iNextInt = jsonReader.nextInt();
                    break;
                case "s":
                    dNextDouble = jsonReader.nextDouble();
                    break;
                case "t":
                    strNextString = jsonReader.nextString();
                    break;
                case "fc":
                    iD = p.d(jsonReader);
                    break;
                case "lh":
                    dNextDouble2 = jsonReader.nextDouble();
                    break;
                case "ls":
                    dNextDouble3 = jsonReader.nextDouble();
                    break;
                case "of":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "sc":
                    iD2 = p.d(jsonReader);
                    break;
                case "sw":
                    dNextDouble4 = jsonReader.nextDouble();
                    break;
                case "tr":
                    iNextInt2 = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.airbnb.lottie.s.b(strNextString, strNextString2, dNextDouble, iNextInt, iNextInt2, dNextDouble2, dNextDouble3, iD, iD2, dNextDouble4, zNextBoolean);
    }
}
