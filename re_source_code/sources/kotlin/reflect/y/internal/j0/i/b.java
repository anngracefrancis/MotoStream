package kotlin.reflect.y.internal.j0.i;

import java.util.Collection;
import kotlin.collections.s;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.p002reflect.jvm.internal.impl.descriptors.c0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.p002reflect.jvm.internal.impl.descriptors.k0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.l.e1;
import kotlin.reflect.y.internal.j0.l.t1.e;
import kotlin.reflect.y.internal.j0.l.t1.g;

/* JADX INFO: compiled from: DescriptorEquivalenceForOverrides.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final b a = new b();

    /* JADX INFO: compiled from: DescriptorEquivalenceForOverrides.kt */
    static final class a extends Lambda implements Function2<m, m, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f24310f = new a();

        a() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(m mVar, m mVar2) {
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.j0.i.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DescriptorEquivalenceForOverrides.kt */
    static final class C0377b implements e.a {
        final /* synthetic */ boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlin.p002reflect.jvm.internal.impl.descriptors.a f24311b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ kotlin.p002reflect.jvm.internal.impl.descriptors.a f24312c;

        /* JADX INFO: renamed from: kotlin.f0.y.e.j0.i.b$b$a */
        /* JADX INFO: compiled from: DescriptorEquivalenceForOverrides.kt */
        static final class a extends Lambda implements Function2<m, m, Boolean> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ kotlin.p002reflect.jvm.internal.impl.descriptors.a f24313f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ kotlin.p002reflect.jvm.internal.impl.descriptors.a f24314g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar, kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar2) {
                super(2);
                this.f24313f = aVar;
                this.f24314g = aVar2;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(m mVar, m mVar2) {
                return Boolean.valueOf(kotlin.jvm.internal.m.a(mVar, this.f24313f) && kotlin.jvm.internal.m.a(mVar2, this.f24314g));
            }
        }

        C0377b(boolean z, kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar, kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar2) {
            this.a = z;
            this.f24311b = aVar;
            this.f24312c = aVar2;
        }

        @Override // kotlin.f0.y.e.j0.l.t1.e.a
        public final boolean a(e1 e1Var, e1 e1Var2) {
            kotlin.jvm.internal.m.f(e1Var, "c1");
            kotlin.jvm.internal.m.f(e1Var2, "c2");
            if (kotlin.jvm.internal.m.a(e1Var, e1Var2)) {
                return true;
            }
            h hVarC = e1Var.w();
            h hVarC2 = e1Var2.w();
            if ((hVarC instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e1) && (hVarC2 instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e1)) {
                return b.a.g((kotlin.p002reflect.jvm.internal.impl.descriptors.e1) hVarC, (kotlin.p002reflect.jvm.internal.impl.descriptors.e1) hVarC2, this.a, new a(this.f24311b, this.f24312c));
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: DescriptorEquivalenceForOverrides.kt */
    static final class c extends Lambda implements Function2<m, m, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f24315f = new c();

        c() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(m mVar, m mVar2) {
            return Boolean.FALSE;
        }
    }

    private b() {
    }

    public static /* synthetic */ boolean b(b bVar, kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar, kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar2, boolean z, boolean z2, boolean z3, g gVar, int i2, Object obj) {
        return bVar.a(aVar, aVar2, z, (i2 & 8) != 0 ? true : z2, (i2 & 16) != 0 ? false : z3, gVar);
    }

    private final boolean c(kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar, kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar2) {
        return kotlin.jvm.internal.m.a(eVar.h(), eVar2.h());
    }

    public static /* synthetic */ boolean e(b bVar, m mVar, m mVar2, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z2 = true;
        }
        return bVar.d(mVar, mVar2, z, z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean h(b bVar, kotlin.p002reflect.jvm.internal.impl.descriptors.e1 e1Var, kotlin.p002reflect.jvm.internal.impl.descriptors.e1 e1Var2, boolean z, Function2 function2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            function2 = c.f24315f;
        }
        return bVar.g(e1Var, e1Var2, z, function2);
    }

    private final boolean i(m mVar, m mVar2, Function2<? super m, ? super m, Boolean> function2, boolean z) {
        m mVarB = mVar.b();
        m mVarB2 = mVar2.b();
        return ((mVarB instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.b) || (mVarB2 instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.b)) ? function2.invoke(mVarB, mVarB2).booleanValue() : e(this, mVarB, mVarB2, z, false, 8, null);
    }

    private final z0 j(kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar) {
        while (aVar instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.b) {
            kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar = (kotlin.p002reflect.jvm.internal.impl.descriptors.b) aVar;
            if (bVar.i() != kotlin.reflect.jvm.internal.impl.descriptors.b.a.FAKE_OVERRIDE) {
                break;
            }
            Collection<? extends kotlin.p002reflect.jvm.internal.impl.descriptors.b> collectionE = bVar.e();
            kotlin.jvm.internal.m.e(collectionE, "overriddenDescriptors");
            aVar = (kotlin.p002reflect.jvm.internal.impl.descriptors.b) s.t0(collectionE);
            if (aVar == null) {
                return null;
            }
        }
        return aVar.t();
    }

    public final boolean a(kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar, kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar2, boolean z, boolean z2, boolean z3, g gVar) {
        kotlin.jvm.internal.m.f(aVar, "a");
        kotlin.jvm.internal.m.f(aVar2, "b");
        kotlin.jvm.internal.m.f(gVar, "kotlinTypeRefiner");
        if (kotlin.jvm.internal.m.a(aVar, aVar2)) {
            return true;
        }
        if (!kotlin.jvm.internal.m.a(aVar.getName(), aVar2.getName())) {
            return false;
        }
        if (z2 && (aVar instanceof c0) && (aVar2 instanceof c0) && ((c0) aVar).M() != ((c0) aVar2).M()) {
            return false;
        }
        if ((kotlin.jvm.internal.m.a(aVar.b(), aVar2.b()) && (!z || !kotlin.jvm.internal.m.a(j(aVar), j(aVar2)))) || d.E(aVar) || d.E(aVar2) || !i(aVar, aVar2, a.f24310f, z)) {
            return false;
        }
        j jVarI = j.i(gVar, new C0377b(z, aVar, aVar2));
        kotlin.jvm.internal.m.e(jVarI, "a: CallableDescriptor,\n …= a && y == b }\n        }");
        j.i.a aVarC = jVarI.E(aVar, aVar2, null, !z3).c();
        j.i.a aVar3 = j.i.a.OVERRIDABLE;
        return aVarC == aVar3 && jVarI.E(aVar2, aVar, null, z3 ^ true).c() == aVar3;
    }

    public final boolean d(m mVar, m mVar2, boolean z, boolean z2) {
        if ((mVar instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e) && (mVar2 instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e)) {
            return c((kotlin.p002reflect.jvm.internal.impl.descriptors.e) mVar, (kotlin.p002reflect.jvm.internal.impl.descriptors.e) mVar2);
        }
        if ((mVar instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e1) && (mVar2 instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e1)) {
            return h(this, (kotlin.p002reflect.jvm.internal.impl.descriptors.e1) mVar, (kotlin.p002reflect.jvm.internal.impl.descriptors.e1) mVar2, z, null, 8, null);
        }
        if ((mVar instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.a) && (mVar2 instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.a)) {
            return b(this, (kotlin.p002reflect.jvm.internal.impl.descriptors.a) mVar, (kotlin.p002reflect.jvm.internal.impl.descriptors.a) mVar2, z, z2, false, g.a.a, 16, null);
        }
        return ((mVar instanceof k0) && (mVar2 instanceof k0)) ? kotlin.jvm.internal.m.a(((k0) mVar).d(), ((k0) mVar2).d()) : kotlin.jvm.internal.m.a(mVar, mVar2);
    }

    public final boolean f(kotlin.p002reflect.jvm.internal.impl.descriptors.e1 e1Var, kotlin.p002reflect.jvm.internal.impl.descriptors.e1 e1Var2, boolean z) {
        kotlin.jvm.internal.m.f(e1Var, "a");
        kotlin.jvm.internal.m.f(e1Var2, "b");
        return h(this, e1Var, e1Var2, z, null, 8, null);
    }

    public final boolean g(kotlin.p002reflect.jvm.internal.impl.descriptors.e1 e1Var, kotlin.p002reflect.jvm.internal.impl.descriptors.e1 e1Var2, boolean z, Function2<? super m, ? super m, Boolean> function2) {
        kotlin.jvm.internal.m.f(e1Var, "a");
        kotlin.jvm.internal.m.f(e1Var2, "b");
        kotlin.jvm.internal.m.f(function2, "equivalentCallables");
        if (kotlin.jvm.internal.m.a(e1Var, e1Var2)) {
            return true;
        }
        return !kotlin.jvm.internal.m.a(e1Var.b(), e1Var2.b()) && i(e1Var, e1Var2, function2, z) && e1Var.g() == e1Var2.g();
    }
}
