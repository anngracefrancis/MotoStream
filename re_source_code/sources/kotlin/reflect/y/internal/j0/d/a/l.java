package kotlin.reflect.y.internal.j0.d.a;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.c0;
import kotlin.collections.u;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.w0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.y.internal.j0.d.a.l0.m.f;
import kotlin.reflect.y.internal.j0.i.e;
import kotlin.reflect.y.internal.j0.i.j;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.sequences.Sequence;
import kotlin.sequences.n;

/* JADX INFO: compiled from: ErasedOverridabilityCondition.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class l implements e {

    /* JADX INFO: compiled from: ErasedOverridabilityCondition.kt */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[j.i.a.values().length];
            iArr[j.i.a.OVERRIDABLE.ordinal()] = 1;
            a = iArr;
        }
    }

    /* JADX INFO: compiled from: ErasedOverridabilityCondition.kt */
    static final class b extends Lambda implements Function1<i1, e0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f23443f = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final e0 invoke(i1 i1Var) {
            return i1Var.getType();
        }
    }

    @Override // kotlin.reflect.y.internal.j0.i.e
    public e.a a() {
        return e.a.SUCCESS_ONLY;
    }

    @Override // kotlin.reflect.y.internal.j0.i.e
    public e.b b(kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar, kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar2, kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar) {
        boolean z;
        kotlin.p002reflect.jvm.internal.impl.descriptors.a aVarC;
        m.f(aVar, "superDescriptor");
        m.f(aVar2, "subDescriptor");
        if (aVar2 instanceof kotlin.reflect.y.internal.j0.d.a.k0.e) {
            kotlin.reflect.y.internal.j0.d.a.k0.e eVar2 = (kotlin.reflect.y.internal.j0.d.a.k0.e) aVar2;
            List<e1> typeParameters = eVar2.getTypeParameters();
            m.e(typeParameters, "subDescriptor.typeParameters");
            if (!(!typeParameters.isEmpty())) {
                j.i iVarW = j.w(aVar, aVar2);
                if ((iVarW != null ? iVarW.c() : null) != null) {
                    return e.b.UNKNOWN;
                }
                List<i1> listF = eVar2.f();
                m.e(listF, "subDescriptor.valueParameters");
                Sequence sequenceU = n.u(c0.J(listF), b.f23443f);
                e0 returnType = eVar2.getReturnType();
                m.c(returnType);
                Sequence sequenceX = n.x(sequenceU, returnType);
                w0 w0VarM0 = eVar2.m0();
                Iterator it = n.w(sequenceX, u.n(w0VarM0 != null ? w0VarM0.getType() : null)).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    e0 e0Var = (e0) it.next();
                    if ((e0Var.M0().isEmpty() ^ true) && !(e0Var.R0() instanceof f)) {
                        z = true;
                        break;
                    }
                }
                if (!z && (aVarC = aVar.c(new kotlin.reflect.y.internal.j0.d.a.l0.m.e(null, 1, null).c())) != null) {
                    if (aVarC instanceof y0) {
                        y0 y0Var = (y0) aVarC;
                        List<e1> typeParameters2 = y0Var.getTypeParameters();
                        m.e(typeParameters2, "erasedSuper.typeParameters");
                        if (!typeParameters2.isEmpty()) {
                            aVarC = y0Var.u().m(u.j()).c();
                            m.c(aVarC);
                        }
                    }
                    j.i.a aVarC2 = j.f24327b.F(aVarC, aVar2, false).c();
                    m.e(aVarC2, "DEFAULT.isOverridableByW…Descriptor, false).result");
                    return a.a[aVarC2.ordinal()] == 1 ? e.b.OVERRIDABLE : e.b.UNKNOWN;
                }
                return e.b.UNKNOWN;
            }
        }
        return e.b.UNKNOWN;
    }
}
