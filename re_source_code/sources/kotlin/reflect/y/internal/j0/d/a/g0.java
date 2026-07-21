package kotlin.reflect.y.internal.j0.d.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.s0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.y.internal.j0.b.h;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.d;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.t1.u;

/* JADX INFO: compiled from: specialBuiltinMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g0 {

    /* JADX INFO: compiled from: specialBuiltinMembers.kt */
    static final class a extends Lambda implements Function1<kotlin.p002reflect.jvm.internal.impl.descriptors.b, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f23375f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar) {
            m.f(bVar, "it");
            return Boolean.valueOf(i.a.b(kotlin.reflect.y.internal.j0.i.t.a.o(bVar)));
        }
    }

    /* JADX INFO: compiled from: specialBuiltinMembers.kt */
    static final class b extends Lambda implements Function1<kotlin.p002reflect.jvm.internal.impl.descriptors.b, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f23376f = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar) {
            m.f(bVar, "it");
            return Boolean.valueOf(e.n.j((y0) bVar));
        }
    }

    /* JADX INFO: compiled from: specialBuiltinMembers.kt */
    static final class c extends Lambda implements Function1<kotlin.p002reflect.jvm.internal.impl.descriptors.b, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f23377f = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar) {
            m.f(bVar, "it");
            return Boolean.valueOf(h.f0(bVar) && f.m(bVar) != null);
        }
    }

    public static final boolean a(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar) {
        m.f(bVar, "<this>");
        return d(bVar) != null;
    }

    public static final String b(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar) {
        kotlin.p002reflect.jvm.internal.impl.descriptors.b bVarO;
        f fVarI;
        m.f(bVar, "callableMemberDescriptor");
        kotlin.p002reflect.jvm.internal.impl.descriptors.b bVarC = c(bVar);
        if (bVarC == null || (bVarO = kotlin.reflect.y.internal.j0.i.t.a.o(bVarC)) == null) {
            return null;
        }
        if (bVarO instanceof t0) {
            return i.a.a(bVarO);
        }
        if (!(bVarO instanceof y0) || (fVarI = e.n.i((y0) bVarO)) == null) {
            return null;
        }
        return fVarI.k();
    }

    private static final kotlin.p002reflect.jvm.internal.impl.descriptors.b c(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar) {
        if (h.f0(bVar)) {
            return d(bVar);
        }
        return null;
    }

    public static final <T extends kotlin.p002reflect.jvm.internal.impl.descriptors.b> T d(T t) {
        m.f(t, "<this>");
        if (!h0.a.g().contains(t.getName()) && !g.a.d().contains(kotlin.reflect.y.internal.j0.i.t.a.o(t).getName())) {
            return null;
        }
        if (t instanceof t0 ? true : t instanceof s0) {
            return (T) kotlin.reflect.y.internal.j0.i.t.a.c(t, false, a.f23375f, 1, null);
        }
        if (t instanceof y0) {
            return (T) kotlin.reflect.y.internal.j0.i.t.a.c(t, false, b.f23376f, 1, null);
        }
        return null;
    }

    public static final <T extends kotlin.p002reflect.jvm.internal.impl.descriptors.b> T e(T t) {
        m.f(t, "<this>");
        T t2 = (T) d(t);
        if (t2 != null) {
            return t2;
        }
        f fVar = f.n;
        f name = t.getName();
        m.e(name, "name");
        if (fVar.l(name)) {
            return (T) kotlin.reflect.y.internal.j0.i.t.a.c(t, false, c.f23377f, 1, null);
        }
        return null;
    }

    public static final boolean f(e eVar, kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar) {
        m.f(eVar, "<this>");
        m.f(aVar, "specialCallableDescriptor");
        kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = aVar.b();
        m.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        m0 m0VarS = ((e) mVarB).s();
        m.e(m0VarS, "specialCallableDescripto…ssDescriptor).defaultType");
        e eVarS = d.s(eVar);
        while (true) {
            if (eVarS == null) {
                return false;
            }
            if (!(eVarS instanceof kotlin.reflect.y.internal.j0.d.a.k0.c)) {
                if (u.b(eVarS.s(), m0VarS) != null) {
                    return !h.f0(eVarS);
                }
            }
            eVarS = d.s(eVarS);
        }
    }

    public static final boolean g(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar) {
        m.f(bVar, "<this>");
        return kotlin.reflect.y.internal.j0.i.t.a.o(bVar).b() instanceof kotlin.reflect.y.internal.j0.d.a.k0.c;
    }

    public static final boolean h(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar) {
        m.f(bVar, "<this>");
        return g(bVar) || h.f0(bVar);
    }
}
