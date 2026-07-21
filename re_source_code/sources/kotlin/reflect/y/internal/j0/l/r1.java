package kotlin.reflect.y.internal.j0.l;

import okhttp3.HttpUrl;

/* JADX INFO: compiled from: Variance.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum r1 {
    INVARIANT(HttpUrl.FRAGMENT_ENCODE_SET, true, true, 0),
    IN_VARIANCE("in", true, false, -1),
    OUT_VARIANCE("out", false, true, 1);


    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f24781j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f24782k;
    private final boolean l;
    private final int m;

    r1(String str, boolean z, boolean z2, int i2) {
        this.f24781j = str;
        this.f24782k = z;
        this.l = z2;
        this.m = i2;
    }

    public final boolean k() {
        return this.l;
    }

    public final String q() {
        return this.f24781j;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f24781j;
    }
}
