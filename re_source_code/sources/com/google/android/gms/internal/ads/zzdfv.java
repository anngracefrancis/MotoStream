package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdfv extends zzdob<zzdfv, zza> implements zzdpm {
    private static volatile zzdpv<zzdfv> zzdv;
    private static final zzdfv zzgsy;
    private int zzgqk;
    private zzdmr zzgqs = zzdmr.f15982f;
    private zzdfx zzgsx;

    public static final class zza extends zzdob.zza<zzdfv, zza> implements zzdpm {
        private zza() {
            super(zzdfv.zzgsy);
        }

        public final zza u(zzdfx zzdfxVar) {
            p();
            ((zzdfv) this.f16019g).C(zzdfxVar);
            return this;
        }

        public final zza v(zzdmr zzdmrVar) {
            p();
            ((zzdfv) this.f16019g).I(zzdmrVar);
            return this;
        }

        public final zza w(int i2) {
            p();
            ((zzdfv) this.f16019g).y(0);
            return this;
        }

        /* synthetic */ zza(os osVar) {
            this();
        }
    }

    static {
        zzdfv zzdfvVar = new zzdfv();
        zzgsy = zzdfvVar;
        zzdob.t(zzdfv.class, zzdfvVar);
    }

    private zzdfv() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(zzdfx zzdfxVar) {
        zzdfxVar.getClass();
        this.zzgsx = zzdfxVar;
    }

    public static zza F() {
        return (zza) ((zzdob.zza) zzgsy.q(zzdob.zze.f16025e, null, null));
    }

    public static zzdfv H(zzdmr zzdmrVar) throws zzdok {
        return (zzdfv) zzdob.k(zzgsy, zzdmrVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(zzdmr zzdmrVar) {
        zzdmrVar.getClass();
        this.zzgqs = zzdmrVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(int i2) {
        this.zzgqk = i2;
    }

    public final zzdmr D() {
        return this.zzgqs;
    }

    public final zzdfx E() {
        zzdfx zzdfxVar = this.zzgsx;
        return zzdfxVar == null ? zzdfx.G() : zzdfxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdob
    protected final Object q(int i2, Object obj, Object obj2) {
        os osVar = null;
        switch (os.a[i2 - 1]) {
            case 1:
                return new zzdfv();
            case 2:
                return new zza(osVar);
            case 3:
                return zzdob.r(zzgsy, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzgqk", "zzgsx", "zzgqs"});
            case 4:
                return zzgsy;
            case 5:
                zzdpv<zzdfv> zzbVar = zzdv;
                if (zzbVar == null) {
                    synchronized (zzdfv.class) {
                        zzbVar = zzdv;
                        if (zzbVar == null) {
                            zzbVar = new zzdob.zzb<>(zzgsy);
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
        return this.zzgqk;
    }
}
