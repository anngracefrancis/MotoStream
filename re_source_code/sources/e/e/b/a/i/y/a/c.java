package e.e.b.a.i.y.a;

/* JADX INFO: compiled from: LogEventDropped.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private static final c a = new a().a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f20866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f20867c;

    /* JADX INFO: compiled from: LogEventDropped.java */
    public static final class a {
        private long a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private b f20868b = b.REASON_UNKNOWN;

        a() {
        }

        public c a() {
            return new c(this.a, this.f20868b);
        }

        public a b(long j2) {
            this.a = j2;
            return this;
        }

        public a c(b bVar) {
            this.f20868b = bVar;
            return this;
        }
    }

    /* JADX INFO: compiled from: LogEventDropped.java */
    public enum b implements com.google.firebase.encoders.i.e {
        REASON_UNKNOWN(0),
        MESSAGE_TOO_OLD(1),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);

        private final int n;

        b(int i2) {
            this.n = i2;
        }

        @Override // com.google.firebase.encoders.i.e
        public int f() {
            return this.n;
        }
    }

    c(long j2, b bVar) {
        this.f20866b = j2;
        this.f20867c = bVar;
    }

    public static a c() {
        return new a();
    }

    @com.google.firebase.encoders.i.f(tag = 1)
    public long a() {
        return this.f20866b;
    }

    @com.google.firebase.encoders.i.f(tag = 3)
    public b b() {
        return this.f20867c;
    }
}
