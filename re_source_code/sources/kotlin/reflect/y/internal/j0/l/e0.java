package kotlin.reflect.y.internal.j0.l;

import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.a;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.l.t1.r;
import kotlin.reflect.y.internal.j0.l.w1.i;

/* JADX INFO: compiled from: KotlinType.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e0 implements a, i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f24704f;

    private e0() {
    }

    public /* synthetic */ e0(g gVar) {
        this();
    }

    private final int L0() {
        return g0.a(this) ? super.hashCode() : (((O0().hashCode() * 31) + M0().hashCode()) * 31) + (P0() ? 1 : 0);
    }

    public abstract List<g1> M0();

    public abstract a1 N0();

    public abstract e1 O0();

    public abstract boolean P0();

    public abstract e0 Q0(kotlin.reflect.y.internal.j0.l.t1.g gVar);

    public abstract q1 R0();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        return P0() == e0Var.P0() && r.a.a(R0(), e0Var.R0());
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.a
    public kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g getAnnotations() {
        return k.a(N0());
    }

    public final int hashCode() {
        int i2 = this.f24704f;
        if (i2 != 0) {
            return i2;
        }
        int iL0 = L0();
        this.f24704f = iL0;
        return iL0;
    }

    public abstract h q();
}
