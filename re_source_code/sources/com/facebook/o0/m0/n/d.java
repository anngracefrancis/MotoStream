package com.facebook.o0.m0.n;

import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import kotlin.text.Regex;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: SensitiveUserDataUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final d a = new d();

    private d() {
    }

    private final boolean a(TextView textView) {
        int i2;
        f fVar = f.a;
        String strC = new Regex("\\s").c(f.k(textView), HttpUrl.FRAGMENT_ENCODE_SET);
        int length = strC.length();
        if (length < 12 || length > 19) {
            return false;
        }
        int i3 = length - 1;
        if (i3 >= 0) {
            boolean z = false;
            i2 = 0;
            while (true) {
                int i4 = i3 - 1;
                char cCharAt = strC.charAt(i3);
                if (!Character.isDigit(cCharAt)) {
                    return false;
                }
                int iD = kotlin.text.c.d(cCharAt);
                if (z && (iD = iD * 2) > 9) {
                    iD = (iD % 10) + 1;
                }
                i2 += iD;
                z = !z;
                if (i4 < 0) {
                    break;
                }
                i3 = i4;
            }
        } else {
            i2 = 0;
        }
        return i2 % 10 == 0;
    }

    private final boolean b(TextView textView) {
        if (textView.getInputType() == 32) {
            return true;
        }
        f fVar = f.a;
        String strK = f.k(textView);
        if (strK == null) {
            return false;
        }
        if (strK.length() == 0) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(strK).matches();
    }

    private final boolean c(TextView textView) {
        if (textView.getInputType() == 128) {
            return true;
        }
        return textView.getTransformationMethod() instanceof PasswordTransformationMethod;
    }

    private final boolean d(TextView textView) {
        return textView.getInputType() == 96;
    }

    private final boolean e(TextView textView) {
        return textView.getInputType() == 3;
    }

    private final boolean f(TextView textView) {
        return textView.getInputType() == 112;
    }

    public static final boolean g(View view) {
        if (!(view instanceof TextView)) {
            return false;
        }
        d dVar = a;
        TextView textView = (TextView) view;
        return dVar.c(textView) || dVar.a(textView) || dVar.d(textView) || dVar.f(textView) || dVar.e(textView) || dVar.b(textView);
    }
}
