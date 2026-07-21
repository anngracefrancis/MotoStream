package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcxb implements zzdti<String> {
    private final zzcwx a;

    public zzcxb(zzcwx zzcwxVar) {
        this.a = zzcwxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (String) zzdto.b(this.a.g(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
