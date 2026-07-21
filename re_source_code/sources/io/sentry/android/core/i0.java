package io.sentry.android.core;

import android.util.Log;
import io.sentry.s4;
import io.sentry.w1;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: AndroidLogger.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class i0 implements w1 {
    private final String a;

    /* JADX INFO: compiled from: AndroidLogger.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[s4.values().length];
            a = iArr;
            try {
                iArr[s4.INFO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[s4.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[s4.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[s4.FATAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[s4.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public i0() {
        this("Sentry");
    }

    private int e(s4 s4Var) {
        int i2 = a.a[s4Var.ordinal()];
        if (i2 == 1) {
            return 4;
        }
        if (i2 != 2) {
            return i2 != 4 ? 3 : 7;
        }
        return 5;
    }

    @Override // io.sentry.w1
    public void a(s4 s4Var, Throwable th, String str, Object... objArr) {
        b(s4Var, String.format(str, objArr), th);
    }

    @Override // io.sentry.w1
    public void b(s4 s4Var, String str, Throwable th) {
        int i2 = a.a[s4Var.ordinal()];
        if (i2 == 1) {
            Log.i(this.a, str, th);
            return;
        }
        if (i2 == 2) {
            Log.w(this.a, str, th);
            return;
        }
        if (i2 == 3) {
            Log.e(this.a, str, th);
        } else if (i2 != 4) {
            Log.d(this.a, str, th);
        } else {
            Log.wtf(this.a, str, th);
        }
    }

    @Override // io.sentry.w1
    public void c(s4 s4Var, String str, Object... objArr) {
        Log.println(e(s4Var), this.a, String.format(str, objArr));
    }

    @Override // io.sentry.w1
    public boolean d(s4 s4Var) {
        return true;
    }

    public i0(String str) {
        this.a = str;
    }
}
