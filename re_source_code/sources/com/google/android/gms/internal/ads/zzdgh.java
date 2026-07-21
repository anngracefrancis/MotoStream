package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdgh extends zzdob<zzdgh, zza> implements zzdpm {
    private static volatile zzdpv<zzdgh> zzdv;
    private static final zzdgh zzgtm;

    public static final class zza extends zzdob.zza<zzdgh, zza> implements zzdpm {
        private zza() {
            super(zzdgh.zzgtm);
        }

        /* synthetic */ zza(ss ssVar) {
            this();
        }
    }

    static {
        zzdgh zzdghVar = new zzdgh();
        zzgtm = zzdghVar;
        zzdob.t(zzdgh.class, zzdghVar);
    }

    private zzdgh() {
    }

    public static zzdgh y(zzdmr zzdmrVar) throws zzdok {
        return (zzdgh) zzdob.k(zzgtm, zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdob
    protected final Object q(int i2, Object obj, Object obj2) {
        ss ssVar = null;
        switch (ss.a[i2 - 1]) {
            case 1:
                return new zzdgh();
            case 2:
                return new zza(ssVar);
            case 3:
                return zzdob.r(zzgtm, "\u0000\u0000", null);
            case 4:
                return zzgtm;
            case 5:
                zzdpv<zzdgh> zzbVar = zzdv;
                if (zzbVar == null) {
                    synchronized (zzdgh.class) {
                        zzbVar = zzdv;
                        if (zzbVar == null) {
                            zzbVar = new zzdob.zzb<>(zzgtm);
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
}
