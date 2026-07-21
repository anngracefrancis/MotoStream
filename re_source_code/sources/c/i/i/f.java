package c.i.i;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: TextUtilsCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    private static final Locale a = new Locale(HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET);

    private static int a(Locale locale) {
        byte directionality = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
        return (directionality == 1 || directionality == 2) ? 1 : 0;
    }

    public static int b(Locale locale) {
        if (Build.VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
        if (locale == null || locale.equals(a)) {
            return 0;
        }
        String strC = b.c(locale);
        if (strC == null) {
            return a(locale);
        }
        return (strC.equalsIgnoreCase("Arab") || strC.equalsIgnoreCase("Hebr")) ? 1 : 0;
    }
}
