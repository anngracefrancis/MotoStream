package com.google.android.gms.internal.ads;

import java.io.PrintStream;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdmb {
    private static final tt a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f15979b;

    static final class a extends tt {
        a() {
        }

        @Override // com.google.android.gms.internal.ads.tt
        public final void a(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
        }

        @Override // com.google.android.gms.internal.ads.tt
        public final void b(Throwable th, Throwable th2) {
        }

        @Override // com.google.android.gms.internal.ads.tt
        public final void c(Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001e A[Catch: all -> 0x002a, TryCatch #0 {all -> 0x002a, blocks: (B:5:0x0007, B:7:0x000f, B:8:0x0015, B:10:0x001e, B:11:0x0024), top: B:25:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:11:0x0024 A[Catch: all -> 0x002a, TRY_LEAVE, TryCatch #0 {all -> 0x002a, blocks: (B:5:0x0007, B:7:0x000f, B:8:0x0015, B:10:0x001e, B:11:0x0024), top: B:25:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x0015 A[Catch: all -> 0x002a, TryCatch #0 {all -> 0x002a, blocks: (B:5:0x0007, B:7:0x000f, B:8:0x0015, B:10:0x001e, B:11:0x0024), top: B:25:0x0007 }] */
    static {
        Integer numC;
        tt aVar;
        try {
            numC = c();
            if (numC != null) {
                try {
                    if (numC.intValue() >= 19) {
                        aVar = new xt();
                    } else if (!Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic")) {
                        aVar = new wt();
                    } else {
                        aVar = new a();
                    }
                } catch (Throwable th) {
                    th = th;
                    PrintStream printStream = System.err;
                    String name = a.class.getName();
                    StringBuilder sb = new StringBuilder(name.length() + 133);
                    sb.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
                    sb.append(name);
                    sb.append("will be used. The error is: ");
                    printStream.println(sb.toString());
                    th.printStackTrace(System.err);
                    aVar = new a();
                }
            } else if (!Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic")) {
                aVar = new wt();
            } else {
                aVar = new a();
            }
        } catch (Throwable th2) {
            th = th2;
            numC = null;
        }
        a = aVar;
        f15979b = numC != null ? numC.intValue() : 1;
    }

    public static void a(Throwable th, PrintWriter printWriter) {
        a.a(th, printWriter);
    }

    public static void b(Throwable th, Throwable th2) {
        a.b(th, th2);
    }

    private static Integer c() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e2) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e2.printStackTrace(System.err);
            return null;
        }
    }

    public static void d(Throwable th) {
        a.c(th);
    }
}
