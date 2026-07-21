package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: OneShotPreDrawListener.java */
/* JADX INFO: loaded from: classes.dex */
public final class r implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final View f1055f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ViewTreeObserver f1056g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Runnable f1057h;

    private r(View view, Runnable runnable) {
        this.f1055f = view;
        this.f1056g = view.getViewTreeObserver();
        this.f1057h = runnable;
    }

    public static r a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        r rVar = new r(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(rVar);
        view.addOnAttachStateChangeListener(rVar);
        return rVar;
    }

    public void b() {
        if (this.f1056g.isAlive()) {
            this.f1056g.removeOnPreDrawListener(this);
        } else {
            this.f1055f.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f1055f.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f1057h.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f1056g = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
