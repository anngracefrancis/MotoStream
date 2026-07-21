package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class tc implements zzaho<Object> {
    final /* synthetic */ zzbmg a;

    tc(zzbmg zzbmgVar) {
        this.a = zzbmgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final void a(Object obj, Map<String, String> map) {
        if (this.a.h(map)) {
            if (((Boolean) zzyt.e().c(zzacu.z4)).booleanValue()) {
                this.a.f14538c.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.uc

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    private final tc f13395f;

                    {
                        this.f13395f = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f13395f.a.f14539d.y();
                    }
                });
            } else {
                this.a.f14539d.y();
            }
        }
    }
}
