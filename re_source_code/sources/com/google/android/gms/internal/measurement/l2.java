package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class l2 extends i1<Float> implements zzfl<Float>, m3, RandomAccess {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final l2 f17209g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float[] f17210h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f17211i;

    static {
        l2 l2Var = new l2(new float[0], 0);
        f17209g = l2Var;
        l2Var.I();
    }

    l2() {
        this(new float[10], 0);
    }

    private final void g(int i2) {
        if (i2 < 0 || i2 >= this.f17211i) {
            throw new IndexOutOfBoundsException(h(i2));
        }
    }

    private final String h(int i2) {
        int i3 = this.f17211i;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        float fFloatValue = ((Float) obj).floatValue();
        c();
        if (i2 < 0 || i2 > (i3 = this.f17211i)) {
            throw new IndexOutOfBoundsException(h(i2));
        }
        float[] fArr = this.f17210h;
        if (i3 < fArr.length) {
            System.arraycopy(fArr, i2, fArr, i2 + 1, i3 - i2);
        } else {
            float[] fArr2 = new float[((i3 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            System.arraycopy(this.f17210h, i2, fArr2, i2 + 1, this.f17211i - i2);
            this.f17210h = fArr2;
        }
        this.f17210h[i2] = fFloatValue;
        this.f17211i++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        c();
        zzff.d(collection);
        if (!(collection instanceof l2)) {
            return super.addAll(collection);
        }
        l2 l2Var = (l2) collection;
        int i2 = l2Var.f17211i;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f17211i;
        if (Integer.MAX_VALUE - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        float[] fArr = this.f17210h;
        if (i4 > fArr.length) {
            this.f17210h = Arrays.copyOf(fArr, i4);
        }
        System.arraycopy(l2Var.f17210h, 0, this.f17210h, this.f17211i, l2Var.f17211i);
        this.f17211i = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzfl
    public final /* synthetic */ zzfl<Float> d(int i2) {
        if (i2 >= this.f17211i) {
            return new l2(Arrays.copyOf(this.f17210h, i2), this.f17211i);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l2)) {
            return super.equals(obj);
        }
        l2 l2Var = (l2) obj;
        if (this.f17211i != l2Var.f17211i) {
            return false;
        }
        float[] fArr = l2Var.f17210h;
        for (int i2 = 0; i2 < this.f17211i; i2++) {
            if (Float.floatToIntBits(this.f17210h[i2]) != Float.floatToIntBits(fArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public final void f(float f2) {
        c();
        int i2 = this.f17211i;
        float[] fArr = this.f17210h;
        if (i2 == fArr.length) {
            float[] fArr2 = new float[((i2 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            this.f17210h = fArr2;
        }
        float[] fArr3 = this.f17210h;
        int i3 = this.f17211i;
        this.f17211i = i3 + 1;
        fArr3[i3] = f2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        g(i2);
        return Float.valueOf(this.f17210h[i2]);
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i2 = 0; i2 < this.f17211i; i2++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.f17210h[i2]);
        }
        return iFloatToIntBits;
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f17211i; i2++) {
            if (obj.equals(Float.valueOf(this.f17210h[i2]))) {
                float[] fArr = this.f17210h;
                System.arraycopy(fArr, i2 + 1, fArr, i2, (this.f17211i - i2) - 1);
                this.f17211i--;
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
        float[] fArr = this.f17210h;
        System.arraycopy(fArr, i3, fArr, i2, this.f17211i - i3);
        this.f17211i -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        c();
        g(i2);
        float[] fArr = this.f17210h;
        float f2 = fArr[i2];
        fArr[i2] = fFloatValue;
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f17211i;
    }

    private l2(float[] fArr, int i2) {
        this.f17210h = fArr;
        this.f17211i = i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        c();
        g(i2);
        float[] fArr = this.f17210h;
        float f2 = fArr[i2];
        int i3 = this.f17211i;
        if (i2 < i3 - 1) {
            System.arraycopy(fArr, i2 + 1, fArr, i2, (i3 - i2) - 1);
        }
        this.f17211i--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f2);
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        f(((Float) obj).floatValue());
        return true;
    }
}
