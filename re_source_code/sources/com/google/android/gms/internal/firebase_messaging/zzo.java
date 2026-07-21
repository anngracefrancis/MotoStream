package com.google.android.gms.internal.firebase_messaging;

import java.io.PrintStream;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzo {
    static final e a;

    static {
        e iVar;
        Integer num = null;
        try {
            try {
                num = (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Exception e2) {
                System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
                e2.printStackTrace(System.err);
            }
            if (num == null || num.intValue() < 19) {
                iVar = !Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ? new h() : new i();
            } else {
                iVar = new j();
            }
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            String name = i.class.getName();
            StringBuilder sb = new StringBuilder(name.length() + 133);
            sb.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
            sb.append(name);
            sb.append("will be used. The error is: ");
            printStream.println(sb.toString());
            th.printStackTrace(System.err);
            iVar = new i();
        }
        a = iVar;
        if (num == null) {
            return;
        }
        num.intValue();
    }

    public static void a(Throwable th, Throwable th2) {
        a.a(th, th2);
    }
}
