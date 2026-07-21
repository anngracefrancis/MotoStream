package com.facebook;

/* JADX INFO: compiled from: FacebookCallback.kt */
/* JADX INFO: loaded from: classes.dex */
public interface z<RESULT> {
    void onCancel();

    void onError(FacebookException facebookException);

    void onSuccess(RESULT result);
}
