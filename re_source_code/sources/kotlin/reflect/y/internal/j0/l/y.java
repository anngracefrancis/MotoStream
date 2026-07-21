package kotlin.reflect.y.internal.j0.l;

import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.h.c;
import kotlin.reflect.y.internal.j0.h.f;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.l.w1.g;

/* JADX INFO: compiled from: KotlinType.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class y extends q1 implements g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final m0 f24878g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final m0 f24879h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(m0 m0Var, m0 m0Var2) {
        super(null);
        m.f(m0Var, "lowerBound");
        m.f(m0Var2, "upperBound");
        this.f24878g = m0Var;
        this.f24879h = m0Var2;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public List<g1> M0() {
        return V0().M0();
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public a1 N0() {
        return V0().N0();
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public e1 O0() {
        return V0().O0();
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public boolean P0() {
        return V0().P0();
    }

    public abstract m0 V0();

    public final m0 W0() {
        return this.f24878g;
    }

    public final m0 X0() {
        return this.f24879h;
    }

    public abstract String Y0(c cVar, f fVar);

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public h q() {
        return V0().q();
    }

    public String toString() {
        return c.f24255j.w(this);
    }
}
