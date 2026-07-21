package k.b.f;

/* JADX INFO: compiled from: Util.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i {
    public static final void a(String str) {
        System.err.println("SLF4J: " + str);
    }

    public static final void b(String str, Throwable th) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th.printStackTrace();
    }

    public static boolean c(String str) {
        String strD = d(str);
        if (strD == null) {
            return false;
        }
        return strD.equalsIgnoreCase("true");
    }

    public static String d(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null input");
        }
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
