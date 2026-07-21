package androidx.work;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: WorkInfo.java */
/* JADX INFO: loaded from: classes.dex */
public final class x {
    private UUID a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f2667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private e f2668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Set<String> f2669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private e f2670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2671f;

    /* JADX INFO: compiled from: WorkInfo.java */
    public enum a {
        ENQUEUED,
        RUNNING,
        SUCCEEDED,
        FAILED,
        BLOCKED,
        CANCELLED;

        public boolean g() {
            return this == SUCCEEDED || this == FAILED || this == CANCELLED;
        }
    }

    public x(UUID uuid, a aVar, e eVar, List<String> list, e eVar2, int i2) {
        this.a = uuid;
        this.f2667b = aVar;
        this.f2668c = eVar;
        this.f2669d = new HashSet(list);
        this.f2670e = eVar2;
        this.f2671f = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || x.class != obj.getClass()) {
            return false;
        }
        x xVar = (x) obj;
        if (this.f2671f == xVar.f2671f && this.a.equals(xVar.a) && this.f2667b == xVar.f2667b && this.f2668c.equals(xVar.f2668c) && this.f2669d.equals(xVar.f2669d)) {
            return this.f2670e.equals(xVar.f2670e);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.f2667b.hashCode()) * 31) + this.f2668c.hashCode()) * 31) + this.f2669d.hashCode()) * 31) + this.f2670e.hashCode()) * 31) + this.f2671f;
    }

    public String toString() {
        return "WorkInfo{mId='" + this.a + "', mState=" + this.f2667b + ", mOutputData=" + this.f2668c + ", mTags=" + this.f2669d + ", mProgress=" + this.f2670e + '}';
    }
}
