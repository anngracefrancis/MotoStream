package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcxn {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f15735c;

    public zzcxn(int i2, int i3, boolean z) {
        this.a = i2;
        this.f15734b = i3;
        this.f15735c = z;
    }

    static List<zzcxn> a(JsonReader jsonReader) throws IllegalStateException, IOException, NumberFormatException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            int iNextInt = 0;
            int iNextInt2 = 0;
            boolean zNextBoolean = false;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if ("width".equals(strNextName)) {
                    iNextInt = jsonReader.nextInt();
                } else if ("height".equals(strNextName)) {
                    iNextInt2 = jsonReader.nextInt();
                } else if ("is_fluid_height".equals(strNextName)) {
                    zNextBoolean = jsonReader.nextBoolean();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            arrayList.add(new zzcxn(iNextInt, iNextInt2, zNextBoolean));
        }
        jsonReader.endArray();
        return arrayList;
    }
}
