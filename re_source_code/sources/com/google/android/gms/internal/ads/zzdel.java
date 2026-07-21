package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdel extends zzdob<zzdel, zza> implements zzdpm {
    private static volatile zzdpv<zzdel> zzdv;
    private static final zzdel zzgrj;
    private int zzgre;

    public static final class zza extends zzdob.zza<zzdel, zza> implements zzdpm {
        private zza() {
            super(zzdel.zzgrj);
        }

        /* synthetic */ zza(gs gsVar) {
            this();
        }
    }

    static {
        zzdel zzdelVar = new zzdel();
        zzgrj = zzdelVar;
        zzdob.t(zzdel.class, zzdelVar);
    }

    private zzdel() {
    }

    public static zzdel y() {
        return zzgrj;
    }

    @Override // com.google.android.gms.internal.ads.zzdob
    protected final Object q(int i2, Object obj, Object obj2) {
        gs gsVar = null;
        switch (gs.a[i2 - 1]) {
            case 1:
                return new zzdel();
            case 2:
                return new zza(gsVar);
            case 3:
                return zzdob.r(zzgrj, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzgre"});
            case 4:
                return zzgrj;
            case 5:
                zzdpv<zzdel> zzbVar = zzdv;
                if (zzbVar == null) {
                    synchronized (zzdel.class) {
                        zzbVar = zzdv;
                        if (zzbVar == null) {
                            zzbVar = new zzdob.zzb<>(zzgrj);
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
        return this.zzgre;
    }
}
