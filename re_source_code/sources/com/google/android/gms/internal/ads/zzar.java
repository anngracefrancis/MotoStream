package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzar {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<zzl> f14084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f14085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final InputStream f14086d;

    public zzar(int i2, List<zzl> list) {
        this(i2, list, -1, null);
    }

    public final InputStream a() {
        return this.f14086d;
    }

    public final int b() {
        return this.f14085c;
    }

    public final int c() {
        return this.a;
    }

    public final List<zzl> d() {
        return Collections.unmodifiableList(this.f14084b);
    }

    public zzar(int i2, List<zzl> list, int i3, InputStream inputStream) {
        this.a = i2;
        this.f14084b = list;
        this.f14085c = i3;
        this.f14086d = inputStream;
    }
}
