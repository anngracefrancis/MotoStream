package io.sentry.android.core;

import io.sentry.s4;
import io.sentry.w1;
import io.sentry.x4;

/* JADX INFO: compiled from: LoadClass.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b1 {
    public boolean a(String str, w1 w1Var) {
        return c(str, w1Var) != null;
    }

    public boolean b(String str, x4 x4Var) {
        return a(str, x4Var != null ? x4Var.getLogger() : null);
    }

    public Class<?> c(String str, w1 w1Var) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            if (w1Var == null) {
                return null;
            }
            w1Var.b(s4.DEBUG, "Class not available:" + str, e2);
            return null;
        } catch (UnsatisfiedLinkError e3) {
            if (w1Var == null) {
                return null;
            }
            w1Var.b(s4.ERROR, "Failed to load (UnsatisfiedLinkError) " + str, e3);
            return null;
        } catch (Throwable th) {
            if (w1Var == null) {
                return null;
            }
            w1Var.b(s4.ERROR, "Failed to initialize " + str, th);
            return null;
        }
    }
}
