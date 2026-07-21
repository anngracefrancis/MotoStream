package io.sentry.transport;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/* JADX INFO: compiled from: ProxyAuthenticator.java */
/* JADX INFO: loaded from: classes2.dex */
final class w extends Authenticator {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f22748b;

    w(String str, String str2) {
        this.a = (String) io.sentry.util.q.c(str, "user is required");
        this.f22748b = (String) io.sentry.util.q.c(str2, "password is required");
    }

    @Override // java.net.Authenticator
    protected PasswordAuthentication getPasswordAuthentication() {
        if (getRequestorType() == Authenticator.RequestorType.PROXY) {
            return new PasswordAuthentication(this.a, this.f22748b.toCharArray());
        }
        return null;
    }
}
