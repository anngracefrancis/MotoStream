package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.a;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.y.internal.j0.d.b.e;
import kotlin.u;

/* JADX INFO: compiled from: RuntimeModuleData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class k {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.j.b.k f25320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.p002reflect.jvm.internal.impl.descriptors.r1.a.a f25321c;

    /* JADX INFO: compiled from: RuntimeModuleData.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final k a(ClassLoader classLoader) {
            m.f(classLoader, "classLoader");
            g gVar = new g(classLoader);
            e.a aVar = e.a;
            ClassLoader classLoader2 = u.class.getClassLoader();
            m.e(classLoader2, "Unit::class.java.classLoader");
            e.a.C0350a c0350aA = aVar.a(gVar, new g(classLoader2), new d(classLoader), "runtime module for " + classLoader, j.f25319b, l.a);
            return new k(c0350aA.a().a(), new kotlin.p002reflect.jvm.internal.impl.descriptors.r1.a.a(c0350aA.b(), gVar), null);
        }
    }

    private k(kotlin.reflect.y.internal.j0.j.b.k kVar, kotlin.p002reflect.jvm.internal.impl.descriptors.r1.a.a aVar) {
        this.f25320b = kVar;
        this.f25321c = aVar;
    }

    public /* synthetic */ k(kotlin.reflect.y.internal.j0.j.b.k kVar, kotlin.p002reflect.jvm.internal.impl.descriptors.r1.a.a aVar, g gVar) {
        this(kVar, aVar);
    }

    public final kotlin.reflect.y.internal.j0.j.b.k a() {
        return this.f25320b;
    }

    public final g0 b() {
        return this.f25320b.p();
    }

    public final kotlin.p002reflect.jvm.internal.impl.descriptors.r1.a.a c() {
        return this.f25321c;
    }
}
