package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@zzard
abstract class m7 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final WeakReference<View> f12964f;

    public m7(View view) {
        this.f12964f = new WeakReference<>(view);
    }

    private final ViewTreeObserver c() {
        ViewTreeObserver viewTreeObserver;
        View view = this.f12964f.get();
        if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return null;
        }
        return viewTreeObserver;
    }

    public final void a() {
        ViewTreeObserver viewTreeObserverC = c();
        if (viewTreeObserverC != null) {
            d(viewTreeObserverC);
        }
    }

    public final void b() {
        ViewTreeObserver viewTreeObserverC = c();
        if (viewTreeObserverC != null) {
            e(viewTreeObserverC);
        }
    }

    protected abstract void d(ViewTreeObserver viewTreeObserver);

    protected abstract void e(ViewTreeObserver viewTreeObserver);
}
