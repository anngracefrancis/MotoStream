package com.airbnb.epoxy;

import java.util.List;

/* JADX INFO: compiled from: EpoxyAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class l extends d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final x f8439k = new x();
    protected final List<s<?>> l = new c0();

    @Override // com.airbnb.epoxy.d
    List<s<?>> j() {
        return this.l;
    }

    @Override // com.airbnb.epoxy.d
    s<?> k(int i2) {
        s<?> sVar = this.l.get(i2);
        return sVar.isShown() ? sVar : this.f8439k;
    }
}
