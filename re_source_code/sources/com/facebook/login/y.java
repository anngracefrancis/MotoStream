package com.facebook.login;

import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import java.util.Set;

/* JADX INFO: compiled from: LoginResult.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class y {
    private final AccessToken a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AuthenticationToken f10062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<String> f10063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set<String> f10064d;

    public y(AccessToken accessToken, AuthenticationToken authenticationToken, Set<String> set, Set<String> set2) {
        kotlin.jvm.internal.m.f(accessToken, "accessToken");
        kotlin.jvm.internal.m.f(set, "recentlyGrantedPermissions");
        kotlin.jvm.internal.m.f(set2, "recentlyDeniedPermissions");
        this.a = accessToken;
        this.f10062b = authenticationToken;
        this.f10063c = set;
        this.f10064d = set2;
    }

    public final AccessToken a() {
        return this.a;
    }

    public final Set<String> b() {
        return this.f10063c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return kotlin.jvm.internal.m.a(this.a, yVar.a) && kotlin.jvm.internal.m.a(this.f10062b, yVar.f10062b) && kotlin.jvm.internal.m.a(this.f10063c, yVar.f10063c) && kotlin.jvm.internal.m.a(this.f10064d, yVar.f10064d);
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        AuthenticationToken authenticationToken = this.f10062b;
        return ((((iHashCode + (authenticationToken == null ? 0 : authenticationToken.hashCode())) * 31) + this.f10063c.hashCode()) * 31) + this.f10064d.hashCode();
    }

    public String toString() {
        return "LoginResult(accessToken=" + this.a + ", authenticationToken=" + this.f10062b + ", recentlyGrantedPermissions=" + this.f10063c + ", recentlyDeniedPermissions=" + this.f10064d + ')';
    }
}
