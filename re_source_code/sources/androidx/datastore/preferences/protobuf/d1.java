package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: RawMessageInfo.java */
/* JADX INFO: loaded from: classes.dex */
final class d1 implements o0 {
    private final q0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f1281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object[] f1282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f1283d;

    d1(q0 q0Var, String str, Object[] objArr) {
        this.a = q0Var;
        this.f1281b = str;
        this.f1282c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f1283d = cCharAt;
            return;
        }
        int i2 = cCharAt & 8191;
        int i3 = 13;
        int i4 = 1;
        while (true) {
            int i5 = i4 + 1;
            char cCharAt2 = str.charAt(i4);
            if (cCharAt2 < 55296) {
                this.f1283d = i2 | (cCharAt2 << i3);
                return;
            } else {
                i2 |= (cCharAt2 & 8191) << i3;
                i3 += 13;
                i4 = i5;
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.o0
    public boolean a() {
        return (this.f1283d & 2) == 2;
    }

    @Override // androidx.datastore.preferences.protobuf.o0
    public q0 b() {
        return this.a;
    }

    @Override // androidx.datastore.preferences.protobuf.o0
    public a1 c() {
        return (this.f1283d & 1) == 1 ? a1.PROTO2 : a1.PROTO3;
    }

    Object[] d() {
        return this.f1282c;
    }

    String e() {
        return this.f1281b;
    }
}
