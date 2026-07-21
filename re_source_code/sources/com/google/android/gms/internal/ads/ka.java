package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@zzard
final class ka {
    private final ArrayList<zzsa> a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f12858b;

    ka() {
    }

    final void a(zzsa zzsaVar) {
        this.a.add(zzsaVar);
    }

    final long b() {
        Iterator<zzsa> it = this.a.iterator();
        while (it.hasNext()) {
            Map<String, List<String>> mapB = it.next().b();
            if (mapB != null) {
                for (Map.Entry<String, List<String>> entry : mapB.entrySet()) {
                    try {
                        if ("content-length".equalsIgnoreCase(entry.getKey())) {
                            this.f12858b = Math.max(this.f12858b, Long.parseLong(entry.getValue().get(0)));
                        }
                    } catch (RuntimeException unused) {
                    }
                }
                it.remove();
            }
        }
        return this.f12858b;
    }
}
