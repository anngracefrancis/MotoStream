package com.airbnb.lottie.u;

import android.graphics.Color;
import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: JsonUtils.java */
/* JADX INFO: loaded from: classes.dex */
class p {

    /* JADX INFO: compiled from: JsonUtils.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            a = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JsonToken.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JsonToken.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static PointF a(JsonReader jsonReader, float f2) throws IOException {
        jsonReader.beginArray();
        float fNextDouble = (float) jsonReader.nextDouble();
        float fNextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.peek() != JsonToken.END_ARRAY) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return new PointF(fNextDouble * f2, fNextDouble2 * f2);
    }

    private static PointF b(JsonReader jsonReader, float f2) throws IOException {
        float fNextDouble = (float) jsonReader.nextDouble();
        float fNextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        return new PointF(fNextDouble * f2, fNextDouble2 * f2);
    }

    private static PointF c(JsonReader jsonReader, float f2) throws IOException {
        jsonReader.beginObject();
        float fG = 0.0f;
        float fG2 = 0.0f;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("x")) {
                fG = g(jsonReader);
            } else if (strNextName.equals("y")) {
                fG2 = g(jsonReader);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return new PointF(fG * f2, fG2 * f2);
    }

    static int d(JsonReader jsonReader) throws IOException {
        jsonReader.beginArray();
        int iNextDouble = (int) (jsonReader.nextDouble() * 255.0d);
        int iNextDouble2 = (int) (jsonReader.nextDouble() * 255.0d);
        int iNextDouble3 = (int) (jsonReader.nextDouble() * 255.0d);
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return Color.argb(255, iNextDouble, iNextDouble2, iNextDouble3);
    }

    static PointF e(JsonReader jsonReader, float f2) throws IOException {
        int i2 = a.a[jsonReader.peek().ordinal()];
        if (i2 == 1) {
            return b(jsonReader, f2);
        }
        if (i2 == 2) {
            return a(jsonReader, f2);
        }
        if (i2 == 3) {
            return c(jsonReader, f2);
        }
        throw new IllegalArgumentException("Unknown point starts with " + jsonReader.peek());
    }

    static List<PointF> f(JsonReader jsonReader, float f2) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            arrayList.add(e(jsonReader, f2));
            jsonReader.endArray();
        }
        jsonReader.endArray();
        return arrayList;
    }

    static float g(JsonReader jsonReader) throws IOException {
        JsonToken jsonTokenPeek = jsonReader.peek();
        int i2 = a.a[jsonTokenPeek.ordinal()];
        if (i2 == 1) {
            return (float) jsonReader.nextDouble();
        }
        if (i2 != 2) {
            throw new IllegalArgumentException("Unknown value for token of type " + jsonTokenPeek);
        }
        jsonReader.beginArray();
        float fNextDouble = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return fNextDouble;
    }
}
