package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdha extends zzdob<zzdha, zza> implements zzdpm {
    private static volatile zzdpv<zzdha> zzdv;
    private static final zzdha zzguz;
    private int zzdj;
    private int zzgux;
    private zzdoj<zzb> zzguy = zzdob.v();

    public static final class zza extends zzdob.zza<zzdha, zza> implements zzdpm {
        private zza() {
            super(zzdha.zzguz);
        }

        /* synthetic */ zza(ct ctVar) {
            this();
        }
    }

    public static final class zzb extends zzdob<zzb, zza> implements zzdpm {
        private static volatile zzdpv<zzb> zzdv;
        private static final zzb zzgvd;
        private int zzguq;
        private zzdgr zzgva;
        private int zzgvb;
        private int zzgvc;

        public static final class zza extends zzdob.zza<zzb, zza> implements zzdpm {
            private zza() {
                super(zzb.zzgvd);
            }

            /* synthetic */ zza(ct ctVar) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzgvd = zzbVar;
            zzdob.t(zzb.class, zzbVar);
        }

        private zzb() {
        }

        public final zzdgu A() {
            zzdgu zzdguVarG = zzdgu.g(this.zzgvb);
            return zzdguVarG == null ? zzdgu.UNRECOGNIZED : zzdguVarG;
        }

        public final int B() {
            return this.zzgvc;
        }

        @Override // com.google.android.gms.internal.ads.zzdob
        protected final Object q(int i2, Object obj, Object obj2) {
            ct ctVar = null;
            switch (ct.a[i2 - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(ctVar);
                case 3:
                    return zzdob.r(zzgvd, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzgva", "zzgvb", "zzgvc", "zzguq"});
                case 4:
                    return zzgvd;
                case 5:
                    zzdpv<zzb> zzbVar = zzdv;
                    if (zzbVar == null) {
                        synchronized (zzb.class) {
                            zzbVar = zzdv;
                            if (zzbVar == null) {
                                zzbVar = new zzdob.zzb<>(zzgvd);
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

        public final zzdhm x() {
            zzdhm zzdhmVarG = zzdhm.g(this.zzguq);
            return zzdhmVarG == null ? zzdhm.UNRECOGNIZED : zzdhmVarG;
        }

        public final boolean y() {
            return this.zzgva != null;
        }

        public final zzdgr z() {
            zzdgr zzdgrVar = this.zzgva;
            return zzdgrVar == null ? zzdgr.F() : zzdgrVar;
        }
    }

    static {
        zzdha zzdhaVar = new zzdha();
        zzguz = zzdhaVar;
        zzdob.t(zzdha.class, zzdhaVar);
    }

    private zzdha() {
    }

    public static zzdha B(byte[] bArr) throws zzdok {
        return (zzdha) zzdob.n(zzguz, bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzdob
    protected final Object q(int i2, Object obj, Object obj2) {
        ct ctVar = null;
        switch (ct.a[i2 - 1]) {
            case 1:
                return new zzdha();
            case 2:
                return new zza(ctVar);
            case 3:
                return zzdob.r(zzguz, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzdj", "zzgux", "zzguy", zzb.class});
            case 4:
                return zzguz;
            case 5:
                zzdpv<zzdha> zzbVar = zzdv;
                if (zzbVar == null) {
                    synchronized (zzdha.class) {
                        zzbVar = zzdv;
                        if (zzbVar == null) {
                            zzbVar = new zzdob.zzb<>(zzguz);
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
        return this.zzgux;
    }

    public final List<zzb> y() {
        return this.zzguy;
    }

    public final int z() {
        return this.zzguy.size();
    }
}
