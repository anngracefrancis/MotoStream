package com.google.android.gms.measurement.internal;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class i implements Iterator<String> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Iterator<String> f17812f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzam f17813g;

    i(zzam zzamVar) {
        this.f17813g = zzamVar;
        this.f17812f = zzamVar.f18066f.keySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f17812f.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f17812f.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
