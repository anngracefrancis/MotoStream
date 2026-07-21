package com.airbnb.epoxy.preload;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.epoxy.a0;
import com.airbnb.epoxy.l;
import com.airbnb.epoxy.n;
import com.airbnb.epoxy.o;
import com.airbnb.epoxy.preload.c;
import com.airbnb.epoxy.s;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.collections.c0;
import kotlin.collections.p0;
import kotlin.collections.v;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.u;

/* JADX INFO: compiled from: EpoxyPreloader.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b<P extends c> extends RecyclerView.t {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IntRange f8449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IntProgression f8450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f8452e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<Class<? extends s<?>>, com.airbnb.epoxy.preload.a<?, ?, ? extends P>> f8453f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final d<P> f8454g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final f f8455h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.airbnb.epoxy.d f8456i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f8457j;

    /* JADX INFO: compiled from: EpoxyPreloader.kt */
    public static final class a {
        private a() {
        }

        public final <P extends c> b<P> a(l lVar, Function0<? extends P> function0, Function2<? super Context, ? super RuntimeException, u> function2, int i2, List<? extends com.airbnb.epoxy.preload.a<? extends s<?>, ? extends h, ? extends P>> list) {
            m.g(lVar, "epoxyAdapter");
            m.g(function0, "requestHolderFactory");
            m.g(function2, "errorHandler");
            m.g(list, "modelPreloaders");
            return new b<>(lVar, (Function0) function0, function2, i2, (List) list);
        }

        public final <P extends c> b<P> b(n nVar, Function0<? extends P> function0, Function2<? super Context, ? super RuntimeException, u> function2, int i2, List<? extends com.airbnb.epoxy.preload.a<? extends s<?>, ? extends h, ? extends P>> list) {
            m.g(nVar, "epoxyController");
            m.g(function0, "requestHolderFactory");
            m.g(function2, "errorHandler");
            m.g(list, "modelPreloaders");
            return new b<>(nVar, function0, function2, i2, list);
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    private b(com.airbnb.epoxy.d dVar, Function0<? extends P> function0, Function2<? super Context, ? super RuntimeException, u> function2, int i2, List<? extends com.airbnb.epoxy.preload.a<?, ?, ? extends P>> list) {
        this.f8456i = dVar;
        this.f8457j = i2;
        IntRange.a aVar = IntRange.f22979j;
        this.f8449b = aVar.a();
        this.f8450c = aVar.a();
        this.f8451d = -1;
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.l.b(p0.e(v.u(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(((com.airbnb.epoxy.preload.a) obj).b(), obj);
        }
        this.f8453f = linkedHashMap;
        this.f8454g = new d<>(this.f8457j, function0);
        this.f8455h = new f(this.f8456i, function2);
        if (this.f8457j > 0) {
            return;
        }
        throw new IllegalArgumentException(("maxItemsToPreload must be greater than 0. Was " + this.f8457j).toString());
    }

    private final IntProgression a(int i2, int i3, boolean z) {
        int i4 = z ? i3 + 1 : i2 - 1;
        int i5 = this.f8457j;
        return IntProgression.f22971f.a(c(i4), c((z ? i5 - 1 : 1 - i5) + i4), z ? 1 : -1);
    }

    private final int c(int i2) {
        return Math.min(this.f8451d - 1, Math.max(i2, 0));
    }

    private final boolean d(int i2) {
        return Math.abs(i2) > 75;
    }

    private final boolean e(int i2) {
        return i2 == -1 || i2 >= this.f8451d;
    }

    private final void f(int i2) {
        s<?> sVarB = a0.b(this.f8456i, i2);
        if (!(sVarB instanceof s)) {
            sVarB = null;
        }
        if (sVarB != null) {
            com.airbnb.epoxy.preload.a<?, ?, ? extends P> aVar = this.f8453f.get(sVarB.getClass());
            com.airbnb.epoxy.preload.a<?, ?, ? extends P> aVar2 = aVar instanceof com.airbnb.epoxy.preload.a ? aVar : null;
            if (aVar2 != null) {
                Iterator it = this.f8455h.c(aVar2, sVarB, i2).iterator();
                while (it.hasNext()) {
                    aVar2.d(sVarB, this.f8454g.b(), (g) it.next());
                }
            }
        }
    }

    public final void b() {
        this.f8454g.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t
    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        m.g(recyclerView, "recyclerView");
        this.f8452e = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t
    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        m.g(recyclerView, "recyclerView");
        if ((i2 == 0 && i3 == 0) || d(i2) || d(i3)) {
            return;
        }
        RecyclerView.g adapter = recyclerView.getAdapter();
        this.f8451d = adapter != null ? adapter.getItemCount() : 0;
        RecyclerView.o layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (e(iFindFirstVisibleItemPosition) || e(iFindLastVisibleItemPosition)) {
            IntRange.a aVar = IntRange.f22979j;
            this.f8449b = aVar.a();
            this.f8450c = aVar.a();
            return;
        }
        IntRange intRange = new IntRange(iFindFirstVisibleItemPosition, iFindLastVisibleItemPosition);
        if (m.a(intRange, this.f8449b)) {
            return;
        }
        IntProgression intProgressionA = a(iFindFirstVisibleItemPosition, iFindLastVisibleItemPosition, intRange.getF22972g() > this.f8449b.getF22972g() || intRange.getF22973h() > this.f8449b.getF22973h());
        Iterator it = c0.y0(intProgressionA, this.f8450c).iterator();
        while (it.hasNext()) {
            f(((Number) it.next()).intValue());
        }
        this.f8449b = intRange;
        this.f8450c = intProgressionA;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public b(n nVar, Function0<? extends P> function0, Function2<? super Context, ? super RuntimeException, u> function2, int i2, List<? extends com.airbnb.epoxy.preload.a<?, ?, ? extends P>> list) {
        m.g(nVar, "epoxyController");
        m.g(function0, "requestHolderFactory");
        m.g(function2, "errorHandler");
        m.g(list, "modelPreloaders");
        o adapter = nVar.getAdapter();
        m.b(adapter, "epoxyController.adapter");
        this(adapter, function0, function2, i2, list);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(l lVar, Function0<? extends P> function0, Function2<? super Context, ? super RuntimeException, u> function2, int i2, List<? extends com.airbnb.epoxy.preload.a<?, ?, ? extends P>> list) {
        this((com.airbnb.epoxy.d) lVar, (Function0) function0, function2, i2, (List) list);
        m.g(lVar, "adapter");
        m.g(function0, "requestHolderFactory");
        m.g(function2, "errorHandler");
        m.g(list, "modelPreloaders");
    }
}
