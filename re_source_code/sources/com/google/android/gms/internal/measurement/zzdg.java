package com.google.android.gms.internal.measurement;

import java.io.PrintStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdg {
    private static final d1 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f17365b;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
    static final class a extends d1 {
        a() {
        }

        @Override // com.google.android.gms.internal.measurement.d1
        public final void a(Throwable th, Throwable th2) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001e A[Catch: all -> 0x002a, TryCatch #0 {all -> 0x002a, blocks: (B:5:0x0007, B:7:0x000f, B:8:0x0015, B:10:0x001e, B:11:0x0024), top: B:25:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:11:0x0024 A[Catch: all -> 0x002a, TRY_LEAVE, TryCatch #0 {all -> 0x002a, blocks: (B:5:0x0007, B:7:0x000f, B:8:0x0015, B:10:0x001e, B:11:0x0024), top: B:25:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x0015 A[Catch: all -> 0x002a, TryCatch #0 {all -> 0x002a, blocks: (B:5:0x0007, B:7:0x000f, B:8:0x0015, B:10:0x001e, B:11:0x0024), top: B:25:0x0007 }] */
    static {
        Integer numA;
        d1 aVar;
        try {
            numA = a();
            if (numA != null) {
                try {
                    if (numA.intValue() >= 19) {
                        aVar = new h1();
                    } else if (!Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic")) {
                        aVar = new g1();
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
                aVar = new g1();
            } else {
                aVar = new a();
            }
        } catch (Throwable th2) {
            th = th2;
            numA = null;
        }
        a = aVar;
        f17365b = numA != null ? numA.intValue() : 1;
    }

    private static Integer a() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e2) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e2.printStackTrace(System.err);
            return null;
        }
    }

    public static void b(Throwable th, Throwable th2) {
        a.a(th, th2);
    }
}
