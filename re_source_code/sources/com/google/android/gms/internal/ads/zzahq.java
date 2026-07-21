package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzahq implements zzaho<Object> {
    private final Context a;

    public zzahq(Context context) {
        this.a = context;
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final void a(Object obj, Map<String, String> map) {
        if (zzk.zzme().D(this.a)) {
            String str = map.get("eventName");
            String str2 = map.get("eventId");
            str.hashCode();
            switch (str) {
                case "_aa":
                    zzk.zzme().y(this.a, str2);
                    break;
                case "_ac":
                    zzk.zzme().u(this.a, str2);
                    break;
                case "_ai":
                    zzk.zzme().v(this.a, str2);
                    break;
                default:
                    zzbad.g("logScionEvent gmsg contained unsupported eventName");
                    break;
            }
        }
    }
}
