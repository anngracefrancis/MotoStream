package com.facebook.internal;

import cm.aptoide.pt.database.room.RoomNotification;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: ProfileInformationCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class m0 {
    public static final m0 a = new m0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, JSONObject> f9804b = new ConcurrentHashMap<>();

    private m0() {
    }

    public static final JSONObject a(String str) {
        kotlin.jvm.internal.m.f(str, "accessToken");
        return f9804b.get(str);
    }

    public static final void b(String str, JSONObject jSONObject) {
        kotlin.jvm.internal.m.f(str, RoomNotification.KEY);
        kotlin.jvm.internal.m.f(jSONObject, "value");
        f9804b.put(str, jSONObject);
    }
}
