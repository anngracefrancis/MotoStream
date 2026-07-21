package io.sentry.transport;

import java.net.Authenticator;

/* JADX INFO: compiled from: AuthenticatorWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
final class n {
    private static final n a = new n();

    private n() {
    }

    public static n a() {
        return a;
    }

    public void b(Authenticator authenticator) {
        Authenticator.setDefault(authenticator);
    }
}
