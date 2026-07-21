package cm.aptoide.pt.util;

/* JADX INFO: loaded from: classes.dex */
public class AptoideColorUtils {
    public static int getChangedColorLightness(float[] fArr, float f2) {
        float f3 = fArr[2] * f2;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        fArr[2] = f3;
        return c.i.e.a.a(fArr);
    }
}
