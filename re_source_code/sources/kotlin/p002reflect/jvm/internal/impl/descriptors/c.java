package kotlin.p002reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.e1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.r1;

/* JADX INFO: compiled from: typeParameterUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
final class c implements e1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e1 f25126f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final m f25127g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f25128h;

    public c(e1 e1Var, m mVar, int i2) {
        m.f(e1Var, "originalDescriptor");
        m.f(mVar, "declarationDescriptor");
        this.f25126f = e1Var;
        this.f25127g = mVar;
        this.f25128h = i2;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e1
    public boolean F() {
        return this.f25126f.F();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.m
    public <R, D> R L(o<R, D> oVar, D d2) {
        return (R) this.f25126f.L(oVar, d2);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n, kotlin.p002reflect.jvm.internal.impl.descriptors.m
    public m b() {
        return this.f25127g;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e1
    public int g() {
        return this.f25128h + this.f25126f.g();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.a
    public g getAnnotations() {
        return this.f25126f.getAnnotations();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.i0
    public f getName() {
        return this.f25126f.getName();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e1
    public List<e0> getUpperBounds() {
        return this.f25126f.getUpperBounds();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e1, kotlin.p002reflect.jvm.internal.impl.descriptors.h
    public e1 h() {
        return this.f25126f.h();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e1
    public n h0() {
        return this.f25126f.h0();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e1
    public r1 n() {
        return this.f25126f.n();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e1
    public boolean o0() {
        return true;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.h
    public m0 s() {
        return this.f25126f.s();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p
    public z0 t() {
        return this.f25126f.t();
    }

    public String toString() {
        return this.f25126f + "[inner-copy]";
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.m
    public e1 a() {
        e1 e1VarA = this.f25126f.a();
        m.e(e1VarA, "originalDescriptor.original");
        return e1VarA;
    }
}
