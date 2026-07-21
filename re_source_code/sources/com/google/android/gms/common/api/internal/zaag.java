package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class zaag extends GoogleApiClient {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11803b;

    public zaag(String str) {
        this.f11803b = str;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public ConnectionResult d() {
        throw new UnsupportedOperationException(this.f11803b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public PendingResult<Status> e() {
        throw new UnsupportedOperationException(this.f11803b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void f() {
        throw new UnsupportedOperationException(this.f11803b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void h() {
        throw new UnsupportedOperationException(this.f11803b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void i(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        throw new UnsupportedOperationException(this.f11803b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean p() {
        throw new UnsupportedOperationException(this.f11803b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void s() {
        throw new UnsupportedOperationException(this.f11803b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void t(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.f11803b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void u(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.f11803b);
    }
}
