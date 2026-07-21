package kotlin.p002reflect.jvm.internal.impl.utils;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.n;
import kotlin.collections.w0;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: SmartSet.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f<T> extends AbstractSet<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f25524f = new b(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Object f25525g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f25526h;

    /* JADX INFO: compiled from: SmartSet.kt */
    private static final class a<T> implements Iterator<T>, KMappedMarker {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Iterator<T> f25527f;

        public a(T[] tArr) {
            m.f(tArr, "array");
            this.f25527f = kotlin.jvm.internal.b.a(tArr);
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f25527f.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.f25527f.next();
        }
    }

    /* JADX INFO: compiled from: SmartSet.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }

        public final <T> f<T> a() {
            return new f<>(null);
        }

        public final <T> f<T> b(Collection<? extends T> collection) {
            m.f(collection, "set");
            f<T> fVar = new f<>(null);
            fVar.addAll(collection);
            return fVar;
        }
    }

    /* JADX INFO: compiled from: SmartSet.kt */
    private static final class c<T> implements Iterator<T>, KMappedMarker {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final T f25528f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f25529g = true;

        public c(T t) {
            this.f25528f = t;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f25529g;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f25529g) {
                throw new NoSuchElementException();
            }
            this.f25529g = false;
            return this.f25528f;
        }
    }

    private f() {
    }

    public /* synthetic */ f(g gVar) {
        this();
    }

    public static final <T> f<T> c() {
        return f25524f.a();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(T t) {
        Object obj;
        if (size() == 0) {
            this.f25525g = t;
        } else if (size() == 1) {
            if (m.a(this.f25525g, t)) {
                return false;
            }
            this.f25525g = new Object[]{this.f25525g, t};
        } else if (size() < 5) {
            Object obj2 = this.f25525g;
            m.d(obj2, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            Object[] objArr = (Object[]) obj2;
            if (n.t(objArr, t)) {
                return false;
            }
            if (size() == 4) {
                LinkedHashSet linkedHashSetF = w0.f(Arrays.copyOf(objArr, objArr.length));
                linkedHashSetF.add(t);
                obj = linkedHashSetF;
            } else {
                Object[] objArrCopyOf = Arrays.copyOf(objArr, size() + 1);
                m.e(objArrCopyOf, "copyOf(this, newSize)");
                objArrCopyOf[objArrCopyOf.length - 1] = t;
                obj = objArrCopyOf;
            }
            this.f25525g = obj;
        } else {
            Object obj3 = this.f25525g;
            m.d(obj3, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
            if (!l0.d(obj3).add(t)) {
                return false;
            }
        }
        g(size() + 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f25525g = null;
        g(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (size() == 0) {
            return false;
        }
        if (size() == 1) {
            return m.a(this.f25525g, obj);
        }
        if (size() < 5) {
            Object obj2 = this.f25525g;
            m.d(obj2, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return n.t((Object[]) obj2, obj);
        }
        Object obj3 = this.f25525g;
        m.d(obj3, "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
        return ((Set) obj3).contains(obj);
    }

    public int f() {
        return this.f25526h;
    }

    public void g(int i2) {
        this.f25526h = i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<T> iterator() {
        if (size() == 0) {
            return Collections.emptySet().iterator();
        }
        if (size() == 1) {
            return new c(this.f25525g);
        }
        if (size() < 5) {
            Object obj = this.f25525g;
            m.d(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return new a((Object[]) obj);
        }
        Object obj2 = this.f25525g;
        m.d(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        return l0.d(obj2).iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return f();
    }
}
