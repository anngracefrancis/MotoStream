package com.facebook.o0.m0;

import android.view.MotionEvent;
import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: RCTCodelessLoggingEventListener.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k {
    public static final k a = new k();

    /* JADX INFO: compiled from: RCTCodelessLoggingEventListener.kt */
    public static final class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final com.facebook.o0.m0.n.a f10287f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final WeakReference<View> f10288g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final WeakReference<View> f10289h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final View.OnTouchListener f10290i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f10291j;

        public a(com.facebook.o0.m0.n.a aVar, View view, View view2) {
            kotlin.jvm.internal.m.f(aVar, "mapping");
            kotlin.jvm.internal.m.f(view, "rootView");
            kotlin.jvm.internal.m.f(view2, "hostView");
            this.f10287f = aVar;
            this.f10288g = new WeakReference<>(view2);
            this.f10289h = new WeakReference<>(view);
            com.facebook.o0.m0.n.f fVar = com.facebook.o0.m0.n.f.a;
            this.f10290i = com.facebook.o0.m0.n.f.h(view2);
            this.f10291j = true;
        }

        public final boolean a() {
            return this.f10291j;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            kotlin.jvm.internal.m.f(view, "view");
            kotlin.jvm.internal.m.f(motionEvent, "motionEvent");
            View view2 = this.f10289h.get();
            View view3 = this.f10288g.get();
            if (view2 != null && view3 != null && motionEvent.getAction() == 1) {
                h hVar = h.a;
                h.d(this.f10287f, view2, view3);
            }
            View.OnTouchListener onTouchListener = this.f10290i;
            return onTouchListener != null && onTouchListener.onTouch(view, motionEvent);
        }
    }

    private k() {
    }

    public static final a a(com.facebook.o0.m0.n.a aVar, View view, View view2) {
        kotlin.jvm.internal.m.f(aVar, "mapping");
        kotlin.jvm.internal.m.f(view, "rootView");
        kotlin.jvm.internal.m.f(view2, "hostView");
        return new a(aVar, view, view2);
    }
}
