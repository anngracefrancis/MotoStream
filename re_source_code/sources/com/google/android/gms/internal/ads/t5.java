package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: loaded from: classes2.dex */
final class t5 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ s5 f13346f;

    t5(s5 s5Var) {
        this.f13346f = s5Var;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        zzk.zzlg();
        zzaxi.j(this.f13346f.f13308f, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
