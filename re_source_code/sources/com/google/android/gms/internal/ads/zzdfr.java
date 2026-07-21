package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdfr extends zzdob<zzdfr, zza> implements zzdpm {
    private static volatile zzdpv<zzdfr> zzdv;
    private static final zzdfr zzgss;
    private zzdft zzgsr;

    public static final class zza extends zzdob.zza<zzdfr, zza> implements zzdpm {
        private zza() {
            super(zzdfr.zzgss);
        }

        /* synthetic */ zza(ms msVar) {
            this();
        }
    }

    static {
        zzdfr zzdfrVar = new zzdfr();
        zzgss = zzdfrVar;
        zzdob.t(zzdfr.class, zzdfrVar);
    }

    private zzdfr() {
    }

    public static zzdfr z(zzdmr zzdmrVar) throws zzdok {
        return (zzdfr) zzdob.k(zzgss, zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdob
    protected final Object q(int i2, Object obj, Object obj2) {
        ms msVar = null;
        switch (ms.a[i2 - 1]) {
            case 1:
                return new zzdfr();
            case 2:
                return new zza(msVar);
            case 3:
                return zzdob.r(zzgss, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zzgsr"});
            case 4:
                return zzgss;
            case 5:
                zzdpv<zzdfr> zzbVar = zzdv;
                if (zzbVar == null) {
                    synchronized (zzdfr.class) {
                        zzbVar = zzdv;
                        if (zzbVar == null) {
                            zzbVar = new zzdob.zzb<>(zzgss);
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

    public final zzdft x() {
        zzdft zzdftVar = this.zzgsr;
        return zzdftVar == null ? zzdft.A() : zzdftVar;
    }
}
