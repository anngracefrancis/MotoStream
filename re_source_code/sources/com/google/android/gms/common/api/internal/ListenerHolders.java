package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class ListenerHolders {
    private final Set<ListenerHolder<?>> a = Collections.newSetFromMap(new WeakHashMap());

    public final void a() {
        Iterator<ListenerHolder<?>> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.a.clear();
    }
}
