package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzbgz;

/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
@zzard
public final class zzj {
    public final int index;
    public final ViewGroup parent;
    public final ViewGroup.LayoutParams zzdkh;
    public final Context zzlj;

    public zzj(zzbgz zzbgzVar) throws zzh {
        this.zzdkh = zzbgzVar.getLayoutParams();
        ViewParent parent = zzbgzVar.getParent();
        this.zzlj = zzbgzVar.d0();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new zzh("Could not get the parent of the WebView for an overlay.");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        this.parent = viewGroup;
        this.index = viewGroup.indexOfChild(zzbgzVar.getView());
        viewGroup.removeView(zzbgzVar.getView());
        zzbgzVar.j0(true);
    }
}
