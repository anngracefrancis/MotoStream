package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes2.dex */
final class kg implements zzbam<zzp, Bitmap> {
    private final /* synthetic */ double a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ boolean f12878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzcan f12879c;

    kg(zzcan zzcanVar, double d2, boolean z) {
        this.f12879c = zzcanVar;
        this.a = d2;
        this.f12878b = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    public final /* synthetic */ Bitmap a(zzp zzpVar) {
        return this.f12879c.b(zzpVar.f16552b, this.a, this.f12878b);
    }
}
