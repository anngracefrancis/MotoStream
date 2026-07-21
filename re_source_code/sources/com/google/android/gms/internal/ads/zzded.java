package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzded extends zzdob<zzded, zza> implements zzdpm {
    private static volatile zzdpv<zzded> zzdv;
    private static final zzded zzgrd;
    private int zzgqu;
    private zzdef zzgrb;

    public static final class zza extends zzdob.zza<zzded, zza> implements zzdpm {
        private zza() {
            super(zzded.zzgrd);
        }

        /* synthetic */ zza(cs csVar) {
            this();
        }
    }

    static {
        zzded zzdedVar = new zzded();
        zzgrd = zzdedVar;
        zzdob.t(zzded.class, zzdedVar);
    }

    private zzded() {
    }

    public static zzded A() {
        return zzgrd;
    }

    public static zzded y(zzdmr zzdmrVar) throws zzdok {
        return (zzded) zzdob.k(zzgrd, zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdob
    protected final Object q(int i2, Object obj, Object obj2) {
        cs csVar = null;
        switch (cs.a[i2 - 1]) {
            case 1:
                return new zzded();
            case 2:
                return new zza(csVar);
            case 3:
                return zzdob.r(zzgrd, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzgrb", "zzgqu"});
            case 4:
                return zzgrd;
            case 5:
                zzdpv<zzded> zzbVar = zzdv;
                if (zzbVar == null) {
                    synchronized (zzded.class) {
                        zzbVar = zzdv;
                        if (zzbVar == null) {
                            zzbVar = new zzdob.zzb<>(zzgrd);
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

    public final int x() {
        return this.zzgqu;
    }

    public final zzdef z() {
        zzdef zzdefVar = this.zzgrb;
        return zzdefVar == null ? zzdef.y() : zzdefVar;
    }
}
