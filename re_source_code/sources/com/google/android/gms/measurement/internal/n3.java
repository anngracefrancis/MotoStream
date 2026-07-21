package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class n3 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final j3 f17876f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f17877g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Throwable f17878h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final byte[] f17879i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f17880j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Map<String, List<String>> f17881k;

    private n3(String str, j3 j3Var, int i2, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        Preconditions.k(j3Var);
        this.f17876f = j3Var;
        this.f17877g = i2;
        this.f17878h = th;
        this.f17879i = bArr;
        this.f17880j = str;
        this.f17881k = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17876f.a(this.f17880j, this.f17877g, this.f17878h, this.f17879i, this.f17881k);
    }
}
