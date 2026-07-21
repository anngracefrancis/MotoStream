package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class jf implements zzbtu {
    static final zzbtu a = new jf();

    private jf() {
    }

    @Override // com.google.android.gms.internal.ads.zzbtu
    public final void a(Object obj) {
        ((VideoController.VideoLifecycleCallbacks) obj).onVideoPlay();
    }
}
