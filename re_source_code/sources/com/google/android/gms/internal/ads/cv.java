package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
final class cv extends yt<Float> implements zzdoj<Float>, fw, RandomAccess {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final cv f12438g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float[] f12439h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f12440i;

    static {
        cv cvVar = new cv(new float[0], 0);
        f12438g = cvVar;
        cvVar.x0();
    }

    cv() {
        this(new float[10], 0);
    }

    private final void f(int i2, float f2) {
        int i3;
        c();
        if (i2 < 0 || i2 > (i3 = this.f12440i)) {
            throw new IndexOutOfBoundsException(h(i2));
        }
        float[] fArr = this.f12439h;
        if (i3 < fArr.length) {
            System.arraycopy(fArr, i2, fArr, i2 + 1, i3 - i2);
        } else {
            float[] fArr2 = new float[((i3 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            System.arraycopy(this.f12439h, i2, fArr2, i2 + 1, this.f12440i - i2);
            this.f12439h = fArr2;
        }
        this.f12439h[i2] = f2;
        this.f12440i++;
        ((AbstractList) this).modCount++;
    }

    private final void g(int i2) {
        if (i2 < 0 || i2 >= this.f12440i) {
            throw new IndexOutOfBoundsException(h(i2));
        }
    }

    private final String h(int i2) {
        int i3 = this.f12440i;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzdoj
    public final /* synthetic */ zzdoj<Float> N(int i2) {
        if (i2 >= this.f12440i) {
            return new cv(Arrays.copyOf(this.f12439h, i2), this.f12440i);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        f(i2, ((Float) obj).floatValue());
    }

    @Override // com.google.android.gms.internal.ads.yt, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        c();
        zzdod.a(collection);
        if (!(collection instanceof cv)) {
            return super.addAll(collection);
        }
        cv cvVar = (cv) collection;
        int i2 = cvVar.f12440i;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f12440i;
        if (Integer.MAX_VALUE - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        float[] fArr = this.f12439h;
        if (i4 > fArr.length) {
            this.f12439h = Arrays.copyOf(fArr, i4);
        }
        System.arraycopy(cvVar.f12439h, 0, this.f12439h, this.f12440i, cvVar.f12440i);
        this.f12440i = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.yt, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cv)) {
            return super.equals(obj);
        }
        cv cvVar = (cv) obj;
        if (this.f12440i != cvVar.f12440i) {
            return false;
        }
        float[] fArr = cvVar.f12439h;
        for (int i2 = 0; i2 < this.f12440i; i2++) {
            if (Float.floatToIntBits(this.f12439h[i2]) != Float.floatToIntBits(fArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        g(i2);
        return Float.valueOf(this.f12439h[i2]);
    }

    @Override // com.google.android.gms.internal.ads.yt, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i2 = 0; i2 < this.f12440i; i2++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.f12439h[i2]);
        }
        return iFloatToIntBits;
    }

    public final void i(float f2) {
        f(this.f12440i, f2);
    }

    @Override // com.google.android.gms.internal.ads.yt, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f12440i; i2++) {
            if (obj.equals(Float.valueOf(this.f12439h[i2]))) {
                float[] fArr = this.f12439h;
                System.arraycopy(fArr, i2 + 1, fArr, i2, (this.f12440i - i2) - 1);
                this.f12440i--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i2, int i3) {
        c();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.f12439h;
        System.arraycopy(fArr, i3, fArr, i2, this.f12440i - i3);
        this.f12440i -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        c();
        g(i2);
        float[] fArr = this.f12439h;
        float f2 = fArr[i2];
        fArr[i2] = fFloatValue;
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f12440i;
    }

    private cv(float[] fArr, int i2) {
        this.f12439h = fArr;
        this.f12440i = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        c();
        g(i2);
        float[] fArr = this.f12439h;
        float f2 = fArr[i2];
        int i3 = this.f12440i;
        if (i2 < i3 - 1) {
            System.arraycopy(fArr, i2 + 1, fArr, i2, (i3 - i2) - 1);
        }
        this.f12440i--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f2);
    }
}
