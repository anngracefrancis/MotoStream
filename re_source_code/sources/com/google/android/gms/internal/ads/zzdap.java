package com.google.android.gms.internal.ads;

import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdap extends zzdob<zzdap, zzb> implements zzdpm {
    private static volatile zzdpv<zzdap> zzdv;
    private static final zzdoi<Integer, zza> zzgof = new tq();
    private static final zzdap zzgoj;
    private int zzdj;
    private zzdoh zzgoe = zzdob.u();
    private String zzgog = HttpUrl.FRAGMENT_ENCODE_SET;
    private String zzgoh = HttpUrl.FRAGMENT_ENCODE_SET;
    private String zzgoi = HttpUrl.FRAGMENT_ENCODE_SET;

    public enum zza implements zzdoe {
        BLOCKED_REASON_UNKNOWN(1),
        BLOCKED_REASON_BACKGROUND(2);


        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final zzdof<zza> f15841h = new vq();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final int f15843j;

        zza(int i2) {
            this.f15843j = i2;
        }

        public static zzdog g() {
            return wq.a;
        }

        public static zza k(int i2) {
            if (i2 == 1) {
                return BLOCKED_REASON_UNKNOWN;
            }
            if (i2 != 2) {
                return null;
            }
            return BLOCKED_REASON_BACKGROUND;
        }

        @Override // com.google.android.gms.internal.ads.zzdoe
        public final int i() {
            return this.f15843j;
        }
    }

    public static final class zzb extends zzdob.zza<zzdap, zzb> implements zzdpm {
        private zzb() {
            super(zzdap.zzgoj);
        }

        public final zzb u(zza zzaVar) {
            p();
            ((zzdap) this.f16019g).x(zzaVar);
            return this;
        }

        public final zzb v(String str) {
            p();
            ((zzdap) this.f16019g).C(str);
            return this;
        }

        /* synthetic */ zzb(tq tqVar) {
            this();
        }
    }

    static {
        zzdap zzdapVar = new zzdap();
        zzgoj = zzdapVar;
        zzdob.t(zzdap.class, zzdapVar);
    }

    private zzdap() {
    }

    public static zzb A() {
        return (zzb) ((zzdob.zza) zzgoj.q(zzdob.zze.f16025e, null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(String str) {
        str.getClass();
        this.zzdj |= 1;
        this.zzgog = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(zza zzaVar) {
        zzaVar.getClass();
        if (!this.zzgoe.m0()) {
            zzdoh zzdohVar = this.zzgoe;
            int size = zzdohVar.size();
            this.zzgoe = zzdohVar.N(size == 0 ? 10 : size << 1);
        }
        this.zzgoe.Z0(zzaVar.i());
    }

    @Override // com.google.android.gms.internal.ads.zzdob
    protected final Object q(int i2, Object obj, Object obj2) {
        tq tqVar = null;
        switch (uq.a[i2 - 1]) {
            case 1:
                return new zzdap();
            case 2:
                return new zzb(tqVar);
            case 3:
                return zzdob.r(zzgoj, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001e\u0002\b\u0000\u0003\b\u0001\u0004\b\u0002", new Object[]{"zzdj", "zzgoe", zza.g(), "zzgog", "zzgoh", "zzgoi"});
            case 4:
                return zzgoj;
            case 5:
                zzdpv<zzdap> zzbVar = zzdv;
                if (zzbVar == null) {
                    synchronized (zzdap.class) {
                        zzbVar = zzdv;
                        if (zzbVar == null) {
                            zzbVar = new zzdob.zzb<>(zzgoj);
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
