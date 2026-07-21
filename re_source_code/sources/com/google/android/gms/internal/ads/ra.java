package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.widget.EditText;

/* JADX INFO: loaded from: classes2.dex */
final class ra implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ JsPromptResult f13267f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ EditText f13268g;

    ra(JsPromptResult jsPromptResult, EditText editText) {
        this.f13267f = jsPromptResult;
        this.f13268g = editText;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f13267f.confirm(this.f13268g.getText().toString());
    }
}
