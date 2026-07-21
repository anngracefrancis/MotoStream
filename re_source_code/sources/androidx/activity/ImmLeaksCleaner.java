package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import androidx.lifecycle.k;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
final class ImmLeaksCleaner implements i {
    private static int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f79b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Field f80c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Field f81d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Activity f82e;

    ImmLeaksCleaner(Activity activity) {
        this.f82e = activity;
    }

    private static void b() {
        try {
            a = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f80c = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f81d = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f79b = declaredField3;
            declaredField3.setAccessible(true);
            a = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.i
    public void a(k kVar, g.b bVar) {
        if (bVar != g.b.ON_DESTROY) {
            return;
        }
        if (a == 0) {
            b();
        }
        if (a == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f82e.getSystemService("input_method");
            try {
                Object obj = f79b.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) f80c.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                f81d.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused) {
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    } catch (ClassCastException unused2) {
                    } catch (IllegalAccessException unused3) {
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}
