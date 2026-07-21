package com.facebook.o0.m0;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.facebook.a0;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: CodelessLoggingEventListener.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h {
    public static final h a = new h();

    /* JADX INFO: compiled from: CodelessLoggingEventListener.kt */
    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private com.facebook.o0.m0.n.a f10256f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private WeakReference<View> f10257g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private WeakReference<View> f10258h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private View.OnClickListener f10259i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f10260j;

        public a(com.facebook.o0.m0.n.a aVar, View view, View view2) {
            kotlin.jvm.internal.m.f(aVar, "mapping");
            kotlin.jvm.internal.m.f(view, "rootView");
            kotlin.jvm.internal.m.f(view2, "hostView");
            this.f10256f = aVar;
            this.f10257g = new WeakReference<>(view2);
            this.f10258h = new WeakReference<>(view);
            com.facebook.o0.m0.n.f fVar = com.facebook.o0.m0.n.f.a;
            this.f10259i = com.facebook.o0.m0.n.f.g(view2);
            this.f10260j = true;
        }

        public final boolean a() {
            return this.f10260j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            kotlin.jvm.internal.m.f(view, "view");
            View.OnClickListener onClickListener = this.f10259i;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            View view2 = this.f10258h.get();
            View view3 = this.f10257g.get();
            if (view2 == null || view3 == null) {
                return;
            }
            h hVar = h.a;
            h.d(this.f10256f, view2, view3);
        }
    }

    /* JADX INFO: compiled from: CodelessLoggingEventListener.kt */
    public static final class b implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private com.facebook.o0.m0.n.a f10261f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private WeakReference<AdapterView<?>> f10262g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private WeakReference<View> f10263h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private AdapterView.OnItemClickListener f10264i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f10265j;

        public b(com.facebook.o0.m0.n.a aVar, View view, AdapterView<?> adapterView) {
            kotlin.jvm.internal.m.f(aVar, "mapping");
            kotlin.jvm.internal.m.f(view, "rootView");
            kotlin.jvm.internal.m.f(adapterView, "hostView");
            this.f10261f = aVar;
            this.f10262g = new WeakReference<>(adapterView);
            this.f10263h = new WeakReference<>(view);
            this.f10264i = adapterView.getOnItemClickListener();
            this.f10265j = true;
        }

        public final boolean a() {
            return this.f10265j;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            kotlin.jvm.internal.m.f(view, "view");
            AdapterView.OnItemClickListener onItemClickListener = this.f10264i;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(adapterView, view, i2, j2);
            }
            View view2 = this.f10263h.get();
            AdapterView<?> adapterView2 = this.f10262g.get();
            if (view2 == null || adapterView2 == null) {
                return;
            }
            h hVar = h.a;
            h.d(this.f10261f, view2, adapterView2);
        }
    }

    private h() {
    }

    public static final a a(com.facebook.o0.m0.n.a aVar, View view, View view2) {
        kotlin.jvm.internal.m.f(aVar, "mapping");
        kotlin.jvm.internal.m.f(view, "rootView");
        kotlin.jvm.internal.m.f(view2, "hostView");
        return new a(aVar, view, view2);
    }

    public static final b b(com.facebook.o0.m0.n.a aVar, View view, AdapterView<?> adapterView) {
        kotlin.jvm.internal.m.f(aVar, "mapping");
        kotlin.jvm.internal.m.f(view, "rootView");
        kotlin.jvm.internal.m.f(adapterView, "hostView");
        return new b(aVar, view, adapterView);
    }

    public static final void d(com.facebook.o0.m0.n.a aVar, View view, View view2) {
        kotlin.jvm.internal.m.f(aVar, "mapping");
        kotlin.jvm.internal.m.f(view, "rootView");
        kotlin.jvm.internal.m.f(view2, "hostView");
        final String strB = aVar.b();
        final Bundle bundleB = j.a.b(aVar, view, view2);
        a.f(bundleB);
        a0 a0Var = a0.a;
        a0.k().execute(new Runnable() { // from class: com.facebook.o0.m0.a
            @Override // java.lang.Runnable
            public final void run() {
                h.e(strB, bundleB);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(String str, Bundle bundle) {
        kotlin.jvm.internal.m.f(str, "$eventName");
        kotlin.jvm.internal.m.f(bundle, "$parameters");
        a0 a0Var = a0.a;
        com.facebook.o0.a0.a.g(a0.c()).d(str, bundle);
    }

    public final void f(Bundle bundle) {
        kotlin.jvm.internal.m.f(bundle, "parameters");
        String string = bundle.getString("_valueToSum");
        if (string != null) {
            com.facebook.o0.q0.g gVar = com.facebook.o0.q0.g.a;
            bundle.putDouble("_valueToSum", com.facebook.o0.q0.g.g(string));
        }
        bundle.putString("_is_fb_codeless", "1");
    }
}
