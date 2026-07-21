package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdgl extends zzdob<zzdgl, zza> implements zzdpm {
    private static volatile zzdpv<zzdgl> zzdv;
    private static final zzdgl zzgtu;
    private int zzgqk;
    private zzdmr zzgqs = zzdmr.f15982f;
    private zzdgp zzgtt;

    public static final class zza extends zzdob.zza<zzdgl, zza> implements zzdpm {
        private zza() {
            super(zzdgl.zzgtu);
        }

        public final zza u(zzdmr zzdmrVar) {
            p();
            ((zzdgl) this.f16019g).J(zzdmrVar);
            return this;
        }

        public final zza v(zzdgp zzdgpVar) {
            p();
            ((zzdgl) this.f16019g).H(zzdgpVar);
            return this;
        }

        public final zza w(int i2) {
            p();
            ((zzdgl) this.f16019g).y(0);
            return this;
        }

        /* synthetic */ zza(us usVar) {
            this();
        }
    }

    static {
        zzdgl zzdglVar = new zzdgl();
        zzgtu = zzdglVar;
        zzdob.t(zzdgl.class, zzdglVar);
    }

    private zzdgl() {
    }

    public static zza E() {
        return (zza) ((zzdob.zza) zzgtu.q(zzdob.zze.f16025e, null, null));
    }

    public static zzdgl F() {
        return zzgtu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(zzdgp zzdgpVar) {
        zzdgpVar.getClass();
        this.zzgtt = zzdgpVar;
    }

    public static zzdgl I(zzdmr zzdmrVar) throws zzdok {
        return (zzdgl) zzdob.k(zzgtu, zzdmrVar);
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

    public final zzdmr C() {
        return this.zzgqs;
    }

    public final zzdgp D() {
        zzdgp zzdgpVar = this.zzgtt;
        return zzdgpVar == null ? zzdgp.z() : zzdgpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdob
    protected final Object q(int i2, Object obj, Object obj2) {
        us usVar = null;
        switch (us.a[i2 - 1]) {
            case 1:
                return new zzdgl();
            case 2:
                return new zza(usVar);
            case 3:
                return zzdob.r(zzgtu, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzgqk", "zzgtt", "zzgqs"});
            case 4:
                return zzgtu;
            case 5:
                zzdpv<zzdgl> zzbVar = zzdv;
                if (zzbVar == null) {
                    synchronized (zzdgl.class) {
                        zzbVar = zzdv;
                        if (zzbVar == null) {
                            zzbVar = new zzdob.zzb<>(zzgtu);
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
