package kotlin.reflect.y.internal.j0.l;

import java.util.ArrayDeque;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.utils.f;
import kotlin.reflect.y.internal.j0.l.w1.d;
import kotlin.reflect.y.internal.j0.l.w1.i;
import kotlin.reflect.y.internal.j0.l.w1.k;
import kotlin.reflect.y.internal.j0.l.w1.p;
import kotlin.u;

/* JADX INFO: compiled from: AbstractTypeChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public class d1 {
    private final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f24687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f24688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final p f24689d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final h f24690e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final i f24691f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f24692g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f24693h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayDeque<k> f24694i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Set<k> f24695j;

    /* JADX INFO: compiled from: AbstractTypeChecker.kt */
    public interface a {

        /* JADX INFO: renamed from: kotlin.f0.y.e.j0.l.d1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AbstractTypeChecker.kt */
        public static final class C0393a implements a {
            private boolean a;

            @Override // kotlin.f0.y.e.j0.l.d1.a
            public void a(Function0<Boolean> function0) {
                m.f(function0, "block");
                if (this.a) {
                    return;
                }
                this.a = function0.invoke().booleanValue();
            }

            public final boolean b() {
                return this.a;
            }
        }

        void a(Function0<Boolean> function0);
    }

    /* JADX INFO: compiled from: AbstractTypeChecker.kt */
    public enum b {
        CHECK_ONLY_LOWER,
        CHECK_SUBTYPE_AND_LOWER,
        SKIP_LOWER
    }

    /* JADX INFO: compiled from: AbstractTypeChecker.kt */
    public static abstract class c {

        /* JADX INFO: compiled from: AbstractTypeChecker.kt */
        public static abstract class a extends c {
            public a() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AbstractTypeChecker.kt */
        public static final class b extends c {
            public static final b a = new b();

            private b() {
                super(null);
            }

            @Override // kotlin.f0.y.e.j0.l.d1.c
            public k a(d1 d1Var, i iVar) {
                m.f(d1Var, "state");
                m.f(iVar, "type");
                return d1Var.j().h0(iVar);
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.j0.l.d1$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AbstractTypeChecker.kt */
        public static final class C0394c extends c {
            public static final C0394c a = new C0394c();

            private C0394c() {
                super(null);
            }

            @Override // kotlin.f0.y.e.j0.l.d1.c
            public /* bridge */ /* synthetic */ k a(d1 d1Var, i iVar) {
                return (k) b(d1Var, iVar);
            }

            public Void b(d1 d1Var, i iVar) {
                m.f(d1Var, "state");
                m.f(iVar, "type");
                throw new UnsupportedOperationException("Should not be called");
            }
        }

        /* JADX INFO: compiled from: AbstractTypeChecker.kt */
        public static final class d extends c {
            public static final d a = new d();

            private d() {
                super(null);
            }

            @Override // kotlin.f0.y.e.j0.l.d1.c
            public k a(d1 d1Var, i iVar) {
                m.f(d1Var, "state");
                m.f(iVar, "type");
                return d1Var.j().T(iVar);
            }
        }

        private c() {
        }

        public /* synthetic */ c(g gVar) {
            this();
        }

        public abstract k a(d1 d1Var, i iVar);
    }

    public d1(boolean z, boolean z2, boolean z3, p pVar, h hVar, i iVar) {
        m.f(pVar, "typeSystemContext");
        m.f(hVar, "kotlinTypePreparator");
        m.f(iVar, "kotlinTypeRefiner");
        this.a = z;
        this.f24687b = z2;
        this.f24688c = z3;
        this.f24689d = pVar;
        this.f24690e = hVar;
        this.f24691f = iVar;
    }

    public static /* synthetic */ Boolean d(d1 d1Var, i iVar, i iVar2, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSubtypeConstraint");
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return d1Var.c(iVar, iVar2, z);
    }

    public Boolean c(i iVar, i iVar2, boolean z) {
        m.f(iVar, "subType");
        m.f(iVar2, "superType");
        return null;
    }

    public final void e() {
        ArrayDeque<k> arrayDeque = this.f24694i;
        m.c(arrayDeque);
        arrayDeque.clear();
        Set<k> set = this.f24695j;
        m.c(set);
        set.clear();
        this.f24693h = false;
    }

    public boolean f(i iVar, i iVar2) {
        m.f(iVar, "subType");
        m.f(iVar2, "superType");
        return true;
    }

    public b g(k kVar, d dVar) {
        m.f(kVar, "subType");
        m.f(dVar, "superType");
        return b.CHECK_SUBTYPE_AND_LOWER;
    }

    public final ArrayDeque<k> h() {
        return this.f24694i;
    }

    public final Set<k> i() {
        return this.f24695j;
    }

    public final p j() {
        return this.f24689d;
    }

    public final void k() {
        this.f24693h = true;
        if (this.f24694i == null) {
            this.f24694i = new ArrayDeque<>(4);
        }
        if (this.f24695j == null) {
            this.f24695j = f.f25524f.a();
        }
    }

    public final boolean l(i iVar) {
        m.f(iVar, "type");
        return this.f24688c && this.f24689d.z0(iVar);
    }

    public final boolean m() {
        return this.a;
    }

    public final boolean n() {
        return this.f24687b;
    }

    public final i o(i iVar) {
        m.f(iVar, "type");
        return this.f24690e.a(iVar);
    }

    public final i p(i iVar) {
        m.f(iVar, "type");
        return this.f24691f.a(iVar);
    }

    public boolean q(Function1<? super a, u> function1) {
        m.f(function1, "block");
        a.C0393a c0393a = new a.C0393a();
        function1.invoke(c0393a);
        return c0393a.b();
    }
}
