package com.google.android.gms.common.internal;

import android.content.Intent;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes2.dex */
final class b extends DialogRedirect {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Intent f12020f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ Fragment f12021g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ int f12022h;

    b(Intent intent, Fragment fragment, int i2) {
        this.f12020f = intent;
        this.f12021g = fragment;
        this.f12022h = i2;
    }

    @Override // com.google.android.gms.common.internal.DialogRedirect
    public final void d() {
        Intent intent = this.f12020f;
        if (intent != null) {
            this.f12021g.startActivityForResult(intent, this.f12022h);
        }
    }
}
