package com.facebook.o0.l0;

import java.util.Arrays;

/* JADX INFO: compiled from: AppEventsConversionsAPITransformer.kt */
/* JADX INFO: loaded from: classes.dex */
public enum e {
    ANON_ID("anon_id"),
    APP_USER_ID("app_user_id"),
    ADVERTISER_ID("advertiser_id"),
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


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f10171f = new a(null);
    private final String y;

    /* JADX INFO: compiled from: AppEventsConversionsAPITransformer.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final e a(String str) {
            kotlin.jvm.internal.m.f(str, "rawValue");
            for (e eVar : e.valuesCustom()) {
                if (kotlin.jvm.internal.m.a(eVar.k(), str)) {
                    return eVar;
                }
            }
            return null;
        }
    }

    e(String str) {
        this.y = str;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static e[] valuesCustom() {
        e[] eVarArrValuesCustom = values();
        return (e[]) Arrays.copyOf(eVarArrValuesCustom, eVarArrValuesCustom.length);
    }

    public final String k() {
        return this.y;
    }
}
