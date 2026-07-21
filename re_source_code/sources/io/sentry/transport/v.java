package io.sentry.transport;

/* JADX INFO: compiled from: NoOpTransportGate.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v implements s {
    private static final v a = new v();

    private v() {
    }

    public static v a() {
        return a;
    }

    @Override // io.sentry.transport.s
    public boolean isConnected() {
        return true;
    }
}
