package kotlin.reflect.y.internal.j0.j.b.g0;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.reflect.KProperty;
import kotlin.reflect.y.internal.j0.k.i;
import kotlin.reflect.y.internal.j0.k.n;

/* JADX INFO: compiled from: DeserializedAnnotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public class a implements g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f24493f = {g0.h(new y(g0.b(a.class), "annotations", "getAnnotations()Ljava/util/List;"))};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final i f24494g;

    public a(n nVar, Function0<? extends List<? extends c>> function0) {
        m.f(nVar, "storageManager");
        m.f(function0, "compute");
        this.f24494g = nVar.d(function0);
    }

    private final List<c> c() {
        return (List) kotlin.reflect.y.internal.j0.k.m.a(this.f24494g, this, f24493f[0]);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g
    public boolean R0(kotlin.reflect.y.internal.j0.f.c cVar) {
        return g.b.b(this, cVar);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g
    public boolean isEmpty() {
        return c().isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<c> iterator() {
        return c().iterator();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g
    public c l(kotlin.reflect.y.internal.j0.f.c cVar) {
        return g.b.a(this, cVar);
    }
}
