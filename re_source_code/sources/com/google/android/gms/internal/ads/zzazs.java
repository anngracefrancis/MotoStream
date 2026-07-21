package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzazs {
    private final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Activity f14308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f14311e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f14312f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ViewTreeObserver.OnScrollChangedListener f14313g = null;

    public zzazs(Activity activity, View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.f14308b = activity;
        this.a = view;
        this.f14312f = onGlobalLayoutListener;
    }

    private static ViewTreeObserver d(Activity activity) {
        Window window;
        View decorView;
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return null;
        }
        return decorView.getViewTreeObserver();
    }

    private final void g() {
        ViewTreeObserver viewTreeObserverD;
        if (this.f14309c) {
            return;
        }
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.f14312f;
        if (onGlobalLayoutListener != null) {
            Activity activity = this.f14308b;
            if (activity != null && (viewTreeObserverD = d(activity)) != null) {
                viewTreeObserverD.addOnGlobalLayoutListener(onGlobalLayoutListener);
            }
            zzk.zzmd();
            zzbbz.a(this.a, this.f14312f);
        }
        this.f14309c = true;
    }

    private final void h() {
        ViewTreeObserver viewTreeObserverD;
        Activity activity = this.f14308b;
        if (activity != null && this.f14309c) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.f14312f;
            if (onGlobalLayoutListener != null && (viewTreeObserverD = d(activity)) != null) {
                zzk.zzli().i(viewTreeObserverD, onGlobalLayoutListener);
            }
            this.f14309c = false;
        }
    }

    public final void a() {
        this.f14310d = true;
        if (this.f14311e) {
            g();
        }
    }

    public final void b() {
        this.f14310d = false;
        h();
    }

    public final void c(Activity activity) {
        this.f14308b = activity;
    }

    public final void e() {
        this.f14311e = true;
        if (this.f14310d) {
            g();
        }
    }

    public final void f() {
        this.f14311e = false;
        h();
    }
}
