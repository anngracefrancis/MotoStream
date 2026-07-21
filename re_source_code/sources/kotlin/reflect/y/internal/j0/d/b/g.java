package kotlin.reflect.y.internal.j0.d.b;

import java.util.Collection;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.u;
import kotlin.collections.v0;
import kotlin.collections.w0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.k0;
import kotlin.p002reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.y.internal.j0.e.a0.b.e;
import kotlin.reflect.y.internal.j0.e.a0.b.i;
import kotlin.reflect.y.internal.j0.e.c;
import kotlin.reflect.y.internal.j0.e.l;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.j.b.k;
import kotlin.reflect.y.internal.j0.j.b.t;

/* JADX INFO: compiled from: DeserializedDescriptorResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<kotlin.reflect.y.internal.j0.d.b.c0.a.EnumC0345a> f23787b = v0.c(kotlin.reflect.y.internal.j0.d.b.c0.a.EnumC0345a.CLASS);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set<kotlin.reflect.y.internal.j0.d.b.c0.a.EnumC0345a> f23788c = w0.i(kotlin.reflect.y.internal.j0.d.b.c0.a.EnumC0345a.FILE_FACADE, kotlin.reflect.y.internal.j0.d.b.c0.a.EnumC0345a.MULTIFILE_CLASS_PART);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final e f23789d = new e(1, 1, 2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final e f23790e = new e(1, 1, 11);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final e f23791f = new e(1, 1, 13);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public k f23792g;

    /* JADX INFO: compiled from: DeserializedDescriptorResolver.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final e a() {
            return g.f23791f;
        }
    }

    /* JADX INFO: compiled from: DeserializedDescriptorResolver.kt */
    static final class b extends Lambda implements Function0<Collection<? extends f>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f23793f = new b();

        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Collection<f> invoke() {
            return u.j();
        }
    }

    private final kotlin.reflect.y.internal.j0.j.b.g0.e c(q qVar) {
        if (d().g().b()) {
            return kotlin.reflect.y.internal.j0.j.b.g0.e.STABLE;
        }
        if (qVar.a().j()) {
            return kotlin.reflect.y.internal.j0.j.b.g0.e.FIR_UNSTABLE;
        }
        return qVar.a().k() ? kotlin.reflect.y.internal.j0.j.b.g0.e.IR_UNSTABLE : kotlin.reflect.y.internal.j0.j.b.g0.e.STABLE;
    }

    private final t<e> e(q qVar) {
        if (f() || qVar.a().d().h()) {
            return null;
        }
        return new t<>(qVar.a().d(), e.f23889h, qVar.getLocation(), qVar.e());
    }

    private final boolean f() {
        return d().g().d();
    }

    private final boolean g(q qVar) {
        return !d().g().c() && qVar.a().i() && m.a(qVar.a().d(), f23790e);
    }

    private final boolean h(q qVar) {
        return (d().g().e() && (qVar.a().i() || m.a(qVar.a().d(), f23789d))) || g(qVar);
    }

    private final String[] j(q qVar, Set<? extends kotlin.reflect.y.internal.j0.d.b.c0.a.EnumC0345a> set) {
        kotlin.reflect.y.internal.j0.d.b.c0.a aVarA = qVar.a();
        String[] strArrA = aVarA.a();
        if (strArrA == null) {
            strArrA = aVarA.b();
        }
        if (strArrA == null || !set.contains(aVarA.c())) {
            return null;
        }
        return strArrA;
    }

    public final h b(k0 k0Var, q qVar) {
        String[] strArrG;
        Pair<kotlin.reflect.y.internal.j0.e.a0.b.f, l> pairM;
        m.f(k0Var, "descriptor");
        m.f(qVar, "kotlinClass");
        String[] strArrJ = j(qVar, f23788c);
        if (strArrJ == null || (strArrG = qVar.a().g()) == null) {
            return null;
        }
        try {
            try {
                pairM = i.m(strArrJ, strArrG);
            } catch (InvalidProtocolBufferException e2) {
                throw new IllegalStateException("Could not read data from " + qVar.getLocation(), e2);
            }
        } catch (Throwable th) {
            if (f() || qVar.a().d().h()) {
                throw th;
            }
            pairM = null;
        }
        if (pairM == null) {
            return null;
        }
        kotlin.reflect.y.internal.j0.e.a0.b.f fVarA = pairM.a();
        l lVarB = pairM.b();
        k kVar = new k(qVar, lVarB, fVarA, e(qVar), h(qVar), c(qVar));
        return new kotlin.reflect.y.internal.j0.j.b.g0.i(k0Var, lVarB, fVarA, qVar.a().d(), kVar, d(), "scope for " + kVar + " in " + k0Var, b.f23793f);
    }

    public final k d() {
        k kVar = this.f23792g;
        if (kVar != null) {
            return kVar;
        }
        m.w("components");
        return null;
    }

    public final kotlin.reflect.y.internal.j0.j.b.g i(q qVar) {
        String[] strArrG;
        Pair<kotlin.reflect.y.internal.j0.e.a0.b.f, c> pairI;
        m.f(qVar, "kotlinClass");
        String[] strArrJ = j(qVar, f23787b);
        if (strArrJ == null || (strArrG = qVar.a().g()) == null) {
            return null;
        }
        try {
            try {
                pairI = i.i(strArrJ, strArrG);
            } catch (InvalidProtocolBufferException e2) {
                throw new IllegalStateException("Could not read data from " + qVar.getLocation(), e2);
            }
        } catch (Throwable th) {
            if (f() || qVar.a().d().h()) {
                throw th;
            }
            pairI = null;
        }
        if (pairI == null) {
            return null;
        }
        return new kotlin.reflect.y.internal.j0.j.b.g(pairI.a(), pairI.b(), qVar.a().d(), new s(qVar, e(qVar), h(qVar), c(qVar)));
    }

    public final kotlin.p002reflect.jvm.internal.impl.descriptors.e k(q qVar) {
        m.f(qVar, "kotlinClass");
        kotlin.reflect.y.internal.j0.j.b.g gVarI = i(qVar);
        if (gVarI == null) {
            return null;
        }
        return d().f().d(qVar.e(), gVarI);
    }

    public final void l(e eVar) {
        m.f(eVar, "components");
        m(eVar.a());
    }

    public final void m(k kVar) {
        m.f(kVar, "<set-?>");
        this.f23792g = kVar;
    }
}
