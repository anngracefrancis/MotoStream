package com.airbnb.lottie.u;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: compiled from: ColorParser.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements j0<Integer> {
    public static final f a = new f();

    private f() {
    }

    @Override // com.airbnb.lottie.u.j0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(JsonReader jsonReader, float f2) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        double dNextDouble = jsonReader.nextDouble();
        double dNextDouble2 = jsonReader.nextDouble();
        double dNextDouble3 = jsonReader.nextDouble();
        double dNextDouble4 = jsonReader.nextDouble();
        if (z) {
            jsonReader.endArray();
        }
        if (dNextDouble <= 1.0d && dNextDouble2 <= 1.0d && dNextDouble3 <= 1.0d && dNextDouble4 <= 1.0d) {
            dNextDouble *= 255.0d;
            dNextDouble2 *= 255.0d;
            dNextDouble3 *= 255.0d;
            dNextDouble4 *= 255.0d;
        }
        return Integer.valueOf(Color.argb((int) dNextDouble4, (int) dNextDouble, (int) dNextDouble2, (int) dNextDouble3));
    }
}
