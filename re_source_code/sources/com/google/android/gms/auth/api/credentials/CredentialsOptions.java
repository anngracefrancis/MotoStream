package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.auth.api.Auth;

/* JADX INFO: loaded from: classes2.dex */
public final class CredentialsOptions extends Auth.AuthCredentialsOptions {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final CredentialsOptions f11471i = (CredentialsOptions) new Builder().a();

    public static final class Builder extends Auth.AuthCredentialsOptions.Builder {
        @Override // com.google.android.gms.auth.api.Auth.AuthCredentialsOptions.Builder
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CredentialsOptions a() {
            return new CredentialsOptions(this);
        }
    }

    private CredentialsOptions(Builder builder) {
        super(builder);
    }
}
