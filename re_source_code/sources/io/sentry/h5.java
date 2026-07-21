package io.sentry;

import java.io.IOException;
import java.util.UUID;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: SpanId.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h5 implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final h5 f22423f = new h5(new UUID(0, 0));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f22424g;

    /* JADX INFO: compiled from: SpanId.java */
    public static final class a implements l2<h5> {
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public h5 a(n2 n2Var, w1 w1Var) throws Exception {
            return new h5(n2Var.J());
        }
    }

    public h5(String str) {
        this.f22424g = (String) io.sentry.util.q.c(str, "value is required");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h5.class != obj.getClass()) {
            return false;
        }
        return this.f22424g.equals(((h5) obj).f22424g);
    }

    public int hashCode() {
        return this.f22424g.hashCode();
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.b(this.f22424g);
    }

    public String toString() {
        return this.f22424g;
    }

    public h5() {
        this(UUID.randomUUID());
    }

    private h5(UUID uuid) {
        this(io.sentry.util.u.d(uuid.toString()).replace("-", HttpUrl.FRAGMENT_ENCODE_SET).substring(0, 16));
    }
}
