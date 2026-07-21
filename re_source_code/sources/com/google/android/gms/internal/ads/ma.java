package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* JADX INFO: loaded from: classes2.dex */
final class ma implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ JsResult f12975f;

    ma(JsResult jsResult) {
        this.f12975f = jsResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.f12975f.cancel();
    }
}
