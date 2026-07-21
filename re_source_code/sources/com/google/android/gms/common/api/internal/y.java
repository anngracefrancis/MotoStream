package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes2.dex */
final class y implements BackgroundDetector.BackgroundStateChangeListener {
    private final /* synthetic */ GoogleApiManager a;

    y(GoogleApiManager googleApiManager) {
        this.a = googleApiManager;
    }

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
    public final void a(boolean z) {
        this.a.v.sendMessage(this.a.v.obtainMessage(1, Boolean.valueOf(z)));
    }
}
