package com.google.firebase.messaging;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class q0 {
    private static final Pattern a = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19851d;

    private q0(String str, String str2) {
        this.f19849b = d(str2, str);
        this.f19850c = str;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("!");
        sb.append(str2);
        this.f19851d = sb.toString();
    }

    static q0 a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split("!", -1);
        if (strArrSplit.length != 2) {
            return null;
        }
        return new q0(strArrSplit[0], strArrSplit[1]);
    }

    private static String d(String str, String str2) {
        if (str != null && str.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", str2));
            str = str.substring(8);
        }
        if (str == null || !a.matcher(str).matches()) {
            throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", str, "[a-zA-Z0-9-_.~%]{1,900}"));
        }
        return str;
    }

    public String b() {
        return this.f19850c;
    }

    public String c() {
        return this.f19849b;
    }

    public String e() {
        return this.f19851d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q0)) {
            return false;
        }
        q0 q0Var = (q0) obj;
        return this.f19849b.equals(q0Var.f19849b) && this.f19850c.equals(q0Var.f19850c);
    }

    public int hashCode() {
        return Objects.b(this.f19850c, this.f19849b);
    }
}
