package com.airbnb.lottie.s.i;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: AnimatablePathValue.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements m<PointF, PointF> {
    private final List<com.airbnb.lottie.w.a<PointF>> a;

    public e() {
        this.a = Collections.singletonList(new com.airbnb.lottie.w.a(new PointF(0.0f, 0.0f)));
    }

    @Override // com.airbnb.lottie.s.i.m
    public com.airbnb.lottie.q.b.a<PointF, PointF> a() {
        return this.a.get(0).d() ? new com.airbnb.lottie.q.b.j(this.a) : new com.airbnb.lottie.q.b.i(this.a);
    }

    public e(List<com.airbnb.lottie.w.a<PointF>> list) {
        this.a = list;
    }
}
