package com.google.android.gms.internal.common;

import java.util.NoSuchElementException;
import org.jspecify.nullness.NullMarked;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes.dex */
@NullMarked
abstract class g extends zzak {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f17069f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f17070g;

    protected g(int i2, int i3) {
        zzs.b(i3, i2, "index");
        this.f17069f = i2;
        this.f17070g = i3;
    }

    protected abstract Object b(int i2);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f17070g < this.f17069f;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f17070g > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f17070g;
        this.f17070g = i2 + 1;
        return b(i2);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f17070g;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f17070g - 1;
        this.f17070g = i2;
        return b(i2);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f17070g - 1;
    }
}
