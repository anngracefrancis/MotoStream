package com.google.android.gms.common;

import android.content.Intent;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public class UserRecoverableException extends Exception {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Intent f11648f;

    public UserRecoverableException(String str, Intent intent) {
        super(str);
        this.f11648f = intent;
    }
}
