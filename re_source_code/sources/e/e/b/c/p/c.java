package e.e.b.c.p;

import android.os.Build;

/* JADX INFO: compiled from: CircularRevealHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static final int a;

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            a = 2;
        } else if (i2 >= 18) {
            a = 1;
        } else {
            a = 0;
        }
    }
}
