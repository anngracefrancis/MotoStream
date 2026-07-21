package com.flurry.sdk;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class x4 implements f7<z> {
    @Override // com.flurry.sdk.f7
    public final /* synthetic */ void a(z zVar) {
        z zVar2 = zVar;
        String str = zVar2.a;
        String str2 = zVar2.f11153b;
        Map map = zVar2.f11154c;
        if (map == null) {
            map = new HashMap();
        }
        map.put("fl.origin.attribute.version", str2);
        if (map.size() > 10) {
            int size = map.size();
            d1.n("OriginAttributeFrame", "MaxOriginParams exceeded: ".concat(String.valueOf(size)));
            map.clear();
            map.put("fl.parameter.limit.exceeded", String.valueOf(size));
        }
        m2.a().b(new b6(new c6(str, map)));
        d1.c(4, "OriginAttributeObserver", "Origin attribute name: " + zVar2.a + ". Origin attribute version: " + zVar2.f11153b + ". Origin attribute params: " + zVar2.f11154c);
    }
}
