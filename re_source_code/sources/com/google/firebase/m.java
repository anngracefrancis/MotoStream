package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Strings;

/* JADX INFO: compiled from: FirebaseOptions.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f19761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f19762f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f19763g;

    private m(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Preconditions.o(!Strings.a(str), "ApplicationId must be set.");
        this.f19758b = str;
        this.a = str2;
        this.f19759c = str3;
        this.f19760d = str4;
        this.f19761e = str5;
        this.f19762f = str6;
        this.f19763g = str7;
    }

    public static m a(Context context) {
        StringResourceValueReader stringResourceValueReader = new StringResourceValueReader(context);
        String strA = stringResourceValueReader.a("google_app_id");
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return new m(strA, stringResourceValueReader.a("google_api_key"), stringResourceValueReader.a("firebase_database_url"), stringResourceValueReader.a("ga_trackingId"), stringResourceValueReader.a("gcm_defaultSenderId"), stringResourceValueReader.a("google_storage_bucket"), stringResourceValueReader.a("project_id"));
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.f19758b;
    }

    public String d() {
        return this.f19761e;
    }

    public String e() {
        return this.f19763g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return Objects.a(this.f19758b, mVar.f19758b) && Objects.a(this.a, mVar.a) && Objects.a(this.f19759c, mVar.f19759c) && Objects.a(this.f19760d, mVar.f19760d) && Objects.a(this.f19761e, mVar.f19761e) && Objects.a(this.f19762f, mVar.f19762f) && Objects.a(this.f19763g, mVar.f19763g);
    }

    public int hashCode() {
        return Objects.b(this.f19758b, this.a, this.f19759c, this.f19760d, this.f19761e, this.f19762f, this.f19763g);
    }

    public String toString() {
        return Objects.c(this).a("applicationId", this.f19758b).a("apiKey", this.a).a("databaseUrl", this.f19759c).a("gcmSenderId", this.f19761e).a("storageBucket", this.f19762f).a("projectId", this.f19763g).toString();
    }
}
