package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class pv implements mw {
    private static final yv a = new rv();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final yv f13189b;

    public pv() {
        this(new sv(fv.c(), c()));
    }

    private static boolean b(xv xvVar) {
        return xvVar.c() == zzdob.zze.f16029i;
    }

    private static yv c() {
        try {
            return (yv) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return a;
        }
    }

    @Override // com.google.android.gms.internal.ads.mw
    public final <T> lw<T> a(Class<T> cls) {
        nw.L(cls);
        xv xvVarA = this.f13189b.a(cls);
        if (xvVarA.a()) {
            return zzdob.class.isAssignableFrom(cls) ? bw.k(nw.s(), xu.b(), xvVarA.b()) : bw.k(nw.q(), xu.c(), xvVarA.b());
        }
        if (zzdob.class.isAssignableFrom(cls)) {
            return b(xvVarA) ? aw.p(cls, xvVarA, ew.b(), kv.d(), nw.s(), xu.b(), wv.b()) : aw.p(cls, xvVarA, ew.b(), kv.d(), nw.s(), null, wv.b());
        }
        return b(xvVarA) ? aw.p(cls, xvVarA, ew.a(), kv.c(), nw.q(), xu.c(), wv.a()) : aw.p(cls, xvVarA, ew.a(), kv.c(), nw.r(), null, wv.a());
    }

    private pv(yv yvVar) {
        this.f13189b = (yv) zzdod.d(yvVar, "messageInfoFactory");
    }
}
