package io.sentry.android.core;

import android.app.Activity;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: CurrentActivityHolder.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public class u0 {
    private static final u0 a = new u0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakReference<Activity> f22260b;

    private u0() {
    }

    public static u0 c() {
        return a;
    }

    public void a() {
        this.f22260b = null;
    }

    public Activity b() {
        WeakReference<Activity> weakReference = this.f22260b;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void d(Activity activity) {
        WeakReference<Activity> weakReference = this.f22260b;
        if (weakReference == null || weakReference.get() != activity) {
            this.f22260b = new WeakReference<>(activity);
        }
    }
}
