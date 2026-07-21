package com.facebook;

import android.os.Handler;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: GraphRequestBatch.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c0 extends AbstractList<GraphRequest> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f9667f = new b(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final AtomicInteger f9668g = new AtomicInteger();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Handler f9669h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f9670i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f9671j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<GraphRequest> f9672k;
    private List<a> l;
    private String m;

    /* JADX INFO: compiled from: GraphRequestBatch.kt */
    public interface a {
        void a(c0 c0Var);
    }

    /* JADX INFO: compiled from: GraphRequestBatch.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: GraphRequestBatch.kt */
    public interface c extends a {
        void b(c0 c0Var, long j2, long j3);
    }

    public c0(Collection<GraphRequest> collection) {
        kotlin.jvm.internal.m.f(collection, "requests");
        this.f9671j = String.valueOf(Integer.valueOf(f9668g.incrementAndGet()));
        this.l = new ArrayList();
        this.f9672k = new ArrayList(collection);
    }

    private final List<d0> n() {
        return GraphRequest.a.g(this);
    }

    private final b0 q() {
        return GraphRequest.a.j(this);
    }

    public /* bridge */ int A(GraphRequest graphRequest) {
        return super.lastIndexOf(graphRequest);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public final /* bridge */ GraphRequest remove(int i2) {
        return E(i2);
    }

    public /* bridge */ boolean D(GraphRequest graphRequest) {
        return super.remove(graphRequest);
    }

    public GraphRequest E(int i2) {
        return this.f9672k.remove(i2);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public GraphRequest set(int i2, GraphRequest graphRequest) {
        kotlin.jvm.internal.m.f(graphRequest, "element");
        return this.f9672k.set(i2, graphRequest);
    }

    public final void G(Handler handler) {
        this.f9669h = handler;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void add(int i2, GraphRequest graphRequest) {
        kotlin.jvm.internal.m.f(graphRequest, "element");
        this.f9672k.add(i2, graphRequest);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f9672k.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null ? true : obj instanceof GraphRequest) {
            return h((GraphRequest) obj);
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean add(GraphRequest graphRequest) {
        kotlin.jvm.internal.m.f(graphRequest, "element");
        return this.f9672k.add(graphRequest);
    }

    public final void g(a aVar) {
        kotlin.jvm.internal.m.f(aVar, "callback");
        if (this.l.contains(aVar)) {
            return;
        }
        this.l.add(aVar);
    }

    public /* bridge */ boolean h(GraphRequest graphRequest) {
        return super.contains(graphRequest);
    }

    public final List<d0> i() {
        return n();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj == null ? true : obj instanceof GraphRequest) {
            return z((GraphRequest) obj);
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj == null ? true : obj instanceof GraphRequest) {
            return A((GraphRequest) obj);
        }
        return -1;
    }

    public final b0 o() {
        return q();
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public GraphRequest get(int i2) {
        return this.f9672k.get(i2);
    }

    public final String s() {
        return this.m;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return x();
    }

    public final Handler t() {
        return this.f9669h;
    }

    public final List<a> u() {
        return this.l;
    }

    public final String v() {
        return this.f9671j;
    }

    public final List<GraphRequest> w() {
        return this.f9672k;
    }

    public int x() {
        return this.f9672k.size();
    }

    public final int y() {
        return this.f9670i;
    }

    public /* bridge */ int z(GraphRequest graphRequest) {
        return super.indexOf(graphRequest);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        if (obj == null ? true : obj instanceof GraphRequest) {
            return D((GraphRequest) obj);
        }
        return false;
    }

    public c0(GraphRequest... graphRequestArr) {
        kotlin.jvm.internal.m.f(graphRequestArr, "requests");
        this.f9671j = String.valueOf(Integer.valueOf(f9668g.incrementAndGet()));
        this.l = new ArrayList();
        this.f9672k = new ArrayList(kotlin.collections.m.c(graphRequestArr));
    }
}
