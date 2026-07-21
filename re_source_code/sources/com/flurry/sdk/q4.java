package com.flurry.sdk;

import android.util.Base64;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public final class q4 implements f7<l> {
    q4() {
    }

    @Override // com.flurry.sdk.f7
    public final /* synthetic */ void a(l lVar) {
        l lVar2 = lVar;
        boolean z = lVar2.f10893b;
        Map<m, String> mapA = lVar2.a();
        if (mapA == null || mapA.size() == 0) {
            d1.c(2, "ReportedIDFrame", "Reported ids is empty, do not send the frame.");
        } else {
            m2.a().b(new i6(new j6(mapA, z)));
        }
        Map<m, String> mapA2 = lVar2.a();
        HashMap map = new HashMap();
        for (Map.Entry<m, String> entry : mapA2.entrySet()) {
            if (entry.getKey().equals(m.AndroidInstallationId)) {
                map.put(entry.getKey().name(), c2.c(Base64.decode(entry.getValue(), 2)).toUpperCase(Locale.getDefault()));
            } else {
                map.put(entry.getKey().name(), entry.getValue());
            }
        }
        g0.a();
        g0.f("Reported Ids", map);
        d1.c(4, "IdObserver", "IdProvider" + lVar2.a());
    }
}
