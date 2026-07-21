package com.airbnb.epoxy;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DiffPayload.java */
/* JADX INFO: loaded from: classes.dex */
public class j {
    private final s<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c.e.d<s<?>> f8436b;

    j(List<? extends s<?>> list) {
        if (list.isEmpty()) {
            throw new IllegalStateException("Models must not be empty");
        }
        int size = list.size();
        if (size == 1) {
            this.a = list.get(0);
            this.f8436b = null;
            return;
        }
        this.a = null;
        this.f8436b = new c.e.d<>(size);
        for (s<?> sVar : list) {
            this.f8436b.k(sVar.id(), sVar);
        }
    }

    public static s<?> a(List<Object> list, long j2) {
        if (list.isEmpty()) {
            return null;
        }
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            j jVar = (j) it.next();
            s<?> sVar = jVar.a;
            if (sVar == null) {
                s<?> sVarG = jVar.f8436b.g(j2);
                if (sVarG != null) {
                    return sVarG;
                }
            } else if (sVar.id() == j2) {
                return jVar.a;
            }
        }
        return null;
    }

    public j(s<?> sVar) {
        this((List<? extends s<?>>) Collections.singletonList(sVar));
    }
}
