package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcqw implements zzdti<String> {
    private final zzcqt a;

    public zzcqw(zzcqt zzcqtVar) {
        this.a = zzcqtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (String) zzdto.b(this.a.b(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
