package io.sentry.clientreport;

import io.sentry.util.q;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: ClientReportKey.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
final class c {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f22359b;

    c(String str, String str2) {
        this.a = str;
        this.f22359b = str2;
    }

    public String a() {
        return this.f22359b;
    }

    public String b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return q.a(b(), cVar.b()) && q.a(a(), cVar.a());
    }

    public int hashCode() {
        return q.b(b(), a());
    }
}
