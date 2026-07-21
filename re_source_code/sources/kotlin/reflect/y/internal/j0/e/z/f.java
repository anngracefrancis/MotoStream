package kotlin.reflect.y.internal.j0.e.z;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.e.c;
import kotlin.reflect.y.internal.j0.e.i;
import kotlin.reflect.y.internal.j0.e.n;
import kotlin.reflect.y.internal.j0.e.q;
import kotlin.reflect.y.internal.j0.e.r;
import kotlin.reflect.y.internal.j0.e.s;
import kotlin.reflect.y.internal.j0.e.u;

/* JADX INFO: compiled from: protoTypeTableUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static final q a(q qVar, g gVar) {
        m.f(qVar, "<this>");
        m.f(gVar, "typeTable");
        if (qVar.k0()) {
            return qVar.R();
        }
        if (qVar.l0()) {
            return gVar.a(qVar.S());
        }
        return null;
    }

    public static final q b(r rVar, g gVar) {
        m.f(rVar, "<this>");
        m.f(gVar, "typeTable");
        if (rVar.e0()) {
            q qVarT = rVar.T();
            m.e(qVarT, "expandedType");
            return qVarT;
        }
        if (rVar.f0()) {
            return gVar.a(rVar.U());
        }
        throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
    }

    public static final q c(q qVar, g gVar) {
        m.f(qVar, "<this>");
        m.f(gVar, "typeTable");
        if (qVar.p0()) {
            return qVar.c0();
        }
        if (qVar.q0()) {
            return gVar.a(qVar.d0());
        }
        return null;
    }

    public static final boolean d(i iVar) {
        m.f(iVar, "<this>");
        return iVar.w0() || iVar.x0();
    }

    public static final boolean e(n nVar) {
        m.f(nVar, "<this>");
        return nVar.t0() || nVar.u0();
    }

    public static final q f(c cVar, g gVar) {
        m.f(cVar, "<this>");
        m.f(gVar, "typeTable");
        if (cVar.p1()) {
            return cVar.K0();
        }
        if (cVar.q1()) {
            return gVar.a(cVar.L0());
        }
        return null;
    }

    public static final q g(q qVar, g gVar) {
        m.f(qVar, "<this>");
        m.f(gVar, "typeTable");
        if (qVar.s0()) {
            return qVar.f0();
        }
        if (qVar.t0()) {
            return gVar.a(qVar.g0());
        }
        return null;
    }

    public static final q h(i iVar, g gVar) {
        m.f(iVar, "<this>");
        m.f(gVar, "typeTable");
        if (iVar.w0()) {
            return iVar.g0();
        }
        if (iVar.x0()) {
            return gVar.a(iVar.h0());
        }
        return null;
    }

    public static final q i(n nVar, g gVar) {
        m.f(nVar, "<this>");
        m.f(gVar, "typeTable");
        if (nVar.t0()) {
            return nVar.f0();
        }
        if (nVar.u0()) {
            return gVar.a(nVar.g0());
        }
        return null;
    }

    public static final q j(i iVar, g gVar) {
        m.f(iVar, "<this>");
        m.f(gVar, "typeTable");
        if (iVar.y0()) {
            q qVarI0 = iVar.i0();
            m.e(qVarI0, "returnType");
            return qVarI0;
        }
        if (iVar.z0()) {
            return gVar.a(iVar.j0());
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Function".toString());
    }

    public static final q k(n nVar, g gVar) {
        m.f(nVar, "<this>");
        m.f(gVar, "typeTable");
        if (nVar.v0()) {
            q qVarH0 = nVar.h0();
            m.e(qVarH0, "returnType");
            return qVarH0;
        }
        if (nVar.w0()) {
            return gVar.a(nVar.i0());
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Property".toString());
    }

    public static final List<q> l(c cVar, g gVar) {
        m.f(cVar, "<this>");
        m.f(gVar, "typeTable");
        List<q> listB1 = cVar.b1();
        if (!(!listB1.isEmpty())) {
            listB1 = null;
        }
        if (listB1 == null) {
            List<Integer> listA1 = cVar.a1();
            m.e(listA1, "supertypeIdList");
            listB1 = new ArrayList<>(v.u(listA1, 10));
            for (Integer num : listA1) {
                m.e(num, "it");
                listB1.add(gVar.a(num.intValue()));
            }
        }
        return listB1;
    }

    public static final q m(q.b bVar, g gVar) {
        m.f(bVar, "<this>");
        m.f(gVar, "typeTable");
        if (bVar.B()) {
            return bVar.y();
        }
        if (bVar.C()) {
            return gVar.a(bVar.z());
        }
        return null;
    }

    public static final q n(u uVar, g gVar) {
        m.f(uVar, "<this>");
        m.f(gVar, "typeTable");
        if (uVar.S()) {
            q qVarM = uVar.M();
            m.e(qVarM, "type");
            return qVarM;
        }
        if (uVar.T()) {
            return gVar.a(uVar.N());
        }
        throw new IllegalStateException("No type in ProtoBuf.ValueParameter".toString());
    }

    public static final q o(r rVar, g gVar) {
        m.f(rVar, "<this>");
        m.f(gVar, "typeTable");
        if (rVar.i0()) {
            q qVarB0 = rVar.b0();
            m.e(qVarB0, "underlyingType");
            return qVarB0;
        }
        if (rVar.j0()) {
            return gVar.a(rVar.c0());
        }
        throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
    }

    public static final List<q> p(s sVar, g gVar) {
        m.f(sVar, "<this>");
        m.f(gVar, "typeTable");
        List<q> listS = sVar.S();
        if (!(!listS.isEmpty())) {
            listS = null;
        }
        if (listS == null) {
            List<Integer> listR = sVar.R();
            m.e(listR, "upperBoundIdList");
            listS = new ArrayList<>(v.u(listR, 10));
            for (Integer num : listR) {
                m.e(num, "it");
                listS.add(gVar.a(num.intValue()));
            }
        }
        return listS;
    }

    public static final q q(u uVar, g gVar) {
        m.f(uVar, "<this>");
        m.f(gVar, "typeTable");
        if (uVar.U()) {
            return uVar.O();
        }
        if (uVar.V()) {
            return gVar.a(uVar.P());
        }
        return null;
    }
}
