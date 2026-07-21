package kotlin.reflect.y.internal.j0.m;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.AbstractIterator;
import kotlin.collections.j;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: ArrayMap.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d<T> extends c<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f24888f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Object[] f24889g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f24890h;

    /* JADX INFO: compiled from: ArrayMap.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: ArrayMap.kt */
    public static final class b extends AbstractIterator<T> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f24891h = -1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ d<T> f24892i;

        b(d<T> dVar) {
            this.f24892i = dVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.collections.AbstractIterator
        protected void b() {
            do {
                int i2 = this.f24891h + 1;
                this.f24891h = i2;
                if (i2 >= ((d) this.f24892i).f24889g.length) {
                    break;
                }
            } while (((d) this.f24892i).f24889g[this.f24891h] == null);
            if (this.f24891h >= ((d) this.f24892i).f24889g.length) {
                c();
                return;
            }
            Object obj = ((d) this.f24892i).f24889g[this.f24891h];
            m.d(obj, "null cannot be cast to non-null type T of org.jetbrains.kotlin.util.ArrayMapImpl");
            d(obj);
        }
    }

    private d(Object[] objArr, int i2) {
        super(null);
        this.f24889g = objArr;
        this.f24890h = i2;
    }

    private final void i(int i2) {
        Object[] objArr = this.f24889g;
        if (objArr.length <= i2) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length * 2);
            m.e(objArrCopyOf, "copyOf(this, newSize)");
            this.f24889g = objArrCopyOf;
        }
    }

    @Override // kotlin.reflect.y.internal.j0.m.c
    public int c() {
        return this.f24890h;
    }

    @Override // kotlin.reflect.y.internal.j0.m.c
    public void f(int i2, T t) {
        m.f(t, "value");
        i(i2);
        if (this.f24889g[i2] == null) {
            this.f24890h = c() + 1;
        }
        this.f24889g[i2] = t;
    }

    @Override // kotlin.reflect.y.internal.j0.m.c
    public T get(int i2) {
        return (T) j.C(this.f24889g, i2);
    }

    @Override // kotlin.reflect.y.internal.j0.m.c, java.lang.Iterable
    public Iterator<T> iterator() {
        return new b(this);
    }

    public d() {
        this(new Object[20], 0);
    }
}
