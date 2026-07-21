package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdgp extends zzdob<zzdgp, zza> implements zzdpm {
    private static volatile zzdpv<zzdgp> zzdv;
    private static final zzdgp zzgty;
    private int zzgtw;
    private int zzgtx;

    public static final class zza extends zzdob.zza<zzdgp, zza> implements zzdpm {
        private zza() {
            super(zzdgp.zzgty);
        }

        /* synthetic */ zza(ws wsVar) {
            this();
        }
    }

    static {
        zzdgp zzdgpVar = new zzdgp();
        zzgty = zzdgpVar;
        zzdob.t(zzdgp.class, zzdgpVar);
    }

    private zzdgp() {
    }

    public static zzdgp z() {
        return zzgty;
    }

    @Override // com.google.android.gms.internal.ads.zzdob
    protected final Object q(int i2, Object obj, Object obj2) {
        ws wsVar = null;
        switch (ws.a[i2 - 1]) {
            case 1:
                return new zzdgp();
            case 2:
                return new zza(wsVar);
            case 3:
                return zzdob.r(zzgty, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzgtw", "zzgtx"});
            case 4:
                return zzgty;
            case 5:
                zzdpv<zzdgp> zzbVar = zzdv;
                if (zzbVar == null) {
                    synchronized (zzdgp.class) {
                        zzbVar = zzdv;
                        if (zzbVar == null) {
                            zzbVar = new zzdob.zzb<>(zzgty);
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

    public final zzdgj x() {
        zzdgj zzdgjVarG = zzdgj.g(this.zzgtw);
        return zzdgjVarG == null ? zzdgj.UNRECOGNIZED : zzdgjVarG;
    }

    public final int y() {
        return this.zzgtx;
    }
}
