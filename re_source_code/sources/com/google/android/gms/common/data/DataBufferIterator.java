package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class DataBufferIterator<T> implements Iterator<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final DataBuffer<T> f11903f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected int f11904g = -1;

    public DataBufferIterator(DataBuffer<T> dataBuffer) {
        this.f11903f = (DataBuffer) Preconditions.k(dataBuffer);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f11904g < this.f11903f.getCount() - 1;
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            DataBuffer<T> dataBuffer = this.f11903f;
            int i2 = this.f11904g + 1;
            this.f11904g = i2;
            return dataBuffer.get(i2);
        }
        int i3 = this.f11904g;
        StringBuilder sb = new StringBuilder(46);
        sb.append("Cannot advance the iterator beyond ");
        sb.append(i3);
        throw new NoSuchElementException(sb.toString());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
