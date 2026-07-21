package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: ManifestSchemaFactory.java */
/* JADX INFO: loaded from: classes.dex */
final class i0 implements g1 {
    private static final p0 a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p0 f1314b;

    /* JADX INFO: compiled from: ManifestSchemaFactory.java */
    static class a implements p0 {
        a() {
        }

        @Override // androidx.datastore.preferences.protobuf.p0
        public o0 a(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }

        @Override // androidx.datastore.preferences.protobuf.p0
        public boolean b(Class<?> cls) {
            return false;
        }
    }

    /* JADX INFO: compiled from: ManifestSchemaFactory.java */
    private static class b implements p0 {
        private p0[] a;

        b(p0... p0VarArr) {
            this.a = p0VarArr;
        }

        @Override // androidx.datastore.preferences.protobuf.p0
        public o0 a(Class<?> cls) {
            for (p0 p0Var : this.a) {
                if (p0Var.b(cls)) {
                    return p0Var.a(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }

        @Override // androidx.datastore.preferences.protobuf.p0
        public boolean b(Class<?> cls) {
            for (p0 p0Var : this.a) {
                if (p0Var.b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public i0() {
        this(b());
    }

    private static p0 b() {
        return new b(x.c(), c());
    }

    private static p0 c() {
        try {
            return (p0) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return a;
        }
    }

    private static boolean d(o0 o0Var) {
        return o0Var.c() == a1.PROTO2;
    }

    private static <T> f1<T> e(Class<T> cls, o0 o0Var) {
        if (y.class.isAssignableFrom(cls)) {
            return d(o0Var) ? t0.N(cls, o0Var, x0.b(), g0.b(), h1.M(), s.b(), n0.b()) : t0.N(cls, o0Var, x0.b(), g0.b(), h1.M(), null, n0.b());
        }
        return d(o0Var) ? t0.N(cls, o0Var, x0.a(), g0.a(), h1.H(), s.a(), n0.a()) : t0.N(cls, o0Var, x0.a(), g0.a(), h1.I(), null, n0.a());
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public <T> f1<T> a(Class<T> cls) {
        h1.J(cls);
        o0 o0VarA = this.f1314b.a(cls);
        if (o0VarA.a()) {
            return y.class.isAssignableFrom(cls) ? u0.l(h1.M(), s.b(), o0VarA.b()) : u0.l(h1.H(), s.a(), o0VarA.b());
        }
        return e(cls, o0VarA);
    }

    private i0(p0 p0Var) {
        this.f1314b = (p0) a0.b(p0Var, "messageInfoFactory");
    }
}
