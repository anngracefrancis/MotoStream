package kotlin.reflect.y.internal.j0.l;

import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.i.w.h;

/* JADX INFO: compiled from: KotlinType.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s1 extends e0 {
    public s1() {
        super(null);
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public List<g1> M0() {
        return S0().M0();
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public a1 N0() {
        return S0().N0();
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public e1 O0() {
        return S0().O0();
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public boolean P0() {
        return S0().P0();
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public final q1 R0() {
        e0 e0VarS0 = S0();
        while (e0VarS0 instanceof s1) {
            e0VarS0 = ((s1) e0VarS0).S0();
        }
        m.d(e0VarS0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.UnwrappedType");
        return (q1) e0VarS0;
    }

    protected abstract e0 S0();

    public boolean T0() {
        return true;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public h q() {
        return S0().q();
    }

    public String toString() {
        return T0() ? S0().toString() : "<Not computed yet>";
    }
}
