package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdeb extends zzdob<zzdeb, zza> implements zzdpm {
    private static volatile zzdpv<zzdeb> zzdv;
    private static final zzdeb zzgrc;
    private int zzgqk;
    private zzdmr zzgqs = zzdmr.f15982f;
    private zzdef zzgrb;

    public static final class zza extends zzdob.zza<zzdeb, zza> implements zzdpm {
        private zza() {
            super(zzdeb.zzgrc);
        }

        public final zza u(zzdmr zzdmrVar) {
            p();
            ((zzdeb) this.f16019g).J(zzdmrVar);
            return this;
        }

        public final zza v(zzdef zzdefVar) {
            p();
            ((zzdeb) this.f16019g).I(zzdefVar);
            return this;
        }

        public final zza w(int i2) {
            p();
            ((zzdeb) this.f16019g).y(0);
            return this;
        }

        /* synthetic */ zza(bs bsVar) {
            this();
        }
    }

    static {
        zzdeb zzdebVar = new zzdeb();
        zzgrc = zzdebVar;
        zzdob.t(zzdeb.class, zzdebVar);
    }

    private zzdeb() {
    }

    public static zzdeb C(zzdmr zzdmrVar) throws zzdok {
        return (zzdeb) zzdob.k(zzgrc, zzdmrVar);
    }

    public static zza F() {
        return (zza) ((zzdob.zza) zzgrc.q(zzdob.zze.f16025e, null, null));
    }

    public static zzdeb G() {
        return zzgrc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(zzdef zzdefVar) {
        zzdefVar.getClass();
        this.zzgrb = zzdefVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(zzdmr zzdmrVar) {
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

    public final zzdef E() {
        zzdef zzdefVar = this.zzgrb;
        return zzdefVar == null ? zzdef.y() : zzdefVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdob
    protected final Object q(int i2, Object obj, Object obj2) {
        bs bsVar = null;
        switch (bs.a[i2 - 1]) {
            case 1:
                return new zzdeb();
            case 2:
                return new zza(bsVar);
            case 3:
                return zzdob.r(zzgrc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzgqk", "zzgrb", "zzgqs"});
            case 4:
                return zzgrc;
            case 5:
                zzdpv<zzdeb> zzbVar = zzdv;
                if (zzbVar == null) {
                    synchronized (zzdeb.class) {
                        zzbVar = zzdv;
                        if (zzbVar == null) {
                            zzbVar = new zzdob.zzb<>(zzgrc);
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
