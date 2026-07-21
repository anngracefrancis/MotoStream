package com.google.android.material.badge;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.internal.ParcelableSparseArray;

/* JADX INFO: compiled from: BadgeUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static final boolean a;

    static {
        a = Build.VERSION.SDK_INT < 18;
    }

    public static void a(BadgeDrawable badgeDrawable, View view, FrameLayout frameLayout) {
        e(badgeDrawable, view, frameLayout);
        if (a) {
            frameLayout.setForeground(badgeDrawable);
        } else {
            view.getOverlay().add(badgeDrawable);
        }
    }

    public static SparseArray<BadgeDrawable> b(Context context, ParcelableSparseArray parcelableSparseArray) {
        SparseArray<BadgeDrawable> sparseArray = new SparseArray<>(parcelableSparseArray.size());
        for (int i2 = 0; i2 < parcelableSparseArray.size(); i2++) {
            int iKeyAt = parcelableSparseArray.keyAt(i2);
            BadgeDrawable.SavedState savedState = (BadgeDrawable.SavedState) parcelableSparseArray.valueAt(i2);
            if (savedState == null) {
                throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
            }
            sparseArray.put(iKeyAt, BadgeDrawable.c(context, savedState));
        }
        return sparseArray;
    }

    public static ParcelableSparseArray c(SparseArray<BadgeDrawable> sparseArray) {
        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            int iKeyAt = sparseArray.keyAt(i2);
            BadgeDrawable badgeDrawableValueAt = sparseArray.valueAt(i2);
            if (badgeDrawableValueAt == null) {
                throw new IllegalArgumentException("badgeDrawable cannot be null");
            }
            parcelableSparseArray.put(iKeyAt, badgeDrawableValueAt.i());
        }
        return parcelableSparseArray;
    }

    public static void d(BadgeDrawable badgeDrawable, View view, FrameLayout frameLayout) {
        if (badgeDrawable == null) {
            return;
        }
        if (a) {
            frameLayout.setForeground(null);
        } else {
            view.getOverlay().remove(badgeDrawable);
        }
    }

    public static void e(BadgeDrawable badgeDrawable, View view, FrameLayout frameLayout) {
        Rect rect = new Rect();
        (a ? frameLayout : view).getDrawingRect(rect);
        badgeDrawable.setBounds(rect);
        badgeDrawable.u(view, frameLayout);
    }

    public static void f(Rect rect, float f2, float f3, float f4, float f5) {
        rect.set((int) (f2 - f4), (int) (f3 - f5), (int) (f2 + f4), (int) (f3 + f5));
    }
}
