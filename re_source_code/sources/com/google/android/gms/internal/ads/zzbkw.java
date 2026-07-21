package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public class zzbkw {
    private zza a;

    public static abstract class zza {
        public abstract zzbgd a();

        public abstract zzbcp b();

        public abstract zzwo c();

        public abstract zzavd d();
    }

    public zzbkw(zza zzaVar) {
        this.a = zzaVar;
    }

    public final zzavd a() {
        return this.a.d();
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.android.gms.internal.ads.zzauw, com.google.android.gms.internal.ads.zzavc] */
    public final com.google.android.gms.ads.internal.zza b() {
        zza zzaVar = this.a;
        return new com.google.android.gms.ads.internal.zza(zzaVar.a(), zzaVar.b(), new zzauw(zzaVar.d()), zzaVar.c());
    }
}
