package kotlin.reflect.y.internal.j0.i.r;

import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.s;
import kotlin.collections.t;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.y.internal.j0.b.h;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.l.a1;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.f0;
import kotlin.reflect.y.internal.j0.l.g0;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.i1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.r1;
import kotlin.reflect.y.internal.j0.l.u1.j;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q extends g<b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f24378b = new a(null);

    /* JADX INFO: compiled from: constantValues.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final g<?> a(e0 e0Var) {
            m.f(e0Var, "argumentType");
            if (g0.a(e0Var)) {
                return null;
            }
            e0 type = e0Var;
            int i2 = 0;
            while (h.c0(type)) {
                type = ((g1) s.s0(type.M0())).getType();
                m.e(type, "type.arguments.single().type");
                i2++;
            }
            kotlin.p002reflect.jvm.internal.impl.descriptors.h hVarW = type.O0().w();
            if (hVarW instanceof e) {
                kotlin.reflect.y.internal.j0.f.b bVarG = kotlin.reflect.y.internal.j0.i.t.a.g(hVarW);
                return bVarG == null ? new q(new b.a(e0Var)) : new q(bVarG, i2);
            }
            if (!(hVarW instanceof e1)) {
                return null;
            }
            kotlin.reflect.y.internal.j0.f.b bVarM = kotlin.reflect.y.internal.j0.f.b.m(k.a.f23201b.l());
            m.e(bVarM, "topLevel(StandardNames.FqNames.any.toSafe())");
            return new q(bVarM, 0);
        }
    }

    /* JADX INFO: compiled from: constantValues.kt */
    public static abstract class b {

        /* JADX INFO: compiled from: constantValues.kt */
        public static final class a extends b {
            private final e0 a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(e0 e0Var) {
                super(null);
                m.f(e0Var, "type");
                this.a = e0Var;
            }

            public final e0 a() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && m.a(this.a, ((a) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            public String toString() {
                return "LocalClass(type=" + this.a + ')';
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.j0.i.r.q$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: constantValues.kt */
        public static final class C0379b extends b {
            private final f a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0379b(f fVar) {
                super(null);
                m.f(fVar, "value");
                this.a = fVar;
            }

            public final int a() {
                return this.a.c();
            }

            public final kotlin.reflect.y.internal.j0.f.b b() {
                return this.a.d();
            }

            public final f c() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0379b) && m.a(this.a, ((C0379b) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            public String toString() {
                return "NormalClass(value=" + this.a + ')';
            }
        }

        private b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(b bVar) {
        super(bVar);
        m.f(bVar, "value");
    }

    @Override // kotlin.reflect.y.internal.j0.i.r.g
    public e0 a(kotlin.p002reflect.jvm.internal.impl.descriptors.g0 g0Var) {
        m.f(g0Var, "module");
        a1 a1VarH = a1.f24676g.h();
        e eVarE = g0Var.o().E();
        m.e(eVarE, "module.builtIns.kClass");
        return f0.g(a1VarH, eVarE, t.e(new i1(c(g0Var))));
    }

    public final e0 c(kotlin.p002reflect.jvm.internal.impl.descriptors.g0 g0Var) {
        m.f(g0Var, "module");
        b bVarB = b();
        if (bVarB instanceof b.a) {
            return ((b.a) b()).a();
        }
        if (!(bVarB instanceof b.C0379b)) {
            throw new NoWhenBranchMatchedException();
        }
        f fVarC = ((b.C0379b) b()).c();
        kotlin.reflect.y.internal.j0.f.b bVarA = fVarC.a();
        int iB = fVarC.b();
        e eVarA = x.a(g0Var, bVarA);
        if (eVarA == null) {
            j jVar = j.f24852k;
            String string = bVarA.toString();
            m.e(string, "classId.toString()");
            return kotlin.reflect.y.internal.j0.l.u1.k.d(jVar, string, String.valueOf(iB));
        }
        m0 m0VarS = eVarA.s();
        m.e(m0VarS, "descriptor.defaultType");
        e0 e0VarW = kotlin.reflect.y.internal.j0.l.x1.a.w(m0VarS);
        for (int i2 = 0; i2 < iB; i2++) {
            e0VarW = g0Var.o().l(r1.INVARIANT, e0VarW);
            m.e(e0VarW, "module.builtIns.getArray…Variance.INVARIANT, type)");
        }
        return e0VarW;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q(f fVar) {
        this(new b.C0379b(fVar));
        m.f(fVar, "value");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q(kotlin.reflect.y.internal.j0.f.b bVar, int i2) {
        this(new f(bVar, i2));
        m.f(bVar, "classId");
    }
}
