package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class qb implements zzaho<zzbgz> {
    private final /* synthetic */ ob a;

    qb(ob obVar) {
        this.a = obVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final /* synthetic */ void a(zzbgz zzbgzVar, Map map) {
        if (map != null) {
            String str = (String) map.get("height");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int i2 = Integer.parseInt(str);
                synchronized (this.a) {
                    if (this.a.G != i2) {
                        this.a.G = i2;
                        this.a.requestLayout();
                    }
                }
            } catch (Exception e2) {
                zzbad.d("Exception occurred while getting webview content height", e2);
            }
        }
    }
}
