package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzapt {
    private final zzbgz a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f14052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f14053c;

    public zzapt(zzbgz zzbgzVar, Map<String, String> map) {
        this.a = zzbgzVar;
        this.f14053c = map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.f14052b = Boolean.parseBoolean(map.get("allowOrientationChange"));
        } else {
            this.f14052b = true;
        }
    }

    public final void a() {
        int iS;
        if (this.a == null) {
            zzbad.i("AdWebView is null");
            return;
        }
        if ("portrait".equalsIgnoreCase(this.f14053c)) {
            zzk.zzli();
            iS = 7;
        } else if ("landscape".equalsIgnoreCase(this.f14053c)) {
            zzk.zzli();
            iS = 6;
        } else {
            iS = this.f14052b ? -1 : zzk.zzli().s();
        }
        this.a.setRequestedOrientation(iS);
    }
}
