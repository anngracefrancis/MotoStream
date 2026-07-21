package e.e.b.a.i;

import java.util.Arrays;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AutoValue_TransportContext.java */
/* JADX INFO: loaded from: classes2.dex */
final class e extends q {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f20828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e.e.b.a.d f20829c;

    /* JADX INFO: compiled from: AutoValue_TransportContext.java */
    static final class b extends q.a {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private byte[] f20830b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private e.e.b.a.d f20831c;

        b() {
        }

        @Override // e.e.b.a.i.q.a
        public q a() {
            String str = this.a;
            String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
            if (str == null) {
                str2 = HttpUrl.FRAGMENT_ENCODE_SET + " backendName";
            }
            if (this.f20831c == null) {
                str2 = str2 + " priority";
            }
            if (str2.isEmpty()) {
                return new e(this.a, this.f20830b, this.f20831c);
            }
            throw new IllegalStateException("Missing required properties:" + str2);
        }

        @Override // e.e.b.a.i.q.a
        public q.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null backendName");
            }
            this.a = str;
            return this;
        }

        @Override // e.e.b.a.i.q.a
        public q.a c(byte[] bArr) {
            this.f20830b = bArr;
            return this;
        }

        @Override // e.e.b.a.i.q.a
        public q.a d(e.e.b.a.d dVar) {
            if (dVar == null) {
                throw new NullPointerException("Null priority");
            }
            this.f20831c = dVar;
            return this;
        }
    }

    @Override // e.e.b.a.i.q
    public String b() {
        return this.a;
    }

    @Override // e.e.b.a.i.q
    public byte[] c() {
        return this.f20828b;
    }

    @Override // e.e.b.a.i.q
    public e.e.b.a.d d() {
        return this.f20829c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (this.a.equals(qVar.b())) {
            if (Arrays.equals(this.f20828b, qVar instanceof e ? ((e) qVar).f20828b : qVar.c()) && this.f20829c.equals(qVar.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f20828b)) * 1000003) ^ this.f20829c.hashCode();
    }

    private e(String str, byte[] bArr, e.e.b.a.d dVar) {
        this.a = str;
        this.f20828b = bArr;
        this.f20829c = dVar;
    }
}
