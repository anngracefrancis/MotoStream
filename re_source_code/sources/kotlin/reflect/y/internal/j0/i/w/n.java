package kotlin.reflect.y.internal.j0.i.w;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.c0;
import kotlin.collections.v;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y0;
import kotlin.p002reflect.jvm.internal.impl.utils.e;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.l;
import kotlin.reflect.y.internal.j0.l.e0;

/* JADX INFO: compiled from: TypeIntersectionScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends kotlin.reflect.y.internal.j0.i.w.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f24432b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f24433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final h f24434d;

    /* JADX INFO: compiled from: TypeIntersectionScope.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final h a(String str, Collection<? extends e0> collection) {
            m.f(str, "message");
            m.f(collection, "types");
            ArrayList arrayList = new ArrayList(v.u(collection, 10));
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(((e0) it.next()).q());
            }
            e<h> eVarB = kotlin.reflect.y.internal.j0.m.v.a.b(arrayList);
            h hVarB = kotlin.reflect.y.internal.j0.i.w.b.f24397b.b(str, eVarB);
            return eVarB.size() <= 1 ? hVarB : new n(str, hVarB, null);
        }
    }

    /* JADX INFO: compiled from: TypeIntersectionScope.kt */
    static final class b extends Lambda implements Function1<kotlin.p002reflect.jvm.internal.impl.descriptors.a, kotlin.p002reflect.jvm.internal.impl.descriptors.a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f24435f = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final kotlin.p002reflect.jvm.internal.impl.descriptors.a invoke(kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar) {
            m.f(aVar, "$this$selectMostSpecificInEachOverridableGroup");
            return aVar;
        }
    }

    /* JADX INFO: compiled from: TypeIntersectionScope.kt */
    static final class c extends Lambda implements Function1<y0, kotlin.p002reflect.jvm.internal.impl.descriptors.a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f24436f = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final kotlin.p002reflect.jvm.internal.impl.descriptors.a invoke(y0 y0Var) {
            m.f(y0Var, "$this$selectMostSpecificInEachOverridableGroup");
            return y0Var;
        }
    }

    /* JADX INFO: compiled from: TypeIntersectionScope.kt */
    static final class d extends Lambda implements Function1<t0, kotlin.p002reflect.jvm.internal.impl.descriptors.a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final d f24437f = new d();

        d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final kotlin.p002reflect.jvm.internal.impl.descriptors.a invoke(t0 t0Var) {
            m.f(t0Var, "$this$selectMostSpecificInEachOverridableGroup");
            return t0Var;
        }
    }

    private n(String str, h hVar) {
        this.f24433c = str;
        this.f24434d = hVar;
    }

    public /* synthetic */ n(String str, h hVar, g gVar) {
        this(str, hVar);
    }

    public static final h j(String str, Collection<? extends e0> collection) {
        return f24432b.a(str, collection);
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.a, kotlin.reflect.y.internal.j0.i.w.h
    public Collection<y0> a(f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        return l.a(super.a(fVar, bVar), c.f24436f);
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.a, kotlin.reflect.y.internal.j0.i.w.h
    public Collection<t0> c(f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        return l.a(super.c(fVar, bVar), d.f24437f);
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.a, kotlin.reflect.y.internal.j0.i.w.k
    public Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.m> g(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super f, Boolean> function1) {
        m.f(dVar, "kindFilter");
        m.f(function1, "nameFilter");
        Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.m> collectionG = super.g(dVar, function1);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : collectionG) {
            if (((kotlin.p002reflect.jvm.internal.impl.descriptors.m) obj) instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.a) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        List list = (List) pair.a();
        List list2 = (List) pair.b();
        m.d(list, "null cannot be cast to non-null type kotlin.collections.Collection<org.jetbrains.kotlin.descriptors.CallableDescriptor>");
        return c0.o0(l.a(list, b.f24435f), list2);
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.a
    protected h i() {
        return this.f24434d;
    }
}
