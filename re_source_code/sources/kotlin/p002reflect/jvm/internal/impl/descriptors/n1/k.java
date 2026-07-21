package kotlin.p002reflect.jvm.internal.impl.descriptors.n1;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.c0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.sequences.Sequence;
import kotlin.sequences.i;
import kotlin.sequences.n;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class k implements g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<g> f25186f;

    /* JADX INFO: compiled from: Annotations.kt */
    static final class a extends Lambda implements Function1<g, c> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f25187f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(c cVar) {
            super(1);
            this.f25187f = cVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final c invoke(g gVar) {
            m.f(gVar, "it");
            return gVar.l(this.f25187f);
        }
    }

    /* JADX INFO: compiled from: Annotations.kt */
    static final class b extends Lambda implements Function1<g, Sequence<? extends c>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f25188f = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Sequence<c> invoke(g gVar) {
            m.f(gVar, "it");
            return c0.J(gVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(List<? extends g> list) {
        m.f(list, "delegates");
        this.f25186f = list;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g
    public boolean R0(c cVar) {
        m.f(cVar, "fqName");
        Iterator it = c0.J(this.f25186f).iterator();
        while (it.hasNext()) {
            if (((g) it.next()).R0(cVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g
    public boolean isEmpty() {
        List<g> list = this.f25186f;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!((g) it.next()).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator<c> iterator() {
        return n.p(c0.J(this.f25186f), b.f25188f).iterator();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g
    public c l(c cVar) {
        m.f(cVar, "fqName");
        return (c) i.o(n.v(c0.J(this.f25186f), new a(cVar)));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(g... gVarArr) {
        this((List<? extends g>) kotlin.collections.n.Z(gVarArr));
        m.f(gVarArr, "delegates");
    }
}
