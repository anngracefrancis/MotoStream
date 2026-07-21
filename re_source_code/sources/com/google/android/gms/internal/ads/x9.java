package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
@zzard
final class x9 extends zzay {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final x9 f13566c = new x9();

    x9() {
    }

    @Override // com.google.android.gms.internal.ads.zzay
    public final zzbd b(String str, byte[] bArr, String str2) {
        if ("moov".equals(str)) {
            return new zzbf();
        }
        return "mvhd".equals(str) ? new zzbg() : new zzbh(str);
    }
}
