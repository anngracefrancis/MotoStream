package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;

/* JADX INFO: loaded from: classes2.dex */
public interface zabd {
    void H(int i2);

    void P(Bundle bundle);

    void a();

    void d();

    boolean disconnect();

    void k0(ConnectionResult connectionResult, Api<?> api, boolean z);

    <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T l0(T t);

    <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T m0(T t);
}
