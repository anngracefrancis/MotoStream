package com.flurry.sdk;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class h3 implements f3 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected static final Set<String> f10809k = new HashSet();

    @Override // com.flurry.sdk.f3
    public final void a() {
        f10809k.clear();
    }

    @Override // com.flurry.sdk.f3
    public final f3.a b(u6 u6Var) {
        if (!u6Var.a().equals(s6.SESSION_PROPERTIES_PARAMS)) {
            return f3.a;
        }
        String str = ((h4) u6Var.f()).f10810b;
        Set<String> set = f10809k;
        if (set.size() < 10 || set.contains(str)) {
            set.add(str);
            return f3.a;
        }
        d1.o("SessionPropertiesParamsDropRule", "MaxSessionPropertiesParams exceeded: 10");
        return f3.f10750j;
    }
}
