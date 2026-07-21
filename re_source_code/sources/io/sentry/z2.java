package io.sentry;

/* JADX INFO: compiled from: NoOpLogger.java */
/* JADX INFO: loaded from: classes2.dex */
public final class z2 implements w1 {
    private static final z2 a = new z2();

    private z2() {
    }

    public static z2 e() {
        return a;
    }

    @Override // io.sentry.w1
    public void a(s4 s4Var, Throwable th, String str, Object... objArr) {
    }

    @Override // io.sentry.w1
    public void b(s4 s4Var, String str, Throwable th) {
    }

    @Override // io.sentry.w1
    public void c(s4 s4Var, String str, Object... objArr) {
    }

    @Override // io.sentry.w1
    public boolean d(s4 s4Var) {
        return false;
    }
}
