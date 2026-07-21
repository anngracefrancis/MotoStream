package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
public class GoogleSignInResult implements Result {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Status f11517f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private GoogleSignInAccount f11518g;

    public GoogleSignInResult(GoogleSignInAccount googleSignInAccount, Status status) {
        this.f11518g = googleSignInAccount;
        this.f11517f = status;
    }

    public GoogleSignInAccount a() {
        return this.f11518g;
    }

    public boolean b() {
        return this.f11517f.e0();
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f11517f;
    }
}
