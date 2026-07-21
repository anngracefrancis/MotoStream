package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class rw extends xw {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ ow f13288g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private rw(ow owVar) {
        super(owVar, null);
        this.f13288g = owVar;
    }

    @Override // com.google.android.gms.internal.ads.xw, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new qw(this.f13288g, null);
    }

    /* synthetic */ rw(ow owVar, pw pwVar) {
        this(owVar);
    }
}
