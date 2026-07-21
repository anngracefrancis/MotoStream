package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(19)
public class zzaxu extends zzaxs {
    @Override // com.google.android.gms.internal.ads.zzaxs, com.google.android.gms.internal.ads.zzaxo
    public final boolean b(View view) {
        return view.isAttachedToWindow();
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public final ViewGroup.LayoutParams t() {
        return new ViewGroup.LayoutParams(-1, -1);
    }
}
