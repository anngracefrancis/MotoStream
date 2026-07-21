package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class v2 implements s3 {
    private static final d3 a = new y2();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d3 f17271b;

    public v2() {
        this(new x2(m2.c(), b()));
    }

    private static d3 b() {
        try {
            return (d3) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return a;
        }
    }

    private static boolean c(e3 e3Var) {
        return e3Var.a() == zzfd.zze.f17404i;
    }

    @Override // com.google.android.gms.internal.measurement.s3
    public final <T> p3<T> a(Class<T> cls) {
        r3.p(cls);
        e3 e3VarB = this.f17271b.b(cls);
        if (e3VarB.b()) {
            return zzfd.class.isAssignableFrom(cls) ? h3.k(r3.B(), e2.a(), e3VarB.c()) : h3.k(r3.f(), e2.b(), e3VarB.c());
        }
        if (zzfd.class.isAssignableFrom(cls)) {
            return c(e3VarB) ? g3.q(cls, e3VarB, k3.b(), s2.d(), r3.B(), e2.a(), b3.b()) : g3.q(cls, e3VarB, k3.b(), s2.d(), r3.B(), null, b3.b());
        }
        return c(e3VarB) ? g3.q(cls, e3VarB, k3.a(), s2.a(), r3.f(), e2.b(), b3.a()) : g3.q(cls, e3VarB, k3.a(), s2.a(), r3.v(), null, b3.a());
    }

    private v2(d3 d3Var) {
        this.f17271b = (d3) zzff.f(d3Var, "messageInfoFactory");
    }
}
