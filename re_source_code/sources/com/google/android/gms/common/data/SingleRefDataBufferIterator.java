package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class SingleRefDataBufferIterator<T> extends DataBufferIterator<T> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private T f11922h;

    @Override // com.google.android.gms.common.data.DataBufferIterator, java.util.Iterator
    public T next() {
        if (!hasNext()) {
            int i2 = this.f11904g;
            StringBuilder sb = new StringBuilder(46);
            sb.append("Cannot advance the iterator beyond ");
            sb.append(i2);
            throw new NoSuchElementException(sb.toString());
        }
        int i3 = this.f11904g + 1;
        this.f11904g = i3;
        if (i3 == 0) {
            T t = this.f11903f.get(0);
            this.f11922h = t;
            if (!(t instanceof DataBufferRef)) {
                String strValueOf = String.valueOf(this.f11922h.getClass());
                StringBuilder sb2 = new StringBuilder(strValueOf.length() + 44);
                sb2.append("DataBuffer reference of type ");
                sb2.append(strValueOf);
                sb2.append(" is not movable");
                throw new IllegalStateException(sb2.toString());
            }
        } else {
            ((DataBufferRef) this.f11922h).a(i3);
        }
        return this.f11922h;
    }
}
