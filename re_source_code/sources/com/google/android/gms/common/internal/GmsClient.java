package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public abstract class GmsClient<T extends IInterface> extends BaseGmsClient<T> implements Api.Client, GmsClientEventManager.GmsClientEventState {
    private final ClientSettings a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<Scope> f11976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Account f11977c;

    @KeepForSdk
    protected GmsClient(Context context, Looper looper, int i2, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, GmsClientSupervisor.b(context), GoogleApiAvailability.q(), i2, clientSettings, (GoogleApiClient.ConnectionCallbacks) Preconditions.k(connectionCallbacks), (GoogleApiClient.OnConnectionFailedListener) Preconditions.k(onConnectionFailedListener));
    }

    private static BaseGmsClient.BaseConnectionCallbacks g(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        if (connectionCallbacks == null) {
            return null;
        }
        return new d(connectionCallbacks);
    }

    private static BaseGmsClient.BaseOnConnectionFailedListener h(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        if (onConnectionFailedListener == null) {
            return null;
        }
        return new e(onConnectionFailedListener);
    }

    private final Set<Scope> i(Set<Scope> set) {
        Set<Scope> setF = f(set);
        Iterator<Scope> it = setF.iterator();
        while (it.hasNext()) {
            if (!set.contains(it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return setF;
    }

    @KeepForSdk
    protected final ClientSettings e() {
        return this.a;
    }

    @KeepForSdk
    protected Set<Scope> f(Set<Scope> set) {
        return set;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Account getAccount() {
        return this.f11977c;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public int getMinApkVersion() {
        return super.getMinApkVersion();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final Set<Scope> getScopes() {
        return this.f11976b;
    }

    @VisibleForTesting
    protected GmsClient(Context context, Looper looper, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailability googleApiAvailability, int i2, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, gmsClientSupervisor, googleApiAvailability, i2, g(connectionCallbacks), h(onConnectionFailedListener), clientSettings.i());
        this.a = clientSettings;
        this.f11977c = clientSettings.b();
        this.f11976b = i(clientSettings.e());
    }
}
