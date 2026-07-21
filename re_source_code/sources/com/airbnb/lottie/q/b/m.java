package com.airbnb.lottie.q.b;

import android.graphics.PointF;
import java.util.Collections;

/* JADX INFO: compiled from: SplitDimensionPathKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class m extends a<PointF, PointF> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final PointF f8666g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final a<Float, Float> f8667h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final a<Float, Float> f8668i;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.f8666g = new PointF();
        this.f8667h = aVar;
        this.f8668i = aVar2;
        l(f());
    }

    @Override // com.airbnb.lottie.q.b.a
    public void l(float f2) {
        this.f8667h.l(f2);
        this.f8668i.l(f2);
        this.f8666g.set(this.f8667h.h().floatValue(), this.f8668i.h().floatValue());
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            this.a.get(i2).a();
        }
    }

    @Override // com.airbnb.lottie.q.b.a
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public PointF h() {
        return i(null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.q.b.a
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public PointF i(com.airbnb.lottie.w.a<PointF> aVar, float f2) {
        return this.f8666g;
    }
}
