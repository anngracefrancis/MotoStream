package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzbhq extends zzaas {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzbdf f14461f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f14463h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f14464i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f14465j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private zzaau f14466k;
    private boolean l;
    private float n;
    private float o;
    private float p;
    private boolean q;
    private boolean r;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f14462g = new Object();
    private boolean m = true;

    public zzbhq(zzbdf zzbdfVar, float f2, boolean z, boolean z2) {
        this.f14461f = zzbdfVar;
        this.n = f2;
        this.f14463h = z;
        this.f14464i = z2;
    }

    private final void j7(final int i2, final int i3, final boolean z, final boolean z2) {
        zzbbm.a.execute(new Runnable(this, i2, i3, z, z2) { // from class: com.google.android.gms.internal.ads.gb

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbhq f12640f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final int f12641g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private final int f12642h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private final boolean f12643i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private final boolean f12644j;

            {
                this.f12640f = this;
                this.f12641g = i2;
                this.f12642h = i3;
                this.f12643i = z;
                this.f12644j = z2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12640f.l7(this.f12641g, this.f12642h, this.f12643i, this.f12644j);
            }
        });
    }

    private final void o7(String str, Map<String, String> map) {
        final HashMap map2 = map == null ? new HashMap() : new HashMap(map);
        map2.put("action", str);
        zzbbm.a.execute(new Runnable(this, map2) { // from class: com.google.android.gms.internal.ads.fb

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbhq f12578f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final Map f12579g;

            {
                this.f12578f = this;
                this.f12579g = map2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12578f.p7(this.f12579g);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final int F() {
        int i2;
        synchronized (this.f14462g) {
            i2 = this.f14465j;
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final boolean G1() {
        boolean z;
        synchronized (this.f14462g) {
            z = this.m;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final float Q6() {
        float f2;
        synchronized (this.f14462g) {
            f2 = this.n;
        }
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void R1(zzaau zzaauVar) {
        synchronized (this.f14462g) {
            this.f14466k = zzaauVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final float S5() {
        float f2;
        synchronized (this.f14462g) {
            f2 = this.o;
        }
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final float T() {
        float f2;
        synchronized (this.f14462g) {
            f2 = this.p;
        }
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final zzaau a5() throws RemoteException {
        zzaau zzaauVar;
        synchronized (this.f14462g) {
            zzaauVar = this.f14466k;
        }
        return zzaauVar;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0015  */
    @Override // com.google.android.gms.internal.ads.zzaar
    public final boolean d1() {
        boolean z;
        boolean zL5 = l5();
        synchronized (this.f14462g) {
            if (zL5) {
                z = false;
            } else {
                try {
                    if (this.r && this.f14464i) {
                        z = true;
                    } else {
                        z = false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return z;
    }

    public final void i7(float f2, float f3, int i2, boolean z, float f4) {
        boolean z2;
        int i3;
        synchronized (this.f14462g) {
            this.n = f3;
            this.o = f2;
            z2 = this.m;
            this.m = z;
            i3 = this.f14465j;
            this.f14465j = i2;
            float f5 = this.p;
            this.p = f4;
            if (Math.abs(f4 - f5) > 1.0E-4f) {
                this.f14461f.getView().invalidate();
            }
        }
        j7(i3, i2, z2, z);
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void k5() {
        o7("play", null);
    }

    public final void k7() {
        boolean z;
        int i2;
        synchronized (this.f14462g) {
            z = this.m;
            i2 = this.f14465j;
            this.f14465j = 3;
        }
        j7(i2, 3, z, z);
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final boolean l5() {
        boolean z;
        synchronized (this.f14462g) {
            z = this.f14463h && this.q;
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0056 A[Catch: RemoteException -> 0x0040, all -> 0x0073, TryCatch #0 {RemoteException -> 0x0040, blocks: (B:35:0x0038, B:37:0x003c, B:41:0x0044, B:43:0x0048, B:45:0x004d, B:47:0x0051, B:49:0x0056, B:51:0x005a, B:52:0x005d, B:54:0x0064, B:56:0x0068), top: B:64:0x0038, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x005a A[Catch: RemoteException -> 0x0040, all -> 0x0073, TryCatch #0 {RemoteException -> 0x0040, blocks: (B:35:0x0038, B:37:0x003c, B:41:0x0044, B:43:0x0048, B:45:0x004d, B:47:0x0051, B:49:0x0056, B:51:0x005a, B:52:0x005d, B:54:0x0064, B:56:0x0068), top: B:64:0x0038, outer: #1 }] */
    final /* synthetic */ void l7(int i2, int i3, boolean z, boolean z2) {
        zzaau zzaauVar;
        zzaau zzaauVar2;
        zzaau zzaauVar3;
        zzaau zzaauVar4;
        synchronized (this.f14462g) {
            boolean z3 = i2 != i3;
            boolean z4 = this.l;
            boolean z5 = !z4 && i3 == 1;
            boolean z6 = z3 && i3 == 1;
            boolean z7 = z3 && i3 == 2;
            boolean z8 = z3 && i3 == 3;
            boolean z9 = z != z2;
            this.l = z4 || z5;
            if (z5) {
                try {
                    zzaau zzaauVar5 = this.f14466k;
                    if (zzaauVar5 != null) {
                        zzaauVar5.onVideoStart();
                    }
                    if (z6 && (zzaauVar4 = this.f14466k) != null) {
                        zzaauVar4.onVideoPlay();
                    }
                    if (z7 && (zzaauVar3 = this.f14466k) != null) {
                        zzaauVar3.onVideoPause();
                    }
                    if (z8) {
                        zzaauVar2 = this.f14466k;
                        if (zzaauVar2 != null) {
                            zzaauVar2.n0();
                        }
                        this.f14461f.M();
                    }
                    if (z9 && (zzaauVar = this.f14466k) != null) {
                        zzaauVar.T0(z2);
                    }
                } catch (RemoteException e2) {
                    zzbad.f("#007 Could not call remote method.", e2);
                }
            } else {
                if (z6) {
                    zzaauVar4.onVideoPlay();
                }
                if (z7) {
                    zzaauVar3.onVideoPause();
                }
                if (z8) {
                    zzaauVar2 = this.f14466k;
                    if (zzaauVar2 != null) {
                        zzaauVar2.n0();
                    }
                    this.f14461f.M();
                }
                if (z9) {
                    zzaauVar.T0(z2);
                }
            }
            throw th;
        }
    }

    public final void m7(zzacd zzacdVar) {
        boolean z = zzacdVar.f13785f;
        boolean z2 = zzacdVar.f13786g;
        boolean z3 = zzacdVar.f13787h;
        synchronized (this.f14462g) {
            this.q = z2;
            this.r = z3;
        }
        o7("initialState", CollectionUtils.d("muteStart", z ? "1" : "0", "customControlsRequested", z2 ? "1" : "0", "clickToExpandRequested", z3 ? "1" : "0"));
    }

    public final void n7(float f2) {
        synchronized (this.f14462g) {
            this.o = f2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void o2(boolean z) {
        o7(z ? "mute" : "unmute", null);
    }

    final /* synthetic */ void p7(Map map) {
        this.f14461f.y("pubVideoCmd", map);
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void pause() {
        o7("pause", null);
    }
}
