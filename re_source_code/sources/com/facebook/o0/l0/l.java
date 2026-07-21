package com.facebook.o0.l0;

import java.util.Arrays;

/* JADX INFO: compiled from: AppEventsConversionsAPITransformer.kt */
/* JADX INFO: loaded from: classes.dex */
public enum l {
    ANON_ID("anon_id"),
    FB_LOGIN_ID("fb_login_id"),
    MAD_ID("madid"),
    PAGE_ID("page_id"),
    PAGE_SCOPED_USER_ID("page_scoped_user_id"),
    USER_DATA("ud"),
    ADV_TE("advertiser_tracking_enabled"),
    APP_TE("application_tracking_enabled"),
    CONSIDER_VIEWS("consider_views"),
    DEVICE_TOKEN("device_token"),
    EXT_INFO("extInfo"),
    INCLUDE_DWELL_DATA("include_dwell_data"),
    INCLUDE_VIDEO_DATA("include_video_data"),
    INSTALL_REFERRER("install_referrer"),
    INSTALLER_PACKAGE("installer_package"),
    RECEIPT_DATA("receipt_data"),
    URL_SCHEMES("url_schemes");

    private final String x;

    l(String str) {
        this.x = str;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static l[] valuesCustom() {
        l[] lVarArrValuesCustom = values();
        return (l[]) Arrays.copyOf(lVarArrValuesCustom, lVarArrValuesCustom.length);
    }

    public final String k() {
        return this.x;
    }
}
