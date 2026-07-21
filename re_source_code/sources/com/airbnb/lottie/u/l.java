package com.airbnb.lottie.u;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: GradientColorParser.java */
/* JADX INFO: loaded from: classes.dex */
public class l implements j0<com.airbnb.lottie.s.j.c> {
    private int a;

    public l(int i2) {
        this.a = i2;
    }

    private void b(com.airbnb.lottie.s.j.c cVar, List<Float> list) {
        int i2 = this.a * 4;
        if (list.size() <= i2) {
            return;
        }
        int size = (list.size() - i2) / 2;
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        int i3 = 0;
        while (i2 < list.size()) {
            if (i2 % 2 == 0) {
                dArr[i3] = list.get(i2).floatValue();
            } else {
                dArr2[i3] = list.get(i2).floatValue();
                i3++;
            }
            i2++;
        }
        for (int i4 = 0; i4 < cVar.c(); i4++) {
            int i5 = cVar.a()[i4];
            cVar.a()[i4] = Color.argb(c(cVar.b()[i4], dArr, dArr2), Color.red(i5), Color.green(i5), Color.blue(i5));
        }
    }

    private int c(double d2, double[] dArr, double[] dArr2) {
        double dI;
        for (int i2 = 1; i2 < dArr.length; i2++) {
            int i3 = i2 - 1;
            double d3 = dArr[i3];
            double d4 = dArr[i2];
            if (dArr[i2] >= d2) {
                dI = com.airbnb.lottie.v.e.i(dArr2[i3], dArr2[i2], (d2 - d3) / (d4 - d3));
                return (int) (dI * 255.0d);
            }
        }
        dI = dArr2[dArr2.length - 1];
        return (int) (dI * 255.0d);
    }

    @Override // com.airbnb.lottie.u.j0
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public com.airbnb.lottie.s.j.c a(JsonReader jsonReader, float f2) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        while (jsonReader.hasNext()) {
            arrayList.add(Float.valueOf((float) jsonReader.nextDouble()));
        }
        if (z) {
            jsonReader.endArray();
        }
        if (this.a == -1) {
            this.a = arrayList.size() / 4;
        }
        int i2 = this.a;
        float[] fArr = new float[i2];
        int[] iArr = new int[i2];
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < this.a * 4; i5++) {
            int i6 = i5 / 4;
            double dFloatValue = arrayList.get(i5).floatValue();
            int i7 = i5 % 4;
            if (i7 == 0) {
                fArr[i6] = (float) dFloatValue;
            } else if (i7 == 1) {
                Double.isNaN(dFloatValue);
                i3 = (int) (dFloatValue * 255.0d);
            } else if (i7 == 2) {
                Double.isNaN(dFloatValue);
                i4 = (int) (dFloatValue * 255.0d);
            } else if (i7 == 3) {
                Double.isNaN(dFloatValue);
                iArr[i6] = Color.argb(255, i3, i4, (int) (dFloatValue * 255.0d));
            }
        }
        com.airbnb.lottie.s.j.c cVar = new com.airbnb.lottie.s.j.c(fArr, iArr);
        b(cVar, arrayList);
        return cVar;
    }
}
