package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class h2 implements zzbbt {
    private final /* synthetic */ zzbbr a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzakw f12681b;

    h2(zzalu zzaluVar, zzbbr zzbbrVar, zzakw zzakwVar) {
        this.a = zzbbrVar;
        this.f12681b = zzakwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbt
    public final void run() {
        this.a.c(new zzali("Unable to obtain a JavascriptEngine."));
        this.f12681b.f();
    }
}
