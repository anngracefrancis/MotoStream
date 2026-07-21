package rx.n.e.o;

/* JADX INFO: compiled from: Pow2.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public static boolean a(int i2) {
        return (i2 & (i2 + (-1))) == 0;
    }

    public static int b(int i2) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i2 - 1));
    }
}
