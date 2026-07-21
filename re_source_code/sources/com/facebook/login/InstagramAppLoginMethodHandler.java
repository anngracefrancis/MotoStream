package com.facebook.login;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.k0;
import java.util.Set;

/* JADX INFO: compiled from: InstagramAppLoginMethodHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InstagramAppLoginMethodHandler extends NativeAppLoginMethodHandler {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f9957k;
    private final com.facebook.w l;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f9956j = new b(null);
    public static final Parcelable.Creator<InstagramAppLoginMethodHandler> CREATOR = new a();

    /* JADX INFO: compiled from: InstagramAppLoginMethodHandler.kt */
    public static final class a implements Parcelable.Creator<InstagramAppLoginMethodHandler> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public InstagramAppLoginMethodHandler createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.m.f(parcel, "source");
            return new InstagramAppLoginMethodHandler(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public InstagramAppLoginMethodHandler[] newArray(int i2) {
            return new InstagramAppLoginMethodHandler[i2];
        }
    }

    /* JADX INFO: compiled from: InstagramAppLoginMethodHandler.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstagramAppLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        kotlin.jvm.internal.m.f(loginClient, "loginClient");
        this.f9957k = "instagram_login";
        this.l = com.facebook.w.INSTAGRAM_APPLICATION_WEB;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public String f() {
        return this.f9957k;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public int o(LoginClient.Request request) {
        kotlin.jvm.internal.m.f(request, "request");
        LoginClient.c cVar = LoginClient.f9960f;
        String strA = cVar.a();
        k0 k0Var = k0.a;
        Context contextI = d().i();
        if (contextI == null) {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            contextI = com.facebook.a0.c();
        }
        String strA2 = request.a();
        Set<String> setN = request.n();
        boolean zS = request.s();
        boolean zP = request.p();
        r rVarG = request.g();
        if (rVarG == null) {
            rVarG = r.NONE;
        }
        Intent intentI = k0.i(contextI, strA2, setN, strA, zS, zP, rVarG, c(request.b()), request.c(), request.l(), request.o(), request.q(), request.z());
        a("e2e", strA);
        return B(intentI, cVar.b()) ? 1 : 0;
    }

    @Override // com.facebook.login.NativeAppLoginMethodHandler
    public com.facebook.w s() {
        return this.l;
    }

    @Override // com.facebook.login.LoginMethodHandler, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        kotlin.jvm.internal.m.f(parcel, "dest");
        super.writeToParcel(parcel, i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstagramAppLoginMethodHandler(Parcel parcel) {
        super(parcel);
        kotlin.jvm.internal.m.f(parcel, "source");
        this.f9957k = "instagram_login";
        this.l = com.facebook.w.INSTAGRAM_APPLICATION_WEB;
    }
}
