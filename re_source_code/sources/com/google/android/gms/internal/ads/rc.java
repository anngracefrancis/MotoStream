package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class rc implements zzaho<Object> {
    final /* synthetic */ zzbmg a;

    rc(zzbmg zzbmgVar) {
        this.a = zzbmgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final void a(Object obj, Map<String, String> map) {
        if (this.a.h(map)) {
            if (((Boolean) zzyt.e().c(zzacu.z4)).booleanValue()) {
                this.a.f14538c.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.sc

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    private final rc f13323f;

                    {
                        this.f13323f = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f13323f.a.f14539d.q();
                    }
                });
            } else {
                this.a.f14539d.q();
            }
        }
    }
}
