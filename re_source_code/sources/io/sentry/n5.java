package io.sentry;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: compiled from: SystemOutLogger.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n5 implements w1 {
    private String e(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    @Override // io.sentry.w1
    public void a(s4 s4Var, Throwable th, String str, Object... objArr) {
        if (th == null) {
            c(s4Var, str, objArr);
        } else {
            System.out.println(String.format("%s: %s \n %s\n%s", s4Var, String.format(str, objArr), th.toString(), e(th)));
        }
    }

    @Override // io.sentry.w1
    public void b(s4 s4Var, String str, Throwable th) {
        if (th == null) {
            c(s4Var, str, new Object[0]);
        } else {
            System.out.println(String.format("%s: %s\n%s", s4Var, String.format(str, th.toString()), e(th)));
        }
    }

    @Override // io.sentry.w1
    public void c(s4 s4Var, String str, Object... objArr) {
        System.out.println(String.format("%s: %s", s4Var, String.format(str, objArr)));
    }

    @Override // io.sentry.w1
    public boolean d(s4 s4Var) {
        return true;
    }
}
