package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbnr implements zzdti<zzbnf> {
    private final zzbnk a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<yc> f14594b;

    public zzbnr(zzbnk zzbnkVar, zzdtu<yc> zzdtuVar) {
        this.a = zzbnkVar;
        this.f14594b = zzdtuVar;
    }

    public static zzbnf a(zzbnk zzbnkVar, Object obj) {
        return (zzbnf) zzdto.b((yc) obj, "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return a(this.a, this.f14594b.get());
    }
}
