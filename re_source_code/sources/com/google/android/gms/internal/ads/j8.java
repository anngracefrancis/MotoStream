package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
final class j8 implements zzgh {
    private WeakReference<zzgh> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzbdk f12814b;

    private j8(zzbdk zzbdkVar) {
        this.f12814b = zzbdkVar;
        this.a = new WeakReference<>(null);
    }

    @Override // com.google.android.gms.internal.ads.zzgh
    public final void a(boolean z, int i2) {
        zzgh zzghVar = this.a.get();
        if (zzghVar != null) {
            zzghVar.a(z, i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgh
    public final void b(zzgd zzgdVar) {
        this.f12814b.f("PlayerError", zzgdVar.getMessage());
        zzgh zzghVar = this.a.get();
        if (zzghVar != null) {
            zzghVar.b(zzgdVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgh
    public final void c() {
        zzgh zzghVar = this.a.get();
        if (zzghVar != null) {
            zzghVar.c();
        }
    }

    public final void d(zzgh zzghVar) {
        this.a = new WeakReference<>(zzghVar);
    }
}
