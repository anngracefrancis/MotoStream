package io.sentry.protocol;

import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.w1;
import java.io.IOException;
import java.util.UUID;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: SentryId.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final q f22645f = new q(new UUID(0, 0));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final UUID f22646g;

    /* JADX INFO: compiled from: SentryId.java */
    public static final class a implements l2<q> {
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public q a(n2 n2Var, w1 w1Var) throws Exception {
            return new q(n2Var.J());
        }
    }

    public q() {
        this((UUID) null);
    }

    private UUID a(String str) {
        if (str.length() == 32) {
            str = new StringBuilder(str).insert(8, "-").insert(13, "-").insert(18, "-").insert(23, "-").toString();
        }
        if (str.length() == 36) {
            return UUID.fromString(str);
        }
        throw new IllegalArgumentException("String representation of SentryId has either 32 (UUID no dashes) or 36 characters long (completed UUID). Received: " + str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && q.class == obj.getClass() && this.f22646g.compareTo(((q) obj).f22646g) == 0;
    }

    public int hashCode() {
        return this.f22646g.hashCode();
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.b(toString());
    }

    public String toString() {
        return io.sentry.util.u.d(this.f22646g.toString()).replace("-", HttpUrl.FRAGMENT_ENCODE_SET);
    }

    public q(UUID uuid) {
        this.f22646g = uuid == null ? UUID.randomUUID() : uuid;
    }

    public q(String str) {
        this.f22646g = a(io.sentry.util.u.d(str));
    }
}
