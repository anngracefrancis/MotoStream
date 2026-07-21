package androidx.work.impl.n;

/* JADX INFO: compiled from: Preference.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f2513b;

    public d(String str, boolean z) {
        this(str, z ? 1L : 0L);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!this.a.equals(dVar.a)) {
            return false;
        }
        Long l = this.f2513b;
        Long l2 = dVar.f2513b;
        if (l != null) {
            return l.equals(l2);
        }
        return l2 == null;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Long l = this.f2513b;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public d(String str, long j2) {
        this.a = str;
        this.f2513b = Long.valueOf(j2);
    }
}
