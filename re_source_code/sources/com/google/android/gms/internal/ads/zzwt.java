package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdRequest;
import java.util.Iterator;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class zzwt {

    public static final class zza extends zzdob<zza, zzb> implements zzdpm {
        private static final zza zzbzk;
        private static volatile zzdpv<zza> zzdv;
        private int zzbzi;
        private zzl zzbzj;
        private int zzdj;

        /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzwt$zza$zza, reason: collision with other inner class name */
        public enum EnumC0187zza implements zzdoe {
            AD_FORMAT_TYPE_UNSPECIFIED(0),
            BANNER(1),
            INTERSTITIAL(2),
            NATIVE_EXPRESS(3),
            NATIVE_CONTENT(4),
            NATIVE_APP_INSTALL(5),
            NATIVE_CUSTOM_TEMPLATE(6),
            DFP_BANNER(7),
            DFP_INTERSTITIAL(8),
            REWARD_BASED_VIDEO_AD(9),
            BANNER_SEARCH_ADS(10);

            private static final zzdof<EnumC0187zza> q = new k50();
            private final int s;

            EnumC0187zza(int i2) {
                this.s = i2;
            }

            public static zzdog g() {
                return l50.a;
            }

            public static EnumC0187zza k(int i2) {
                switch (i2) {
                    case 0:
                        return AD_FORMAT_TYPE_UNSPECIFIED;
                    case 1:
                        return BANNER;
                    case 2:
                        return INTERSTITIAL;
                    case 3:
                        return NATIVE_EXPRESS;
                    case 4:
                        return NATIVE_CONTENT;
                    case 5:
                        return NATIVE_APP_INSTALL;
                    case 6:
                        return NATIVE_CUSTOM_TEMPLATE;
                    case 7:
                        return DFP_BANNER;
                    case 8:
                        return DFP_INTERSTITIAL;
                    case 9:
                        return REWARD_BASED_VIDEO_AD;
                    case 10:
                        return BANNER_SEARCH_ADS;
                    default:
                        return null;
                }
            }

            @Override // com.google.android.gms.internal.ads.zzdoe
            public final int i() {
                return this.s;
            }
        }

        public static final class zzb extends zzdob.zza<zza, zzb> implements zzdpm {
            private zzb() {
                super(zza.zzbzk);
            }

            /* synthetic */ zzb(j50 j50Var) {
                this();
            }
        }

        static {
            zza zzaVar = new zza();
            zzbzk = zzaVar;
            zzdob.t(zza.class, zzaVar);
        }

        private zza() {
        }

        @Override // com.google.android.gms.internal.ads.zzdob
        protected final Object q(int i2, Object obj, Object obj2) {
            j50 j50Var = null;
            switch (j50.a[i2 - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb(j50Var);
                case 3:
                    return zzdob.r(zzbzk, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001", new Object[]{"zzdj", "zzbzi", EnumC0187zza.g(), "zzbzj"});
                case 4:
                    return zzbzk;
                case 5:
                    zzdpv<zza> zzbVar = zzdv;
                    if (zzbVar == null) {
                        synchronized (zza.class) {
                            zzbVar = zzdv;
                            if (zzbVar == null) {
                                zzbVar = new zzdob.zzb<>(zzbzk);
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

    public static final class zzb extends zzdob<zzb, zza> implements zzdpm {
        private static final zzb zzcaa;
        private static volatile zzdpv<zzb> zzdv;
        private String zzbzx = HttpUrl.FRAGMENT_ENCODE_SET;
        private zzdoj<zza> zzbzy = zzdob.v();
        private int zzbzz;
        private int zzdj;

        public static final class zza extends zzdob.zza<zzb, zza> implements zzdpm {
            private zza() {
                super(zzb.zzcaa);
            }

            /* synthetic */ zza(j50 j50Var) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzcaa = zzbVar;
            zzdob.t(zzb.class, zzbVar);
        }

        private zzb() {
        }

        @Override // com.google.android.gms.internal.ads.zzdob
        protected final Object q(int i2, Object obj, Object obj2) {
            j50 j50Var = null;
            switch (j50.a[i2 - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(j50Var);
                case 3:
                    return zzdob.r(zzcaa, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\b\u0000\u0002\u001b\u0003\f\u0001", new Object[]{"zzdj", "zzbzx", "zzbzy", zza.class, "zzbzz", zzwx.g()});
                case 4:
                    return zzcaa;
                case 5:
                    zzdpv<zzb> zzbVar = zzdv;
                    if (zzbVar == null) {
                        synchronized (zzb.class) {
                            zzbVar = zzdv;
                            if (zzbVar == null) {
                                zzbVar = new zzdob.zzb<>(zzcaa);
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
        private static final zzc zzcah;
        private static volatile zzdpv<zzc> zzdv;
        private int zzcab;
        private zzn zzcac;
        private zzn zzcad;
        private zzn zzcae;
        private zzdoj<zzn> zzcaf = zzdob.v();
        private int zzcag;
        private int zzdj;

        public static final class zza extends zzdob.zza<zzc, zza> implements zzdpm {
            private zza() {
                super(zzc.zzcah);
            }

            /* synthetic */ zza(j50 j50Var) {
                this();
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzcah = zzcVar;
            zzdob.t(zzc.class, zzcVar);
        }

        private zzc() {
        }

        @Override // com.google.android.gms.internal.ads.zzdob
        protected final Object q(int i2, Object obj, Object obj2) {
            j50 j50Var = null;
            switch (j50.a[i2 - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(j50Var);
                case 3:
                    return zzdob.r(zzcah, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u0004\u0000\u0002\t\u0001\u0003\t\u0002\u0004\t\u0003\u0005\u001b\u0006\u0004\u0004", new Object[]{"zzdj", "zzcab", "zzcac", "zzcad", "zzcae", "zzcaf", zzn.class, "zzcag"});
                case 4:
                    return zzcah;
                case 5:
                    zzdpv<zzc> zzbVar = zzdv;
                    if (zzbVar == null) {
                        synchronized (zzc.class) {
                            zzbVar = zzdv;
                            if (zzbVar == null) {
                                zzbVar = new zzdob.zzb<>(zzcah);
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

    public static final class zzd extends zzdob<zzd, zza> implements zzdpm {
        private static final zzd zzcaq;
        private static volatile zzdpv<zzd> zzdv;
        private int zzcan;
        private zzn zzcap;
        private int zzdj;
        private String zzcam = HttpUrl.FRAGMENT_ENCODE_SET;
        private zzdoh zzcao = zzdob.u();

        public static final class zza extends zzdob.zza<zzd, zza> implements zzdpm {
            private zza() {
                super(zzd.zzcaq);
            }

            /* synthetic */ zza(j50 j50Var) {
                this();
            }
        }

        static {
            zzd zzdVar = new zzd();
            zzcaq = zzdVar;
            zzdob.t(zzd.class, zzdVar);
        }

        private zzd() {
        }

        @Override // com.google.android.gms.internal.ads.zzdob
        protected final Object q(int i2, Object obj, Object obj2) {
            j50 j50Var = null;
            switch (j50.a[i2 - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(j50Var);
                case 3:
                    return zzdob.r(zzcaq, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\b\u0000\u0002\f\u0001\u0003\u0016\u0004\t\u0002", new Object[]{"zzdj", "zzcam", "zzcan", zzwx.g(), "zzcao", "zzcap"});
                case 4:
                    return zzcaq;
                case 5:
                    zzdpv<zzd> zzbVar = zzdv;
                    if (zzbVar == null) {
                        synchronized (zzd.class) {
                            zzbVar = zzdv;
                            if (zzbVar == null) {
                                zzbVar = new zzdob.zzb<>(zzcaq);
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

    public static final class zze extends zzdob<zze, zza> implements zzdpm {
        private static final zze zzcas;
        private static volatile zzdpv<zze> zzdv;
        private zzdoh zzcao = zzdob.u();
        private int zzcar;
        private int zzdj;

        public static final class zza extends zzdob.zza<zze, zza> implements zzdpm {
            private zza() {
                super(zze.zzcas);
            }

            /* synthetic */ zza(j50 j50Var) {
                this();
            }
        }

        static {
            zze zzeVar = new zze();
            zzcas = zzeVar;
            zzdob.t(zze.class, zzeVar);
        }

        private zze() {
        }

        @Override // com.google.android.gms.internal.ads.zzdob
        protected final Object q(int i2, Object obj, Object obj2) {
            j50 j50Var = null;
            switch (j50.a[i2 - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(j50Var);
                case 3:
                    return zzdob.r(zzcas, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0000\u0002\u0016", new Object[]{"zzdj", "zzcar", zzwx.g(), "zzcao"});
                case 4:
                    return zzcas;
                case 5:
                    zzdpv<zze> zzbVar = zzdv;
                    if (zzbVar == null) {
                        synchronized (zze.class) {
                            zzbVar = zzdv;
                            if (zzbVar == null) {
                                zzbVar = new zzdob.zzb<>(zzcas);
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

    public static final class zzf extends zzdob<zzf, zza> implements zzdpm {
        private static final zzf zzcav;
        private static volatile zzdpv<zzf> zzdv;
        private zzn zzcap;
        private int zzcar;
        private zzd zzcat;
        private zzdoj<zzm> zzcau = zzdob.v();
        private int zzdj;

        public static final class zza extends zzdob.zza<zzf, zza> implements zzdpm {
            private zza() {
                super(zzf.zzcav);
            }

            /* synthetic */ zza(j50 j50Var) {
                this();
            }
        }

        static {
            zzf zzfVar = new zzf();
            zzcav = zzfVar;
            zzdob.t(zzf.class, zzfVar);
        }

        private zzf() {
        }

        @Override // com.google.android.gms.internal.ads.zzdob
        protected final Object q(int i2, Object obj, Object obj2) {
            j50 j50Var = null;
            switch (j50.a[i2 - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(j50Var);
                case 3:
                    return zzdob.r(zzcav, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\t\u0000\u0002\u001b\u0003\f\u0001\u0004\t\u0002", new Object[]{"zzdj", "zzcat", "zzcau", zzm.class, "zzcar", zzwx.g(), "zzcap"});
                case 4:
                    return zzcav;
                case 5:
                    zzdpv<zzf> zzbVar = zzdv;
                    if (zzbVar == null) {
                        synchronized (zzf.class) {
                            zzbVar = zzdv;
                            if (zzbVar == null) {
                                zzbVar = new zzdob.zzb<>(zzcav);
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

    public static final class zzg extends zzdob<zzg, zza> implements zzdpm {
        private static final zzg zzcax;
        private static volatile zzdpv<zzg> zzdv;
        private int zzbzi;
        private int zzcaw;
        private int zzdj;

        public static final class zza extends zzdob.zza<zzg, zza> implements zzdpm {
            private zza() {
                super(zzg.zzcax);
            }

            public final zza u(zzb zzbVar) {
                p();
                ((zzg) this.f16019g).x(zzbVar);
                return this;
            }

            public final zza v(zzc zzcVar) {
                p();
                ((zzg) this.f16019g).y(zzcVar);
                return this;
            }

            /* synthetic */ zza(j50 j50Var) {
                this();
            }
        }

        public enum zzb implements zzdoe {
            CELLULAR_NETWORK_TYPE_UNSPECIFIED(0),
            TWO_G(1),
            THREE_G(2),
            LTE(4);


            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private static final zzdof<zzb> f16894j = new o50();
            private final int l;

            zzb(int i2) {
                this.l = i2;
            }

            public static zzdog g() {
                return p50.a;
            }

            public static zzb k(int i2) {
                if (i2 == 0) {
                    return CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                }
                if (i2 == 1) {
                    return TWO_G;
                }
                if (i2 == 2) {
                    return THREE_G;
                }
                if (i2 != 4) {
                    return null;
                }
                return LTE;
            }

            @Override // com.google.android.gms.internal.ads.zzdoe
            public final int i() {
                return this.l;
            }
        }

        public enum zzc implements zzdoe {
            NETWORKTYPE_UNSPECIFIED(0),
            CELL(1),
            WIFI(2);


            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private static final zzdof<zzc> f16899i = new q50();

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private final int f16901k;

            zzc(int i2) {
                this.f16901k = i2;
            }

            public static zzdog g() {
                return r50.a;
            }

            public static zzc k(int i2) {
                if (i2 == 0) {
                    return NETWORKTYPE_UNSPECIFIED;
                }
                if (i2 == 1) {
                    return CELL;
                }
                if (i2 != 2) {
                    return null;
                }
                return WIFI;
            }

            @Override // com.google.android.gms.internal.ads.zzdoe
            public final int i() {
                return this.f16901k;
            }
        }

        static {
            zzg zzgVar = new zzg();
            zzcax = zzgVar;
            zzdob.t(zzg.class, zzgVar);
        }

        private zzg() {
        }

        public static zza B() {
            return (zza) ((zzdob.zza) zzcax.q(zzdob.zze.f16025e, null, null));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void x(zzb zzbVar) {
            zzbVar.getClass();
            this.zzdj |= 2;
            this.zzcaw = zzbVar.i();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void y(zzc zzcVar) {
            zzcVar.getClass();
            this.zzdj |= 1;
            this.zzbzi = zzcVar.i();
        }

        @Override // com.google.android.gms.internal.ads.zzdob
        protected final Object q(int i2, Object obj, Object obj2) {
            j50 j50Var = null;
            switch (j50.a[i2 - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(j50Var);
                case 3:
                    return zzdob.r(zzcax, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001", new Object[]{"zzdj", "zzbzi", zzc.g(), "zzcaw", zzb.g()});
                case 4:
                    return zzcax;
                case 5:
                    zzdpv<zzg> zzbVar = zzdv;
                    if (zzbVar == null) {
                        synchronized (zzg.class) {
                            zzbVar = zzdv;
                            if (zzbVar == null) {
                                zzbVar = new zzdob.zzb<>(zzcax);
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

    public static final class zzh extends zzdob<zzh, zza> implements zzdpm {
        private static final zzh zzcbj;
        private static volatile zzdpv<zzh> zzdv;
        private int zzcbh;
        private zzn zzcbi;
        private int zzdj;

        public static final class zza extends zzdob.zza<zzh, zza> implements zzdpm {
            private zza() {
                super(zzh.zzcbj);
            }

            /* synthetic */ zza(j50 j50Var) {
                this();
            }
        }

        static {
            zzh zzhVar = new zzh();
            zzcbj = zzhVar;
            zzdob.t(zzh.class, zzhVar);
        }

        private zzh() {
        }

        @Override // com.google.android.gms.internal.ads.zzdob
        protected final Object q(int i2, Object obj, Object obj2) {
            j50 j50Var = null;
            switch (j50.a[i2 - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza(j50Var);
                case 3:
                    return zzdob.r(zzcbj, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001", new Object[]{"zzdj", "zzcbh", zzwx.g(), "zzcbi"});
                case 4:
                    return zzcbj;
                case 5:
                    zzdpv<zzh> zzbVar = zzdv;
                    if (zzbVar == null) {
                        synchronized (zzh.class) {
                            zzbVar = zzdv;
                            if (zzbVar == null) {
                                zzbVar = new zzdob.zzb<>(zzcbj);
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

    public static final class zzi extends zzdob<zzi, zzb> implements zzdpm {
        private static final zzi zzcbq;
        private static volatile zzdpv<zzi> zzdv;
        private int zzcbl;
        private int zzcbm;
        private long zzcbn;
        private long zzcbp;
        private int zzdj;
        private zzdoj<zza> zzcbk = zzdob.v();
        private String zzdk = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzcbo = HttpUrl.FRAGMENT_ENCODE_SET;

        public static final class zza extends zzdob<zza, C0188zza> implements zzdpm {
            private static final zzdoi<Integer, zza.EnumC0187zza> zzcbw = new s50();
            private static final zza zzcce;
            private static volatile zzdpv<zza> zzdv;
            private long zzcbr;
            private int zzcbs;
            private long zzcbt;
            private long zzcbu;
            private zzdoh zzcbv = zzdob.u();
            private zzg zzcbx;
            private int zzcby;
            private int zzcbz;
            private int zzcca;
            private int zzccb;
            private int zzccc;
            private int zzccd;
            private int zzdj;

            /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzwt$zzi$zza$zza, reason: collision with other inner class name */
            public static final class C0188zza extends zzdob.zza<zza, C0188zza> implements zzdpm {
                private C0188zza() {
                    super(zza.zzcce);
                }

                public final C0188zza A(int i2) {
                    p();
                    ((zza) this.f16019g).O(i2);
                    return this;
                }

                public final C0188zza B(long j2) {
                    p();
                    ((zza) this.f16019g).x(j2);
                    return this;
                }

                public final C0188zza C(long j2) {
                    p();
                    ((zza) this.f16019g).T(j2);
                    return this;
                }

                public final C0188zza D(long j2) {
                    p();
                    ((zza) this.f16019g).U(j2);
                    return this;
                }

                public final C0188zza E(zzwx zzwxVar) {
                    p();
                    ((zza) this.f16019g).G(zzwxVar);
                    return this;
                }

                public final C0188zza F(zzwx zzwxVar) {
                    p();
                    ((zza) this.f16019g).J(zzwxVar);
                    return this;
                }

                public final C0188zza G(zzwx zzwxVar) {
                    p();
                    ((zza) this.f16019g).N(zzwxVar);
                    return this;
                }

                public final C0188zza H(zzwx zzwxVar) {
                    p();
                    ((zza) this.f16019g).Q(zzwxVar);
                    return this;
                }

                public final C0188zza I(zzwx zzwxVar) {
                    p();
                    ((zza) this.f16019g).S(zzwxVar);
                    return this;
                }

                public final C0188zza u(zzg zzgVar) {
                    p();
                    ((zza) this.f16019g).y(zzgVar);
                    return this;
                }

                public final C0188zza v(zzc zzcVar) {
                    p();
                    ((zza) this.f16019g).F(zzcVar);
                    return this;
                }

                public final C0188zza w(Iterable<? extends zza.EnumC0187zza> iterable) {
                    p();
                    ((zza) this.f16019g).K(iterable);
                    return this;
                }

                /* synthetic */ C0188zza(j50 j50Var) {
                    this();
                }
            }

            static {
                zza zzaVar = new zza();
                zzcce = zzaVar;
                zzdob.t(zza.class, zzaVar);
            }

            private zza() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void F(zzc zzcVar) {
                zzcVar.getClass();
                this.zzdj |= 1024;
                this.zzccd = zzcVar.i();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void G(zzwx zzwxVar) {
                zzwxVar.getClass();
                this.zzdj |= 2;
                this.zzcbs = zzwxVar.i();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void J(zzwx zzwxVar) {
                zzwxVar.getClass();
                this.zzdj |= 32;
                this.zzcby = zzwxVar.i();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void K(Iterable<? extends zza.EnumC0187zza> iterable) {
                if (!this.zzcbv.m0()) {
                    zzdoh zzdohVar = this.zzcbv;
                    int size = zzdohVar.size();
                    this.zzcbv = zzdohVar.N(size == 0 ? 10 : size << 1);
                }
                Iterator<? extends zza.EnumC0187zza> it = iterable.iterator();
                while (it.hasNext()) {
                    this.zzcbv.Z0(it.next().i());
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void N(zzwx zzwxVar) {
                zzwxVar.getClass();
                this.zzdj |= 64;
                this.zzcbz = zzwxVar.i();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void O(int i2) {
                this.zzdj |= 256;
                this.zzccb = i2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void Q(zzwx zzwxVar) {
                zzwxVar.getClass();
                this.zzdj |= 128;
                this.zzcca = zzwxVar.i();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void S(zzwx zzwxVar) {
                zzwxVar.getClass();
                this.zzdj |= AdRequest.MAX_CONTENT_URL_LENGTH;
                this.zzccc = zzwxVar.i();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void T(long j2) {
                this.zzdj |= 4;
                this.zzcbt = j2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void U(long j2) {
                this.zzdj |= 8;
                this.zzcbu = j2;
            }

            public static zza V(byte[] bArr) throws zzdok {
                return (zza) zzdob.n(zzcce, bArr);
            }

            public static C0188zza W() {
                return (C0188zza) ((zzdob.zza) zzcce.q(zzdob.zze.f16025e, null, null));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void x(long j2) {
                this.zzdj |= 1;
                this.zzcbr = j2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void y(zzg zzgVar) {
                zzgVar.getClass();
                this.zzcbx = zzgVar;
                this.zzdj |= 16;
            }

            @Override // com.google.android.gms.internal.ads.zzdob
            protected final Object q(int i2, Object obj, Object obj2) {
                j50 j50Var = null;
                switch (j50.a[i2 - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0188zza(j50Var);
                    case 3:
                        return zzdob.r(zzcce, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0001\u0000\u0001\u0002\u0000\u0002\f\u0001\u0003\u0002\u0002\u0004\u0002\u0003\u0005\u001e\u0006\t\u0004\u0007\f\u0005\b\f\u0006\t\f\u0007\n\u0004\b\u000b\f\t\f\f\n", new Object[]{"zzdj", "zzcbr", "zzcbs", zzwx.g(), "zzcbt", "zzcbu", "zzcbv", zza.EnumC0187zza.g(), "zzcbx", "zzcby", zzwx.g(), "zzcbz", zzwx.g(), "zzcca", zzwx.g(), "zzccb", "zzccc", zzwx.g(), "zzccd", zzc.g()});
                    case 4:
                        return zzcce;
                    case 5:
                        zzdpv<zza> zzbVar = zzdv;
                        if (zzbVar == null) {
                            synchronized (zza.class) {
                                zzbVar = zzdv;
                                if (zzbVar == null) {
                                    zzbVar = new zzdob.zzb<>(zzcce);
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

        public static final class zzb extends zzdob.zza<zzi, zzb> implements zzdpm {
            private zzb() {
                super(zzi.zzcbq);
            }

            public final zzb A(int i2) {
                p();
                ((zzi) this.f16019g).G(i2);
                return this;
            }

            public final zzb B(Iterable<? extends zza> iterable) {
                p();
                ((zzi) this.f16019g).B(iterable);
                return this;
            }

            public final zzb C(long j2) {
                p();
                ((zzi) this.f16019g).H(j2);
                return this;
            }

            public final zzb u(String str) {
                p();
                ((zzi) this.f16019g).I(str);
                return this;
            }

            public final zzb v(String str) {
                p();
                ((zzi) this.f16019g).E(str);
                return this;
            }

            public final zzb w(int i2) {
                p();
                ((zzi) this.f16019g).F(i2);
                return this;
            }

            /* synthetic */ zzb(j50 j50Var) {
                this();
            }
        }

        public enum zzc implements zzdoe {
            UNSPECIFIED(0),
            CONNECTING(1),
            CONNECTED(2),
            DISCONNECTING(3),
            DISCONNECTED(4),
            SUSPENDED(5);

            private static final zzdof<zzc> l = new t50();
            private final int n;

            zzc(int i2) {
                this.n = i2;
            }

            public static zzdog g() {
                return u50.a;
            }

            public static zzc k(int i2) {
                if (i2 == 0) {
                    return UNSPECIFIED;
                }
                if (i2 == 1) {
                    return CONNECTING;
                }
                if (i2 == 2) {
                    return CONNECTED;
                }
                if (i2 == 3) {
                    return DISCONNECTING;
                }
                if (i2 == 4) {
                    return DISCONNECTED;
                }
                if (i2 != 5) {
                    return null;
                }
                return SUSPENDED;
            }

            @Override // com.google.android.gms.internal.ads.zzdoe
            public final int i() {
                return this.n;
            }
        }

        static {
            zzi zziVar = new zzi();
            zzcbq = zziVar;
            zzdob.t(zzi.class, zziVar);
        }

        private zzi() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void B(Iterable<? extends zza> iterable) {
            if (!this.zzcbk.m0()) {
                zzdoj<zza> zzdojVar = this.zzcbk;
                int size = zzdojVar.size();
                this.zzcbk = zzdojVar.N(size == 0 ? 10 : size << 1);
            }
            zzdmi.a(iterable, this.zzcbk);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void E(String str) {
            str.getClass();
            this.zzdj |= 16;
            this.zzcbo = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void F(int i2) {
            this.zzdj |= 1;
            this.zzcbl = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void G(int i2) {
            this.zzdj |= 2;
            this.zzcbm = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void H(long j2) {
            this.zzdj |= 4;
            this.zzcbn = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void I(String str) {
            str.getClass();
            this.zzdj |= 8;
            this.zzdk = str;
        }

        public static zzb J() {
            return (zzb) ((zzdob.zza) zzcbq.q(zzdob.zze.f16025e, null, null));
        }

        @Override // com.google.android.gms.internal.ads.zzdob
        protected final Object q(int i2, Object obj, Object obj2) {
            j50 j50Var = null;
            switch (j50.a[i2 - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zzb(j50Var);
                case 3:
                    return zzdob.r(zzcbq, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001\u001b\u0002\u0004\u0000\u0003\u0004\u0001\u0004\u0002\u0002\u0005\b\u0003\u0006\b\u0004\u0007\u0002\u0005", new Object[]{"zzdj", "zzcbk", zza.class, "zzcbl", "zzcbm", "zzcbn", "zzdk", "zzcbo", "zzcbp"});
                case 4:
                    return zzcbq;
                case 5:
                    zzdpv<zzi> zzbVar = zzdv;
                    if (zzbVar == null) {
                        synchronized (zzi.class) {
                            zzbVar = zzdv;
                            if (zzbVar == null) {
                                zzbVar = new zzdob.zzb<>(zzcbq);
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

    public static final class zzj extends zzdob<zzj, zza> implements zzdpm {
        private static final zzj zzccx;
        private static volatile zzdpv<zzj> zzdv;
        private int zzccm = 1000;
        private int zzccn = 1000;
        private int zzcco;
        private int zzccp;
        private int zzccq;
        private int zzccr;
        private int zzccs;
        private int zzcct;
        private int zzccu;
        private int zzccv;
        private zzk zzccw;
        private int zzdj;

        public static final class zza extends zzdob.zza<zzj, zza> implements zzdpm {
            private zza() {
                super(zzj.zzccx);
            }

            /* synthetic */ zza(j50 j50Var) {
                this();
            }
        }

        static {
            zzj zzjVar = new zzj();
            zzccx = zzjVar;
            zzdob.t(zzj.class, zzjVar);
        }

        private zzj() {
        }

        @Override // com.google.android.gms.internal.ads.zzdob
        protected final Object q(int i2, Object obj, Object obj2) {
            j50 j50Var = null;
            switch (j50.a[i2 - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza(j50Var);
                case 3:
                    return zzdob.r(zzccx, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004\u0006\u0004\u0005\u0007\u0004\u0006\b\u0004\u0007\t\u0004\b\n\u0004\t\u000b\t\n", new Object[]{"zzdj", "zzccm", zzwx.g(), "zzccn", zzwx.g(), "zzcco", "zzccp", "zzccq", "zzccr", "zzccs", "zzcct", "zzccu", "zzccv", "zzccw"});
                case 4:
                    return zzccx;
                case 5:
                    zzdpv<zzj> zzbVar = zzdv;
                    if (zzbVar == null) {
                        synchronized (zzj.class) {
                            zzbVar = zzdv;
                            if (zzbVar == null) {
                                zzbVar = new zzdob.zzb<>(zzccx);
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

    public static final class zzk extends zzdob<zzk, zza> implements zzdpm {
        private static final zzk zzcda;
        private static volatile zzdpv<zzk> zzdv;
        private int zzccy;
        private int zzccz;
        private int zzdj;

        public static final class zza extends zzdob.zza<zzk, zza> implements zzdpm {
            private zza() {
                super(zzk.zzcda);
            }

            /* synthetic */ zza(j50 j50Var) {
                this();
            }
        }

        static {
            zzk zzkVar = new zzk();
            zzcda = zzkVar;
            zzdob.t(zzk.class, zzkVar);
        }

        private zzk() {
        }

        @Override // com.google.android.gms.internal.ads.zzdob
        protected final Object q(int i2, Object obj, Object obj2) {
            j50 j50Var = null;
            switch (j50.a[i2 - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza(j50Var);
                case 3:
                    return zzdob.r(zzcda, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzdj", "zzccy", "zzccz"});
                case 4:
                    return zzcda;
                case 5:
                    zzdpv<zzk> zzbVar = zzdv;
                    if (zzbVar == null) {
                        synchronized (zzk.class) {
                            zzbVar = zzdv;
                            if (zzbVar == null) {
                                zzbVar = new zzdob.zzb<>(zzcda);
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

    public static final class zzl extends zzdob<zzl, zza> implements zzdpm {
        private static final zzl zzcdd;
        private static volatile zzdpv<zzl> zzdv;
        private int zzcdb;
        private int zzcdc;
        private int zzdj;

        public static final class zza extends zzdob.zza<zzl, zza> implements zzdpm {
            private zza() {
                super(zzl.zzcdd);
            }

            /* synthetic */ zza(j50 j50Var) {
                this();
            }
        }

        static {
            zzl zzlVar = new zzl();
            zzcdd = zzlVar;
            zzdob.t(zzl.class, zzlVar);
        }

        private zzl() {
        }

        @Override // com.google.android.gms.internal.ads.zzdob
        protected final Object q(int i2, Object obj, Object obj2) {
            j50 j50Var = null;
            switch (j50.a[i2 - 1]) {
                case 1:
                    return new zzl();
                case 2:
                    return new zza(j50Var);
                case 3:
                    return zzdob.r(zzcdd, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzdj", "zzcdb", "zzcdc"});
                case 4:
                    return zzcdd;
                case 5:
                    zzdpv<zzl> zzbVar = zzdv;
                    if (zzbVar == null) {
                        synchronized (zzl.class) {
                            zzbVar = zzdv;
                            if (zzbVar == null) {
                                zzbVar = new zzdob.zzb<>(zzcdd);
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

    public static final class zzm extends zzdob<zzm, zza> implements zzdpm {
        private static final zzm zzcde;
        private static volatile zzdpv<zzm> zzdv;
        private String zzcam = HttpUrl.FRAGMENT_ENCODE_SET;
        private int zzcan;
        private zzn zzcap;
        private int zzdj;

        public static final class zza extends zzdob.zza<zzm, zza> implements zzdpm {
            private zza() {
                super(zzm.zzcde);
            }

            /* synthetic */ zza(j50 j50Var) {
                this();
            }
        }

        static {
            zzm zzmVar = new zzm();
            zzcde = zzmVar;
            zzdob.t(zzm.class, zzmVar);
        }

        private zzm() {
        }

        @Override // com.google.android.gms.internal.ads.zzdob
        protected final Object q(int i2, Object obj, Object obj2) {
            j50 j50Var = null;
            switch (j50.a[i2 - 1]) {
                case 1:
                    return new zzm();
                case 2:
                    return new zza(j50Var);
                case 3:
                    return zzdob.r(zzcde, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\f\u0001\u0003\t\u0002", new Object[]{"zzdj", "zzcam", "zzcan", zzwx.g(), "zzcap"});
                case 4:
                    return zzcde;
                case 5:
                    zzdpv<zzm> zzbVar = zzdv;
                    if (zzbVar == null) {
                        synchronized (zzm.class) {
                            zzbVar = zzdv;
                            if (zzbVar == null) {
                                zzbVar = new zzdob.zzb<>(zzcde);
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

    public static final class zzn extends zzdob<zzn, zza> implements zzdpm {
        private static final zzn zzcdh;
        private static volatile zzdpv<zzn> zzdv;
        private int zzcdf;
        private int zzcdg;
        private int zzdj;

        public static final class zza extends zzdob.zza<zzn, zza> implements zzdpm {
            private zza() {
                super(zzn.zzcdh);
            }

            /* synthetic */ zza(j50 j50Var) {
                this();
            }
        }

        static {
            zzn zznVar = new zzn();
            zzcdh = zznVar;
            zzdob.t(zzn.class, zznVar);
        }

        private zzn() {
        }

        @Override // com.google.android.gms.internal.ads.zzdob
        protected final Object q(int i2, Object obj, Object obj2) {
            j50 j50Var = null;
            switch (j50.a[i2 - 1]) {
                case 1:
                    return new zzn();
                case 2:
                    return new zza(j50Var);
                case 3:
                    return zzdob.r(zzcdh, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzdj", "zzcdf", "zzcdg"});
                case 4:
                    return zzcdh;
                case 5:
                    zzdpv<zzn> zzbVar = zzdv;
                    if (zzbVar == null) {
                        synchronized (zzn.class) {
                            zzbVar = zzdv;
                            if (zzbVar == null) {
                                zzbVar = new zzdob.zzb<>(zzcdh);
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

    public static final class zzo extends zzdob<zzo, zza> implements zzdpm {
        private static final zzo zzcdk;
        private static volatile zzdpv<zzo> zzdv;
        private int zzcar = 1000;
        private zzp zzcdi;
        private zzn zzcdj;
        private int zzdj;

        public static final class zza extends zzdob.zza<zzo, zza> implements zzdpm {
            private zza() {
                super(zzo.zzcdk);
            }

            /* synthetic */ zza(j50 j50Var) {
                this();
            }
        }

        static {
            zzo zzoVar = new zzo();
            zzcdk = zzoVar;
            zzdob.t(zzo.class, zzoVar);
        }

        private zzo() {
        }

        @Override // com.google.android.gms.internal.ads.zzdob
        protected final Object q(int i2, Object obj, Object obj2) {
            j50 j50Var = null;
            switch (j50.a[i2 - 1]) {
                case 1:
                    return new zzo();
                case 2:
                    return new zza(j50Var);
                case 3:
                    return zzdob.r(zzcdk, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzdj", "zzcar", zzwx.g(), "zzcdi", "zzcdj"});
                case 4:
                    return zzcdk;
                case 5:
                    zzdpv<zzo> zzbVar = zzdv;
                    if (zzbVar == null) {
                        synchronized (zzo.class) {
                            zzbVar = zzdv;
                            if (zzbVar == null) {
                                zzbVar = new zzdob.zzb<>(zzcdk);
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

    public static final class zzp extends zzdob<zzp, zza> implements zzdpm {
        private static final zzp zzcdm;
        private static volatile zzdpv<zzp> zzdv;
        private int zzcdl;
        private int zzdj;

        public static final class zza extends zzdob.zza<zzp, zza> implements zzdpm {
            private zza() {
                super(zzp.zzcdm);
            }

            /* synthetic */ zza(j50 j50Var) {
                this();
            }
        }

        public enum zzb implements zzdoe {
            VIDEO_ERROR_CODE_UNSPECIFIED(0),
            OPENGL_RENDERING_FAILED(1),
            CACHE_LOAD_FAILED(2),
            ANDROID_TARGET_API_TOO_LOW(3);


            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private static final zzdof<zzb> f16912j = new v50();
            private final int l;

            zzb(int i2) {
                this.l = i2;
            }

            public static zzdog g() {
                return w50.a;
            }

            public static zzb k(int i2) {
                if (i2 == 0) {
                    return VIDEO_ERROR_CODE_UNSPECIFIED;
                }
                if (i2 == 1) {
                    return OPENGL_RENDERING_FAILED;
                }
                if (i2 == 2) {
                    return CACHE_LOAD_FAILED;
                }
                if (i2 != 3) {
                    return null;
                }
                return ANDROID_TARGET_API_TOO_LOW;
            }

            @Override // com.google.android.gms.internal.ads.zzdoe
            public final int i() {
                return this.l;
            }
        }

        static {
            zzp zzpVar = new zzp();
            zzcdm = zzpVar;
            zzdob.t(zzp.class, zzpVar);
        }

        private zzp() {
        }

        @Override // com.google.android.gms.internal.ads.zzdob
        protected final Object q(int i2, Object obj, Object obj2) {
            j50 j50Var = null;
            switch (j50.a[i2 - 1]) {
                case 1:
                    return new zzp();
                case 2:
                    return new zza(j50Var);
                case 3:
                    return zzdob.r(zzcdm, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f\u0000", new Object[]{"zzdj", "zzcdl", zzb.g()});
                case 4:
                    return zzcdm;
                case 5:
                    zzdpv<zzp> zzbVar = zzdv;
                    if (zzbVar == null) {
                        synchronized (zzp.class) {
                            zzbVar = zzdv;
                            if (zzbVar == null) {
                                zzbVar = new zzdob.zzb<>(zzcdm);
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

    public static final class zzq extends zzdob<zzq, zza> implements zzdpm {
        private static final zzq zzcdv;
        private static volatile zzdpv<zzq> zzdv;
        private int zzcar = 1000;
        private zzp zzcdi;
        private int zzcds;
        private int zzcdt;
        private int zzcdu;
        private int zzdj;

        public static final class zza extends zzdob.zza<zzq, zza> implements zzdpm {
            private zza() {
                super(zzq.zzcdv);
            }

            /* synthetic */ zza(j50 j50Var) {
                this();
            }
        }

        static {
            zzq zzqVar = new zzq();
            zzcdv = zzqVar;
            zzdob.t(zzq.class, zzqVar);
        }

        private zzq() {
        }

        @Override // com.google.android.gms.internal.ads.zzdob
        protected final Object q(int i2, Object obj, Object obj2) {
            j50 j50Var = null;
            switch (j50.a[i2 - 1]) {
                case 1:
                    return new zzq();
                case 2:
                    return new zza(j50Var);
                case 3:
                    return zzdob.r(zzcdv, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004", new Object[]{"zzdj", "zzcar", zzwx.g(), "zzcdi", "zzcds", "zzcdt", "zzcdu"});
                case 4:
                    return zzcdv;
                case 5:
                    zzdpv<zzq> zzbVar = zzdv;
                    if (zzbVar == null) {
                        synchronized (zzq.class) {
                            zzbVar = zzdv;
                            if (zzbVar == null) {
                                zzbVar = new zzdob.zzb<>(zzcdv);
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

    public static final class zzr extends zzdob<zzr, zza> implements zzdpm {
        private static final zzr zzcdw;
        private static volatile zzdpv<zzr> zzdv;
        private int zzcar = 1000;
        private zzp zzcdi;
        private zzn zzcdj;
        private int zzdj;

        public static final class zza extends zzdob.zza<zzr, zza> implements zzdpm {
            private zza() {
                super(zzr.zzcdw);
            }

            /* synthetic */ zza(j50 j50Var) {
                this();
            }
        }

        static {
            zzr zzrVar = new zzr();
            zzcdw = zzrVar;
            zzdob.t(zzr.class, zzrVar);
        }

        private zzr() {
        }

        @Override // com.google.android.gms.internal.ads.zzdob
        protected final Object q(int i2, Object obj, Object obj2) {
            j50 j50Var = null;
            switch (j50.a[i2 - 1]) {
                case 1:
                    return new zzr();
                case 2:
                    return new zza(j50Var);
                case 3:
                    return zzdob.r(zzcdw, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzdj", "zzcar", zzwx.g(), "zzcdi", "zzcdj"});
                case 4:
                    return zzcdw;
                case 5:
                    zzdpv<zzr> zzbVar = zzdv;
                    if (zzbVar == null) {
                        synchronized (zzr.class) {
                            zzbVar = zzdv;
                            if (zzbVar == null) {
                                zzbVar = new zzdob.zzb<>(zzcdw);
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

    public static final class zzs extends zzdob<zzs, zza> implements zzdpm {
        private static final zzs zzcdy;
        private static volatile zzdpv<zzs> zzdv;
        private int zzcar = 1000;
        private zzp zzcdi;
        private int zzcds;
        private int zzcdt;
        private int zzcdu;
        private long zzcdx;
        private int zzdj;

        public static final class zza extends zzdob.zza<zzs, zza> implements zzdpm {
            private zza() {
                super(zzs.zzcdy);
            }

            /* synthetic */ zza(j50 j50Var) {
                this();
            }
        }

        static {
            zzs zzsVar = new zzs();
            zzcdy = zzsVar;
            zzdob.t(zzs.class, zzsVar);
        }

        private zzs() {
        }

        @Override // com.google.android.gms.internal.ads.zzdob
        protected final Object q(int i2, Object obj, Object obj2) {
            j50 j50Var = null;
            switch (j50.a[i2 - 1]) {
                case 1:
                    return new zzs();
                case 2:
                    return new zza(j50Var);
                case 3:
                    return zzdob.r(zzcdy, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004\u0006\u0003\u0005", new Object[]{"zzdj", "zzcar", zzwx.g(), "zzcdi", "zzcds", "zzcdt", "zzcdu", "zzcdx"});
                case 4:
                    return zzcdy;
                case 5:
                    zzdpv<zzs> zzbVar = zzdv;
                    if (zzbVar == null) {
                        synchronized (zzs.class) {
                            zzbVar = zzdv;
                            if (zzbVar == null) {
                                zzbVar = new zzdob.zzb<>(zzcdy);
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

    public static final class zzt extends zzdob<zzt, zza> implements zzdpm {
        private static final zzt zzcdz;
        private static volatile zzdpv<zzt> zzdv;
        private int zzcar = 1000;
        private zzp zzcdi;
        private zzn zzcdj;
        private int zzdj;

        public static final class zza extends zzdob.zza<zzt, zza> implements zzdpm {
            private zza() {
                super(zzt.zzcdz);
            }

            /* synthetic */ zza(j50 j50Var) {
                this();
            }
        }

        static {
            zzt zztVar = new zzt();
            zzcdz = zztVar;
            zzdob.t(zzt.class, zztVar);
        }

        private zzt() {
        }

        @Override // com.google.android.gms.internal.ads.zzdob
        protected final Object q(int i2, Object obj, Object obj2) {
            j50 j50Var = null;
            switch (j50.a[i2 - 1]) {
                case 1:
                    return new zzt();
                case 2:
                    return new zza(j50Var);
                case 3:
                    return zzdob.r(zzcdz, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzdj", "zzcar", zzwx.g(), "zzcdi", "zzcdj"});
                case 4:
                    return zzcdz;
                case 5:
                    zzdpv<zzt> zzbVar = zzdv;
                    if (zzbVar == null) {
                        synchronized (zzt.class) {
                            zzbVar = zzdv;
                            if (zzbVar == null) {
                                zzbVar = new zzdob.zzb<>(zzcdz);
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

    public static final class zzu extends zzdob<zzu, zza> implements zzdpm {
        private static final zzu zzcea;
        private static volatile zzdpv<zzu> zzdv;
        private int zzcar = 1000;
        private zzp zzcdi;
        private int zzdj;

        public static final class zza extends zzdob.zza<zzu, zza> implements zzdpm {
            private zza() {
                super(zzu.zzcea);
            }

            /* synthetic */ zza(j50 j50Var) {
                this();
            }
        }

        static {
            zzu zzuVar = new zzu();
            zzcea = zzuVar;
            zzdob.t(zzu.class, zzuVar);
        }

        private zzu() {
        }

        @Override // com.google.android.gms.internal.ads.zzdob
        protected final Object q(int i2, Object obj, Object obj2) {
            j50 j50Var = null;
            switch (j50.a[i2 - 1]) {
                case 1:
                    return new zzu();
                case 2:
                    return new zza(j50Var);
                case 3:
                    return zzdob.r(zzcea, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001", new Object[]{"zzdj", "zzcar", zzwx.g(), "zzcdi"});
                case 4:
                    return zzcea;
                case 5:
                    zzdpv<zzu> zzbVar = zzdv;
                    if (zzbVar == null) {
                        synchronized (zzu.class) {
                            zzbVar = zzdv;
                            if (zzbVar == null) {
                                zzbVar = new zzdob.zzb<>(zzcea);
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

    public static final class zzv extends zzdob<zzv, zza> implements zzdpm {
        private static final zzv zzced;
        private static volatile zzdpv<zzv> zzdv;
        private boolean zzceb;
        private int zzcec;
        private int zzdj;

        public static final class zza extends zzdob.zza<zzv, zza> implements zzdpm {
            private zza() {
                super(zzv.zzced);
            }

            public final zza u(int i2) {
                p();
                ((zzv) this.f16019g).z(i2);
                return this;
            }

            public final boolean v() {
                return ((zzv) this.f16019g).A();
            }

            public final zza w(boolean z) {
                p();
                ((zzv) this.f16019g).D(z);
                return this;
            }

            /* synthetic */ zza(j50 j50Var) {
                this();
            }
        }

        static {
            zzv zzvVar = new zzv();
            zzced = zzvVar;
            zzdob.t(zzv.class, zzvVar);
        }

        private zzv() {
        }

        public static zza B() {
            return (zza) ((zzdob.zza) zzced.q(zzdob.zze.f16025e, null, null));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void D(boolean z) {
            this.zzdj |= 1;
            this.zzceb = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void z(int i2) {
            this.zzdj |= 2;
            this.zzcec = i2;
        }

        public final boolean A() {
            return this.zzceb;
        }

        @Override // com.google.android.gms.internal.ads.zzdob
        protected final Object q(int i2, Object obj, Object obj2) {
            j50 j50Var = null;
            switch (j50.a[i2 - 1]) {
                case 1:
                    return new zzv();
                case 2:
                    return new zza(j50Var);
                case 3:
                    return zzdob.r(zzced, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0000\u0002\u0004\u0001", new Object[]{"zzdj", "zzceb", "zzcec"});
                case 4:
                    return zzced;
                case 5:
                    zzdpv<zzv> zzbVar = zzdv;
                    if (zzbVar == null) {
                        synchronized (zzv.class) {
                            zzbVar = zzdv;
                            if (zzbVar == null) {
                                zzbVar = new zzdob.zzb<>(zzced);
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
}
