package io.sentry.android.core.internal.util;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import io.sentry.android.core.s0;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FirstDrawDoneListener.java */
/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ObsoleteSdkInt"})
public class p implements ViewTreeObserver.OnDrawListener {
    private final Handler a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicReference<View> f22193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Runnable f22194c;

    /* JADX INFO: compiled from: FirstDrawDoneListener.java */
    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.getViewTreeObserver().addOnDrawListener(p.this);
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
        }
    }

    private p(View view, Runnable runnable) {
        this.f22193b = new AtomicReference<>(view);
        this.f22194c = runnable;
    }

    private static boolean a(View view, s0 s0Var) {
        return view.getViewTreeObserver().isAlive() && b(view, s0Var);
    }

    @SuppressLint({"NewApi"})
    private static boolean b(View view, s0 s0Var) {
        if (s0Var.d() >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(View view) {
        view.getViewTreeObserver().removeOnDrawListener(this);
    }

    public static void e(View view, Runnable runnable, s0 s0Var) {
        p pVar = new p(view, runnable);
        if (s0Var.d() >= 26 || a(view, s0Var)) {
            view.getViewTreeObserver().addOnDrawListener(pVar);
        } else {
            view.addOnAttachStateChangeListener(pVar.new a());
        }
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public void onDraw() {
        final View andSet = this.f22193b.getAndSet(null);
        if (andSet == null) {
            return;
        }
        andSet.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: io.sentry.android.core.internal.util.a
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f22177f.d(andSet);
            }
        });
        this.a.postAtFrontOfQueue(this.f22194c);
    }
}
