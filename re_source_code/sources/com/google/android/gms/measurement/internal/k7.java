package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class k7 implements j3 {
    private final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzkc f17847b;

    k7(zzkc zzkcVar, String str) {
        this.f17847b = zzkcVar;
        this.a = str;
    }

    @Override // com.google.android.gms.measurement.internal.j3
    public final void a(String str, int i2, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.f17847b.k(i2, th, bArr, this.a);
    }
}
