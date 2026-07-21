package com.airbnb.epoxy;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Window;

/* JADX INFO: compiled from: ActivityRecyclerPool.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final boolean a(Context context) {
        if (context == null) {
            return true;
        }
        if (!(context instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) context;
        if (activity.isFinishing()) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            return activity.isDestroyed();
        }
        Window window = activity.getWindow();
        kotlin.jvm.internal.m.b(window, "window");
        return !androidx.core.view.u.N(window.getDecorView());
    }
}
