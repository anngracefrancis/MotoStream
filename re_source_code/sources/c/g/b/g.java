package c.g.b;

/* JADX INFO: compiled from: Pools.java */
/* JADX INFO: loaded from: classes.dex */
class g<T> implements f<T> {
    private final Object[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3007b;

    g(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.a = new Object[i2];
    }

    @Override // c.g.b.f
    public boolean a(T t) {
        int i2 = this.f3007b;
        Object[] objArr = this.a;
        if (i2 >= objArr.length) {
            return false;
        }
        objArr[i2] = t;
        this.f3007b = i2 + 1;
        return true;
    }

    @Override // c.g.b.f
    public T b() {
        int i2 = this.f3007b;
        if (i2 <= 0) {
            return null;
        }
        int i3 = i2 - 1;
        Object[] objArr = this.a;
        T t = (T) objArr[i3];
        objArr[i3] = null;
        this.f3007b = i2 - 1;
        return t;
    }

    @Override // c.g.b.f
    public void c(T[] tArr, int i2) {
        if (i2 > tArr.length) {
            i2 = tArr.length;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            T t = tArr[i3];
            int i4 = this.f3007b;
            Object[] objArr = this.a;
            if (i4 < objArr.length) {
                objArr[i4] = t;
                this.f3007b = i4 + 1;
            }
        }
    }
}
