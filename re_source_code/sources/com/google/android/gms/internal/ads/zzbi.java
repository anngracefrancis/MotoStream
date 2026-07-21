package com.google.android.gms.internal.ads;

import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbi {

    public static final class zza extends zzdob<zza, C0174zza> implements zzdpm {
        private static final zza zzdu;
        private static volatile zzdpv<zza> zzdv;
        private int zzdj;
        private long zzdl;
        private long zzdp;
        private long zzdq;
        private long zzds;
        private String zzdk = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzdm = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzdn = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzdo = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzdr = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzdt = HttpUrl.FRAGMENT_ENCODE_SET;

        /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbi$zza$zza, reason: collision with other inner class name */
        public static final class C0174zza extends zzdob.zza<zza, C0174zza> implements zzdpm {
            private C0174zza() {
                super(zza.zzdu);
            }

            public final C0174zza A(String str) {
                p();
                ((zza) this.f16019g).E(str);
                return this;
            }

            public final C0174zza u(long j2) {
                p();
                ((zza) this.f16019g).A(j2);
                return this;
            }

            public final C0174zza v(String str) {
                p();
                ((zza) this.f16019g).C(str);
                return this;
            }

            public final C0174zza w(String str) {
                p();
                ((zza) this.f16019g).D(str);
                return this;
            }

            /* synthetic */ C0174zza(sb sbVar) {
                this();
            }
        }

        static {
            zza zzaVar = new zza();
            zzdu = zzaVar;
            zzdob.t(zza.class, zzaVar);
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void A(long j2) {
            this.zzdj |= 2;
            this.zzdl = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void C(String str) {
            str.getClass();
            this.zzdj |= 1;
            this.zzdk = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void D(String str) {
            str.getClass();
            this.zzdj |= 4;
            this.zzdm = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void E(String str) {
            str.getClass();
            this.zzdj |= 8;
            this.zzdn = str;
        }

        public static C0174zza F() {
            return (C0174zza) ((zzdob.zza) zzdu.q(zzdob.zze.f16025e, null, null));
        }

        @Override // com.google.android.gms.internal.ads.zzdob
        protected final Object q(int i2, Object obj, Object obj2) {
            sb sbVar = null;
            switch (sb.a[i2 - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0174zza(sbVar);
                case 3:
                    return zzdob.r(zzdu, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\u0002\u0005\u0007\u0002\u0006\b\b\u0007\t\u0002\b\n\b\t", new Object[]{"zzdj", "zzdk", "zzdl", "zzdm", "zzdn", "zzdo", "zzdp", "zzdq", "zzdr", "zzds", "zzdt"});
                case 4:
                    return zzdu;
                case 5:
                    zzdpv<zza> zzbVar = zzdv;
                    if (zzbVar == null) {
                        synchronized (zza.class) {
                            zzbVar = zzdv;
                            if (zzbVar == null) {
                                zzbVar = new zzdob.zzb<>(zzdu);
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
