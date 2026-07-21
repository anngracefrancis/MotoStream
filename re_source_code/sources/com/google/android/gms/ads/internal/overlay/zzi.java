package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzayb;

/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
@zzard
final class zzi extends RelativeLayout {

    @VisibleForTesting
    private zzayb zzdkf;

    @VisibleForTesting
    boolean zzdkg;

    public zzi(Context context, String str, String str2) {
        super(context);
        zzayb zzaybVar = new zzayb(context, str);
        this.zzdkf = zzaybVar;
        zzaybVar.j(str2);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zzdkg) {
            return false;
        }
        this.zzdkf.g(motionEvent);
        return false;
    }
}
