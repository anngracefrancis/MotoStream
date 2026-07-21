package io.sentry;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: SentryIntegrationPackageStorage.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class q4 {
    private static volatile q4 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<String> f22681b = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<io.sentry.protocol.r> f22682c = new CopyOnWriteArraySet();

    private q4() {
    }

    public static q4 c() {
        if (a == null) {
            synchronized (q4.class) {
                if (a == null) {
                    a = new q4();
                }
            }
        }
        return a;
    }

    public void a(String str) {
        io.sentry.util.q.c(str, "integration is required.");
        this.f22681b.add(str);
    }

    public void b(String str, String str2) {
        io.sentry.util.q.c(str, "name is required.");
        io.sentry.util.q.c(str2, "version is required.");
        this.f22682c.add(new io.sentry.protocol.r(str, str2));
    }

    public Set<String> d() {
        return this.f22681b;
    }

    public Set<io.sentry.protocol.r> e() {
        return this.f22682c;
    }
}
