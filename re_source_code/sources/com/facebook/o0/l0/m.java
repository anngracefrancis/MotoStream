package com.facebook.o0.l0;

import java.util.Arrays;

/* JADX INFO: compiled from: AppEventsConversionsAPITransformer.kt */
/* JADX INFO: loaded from: classes.dex */
public enum m {
    EVENT_TIME("_logTime"),
    EVENT_NAME("_eventName"),
    VALUE_TO_SUM("_valueToSum"),
    CONTENT_IDS("fb_content_id"),
    CONTENTS("fb_content"),
    CONTENT_TYPE("fb_content_type"),
    DESCRIPTION("fb_description"),
    LEVEL("fb_level"),
    MAX_RATING_VALUE("fb_max_rating_value"),
    NUM_ITEMS("fb_num_items"),
    PAYMENT_INFO_AVAILABLE("fb_payment_info_available"),
    REGISTRATION_METHOD("fb_registration_method"),
    SEARCH_STRING("fb_search_string"),
    SUCCESS("fb_success"),
    ORDER_ID("fb_order_id"),
    AD_TYPE("ad_type"),
    CURRENCY("fb_currency");


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f10229f = new a(null);
    private final String y;

    /* JADX INFO: compiled from: AppEventsConversionsAPITransformer.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final m a(String str) {
            kotlin.jvm.internal.m.f(str, "rawValue");
            for (m mVar : m.valuesCustom()) {
                if (kotlin.jvm.internal.m.a(mVar.k(), str)) {
                    return mVar;
                }
            }
            return null;
        }
    }

    m(String str) {
        this.y = str;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static m[] valuesCustom() {
        m[] mVarArrValuesCustom = values();
        return (m[]) Arrays.copyOf(mVarArrValuesCustom, mVarArrValuesCustom.length);
    }

    public final String k() {
        return this.y;
    }
}
