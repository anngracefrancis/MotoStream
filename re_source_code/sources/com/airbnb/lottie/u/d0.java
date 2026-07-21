package com.airbnb.lottie.u;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: ShapeDataParser.java */
/* JADX INFO: loaded from: classes.dex */
public class d0 implements j0<com.airbnb.lottie.s.j.l> {
    public static final d0 a = new d0();

    private d0() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:10:0x0029  */
    @Override // com.airbnb.lottie.u.j0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.airbnb.lottie.s.j.l a(JsonReader jsonReader, float f2) throws IOException {
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List<PointF> listF = null;
        List<PointF> listF2 = null;
        List<PointF> listF3 = null;
        boolean zNextBoolean = false;
        while (true) {
            if (!jsonReader.hasNext()) {
                jsonReader.endObject();
                if (jsonReader.peek() == JsonToken.END_ARRAY) {
                    jsonReader.endArray();
                }
                if (listF == null || listF2 == null || listF3 == null) {
                    throw new IllegalArgumentException("Shape data was missing information.");
                }
                if (listF.isEmpty()) {
                    return new com.airbnb.lottie.s.j.l(new PointF(), false, Collections.emptyList());
                }
                int size = listF.size();
                PointF pointF = listF.get(0);
                ArrayList arrayList = new ArrayList(size);
                for (int i2 = 1; i2 < size; i2++) {
                    PointF pointF2 = listF.get(i2);
                    int i3 = i2 - 1;
                    arrayList.add(new com.airbnb.lottie.s.a(com.airbnb.lottie.v.e.a(listF.get(i3), listF3.get(i3)), com.airbnb.lottie.v.e.a(pointF2, listF2.get(i2)), pointF2));
                }
                if (zNextBoolean) {
                    PointF pointF3 = listF.get(0);
                    int i4 = size - 1;
                    arrayList.add(new com.airbnb.lottie.s.a(com.airbnb.lottie.v.e.a(listF.get(i4), listF3.get(i4)), com.airbnb.lottie.v.e.a(pointF3, listF2.get(0)), pointF3));
                }
                return new com.airbnb.lottie.s.j.l(pointF, zNextBoolean, arrayList);
            }
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "c":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "i":
                    listF2 = p.f(jsonReader, f2);
                    break;
                case "o":
                    listF3 = p.f(jsonReader, f2);
                    break;
                case "v":
                    listF = p.f(jsonReader, f2);
                    break;
            }
        }
    }
}
