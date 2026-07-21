package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbo {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
    public static final class zza extends zzfd<zza, C0190zza> implements zzgq {
        private static final zza zzh;
        private static volatile zzgx<zza> zzi;
        private int zzc;
        private String zzd = HttpUrl.FRAGMENT_ENCODE_SET;
        private boolean zze;
        private boolean zzf;
        private int zzg;

        /* JADX INFO: renamed from: com.google.android.gms.internal.measurement.zzbo$zza$zza, reason: collision with other inner class name */
        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
        public static final class C0190zza extends zzfd.zzb<zza, C0190zza> implements zzgq {
            private C0190zza() {
                super(zza.zzh);
            }

            public final String A() {
                return ((zza) this.f17395g).B();
            }

            public final boolean B() {
                return ((zza) this.f17395g).E();
            }

            public final boolean C() {
                return ((zza) this.f17395g).F();
            }

            public final boolean D() {
                return ((zza) this.f17395g).G();
            }

            public final int E() {
                return ((zza) this.f17395g).H();
            }

            public final C0190zza w(String str) {
                t();
                ((zza) this.f17395g).D(str);
                return this;
            }

            /* synthetic */ C0190zza(f0 f0Var) {
                this();
            }
        }

        static {
            zza zzaVar = new zza();
            zzh = zzaVar;
            zzfd.s(zza.class, zzaVar);
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void D(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        public final String B() {
            return this.zzd;
        }

        public final boolean E() {
            return this.zze;
        }

        public final boolean F() {
            return this.zzf;
        }

        public final boolean G() {
            return (this.zzc & 8) != 0;
        }

        public final int H() {
            return this.zzg;
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        protected final Object p(int i2, Object obj, Object obj2) {
            f0 f0Var = null;
            switch (f0.a[i2 - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0190zza(f0Var);
                case 3:
                    return zzfd.q(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\b\u0000\u0002\u0007\u0001\u0003\u0007\u0002\u0004\u0004\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzgx<zza> zzaVar = zzi;
                    if (zzaVar == null) {
                        synchronized (zza.class) {
                            zzaVar = zzi;
                            if (zzaVar == null) {
                                zzaVar = new zzfd.zza<>(zzh);
                                zzi = zzaVar;
                            }
                            break;
                        }
                    }
                    return zzaVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
    public static final class zzb extends zzfd<zzb, zza> implements zzgq {
        private static final zzb zzl;
        private static volatile zzgx<zzb> zzm;
        private int zzc;
        private long zzd;
        private int zzf;
        private boolean zzk;
        private String zze = HttpUrl.FRAGMENT_ENCODE_SET;
        private zzfl<zzc> zzg = zzfd.A();
        private zzfl<zza> zzh = zzfd.A();
        private zzfl<zzbj.zza> zzi = zzfd.A();
        private String zzj = HttpUrl.FRAGMENT_ENCODE_SET;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
        public static final class zza extends zzfd.zzb<zzb, zza> implements zzgq {
            private zza() {
                super(zzb.zzl);
            }

            public final zza A(int i2) {
                return ((zzb) this.f17395g).B(i2);
            }

            public final zza B(int i2, zza.C0190zza c0190zza) {
                t();
                ((zzb) this.f17395g).C(i2, c0190zza);
                return this;
            }

            public final List<zzbj.zza> C() {
                return Collections.unmodifiableList(((zzb) this.f17395g).L());
            }

            public final zza D() {
                t();
                ((zzb) this.f17395g).Q();
                return this;
            }

            public final int w() {
                return ((zzb) this.f17395g).K();
            }

            /* synthetic */ zza(f0 f0Var) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzl = zzbVar;
            zzfd.s(zzb.class, zzbVar);
        }

        private zzb() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void C(int i2, zza.C0190zza c0190zza) {
            if (!this.zzh.a()) {
                this.zzh = zzfd.n(this.zzh);
            }
            this.zzh.set(i2, (zza) ((zzfd) c0190zza.y()));
        }

        public static zza N() {
            return zzl.u();
        }

        public static zzb O() {
            return zzl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void Q() {
            this.zzi = zzfd.A();
        }

        public final zza B(int i2) {
            return this.zzh.get(i2);
        }

        public final boolean F() {
            return (this.zzc & 1) != 0;
        }

        public final long G() {
            return this.zzd;
        }

        public final boolean H() {
            return (this.zzc & 2) != 0;
        }

        public final String I() {
            return this.zze;
        }

        public final List<zzc> J() {
            return this.zzg;
        }

        public final int K() {
            return this.zzh.size();
        }

        public final List<zzbj.zza> L() {
            return this.zzi;
        }

        public final boolean M() {
            return this.zzk;
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        protected final Object p(int i2, Object obj, Object obj2) {
            f0 f0Var = null;
            switch (f0.a[i2 - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(f0Var);
                case 3:
                    return zzfd.q(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0003\u0000\u0001\u0002\u0000\u0002\b\u0001\u0003\u0004\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007\b\u0003\b\u0007\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zzc.class, "zzh", zza.class, "zzi", zzbj.zza.class, "zzj", "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzgx<zzb> zzaVar = zzm;
                    if (zzaVar == null) {
                        synchronized (zzb.class) {
                            zzaVar = zzm;
                            if (zzaVar == null) {
                                zzaVar = new zzfd.zza<>(zzl);
                                zzm = zzaVar;
                            }
                            break;
                        }
                    }
                    return zzaVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
    public static final class zzc extends zzfd<zzc, zza> implements zzgq {
        private static final zzc zzf;
        private static volatile zzgx<zzc> zzg;
        private int zzc;
        private String zzd = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zze = HttpUrl.FRAGMENT_ENCODE_SET;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
        public static final class zza extends zzfd.zzb<zzc, zza> implements zzgq {
            private zza() {
                super(zzc.zzf);
            }

            /* synthetic */ zza(f0 f0Var) {
                this();
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzf = zzcVar;
            zzfd.s(zzc.class, zzcVar);
        }

        private zzc() {
        }

        public final String B() {
            return this.zzd;
        }

        public final String C() {
            return this.zze;
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        protected final Object p(int i2, Object obj, Object obj2) {
            f0 f0Var = null;
            switch (f0.a[i2 - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(f0Var);
                case 3:
                    return zzfd.q(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgx<zzc> zzaVar = zzg;
                    if (zzaVar == null) {
                        synchronized (zzc.class) {
                            zzaVar = zzg;
                            if (zzaVar == null) {
                                zzaVar = new zzfd.zza<>(zzf);
                                zzg = zzaVar;
                            }
                            break;
                        }
                    }
                    return zzaVar;
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
