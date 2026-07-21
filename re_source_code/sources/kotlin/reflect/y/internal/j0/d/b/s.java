package kotlin.reflect.y.internal.j0.d.b;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.y.internal.j0.e.a0.b.e;
import kotlin.reflect.y.internal.j0.j.b.g0.f;
import kotlin.reflect.y.internal.j0.j.b.t;

/* JADX INFO: compiled from: KotlinJvmBinarySourceElement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q f23815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final t<e> f23816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f23817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.j.b.g0.e f23818e;

    public s(q qVar, t<e> tVar, boolean z, kotlin.reflect.y.internal.j0.j.b.g0.e eVar) {
        m.f(qVar, "binaryClass");
        m.f(eVar, "abiStability");
        this.f23815b = qVar;
        this.f23816c = tVar;
        this.f23817d = z;
        this.f23818e = eVar;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.z0
    public a1 a() {
        a1 a1Var = a1.a;
        m.e(a1Var, "NO_SOURCE_FILE");
        return a1Var;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.g0.f
    public String c() {
        return "Class '" + this.f23815b.e().b().b() + '\'';
    }

    public final q d() {
        return this.f23815b;
    }

    public String toString() {
        return s.class.getSimpleName() + ": " + this.f23815b;
    }
}
