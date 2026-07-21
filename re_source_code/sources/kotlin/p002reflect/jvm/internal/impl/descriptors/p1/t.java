package kotlin.p002reflect.jvm.internal.impl.descriptors.p1;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.l.j1;

/* JADX INFO: compiled from: ModuleAwareClassDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class t implements e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f25296f = new a(null);

    /* JADX INFO: compiled from: ModuleAwareClassDescriptor.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final h a(e eVar, j1 j1Var, kotlin.reflect.y.internal.j0.l.t1.g gVar) {
            h hVarV;
            m.f(eVar, "<this>");
            m.f(j1Var, "typeSubstitution");
            m.f(gVar, "kotlinTypeRefiner");
            t tVar = eVar instanceof t ? (t) eVar : null;
            if (tVar != null && (hVarV = tVar.v(j1Var, gVar)) != null) {
                return hVarV;
            }
            h hVarA0 = eVar.a0(j1Var);
            m.e(hVarA0, "this.getMemberScope(\n   …ubstitution\n            )");
            return hVarA0;
        }

        public final h b(e eVar, kotlin.reflect.y.internal.j0.l.t1.g gVar) {
            h hVarH;
            m.f(eVar, "<this>");
            m.f(gVar, "kotlinTypeRefiner");
            t tVar = eVar instanceof t ? (t) eVar : null;
            if (tVar != null && (hVarH = tVar.H(gVar)) != null) {
                return hVarH;
            }
            h hVarD0 = eVar.D0();
            m.e(hVarD0, "this.unsubstitutedMemberScope");
            return hVarD0;
        }
    }

    protected abstract h H(kotlin.reflect.y.internal.j0.l.t1.g gVar);

    protected abstract h v(j1 j1Var, kotlin.reflect.y.internal.j0.l.t1.g gVar);
}
