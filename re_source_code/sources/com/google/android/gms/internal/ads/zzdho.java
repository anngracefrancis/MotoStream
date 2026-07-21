package com.google.android.gms.internal.ads;

import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdho extends zzdob<zzdho, zza> implements zzdpm {
    private static volatile zzdpv<zzdho> zzdv;
    private static final zzdho zzgvz;
    private int zzdj;
    private String zzgvx = HttpUrl.FRAGMENT_ENCODE_SET;
    private zzdoj<zzdgy> zzgvy = zzdob.v();

    public static final class zza extends zzdob.zza<zzdho, zza> implements zzdpm {
        private zza() {
            super(zzdho.zzgvz);
        }

        public final zza u(zzdgy zzdgyVar) {
            p();
            ((zzdho) this.f16019g).x(zzdgyVar);
            return this;
        }

        public final zza v(String str) {
            p();
            ((zzdho) this.f16019g).D(str);
            return this;
        }

        /* synthetic */ zza(jt jtVar) {
            this();
        }
    }

    static {
        zzdho zzdhoVar = new zzdho();
        zzgvz = zzdhoVar;
        zzdob.t(zzdho.class, zzdhoVar);
    }

    private zzdho() {
    }

    public static zza B() {
        return (zza) ((zzdob.zza) zzgvz.q(zzdob.zze.f16025e, null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(String str) {
        str.getClass();
        this.zzgvx = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(zzdgy zzdgyVar) {
        zzdgyVar.getClass();
        if (!this.zzgvy.m0()) {
            zzdoj<zzdgy> zzdojVar = this.zzgvy;
            int size = zzdojVar.size();
            this.zzgvy = zzdojVar.N(size == 0 ? 10 : size << 1);
        }
        this.zzgvy.add(zzdgyVar);
    }

    public final List<zzdgy> A() {
        return this.zzgvy;
    }

    @Override // com.google.android.gms.internal.ads.zzdob
    protected final Object q(int i2, Object obj, Object obj2) {
        jt jtVar = null;
        switch (jt.a[i2 - 1]) {
            case 1:
                return new zzdho();
            case 2:
                return new zza(jtVar);
            case 3:
                return zzdob.r(zzgvz, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzdj", "zzgvx", "zzgvy", zzdgy.class});
            case 4:
                return zzgvz;
            case 5:
                zzdpv<zzdho> zzbVar = zzdv;
                if (zzbVar == null) {
                    synchronized (zzdho.class) {
                        zzbVar = zzdv;
                        if (zzbVar == null) {
                            zzbVar = new zzdob.zzb<>(zzgvz);
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
