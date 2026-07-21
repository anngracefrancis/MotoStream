package com.google.android.gms.internal.measurement;

import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbj {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
    public static final class zza extends zzfd<zza, C0189zza> implements zzgq {
        private static final zza zzi;
        private static volatile zzgx<zza> zzj;
        private int zzc;
        private int zzd;
        private zzfl<zze> zze = zzfd.A();
        private zzfl<zzb> zzf = zzfd.A();
        private boolean zzg;
        private boolean zzh;

        /* JADX INFO: renamed from: com.google.android.gms.internal.measurement.zzbj$zza$zza, reason: collision with other inner class name */
        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
        public static final class C0189zza extends zzfd.zzb<zza, C0189zza> implements zzgq {
            private C0189zza() {
                super(zza.zzi);
            }

            public final C0189zza A(int i2, zzb.zza zzaVar) {
                t();
                ((zza) this.f17395g).C(i2, zzaVar);
                return this;
            }

            public final C0189zza B(int i2, zze.zza zzaVar) {
                t();
                ((zza) this.f17395g).D(i2, zzaVar);
                return this;
            }

            public final zze C(int i2) {
                return ((zza) this.f17395g).B(i2);
            }

            public final int D() {
                return ((zza) this.f17395g).M();
            }

            public final zzb E(int i2) {
                return ((zza) this.f17395g).I(i2);
            }

            public final int w() {
                return ((zza) this.f17395g).K();
            }

            /* synthetic */ C0189zza(a0 a0Var) {
                this();
            }
        }

        static {
            zza zzaVar = new zza();
            zzi = zzaVar;
            zzfd.s(zza.class, zzaVar);
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void C(int i2, zzb.zza zzaVar) {
            if (!this.zzf.a()) {
                this.zzf = zzfd.n(this.zzf);
            }
            this.zzf.set(i2, (zzb) ((zzfd) zzaVar.y()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void D(int i2, zze.zza zzaVar) {
            if (!this.zze.a()) {
                this.zze = zzfd.n(this.zze);
            }
            this.zze.set(i2, (zze) ((zzfd) zzaVar.y()));
        }

        public final zze B(int i2) {
            return this.zze.get(i2);
        }

        public final boolean G() {
            return (this.zzc & 1) != 0;
        }

        public final int H() {
            return this.zzd;
        }

        public final zzb I(int i2) {
            return this.zzf.get(i2);
        }

        public final List<zze> J() {
            return this.zze;
        }

        public final int K() {
            return this.zze.size();
        }

        public final List<zzb> L() {
            return this.zzf;
        }

        public final int M() {
            return this.zzf.size();
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        protected final Object p(int i2, Object obj, Object obj2) {
            a0 a0Var = null;
            switch (a0.a[i2 - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0189zza(a0Var);
                case 3:
                    return zzfd.q(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001\u0004\u0000\u0002\u001b\u0003\u001b\u0004\u0007\u0001\u0005\u0007\u0002", new Object[]{"zzc", "zzd", "zze", zze.class, "zzf", zzb.class, "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzgx<zza> zzaVar = zzj;
                    if (zzaVar == null) {
                        synchronized (zza.class) {
                            zzaVar = zzj;
                            if (zzaVar == null) {
                                zzaVar = new zzfd.zza<>(zzi);
                                zzj = zzaVar;
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
        private int zzd;
        private String zze = HttpUrl.FRAGMENT_ENCODE_SET;
        private zzfl<zzc> zzf = zzfd.A();
        private boolean zzg;
        private zzd zzh;
        private boolean zzi;
        private boolean zzj;
        private boolean zzk;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
        public static final class zza extends zzfd.zzb<zzb, zza> implements zzgq {
            private zza() {
                super(zzb.zzl);
            }

            public final zza A(String str) {
                t();
                ((zzb) this.f17395g).F(str);
                return this;
            }

            public final zzc B(int i2) {
                return ((zzb) this.f17395g).B(i2);
            }

            public final String C() {
                return ((zzb) this.f17395g).I();
            }

            public final int D() {
                return ((zzb) this.f17395g).K();
            }

            public final zza w(int i2, zzc zzcVar) {
                t();
                ((zzb) this.f17395g).C(i2, zzcVar);
                return this;
            }

            /* synthetic */ zza(a0 a0Var) {
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
        public final void C(int i2, zzc zzcVar) {
            zzcVar.getClass();
            if (!this.zzf.a()) {
                this.zzf = zzfd.n(this.zzf);
            }
            this.zzf.set(i2, zzcVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void F(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        public static zza R() {
            return zzl.u();
        }

        public final zzc B(int i2) {
            return this.zzf.get(i2);
        }

        public final boolean G() {
            return (this.zzc & 1) != 0;
        }

        public final int H() {
            return this.zzd;
        }

        public final String I() {
            return this.zze;
        }

        public final List<zzc> J() {
            return this.zzf;
        }

        public final int K() {
            return this.zzf.size();
        }

        public final boolean L() {
            return (this.zzc & 8) != 0;
        }

        public final zzd M() {
            zzd zzdVar = this.zzh;
            return zzdVar == null ? zzd.L() : zzdVar;
        }

        public final boolean N() {
            return this.zzi;
        }

        public final boolean O() {
            return this.zzj;
        }

        public final boolean P() {
            return (this.zzc & 64) != 0;
        }

        public final boolean Q() {
            return this.zzk;
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        protected final Object p(int i2, Object obj, Object obj2) {
            a0 a0Var = null;
            switch (a0.a[i2 - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(a0Var);
                case 3:
                    return zzfd.q(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\u001b\u0004\u0007\u0002\u0005\t\u0003\u0006\u0007\u0004\u0007\u0007\u0005\b\u0007\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", zzc.class, "zzg", "zzh", "zzi", "zzj", "zzk"});
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
        private static final zzc zzh;
        private static volatile zzgx<zzc> zzi;
        private int zzc;
        private zzf zzd;
        private zzd zze;
        private boolean zzf;
        private String zzg = HttpUrl.FRAGMENT_ENCODE_SET;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
        public static final class zza extends zzfd.zzb<zzc, zza> implements zzgq {
            private zza() {
                super(zzc.zzh);
            }

            public final zza w(String str) {
                t();
                ((zzc) this.f17395g).C(str);
                return this;
            }

            /* synthetic */ zza(a0 a0Var) {
                this();
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzh = zzcVar;
            zzfd.s(zzc.class, zzcVar);
        }

        private zzc() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void C(String str) {
            str.getClass();
            this.zzc |= 8;
            this.zzg = str;
        }

        public static zzc K() {
            return zzh;
        }

        public final boolean D() {
            return (this.zzc & 1) != 0;
        }

        public final zzf E() {
            zzf zzfVar = this.zzd;
            return zzfVar == null ? zzf.J() : zzfVar;
        }

        public final boolean F() {
            return (this.zzc & 2) != 0;
        }

        public final zzd G() {
            zzd zzdVar = this.zze;
            return zzdVar == null ? zzd.L() : zzdVar;
        }

        public final boolean H() {
            return (this.zzc & 4) != 0;
        }

        public final boolean I() {
            return this.zzf;
        }

        public final String J() {
            return this.zzg;
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        protected final Object p(int i2, Object obj, Object obj2) {
            a0 a0Var = null;
            switch (a0.a[i2 - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(a0Var);
                case 3:
                    return zzfd.q(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\u0007\u0002\u0004\b\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzgx<zzc> zzaVar = zzi;
                    if (zzaVar == null) {
                        synchronized (zzc.class) {
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
    public static final class zzd extends zzfd<zzd, zzb> implements zzgq {
        private static final zzd zzi;
        private static volatile zzgx<zzd> zzj;
        private int zzc;
        private int zzd;
        private boolean zze;
        private String zzf = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzg = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzh = HttpUrl.FRAGMENT_ENCODE_SET;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
        public enum zza implements zzfi {
            UNKNOWN_COMPARISON_TYPE(0),
            LESS_THAN(1),
            GREATER_THAN(2),
            EQUAL(3),
            BETWEEN(4);


            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private static final zzfh<zza> f17312k = new c0();
            private final int m;

            zza(int i2) {
                this.m = i2;
            }

            public static zza g(int i2) {
                if (i2 == 0) {
                    return UNKNOWN_COMPARISON_TYPE;
                }
                if (i2 == 1) {
                    return LESS_THAN;
                }
                if (i2 == 2) {
                    return GREATER_THAN;
                }
                if (i2 == 3) {
                    return EQUAL;
                }
                if (i2 != 4) {
                    return null;
                }
                return BETWEEN;
            }

            public static zzfk k() {
                return b0.a;
            }

            @Override // com.google.android.gms.internal.measurement.zzfi
            public final int a() {
                return this.m;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.m + " name=" + name() + '>';
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
        public static final class zzb extends zzfd.zzb<zzd, zzb> implements zzgq {
            private zzb() {
                super(zzd.zzi);
            }

            /* synthetic */ zzb(a0 a0Var) {
                this();
            }
        }

        static {
            zzd zzdVar = new zzd();
            zzi = zzdVar;
            zzfd.s(zzd.class, zzdVar);
        }

        private zzd() {
        }

        public static zzd L() {
            return zzi;
        }

        public final boolean B() {
            return (this.zzc & 1) != 0;
        }

        public final zza C() {
            zza zzaVarG = zza.g(this.zzd);
            return zzaVarG == null ? zza.UNKNOWN_COMPARISON_TYPE : zzaVarG;
        }

        public final boolean D() {
            return (this.zzc & 2) != 0;
        }

        public final boolean E() {
            return this.zze;
        }

        public final boolean F() {
            return (this.zzc & 4) != 0;
        }

        public final String G() {
            return this.zzf;
        }

        public final boolean H() {
            return (this.zzc & 8) != 0;
        }

        public final String I() {
            return this.zzg;
        }

        public final boolean J() {
            return (this.zzc & 16) != 0;
        }

        public final String K() {
            return this.zzh;
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        protected final Object p(int i2, Object obj, Object obj2) {
            a0 a0Var = null;
            switch (a0.a[i2 - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zzb(a0Var);
                case 3:
                    return zzfd.q(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0000\u0002\u0007\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004", new Object[]{"zzc", "zzd", zza.k(), "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzgx<zzd> zzaVar = zzj;
                    if (zzaVar == null) {
                        synchronized (zzd.class) {
                            zzaVar = zzj;
                            if (zzaVar == null) {
                                zzaVar = new zzfd.zza<>(zzi);
                                zzj = zzaVar;
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
    public static final class zze extends zzfd<zze, zza> implements zzgq {
        private static final zze zzj;
        private static volatile zzgx<zze> zzk;
        private int zzc;
        private int zzd;
        private String zze = HttpUrl.FRAGMENT_ENCODE_SET;
        private zzc zzf;
        private boolean zzg;
        private boolean zzh;
        private boolean zzi;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
        public static final class zza extends zzfd.zzb<zze, zza> implements zzgq {
            private zza() {
                super(zze.zzj);
            }

            public final zza w(String str) {
                t();
                ((zze) this.f17395g).C(str);
                return this;
            }

            /* synthetic */ zza(a0 a0Var) {
                this();
            }
        }

        static {
            zze zzeVar = new zze();
            zzj = zzeVar;
            zzfd.s(zze.class, zzeVar);
        }

        private zze() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void C(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        public static zza L() {
            return zzj.u();
        }

        public final boolean D() {
            return (this.zzc & 1) != 0;
        }

        public final int E() {
            return this.zzd;
        }

        public final String F() {
            return this.zze;
        }

        public final zzc G() {
            zzc zzcVar = this.zzf;
            return zzcVar == null ? zzc.K() : zzcVar;
        }

        public final boolean H() {
            return this.zzg;
        }

        public final boolean I() {
            return this.zzh;
        }

        public final boolean J() {
            return (this.zzc & 32) != 0;
        }

        public final boolean K() {
            return this.zzi;
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        protected final Object p(int i2, Object obj, Object obj2) {
            a0 a0Var = null;
            switch (a0.a[i2 - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(a0Var);
                case 3:
                    return zzfd.q(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\t\u0002\u0004\u0007\u0003\u0005\u0007\u0004\u0006\u0007\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzgx<zze> zzaVar = zzk;
                    if (zzaVar == null) {
                        synchronized (zze.class) {
                            zzaVar = zzk;
                            if (zzaVar == null) {
                                zzaVar = new zzfd.zza<>(zzj);
                                zzk = zzaVar;
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
    public static final class zzf extends zzfd<zzf, zza> implements zzgq {
        private static final zzf zzh;
        private static volatile zzgx<zzf> zzi;
        private int zzc;
        private int zzd;
        private boolean zzf;
        private String zze = HttpUrl.FRAGMENT_ENCODE_SET;
        private zzfl<String> zzg = zzfd.A();

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
        public static final class zza extends zzfd.zzb<zzf, zza> implements zzgq {
            private zza() {
                super(zzf.zzh);
            }

            /* synthetic */ zza(a0 a0Var) {
                this();
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
        public enum zzb implements zzfi {
            UNKNOWN_MATCH_TYPE(0),
            REGEXP(1),
            BEGINS_WITH(2),
            ENDS_WITH(3),
            PARTIAL(4),
            EXACT(5),
            IN_LIST(6);

            private static final zzfh<zzb> m = new d0();
            private final int o;

            zzb(int i2) {
                this.o = i2;
            }

            public static zzb g(int i2) {
                switch (i2) {
                    case 0:
                        return UNKNOWN_MATCH_TYPE;
                    case 1:
                        return REGEXP;
                    case 2:
                        return BEGINS_WITH;
                    case 3:
                        return ENDS_WITH;
                    case 4:
                        return PARTIAL;
                    case 5:
                        return EXACT;
                    case 6:
                        return IN_LIST;
                    default:
                        return null;
                }
            }

            public static zzfk k() {
                return e0.a;
            }

            @Override // com.google.android.gms.internal.measurement.zzfi
            public final int a() {
                return this.o;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.o + " name=" + name() + '>';
            }
        }

        static {
            zzf zzfVar = new zzf();
            zzh = zzfVar;
            zzfd.s(zzf.class, zzfVar);
        }

        private zzf() {
        }

        public static zzf J() {
            return zzh;
        }

        public final boolean B() {
            return (this.zzc & 1) != 0;
        }

        public final zzb C() {
            zzb zzbVarG = zzb.g(this.zzd);
            return zzbVarG == null ? zzb.UNKNOWN_MATCH_TYPE : zzbVarG;
        }

        public final boolean D() {
            return (this.zzc & 2) != 0;
        }

        public final String E() {
            return this.zze;
        }

        public final boolean F() {
            return (this.zzc & 4) != 0;
        }

        public final boolean G() {
            return this.zzf;
        }

        public final List<String> H() {
            return this.zzg;
        }

        public final int I() {
            return this.zzg.size();
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        protected final Object p(int i2, Object obj, Object obj2) {
            a0 a0Var = null;
            switch (a0.a[i2 - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(a0Var);
                case 3:
                    return zzfd.q(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\f\u0000\u0002\b\u0001\u0003\u0007\u0002\u0004\u001a", new Object[]{"zzc", "zzd", zzb.k(), "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzgx<zzf> zzaVar = zzi;
                    if (zzaVar == null) {
                        synchronized (zzf.class) {
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
}
