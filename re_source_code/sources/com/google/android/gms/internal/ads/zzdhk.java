package com.google.android.gms.internal.ads;

import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdhk extends zzdob<zzdhk, zza> implements zzdpm {
    private static volatile zzdpv<zzdhk> zzdv;
    private static final zzdhk zzgvp;
    private String zzgvn = HttpUrl.FRAGMENT_ENCODE_SET;
    private zzdgw zzgvo;

    public static final class zza extends zzdob.zza<zzdhk, zza> implements zzdpm {
        private zza() {
            super(zzdhk.zzgvp);
        }

        /* synthetic */ zza(ht htVar) {
            this();
        }
    }

    static {
        zzdhk zzdhkVar = new zzdhk();
        zzgvp = zzdhkVar;
        zzdob.t(zzdhk.class, zzdhkVar);
    }

    private zzdhk() {
    }

    public static zzdhk B(zzdmr zzdmrVar) throws zzdok {
        return (zzdhk) zzdob.k(zzgvp, zzdmrVar);
    }

    public static zzdhk z() {
        return zzgvp;
    }

    @Override // com.google.android.gms.internal.ads.zzdob
    protected final Object q(int i2, Object obj, Object obj2) {
        ht htVar = null;
        switch (ht.a[i2 - 1]) {
            case 1:
                return new zzdhk();
            case 2:
                return new zza(htVar);
            case 3:
                return zzdob.r(zzgvp, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zzgvn", "zzgvo"});
            case 4:
                return zzgvp;
            case 5:
                zzdpv<zzdhk> zzbVar = zzdv;
                if (zzbVar == null) {
                    synchronized (zzdhk.class) {
                        zzbVar = zzdv;
                        if (zzbVar == null) {
                            zzbVar = new zzdob.zzb<>(zzgvp);
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
        return this.zzgvn;
    }

    public final zzdgw y() {
        zzdgw zzdgwVar = this.zzgvo;
        return zzdgwVar == null ? zzdgw.z() : zzdgwVar;
    }
}
