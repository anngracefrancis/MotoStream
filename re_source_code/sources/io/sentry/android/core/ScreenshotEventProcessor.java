package io.sentry.android.core;

import android.app.Activity;
import io.sentry.i2;
import io.sentry.j1;
import io.sentry.j2;
import io.sentry.k1;
import io.sentry.l4;
import io.sentry.n1;
import io.sentry.s4;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class ScreenshotEventProcessor implements k1, j2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SentryAndroidOptions f22064f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final s0 f22065g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final io.sentry.android.core.internal.util.n f22066h = new io.sentry.android.core.internal.util.n(io.sentry.android.core.internal.util.g.b(), 2000, 3);

    public ScreenshotEventProcessor(SentryAndroidOptions sentryAndroidOptions, s0 s0Var) {
        this.f22064f = (SentryAndroidOptions) io.sentry.util.q.c(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f22065g = (s0) io.sentry.util.q.c(s0Var, "BuildInfoProvider is required");
        if (sentryAndroidOptions.isAttachScreenshot()) {
            a();
        }
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
        if (!this.f22064f.isAttachScreenshot()) {
            this.f22064f.getLogger().c(s4.DEBUG, "attachScreenshot is disabled.", new Object[0]);
            return l4Var;
        }
        Activity activityB = u0.c().b();
        if (activityB != null && !io.sentry.util.m.e(n1Var)) {
            boolean zA = this.f22066h.a();
            SentryAndroidOptions.a beforeScreenshotCaptureCallback = this.f22064f.getBeforeScreenshotCaptureCallback();
            if (beforeScreenshotCaptureCallback != null) {
                if (!beforeScreenshotCaptureCallback.a(l4Var, n1Var, zA)) {
                    return l4Var;
                }
            } else if (zA) {
                return l4Var;
            }
            byte[] bArrD = io.sentry.android.core.internal.util.s.d(activityB, this.f22064f.getMainThreadChecker(), this.f22064f.getLogger(), this.f22065g);
            if (bArrD == null) {
                return l4Var;
            }
            n1Var.k(io.sentry.s0.a(bArrD));
            n1Var.j("android:activity", activityB);
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
