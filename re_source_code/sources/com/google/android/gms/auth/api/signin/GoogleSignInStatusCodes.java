package com.google.android.gms.auth.api.signin;

import cm.aptoide.pt.account.AccountAnalytics;
import com.google.android.gms.common.api.CommonStatusCodes;

/* JADX INFO: loaded from: classes2.dex */
public final class GoogleSignInStatusCodes extends CommonStatusCodes {
    private GoogleSignInStatusCodes() {
    }

    public static String a(int i2) {
        switch (i2) {
            case 12500:
                return "A non-recoverable sign in failure occurred";
            case AccountAnalytics.UNKNOWN_STATUS_CODE /* 12501 */:
                return "Sign in action cancelled";
            case 12502:
                return "Sign-in in progress";
            default:
                return CommonStatusCodes.a(i2);
        }
    }
}
