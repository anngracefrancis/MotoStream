package androidx.appcompat.widget;

/* JADX INFO: compiled from: RtlSpacingHelper.java */
/* JADX INFO: loaded from: classes.dex */
class i0 {
    private int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f541b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f542c = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f543d = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f544e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f545f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f546g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f547h = false;

    i0() {
    }

    public int a() {
        return this.f546g ? this.a : this.f541b;
    }

    public int b() {
        return this.a;
    }

    public int c() {
        return this.f541b;
    }

    public int d() {
        return this.f546g ? this.f541b : this.a;
    }

    public void e(int i2, int i3) {
        this.f547h = false;
        if (i2 != Integer.MIN_VALUE) {
            this.f544e = i2;
            this.a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f545f = i3;
            this.f541b = i3;
        }
    }

    public void f(boolean z) {
        if (z == this.f546g) {
            return;
        }
        this.f546g = z;
        if (!this.f547h) {
            this.a = this.f544e;
            this.f541b = this.f545f;
            return;
        }
        if (z) {
            int i2 = this.f543d;
            if (i2 == Integer.MIN_VALUE) {
                i2 = this.f544e;
            }
            this.a = i2;
            int i3 = this.f542c;
            if (i3 == Integer.MIN_VALUE) {
                i3 = this.f545f;
            }
            this.f541b = i3;
            return;
        }
        int i4 = this.f542c;
        if (i4 == Integer.MIN_VALUE) {
            i4 = this.f544e;
        }
        this.a = i4;
        int i5 = this.f543d;
        if (i5 == Integer.MIN_VALUE) {
            i5 = this.f545f;
        }
        this.f541b = i5;
    }

    public void g(int i2, int i3) {
        this.f542c = i2;
        this.f543d = i3;
        this.f547h = true;
        if (this.f546g) {
            if (i3 != Integer.MIN_VALUE) {
                this.a = i3;
            }
            if (i2 != Integer.MIN_VALUE) {
                this.f541b = i2;
                return;
            }
            return;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f541b = i3;
        }
    }
}
