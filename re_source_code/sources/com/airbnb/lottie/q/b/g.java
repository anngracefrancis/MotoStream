package com.airbnb.lottie.q.b;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: MaskKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    private final List<a<com.airbnb.lottie.s.j.l, Path>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<a<Integer, Integer>> f8656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<com.airbnb.lottie.s.j.g> f8657c;

    public g(List<com.airbnb.lottie.s.j.g> list) {
        this.f8657c = list;
        this.a = new ArrayList(list.size());
        this.f8656b = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.a.add(list.get(i2).b().a());
            this.f8656b.add(list.get(i2).c().a());
        }
    }

    public List<a<com.airbnb.lottie.s.j.l, Path>> a() {
        return this.a;
    }

    public List<com.airbnb.lottie.s.j.g> b() {
        return this.f8657c;
    }

    public List<a<Integer, Integer>> c() {
        return this.f8656b;
    }
}
