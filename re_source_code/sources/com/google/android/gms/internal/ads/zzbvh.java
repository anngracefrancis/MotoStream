package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbvh implements zzbvg {
    private final List<String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdae f14750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14751c;

    public zzbvh(zzcxm zzcxmVar, zzdae zzdaeVar) {
        this.a = zzcxmVar.n;
        this.f14750b = zzdaeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbvg
    public final void a() {
        if (this.f14751c) {
            return;
        }
        this.f14750b.h(this.a);
        this.f14751c = true;
    }
}
