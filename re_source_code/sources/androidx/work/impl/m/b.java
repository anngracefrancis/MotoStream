package androidx.work.impl.m;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: NetworkState.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2482d;

    public b(boolean z, boolean z2, boolean z3, boolean z4) {
        this.a = z;
        this.f2480b = z2;
        this.f2481c = z3;
        this.f2482d = z4;
    }

    public boolean a() {
        return this.a;
    }

    public boolean b() {
        return this.f2481c;
    }

    public boolean c() {
        return this.f2482d;
    }

    public boolean d() {
        return this.f2480b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && this.f2480b == bVar.f2480b && this.f2481c == bVar.f2481c && this.f2482d == bVar.f2482d;
    }

    public int hashCode() {
        int i2 = this.a ? 1 : 0;
        if (this.f2480b) {
            i2 += 16;
        }
        if (this.f2481c) {
            i2 += 256;
        }
        return this.f2482d ? i2 + RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT : i2;
    }

    public String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", Boolean.valueOf(this.a), Boolean.valueOf(this.f2480b), Boolean.valueOf(this.f2481c), Boolean.valueOf(this.f2482d));
    }
}
