package e.i;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.collections.c0;
import kotlin.collections.q0;
import kotlin.collections.s;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.u;

/* JADX INFO: compiled from: StateMachine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a<STATE, EVENT, SIDE_EFFECT> {
    public static final C0282a a = new C0282a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicReference<STATE> f21388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b<STATE, EVENT, SIDE_EFFECT> f21389c;

    /* JADX INFO: renamed from: e.i.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: StateMachine.kt */
    public static final class C0282a {
        private C0282a() {
        }

        private final <STATE, EVENT, SIDE_EFFECT> a<STATE, EVENT, SIDE_EFFECT> a(b<STATE, EVENT, SIDE_EFFECT> bVar, Function1<? super c<STATE, EVENT, SIDE_EFFECT>, u> function1) {
            c cVar = new c(bVar);
            function1.invoke(cVar);
            return new a<>(cVar.a(), null);
        }

        public final <STATE, EVENT, SIDE_EFFECT> a<STATE, EVENT, SIDE_EFFECT> b(Function1<? super c<STATE, EVENT, SIDE_EFFECT>, u> function1) {
            m.g(function1, "init");
            return a(null, function1);
        }

        public /* synthetic */ C0282a(g gVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: StateMachine.kt */
    public static final class b<STATE, EVENT, SIDE_EFFECT> {
        private final STATE a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<d<STATE, STATE>, C0283a<STATE, EVENT, SIDE_EFFECT>> f21390b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<Function1<e<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, u>> f21391c;

        /* JADX INFO: renamed from: e.i.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: StateMachine.kt */
        public static final class C0283a<STATE, EVENT, SIDE_EFFECT> {
            private final List<Function2<STATE, EVENT, u>> a = new ArrayList();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final List<Function2<STATE, EVENT, u>> f21392b = new ArrayList();

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final LinkedHashMap<d<EVENT, EVENT>, Function2<STATE, EVENT, C0284a<STATE, SIDE_EFFECT>>> f21393c = new LinkedHashMap<>();

            /* JADX INFO: renamed from: e.i.a$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: StateMachine.kt */
            public static final class C0284a<STATE, SIDE_EFFECT> {
                private final STATE a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private final SIDE_EFFECT f21394b;

                public C0284a(STATE state, SIDE_EFFECT side_effect) {
                    m.g(state, "toState");
                    this.a = state;
                    this.f21394b = side_effect;
                }

                public final STATE a() {
                    return this.a;
                }

                public final SIDE_EFFECT b() {
                    return this.f21394b;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof C0284a)) {
                        return false;
                    }
                    C0284a c0284a = (C0284a) obj;
                    return m.a(this.a, c0284a.a) && m.a(this.f21394b, c0284a.f21394b);
                }

                public int hashCode() {
                    STATE state = this.a;
                    int iHashCode = (state != null ? state.hashCode() : 0) * 31;
                    SIDE_EFFECT side_effect = this.f21394b;
                    return iHashCode + (side_effect != null ? side_effect.hashCode() : 0);
                }

                public String toString() {
                    return "TransitionTo(toState=" + this.a + ", sideEffect=" + this.f21394b + ")";
                }
            }

            public final List<Function2<STATE, EVENT, u>> a() {
                return this.a;
            }

            public final List<Function2<STATE, EVENT, u>> b() {
                return this.f21392b;
            }

            public final LinkedHashMap<d<EVENT, EVENT>, Function2<STATE, EVENT, C0284a<STATE, SIDE_EFFECT>>> c() {
                return this.f21393c;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(STATE state, Map<d<STATE, STATE>, C0283a<STATE, EVENT, SIDE_EFFECT>> map, List<? extends Function1<? super e<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, u>> list) {
            m.g(state, "initialState");
            m.g(map, "stateDefinitions");
            m.g(list, "onTransitionListeners");
            this.a = state;
            this.f21390b = map;
            this.f21391c = list;
        }

        public final STATE a() {
            return this.a;
        }

        public final List<Function1<e<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, u>> b() {
            return this.f21391c;
        }

        public final Map<d<STATE, STATE>, C0283a<STATE, EVENT, SIDE_EFFECT>> c() {
            return this.f21390b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return m.a(this.a, bVar.a) && m.a(this.f21390b, bVar.f21390b) && m.a(this.f21391c, bVar.f21391c);
        }

        public int hashCode() {
            STATE state = this.a;
            int iHashCode = (state != null ? state.hashCode() : 0) * 31;
            Map<d<STATE, STATE>, C0283a<STATE, EVENT, SIDE_EFFECT>> map = this.f21390b;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            List<Function1<e<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, u>> list = this.f21391c;
            return iHashCode2 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "Graph(initialState=" + this.a + ", stateDefinitions=" + this.f21390b + ", onTransitionListeners=" + this.f21391c + ")";
        }
    }

    /* JADX INFO: compiled from: StateMachine.kt */
    public static abstract class e<STATE, EVENT, SIDE_EFFECT> {

        /* JADX INFO: renamed from: e.i.a$e$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: StateMachine.kt */
        public static final class C0288a<STATE, EVENT, SIDE_EFFECT> extends e<STATE, EVENT, SIDE_EFFECT> {
            private final STATE a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final EVENT f21403b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0288a(STATE state, EVENT event) {
                super(null);
                m.g(state, "fromState");
                m.g(event, "event");
                this.a = state;
                this.f21403b = event;
            }

            public EVENT a() {
                return this.f21403b;
            }

            public STATE b() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0288a)) {
                    return false;
                }
                C0288a c0288a = (C0288a) obj;
                return m.a(b(), c0288a.b()) && m.a(a(), c0288a.a());
            }

            public int hashCode() {
                STATE stateB = b();
                int iHashCode = (stateB != null ? stateB.hashCode() : 0) * 31;
                EVENT eventA = a();
                return iHashCode + (eventA != null ? eventA.hashCode() : 0);
            }

            public String toString() {
                return "Invalid(fromState=" + b() + ", event=" + a() + ")";
            }
        }

        /* JADX INFO: compiled from: StateMachine.kt */
        public static final class b<STATE, EVENT, SIDE_EFFECT> extends e<STATE, EVENT, SIDE_EFFECT> {
            private final STATE a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final EVENT f21404b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final STATE f21405c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final SIDE_EFFECT f21406d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(STATE state, EVENT event, STATE state2, SIDE_EFFECT side_effect) {
                super(null);
                m.g(state, "fromState");
                m.g(event, "event");
                m.g(state2, "toState");
                this.a = state;
                this.f21404b = event;
                this.f21405c = state2;
                this.f21406d = side_effect;
            }

            public EVENT a() {
                return this.f21404b;
            }

            public STATE b() {
                return this.a;
            }

            public final STATE c() {
                return this.f21405c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return m.a(b(), bVar.b()) && m.a(a(), bVar.a()) && m.a(this.f21405c, bVar.f21405c) && m.a(this.f21406d, bVar.f21406d);
            }

            public int hashCode() {
                STATE stateB = b();
                int iHashCode = (stateB != null ? stateB.hashCode() : 0) * 31;
                EVENT eventA = a();
                int iHashCode2 = (iHashCode + (eventA != null ? eventA.hashCode() : 0)) * 31;
                STATE state = this.f21405c;
                int iHashCode3 = (iHashCode2 + (state != null ? state.hashCode() : 0)) * 31;
                SIDE_EFFECT side_effect = this.f21406d;
                return iHashCode3 + (side_effect != null ? side_effect.hashCode() : 0);
            }

            public String toString() {
                return "Valid(fromState=" + b() + ", event=" + a() + ", toState=" + this.f21405c + ", sideEffect=" + this.f21406d + ")";
            }
        }

        private e() {
        }

        public /* synthetic */ e(g gVar) {
            this();
        }
    }

    private a(b<STATE, EVENT, SIDE_EFFECT> bVar) {
        this.f21389c = bVar;
        this.f21388b = new AtomicReference<>(bVar.a());
    }

    private final b.C0283a<STATE, EVENT, SIDE_EFFECT> a(STATE state) {
        Map<d<STATE, STATE>, b.C0283a<STATE, EVENT, SIDE_EFFECT>> mapC = this.f21389c.c();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<d<STATE, STATE>, b.C0283a<STATE, EVENT, SIDE_EFFECT>> entry : mapC.entrySet()) {
            if (entry.getKey().b(state)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add((b.C0283a) ((Map.Entry) it.next()).getValue());
        }
        b.C0283a<STATE, EVENT, SIDE_EFFECT> c0283a = (b.C0283a) s.W(arrayList);
        if (c0283a != null) {
            return c0283a;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final e<STATE, EVENT, SIDE_EFFECT> c(STATE state, EVENT event) {
        for (Map.Entry<d<EVENT, EVENT>, Function2<STATE, EVENT, b.C0283a.C0284a<STATE, SIDE_EFFECT>>> entry : a(state).c().entrySet()) {
            d<EVENT, EVENT> key = entry.getKey();
            Function2<STATE, EVENT, b.C0283a.C0284a<STATE, SIDE_EFFECT>> value = entry.getValue();
            if (key.b(event)) {
                b.C0283a.C0284a<STATE, SIDE_EFFECT> c0284aInvoke = value.invoke(state, event);
                return new e.b(state, event, c0284aInvoke.a(), c0284aInvoke.b());
            }
        }
        return new e.C0288a(state, event);
    }

    private final void d(STATE state, EVENT event) {
        Iterator<T> it = a(state).a().iterator();
        while (it.hasNext()) {
            ((Function2) it.next()).invoke(state, event);
        }
    }

    private final void e(STATE state, EVENT event) {
        Iterator<T> it = a(state).b().iterator();
        while (it.hasNext()) {
            ((Function2) it.next()).invoke(state, event);
        }
    }

    private final void f(e<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT> eVar) {
        Iterator<T> it = this.f21389c.b().iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(eVar);
        }
    }

    public final STATE b() {
        STATE state = this.f21388b.get();
        m.b(state, "stateRef.get()");
        return state;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final e<STATE, EVENT, SIDE_EFFECT> g(EVENT event) {
        e<STATE, EVENT, SIDE_EFFECT> eVarC;
        m.g(event, "event");
        synchronized (this) {
            STATE state = this.f21388b.get();
            m.b(state, "fromState");
            eVarC = c(state, event);
            if (eVarC instanceof e.b) {
                this.f21388b.set((STATE) ((e.b) eVarC).c());
            }
        }
        f(eVarC);
        if (eVarC instanceof e.b) {
            e.b bVar = (e.b) eVarC;
            e(bVar.b(), event);
            d(bVar.c(), event);
        }
        return eVarC;
    }

    /* JADX INFO: compiled from: StateMachine.kt */
    public static final class d<T, R extends T> {
        public static final C0287a a = new C0287a(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<Function1<T, Boolean>> f21400b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Class<R> f21401c;

        /* JADX INFO: renamed from: e.i.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: StateMachine.kt */
        public static final class C0287a {
            private C0287a() {
            }

            public final <T, R extends T> d<T, R> a(Class<R> cls) {
                m.g(cls, "clazz");
                return new d<>(cls, null);
            }

            public /* synthetic */ C0287a(g gVar) {
                this();
            }
        }

        /* JADX INFO: compiled from: StateMachine.kt */
        static final class b extends Lambda implements Function1<T, Boolean> {
            b() {
                super(1);
            }

            public final boolean b(T t) {
                m.g(t, "it");
                return d.this.f21401c.isInstance(t);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                return Boolean.valueOf(b(obj));
            }
        }

        private d(Class<R> cls) {
            this.f21401c = cls;
            this.f21400b = kotlin.collections.u.p(new b());
        }

        public final boolean b(T t) {
            m.g(t, "value");
            List<Function1<T, Boolean>> list = this.f21400b;
            if ((list instanceof Collection) && list.isEmpty()) {
                return true;
            }
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (!((Boolean) ((Function1) it.next()).invoke(t)).booleanValue()) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ d(Class cls, g gVar) {
            this(cls);
        }
    }

    public /* synthetic */ a(b bVar, g gVar) {
        this(bVar);
    }

    /* JADX INFO: compiled from: StateMachine.kt */
    public static final class c<STATE, EVENT, SIDE_EFFECT> {
        private STATE a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final LinkedHashMap<d<STATE, STATE>, b.C0283a<STATE, EVENT, SIDE_EFFECT>> f21395b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ArrayList<Function1<e<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, u>> f21396c;

        /* JADX INFO: renamed from: e.i.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: StateMachine.kt */
        public final class C0285a<S extends STATE> {
            private final b.C0283a<STATE, EVENT, SIDE_EFFECT> a = new b.C0283a<>();

            /* JADX INFO: renamed from: e.i.a$c$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: StateMachine.kt */
            static final class C0286a extends Lambda implements Function2<STATE, EVENT, b.C0283a.C0284a<? extends STATE, ? extends SIDE_EFFECT>> {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ Function2 f21398f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0286a(Function2 function2) {
                    super(2);
                    this.f21398f = function2;
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final b.C0283a.C0284a<STATE, SIDE_EFFECT> invoke(STATE state, EVENT event) {
                    m.g(state, "state");
                    m.g(event, "event");
                    return (b.C0283a.C0284a) this.f21398f.invoke(state, event);
                }
            }

            /* JADX INFO: renamed from: e.i.a$c$a$b */
            /* JADX INFO: compiled from: StateMachine.kt */
            static final class b extends Lambda implements Function2<STATE, EVENT, u> {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ Function2 f21399f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                b(Function2 function2) {
                    super(2);
                    this.f21399f = function2;
                }

                public final void b(STATE state, EVENT event) {
                    m.g(state, "state");
                    m.g(event, "cause");
                    this.f21399f.invoke(state, event);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ u invoke(Object obj, Object obj2) {
                    b(obj, obj2);
                    return u.a;
                }
            }

            public C0285a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* bridge */ /* synthetic */ b.C0283a.C0284a c(C0285a c0285a, Object obj, Object obj2, int i2, Object obj3) {
                if ((i2 & 1) != 0) {
                    obj2 = null;
                }
                return c0285a.b(obj, obj2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* bridge */ /* synthetic */ b.C0283a.C0284a g(C0285a c0285a, Object obj, Object obj2, Object obj3, int i2, Object obj4) {
                if ((i2 & 2) != 0) {
                    obj3 = null;
                }
                return c0285a.f(obj, obj2, obj3);
            }

            public final b.C0283a<STATE, EVENT, SIDE_EFFECT> a() {
                return this.a;
            }

            public final b.C0283a.C0284a<STATE, SIDE_EFFECT> b(S s, SIDE_EFFECT side_effect) {
                m.g(s, "$receiver");
                return f(s, s, side_effect);
            }

            public final <E extends EVENT> void d(d<EVENT, ? extends E> dVar, Function2<? super S, ? super E, ? extends b.C0283a.C0284a<? extends STATE, ? extends SIDE_EFFECT>> function2) {
                m.g(dVar, "eventMatcher");
                m.g(function2, "createTransitionTo");
                this.a.c().put(dVar, new C0286a(function2));
            }

            public final boolean e(Function2<? super S, ? super EVENT, u> function2) {
                m.g(function2, "listener");
                return this.a.a().add(new b(function2));
            }

            public final b.C0283a.C0284a<STATE, SIDE_EFFECT> f(S s, STATE state, SIDE_EFFECT side_effect) {
                m.g(s, "$receiver");
                m.g(state, "state");
                return new b.C0283a.C0284a<>(state, side_effect);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public c(b<STATE, EVENT, SIDE_EFFECT> bVar) {
            List<Function1<e<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, u>> listB;
            Map<d<STATE, STATE>, b.C0283a<STATE, EVENT, SIDE_EFFECT>> mapC;
            this.a = bVar != null ? bVar.a() : null;
            this.f21395b = new LinkedHashMap<>((bVar == null || (mapC = bVar.c()) == null) ? q0.i() : mapC);
            this.f21396c = new ArrayList<>((bVar == null || (listB = bVar.b()) == null) ? kotlin.collections.u.j() : listB);
        }

        public final b<STATE, EVENT, SIDE_EFFECT> a() {
            STATE state = this.a;
            if (state != null) {
                return new b<>(state, q0.s(this.f21395b), c0.E0(this.f21396c));
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }

        public final void b(STATE state) {
            m.g(state, "initialState");
            this.a = state;
        }

        public final <S extends STATE> void c(d<STATE, ? extends S> dVar, Function1<? super c<STATE, EVENT, SIDE_EFFECT>.C0285a<S>, u> function1) {
            m.g(dVar, "stateMatcher");
            m.g(function1, "init");
            LinkedHashMap<d<STATE, STATE>, b.C0283a<STATE, EVENT, SIDE_EFFECT>> linkedHashMap = this.f21395b;
            C0285a c0285a = new C0285a();
            function1.invoke(c0285a);
            linkedHashMap.put(dVar, c0285a.a());
        }

        public /* synthetic */ c(b bVar, int i2, g gVar) {
            this((i2 & 1) != 0 ? null : bVar);
        }
    }
}
