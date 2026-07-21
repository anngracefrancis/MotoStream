package com.google.android.gms.internal.measurement;

import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.file.CacheHelper;
import com.google.android.gms.ads.AdRequest;
import java.util.Collections;
import java.util.List;
import okhttp3.HttpUrl;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbr {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
    public static final class zza extends zzfd<zza, C0191zza> implements zzgq {
        private static final zza zzh;
        private static volatile zzgx<zza> zzi;
        private int zzc;
        private int zzd;
        private zzi zze;
        private zzi zzf;
        private boolean zzg;

        /* JADX INFO: renamed from: com.google.android.gms.internal.measurement.zzbr$zza$zza, reason: collision with other inner class name */
        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
        public static final class C0191zza extends zzfd.zzb<zza, C0191zza> implements zzgq {
            private C0191zza() {
                super(zza.zzh);
            }

            public final C0191zza A(zzi.zza zzaVar) {
                t();
                ((zza) this.f17395g).G(zzaVar);
                return this;
            }

            public final C0191zza B(zzi zziVar) {
                t();
                ((zza) this.f17395g).H(zziVar);
                return this;
            }

            public final C0191zza C(boolean z) {
                t();
                ((zza) this.f17395g).I(z);
                return this;
            }

            public final boolean D() {
                return ((zza) this.f17395g).M();
            }

            public final zzi E() {
                return ((zza) this.f17395g).N();
            }

            public final C0191zza w(int i2) {
                t();
                ((zza) this.f17395g).B(i2);
                return this;
            }

            /* synthetic */ C0191zza(g0 g0Var) {
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
        public final void B(int i2) {
            this.zzc |= 1;
            this.zzd = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void G(zzi.zza zzaVar) {
            this.zze = (zzi) ((zzfd) zzaVar.y());
            this.zzc |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void H(zzi zziVar) {
            zziVar.getClass();
            this.zzf = zziVar;
            this.zzc |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void I(boolean z) {
            this.zzc |= 8;
            this.zzg = z;
        }

        public static C0191zza Q() {
            return zzh.u();
        }

        public final boolean J() {
            return (this.zzc & 1) != 0;
        }

        public final int K() {
            return this.zzd;
        }

        public final zzi L() {
            zzi zziVar = this.zze;
            return zziVar == null ? zzi.b0() : zziVar;
        }

        public final boolean M() {
            return (this.zzc & 4) != 0;
        }

        public final zzi N() {
            zzi zziVar = this.zzf;
            return zziVar == null ? zzi.b0() : zziVar;
        }

        public final boolean O() {
            return (this.zzc & 8) != 0;
        }

        public final boolean P() {
            return this.zzg;
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        protected final Object p(int i2, Object obj, Object obj2) {
            g0 g0Var = null;
            switch (g0.a[i2 - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0191zza(g0Var);
                case 3:
                    return zzfd.q(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0000\u0002\t\u0001\u0003\t\u0002\u0004\u0007\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
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
        private static final zzb zzf;
        private static volatile zzgx<zzb> zzg;
        private int zzc;
        private int zzd;
        private long zze;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
        public static final class zza extends zzfd.zzb<zzb, zza> implements zzgq {
            private zza() {
                super(zzb.zzf);
            }

            public final zza A(long j2) {
                t();
                ((zzb) this.f17395g).C(j2);
                return this;
            }

            public final zza w(int i2) {
                t();
                ((zzb) this.f17395g).B(i2);
                return this;
            }

            /* synthetic */ zza(g0 g0Var) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzf = zzbVar;
            zzfd.s(zzb.class, zzbVar);
        }

        private zzb() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void B(int i2) {
            this.zzc |= 1;
            this.zzd = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void C(long j2) {
            this.zzc |= 2;
            this.zze = j2;
        }

        public static zza J() {
            return zzf.u();
        }

        public final boolean F() {
            return (this.zzc & 1) != 0;
        }

        public final int G() {
            return this.zzd;
        }

        public final boolean H() {
            return (this.zzc & 2) != 0;
        }

        public final long I() {
            return this.zze;
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        protected final Object p(int i2, Object obj, Object obj2) {
            g0 g0Var = null;
            switch (g0.a[i2 - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(g0Var);
                case 3:
                    return zzfd.q(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0002\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgx<zzb> zzaVar = zzg;
                    if (zzaVar == null) {
                        synchronized (zzb.class) {
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

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
    public static final class zzc extends zzfd<zzc, zza> implements zzgq {
        private static final zzc zzi;
        private static volatile zzgx<zzc> zzj;
        private int zzc;
        private zzfl<zze> zzd = zzfd.A();
        private String zze = HttpUrl.FRAGMENT_ENCODE_SET;
        private long zzf;
        private long zzg;
        private int zzh;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
        public static final class zza extends zzfd.zzb<zzc, zza> implements zzgq {
            private zza() {
                super(zzc.zzi);
            }

            public final zza A(int i2, zze zzeVar) {
                t();
                ((zzc) this.f17395g).E(i2, zzeVar);
                return this;
            }

            public final zza B(long j2) {
                t();
                ((zzc) this.f17395g).F(j2);
                return this;
            }

            public final zza C(zze.zza zzaVar) {
                t();
                ((zzc) this.f17395g).N(zzaVar);
                return this;
            }

            public final zza D(zze zzeVar) {
                t();
                ((zzc) this.f17395g).O(zzeVar);
                return this;
            }

            public final zza E(String str) {
                t();
                ((zzc) this.f17395g).P(str);
                return this;
            }

            public final zze F(int i2) {
                return ((zzc) this.f17395g).B(i2);
            }

            public final List<zze> G() {
                return Collections.unmodifiableList(((zzc) this.f17395g).C());
            }

            public final int H() {
                return ((zzc) this.f17395g).Q();
            }

            public final zza I(int i2) {
                t();
                ((zzc) this.f17395g).R(i2);
                return this;
            }

            public final zza J(long j2) {
                t();
                ((zzc) this.f17395g).S(j2);
                return this;
            }

            public final String K() {
                return ((zzc) this.f17395g).U();
            }

            public final boolean L() {
                return ((zzc) this.f17395g).V();
            }

            public final long M() {
                return ((zzc) this.f17395g).W();
            }

            public final long N() {
                return ((zzc) this.f17395g).Z();
            }

            public final zza w(int i2, zze.zza zzaVar) {
                t();
                ((zzc) this.f17395g).D(i2, zzaVar);
                return this;
            }

            /* synthetic */ zza(g0 g0Var) {
                this();
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzi = zzcVar;
            zzfd.s(zzc.class, zzcVar);
        }

        private zzc() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void D(int i2, zze.zza zzaVar) {
            e0();
            this.zzd.set(i2, (zze) ((zzfd) zzaVar.y()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void E(int i2, zze zzeVar) {
            zzeVar.getClass();
            e0();
            this.zzd.set(i2, zzeVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void F(long j2) {
            this.zzc |= 2;
            this.zzf = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void N(zze.zza zzaVar) {
            e0();
            this.zzd.add((zze) ((zzfd) zzaVar.y()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void O(zze zzeVar) {
            zzeVar.getClass();
            e0();
            this.zzd.add(zzeVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void P(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zze = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void R(int i2) {
            e0();
            this.zzd.remove(i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void S(long j2) {
            this.zzc |= 4;
            this.zzg = j2;
        }

        public static zza c0() {
            return zzi.u();
        }

        private final void e0() {
            if (this.zzd.a()) {
                return;
            }
            this.zzd = zzfd.n(this.zzd);
        }

        public final zze B(int i2) {
            return this.zzd.get(i2);
        }

        public final List<zze> C() {
            return this.zzd;
        }

        public final int Q() {
            return this.zzd.size();
        }

        public final String U() {
            return this.zze;
        }

        public final boolean V() {
            return (this.zzc & 2) != 0;
        }

        public final long W() {
            return this.zzf;
        }

        public final boolean X() {
            return (this.zzc & 4) != 0;
        }

        public final long Z() {
            return this.zzg;
        }

        public final boolean a0() {
            return (this.zzc & 8) != 0;
        }

        public final int b0() {
            return this.zzh;
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        protected final Object p(int i2, Object obj, Object obj2) {
            g0 g0Var = null;
            switch (g0.a[i2 - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(g0Var);
                case 3:
                    return zzfd.q(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002\b\u0000\u0003\u0002\u0001\u0004\u0002\u0002\u0005\u0004\u0003", new Object[]{"zzc", "zzd", zze.class, "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzgx<zzc> zzaVar = zzj;
                    if (zzaVar == null) {
                        synchronized (zzc.class) {
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
    public static final class zzd extends zzfd<zzd, zza> implements zzgq {
        private static final zzd zzf;
        private static volatile zzgx<zzd> zzg;
        private int zzc;
        private String zzd = HttpUrl.FRAGMENT_ENCODE_SET;
        private long zze;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
        public static final class zza extends zzfd.zzb<zzd, zza> implements zzgq {
            private zza() {
                super(zzd.zzf);
            }

            public final zza A(String str) {
                t();
                ((zzd) this.f17395g).F(str);
                return this;
            }

            public final zza w(long j2) {
                t();
                ((zzd) this.f17395g).C(j2);
                return this;
            }

            /* synthetic */ zza(g0 g0Var) {
                this();
            }
        }

        static {
            zzd zzdVar = new zzd();
            zzf = zzdVar;
            zzfd.s(zzd.class, zzdVar);
        }

        private zzd() {
        }

        public static zza B() {
            return zzf.u();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void C(long j2) {
            this.zzc |= 2;
            this.zze = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void F(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        protected final Object p(int i2, Object obj, Object obj2) {
            g0 g0Var = null;
            switch (g0.a[i2 - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(g0Var);
                case 3:
                    return zzfd.q(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgx<zzd> zzaVar = zzg;
                    if (zzaVar == null) {
                        synchronized (zzd.class) {
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

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
    public static final class zze extends zzfd<zze, zza> implements zzgq {
        private static final zze zzi;
        private static volatile zzgx<zze> zzj;
        private int zzc;
        private String zzd = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zze = HttpUrl.FRAGMENT_ENCODE_SET;
        private long zzf;
        private float zzg;
        private double zzh;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
        public static final class zza extends zzfd.zzb<zze, zza> implements zzgq {
            private zza() {
                super(zze.zzi);
            }

            public final zza A(double d2) {
                t();
                ((zze) this.f17395g).C(d2);
                return this;
            }

            public final zza B(long j2) {
                t();
                ((zze) this.f17395g).D(j2);
                return this;
            }

            public final zza C(String str) {
                t();
                ((zze) this.f17395g).I(str);
                return this;
            }

            public final zza D() {
                t();
                ((zze) this.f17395g).W();
                return this;
            }

            public final zza E(String str) {
                t();
                ((zze) this.f17395g).L(str);
                return this;
            }

            public final zza F() {
                t();
                ((zze) this.f17395g).X();
                return this;
            }

            public final zza w() {
                t();
                ((zze) this.f17395g).V();
                return this;
            }

            /* synthetic */ zza(g0 g0Var) {
                this();
            }
        }

        static {
            zze zzeVar = new zze();
            zzi = zzeVar;
            zzfd.s(zze.class, zzeVar);
        }

        private zze() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void C(double d2) {
            this.zzc |= 16;
            this.zzh = d2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void D(long j2) {
            this.zzc |= 4;
            this.zzf = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void I(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void L(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        public static zza T() {
            return zzi.u();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void V() {
            this.zzc &= -3;
            this.zze = zzi.zze;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void W() {
            this.zzc &= -5;
            this.zzf = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void X() {
            this.zzc &= -17;
            this.zzh = 0.0d;
        }

        public final String B() {
            return this.zzd;
        }

        public final boolean M() {
            return (this.zzc & 2) != 0;
        }

        public final String N() {
            return this.zze;
        }

        public final boolean P() {
            return (this.zzc & 4) != 0;
        }

        public final long Q() {
            return this.zzf;
        }

        public final boolean R() {
            return (this.zzc & 16) != 0;
        }

        public final double S() {
            return this.zzh;
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        protected final Object p(int i2, Object obj, Object obj2) {
            g0 g0Var = null;
            switch (g0.a[i2 - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(g0Var);
                case 3:
                    return zzfd.q(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\u0002\u0002\u0004\u0001\u0003\u0005\u0000\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzgx<zze> zzaVar = zzj;
                    if (zzaVar == null) {
                        synchronized (zze.class) {
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
    public static final class zzf extends zzfd<zzf, zza> implements zzgq {
        private static final zzf zzd;
        private static volatile zzgx<zzf> zze;
        private zzfl<zzg> zzc = zzfd.A();

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
        public static final class zza extends zzfd.zzb<zzf, zza> implements zzgq {
            private zza() {
                super(zzf.zzd);
            }

            public final zzg A(int i2) {
                return ((zzf) this.f17395g).B(0);
            }

            public final zza w(zzg.zza zzaVar) {
                t();
                ((zzf) this.f17395g).E(zzaVar);
                return this;
            }

            /* synthetic */ zza(g0 g0Var) {
                this();
            }
        }

        static {
            zzf zzfVar = new zzf();
            zzd = zzfVar;
            zzfd.s(zzf.class, zzfVar);
        }

        private zzf() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void E(zzg.zza zzaVar) {
            if (!this.zzc.a()) {
                this.zzc = zzfd.n(this.zzc);
            }
            this.zzc.add((zzg) ((zzfd) zzaVar.y()));
        }

        public static zza F() {
            return zzd.u();
        }

        public final zzg B(int i2) {
            return this.zzc.get(0);
        }

        public final List<zzg> C() {
            return this.zzc;
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        protected final Object p(int i2, Object obj, Object obj2) {
            g0 g0Var = null;
            switch (g0.a[i2 - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(g0Var);
                case 3:
                    return zzfd.q(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzg.class});
                case 4:
                    return zzd;
                case 5:
                    zzgx<zzf> zzaVar = zze;
                    if (zzaVar == null) {
                        synchronized (zzf.class) {
                            zzaVar = zze;
                            if (zzaVar == null) {
                                zzaVar = new zzfd.zza<>(zzd);
                                zze = zzaVar;
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
    public static final class zzg extends zzfd<zzg, zza> implements zzgq {
        private static final zzg zzav;
        private static volatile zzgx<zzg> zzaw;
        private int zzaa;
        private boolean zzad;
        private int zzag;
        private int zzah;
        private int zzai;
        private long zzak;
        private long zzal;
        private int zzao;
        private zzh zzaq;
        private long zzas;
        private long zzat;
        private int zzc;
        private int zzd;
        private int zze;
        private long zzh;
        private long zzi;
        private long zzj;
        private long zzk;
        private long zzl;
        private int zzq;
        private long zzu;
        private long zzv;
        private boolean zzx;
        private long zzz;
        private zzfl<zzc> zzf = zzfd.A();
        private zzfl<zzk> zzg = zzfd.A();
        private String zzm = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzn = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzo = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzp = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzr = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzs = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzt = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzw = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzy = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzab = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzac = HttpUrl.FRAGMENT_ENCODE_SET;
        private zzfl<zza> zzae = zzfd.A();
        private String zzaf = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzaj = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzam = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzan = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzap = HttpUrl.FRAGMENT_ENCODE_SET;
        private zzfj zzar = zzfd.w();
        private String zzau = HttpUrl.FRAGMENT_ENCODE_SET;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
        public static final class zza extends zzfd.zzb<zzg, zza> implements zzgq {
            private zza() {
                super(zzg.zzav);
            }

            public final zza A(int i2, zzc.zza zzaVar) {
                t();
                ((zzg) this.f17395g).C(i2, zzaVar);
                return this;
            }

            public final zza A0(long j2) {
                t();
                ((zzg) this.f17395g).g2(j2);
                return this;
            }

            public final zza B(int i2, zzk zzkVar) {
                t();
                ((zzg) this.f17395g).D(i2, zzkVar);
                return this;
            }

            public final zza B0(String str) {
                t();
                ((zzg) this.f17395g).j2(str);
                return this;
            }

            public final zza C(long j2) {
                t();
                ((zzg) this.f17395g).E(j2);
                return this;
            }

            public final String C0() {
                return ((zzg) this.f17395g).L2();
            }

            public final zza D(zzc.zza zzaVar) {
                t();
                ((zzg) this.f17395g).F(zzaVar);
                return this;
            }

            public final zza D0() {
                t();
                ((zzg) this.f17395g).Z0();
                return this;
            }

            public final zza E(zzh.zzb zzbVar) {
                t();
                ((zzg) this.f17395g).S(zzbVar);
                return this;
            }

            public final zza E0(long j2) {
                t();
                ((zzg) this.f17395g).k2(j2);
                return this;
            }

            public final zza F(zzk.zza zzaVar) {
                t();
                ((zzg) this.f17395g).T(zzaVar);
                return this;
            }

            public final zza F0(String str) {
                t();
                ((zzg) this.f17395g).n2(str);
                return this;
            }

            public final zza G(zzk zzkVar) {
                t();
                ((zzg) this.f17395g).U(zzkVar);
                return this;
            }

            public final zza G0(long j2) {
                t();
                ((zzg) this.f17395g).q2(j2);
                return this;
            }

            public final zza H(Iterable<? extends zzc> iterable) {
                t();
                ((zzg) this.f17395g).V(iterable);
                return this;
            }

            public final zza H0(String str) {
                t();
                ((zzg) this.f17395g).t2(str);
                return this;
            }

            public final zza I(String str) {
                t();
                ((zzg) this.f17395g).W(str);
                return this;
            }

            public final String I0() {
                return ((zzg) this.f17395g).n0();
            }

            public final zza J(boolean z) {
                t();
                ((zzg) this.f17395g).X(z);
                return this;
            }

            public final List<zzc> K() {
                return Collections.unmodifiableList(((zzg) this.f17395g).b1());
            }

            public final zza K0() {
                t();
                ((zzg) this.f17395g).a1();
                return this;
            }

            public final int L() {
                return ((zzg) this.f17395g).l1();
            }

            public final zza L0(String str) {
                t();
                ((zzg) this.f17395g).v2(str);
                return this;
            }

            public final zzc M(int i2) {
                return ((zzg) this.f17395g).B(i2);
            }

            public final zza N(long j2) {
                t();
                ((zzg) this.f17395g).D0(j2);
                return this;
            }

            public final zza N0() {
                t();
                ((zzg) this.f17395g).k1();
                return this;
            }

            public final zza O(Iterable<? extends zzk> iterable) {
                t();
                ((zzg) this.f17395g).K0(iterable);
                return this;
            }

            public final zza O0(String str) {
                t();
                ((zzg) this.f17395g).z2(null);
                return this;
            }

            public final zza P(String str) {
                t();
                ((zzg) this.f17395g).L0(str);
                return this;
            }

            public final zza P0(String str) {
                t();
                ((zzg) this.f17395g).B2(str);
                return this;
            }

            public final zza Q(boolean z) {
                t();
                ((zzg) this.f17395g).M0(z);
                return this;
            }

            public final zza R() {
                t();
                ((zzg) this.f17395g).U0();
                return this;
            }

            public final zza S(int i2) {
                t();
                ((zzg) this.f17395g).w1(i2);
                return this;
            }

            public final zza T(long j2) {
                t();
                ((zzg) this.f17395g).c1(j2);
                return this;
            }

            public final zza U(Iterable<? extends zza> iterable) {
                t();
                ((zzg) this.f17395g).i1(iterable);
                return this;
            }

            public final zza V(String str) {
                t();
                ((zzg) this.f17395g).j1(str);
                return this;
            }

            public final zza X(long j2) {
                t();
                ((zzg) this.f17395g).n1(j2);
                return this;
            }

            public final zza Z(Iterable<? extends Integer> iterable) {
                t();
                ((zzg) this.f17395g).t1(iterable);
                return this;
            }

            public final zza a0(String str) {
                t();
                ((zzg) this.f17395g).u1(str);
                return this;
            }

            public final zzk b0(int i2) {
                return ((zzg) this.f17395g).C0(i2);
            }

            public final List<zzk> c0() {
                return Collections.unmodifiableList(((zzg) this.f17395g).v1());
            }

            public final int d0() {
                return ((zzg) this.f17395g).D1();
            }

            public final zza f0(int i2) {
                t();
                ((zzg) this.f17395g).E1(i2);
                return this;
            }

            public final zza g0(long j2) {
                t();
                ((zzg) this.f17395g).x1(j2);
                return this;
            }

            public final zza h0(String str) {
                t();
                ((zzg) this.f17395g).C1(str);
                return this;
            }

            public final long j0() {
                return ((zzg) this.f17395g).e2();
            }

            public final zza k0(int i2) {
                t();
                ((zzg) this.f17395g).L1(i2);
                return this;
            }

            public final zza l0(long j2) {
                t();
                ((zzg) this.f17395g).F1(j2);
                return this;
            }

            public final zza m0(String str) {
                t();
                ((zzg) this.f17395g).K1(str);
                return this;
            }

            public final long n0() {
                return ((zzg) this.f17395g).p2();
            }

            public final zza o0(int i2) {
                t();
                ((zzg) this.f17395g).T1(i2);
                return this;
            }

            public final zza q0(long j2) {
                t();
                ((zzg) this.f17395g).M1(j2);
                return this;
            }

            public final zza r0(String str) {
                t();
                ((zzg) this.f17395g).Q1(str);
                return this;
            }

            public final zza s0() {
                t();
                ((zzg) this.f17395g).W0();
                return this;
            }

            public final zza t0(int i2) {
                t();
                ((zzg) this.f17395g).Y1(i2);
                return this;
            }

            public final zza u0(long j2) {
                t();
                ((zzg) this.f17395g).U1(j2);
                return this;
            }

            public final zza v0(String str) {
                t();
                ((zzg) this.f17395g).X1(str);
                return this;
            }

            public final zza w(int i2) {
                t();
                ((zzg) this.f17395g).m1(1);
                return this;
            }

            public final zza w0() {
                t();
                ((zzg) this.f17395g).Y0();
                return this;
            }

            public final zza x0(int i2) {
                t();
                ((zzg) this.f17395g).f2(i2);
                return this;
            }

            public final zza y0(long j2) {
                t();
                ((zzg) this.f17395g).Z1(j2);
                return this;
            }

            public final zza z0(String str) {
                t();
                ((zzg) this.f17395g).c2(str);
                return this;
            }

            /* synthetic */ zza(g0 g0Var) {
                this();
            }
        }

        static {
            zzg zzgVar = new zzg();
            zzav = zzgVar;
            zzfd.s(zzg.class, zzgVar);
        }

        private zzg() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void B2(String str) {
            str.getClass();
            this.zzd |= 4;
            this.zzap = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void C(int i2, zzc.zza zzaVar) {
            T0();
            this.zzf.set(i2, (zzc) ((zzfd) zzaVar.y()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void C1(String str) {
            str.getClass();
            this.zzc |= RecyclerView.l.FLAG_MOVED;
            this.zzr = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void D(int i2, zzk zzkVar) {
            zzkVar.getClass();
            V0();
            this.zzg.set(i2, zzkVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void D0(long j2) {
            this.zzc |= 4;
            this.zzi = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void E(long j2) {
            this.zzc |= 2;
            this.zzh = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void E1(int i2) {
            V0();
            this.zzg.remove(i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void F(zzc.zza zzaVar) {
            T0();
            this.zzf.add((zzc) ((zzfd) zzaVar.y()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void F1(long j2) {
            this.zzc |= Http2.INITIAL_MAX_FRAME_SIZE;
            this.zzu = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void K0(Iterable<? extends zzk> iterable) {
            V0();
            zzdl.c(iterable, this.zzg);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void K1(String str) {
            str.getClass();
            this.zzc |= RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT;
            this.zzs = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void L0(String str) {
            str.getClass();
            this.zzc |= 128;
            this.zzn = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void L1(int i2) {
            this.zzc |= 1024;
            this.zzq = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void M0(boolean z) {
            this.zzc |= 8388608;
            this.zzad = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void M1(long j2) {
            this.zzc |= 32768;
            this.zzv = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void Q1(String str) {
            str.getClass();
            this.zzc |= 8192;
            this.zzt = str;
        }

        public static zza R0() {
            return zzav.u();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void S(zzh.zzb zzbVar) {
            this.zzaq = (zzh) ((zzfd) zzbVar.y());
            this.zzd |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void T(zzk.zza zzaVar) {
            V0();
            this.zzg.add((zzk) ((zzfd) zzaVar.y()));
        }

        private final void T0() {
            if (this.zzf.a()) {
                return;
            }
            this.zzf = zzfd.n(this.zzf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void T1(int i2) {
            this.zzc |= CacheHelper.VALUE_TO_CONVERT_MB_TO_BYTES;
            this.zzaa = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void U(zzk zzkVar) {
            zzkVar.getClass();
            V0();
            this.zzg.add(zzkVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void U0() {
            this.zzf = zzfd.A();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void U1(long j2) {
            this.zzc |= 524288;
            this.zzz = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void V(Iterable<? extends zzc> iterable) {
            T0();
            zzdl.c(iterable, this.zzf);
        }

        private final void V0() {
            if (this.zzg.a()) {
                return;
            }
            this.zzg = zzfd.n(this.zzg);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void W(String str) {
            str.getClass();
            this.zzc |= 64;
            this.zzm = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void W0() {
            this.zzc &= -17;
            this.zzk = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void X(boolean z) {
            this.zzc |= 131072;
            this.zzx = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void X1(String str) {
            str.getClass();
            this.zzc |= 65536;
            this.zzw = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void Y0() {
            this.zzc &= -33;
            this.zzl = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void Y1(int i2) {
            this.zzc |= 33554432;
            this.zzag = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void Z0() {
            this.zzc &= -2097153;
            this.zzab = zzav.zzab;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void Z1(long j2) {
            this.zzc |= 536870912;
            this.zzak = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a1() {
            this.zzae = zzfd.A();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c1(long j2) {
            this.zzc |= 8;
            this.zzj = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c2(String str) {
            str.getClass();
            this.zzc |= 262144;
            this.zzy = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void f2(int i2) {
            this.zzd |= 2;
            this.zzao = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void g2(long j2) {
            this.zzc |= 1073741824;
            this.zzal = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void i1(Iterable<? extends zza> iterable) {
            if (!this.zzae.a()) {
                this.zzae = zzfd.n(this.zzae);
            }
            zzdl.c(iterable, this.zzae);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void j1(String str) {
            str.getClass();
            this.zzc |= 256;
            this.zzo = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void j2(String str) {
            str.getClass();
            this.zzc |= 2097152;
            this.zzab = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void k1() {
            this.zzc &= Integer.MAX_VALUE;
            this.zzam = zzav.zzam;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void k2(long j2) {
            this.zzd |= 16;
            this.zzas = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void m1(int i2) {
            this.zzc |= 1;
            this.zze = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void n1(long j2) {
            this.zzc |= 16;
            this.zzk = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void n2(String str) {
            str.getClass();
            this.zzc |= 4194304;
            this.zzac = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void q2(long j2) {
            this.zzd |= 32;
            this.zzat = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void t1(Iterable<? extends Integer> iterable) {
            if (!this.zzar.a()) {
                zzfj zzfjVar = this.zzar;
                int size = zzfjVar.size();
                this.zzar = zzfjVar.d(size == 0 ? 10 : size << 1);
            }
            zzdl.c(iterable, this.zzar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void t2(String str) {
            str.getClass();
            this.zzc |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
            this.zzaf = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void u1(String str) {
            str.getClass();
            this.zzc |= AdRequest.MAX_CONTENT_URL_LENGTH;
            this.zzp = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void v2(String str) {
            str.getClass();
            this.zzc |= 268435456;
            this.zzaj = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void w1(int i2) {
            T0();
            this.zzf.remove(i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void x1(long j2) {
            this.zzc |= 32;
            this.zzl = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void z2(String str) {
            str.getClass();
            this.zzc |= Integer.MIN_VALUE;
            this.zzam = str;
        }

        public final boolean A0() {
            return (this.zzd & 2) != 0;
        }

        public final zzc B(int i2) {
            return this.zzf.get(i2);
        }

        public final int B0() {
            return this.zze;
        }

        public final zzk C0(int i2) {
            return this.zzg.get(i2);
        }

        public final boolean C2() {
            return (this.zzc & 32) != 0;
        }

        public final int D1() {
            return this.zzg.size();
        }

        public final long D2() {
            return this.zzl;
        }

        public final String E2() {
            return this.zzm;
        }

        public final String F2() {
            return this.zzn;
        }

        public final String G2() {
            return this.zzo;
        }

        public final String H2() {
            return this.zzp;
        }

        public final boolean I2() {
            return (this.zzc & 1024) != 0;
        }

        public final int J2() {
            return this.zzq;
        }

        public final String K2() {
            return this.zzr;
        }

        public final String L2() {
            return this.zzs;
        }

        public final String M2() {
            return this.zzt;
        }

        public final int N0() {
            return this.zzao;
        }

        public final boolean N2() {
            return (this.zzc & Http2.INITIAL_MAX_FRAME_SIZE) != 0;
        }

        public final String O0() {
            return this.zzap;
        }

        public final boolean P0() {
            return (this.zzd & 16) != 0;
        }

        public final long Q0() {
            return this.zzas;
        }

        public final boolean R1() {
            return (this.zzc & 2) != 0;
        }

        public final long S1() {
            return this.zzh;
        }

        public final boolean Z() {
            return (this.zzc & 1) != 0;
        }

        public final long a0() {
            return this.zzu;
        }

        public final boolean b0() {
            return (this.zzc & 32768) != 0;
        }

        public final List<zzc> b1() {
            return this.zzf;
        }

        public final long c0() {
            return this.zzv;
        }

        public final String d0() {
            return this.zzw;
        }

        public final boolean d2() {
            return (this.zzc & 4) != 0;
        }

        public final boolean e0() {
            return (this.zzc & 131072) != 0;
        }

        public final long e2() {
            return this.zzi;
        }

        public final boolean f0() {
            return this.zzx;
        }

        public final String g0() {
            return this.zzy;
        }

        public final boolean h0() {
            return (this.zzc & 524288) != 0;
        }

        public final long j0() {
            return this.zzz;
        }

        public final boolean k0() {
            return (this.zzc & CacheHelper.VALUE_TO_CONVERT_MB_TO_BYTES) != 0;
        }

        public final int l0() {
            return this.zzaa;
        }

        public final int l1() {
            return this.zzf.size();
        }

        public final String m0() {
            return this.zzab;
        }

        public final String n0() {
            return this.zzac;
        }

        public final boolean o0() {
            return (this.zzc & 8388608) != 0;
        }

        public final boolean o2() {
            return (this.zzc & 8) != 0;
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        protected final Object p(int i2, Object obj, Object obj2) {
            g0 g0Var = null;
            switch (g0.a[i2 - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(g0Var);
                case 3:
                    return zzfd.q(zzav, "\u0001+\u0000\u0002\u00012+\u0000\u0004\u0000\u0001\u0004\u0000\u0002\u001b\u0003\u001b\u0004\u0002\u0001\u0005\u0002\u0002\u0006\u0002\u0003\u0007\u0002\u0005\b\b\u0006\t\b\u0007\n\b\b\u000b\b\t\f\u0004\n\r\b\u000b\u000e\b\f\u0010\b\r\u0011\u0002\u000e\u0012\u0002\u000f\u0013\b\u0010\u0014\u0007\u0011\u0015\b\u0012\u0016\u0002\u0013\u0017\u0004\u0014\u0018\b\u0015\u0019\b\u0016\u001a\u0002\u0004\u001c\u0007\u0017\u001d\u001b\u001e\b\u0018\u001f\u0004\u0019 \u0004\u001a!\u0004\u001b\"\b\u001c#\u0002\u001d$\u0002\u001e%\b\u001f&\b '\u0004!)\b\",\t#-\u001d.\u0002$/\u0002%2\b&", new Object[]{"zzc", "zzd", "zze", "zzf", zzc.class, "zzg", zzk.class, "zzh", "zzi", "zzj", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzaa", "zzab", "zzac", "zzk", "zzad", "zzae", zza.class, "zzaf", "zzag", "zzah", "zzai", "zzaj", "zzak", "zzal", "zzam", "zzan", "zzao", "zzap", "zzaq", "zzar", "zzas", "zzat", "zzau"});
                case 4:
                    return zzav;
                case 5:
                    zzgx<zzg> zzaVar = zzaw;
                    if (zzaVar == null) {
                        synchronized (zzg.class) {
                            zzaVar = zzaw;
                            if (zzaVar == null) {
                                zzaVar = new zzfd.zza<>(zzav);
                                zzaw = zzaVar;
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

        public final boolean p0() {
            return this.zzad;
        }

        public final long p2() {
            return this.zzj;
        }

        public final List<zza> q0() {
            return this.zzae;
        }

        public final String r0() {
            return this.zzaf;
        }

        public final boolean s0() {
            return (this.zzc & 33554432) != 0;
        }

        public final int t0() {
            return this.zzag;
        }

        public final String u0() {
            return this.zzaj;
        }

        public final boolean v0() {
            return (this.zzc & 536870912) != 0;
        }

        public final List<zzk> v1() {
            return this.zzg;
        }

        public final long w0() {
            return this.zzak;
        }

        public final boolean w2() {
            return (this.zzc & 16) != 0;
        }

        public final boolean x0() {
            return (this.zzc & 1073741824) != 0;
        }

        public final long x2() {
            return this.zzk;
        }

        public final long y0() {
            return this.zzal;
        }

        public final String z0() {
            return this.zzam;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
    public static final class zzh extends zzfd<zzh, zzb> implements zzgq {
        private static final zzh zzf;
        private static volatile zzgx<zzh> zzg;
        private int zzc;
        private int zzd = 1;
        private zzfl<zzd> zze = zzfd.A();

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
        public enum zza implements zzfi {
            RADS(1),
            PROVISIONING(2);


            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private static final zzfh<zza> f17321h = new i0();

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private final int f17323j;

            zza(int i2) {
                this.f17323j = i2;
            }

            public static zza g(int i2) {
                if (i2 == 1) {
                    return RADS;
                }
                if (i2 != 2) {
                    return null;
                }
                return PROVISIONING;
            }

            public static zzfk k() {
                return h0.a;
            }

            @Override // com.google.android.gms.internal.measurement.zzfi
            public final int a() {
                return this.f17323j;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f17323j + " name=" + name() + '>';
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
        public static final class zzb extends zzfd.zzb<zzh, zzb> implements zzgq {
            private zzb() {
                super(zzh.zzf);
            }

            public final zzb w(zzd.zza zzaVar) {
                t();
                ((zzh) this.f17395g).C(zzaVar);
                return this;
            }

            /* synthetic */ zzb(g0 g0Var) {
                this();
            }
        }

        static {
            zzh zzhVar = new zzh();
            zzf = zzhVar;
            zzfd.s(zzh.class, zzhVar);
        }

        private zzh() {
        }

        public static zzb B() {
            return zzf.u();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void C(zzd.zza zzaVar) {
            if (!this.zze.a()) {
                this.zze = zzfd.n(this.zze);
            }
            this.zze.add((zzd) ((zzfd) zzaVar.y()));
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        protected final Object p(int i2, Object obj, Object obj2) {
            g0 g0Var = null;
            switch (g0.a[i2 - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zzb(g0Var);
                case 3:
                    return zzfd.q(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0000\u0002\u001b", new Object[]{"zzc", "zzd", zza.k(), "zze", zzd.class});
                case 4:
                    return zzf;
                case 5:
                    zzgx<zzh> zzaVar = zzg;
                    if (zzaVar == null) {
                        synchronized (zzh.class) {
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

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
    public static final class zzi extends zzfd<zzi, zza> implements zzgq {
        private static final zzi zzg;
        private static volatile zzgx<zzi> zzh;
        private zzfm zzc = zzfd.z();
        private zzfm zzd = zzfd.z();
        private zzfl<zzb> zze = zzfd.A();
        private zzfl<zzj> zzf = zzfd.A();

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
        public static final class zza extends zzfd.zzb<zzi, zza> implements zzgq {
            private zza() {
                super(zzi.zzg);
            }

            public final zza A(int i2) {
                t();
                ((zzi) this.f17395g).R(i2);
                return this;
            }

            public final zza B(Iterable<? extends Long> iterable) {
                t();
                ((zzi) this.f17395g).G(iterable);
                return this;
            }

            public final zza C() {
                t();
                ((zzi) this.f17395g).e0();
                return this;
            }

            public final zza D(int i2) {
                t();
                ((zzi) this.f17395g).V(i2);
                return this;
            }

            public final zza E(Iterable<? extends Long> iterable) {
                t();
                ((zzi) this.f17395g).M(iterable);
                return this;
            }

            public final zza F(Iterable<? extends zzb> iterable) {
                t();
                ((zzi) this.f17395g).P(iterable);
                return this;
            }

            public final zza G(Iterable<? extends zzj> iterable) {
                t();
                ((zzi) this.f17395g).T(iterable);
                return this;
            }

            public final zza w() {
                t();
                ((zzi) this.f17395g).d0();
                return this;
            }

            /* synthetic */ zza(g0 g0Var) {
                this();
            }
        }

        static {
            zzi zziVar = new zzi();
            zzg = zziVar;
            zzfd.s(zzi.class, zziVar);
        }

        private zzi() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void G(Iterable<? extends Long> iterable) {
            if (!this.zzc.a()) {
                this.zzc = zzfd.o(this.zzc);
            }
            zzdl.c(iterable, this.zzc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void M(Iterable<? extends Long> iterable) {
            if (!this.zzd.a()) {
                this.zzd = zzfd.o(this.zzd);
            }
            zzdl.c(iterable, this.zzd);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void P(Iterable<? extends zzb> iterable) {
            f0();
            zzdl.c(iterable, this.zze);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void R(int i2) {
            f0();
            this.zze.remove(i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void T(Iterable<? extends zzj> iterable) {
            g0();
            zzdl.c(iterable, this.zzf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void V(int i2) {
            g0();
            this.zzf.remove(i2);
        }

        public static zza a0() {
            return zzg.u();
        }

        public static zzi b0() {
            return zzg;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d0() {
            this.zzc = zzfd.z();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e0() {
            this.zzd = zzfd.z();
        }

        private final void f0() {
            if (this.zze.a()) {
                return;
            }
            this.zze = zzfd.n(this.zze);
        }

        private final void g0() {
            if (this.zzf.a()) {
                return;
            }
            this.zzf = zzfd.n(this.zzf);
        }

        public final zzb B(int i2) {
            return this.zze.get(i2);
        }

        public final List<Long> C() {
            return this.zzc;
        }

        public final int H() {
            return this.zzc.size();
        }

        public final zzj I(int i2) {
            return this.zzf.get(i2);
        }

        public final List<Long> N() {
            return this.zzd;
        }

        public final int Q() {
            return this.zzd.size();
        }

        public final List<zzb> U() {
            return this.zze;
        }

        public final int W() {
            return this.zze.size();
        }

        public final List<zzj> X() {
            return this.zzf;
        }

        public final int Z() {
            return this.zzf.size();
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        protected final Object p(int i2, Object obj, Object obj2) {
            g0 g0Var = null;
            switch (g0.a[i2 - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza(g0Var);
                case 3:
                    return zzfd.q(zzg, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzc", "zzd", "zze", zzb.class, "zzf", zzj.class});
                case 4:
                    return zzg;
                case 5:
                    zzgx<zzi> zzaVar = zzh;
                    if (zzaVar == null) {
                        synchronized (zzi.class) {
                            zzaVar = zzh;
                            if (zzaVar == null) {
                                zzaVar = new zzfd.zza<>(zzg);
                                zzh = zzaVar;
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
    public static final class zzj extends zzfd<zzj, zza> implements zzgq {
        private static final zzj zzf;
        private static volatile zzgx<zzj> zzg;
        private int zzc;
        private int zzd;
        private zzfm zze = zzfd.z();

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
        public static final class zza extends zzfd.zzb<zzj, zza> implements zzgq {
            private zza() {
                super(zzj.zzf);
            }

            public final zza A(int i2) {
                t();
                ((zzj) this.f17395g).K(i2);
                return this;
            }

            public final zza B(long j2) {
                t();
                ((zzj) this.f17395g).C(j2);
                return this;
            }

            public final zza C(Iterable<? extends Long> iterable) {
                t();
                ((zzj) this.f17395g).H(iterable);
                return this;
            }

            public final zza w() {
                t();
                ((zzj) this.f17395g).Q();
                return this;
            }

            /* synthetic */ zza(g0 g0Var) {
                this();
            }
        }

        static {
            zzj zzjVar = new zzj();
            zzf = zzjVar;
            zzfd.s(zzj.class, zzjVar);
        }

        private zzj() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void C(long j2) {
            P();
            this.zze.G0(j2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void H(Iterable<? extends Long> iterable) {
            P();
            zzdl.c(iterable, this.zze);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void K(int i2) {
            this.zzc |= 1;
            this.zzd = i2;
        }

        public static zza N() {
            return zzf.u();
        }

        private final void P() {
            if (this.zze.a()) {
                return;
            }
            this.zze = zzfd.o(this.zze);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void Q() {
            this.zze = zzfd.z();
        }

        public final long B(int i2) {
            return this.zze.e(i2);
        }

        public final boolean I() {
            return (this.zzc & 1) != 0;
        }

        public final int J() {
            return this.zzd;
        }

        public final List<Long> L() {
            return this.zze;
        }

        public final int M() {
            return this.zze.size();
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        protected final Object p(int i2, Object obj, Object obj2) {
            g0 g0Var = null;
            switch (g0.a[i2 - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza(g0Var);
                case 3:
                    return zzfd.q(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u0004\u0000\u0002\u0014", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgx<zzj> zzaVar = zzg;
                    if (zzaVar == null) {
                        synchronized (zzj.class) {
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

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
    public static final class zzk extends zzfd<zzk, zza> implements zzgq {
        private static final zzk zzj;
        private static volatile zzgx<zzk> zzk;
        private int zzc;
        private long zzd;
        private String zze = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzf = HttpUrl.FRAGMENT_ENCODE_SET;
        private long zzg;
        private float zzh;
        private double zzi;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
        public static final class zza extends zzfd.zzb<zzk, zza> implements zzgq {
            private zza() {
                super(zzk.zzj);
            }

            public final zza A(double d2) {
                t();
                ((zzk) this.f17395g).B(d2);
                return this;
            }

            public final zza B(long j2) {
                t();
                ((zzk) this.f17395g).C(j2);
                return this;
            }

            public final zza C(String str) {
                t();
                ((zzk) this.f17395g).H(str);
                return this;
            }

            public final zza D() {
                t();
                ((zzk) this.f17395g).b0();
                return this;
            }

            public final zza E(long j2) {
                t();
                ((zzk) this.f17395g).K(j2);
                return this;
            }

            public final zza F(String str) {
                t();
                ((zzk) this.f17395g).O(str);
                return this;
            }

            public final zza G() {
                t();
                ((zzk) this.f17395g).c0();
                return this;
            }

            public final zza w() {
                t();
                ((zzk) this.f17395g).a0();
                return this;
            }

            /* synthetic */ zza(g0 g0Var) {
                this();
            }
        }

        static {
            zzk zzkVar = new zzk();
            zzj = zzkVar;
            zzfd.s(zzk.class, zzkVar);
        }

        private zzk() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void B(double d2) {
            this.zzc |= 32;
            this.zzi = d2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void C(long j2) {
            this.zzc |= 1;
            this.zzd = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void H(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void K(long j2) {
            this.zzc |= 8;
            this.zzg = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void O(String str) {
            str.getClass();
            this.zzc |= 4;
            this.zzf = str;
        }

        public static zza X() {
            return zzj.u();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a0() {
            this.zzc &= -5;
            this.zzf = zzj.zzf;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b0() {
            this.zzc &= -9;
            this.zzg = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c0() {
            this.zzc &= -33;
            this.zzi = 0.0d;
        }

        public final boolean I() {
            return (this.zzc & 1) != 0;
        }

        public final long J() {
            return this.zzd;
        }

        public final String P() {
            return this.zze;
        }

        public final boolean R() {
            return (this.zzc & 4) != 0;
        }

        public final String S() {
            return this.zzf;
        }

        public final boolean T() {
            return (this.zzc & 8) != 0;
        }

        public final long U() {
            return this.zzg;
        }

        public final boolean V() {
            return (this.zzc & 32) != 0;
        }

        public final double W() {
            return this.zzi;
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        protected final Object p(int i2, Object obj, Object obj2) {
            g0 g0Var = null;
            switch (g0.a[i2 - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza(g0Var);
                case 3:
                    return zzfd.q(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0002\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0002\u0003\u0005\u0001\u0004\u0006\u0000\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzgx<zzk> zzaVar = zzk;
                    if (zzaVar == null) {
                        synchronized (zzk.class) {
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
}
