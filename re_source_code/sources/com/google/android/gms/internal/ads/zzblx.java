package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzblx implements zzbls {
    private final zzcxk a;

    public zzblx(zzcxk zzcxkVar) {
        this.a = zzcxkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final void a(Map<String, String> map) {
        String str = map.get("render_in_browser");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.a.d(Boolean.parseBoolean(str));
        } catch (Exception unused) {
            throw new IllegalStateException("Invalid render_in_browser state");
        }
    }
}
