package com.google.android.gms.internal.ads;

import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdgr extends zzdob<zzdgr, zza> implements zzdpm {
    private static volatile zzdpv<zzdgr> zzdv;
    private static final zzdgr zzguc;
    private String zzgtz = HttpUrl.FRAGMENT_ENCODE_SET;
    private zzdmr zzgua = zzdmr.f15982f;
    private int zzgub;

    public static final class zza extends zzdob.zza<zzdgr, zza> implements zzdpm {
        private zza() {
            super(zzdgr.zzguc);
        }

        public final zza u(zzb zzbVar) {
            p();
            ((zzdgr) this.f16019g).x(zzbVar);
            return this;
        }

        public final zza v(zzdmr zzdmrVar) {
            p();
            ((zzdgr) this.f16019g).H(zzdmrVar);
            return this;
        }

        public final zza w(String str) {
            p();
            ((zzdgr) this.f16019g).I(str);
            return this;
        }

        /* synthetic */ zza(xs xsVar) {
            this();
        }
    }

    public enum zzb implements zzdoe {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);

        private static final zzdof<zzb> l = new ys();
        private final int n;

        zzb(int i2) {
            this.n = i2;
        }

        public static zzb g(int i2) {
            if (i2 == 0) {
                return UNKNOWN_KEYMATERIAL;
            }
            if (i2 == 1) {
                return SYMMETRIC;
            }
            if (i2 == 2) {
                return ASYMMETRIC_PRIVATE;
            }
            if (i2 == 3) {
                return ASYMMETRIC_PUBLIC;
            }
            if (i2 != 4) {
                return null;
            }
            return REMOTE;
        }

        @Override // com.google.android.gms.internal.ads.zzdoe
        public final int i() {
            if (this != UNRECOGNIZED) {
                return this.n;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        zzdgr zzdgrVar = new zzdgr();
        zzguc = zzdgrVar;
        zzdob.t(zzdgr.class, zzdgrVar);
    }

    private zzdgr() {
    }

    public static zza E() {
        return (zza) ((zzdob.zza) zzguc.q(zzdob.zze.f16025e, null, null));
    }

    public static zzdgr F() {
        return zzguc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(zzdmr zzdmrVar) {
        zzdmrVar.getClass();
        this.zzgua = zzdmrVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(String str) {
        str.getClass();
        this.zzgtz = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(zzb zzbVar) {
        zzbVar.getClass();
        this.zzgub = zzbVar.i();
    }

    public final String B() {
        return this.zzgtz;
    }

    public final zzdmr C() {
        return this.zzgua;
    }

    public final zzb D() {
        zzb zzbVarG = zzb.g(this.zzgub);
        return zzbVarG == null ? zzb.UNRECOGNIZED : zzbVarG;
    }

    @Override // com.google.android.gms.internal.ads.zzdob
    protected final Object q(int i2, Object obj, Object obj2) {
        xs xsVar = null;
        switch (xs.a[i2 - 1]) {
            case 1:
                return new zzdgr();
            case 2:
                return new zza(xsVar);
            case 3:
                return zzdob.r(zzguc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzgtz", "zzgua", "zzgub"});
            case 4:
                return zzguc;
            case 5:
                zzdpv<zzdgr> zzbVar = zzdv;
                if (zzbVar == null) {
                    synchronized (zzdgr.class) {
                        zzbVar = zzdv;
                        if (zzbVar == null) {
                            zzbVar = new zzdob.zzb<>(zzguc);
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
