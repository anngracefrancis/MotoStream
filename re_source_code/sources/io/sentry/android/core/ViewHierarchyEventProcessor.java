package io.sentry.android.core;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import io.sentry.i2;
import io.sentry.j1;
import io.sentry.j2;
import io.sentry.k1;
import io.sentry.l4;
import io.sentry.n1;
import io.sentry.s4;
import io.sentry.w1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class ViewHierarchyEventProcessor implements k1, j2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SentryAndroidOptions f22087f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final io.sentry.android.core.internal.util.n f22088g = new io.sentry.android.core.internal.util.n(io.sentry.android.core.internal.util.g.b(), 2000, 3);

    public ViewHierarchyEventProcessor(SentryAndroidOptions sentryAndroidOptions) {
        this.f22087f = (SentryAndroidOptions) io.sentry.util.q.c(sentryAndroidOptions, "SentryAndroidOptions is required");
        if (sentryAndroidOptions.isAttachViewHierarchy()) {
            a();
        }
    }

    private static void f(View view, io.sentry.protocol.c0 c0Var, List<io.sentry.internal.viewhierarchy.a> list) {
        if (view instanceof ViewGroup) {
            Iterator<io.sentry.internal.viewhierarchy.a> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().a(c0Var, view)) {
                    return;
                }
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList(childCount);
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt != null) {
                    io.sentry.protocol.c0 c0VarJ = j(childAt);
                    arrayList.add(c0VarJ);
                    f(childAt, c0VarJ, list);
                }
            }
            c0Var.m(arrayList);
        }
    }

    static /* synthetic */ void g(AtomicReference atomicReference, View view, List list, CountDownLatch countDownLatch, w1 w1Var) {
        try {
            atomicReference.set(i(view, list));
            countDownLatch.countDown();
        } catch (Throwable th) {
            w1Var.b(s4.ERROR, "Failed to process view hierarchy.", th);
        }
    }

    public static io.sentry.protocol.b0 h(Activity activity, final List<io.sentry.internal.viewhierarchy.a> list, io.sentry.util.thread.b bVar, final w1 w1Var) {
        if (activity == null) {
            w1Var.c(s4.INFO, "Missing activity for view hierarchy snapshot.", new Object[0]);
            return null;
        }
        Window window = activity.getWindow();
        if (window == null) {
            w1Var.c(s4.INFO, "Missing window for view hierarchy snapshot.", new Object[0]);
            return null;
        }
        final View viewPeekDecorView = window.peekDecorView();
        if (viewPeekDecorView == null) {
            w1Var.c(s4.INFO, "Missing decor view for view hierarchy snapshot.", new Object[0]);
            return null;
        }
        try {
            if (bVar.d()) {
                return i(viewPeekDecorView, list);
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final AtomicReference atomicReference = new AtomicReference(null);
            activity.runOnUiThread(new Runnable() { // from class: io.sentry.android.core.d0
                @Override // java.lang.Runnable
                public final void run() {
                    ViewHierarchyEventProcessor.g(atomicReference, viewPeekDecorView, list, countDownLatch, w1Var);
                }
            });
            if (countDownLatch.await(1000L, TimeUnit.MILLISECONDS)) {
                return (io.sentry.protocol.b0) atomicReference.get();
            }
            return null;
        } catch (Throwable th) {
            w1Var.b(s4.ERROR, "Failed to process view hierarchy.", th);
        }
    }

    public static io.sentry.protocol.b0 i(View view, List<io.sentry.internal.viewhierarchy.a> list) {
        ArrayList arrayList = new ArrayList(1);
        io.sentry.protocol.b0 b0Var = new io.sentry.protocol.b0("android_view_system", arrayList);
        io.sentry.protocol.c0 c0VarJ = j(view);
        arrayList.add(c0VarJ);
        f(view, c0VarJ, list);
        return b0Var;
    }

    private static io.sentry.protocol.c0 j(View view) {
        io.sentry.protocol.c0 c0Var = new io.sentry.protocol.c0();
        c0Var.p(io.sentry.android.core.internal.util.j.a(view));
        try {
            c0Var.o(io.sentry.android.core.internal.gestures.j.b(view));
        } catch (Throwable unused) {
        }
        c0Var.t(Double.valueOf(view.getX()));
        c0Var.u(Double.valueOf(view.getY()));
        c0Var.s(Double.valueOf(view.getWidth()));
        c0Var.n(Double.valueOf(view.getHeight()));
        c0Var.l(Double.valueOf(view.getAlpha()));
        int visibility = view.getVisibility();
        if (visibility == 0) {
            c0Var.r("visible");
        } else if (visibility == 4) {
            c0Var.r("invisible");
        } else if (visibility == 8) {
            c0Var.r("gone");
        }
        return c0Var;
    }

    @Override // io.sentry.j2
    public /* synthetic */ void a() {
        i2.a(this);
    }

    @Override // io.sentry.k1
    public l4 b(l4 l4Var, n1 n1Var) {
        if (!l4Var.w0()) {
            return l4Var;
        }
        if (!this.f22087f.isAttachViewHierarchy()) {
            this.f22087f.getLogger().c(s4.DEBUG, "attachViewHierarchy is disabled.", new Object[0]);
            return l4Var;
        }
        if (io.sentry.util.m.e(n1Var)) {
            return l4Var;
        }
        boolean zA = this.f22088g.a();
        SentryAndroidOptions.a beforeViewHierarchyCaptureCallback = this.f22087f.getBeforeViewHierarchyCaptureCallback();
        if (beforeViewHierarchyCaptureCallback != null) {
            if (!beforeViewHierarchyCaptureCallback.a(l4Var, n1Var, zA)) {
                return l4Var;
            }
        } else if (zA) {
            return l4Var;
        }
        io.sentry.protocol.b0 b0VarH = h(u0.c().b(), this.f22087f.getViewHierarchyExporters(), this.f22087f.getMainThreadChecker(), this.f22087f.getLogger());
        if (b0VarH != null) {
            n1Var.m(io.sentry.s0.c(b0VarH));
        }
        return l4Var;
    }

    @Override // io.sentry.j2
    public /* synthetic */ String d() {
        return i2.b(this);
    }

    @Override // io.sentry.k1
    public /* synthetic */ io.sentry.protocol.x e(io.sentry.protocol.x xVar, n1 n1Var) {
        return j1.a(this, xVar, n1Var);
    }
}
