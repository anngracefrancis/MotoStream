package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdfp extends zzdob<zzdfp, zza> implements zzdpm {
    private static volatile zzdpv<zzdfp> zzdv;
    private static final zzdfp zzgsq;
    private zzdgw zzgsp;

    public static final class zza extends zzdob.zza<zzdfp, zza> implements zzdpm {
        private zza() {
            super(zzdfp.zzgsq);
        }

        /* synthetic */ zza(ls lsVar) {
            this();
        }
    }

    static {
        zzdfp zzdfpVar = new zzdfp();
        zzgsq = zzdfpVar;
        zzdob.t(zzdfp.class, zzdfpVar);
    }

    private zzdfp() {
    }

    public static zzdfp y() {
        return zzgsq;
    }

    @Override // com.google.android.gms.internal.ads.zzdob
    protected final Object q(int i2, Object obj, Object obj2) {
        ls lsVar = null;
        switch (ls.a[i2 - 1]) {
            case 1:
                return new zzdfp();
            case 2:
                return new zza(lsVar);
            case 3:
                return zzdob.r(zzgsq, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"zzgsp"});
            case 4:
                return zzgsq;
            case 5:
                zzdpv<zzdfp> zzbVar = zzdv;
                if (zzbVar == null) {
                    synchronized (zzdfp.class) {
                        zzbVar = zzdv;
                        if (zzbVar == null) {
                            zzbVar = new zzdob.zzb<>(zzgsq);
                            zzdv = zzbVar;
                        }
                        break;
                    }
                }
                return zzbVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final zzdgw x() {
        zzdgw zzdgwVar = this.zzgsp;
        return zzdgwVar == null ? zzdgw.z() : zzdgwVar;
    }
}
