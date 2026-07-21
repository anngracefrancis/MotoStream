package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* JADX INFO: loaded from: classes2.dex */
final class na implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ JsResult f13031f;

    na(JsResult jsResult) {
        this.f13031f = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f13031f.cancel();
    }
}
