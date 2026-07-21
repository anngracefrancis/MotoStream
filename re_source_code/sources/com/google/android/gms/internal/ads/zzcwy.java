package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcwy implements zzdti<String> {
    private final zzcwx a;

    public zzcwy(zzcwx zzcwxVar) {
        this.a = zzcwxVar;
    }

    public static String a(zzcwx zzcwxVar) {
        return (String) zzdto.b(zzcwxVar.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return a(this.a);
    }
}
