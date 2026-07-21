package kotlin.reflect.y.internal.j0.j.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.IntIterator;
import kotlin.collections.p0;
import kotlin.collections.q0;
import kotlin.collections.s;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.j0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.x;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.ranges.l;
import kotlin.reflect.y.internal.j0.e.b;
import kotlin.reflect.y.internal.j0.e.z.c;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.d;
import kotlin.reflect.y.internal.j0.i.r.g;
import kotlin.reflect.y.internal.j0.i.r.i;
import kotlin.reflect.y.internal.j0.i.r.j;
import kotlin.reflect.y.internal.j0.i.r.k;
import kotlin.reflect.y.internal.j0.i.r.q;
import kotlin.reflect.y.internal.j0.i.r.r;
import kotlin.reflect.y.internal.j0.i.r.w;
import kotlin.reflect.y.internal.j0.i.r.y;
import kotlin.reflect.y.internal.j0.i.r.z;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.m0;

/* JADX INFO: compiled from: AnnotationDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private final g0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j0 f24488b;

    /* JADX INFO: compiled from: AnnotationDeserializer.kt */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.C0361b.c.EnumC0364c.values().length];
            iArr[b.C0361b.c.EnumC0364c.BYTE.ordinal()] = 1;
            iArr[b.C0361b.c.EnumC0364c.CHAR.ordinal()] = 2;
            iArr[b.C0361b.c.EnumC0364c.SHORT.ordinal()] = 3;
            iArr[b.C0361b.c.EnumC0364c.INT.ordinal()] = 4;
            iArr[b.C0361b.c.EnumC0364c.LONG.ordinal()] = 5;
            iArr[b.C0361b.c.EnumC0364c.FLOAT.ordinal()] = 6;
            iArr[b.C0361b.c.EnumC0364c.DOUBLE.ordinal()] = 7;
            iArr[b.C0361b.c.EnumC0364c.BOOLEAN.ordinal()] = 8;
            iArr[b.C0361b.c.EnumC0364c.STRING.ordinal()] = 9;
            iArr[b.C0361b.c.EnumC0364c.CLASS.ordinal()] = 10;
            iArr[b.C0361b.c.EnumC0364c.ENUM.ordinal()] = 11;
            iArr[b.C0361b.c.EnumC0364c.ANNOTATION.ordinal()] = 12;
            iArr[b.C0361b.c.EnumC0364c.ARRAY.ordinal()] = 13;
            a = iArr;
        }
    }

    public e(g0 g0Var, j0 j0Var) {
        m.f(g0Var, "module");
        m.f(j0Var, "notFoundClasses");
        this.a = g0Var;
        this.f24488b = j0Var;
    }

    private final boolean b(g<?> gVar, e0 e0Var, b.C0361b.c cVar) {
        b.C0361b.c.EnumC0364c enumC0364cS = cVar.S();
        int i2 = enumC0364cS == null ? -1 : a.a[enumC0364cS.ordinal()];
        if (i2 == 10) {
            h hVarW = e0Var.O0().w();
            kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar = hVarW instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e ? (kotlin.p002reflect.jvm.internal.impl.descriptors.e) hVarW : null;
            if (eVar != null && !kotlin.reflect.y.internal.j0.b.h.k0(eVar)) {
                return false;
            }
        } else {
            if (i2 != 13) {
                return m.a(gVar.a(this.a), e0Var);
            }
            if (!((gVar instanceof kotlin.reflect.y.internal.j0.i.r.b) && ((kotlin.reflect.y.internal.j0.i.r.b) gVar).b().size() == cVar.J().size())) {
                throw new IllegalStateException(("Deserialized ArrayValue should have the same number of elements as the original array value: " + gVar).toString());
            }
            e0 e0VarK = c().k(e0Var);
            m.e(e0VarK, "builtIns.getArrayElementType(expectedType)");
            kotlin.reflect.y.internal.j0.i.r.b bVar = (kotlin.reflect.y.internal.j0.i.r.b) gVar;
            Iterable iterableK = u.k(bVar.b());
            if (!(iterableK instanceof Collection) || !((Collection) iterableK).isEmpty()) {
                Iterator it = iterableK.iterator();
                while (it.hasNext()) {
                    int iB = ((IntIterator) it).b();
                    g<?> gVar2 = bVar.b().get(iB);
                    b.C0361b.c cVarH = cVar.H(iB);
                    m.e(cVarH, "value.getArrayElement(i)");
                    if (!b(gVar2, e0VarK, cVarH)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private final kotlin.reflect.y.internal.j0.b.h c() {
        return this.a.o();
    }

    private final Pair<f, g<?>> d(b.C0361b c0361b, Map<f, ? extends i1> map, c cVar) {
        i1 i1Var = map.get(x.b(cVar, c0361b.w()));
        if (i1Var == null) {
            return null;
        }
        f fVarB = x.b(cVar, c0361b.w());
        e0 type = i1Var.getType();
        m.e(type, "parameter.type");
        b.C0361b.c cVarX = c0361b.x();
        m.e(cVarX, "proto.value");
        return new Pair<>(fVarB, g(type, cVarX, cVar));
    }

    private final kotlin.p002reflect.jvm.internal.impl.descriptors.e e(kotlin.reflect.y.internal.j0.f.b bVar) {
        return x.c(this.a, bVar, this.f24488b);
    }

    private final g<?> g(e0 e0Var, b.C0361b.c cVar, c cVar2) {
        g<?> gVarF = f(e0Var, cVar, cVar2);
        if (!b(gVarF, e0Var, cVar)) {
            gVarF = null;
        }
        if (gVarF != null) {
            return gVarF;
        }
        return k.f24364b.a("Unexpected argument value: actual type " + cVar.S() + " != expected type " + e0Var);
    }

    public final kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c a(b bVar, c cVar) {
        m.f(bVar, "proto");
        m.f(cVar, "nameResolver");
        kotlin.p002reflect.jvm.internal.impl.descriptors.e eVarE = e(x.a(cVar, bVar.A()));
        Map mapI = q0.i();
        if (bVar.x() != 0 && !kotlin.reflect.y.internal.j0.l.u1.k.m(eVarE) && d.t(eVarE)) {
            Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.d> collectionK = eVarE.k();
            m.e(collectionK, "annotationClass.constructors");
            kotlin.p002reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.p002reflect.jvm.internal.impl.descriptors.d) s.t0(collectionK);
            if (dVar != null) {
                List<i1> listF = dVar.f();
                m.e(listF, "constructor.valueParameters");
                LinkedHashMap linkedHashMap = new LinkedHashMap(l.b(p0.e(v.u(listF, 10)), 16));
                for (Object obj : listF) {
                    linkedHashMap.put(((i1) obj).getName(), obj);
                }
                List<b.C0361b> listY = bVar.y();
                m.e(listY, "proto.argumentList");
                ArrayList arrayList = new ArrayList();
                for (b.C0361b c0361b : listY) {
                    m.e(c0361b, "it");
                    Pair<f, g<?>> pairD = d(c0361b, linkedHashMap, cVar);
                    if (pairD != null) {
                        arrayList.add(pairD);
                    }
                }
                mapI = q0.q(arrayList);
            }
        }
        return new kotlin.p002reflect.jvm.internal.impl.descriptors.n1.d(eVarE.s(), mapI, z0.a);
    }

    public final g<?> f(e0 e0Var, b.C0361b.c cVar, c cVar2) {
        g<?> eVar;
        m.f(e0Var, "expectedType");
        m.f(cVar, "value");
        m.f(cVar2, "nameResolver");
        Boolean boolD = kotlin.reflect.y.internal.j0.e.z.b.O.d(cVar.O());
        m.e(boolD, "IS_UNSIGNED.get(value.flags)");
        boolean zBooleanValue = boolD.booleanValue();
        b.C0361b.c.EnumC0364c enumC0364cS = cVar.S();
        switch (enumC0364cS == null ? -1 : a.a[enumC0364cS.ordinal()]) {
            case 1:
                byte bQ = (byte) cVar.Q();
                return zBooleanValue ? new w(bQ) : new kotlin.reflect.y.internal.j0.i.r.d(bQ);
            case 2:
                eVar = new kotlin.reflect.y.internal.j0.i.r.e((char) cVar.Q());
                break;
            case 3:
                short sQ = (short) cVar.Q();
                return zBooleanValue ? new z(sQ) : new kotlin.reflect.y.internal.j0.i.r.u(sQ);
            case 4:
                int iQ = (int) cVar.Q();
                eVar = zBooleanValue ? new kotlin.reflect.y.internal.j0.i.r.x(iQ) : new kotlin.reflect.y.internal.j0.i.r.m(iQ);
                break;
            case 5:
                long jQ = cVar.Q();
                return zBooleanValue ? new y(jQ) : new r(jQ);
            case 6:
                eVar = new kotlin.reflect.y.internal.j0.i.r.l(cVar.P());
                break;
            case 7:
                eVar = new i(cVar.M());
                break;
            case 8:
                eVar = new kotlin.reflect.y.internal.j0.i.r.c(cVar.Q() != 0);
                break;
            case 9:
                eVar = new kotlin.reflect.y.internal.j0.i.r.v(cVar2.getString(cVar.R()));
                break;
            case 10:
                eVar = new q(x.a(cVar2, cVar.K()), cVar.G());
                break;
            case 11:
                eVar = new j(x.a(cVar2, cVar.K()), x.b(cVar2, cVar.N()));
                break;
            case 12:
                b bVarF = cVar.F();
                m.e(bVarF, "value.annotation");
                eVar = new kotlin.reflect.y.internal.j0.i.r.a(a(bVarF, cVar2));
                break;
            case 13:
                List<b.C0361b.c> listJ = cVar.J();
                m.e(listJ, "value.arrayElementList");
                ArrayList arrayList = new ArrayList(v.u(listJ, 10));
                for (b.C0361b.c cVar3 : listJ) {
                    m0 m0VarI = c().i();
                    m.e(m0VarI, "builtIns.anyType");
                    m.e(cVar3, "it");
                    arrayList.add(f(m0VarI, cVar3, cVar2));
                }
                return new n(arrayList, e0Var);
            default:
                throw new IllegalStateException(("Unsupported annotation argument type: " + cVar.S() + " (expected " + e0Var + ')').toString());
        }
        return eVar;
    }
}
