package com.facebook.o0.l0;

import java.util.Arrays;

/* JADX INFO: compiled from: AppEventsConversionsAPITransformer.kt */
/* JADX INFO: loaded from: classes.dex */
public enum d {
    MOBILE_APP_INSTALL,
    CUSTOM,
    OTHER;


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f10166f = new a(null);

    /* JADX INFO: compiled from: AppEventsConversionsAPITransformer.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final d a(String str) {
            kotlin.jvm.internal.m.f(str, "rawValue");
            if (kotlin.jvm.internal.m.a(str, "MOBILE_APP_INSTALL")) {
                return d.MOBILE_APP_INSTALL;
            }
            return kotlin.jvm.internal.m.a(str, "CUSTOM_APP_EVENTS") ? d.CUSTOM : d.OTHER;
        }
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static d[] valuesCustom() {
        d[] dVarArrValuesCustom = values();
        return (d[]) Arrays.copyOf(dVarArrValuesCustom, dVarArrValuesCustom.length);
    }
}
