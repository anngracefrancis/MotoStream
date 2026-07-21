package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzagw implements zzaho<Object> {
    private final zzagx a;

    public zzagw(zzagx zzagxVar) {
        this.a = zzagxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final void a(Object obj, Map<String, String> map) {
        String str = map.get("name");
        if (str == null) {
            zzbad.i("App event with no name parameter.");
        } else {
            this.a.onAppEvent(str, map.get("info"));
        }
    }
}
