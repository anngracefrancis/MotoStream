package com.google.android.gms.internal.ads;

import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdrz {

    public static final class zza extends zzdob<zza, C0179zza> implements zzdpm {
        private static volatile zzdpv<zza> zzdv;
        private static final zza zzhoq;
        private int zzdj;
        private int zzhoj;
        private zzb zzhok;
        private zzdmr zzhol;
        private zzdmr zzhom;
        private boolean zzhon;
        private boolean zzhoo;
        private byte zzhop = 2;

        /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzdrz$zza$zza, reason: collision with other inner class name */
        public static final class C0179zza extends zzdob.zza<zza, C0179zza> implements zzdpm {
            private C0179zza() {
                super(zza.zzhoq);
            }

            /* synthetic */ C0179zza(xx xxVar) {
                this();
            }
        }

        public static final class zzb extends zzdob<zzb, C0180zza> implements zzdpm {
            private static volatile zzdpv<zzb> zzdv;
            private static final zzb zzhov;
            private int zzdj;
            private String zzhor = HttpUrl.FRAGMENT_ENCODE_SET;
            private String zzhos = HttpUrl.FRAGMENT_ENCODE_SET;
            private String zzhot = HttpUrl.FRAGMENT_ENCODE_SET;
            private int zzhou;

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzdrz$zza$zzb$zza, reason: collision with other inner class name */
            public static final class C0180zza extends zzdob.zza<zzb, C0180zza> implements zzdpm {
                private C0180zza() {
                    super(zzb.zzhov);
                }

                /* synthetic */ C0180zza(xx xxVar) {
                    this();
                }
            }

            static {
                zzb zzbVar = new zzb();
                zzhov = zzbVar;
                zzdob.t(zzb.class, zzbVar);
            }

            private zzb() {
            }

            @Override // com.google.android.gms.internal.ads.zzdob
            protected final Object q(int i2, Object obj, Object obj2) {
                xx xxVar = null;
                switch (xx.a[i2 - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C0180zza(xxVar);
                    case 3:
                        return zzdob.r(zzhov, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0004\u0003", new Object[]{"zzdj", "zzhor", "zzhos", "zzhot", "zzhou"});
                    case 4:
                        return zzhov;
                    case 5:
                        zzdpv<zzb> zzbVar = zzdv;
                        if (zzbVar == null) {
                            synchronized (zzb.class) {
                                zzbVar = zzdv;
                                if (zzbVar == null) {
                                    zzbVar = new zzdob.zzb<>(zzhov);
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

        public enum zzc implements zzdoe {
            SAFE(0),
            DANGEROUS(1),
            UNKNOWN(2),
            POTENTIALLY_UNWANTED(3),
            DANGEROUS_HOST(4);


            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private static final zzdof<zzc> f16092k = new yx();
            private final int m;

            zzc(int i2) {
                this.m = i2;
            }

            public static zzdog g() {
                return zx.a;
            }

            public static zzc k(int i2) {
                if (i2 == 0) {
                    return SAFE;
                }
                if (i2 == 1) {
                    return DANGEROUS;
                }
                if (i2 == 2) {
                    return UNKNOWN;
                }
                if (i2 == 3) {
                    return POTENTIALLY_UNWANTED;
                }
                if (i2 != 4) {
                    return null;
                }
                return DANGEROUS_HOST;
            }

            @Override // com.google.android.gms.internal.ads.zzdoe
            public final int i() {
                return this.m;
            }
        }

        static {
            zza zzaVar = new zza();
            zzhoq = zzaVar;
            zzdob.t(zza.class, zzaVar);
        }

        private zza() {
            zzdmr zzdmrVar = zzdmr.f15982f;
            this.zzhol = zzdmrVar;
            this.zzhom = zzdmrVar;
        }

        @Override // com.google.android.gms.internal.ads.zzdob
        protected final Object q(int i2, Object obj, Object obj2) {
            xx xxVar = null;
            switch (xx.a[i2 - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0179zza(xxVar);
                case 3:
                    return zzdob.r(zzhoq, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0001\u0001Ԍ\u0000\u0002\t\u0001\u0003\n\u0002\u0004\n\u0003\u0005\u0007\u0004\u0006\u0007\u0005", new Object[]{"zzdj", "zzhoj", zzc.g(), "zzhok", "zzhol", "zzhom", "zzhon", "zzhoo"});
                case 4:
                    return zzhoq;
                case 5:
                    zzdpv<zza> zzbVar = zzdv;
                    if (zzbVar == null) {
                        synchronized (zza.class) {
                            zzbVar = zzdv;
                            if (zzbVar == null) {
                                zzbVar = new zzdob.zzb<>(zzhoq);
                                zzdv = zzbVar;
                            }
                            break;
                        }
                    }
                    return zzbVar;
                case 6:
                    return Byte.valueOf(this.zzhop);
                case 7:
                    this.zzhop = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzb extends zzdob<zzb, zza> implements zzdpm {
        private static volatile zzdpv<zzb> zzdv;
        private static final zzb zzhpr;
        private int zzbzi;
        private int zzdj;
        private int zzhpc;
        private C0181zzb zzhpf;
        private zzf zzhpi;
        private boolean zzhpj;
        private boolean zzhpm;
        private boolean zzhpn;
        private zzi zzhpo;
        private byte zzhop = 2;
        private String zzhos = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzhpd = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzhpe = HttpUrl.FRAGMENT_ENCODE_SET;
        private zzdoj<zzh> zzhpg = zzdob.v();
        private String zzhph = HttpUrl.FRAGMENT_ENCODE_SET;
        private zzdoj<String> zzhpk = zzdob.v();
        private String zzhpl = HttpUrl.FRAGMENT_ENCODE_SET;
        private zzdmr zzhol = zzdmr.f15982f;
        private zzdoj<String> zzhpp = zzdob.v();
        private zzdoj<String> zzhpq = zzdob.v();

        public static final class zza extends zzdob.zza<zzb, zza> implements zzdpm {
            private zza() {
                super(zzb.zzhpr);
            }

            /* synthetic */ zza(xx xxVar) {
                this();
            }
        }

        /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zzb, reason: collision with other inner class name */
        public static final class C0181zzb extends zzdob<C0181zzb, zza> implements zzdpm {
            private static volatile zzdpv<C0181zzb> zzdv;
            private static final C0181zzb zzhpt;
            private int zzdj;
            private String zzhps = HttpUrl.FRAGMENT_ENCODE_SET;

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zzb$zza */
            public static final class zza extends zzdob.zza<C0181zzb, zza> implements zzdpm {
                private zza() {
                    super(C0181zzb.zzhpt);
                }

                /* synthetic */ zza(xx xxVar) {
                    this();
                }
            }

            static {
                C0181zzb c0181zzb = new C0181zzb();
                zzhpt = c0181zzb;
                zzdob.t(C0181zzb.class, c0181zzb);
            }

            private C0181zzb() {
            }

            @Override // com.google.android.gms.internal.ads.zzdob
            protected final Object q(int i2, Object obj, Object obj2) {
                xx xxVar = null;
                switch (xx.a[i2 - 1]) {
                    case 1:
                        return new C0181zzb();
                    case 2:
                        return new zza(xxVar);
                    case 3:
                        return zzdob.r(zzhpt, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"zzdj", "zzhps"});
                    case 4:
                        return zzhpt;
                    case 5:
                        zzdpv<C0181zzb> zzbVar = zzdv;
                        if (zzbVar == null) {
                            synchronized (C0181zzb.class) {
                                zzbVar = zzdv;
                                if (zzbVar == null) {
                                    zzbVar = new zzdob.zzb<>(zzhpt);
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

        public static final class zzc extends zzdob<zzc, zza> implements zzdpm {
            private static volatile zzdpv<zzc> zzdv;
            private static final zzc zzhpv;
            private int zzdj;
            private zzdmr zzgua;
            private byte zzhop = 2;
            private zzdmr zzhpu;

            public static final class zza extends zzdob.zza<zzc, zza> implements zzdpm {
                private zza() {
                    super(zzc.zzhpv);
                }

                /* synthetic */ zza(xx xxVar) {
                    this();
                }
            }

            static {
                zzc zzcVar = new zzc();
                zzhpv = zzcVar;
                zzdob.t(zzc.class, zzcVar);
            }

            private zzc() {
                zzdmr zzdmrVar = zzdmr.f15982f;
                this.zzhpu = zzdmrVar;
                this.zzgua = zzdmrVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdob
            protected final Object q(int i2, Object obj, Object obj2) {
                xx xxVar = null;
                switch (xx.a[i2 - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new zza(xxVar);
                    case 3:
                        return zzdob.r(zzhpv, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001Ԋ\u0000\u0002\n\u0001", new Object[]{"zzdj", "zzhpu", "zzgua"});
                    case 4:
                        return zzhpv;
                    case 5:
                        zzdpv<zzc> zzbVar = zzdv;
                        if (zzbVar == null) {
                            synchronized (zzc.class) {
                                zzbVar = zzdv;
                                if (zzbVar == null) {
                                    zzbVar = new zzdob.zzb<>(zzhpv);
                                    zzdv = zzbVar;
                                }
                                break;
                            }
                        }
                        return zzbVar;
                    case 6:
                        return Byte.valueOf(this.zzhop);
                    case 7:
                        this.zzhop = (byte) (obj == null ? 0 : 1);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        public static final class zzd extends zzdob<zzd, zza> implements zzdpm {
            private static volatile zzdpv<zzd> zzdv;
            private static final zzd zzhqb;
            private int zzdj;
            private C0182zzb zzhpw;
            private zzdmr zzhpy;
            private zzdmr zzhpz;
            private int zzhqa;
            private byte zzhop = 2;
            private zzdoj<zzc> zzhpx = zzdob.v();

            public static final class zza extends zzdob.zza<zzd, zza> implements zzdpm {
                private zza() {
                    super(zzd.zzhqb);
                }

                /* synthetic */ zza(xx xxVar) {
                    this();
                }
            }

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zzd$zzb, reason: collision with other inner class name */
            public static final class C0182zzb extends zzdob<C0182zzb, zza> implements zzdpm {
                private static volatile zzdpv<C0182zzb> zzdv;
                private static final C0182zzb zzhqf;
                private int zzdj;
                private zzdmr zzhqc;
                private zzdmr zzhqd;
                private zzdmr zzhqe;

                /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zzd$zzb$zza */
                public static final class zza extends zzdob.zza<C0182zzb, zza> implements zzdpm {
                    private zza() {
                        super(C0182zzb.zzhqf);
                    }

                    /* synthetic */ zza(xx xxVar) {
                        this();
                    }
                }

                static {
                    C0182zzb c0182zzb = new C0182zzb();
                    zzhqf = c0182zzb;
                    zzdob.t(C0182zzb.class, c0182zzb);
                }

                private C0182zzb() {
                    zzdmr zzdmrVar = zzdmr.f15982f;
                    this.zzhqc = zzdmrVar;
                    this.zzhqd = zzdmrVar;
                    this.zzhqe = zzdmrVar;
                }

                @Override // com.google.android.gms.internal.ads.zzdob
                protected final Object q(int i2, Object obj, Object obj2) {
                    xx xxVar = null;
                    switch (xx.a[i2 - 1]) {
                        case 1:
                            return new C0182zzb();
                        case 2:
                            return new zza(xxVar);
                        case 3:
                            return zzdob.r(zzhqf, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\n\u0000\u0002\n\u0001\u0003\n\u0002", new Object[]{"zzdj", "zzhqc", "zzhqd", "zzhqe"});
                        case 4:
                            return zzhqf;
                        case 5:
                            zzdpv<C0182zzb> zzbVar = zzdv;
                            if (zzbVar == null) {
                                synchronized (C0182zzb.class) {
                                    zzbVar = zzdv;
                                    if (zzbVar == null) {
                                        zzbVar = new zzdob.zzb<>(zzhqf);
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

            static {
                zzd zzdVar = new zzd();
                zzhqb = zzdVar;
                zzdob.t(zzd.class, zzdVar);
            }

            private zzd() {
                zzdmr zzdmrVar = zzdmr.f15982f;
                this.zzhpy = zzdmrVar;
                this.zzhpz = zzdmrVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdob
            protected final Object q(int i2, Object obj, Object obj2) {
                xx xxVar = null;
                switch (xx.a[i2 - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new zza(xxVar);
                    case 3:
                        return zzdob.r(zzhqb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001\t\u0000\u0002Л\u0003\n\u0001\u0004\n\u0002\u0005\u0004\u0003", new Object[]{"zzdj", "zzhpw", "zzhpx", zzc.class, "zzhpy", "zzhpz", "zzhqa"});
                    case 4:
                        return zzhqb;
                    case 5:
                        zzdpv<zzd> zzbVar = zzdv;
                        if (zzbVar == null) {
                            synchronized (zzd.class) {
                                zzbVar = zzdv;
                                if (zzbVar == null) {
                                    zzbVar = new zzdob.zzb<>(zzhqb);
                                    zzdv = zzbVar;
                                }
                                break;
                            }
                        }
                        return zzbVar;
                    case 6:
                        return Byte.valueOf(this.zzhop);
                    case 7:
                        this.zzhop = (byte) (obj == null ? 0 : 1);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        public static final class zze extends zzdob<zze, zza> implements zzdpm {
            private static volatile zzdpv<zze> zzdv;
            private static final zze zzhqi;
            private int zzdj;
            private byte zzhop = 2;
            private zzdoj<zzc> zzhpx = zzdob.v();
            private zzdmr zzhpy;
            private zzdmr zzhpz;
            private int zzhqa;
            private C0183zzb zzhqg;
            private zzdmr zzhqh;

            public static final class zza extends zzdob.zza<zze, zza> implements zzdpm {
                private zza() {
                    super(zze.zzhqi);
                }

                /* synthetic */ zza(xx xxVar) {
                    this();
                }
            }

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zze$zzb, reason: collision with other inner class name */
            public static final class C0183zzb extends zzdob<C0183zzb, zza> implements zzdpm {
                private static volatile zzdpv<C0183zzb> zzdv;
                private static final C0183zzb zzhql;
                private int zzdj;
                private zzdmr zzhqe;
                private int zzhqj;
                private zzdmr zzhqk;

                /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zze$zzb$zza */
                public static final class zza extends zzdob.zza<C0183zzb, zza> implements zzdpm {
                    private zza() {
                        super(C0183zzb.zzhql);
                    }

                    /* synthetic */ zza(xx xxVar) {
                        this();
                    }
                }

                static {
                    C0183zzb c0183zzb = new C0183zzb();
                    zzhql = c0183zzb;
                    zzdob.t(C0183zzb.class, c0183zzb);
                }

                private C0183zzb() {
                    zzdmr zzdmrVar = zzdmr.f15982f;
                    this.zzhqk = zzdmrVar;
                    this.zzhqe = zzdmrVar;
                }

                @Override // com.google.android.gms.internal.ads.zzdob
                protected final Object q(int i2, Object obj, Object obj2) {
                    xx xxVar = null;
                    switch (xx.a[i2 - 1]) {
                        case 1:
                            return new C0183zzb();
                        case 2:
                            return new zza(xxVar);
                        case 3:
                            return zzdob.r(zzhql, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\n\u0001\u0003\n\u0002", new Object[]{"zzdj", "zzhqj", "zzhqk", "zzhqe"});
                        case 4:
                            return zzhql;
                        case 5:
                            zzdpv<C0183zzb> zzbVar = zzdv;
                            if (zzbVar == null) {
                                synchronized (C0183zzb.class) {
                                    zzbVar = zzdv;
                                    if (zzbVar == null) {
                                        zzbVar = new zzdob.zzb<>(zzhql);
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

            static {
                zze zzeVar = new zze();
                zzhqi = zzeVar;
                zzdob.t(zze.class, zzeVar);
            }

            private zze() {
                zzdmr zzdmrVar = zzdmr.f15982f;
                this.zzhpy = zzdmrVar;
                this.zzhpz = zzdmrVar;
                this.zzhqh = zzdmrVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdob
            protected final Object q(int i2, Object obj, Object obj2) {
                xx xxVar = null;
                switch (xx.a[i2 - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new zza(xxVar);
                    case 3:
                        return zzdob.r(zzhqi, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001\t\u0000\u0002Л\u0003\n\u0001\u0004\n\u0002\u0005\u0004\u0003\u0006\n\u0004", new Object[]{"zzdj", "zzhqg", "zzhpx", zzc.class, "zzhpy", "zzhpz", "zzhqa", "zzhqh"});
                    case 4:
                        return zzhqi;
                    case 5:
                        zzdpv<zze> zzbVar = zzdv;
                        if (zzbVar == null) {
                            synchronized (zze.class) {
                                zzbVar = zzdv;
                                if (zzbVar == null) {
                                    zzbVar = new zzdob.zzb<>(zzhqi);
                                    zzdv = zzbVar;
                                }
                                break;
                            }
                        }
                        return zzbVar;
                    case 6:
                        return Byte.valueOf(this.zzhop);
                    case 7:
                        this.zzhop = (byte) (obj == null ? 0 : 1);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        public static final class zzf extends zzdob<zzf, zza> implements zzdpm {
            private static volatile zzdpv<zzf> zzdv;
            private static final zzf zzhqo;
            private int zzbzi;
            private int zzdj;
            private String zzhqm = HttpUrl.FRAGMENT_ENCODE_SET;
            private zzdmr zzhqn = zzdmr.f15982f;

            public static final class zza extends zzdob.zza<zzf, zza> implements zzdpm {
                private zza() {
                    super(zzf.zzhqo);
                }

                /* synthetic */ zza(xx xxVar) {
                    this();
                }
            }

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zzf$zzb, reason: collision with other inner class name */
            public enum EnumC0184zzb implements zzdoe {
                TYPE_UNKNOWN(0),
                TYPE_CREATIVE(1);


                /* JADX INFO: renamed from: h, reason: collision with root package name */
                private static final zzdof<EnumC0184zzb> f16095h = new ay();

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                private final int f16097j;

                EnumC0184zzb(int i2) {
                    this.f16097j = i2;
                }

                public static zzdog g() {
                    return by.a;
                }

                public static EnumC0184zzb k(int i2) {
                    if (i2 == 0) {
                        return TYPE_UNKNOWN;
                    }
                    if (i2 != 1) {
                        return null;
                    }
                    return TYPE_CREATIVE;
                }

                @Override // com.google.android.gms.internal.ads.zzdoe
                public final int i() {
                    return this.f16097j;
                }
            }

            static {
                zzf zzfVar = new zzf();
                zzhqo = zzfVar;
                zzdob.t(zzf.class, zzfVar);
            }

            private zzf() {
            }

            @Override // com.google.android.gms.internal.ads.zzdob
            protected final Object q(int i2, Object obj, Object obj2) {
                xx xxVar = null;
                switch (xx.a[i2 - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new zza(xxVar);
                    case 3:
                        return zzdob.r(zzhqo, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001\u0003\n\u0002", new Object[]{"zzdj", "zzbzi", EnumC0184zzb.g(), "zzhqm", "zzhqn"});
                    case 4:
                        return zzhqo;
                    case 5:
                        zzdpv<zzf> zzbVar = zzdv;
                        if (zzbVar == null) {
                            synchronized (zzf.class) {
                                zzbVar = zzdv;
                                if (zzbVar == null) {
                                    zzbVar = new zzdob.zzb<>(zzhqo);
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

        public enum zzg implements zzdoe {
            UNKNOWN(0),
            URL_PHISHING(1),
            URL_MALWARE(2),
            URL_UNWANTED(3),
            CLIENT_SIDE_PHISHING_URL(4),
            CLIENT_SIDE_MALWARE_URL(5),
            DANGEROUS_DOWNLOAD_RECOVERY(6),
            DANGEROUS_DOWNLOAD_WARNING(7),
            OCTAGON_AD(8),
            OCTAGON_AD_SB_MATCH(9);

            private static final zzdof<zzg> p = new cy();
            private final int r;

            zzg(int i2) {
                this.r = i2;
            }

            public static zzdog g() {
                return dy.a;
            }

            public static zzg k(int i2) {
                switch (i2) {
                    case 0:
                        return UNKNOWN;
                    case 1:
                        return URL_PHISHING;
                    case 2:
                        return URL_MALWARE;
                    case 3:
                        return URL_UNWANTED;
                    case 4:
                        return CLIENT_SIDE_PHISHING_URL;
                    case 5:
                        return CLIENT_SIDE_MALWARE_URL;
                    case 6:
                        return DANGEROUS_DOWNLOAD_RECOVERY;
                    case 7:
                        return DANGEROUS_DOWNLOAD_WARNING;
                    case 8:
                        return OCTAGON_AD;
                    case 9:
                        return OCTAGON_AD_SB_MATCH;
                    default:
                        return null;
                }
            }

            @Override // com.google.android.gms.internal.ads.zzdoe
            public final int i() {
                return this.r;
            }
        }

        public static final class zzh extends zzdob<zzh, C0185zzb> implements zzdpm {
            private static volatile zzdpv<zzh> zzdv;
            private static final zzh zzhrl;
            private int zzdj;
            private int zzhrd;
            private zzd zzhre;
            private zze zzhrf;
            private int zzhrg;
            private int zzhrj;
            private byte zzhop = 2;
            private String zzhos = HttpUrl.FRAGMENT_ENCODE_SET;
            private zzdoh zzhrh = zzdob.u();
            private String zzhri = HttpUrl.FRAGMENT_ENCODE_SET;
            private zzdoj<String> zzhrk = zzdob.v();

            public enum zza implements zzdoe {
                AD_RESOURCE_UNKNOWN(0),
                AD_RESOURCE_CREATIVE(1),
                AD_RESOURCE_POST_CLICK(2),
                AD_RESOURCE_AUTO_CLICK_DESTINATION(3);


                /* JADX INFO: renamed from: j, reason: collision with root package name */
                private static final zzdof<zza> f16108j = new ey();
                private final int l;

                zza(int i2) {
                    this.l = i2;
                }

                public static zzdog g() {
                    return fy.a;
                }

                public static zza k(int i2) {
                    if (i2 == 0) {
                        return AD_RESOURCE_UNKNOWN;
                    }
                    if (i2 == 1) {
                        return AD_RESOURCE_CREATIVE;
                    }
                    if (i2 == 2) {
                        return AD_RESOURCE_POST_CLICK;
                    }
                    if (i2 != 3) {
                        return null;
                    }
                    return AD_RESOURCE_AUTO_CLICK_DESTINATION;
                }

                @Override // com.google.android.gms.internal.ads.zzdoe
                public final int i() {
                    return this.l;
                }
            }

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzdrz$zzb$zzh$zzb, reason: collision with other inner class name */
            public static final class C0185zzb extends zzdob.zza<zzh, C0185zzb> implements zzdpm {
                private C0185zzb() {
                    super(zzh.zzhrl);
                }

                /* synthetic */ C0185zzb(xx xxVar) {
                    this();
                }
            }

            static {
                zzh zzhVar = new zzh();
                zzhrl = zzhVar;
                zzdob.t(zzh.class, zzhVar);
            }

            private zzh() {
            }

            @Override // com.google.android.gms.internal.ads.zzdob
            protected final Object q(int i2, Object obj, Object obj2) {
                xx xxVar = null;
                switch (xx.a[i2 - 1]) {
                    case 1:
                        return new zzh();
                    case 2:
                        return new C0185zzb(xxVar);
                    case 3:
                        return zzdob.r(zzhrl, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001Ԅ\u0000\u0002\b\u0001\u0003Љ\u0002\u0004Љ\u0003\u0005\u0004\u0004\u0006\u0016\u0007\b\u0005\b\f\u0006\t\u001a", new Object[]{"zzdj", "zzhrd", "zzhos", "zzhre", "zzhrf", "zzhrg", "zzhrh", "zzhri", "zzhrj", zza.g(), "zzhrk"});
                    case 4:
                        return zzhrl;
                    case 5:
                        zzdpv<zzh> zzbVar = zzdv;
                        if (zzbVar == null) {
                            synchronized (zzh.class) {
                                zzbVar = zzdv;
                                if (zzbVar == null) {
                                    zzbVar = new zzdob.zzb<>(zzhrl);
                                    zzdv = zzbVar;
                                }
                                break;
                            }
                        }
                        return zzbVar;
                    case 6:
                        return Byte.valueOf(this.zzhop);
                    case 7:
                        this.zzhop = (byte) (obj == null ? 0 : 1);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        public static final class zzi extends zzdob<zzi, zza> implements zzdpm {
            private static volatile zzdpv<zzi> zzdv;
            private static final zzi zzhru;
            private int zzdj;
            private String zzhrr = HttpUrl.FRAGMENT_ENCODE_SET;
            private long zzhrs;
            private boolean zzhrt;

            public static final class zza extends zzdob.zza<zzi, zza> implements zzdpm {
                private zza() {
                    super(zzi.zzhru);
                }

                /* synthetic */ zza(xx xxVar) {
                    this();
                }
            }

            static {
                zzi zziVar = new zzi();
                zzhru = zziVar;
                zzdob.t(zzi.class, zziVar);
            }

            private zzi() {
            }

            @Override // com.google.android.gms.internal.ads.zzdob
            protected final Object q(int i2, Object obj, Object obj2) {
                xx xxVar = null;
                switch (xx.a[i2 - 1]) {
                    case 1:
                        return new zzi();
                    case 2:
                        return new zza(xxVar);
                    case 3:
                        return zzdob.r(zzhru, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001\u0003\u0007\u0002", new Object[]{"zzdj", "zzhrr", "zzhrs", "zzhrt"});
                    case 4:
                        return zzhru;
                    case 5:
                        zzdpv<zzi> zzbVar = zzdv;
                        if (zzbVar == null) {
                            synchronized (zzi.class) {
                                zzbVar = zzdv;
                                if (zzbVar == null) {
                                    zzbVar = new zzdob.zzb<>(zzhru);
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

        static {
            zzb zzbVar = new zzb();
            zzhpr = zzbVar;
            zzdob.t(zzb.class, zzbVar);
        }

        private zzb() {
        }

        @Override // com.google.android.gms.internal.ads.zzdob
        protected final Object q(int i2, Object obj, Object obj2) {
            xx xxVar = null;
            switch (xx.a[i2 - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(xxVar);
                case 3:
                    return zzdob.r(zzhpr, "\u0001\u0012\u0000\u0001\u0001\u0015\u0012\u0000\u0004\u0001\u0001\b\u0002\u0002\b\u0003\u0003\b\u0004\u0004Л\u0005\u0007\b\u0006\u001a\u0007\b\t\b\u0007\n\t\u0007\u000b\n\f\u0000\u000b\f\u0001\f\t\u0005\r\b\u0006\u000e\t\u0007\u000f\n\f\u0011\t\r\u0014\u001a\u0015\u001a", new Object[]{"zzdj", "zzhos", "zzhpd", "zzhpe", "zzhpg", zzh.class, "zzhpj", "zzhpk", "zzhpl", "zzhpm", "zzhpn", "zzbzi", zzg.g(), "zzhpc", zza.zzc.g(), "zzhpf", "zzhph", "zzhpi", "zzhol", "zzhpo", "zzhpp", "zzhpq"});
                case 4:
                    return zzhpr;
                case 5:
                    zzdpv<zzb> zzbVar = zzdv;
                    if (zzbVar == null) {
                        synchronized (zzb.class) {
                            zzbVar = zzdv;
                            if (zzbVar == null) {
                                zzbVar = new zzdob.zzb<>(zzhpr);
                                zzdv = zzbVar;
                            }
                            break;
                        }
                    }
                    return zzbVar;
                case 6:
                    return Byte.valueOf(this.zzhop);
                case 7:
                    this.zzhop = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }
}
