package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@zzard
final class l7 extends m7 implements ViewTreeObserver.OnScrollChangedListener {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final WeakReference<ViewTreeObserver.OnScrollChangedListener> f12914g;

    public l7(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        super(view);
        this.f12914g = new WeakReference<>(onScrollChangedListener);
    }

    @Override // com.google.android.gms.internal.ads.m7
    protected final void d(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnScrollChangedListener(this);
    }

    @Override // com.google.android.gms.internal.ads.m7
    protected final void e(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.removeOnScrollChangedListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = this.f12914g.get();
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChanged();
        } else {
            b();
        }
    }
}
