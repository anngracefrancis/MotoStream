package c.x;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: ViewGroupUtilsApi14.java */
/* JADX INFO: loaded from: classes.dex */
class y {
    private static LayoutTransition a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f3613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f3614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f3615d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f3616e;

    /* JADX INFO: compiled from: ViewGroupUtilsApi14.java */
    static class a extends LayoutTransition {
        a() {
        }

        @Override // android.animation.LayoutTransition
        public boolean isChangingLayout() {
            return true;
        }
    }

    private static void a(LayoutTransition layoutTransition) {
        if (!f3616e) {
            try {
                Method declaredMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                f3615d = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            }
            f3616e = true;
        }
        Method method = f3615d;
        if (method != null) {
            try {
                method.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException unused2) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            } catch (InvocationTargetException unused3) {
                Log.i("ViewGroupUtilsApi14", "Failed to invoke cancel method by reflection");
            }
        }
    }

    static void b(ViewGroup viewGroup, boolean z) {
        boolean z2 = false;
        if (a == null) {
            a aVar = new a();
            a = aVar;
            aVar.setAnimator(2, null);
            a.setAnimator(0, null);
            a.setAnimator(1, null);
            a.setAnimator(3, null);
            a.setAnimator(4, null);
        }
        if (z) {
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null) {
                if (layoutTransition.isRunning()) {
                    a(layoutTransition);
                }
                if (layoutTransition != a) {
                    viewGroup.setTag(j.f3574d, layoutTransition);
                }
            }
            viewGroup.setLayoutTransition(a);
            return;
        }
        viewGroup.setLayoutTransition(null);
        if (!f3614c) {
            try {
                Field declaredField = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                f3613b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewGroupUtilsApi14", "Failed to access mLayoutSuppressed field by reflection");
            }
            f3614c = true;
        }
        Field field = f3613b;
        if (field != null) {
            try {
                boolean z3 = field.getBoolean(viewGroup);
                if (z3) {
                    try {
                        f3613b.setBoolean(viewGroup, false);
                    } catch (IllegalAccessException unused2) {
                        z2 = z3;
                        Log.i("ViewGroupUtilsApi14", "Failed to get mLayoutSuppressed field by reflection");
                    }
                }
                z2 = z3;
            } catch (IllegalAccessException unused3) {
            }
        }
        if (z2) {
            viewGroup.requestLayout();
        }
        int i2 = j.f3574d;
        LayoutTransition layoutTransition2 = (LayoutTransition) viewGroup.getTag(i2);
        if (layoutTransition2 != null) {
            viewGroup.setTag(i2, null);
            viewGroup.setLayoutTransition(layoutTransition2);
        }
    }
}
