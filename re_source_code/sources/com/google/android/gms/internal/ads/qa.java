package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

/* JADX INFO: loaded from: classes2.dex */
final class qa implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ JsPromptResult f13228f;

    qa(JsPromptResult jsPromptResult) {
        this.f13228f = jsPromptResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f13228f.cancel();
    }
}
