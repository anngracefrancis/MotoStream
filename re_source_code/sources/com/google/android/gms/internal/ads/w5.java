package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class w5 implements zzz {
    private final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ y5 f13496b;

    w5(zzayu zzayuVar, String str, y5 y5Var) {
        this.a = str;
        this.f13496b = y5Var;
    }

    @Override // com.google.android.gms.internal.ads.zzz
    public final void a(zzaf zzafVar) {
        String str = this.a;
        String string = zzafVar.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(string).length());
        sb.append("Failed to load URL: ");
        sb.append(str);
        sb.append("\n");
        sb.append(string);
        zzbad.i(sb.toString());
        this.f13496b.b(null);
    }
}
