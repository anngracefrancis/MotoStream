package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class h3 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ int f17794f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f17795g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ Object f17796h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ Object f17797i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ Object f17798j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzet f17799k;

    h3(zzet zzetVar, int i2, String str, Object obj, Object obj2, Object obj3) {
        this.f17799k = zzetVar;
        this.f17794f = i2;
        this.f17795g = str;
        this.f17796h = obj;
        this.f17797i = obj2;
        this.f17798j = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r3 r3VarB = this.f17799k.a.B();
        if (!r3VarB.t()) {
            this.f17799k.A(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        if (this.f17799k.f18105c == 0) {
            if (this.f17799k.n().E()) {
                zzet zzetVar = this.f17799k;
                zzetVar.G();
                zzetVar.f18105c = 'C';
            } else {
                zzet zzetVar2 = this.f17799k;
                zzetVar2.G();
                zzetVar2.f18105c = 'c';
            }
        }
        if (this.f17799k.f18106d < 0) {
            zzet zzetVar3 = this.f17799k;
            zzetVar3.f18106d = zzetVar3.n().C();
        }
        char cCharAt = "01VDIWEA?".charAt(this.f17794f);
        char c2 = this.f17799k.f18105c;
        long j2 = this.f17799k.f18106d;
        String strZ = zzet.z(true, this.f17795g, this.f17796h, this.f17797i, this.f17798j);
        StringBuilder sb = new StringBuilder(String.valueOf(strZ).length() + 24);
        sb.append("2");
        sb.append(cCharAt);
        sb.append(c2);
        sb.append(j2);
        sb.append(":");
        sb.append(strZ);
        String string = sb.toString();
        if (string.length() > 1024) {
            string = this.f17795g.substring(0, 1024);
        }
        r3VarB.f17921e.b(string, 1L);
    }
}
