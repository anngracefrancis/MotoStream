package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes2.dex */
final class i3 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzapo f12742f;

    i3(zzapo zzapoVar) {
        this.f12742f = zzapoVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f12742f.e("Operation denied by user.");
    }
}
