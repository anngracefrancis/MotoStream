package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleFragment;

/* JADX INFO: loaded from: classes2.dex */
final class c extends DialogRedirect {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Intent f12023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ LifecycleFragment f12024g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ int f12025h;

    c(Intent intent, LifecycleFragment lifecycleFragment, int i2) {
        this.f12023f = intent;
        this.f12024g = lifecycleFragment;
        this.f12025h = i2;
    }

    @Override // com.google.android.gms.common.internal.DialogRedirect
    public final void d() {
        Intent intent = this.f12023f;
        if (intent != null) {
            this.f12024g.startActivityForResult(intent, this.f12025h);
        }
    }
}
