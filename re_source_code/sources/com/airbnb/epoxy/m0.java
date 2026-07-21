package com.airbnb.epoxy;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: ViewTypeManager.java */
/* JADX INFO: loaded from: classes.dex */
class m0 {
    private static final Map<Class, Integer> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private s<?> f8443b;

    m0() {
    }

    static int b(s<?> sVar) {
        int viewType = sVar.getViewType();
        if (viewType != 0) {
            return viewType;
        }
        Class<?> cls = sVar.getClass();
        Map<Class, Integer> map = a;
        Integer numValueOf = map.get(cls);
        if (numValueOf == null) {
            numValueOf = Integer.valueOf((-map.size()) - 1);
            map.put(cls, numValueOf);
        }
        return numValueOf.intValue();
    }

    s<?> a(d dVar, int i2) {
        s<?> sVar = this.f8443b;
        if (sVar != null && b(sVar) == i2) {
            return this.f8443b;
        }
        dVar.r(new IllegalStateException("Last model did not match expected view type"));
        for (s<?> sVar2 : dVar.j()) {
            if (b(sVar2) == i2) {
                return sVar2;
            }
        }
        x xVar = new x();
        if (i2 == xVar.getViewType()) {
            return xVar;
        }
        throw new IllegalStateException("Could not find model for view type: " + i2);
    }

    int c(s<?> sVar) {
        this.f8443b = sVar;
        return b(sVar);
    }
}
