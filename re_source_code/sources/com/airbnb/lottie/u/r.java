package com.airbnb.lottie.u;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: KeyframesParser.java */
/* JADX INFO: loaded from: classes.dex */
class r {
    static <T> List<com.airbnb.lottie.w.a<T>> a(JsonReader jsonReader, com.airbnb.lottie.d dVar, float f2, j0<T> j0Var) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            dVar.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (!strNextName.equals("k")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                if (jsonReader.peek() == JsonToken.NUMBER) {
                    arrayList.add(q.b(jsonReader, dVar, f2, j0Var, false));
                } else {
                    while (jsonReader.hasNext()) {
                        arrayList.add(q.b(jsonReader, dVar, f2, j0Var, true));
                    }
                }
                jsonReader.endArray();
            } else {
                arrayList.add(q.b(jsonReader, dVar, f2, j0Var, false));
            }
        }
        jsonReader.endObject();
        b(arrayList);
        return arrayList;
    }

    public static void b(List<? extends com.airbnb.lottie.w.a<?>> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        while (true) {
            i2 = size - 1;
            if (i3 >= i2) {
                break;
            }
            com.airbnb.lottie.w.a<?> aVar = list.get(i3);
            i3++;
            aVar.f8866f = Float.valueOf(list.get(i3).f8865e);
        }
        com.airbnb.lottie.w.a<?> aVar2 = list.get(i2);
        if (aVar2.f8862b == 0) {
            list.remove(aVar2);
        }
    }
}
