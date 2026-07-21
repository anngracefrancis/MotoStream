package androidx.work.impl.n;

/* JADX INFO: compiled from: SystemIdInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2515b;

    public g(String str, int i2) {
        this.a = str;
        this.f2515b = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f2515b != gVar.f2515b) {
            return false;
        }
        return this.a.equals(gVar.a);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.f2515b;
    }
}
