package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbvq extends zzbts<VideoController.VideoLifecycleCallbacks> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f14753g;

    protected zzbvq(Set<zzbuz<VideoController.VideoLifecycleCallbacks>> set) {
        super(set);
    }

    public final void Y() {
        T(gf.a);
    }

    public final void f0() {
        T(ff.a);
    }

    public final synchronized void g0() {
        if (!this.f14753g) {
            T(Cif.a);
            this.f14753g = true;
        }
        T(jf.a);
    }

    public final synchronized void i0() {
        T(hf.a);
        this.f14753g = true;
    }
}
