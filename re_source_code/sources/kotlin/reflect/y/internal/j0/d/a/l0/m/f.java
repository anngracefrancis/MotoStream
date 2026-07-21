package kotlin.reflect.y.internal.j0.d.a.l0.m;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.c0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.h.c;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.l.a1;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.l0;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.t1.e;
import kotlin.reflect.y.internal.j0.l.t1.g;
import kotlin.reflect.y.internal.j0.l.y;
import kotlin.text.v;

/* JADX INFO: compiled from: RawType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends y implements l0 {

    /* JADX INFO: compiled from: RawType.kt */
    static final class a extends Lambda implements Function1<String, CharSequence> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f23587f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(String str) {
            m.f(str, "it");
            return "(raw) " + str;
        }
    }

    private f(m0 m0Var, m0 m0Var2, boolean z) {
        super(m0Var, m0Var2);
        if (z) {
            return;
        }
        e.a.d(m0Var, m0Var2);
    }

    private static final boolean b1(String str, String str2) {
        return m.a(str, v.m0(str2, "out ")) || m.a(str2, "*");
    }

    private static final List<String> c1(c cVar, e0 e0Var) {
        List<g1> listM0 = e0Var.M0();
        ArrayList arrayList = new ArrayList(kotlin.collections.v.u(listM0, 10));
        Iterator<T> it = listM0.iterator();
        while (it.hasNext()) {
            arrayList.add(cVar.x((g1) it.next()));
        }
        return arrayList;
    }

    private static final String d1(String str, String str2) {
        if (!v.I(str, '<', false, 2, null)) {
            return str;
        }
        return v.L0(str, '<', null, 2, null) + '<' + str2 + '>' + v.I0(str, '>', null, 2, null);
    }

    @Override // kotlin.reflect.y.internal.j0.l.y
    public m0 V0() {
        return W0();
    }

    @Override // kotlin.reflect.y.internal.j0.l.y
    public String Y0(c cVar, kotlin.reflect.y.internal.j0.h.f fVar) {
        m.f(cVar, "renderer");
        m.f(fVar, "options");
        String strW = cVar.w(W0());
        String strW2 = cVar.w(X0());
        if (fVar.n()) {
            return "raw (" + strW + ".." + strW2 + ')';
        }
        if (X0().M0().isEmpty()) {
            return cVar.t(strW, strW2, kotlin.reflect.y.internal.j0.l.x1.a.h(this));
        }
        List<String> listC1 = c1(cVar, W0());
        List<String> listC2 = c1(cVar, X0());
        String strE0 = c0.e0(listC1, ", ", null, null, 0, null, a.f23587f, 30, null);
        List<Pair> listL0 = c0.L0(listC1, listC2);
        boolean z = true;
        if (!(listL0 instanceof Collection) || !listL0.isEmpty()) {
            for (Pair pair : listL0) {
                if (!b1((String) pair.c(), (String) pair.d())) {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            strW2 = d1(strW2, strE0);
        }
        String strD1 = d1(strW, strE0);
        return m.a(strD1, strW2) ? strD1 : cVar.t(strD1, strW2, kotlin.reflect.y.internal.j0.l.x1.a.h(this));
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* JADX INFO: renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public f S0(boolean z) {
        return new f(W0().S0(z), X0().S0(z));
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* JADX INFO: renamed from: a1, reason: merged with bridge method [inline-methods] */
    public y Y0(g gVar) {
        m.f(gVar, "kotlinTypeRefiner");
        e0 e0VarA = gVar.a(W0());
        m.d(e0VarA, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        e0 e0VarA2 = gVar.a(X0());
        m.d(e0VarA2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new f((m0) e0VarA, (m0) e0VarA2, true);
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* JADX INFO: renamed from: e1, reason: merged with bridge method [inline-methods] */
    public f U0(a1 a1Var) {
        m.f(a1Var, "newAttributes");
        return new f(W0().U0(a1Var), X0().U0(a1Var));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.y.internal.j0.l.y, kotlin.reflect.y.internal.j0.l.e0
    public h q() {
        kotlin.p002reflect.jvm.internal.impl.descriptors.h hVarW = O0().w();
        g gVar = null;
        Object[] objArr = 0;
        kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar = hVarW instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e ? (kotlin.p002reflect.jvm.internal.impl.descriptors.e) hVarW : null;
        if (eVar != null) {
            h hVarA0 = eVar.a0(new e(gVar, 1, objArr == true ? 1 : 0));
            m.e(hVarA0, "classDescriptor.getMemberScope(RawSubstitution())");
            return hVarA0;
        }
        throw new IllegalStateException(("Incorrect classifier: " + O0().w()).toString());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(m0 m0Var, m0 m0Var2) {
        this(m0Var, m0Var2, false);
        m.f(m0Var, "lowerBound");
        m.f(m0Var2, "upperBound");
    }
}
