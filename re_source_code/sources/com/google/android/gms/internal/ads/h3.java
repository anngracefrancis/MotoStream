package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: loaded from: classes2.dex */
final class h3 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzapo f12684f;

    h3(zzapo zzapoVar) {
        this.f12684f = zzapoVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        Intent intentH = this.f12684f.h();
        zzk.zzlg();
        zzaxi.i(this.f12684f.f14037d, intentH);
    }
}
