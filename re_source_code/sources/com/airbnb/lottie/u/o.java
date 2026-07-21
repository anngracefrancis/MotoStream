package com.airbnb.lottie.u;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: IntegerParser.java */
/* JADX INFO: loaded from: classes.dex */
public class o implements j0<Integer> {
    public static final o a = new o();

    private o() {
    }

    @Override // com.airbnb.lottie.u.j0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(JsonReader jsonReader, float f2) throws IOException {
        return Integer.valueOf(Math.round(p.g(jsonReader) * f2));
    }
}
