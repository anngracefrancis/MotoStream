package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbok implements zzdti<Boolean> {
    private final zzdtu<zzcxv> a;

    public zzbok(zzdtu<zzcxv> zzdtuVar) {
        this.a = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        boolean zBooleanValue;
        if (this.a.get().a() != null) {
            zBooleanValue = ((Boolean) zzyt.e().c(zzacu.t1)).booleanValue();
        } else {
            zBooleanValue = ((Boolean) zzyt.e().c(zzacu.x4)).booleanValue();
        }
        return Boolean.valueOf(zBooleanValue);
    }
}
