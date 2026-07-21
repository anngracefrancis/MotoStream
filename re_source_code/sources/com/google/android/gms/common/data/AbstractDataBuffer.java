package com.google.android.gms.common.data;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractDataBuffer<T> implements DataBuffer<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final DataHolder f11896f;

    @Override // com.google.android.gms.common.api.Releasable
    public void c() {
        DataHolder dataHolder = this.f11896f;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public abstract T get(int i2);

    @Override // com.google.android.gms.common.data.DataBuffer
    public int getCount() {
        DataHolder dataHolder = this.f11896f;
        if (dataHolder == null) {
            return 0;
        }
        return dataHolder.getCount();
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new DataBufferIterator(this);
    }
}
