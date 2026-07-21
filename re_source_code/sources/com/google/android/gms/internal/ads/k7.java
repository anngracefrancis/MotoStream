package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.zzk;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@zzard
final class k7 extends m7 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final WeakReference<ViewTreeObserver.OnGlobalLayoutListener> f12854g;

    public k7(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        super(view);
        this.f12854g = new WeakReference<>(onGlobalLayoutListener);
    }

    @Override // com.google.android.gms.internal.ads.m7
    protected final void d(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnGlobalLayoutListener(this);
    }

    @Override // com.google.android.gms.internal.ads.m7
    protected final void e(ViewTreeObserver viewTreeObserver) {
        zzk.zzli().i(viewTreeObserver, this);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.f12854g.get();
        if (onGlobalLayoutListener != null) {
            onGlobalLayoutListener.onGlobalLayout();
        } else {
            b();
        }
    }
}
