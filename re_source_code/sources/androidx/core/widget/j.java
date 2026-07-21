package androidx.core.widget;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.view.u;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: PopupWindowCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    private static Method a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f1118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Field f1119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f1120d;

    public static void a(PopupWindow popupWindow, boolean z) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            popupWindow.setOverlapAnchor(z);
            return;
        }
        if (i2 >= 21) {
            if (!f1120d) {
                try {
                    Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    f1119c = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                    Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e2);
                }
                f1120d = true;
            }
            Field field = f1119c;
            if (field != null) {
                try {
                    field.set(popupWindow, Boolean.valueOf(z));
                } catch (IllegalAccessException e3) {
                    Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e3);
                }
            }
        }
    }

    public static void b(PopupWindow popupWindow, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            popupWindow.setWindowLayoutType(i2);
            return;
        }
        if (!f1118b) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            f1118b = true;
        }
        Method method = a;
        if (method != null) {
            try {
                method.invoke(popupWindow, Integer.valueOf(i2));
            } catch (Exception unused2) {
            }
        }
    }

    public static void c(PopupWindow popupWindow, View view, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 19) {
            popupWindow.showAsDropDown(view, i2, i3, i4);
            return;
        }
        if ((androidx.core.view.d.b(i4, u.y(view)) & 7) == 5) {
            i2 -= popupWindow.getWidth() - view.getWidth();
        }
        popupWindow.showAsDropDown(view, i2, i3);
    }
}
