package kotlin.reflect.y.internal.j0.l;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c;

/* JADX INFO: compiled from: TypeAliasExpansionReportStrategy.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface x0 {

    /* JADX INFO: compiled from: TypeAliasExpansionReportStrategy.kt */
    public static final class a implements x0 {
        public static final a a = new a();

        private a() {
        }

        @Override // kotlin.reflect.y.internal.j0.l.x0
        public void a(c cVar) {
            m.f(cVar, "annotation");
        }

        @Override // kotlin.reflect.y.internal.j0.l.x0
        public void b(d1 d1Var, e1 e1Var, e0 e0Var) {
            m.f(d1Var, "typeAlias");
            m.f(e0Var, "substitutedArgument");
        }

        @Override // kotlin.reflect.y.internal.j0.l.x0
        public void c(l1 l1Var, e0 e0Var, e0 e0Var2, e1 e1Var) {
            m.f(l1Var, "substitutor");
            m.f(e0Var, "unsubstitutedArgument");
            m.f(e0Var2, "argument");
            m.f(e1Var, "typeParameter");
        }

        @Override // kotlin.reflect.y.internal.j0.l.x0
        public void d(d1 d1Var) {
            m.f(d1Var, "typeAlias");
        }
    }

    void a(c cVar);

    void b(d1 d1Var, e1 e1Var, e0 e0Var);

    void c(l1 l1Var, e0 e0Var, e0 e0Var2, e1 e1Var);

    void d(d1 d1Var);
}
