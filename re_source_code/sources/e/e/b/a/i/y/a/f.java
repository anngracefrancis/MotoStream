package e.e.b.a.i.y.a;

/* JADX INFO: compiled from: TimeWindow.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f {
    private static final f a = new a().a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f20881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f20882c;

    /* JADX INFO: compiled from: TimeWindow.java */
    public static final class a {
        private long a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f20883b = 0;

        a() {
        }

        public f a() {
            return new f(this.a, this.f20883b);
        }

        public a b(long j2) {
            this.f20883b = j2;
            return this;
        }

        public a c(long j2) {
            this.a = j2;
            return this;
        }
    }

    f(long j2, long j3) {
        this.f20881b = j2;
        this.f20882c = j3;
    }

    public static a c() {
        return new a();
    }

    @com.google.firebase.encoders.i.f(tag = 2)
    public long a() {
        return this.f20882c;
    }

    @com.google.firebase.encoders.i.f(tag = 1)
    public long b() {
        return this.f20881b;
    }
}
