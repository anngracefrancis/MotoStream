package com.airbnb.epoxy.preload;

import android.content.Context;
import android.view.View;
import com.airbnb.epoxy.a0;
import com.airbnb.epoxy.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.t;
import kotlin.collections.z;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.u;

/* JADX INFO: compiled from: PreloadableViewDataProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    private final Map<a, List<g<?>>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.airbnb.epoxy.d f8458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function2<Context, RuntimeException, u> f8459c;

    /* JADX INFO: compiled from: PreloadableViewDataProvider.kt */
    private static final class a {
        private final Class<? extends s<?>> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f8460b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f8461c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Object f8462d;

        public a(Class<? extends s<?>> cls, int i2, int i3, Object obj) {
            m.g(cls, "epoxyModelClass");
            this.a = cls;
            this.f8460b = i2;
            this.f8461c = i3;
            this.f8462d = obj;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (m.a(this.a, aVar.a)) {
                        if (this.f8460b == aVar.f8460b) {
                            if (!(this.f8461c == aVar.f8461c) || !m.a(this.f8462d, aVar.f8462d)) {
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            Class<? extends s<?>> cls = this.a;
            int iHashCode = (((((cls != null ? cls.hashCode() : 0) * 31) + this.f8460b) * 31) + this.f8461c) * 31;
            Object obj = this.f8462d;
            return iHashCode + (obj != null ? obj.hashCode() : 0);
        }

        public String toString() {
            return "CacheKey(epoxyModelClass=" + this.a + ", spanSize=" + this.f8460b + ", viewType=" + this.f8461c + ", signature=" + this.f8462d + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(com.airbnb.epoxy.d dVar, Function2<? super Context, ? super RuntimeException, u> function2) {
        m.g(dVar, "adapter");
        m.g(function2, "errorHandler");
        this.f8458b = dVar;
        this.f8459c = function2;
        this.a = new LinkedHashMap();
    }

    private final <T extends s<?>, U extends h, P extends c> g<U> a(View view, com.airbnb.epoxy.preload.a<T, U, P> aVar, T t) {
        int width = (view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight();
        int height = (view.getHeight() - view.getPaddingTop()) - view.getPaddingBottom();
        if (width > 0 && height > 0) {
            return new g<>(view.getId(), width, height, aVar.a(view));
        }
        Function2<Context, RuntimeException, u> function2 = this.f8459c;
        Context context = view.getContext();
        m.b(context, "context");
        function2.invoke(context, new EpoxyPreloadException(view.getClass().getSimpleName() + " in " + t.getClass().getSimpleName() + " has zero size. A size must be set to allow preloading."));
        return null;
    }

    private final <T extends s<?>> a b(com.airbnb.epoxy.preload.a<T, ?, ?> aVar, T t, int i2) {
        return new a(t.getClass(), this.f8458b.n() ? t.spanSize(this.f8458b.l(), i2, this.f8458b.getItemCount()) : 1, a0.d(t), aVar.e(t));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T extends s<?>, U extends h, P extends c> List<g<U>> d(com.airbnb.epoxy.preload.a<T, U, P> aVar, T t, a aVar2) {
        com.airbnb.epoxy.u next;
        View view;
        List<View> listA;
        boolean z;
        com.airbnb.epoxy.e eVarA = a0.a(this.f8458b);
        m.b(eVarA, "adapter.boundViewHoldersInternal()");
        Iterator<com.airbnb.epoxy.u> it = eVarA.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            com.airbnb.epoxy.u uVar = next;
            m.b(uVar, "it");
            s<?> sVarC = uVar.c();
            z = false;
            if (m.a(g0.b(sVarC.getClass()), g0.b(t.getClass())) && androidx.core.view.u.N(uVar.itemView) && androidx.core.view.u.O(uVar.itemView) && m.a(b(aVar, sVarC, uVar.getAdapterPosition()), aVar2)) {
                z = true;
            }
        } while (!z);
        com.airbnb.epoxy.u uVar2 = next;
        if (uVar2 == null || (view = uVar2.itemView) == 0) {
            return null;
        }
        m.b(view, "holderMatch?.itemView ?: return null");
        Object objC = a0.c(uVar2);
        if (!aVar.c().isEmpty()) {
            listA = e(view, aVar.c(), t);
        } else if (view instanceof e) {
            listA = ((e) view).a();
        } else {
            listA = objC instanceof e ? ((e) objC).a() : kotlin.collections.u.j();
        }
        if (listA.isEmpty()) {
            Function2<Context, RuntimeException, u> function2 = this.f8459c;
            Context context = view.getContext();
            m.b(context, "rootView.context");
            function2.invoke(context, new EpoxyPreloadException("No preloadable views were found in " + t.getClass().getSimpleName()));
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = listA.iterator();
        while (it2.hasNext()) {
            z.z(arrayList, f((View) it2.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            g gVarA = a((View) it3.next(), aVar, t);
            if (gVarA != null) {
                arrayList2.add(gVarA);
            }
        }
        return arrayList2;
    }

    private final <T extends s<?>> List<View> e(View view, List<Integer> list, T t) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            View viewFindViewById = view.findViewById(iIntValue);
            if (viewFindViewById == null) {
                Function2<Context, RuntimeException, u> function2 = this.f8459c;
                Context context = view.getContext();
                m.b(context, "context");
                function2.invoke(context, new EpoxyPreloadException("View with id " + iIntValue + " in " + t.getClass().getSimpleName() + " could not be found."));
            }
            if (viewFindViewById != null) {
                arrayList.add(viewFindViewById);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T extends View> List<View> f(T t) {
        if (!(t instanceof e)) {
            return t.e(t);
        }
        List<View> listA = ((e) t).a();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listA.iterator();
        while (it.hasNext()) {
            z.z(arrayList, f((View) it.next()));
        }
        return arrayList;
    }

    public final <T extends s<?>, U extends h, P extends c> List<g<U>> c(com.airbnb.epoxy.preload.a<T, U, P> aVar, T t, int i2) {
        m.g(aVar, "preloader");
        m.g(t, "epoxyModel");
        a aVarB = b(aVar, t, i2);
        Map<a, List<g<?>>> map = this.a;
        Collection collectionD = map.get(aVarB);
        if (collectionD == null) {
            collectionD = d(aVar, t, aVarB);
            map.put(aVarB, (List<g<?>>) collectionD);
        }
        if (!(collectionD instanceof List)) {
            collectionD = null;
        }
        List<g<U>> list = (List) collectionD;
        return list != null ? list : kotlin.collections.u.j();
    }
}
