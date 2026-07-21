package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class ja implements zzbdo {
    private final /* synthetic */ zzbgl a;

    ja(zzbgl zzbglVar) {
        this.a = zzbglVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbdo
    public final void b(String str, String str2) {
        zzbgl zzbglVar = this.a;
        String strValueOf = String.valueOf(str);
        zzbglVar.f14441k = strValueOf.length() != 0 ? "ExoPlayer caching failed. Type: ".concat(strValueOf) : new String("ExoPlayer caching failed. Type: ");
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(str2).length());
        sb.append("ExoPlayer failed during precache: ");
        sb.append(str);
        sb.append(" Exception: ");
        sb.append(str2);
        zzbad.i(sb.toString());
        this.a.b();
    }
}
