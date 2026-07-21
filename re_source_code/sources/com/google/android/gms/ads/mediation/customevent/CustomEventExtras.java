package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.e;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class CustomEventExtras implements e {
    private final HashMap<String, Object> zzeob = new HashMap<>();

    public final Object getExtra(String str) {
        return this.zzeob.get(str);
    }

    public final void setExtra(String str, Object obj) {
        this.zzeob.put(str, obj);
    }
}
