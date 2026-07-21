package c.i.j;

import java.io.PrintWriter;

/* JADX INFO: compiled from: TimeUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    private static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static char[] f3284b = new char[24];

    private static int a(int i2, int i3, boolean z, int i4) {
        if (i2 > 99 || (z && i4 >= 3)) {
            return i3 + 3;
        }
        if (i2 > 9 || (z && i4 >= 2)) {
            return i3 + 2;
        }
        if (z || i2 > 0) {
            return i3 + 1;
        }
        return 0;
    }

    public static void b(long j2, long j3, PrintWriter printWriter) {
        if (j2 == 0) {
            printWriter.print("--");
        } else {
            d(j2 - j3, printWriter, 0);
        }
    }

    public static void c(long j2, PrintWriter printWriter) {
        d(j2, printWriter, 0);
    }

    public static void d(long j2, PrintWriter printWriter, int i2) {
        synchronized (a) {
            printWriter.print(new String(f3284b, 0, e(j2, i2)));
        }
    }

    private static int e(long j2, int i2) {
        char c2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        long j3 = j2;
        if (f3284b.length < i2) {
            f3284b = new char[i2];
        }
        char[] cArr = f3284b;
        if (j3 == 0) {
            int i8 = i2 - 1;
            while (i8 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (j3 > 0) {
            c2 = '+';
        } else {
            c2 = '-';
            j3 = -j3;
        }
        int i9 = (int) (j3 % 1000);
        int iFloor = (int) Math.floor(j3 / 1000);
        if (iFloor > 86400) {
            i3 = iFloor / 86400;
            iFloor -= 86400 * i3;
        } else {
            i3 = 0;
        }
        if (iFloor > 3600) {
            i4 = iFloor / 3600;
            iFloor -= i4 * 3600;
        } else {
            i4 = 0;
        }
        if (iFloor > 60) {
            int i10 = iFloor / 60;
            i5 = iFloor - (i10 * 60);
            i6 = i10;
        } else {
            i5 = iFloor;
            i6 = 0;
        }
        if (i2 != 0) {
            int iA = a(i3, 1, false, 0);
            int iA2 = iA + a(i4, 1, iA > 0, 2);
            int iA3 = iA2 + a(i6, 1, iA2 > 0, 2);
            int iA4 = iA3 + a(i5, 1, iA3 > 0, 2);
            i7 = 0;
            for (int iA5 = iA4 + a(i9, 2, true, iA4 > 0 ? 3 : 0) + 1; iA5 < i2; iA5++) {
                cArr[i7] = ' ';
                i7++;
            }
        } else {
            i7 = 0;
        }
        cArr[i7] = c2;
        int i11 = i7 + 1;
        boolean z = i2 != 0;
        int iF = f(cArr, i3, 'd', i11, false, 0);
        int iF2 = f(cArr, i4, 'h', iF, iF != i11, z ? 2 : 0);
        int iF3 = f(cArr, i6, 'm', iF2, iF2 != i11, z ? 2 : 0);
        int iF4 = f(cArr, i5, 's', iF3, iF3 != i11, z ? 2 : 0);
        int iF5 = f(cArr, i9, 'm', iF4, true, (!z || iF4 == i11) ? 0 : 3);
        cArr[iF5] = 's';
        return iF5 + 1;
    }

    private static int f(char[] cArr, int i2, char c2, int i3, boolean z, int i4) {
        int i5;
        if (!z && i2 <= 0) {
            return i3;
        }
        if ((!z || i4 < 3) && i2 <= 99) {
            i5 = i3;
        } else {
            int i6 = i2 / 100;
            cArr[i3] = (char) (i6 + 48);
            i5 = i3 + 1;
            i2 -= i6 * 100;
        }
        if ((z && i4 >= 2) || i2 > 9 || i3 != i5) {
            int i7 = i2 / 10;
            cArr[i5] = (char) (i7 + 48);
            i5++;
            i2 -= i7 * 10;
        }
        cArr[i5] = (char) (i2 + 48);
        int i8 = i5 + 1;
        cArr[i8] = c2;
        return i8 + 1;
    }
}
