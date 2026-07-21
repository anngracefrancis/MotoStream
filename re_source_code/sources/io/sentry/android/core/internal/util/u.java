package io.sentry.android.core.internal.util;

import android.os.Handler;
import android.view.Window;

/* JADX INFO: compiled from: SentryFrameMetricsCollector.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class u {
    public static void a(t.c _this, Window window, Window.OnFrameMetricsAvailableListener onFrameMetricsAvailableListener, Handler handler) {
        window.addOnFrameMetricsAvailableListener(onFrameMetricsAvailableListener, handler);
    }

    public static void b(t.c _this, Window window, Window.OnFrameMetricsAvailableListener onFrameMetricsAvailableListener) {
        window.removeOnFrameMetricsAvailableListener(onFrameMetricsAvailableListener);
    }
}
