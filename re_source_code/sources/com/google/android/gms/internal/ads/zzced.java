package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.common.util.PlatformVersion;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(19)
public final class zzced {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PopupWindow f15136b;

    private static PopupWindow c(Context context, View view) {
        Window window = context instanceof Activity ? ((Activity) context).getWindow() : null;
        if (window == null || window.getDecorView() == null || ((Activity) context).isDestroyed()) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.addView(view, -1, -1);
        PopupWindow popupWindow = new PopupWindow((View) frameLayout, 1, 1, false);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setClippingEnabled(false);
        zzbad.e("Displaying the 1x1 popup off the screen.");
        try {
            popupWindow.showAtLocation(window.getDecorView(), 0, -1, -1);
            return popupWindow;
        } catch (Exception unused) {
            return null;
        }
    }

    public final void a(Context context, View view) {
        if (!PlatformVersion.f() || PlatformVersion.h()) {
            return;
        }
        PopupWindow popupWindowC = c(context, view);
        this.f15136b = popupWindowC;
        if (popupWindowC == null) {
            context = null;
        }
        this.a = context;
    }

    public final void b() {
        Context context = this.a;
        if (context == null || this.f15136b == null) {
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isDestroyed()) {
            this.a = null;
            this.f15136b = null;
        } else {
            if (this.f15136b.isShowing()) {
                this.f15136b.dismiss();
            }
            this.a = null;
            this.f15136b = null;
        }
    }
}
