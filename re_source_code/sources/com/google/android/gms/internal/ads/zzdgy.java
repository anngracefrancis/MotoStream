package com.google.android.gms.internal.ads;

import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdgy extends zzdob<zzdgy, zza> implements zzdpm {
    private static volatile zzdpv<zzdgy> zzdv;
    private static final zzdgy zzguw;
    private int zzgut;
    private boolean zzguu;
    private String zzgus = HttpUrl.FRAGMENT_ENCODE_SET;
    private String zzgtz = HttpUrl.FRAGMENT_ENCODE_SET;
    private String zzguv = HttpUrl.FRAGMENT_ENCODE_SET;

    public static final class zza extends zzdob.zza<zzdgy, zza> implements zzdpm {
        private zza() {
            super(zzdgy.zzguw);
        }

        public final zza A(String str) {
            p();
            ((zzdgy) this.f16019g).L(str);
            return this;
        }

        public final zza B(String str) {
            p();
            ((zzdgy) this.f16019g).N(str);
            return this;
        }

        public final zza u(boolean z) {
            p();
            ((zzdgy) this.f16019g).I(true);
            return this;
        }

        public final zza v(int i2) {
            p();
            ((zzdgy) this.f16019g).K(0);
            return this;
        }

        public final zza w(String str) {
            p();
            ((zzdgy) this.f16019g).M(str);
            return this;
        }

        /* synthetic */ zza(bt btVar) {
            this();
        }
    }

    static {
        zzdgy zzdgyVar = new zzdgy();
        zzguw = zzdgyVar;
        zzdob.t(zzdgy.class, zzdgyVar);
    }

    private zzdgy() {
    }

    public static zza F() {
        return (zza) ((zzdob.zza) zzguw.q(zzdob.zze.f16025e, null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(boolean z) {
        this.zzguu = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(int i2) {
        this.zzgut = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(String str) {
        str.getClass();
        this.zzgtz = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(String str) {
        str.getClass();
        this.zzgus = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(String str) {
        str.getClass();
        this.zzguv = str;
    }

    public final String A() {
        return this.zzgtz;
    }

    public final String B() {
        return this.zzgus;
    }

    public final int C() {
        return this.zzgut;
    }

    public final boolean D() {
        return this.zzguu;
    }

    public final String E() {
        return this.zzguv;
    }

    @Override // com.google.android.gms.internal.ads.zzdob
    protected final Object q(int i2, Object obj, Object obj2) {
        bt btVar = null;
        switch (bt.a[i2 - 1]) {
            case 1:
                return new zzdgy();
            case 2:
                return new zza(btVar);
            case 3:
                return zzdob.r(zzguw, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zzgus", "zzgtz", "zzgut", "zzguu", "zzguv"});
            case 4:
                return zzguw;
            case 5:
                zzdpv<zzdgy> zzbVar = zzdv;
                if (zzbVar == null) {
                    synchronized (zzdgy.class) {
                        zzbVar = zzdv;
                        if (zzbVar == null) {
                            zzbVar = new zzdob.zzb<>(zzguw);
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
