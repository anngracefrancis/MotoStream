package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes2.dex */
final class l3 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzapu f12909f;

    l3(zzapu zzapuVar) {
        this.f12909f = zzapuVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f12909f.e("User canceled the download.");
    }
}
