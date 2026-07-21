package kotlin.reflect.y.internal.j0.l.y1;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.t1.e;

/* JADX INFO: compiled from: CapturedTypeApproximation.kt */
/* JADX INFO: loaded from: classes3.dex */
final class c {
    private final e1 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e0 f24882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e0 f24883c;

    public c(e1 e1Var, e0 e0Var, e0 e0Var2) {
        m.f(e1Var, "typeParameter");
        m.f(e0Var, "inProjection");
        m.f(e0Var2, "outProjection");
        this.a = e1Var;
        this.f24882b = e0Var;
        this.f24883c = e0Var2;
    }

    public final e0 a() {
        return this.f24882b;
    }

    public final e0 b() {
        return this.f24883c;
    }

    public final e1 c() {
        return this.a;
    }

    public final boolean d() {
        return e.a.d(this.f24882b, this.f24883c);
    }
}
