package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import cm.aptoide.pt.account.AndroidAccountManagerPersistence;
import com.facebook.AccessToken;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: compiled from: DeviceAuthMethodHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public class DeviceAuthMethodHandler extends LoginMethodHandler {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static ScheduledThreadPoolExecutor f9949j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f9950k;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f9948i = new b(null);
    public static final Parcelable.Creator<DeviceAuthMethodHandler> CREATOR = new a();

    /* JADX INFO: compiled from: DeviceAuthMethodHandler.kt */
    public static final class a implements Parcelable.Creator<DeviceAuthMethodHandler> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DeviceAuthMethodHandler createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.m.f(parcel, "source");
            return new DeviceAuthMethodHandler(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DeviceAuthMethodHandler[] newArray(int i2) {
            return new DeviceAuthMethodHandler[i2];
        }
    }

    /* JADX INFO: compiled from: DeviceAuthMethodHandler.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final synchronized ScheduledThreadPoolExecutor a() {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
            if (DeviceAuthMethodHandler.f9949j == null) {
                DeviceAuthMethodHandler.f9949j = new ScheduledThreadPoolExecutor(1);
            }
            scheduledThreadPoolExecutor = DeviceAuthMethodHandler.f9949j;
            if (scheduledThreadPoolExecutor == null) {
                kotlin.jvm.internal.m.w("backgroundExecutor");
                throw null;
            }
            return scheduledThreadPoolExecutor;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceAuthMethodHandler(LoginClient loginClient) {
        super(loginClient);
        kotlin.jvm.internal.m.f(loginClient, "loginClient");
        this.f9950k = "device_auth";
    }

    private final void v(LoginClient.Request request) {
        androidx.fragment.app.d dVarI = d().i();
        if (dVarI == null || dVarI.isFinishing()) {
            return;
        }
        DeviceAuthDialog deviceAuthDialogR = r();
        deviceAuthDialogR.show(dVarI.getSupportFragmentManager(), "login_with_facebook");
        deviceAuthDialogR.E(request);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public String f() {
        return this.f9950k;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public int o(LoginClient.Request request) {
        kotlin.jvm.internal.m.f(request, "request");
        v(request);
        return 1;
    }

    protected DeviceAuthDialog r() {
        return new DeviceAuthDialog();
    }

    public void s() {
        d().g(LoginClient.Result.f9972f.a(d().o(), "User canceled log in."));
    }

    public void t(Exception exc) {
        kotlin.jvm.internal.m.f(exc, "ex");
        d().g(LoginClient.Result.c.d(LoginClient.Result.f9972f, d().o(), null, exc.getMessage(), null, 8, null));
    }

    public void u(String str, String str2, String str3, Collection<String> collection, Collection<String> collection2, Collection<String> collection3, com.facebook.w wVar, Date date, Date date2, Date date3) {
        kotlin.jvm.internal.m.f(str, "accessToken");
        kotlin.jvm.internal.m.f(str2, "applicationId");
        kotlin.jvm.internal.m.f(str3, AndroidAccountManagerPersistence.ACCOUNT_ID);
        d().g(LoginClient.Result.f9972f.e(d().o(), new AccessToken(str, str2, str3, collection, collection2, collection3, wVar, date, date2, date3, null, 1024, null)));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected DeviceAuthMethodHandler(Parcel parcel) {
        super(parcel);
        kotlin.jvm.internal.m.f(parcel, "parcel");
        this.f9950k = "device_auth";
    }
}
