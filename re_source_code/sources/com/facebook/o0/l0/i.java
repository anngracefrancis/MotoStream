package com.facebook.o0.l0;

import cm.aptoide.pt.install.installer.RootCommandOnSubscribe;
import java.util.Arrays;

/* JADX INFO: compiled from: AppEventsConversionsAPITransformer.kt */
/* JADX INFO: loaded from: classes.dex */
public enum i {
    VALUE_TO_SUM("value"),
    EVENT_TIME("event_time"),
    EVENT_NAME("event_name"),
    CONTENT_IDS("content_ids"),
    CONTENTS("contents"),
    CONTENT_TYPE("content_type"),
    DESCRIPTION("description"),
    LEVEL("level"),
    MAX_RATING_VALUE("max_rating_value"),
    NUM_ITEMS("num_items"),
    PAYMENT_INFO_AVAILABLE("payment_info_available"),
    REGISTRATION_METHOD("registration_method"),
    SEARCH_STRING("search_string"),
    SUCCESS(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION),
    ORDER_ID("order_id"),
    AD_TYPE("ad_type"),
    CURRENCY("currency");

    private final String x;

    i(String str) {
        this.x = str;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static i[] valuesCustom() {
        i[] iVarArrValuesCustom = values();
        return (i[]) Arrays.copyOf(iVarArrValuesCustom, iVarArrValuesCustom.length);
    }

    public final String k() {
        return this.x;
    }
}
