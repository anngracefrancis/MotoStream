package com.google.android.gms.internal.ads;

import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbk {

    public static final class zza extends zzdob<zza, C0175zza> implements zzdpm {
        private static volatile zzdpv<zza> zzdv;
        private static final zza zzdy;
        private int zzdj;
        private zzb zzdw;
        private zzc zzdx;

        /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbk$zza$zza, reason: collision with other inner class name */
        public static final class C0175zza extends zzdob.zza<zza, C0175zza> implements zzdpm {
            private C0175zza() {
                super(zza.zzdy);
            }

            /* synthetic */ C0175zza(oc ocVar) {
                this();
            }
        }

        static {
            zza zzaVar = new zza();
            zzdy = zzaVar;
            zzdob.t(zza.class, zzaVar);
        }

        private zza() {
        }

        public static zza x(byte[] bArr, zzdno zzdnoVar) throws zzdok {
            return (zza) zzdob.p(zzdy, bArr, zzdnoVar);
        }

        public final boolean A() {
            return (this.zzdj & 2) == 2;
        }

        public final zzc B() {
            zzc zzcVar = this.zzdx;
            return zzcVar == null ? zzc.z() : zzcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzdob
        protected final Object q(int i2, Object obj, Object obj2) {
            oc ocVar = null;
            switch (oc.a[i2 - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0175zza(ocVar);
                case 3:
                    return zzdob.r(zzdy, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001", new Object[]{"zzdj", "zzdw", "zzdx"});
                case 4:
                    return zzdy;
                case 5:
                    zzdpv<zza> zzbVar = zzdv;
                    if (zzbVar == null) {
                        synchronized (zza.class) {
                            zzbVar = zzdv;
                            if (zzbVar == null) {
                                zzbVar = new zzdob.zzb<>(zzdy);
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

        public final boolean y() {
            return (this.zzdj & 1) == 1;
        }

        public final zzb z() {
            zzb zzbVar = this.zzdw;
            return zzbVar == null ? zzb.x() : zzbVar;
        }
    }

    public static final class zzb extends zzdob<zzb, zza> implements zzdpm {
        private static volatile zzdpv<zzb> zzdv;
        private static final zzb zzea;
        private int zzdj;
        private int zzdz = 2;

        public static final class zza extends zzdob.zza<zzb, zza> implements zzdpm {
            private zza() {
                super(zzb.zzea);
            }

            /* synthetic */ zza(oc ocVar) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzea = zzbVar;
            zzdob.t(zzb.class, zzbVar);
        }

        private zzb() {
        }

        public static zzb x() {
            return zzea;
        }

        @Override // com.google.android.gms.internal.ads.zzdob
        protected final Object q(int i2, Object obj, Object obj2) {
            oc ocVar = null;
            switch (oc.a[i2 - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(ocVar);
                case 3:
                    return zzdob.r(zzea, "\u0001\u0001\u0000\u0001\u001b\u001b\u0001\u0000\u0000\u0000\u001b\f\u0000", new Object[]{"zzdj", "zzdz", zzbm.g()});
                case 4:
                    return zzea;
                case 5:
                    zzdpv<zzb> zzbVar = zzdv;
                    if (zzbVar == null) {
                        synchronized (zzb.class) {
                            zzbVar = zzdv;
                            if (zzbVar == null) {
                                zzbVar = new zzdob.zzb<>(zzea);
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

        public final zzbm z() {
            zzbm zzbmVarK = zzbm.k(this.zzdz);
            return zzbmVarK == null ? zzbm.ENUM_SIGNAL_SOURCE_ADSHIELD : zzbmVarK;
        }
    }

    public static final class zzc extends zzdob<zzc, zza> implements zzdpm {
        private static volatile zzdpv<zzc> zzdv;
        private static final zzc zzep;
        private int zzdj;
        private String zzej = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzek = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzel = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzem = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzen = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzeo = HttpUrl.FRAGMENT_ENCODE_SET;

        public static final class zza extends zzdob.zza<zzc, zza> implements zzdpm {
            private zza() {
                super(zzc.zzep);
            }

            /* synthetic */ zza(oc ocVar) {
                this();
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzep = zzcVar;
            zzdob.t(zzc.class, zzcVar);
        }

        private zzc() {
        }

        public static zzc z() {
            return zzep;
        }

        @Override // com.google.android.gms.internal.ads.zzdob
        protected final Object q(int i2, Object obj, Object obj2) {
            oc ocVar = null;
            switch (oc.a[i2 - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(ocVar);
                case 3:
                    return zzdob.r(zzep, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005", new Object[]{"zzdj", "zzej", "zzek", "zzel", "zzem", "zzen", "zzeo"});
                case 4:
                    return zzep;
                case 5:
                    zzdpv<zzc> zzbVar = zzdv;
                    if (zzbVar == null) {
                        synchronized (zzc.class) {
                            zzbVar = zzdv;
                            if (zzbVar == null) {
                                zzbVar = new zzdob.zzb<>(zzep);
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

        public final String x() {
            return this.zzej;
        }

        public final String y() {
            return this.zzeo;
        }
    }
}
