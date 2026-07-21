package kotlin.reflect.y.internal.j0.l.t1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.collections.s;
import kotlin.collections.v;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.m;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.y.internal.j0.i.r.n;
import kotlin.reflect.y.internal.j0.l.a1;
import kotlin.reflect.y.internal.j0.l.b0;
import kotlin.reflect.y.internal.j0.l.d0;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.p;
import kotlin.reflect.y.internal.j0.l.q0;
import kotlin.reflect.y.internal.j0.l.q1;
import kotlin.reflect.y.internal.j0.l.u0;

/* JADX INFO: compiled from: IntersectionType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w {
    public static final w a = new w();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: IntersectionType.kt */
    private static final class a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f24808f = new c("START", 0);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f24809g = new C0398a("ACCEPT_NULL", 1);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f24810h = new d("UNKNOWN", 2);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f24811i = new b("NOT_NULL", 3);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ a[] f24812j = g();

        /* JADX INFO: renamed from: kotlin.f0.y.e.j0.l.t1.w$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IntersectionType.kt */
        static final class C0398a extends a {
            C0398a(String str, int i2) {
                super(str, i2, null);
            }

            @Override // kotlin.f0.y.e.j0.l.t1.w.a
            public a k(q1 q1Var) {
                m.f(q1Var, "nextType");
                return q(q1Var);
            }
        }

        /* JADX INFO: compiled from: IntersectionType.kt */
        static final class b extends a {
            b(String str, int i2) {
                super(str, i2, null);
            }

            @Override // kotlin.f0.y.e.j0.l.t1.w.a
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public b k(q1 q1Var) {
                m.f(q1Var, "nextType");
                return this;
            }
        }

        /* JADX INFO: compiled from: IntersectionType.kt */
        static final class c extends a {
            c(String str, int i2) {
                super(str, i2, null);
            }

            @Override // kotlin.f0.y.e.j0.l.t1.w.a
            public a k(q1 q1Var) {
                m.f(q1Var, "nextType");
                return q(q1Var);
            }
        }

        /* JADX INFO: compiled from: IntersectionType.kt */
        static final class d extends a {
            d(String str, int i2) {
                super(str, i2, null);
            }

            @Override // kotlin.f0.y.e.j0.l.t1.w.a
            public a k(q1 q1Var) {
                m.f(q1Var, "nextType");
                a aVarQ = q(q1Var);
                return aVarQ == a.f24809g ? this : aVarQ;
            }
        }

        private a(String str, int i2) {
            super(str, i2);
        }

        public /* synthetic */ a(String str, int i2, g gVar) {
            this(str, i2);
        }

        private static final /* synthetic */ a[] g() {
            return new a[]{f24808f, f24809g, f24810h, f24811i};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f24812j.clone();
        }

        public abstract a k(q1 q1Var);

        protected final a q(q1 q1Var) {
            m.f(q1Var, "<this>");
            if (q1Var.P0()) {
                return f24809g;
            }
            if ((q1Var instanceof p) && (((p) q1Var).a1() instanceof u0)) {
                return f24811i;
            }
            if (q1Var instanceof u0) {
                return f24810h;
            }
            return o.a.a(q1Var) ? f24811i : f24810h;
        }
    }

    /* JADX INFO: compiled from: IntersectionType.kt */
    static final class b extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Set<m0> f24813f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(Set<? extends m0> set) {
            super(0);
            this.f24813f = set;
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return "This collections cannot be empty! input types: " + c0.e0(this.f24813f, null, null, null, 0, null, null, 63, null);
        }
    }

    /* JADX INFO: compiled from: IntersectionType.kt */
    /* synthetic */ class c extends i implements Function2<e0, e0, Boolean> {
        c(Object obj) {
            super(2, obj);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* JADX INFO: renamed from: getName */
        public final String getM() {
            return "isStrictSupertype";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return g0.b(w.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "isStrictSupertype(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(e0 e0Var, e0 e0Var2) {
            m.f(e0Var, "p0");
            m.f(e0Var2, "p1");
            return Boolean.valueOf(((w) this.receiver).e(e0Var, e0Var2));
        }
    }

    /* JADX INFO: compiled from: IntersectionType.kt */
    /* synthetic */ class d extends i implements Function2<e0, e0, Boolean> {
        d(Object obj) {
            super(2, obj);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* JADX INFO: renamed from: getName */
        public final String getM() {
            return "equalTypes";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return g0.b(m.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "equalTypes(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(e0 e0Var, e0 e0Var2) {
            m.f(e0Var, "p0");
            m.f(e0Var2, "p1");
            return Boolean.valueOf(((m) this.receiver).b(e0Var, e0Var2));
        }
    }

    private w() {
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004e  */
    private final Collection<m0> b(Collection<? extends m0> collection, Function2<? super m0, ? super m0, Boolean> function2) {
        boolean z;
        ArrayList arrayList = new ArrayList(collection);
        Iterator it = arrayList.iterator();
        m.e(it, "filteredTypes.iterator()");
        while (it.hasNext()) {
            m0 m0Var = (m0) it.next();
            boolean z2 = true;
            if (!arrayList.isEmpty()) {
                Iterator it2 = arrayList.iterator();
                do {
                    if (!it2.hasNext()) {
                        z2 = false;
                        break;
                    }
                    m0 m0Var2 = (m0) it2.next();
                    if (m0Var2 != m0Var) {
                        m.e(m0Var2, "lower");
                        m.e(m0Var, "upper");
                        if (function2.invoke(m0Var2, m0Var).booleanValue()) {
                            z = true;
                        } else {
                            z = false;
                        }
                    } else {
                        z = false;
                    }
                } while (!z);
            } else {
                z2 = false;
                break;
            }
            if (z2) {
                it.remove();
            }
        }
        return arrayList;
    }

    private final m0 d(Set<? extends m0> set) {
        if (set.size() == 1) {
            return (m0) s.r0(set);
        }
        new b(set);
        Collection<m0> collectionB = b(set, new c(this));
        collectionB.isEmpty();
        m0 m0VarB = n.a.b(collectionB);
        if (m0VarB != null) {
            return m0VarB;
        }
        Collection<m0> collectionB2 = b(collectionB, new d(l.f24802b.a()));
        collectionB2.isEmpty();
        return collectionB2.size() < 2 ? (m0) s.r0(collectionB2) : new d0(set).h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(e0 e0Var, e0 e0Var2) {
        m mVarA = l.f24802b.a();
        return mVarA.d(e0Var, e0Var2) && !mVarA.d(e0Var2, e0Var);
    }

    public final m0 c(List<? extends m0> list) {
        m.f(list, "types");
        list.size();
        ArrayList<m0> arrayList = new ArrayList();
        for (m0 m0Var : list) {
            if (m0Var.O0() instanceof d0) {
                Collection<e0> collectionA = m0Var.O0().a();
                m.e(collectionA, "type.constructor.supertypes");
                ArrayList arrayList2 = new ArrayList(v.u(collectionA, 10));
                for (e0 e0Var : collectionA) {
                    m.e(e0Var, "it");
                    m0 m0VarD = b0.d(e0Var);
                    if (m0Var.P0()) {
                        m0VarD = m0VarD.S0(true);
                    }
                    arrayList2.add(m0VarD);
                }
                arrayList.addAll(arrayList2);
            } else {
                arrayList.add(m0Var);
            }
        }
        a aVarK = a.f24808f;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            aVarK = aVarK.k((q1) it.next());
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (m0 m0VarI : arrayList) {
            if (aVarK == a.f24811i) {
                if (m0VarI instanceof i) {
                    m0VarI = q0.k((i) m0VarI);
                }
                m0VarI = q0.i(m0VarI, false, 1, null);
            }
            linkedHashSet.add(m0VarI);
        }
        ArrayList arrayList3 = new ArrayList(v.u(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((m0) it2.next()).N0());
        }
        Iterator it3 = arrayList3.iterator();
        if (!it3.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        Object next = it3.next();
        while (it3.hasNext()) {
            next = ((a1) next).q((a1) it3.next());
        }
        return d(linkedHashSet).U0((a1) next);
    }
}
