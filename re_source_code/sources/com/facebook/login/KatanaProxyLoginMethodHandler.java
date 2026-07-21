package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.k0;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: KatanaProxyLoginMethodHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class KatanaProxyLoginMethodHandler extends NativeAppLoginMethodHandler {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f9959k;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f9958j = new b(null);
    public static final Parcelable.Creator<KatanaProxyLoginMethodHandler> CREATOR = new a();

    /* JADX INFO: compiled from: KatanaProxyLoginMethodHandler.kt */
    public static final class a implements Parcelable.Creator<KatanaProxyLoginMethodHandler> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public KatanaProxyLoginMethodHandler createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.m.f(parcel, "source");
            return new KatanaProxyLoginMethodHandler(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public KatanaProxyLoginMethodHandler[] newArray(int i2) {
            return new KatanaProxyLoginMethodHandler[i2];
        }
    }

    /* JADX INFO: compiled from: KatanaProxyLoginMethodHandler.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KatanaProxyLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        kotlin.jvm.internal.m.f(loginClient, "loginClient");
        this.f9959k = "katana_proxy_auth";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public String f() {
        return this.f9959k;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public boolean n() {
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0023  */
    @Override // com.facebook.login.LoginMethodHandler
    public int o(LoginClient.Request request) {
        boolean z;
        kotlin.jvm.internal.m.f(request, "request");
        t tVarJ = request.j();
        if (com.facebook.a0.r) {
            com.facebook.internal.v vVar = com.facebook.internal.v.a;
            if (com.facebook.internal.v.a() == null || !tVarJ.k()) {
                z = false;
            } else {
                z = true;
            }
        } else {
            z = false;
        }
        String strA = LoginClient.f9960f.a();
        k0 k0Var = k0.a;
        androidx.fragment.app.d dVarI = d().i();
        String strA2 = request.a();
        Set<String> setN = request.n();
        boolean zS = request.s();
        boolean zP = request.p();
        r rVarG = request.g();
        if (rVarG == null) {
            rVarG = r.NONE;
        }
        r rVar = rVarG;
        String strC = c(request.b());
        String strC2 = request.c();
        String strL = request.l();
        boolean zO = request.o();
        boolean zQ = request.q();
        boolean z2 = request.z();
        String strM = request.m();
        String strD = request.d();
        p pVarE = request.e();
        List<Intent> listM = k0.m(dVarI, strA2, setN, strA, zS, zP, rVar, strC, strC2, z, strL, zO, zQ, z2, strM, strD, pVarE == null ? null : pVarE.name());
        a("e2e", strA);
        Iterator<Intent> it = listM.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2++;
            if (B(it.next(), LoginClient.f9960f.b())) {
                return i2;
            }
        }
        return 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KatanaProxyLoginMethodHandler(Parcel parcel) {
        super(parcel);
        kotlin.jvm.internal.m.f(parcel, "source");
        this.f9959k = "katana_proxy_auth";
    }
}
