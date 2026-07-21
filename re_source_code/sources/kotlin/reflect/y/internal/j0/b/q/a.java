package kotlin.reflect.y.internal.j0.b.q;

import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.b;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.g0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.w.e;
import kotlin.reflect.y.internal.j0.k.n;

/* JADX INFO: compiled from: CloneableClassScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0324a f23239e = new C0324a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final f f23240f;

    /* JADX INFO: renamed from: kotlin.f0.y.e.j0.b.q.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CloneableClassScope.kt */
    public static final class C0324a {
        private C0324a() {
        }

        public /* synthetic */ C0324a(g gVar) {
            this();
        }

        public final f a() {
            return a.f23240f;
        }
    }

    static {
        f fVarX = f.x("clone");
        m.e(fVarX, "identifier(\"clone\")");
        f23240f = fVarX;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(n nVar, kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar) {
        super(nVar, eVar);
        m.f(nVar, "storageManager");
        m.f(eVar, "containingClass");
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.e
    protected List<y> i() {
        g0 g0VarM1 = g0.m1(l(), kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b(), f23240f, b.a.DECLARATION, z0.a);
        g0VarM1.S0(null, l().K0(), u.j(), u.j(), u.j(), kotlin.reflect.y.internal.j0.i.t.a.f(l()).i(), d0.OPEN, t.f25366c);
        return kotlin.collections.t.e(g0VarM1);
    }
}
