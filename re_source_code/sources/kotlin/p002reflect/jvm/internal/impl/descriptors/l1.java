package kotlin.p002reflect.jvm.internal.impl.descriptors;

import java.util.Map;
import kotlin.collections.p0;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: Visibilities.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class l1 {
    public static final l1 a = new l1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<m1, Integer> f25151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final h f25152c;

    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class a extends m1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f25153c = new a();

        private a() {
            super("inherited", false);
        }
    }

    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class b extends m1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f25154c = new b();

        private b() {
            super("internal", false);
        }
    }

    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class c extends m1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f25155c = new c();

        private c() {
            super("invisible_fake", false);
        }
    }

    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class d extends m1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f25156c = new d();

        private d() {
            super("local", false);
        }
    }

    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class e extends m1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f25157c = new e();

        private e() {
            super("private", false);
        }
    }

    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class f extends m1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f f25158c = new f();

        private f() {
            super("private_to_this", false);
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.m1
        public String b() {
            return "private/*private to this*/";
        }
    }

    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class g extends m1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final g f25159c = new g();

        private g() {
            super("protected", true);
        }
    }

    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class h extends m1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final h f25160c = new h();

        private h() {
            super("public", true);
        }
    }

    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class i extends m1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final i f25161c = new i();

        private i() {
            super("unknown", false);
        }
    }

    static {
        Map mapC = p0.c();
        mapC.put(f.f25158c, 0);
        mapC.put(e.f25157c, 0);
        mapC.put(b.f25154c, 1);
        mapC.put(g.f25159c, 1);
        h hVar = h.f25160c;
        mapC.put(hVar, 2);
        f25151b = p0.b(mapC);
        f25152c = hVar;
    }

    private l1() {
    }

    public final Integer a(m1 m1Var, m1 m1Var2) {
        m.f(m1Var, "first");
        m.f(m1Var2, "second");
        if (m1Var == m1Var2) {
            return 0;
        }
        Map<m1, Integer> map = f25151b;
        Integer num = map.get(m1Var);
        Integer num2 = map.get(m1Var2);
        if (num == null || num2 == null || m.a(num, num2)) {
            return null;
        }
        return Integer.valueOf(num.intValue() - num2.intValue());
    }

    public final boolean b(m1 m1Var) {
        m.f(m1Var, "visibility");
        return m1Var == e.f25157c || m1Var == f.f25158c;
    }
}
