package kotlin.reflect.y.internal.j0.l.t1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.q1;

/* JADX INFO: compiled from: NewCapturedType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements kotlin.reflect.y.internal.j0.i.q.a.b {
    private final g1 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Function0<? extends List<? extends q1>> f24793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j f24794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e1 f24795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Lazy f24796e;

    /* JADX INFO: compiled from: NewCapturedType.kt */
    static final class a extends Lambda implements Function0<List<? extends q1>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ List<q1> f24797f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(List<? extends q1> list) {
            super(0);
            this.f24797f = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends q1> invoke() {
            return this.f24797f;
        }
    }

    /* JADX INFO: compiled from: NewCapturedType.kt */
    static final class b extends Lambda implements Function0<List<? extends q1>> {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends q1> invoke() {
            Function0 function0 = j.this.f24793b;
            if (function0 != null) {
                return (List) function0.invoke();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: NewCapturedType.kt */
    static final class c extends Lambda implements Function0<List<? extends q1>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ List<q1> f24799f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(List<? extends q1> list) {
            super(0);
            this.f24799f = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends q1> invoke() {
            return this.f24799f;
        }
    }

    /* JADX INFO: compiled from: NewCapturedType.kt */
    static final class d extends Lambda implements Function0<List<? extends q1>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ g f24801g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(g gVar) {
            super(0);
            this.f24801g = gVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends q1> invoke() {
            List<q1> listA = j.this.a();
            g gVar = this.f24801g;
            ArrayList arrayList = new ArrayList(v.u(listA, 10));
            Iterator<T> it = listA.iterator();
            while (it.hasNext()) {
                arrayList.add(((q1) it.next()).Y0(gVar));
            }
            return arrayList;
        }
    }

    public j(g1 g1Var, Function0<? extends List<? extends q1>> function0, j jVar, e1 e1Var) {
        m.f(g1Var, "projection");
        this.a = g1Var;
        this.f24793b = function0;
        this.f24794c = jVar;
        this.f24795d = e1Var;
        this.f24796e = i.a(LazyThreadSafetyMode.PUBLICATION, new b());
    }

    private final List<q1> i() {
        return (List) this.f24796e.getValue();
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    /* JADX INFO: renamed from: c */
    public h w() {
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public boolean e() {
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!m.a(j.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        m.d(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
        j jVar = (j) obj;
        j jVar2 = this.f24794c;
        if (jVar2 == null) {
            jVar2 = this;
        }
        j jVar3 = jVar.f24794c;
        if (jVar3 != null) {
            jVar = jVar3;
        }
        return jVar2 == jVar;
    }

    @Override // kotlin.reflect.y.internal.j0.i.q.a.b
    public g1 f() {
        return this.a;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public List<e1> getParameters() {
        return u.j();
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public List<q1> a() {
        List<q1> listI = i();
        return listI == null ? u.j() : listI;
    }

    public int hashCode() {
        j jVar = this.f24794c;
        return jVar != null ? jVar.hashCode() : super.hashCode();
    }

    public final void j(List<? extends q1> list) {
        m.f(list, "supertypes");
        Function0<? extends List<? extends q1>> function0 = this.f24793b;
        this.f24793b = new c(list);
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public j b(g gVar) {
        m.f(gVar, "kotlinTypeRefiner");
        g1 g1VarB = f().b(gVar);
        m.e(g1VarB, "projection.refine(kotlinTypeRefiner)");
        d dVar = this.f24793b != null ? new d(gVar) : null;
        j jVar = this.f24794c;
        if (jVar == null) {
            jVar = this;
        }
        return new j(g1VarB, dVar, jVar, this.f24795d);
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public kotlin.reflect.y.internal.j0.b.h o() {
        e0 type = f().getType();
        m.e(type, "projection.type");
        return kotlin.reflect.y.internal.j0.l.x1.a.h(type);
    }

    public String toString() {
        return "CapturedType(" + f() + ')';
    }

    public /* synthetic */ j(g1 g1Var, Function0 function0, j jVar, e1 e1Var, int i2, g gVar) {
        this(g1Var, (i2 & 2) != 0 ? null : function0, (i2 & 4) != 0 ? null : jVar, (i2 & 8) != 0 ? null : e1Var);
    }

    public /* synthetic */ j(g1 g1Var, List list, j jVar, int i2, g gVar) {
        this(g1Var, list, (i2 & 4) != 0 ? null : jVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(g1 g1Var, List<? extends q1> list, j jVar) {
        this(g1Var, new a(list), jVar, null, 8, null);
        m.f(g1Var, "projection");
        m.f(list, "supertypes");
    }
}
