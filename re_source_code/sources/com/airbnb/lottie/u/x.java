package com.airbnb.lottie.u;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: PathParser.java */
/* JADX INFO: loaded from: classes.dex */
public class x implements j0<PointF> {
    public static final x a = new x();

    private x() {
    }

    @Override // com.airbnb.lottie.u.j0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PointF a(JsonReader jsonReader, float f2) throws IOException {
        return p.e(jsonReader, f2);
    }
}
