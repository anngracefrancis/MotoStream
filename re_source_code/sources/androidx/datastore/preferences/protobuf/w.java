package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: FloatArrayList.java */
/* JADX INFO: loaded from: classes.dex */
final class w extends c<Float> implements a0.f, RandomAccess, z0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final w f1443g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float[] f1444h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f1445i;

    static {
        w wVar = new w(new float[0], 0);
        f1443g = wVar;
        wVar.B();
    }

    w() {
        this(new float[10], 0);
    }

    private void i(int i2, float f2) {
        int i3;
        c();
        if (i2 < 0 || i2 > (i3 = this.f1445i)) {
            throw new IndexOutOfBoundsException(r(i2));
        }
        float[] fArr = this.f1444h;
        if (i3 < fArr.length) {
            System.arraycopy(fArr, i2, fArr, i2 + 1, i3 - i2);
        } else {
            float[] fArr2 = new float[((i3 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            System.arraycopy(this.f1444h, i2, fArr2, i2 + 1, this.f1445i - i2);
            this.f1444h = fArr2;
        }
        this.f1444h[i2] = f2;
        this.f1445i++;
        ((AbstractList) this).modCount++;
    }

    private void n(int i2) {
        if (i2 < 0 || i2 >= this.f1445i) {
            throw new IndexOutOfBoundsException(r(i2));
        }
    }

    private String r(int i2) {
        return "Index:" + i2 + ", Size:" + this.f1445i;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Float> collection) {
        c();
        a0.a(collection);
        if (!(collection instanceof w)) {
            return super.addAll(collection);
        }
        w wVar = (w) collection;
        int i2 = wVar.f1445i;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f1445i;
        if (Integer.MAX_VALUE - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        float[] fArr = this.f1444h;
        if (i4 > fArr.length) {
            this.f1444h = Arrays.copyOf(fArr, i4);
        }
        System.arraycopy(wVar.f1444h, 0, this.f1444h, this.f1445i, wVar.f1445i);
        this.f1445i = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return super.equals(obj);
        }
        w wVar = (w) obj;
        if (this.f1445i != wVar.f1445i) {
            return false;
        }
        float[] fArr = wVar.f1444h;
        for (int i2 = 0; i2 < this.f1445i; i2++) {
            if (Float.floatToIntBits(this.f1444h[i2]) != Float.floatToIntBits(fArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void add(int i2, Float f2) {
        i(i2, f2.floatValue());
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public boolean add(Float f2) {
        h(f2.floatValue());
        return true;
    }

    public void h(float f2) {
        c();
        int i2 = this.f1445i;
        float[] fArr = this.f1444h;
        if (i2 == fArr.length) {
            float[] fArr2 = new float[((i2 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            this.f1444h = fArr2;
        }
        float[] fArr3 = this.f1444h;
        int i3 = this.f1445i;
        this.f1445i = i3 + 1;
        fArr3[i3] = f2;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iFloatToIntBits = 1;
        for (int i2 = 0; i2 < this.f1445i; i2++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.f1444h[i2]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Float get(int i2) {
        return Float.valueOf(q(i2));
    }

    public float q(int i2) {
        n(i2);
        return this.f1444h[i2];
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i2, int i3) {
        c();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.f1444h;
        System.arraycopy(fArr, i3, fArr, i2, this.f1445i - i3);
        this.f1445i -= i3 - i2;
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.a0.i
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public a0.f J(int i2) {
        if (i2 >= this.f1445i) {
            return new w(Arrays.copyOf(this.f1444h, i2), this.f1445i);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f1445i;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public Float remove(int i2) {
        c();
        n(i2);
        float[] fArr = this.f1444h;
        float f2 = fArr[i2];
        int i3 = this.f1445i;
        if (i2 < i3 - 1) {
            System.arraycopy(fArr, i2 + 1, fArr, i2, (i3 - i2) - 1);
        }
        this.f1445i--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Float set(int i2, Float f2) {
        return Float.valueOf(v(i2, f2.floatValue()));
    }

    public float v(int i2, float f2) {
        c();
        n(i2);
        float[] fArr = this.f1444h;
        float f3 = fArr[i2];
        fArr[i2] = f2;
        return f3;
    }

    private w(float[] fArr, int i2) {
        this.f1444h = fArr;
        this.f1445i = i2;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f1445i; i2++) {
            if (obj.equals(Float.valueOf(this.f1444h[i2]))) {
                float[] fArr = this.f1444h;
                System.arraycopy(fArr, i2 + 1, fArr, i2, (this.f1445i - i2) - 1);
                this.f1445i--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
