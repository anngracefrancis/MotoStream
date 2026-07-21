package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class db implements zzaho<zzbgz> {
    private final /* synthetic */ bb a;

    db(bb bbVar) {
        this.a = bbVar;
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
                    if (this.a.I != i2) {
                        this.a.I = i2;
                        this.a.requestLayout();
                    }
                }
            } catch (Exception e2) {
                zzbad.d("Exception occurred while getting webview content height", e2);
            }
        }
    }
}
