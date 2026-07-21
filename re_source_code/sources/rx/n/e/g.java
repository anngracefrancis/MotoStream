package rx.n.e;

/* JADX INFO: compiled from: PlatformDependent.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    private static final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f26743b;

    static {
        int iC = c();
        a = iC;
        f26743b = iC != 0;
    }

    public static int a() {
        return a;
    }

    public static boolean b() {
        return f26743b;
    }

    private static int c() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null)).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }
}
