package com.google.android.gms.internal.ads;

import android.os.Build;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class vp implements Callable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final Callable f13466f = new vp();

    private vp() {
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        HashMap map = new HashMap();
        String str = (String) zzyt.e().c(zzacu.R);
        if (str != null && !str.isEmpty()) {
            if (Build.VERSION.SDK_INT >= ((Integer) zzyt.e().c(zzacu.S)).intValue()) {
                for (String str2 : str.split(",", -1)) {
                    map.put(str2, zzazr.b(str2));
                }
            }
        }
        return new zzcxg(map);
    }
}
