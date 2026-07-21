package androidx.recyclerview.widget;

/* JADX INFO: compiled from: BatchingListUpdateCallback.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements l {
    final l a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f2009b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f2010c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f2011d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Object f2012e = null;

    public c(l lVar) {
        this.a = lVar;
    }

    @Override // androidx.recyclerview.widget.l
    public void a(int i2, int i3) {
        e();
        this.a.a(i2, i3);
    }

    @Override // androidx.recyclerview.widget.l
    public void b(int i2, int i3) {
        int i4;
        if (this.f2009b == 1 && i2 >= (i4 = this.f2010c)) {
            int i5 = this.f2011d;
            if (i2 <= i4 + i5) {
                this.f2011d = i5 + i3;
                this.f2010c = Math.min(i2, i4);
                return;
            }
        }
        e();
        this.f2010c = i2;
        this.f2011d = i3;
        this.f2009b = 1;
    }

    @Override // androidx.recyclerview.widget.l
    public void c(int i2, int i3) {
        int i4;
        if (this.f2009b == 2 && (i4 = this.f2010c) >= i2 && i4 <= i2 + i3) {
            this.f2011d += i3;
            this.f2010c = i2;
        } else {
            e();
            this.f2010c = i2;
            this.f2011d = i3;
            this.f2009b = 2;
        }
    }

    @Override // androidx.recyclerview.widget.l
    public void d(int i2, int i3, Object obj) {
        int i4;
        if (this.f2009b == 3) {
            int i5 = this.f2010c;
            int i6 = this.f2011d;
            if (i2 <= i5 + i6 && (i4 = i2 + i3) >= i5 && this.f2012e == obj) {
                this.f2010c = Math.min(i2, i5);
                this.f2011d = Math.max(i6 + i5, i4) - this.f2010c;
                return;
            }
        }
        e();
        this.f2010c = i2;
        this.f2011d = i3;
        this.f2012e = obj;
        this.f2009b = 3;
    }

    public void e() {
        int i2 = this.f2009b;
        if (i2 == 0) {
            return;
        }
        if (i2 == 1) {
            this.a.b(this.f2010c, this.f2011d);
        } else if (i2 == 2) {
            this.a.c(this.f2010c, this.f2011d);
        } else if (i2 == 3) {
            this.a.d(this.f2010c, this.f2011d, this.f2012e);
        }
        this.f2012e = null;
        this.f2009b = 0;
    }
}
