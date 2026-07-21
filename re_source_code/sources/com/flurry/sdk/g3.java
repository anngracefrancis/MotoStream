package com.flurry.sdk;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class g3 implements f3 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Set<String> f10783k = new HashSet();

    @Override // com.flurry.sdk.f3
    public final void a() {
    }

    @Override // com.flurry.sdk.f3
    public final f3.a b(u6 u6Var) {
        if (!u6Var.a().equals(s6.ORIGIN_ATTRIBUTE)) {
            return f3.a;
        }
        String str = ((c6) u6Var.f()).f10676b;
        Set<String> set = f10783k;
        if (set.size() < 10 || set.contains(str)) {
            set.add(str);
            return f3.a;
        }
        d1.o("OriginAttributeDropRule", "MaxOrigins exceeded: " + set.size());
        return f3.f10749i;
    }
}
