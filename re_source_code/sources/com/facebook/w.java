package com.facebook;

import java.util.Arrays;

/* JADX INFO: compiled from: AccessTokenSource.kt */
/* JADX INFO: loaded from: classes.dex */
public enum w {
    NONE(false),
    FACEBOOK_APPLICATION_WEB(true),
    FACEBOOK_APPLICATION_NATIVE(true),
    FACEBOOK_APPLICATION_SERVICE(true),
    WEB_VIEW(true),
    CHROME_CUSTOM_TAB(true),
    TEST_USER(true),
    CLIENT_TOKEN(true),
    DEVICE_AUTH(true),
    INSTAGRAM_APPLICATION_WEB(true),
    INSTAGRAM_CUSTOM_CHROME_TAB(true),
    INSTAGRAM_WEB_VIEW(true);

    private final boolean s;

    w(boolean z) {
        this.s = z;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static w[] valuesCustom() {
        w[] wVarArrValuesCustom = values();
        return (w[]) Arrays.copyOf(wVarArrValuesCustom, wVarArrValuesCustom.length);
    }

    public final boolean k() {
        return this.s;
    }
}
