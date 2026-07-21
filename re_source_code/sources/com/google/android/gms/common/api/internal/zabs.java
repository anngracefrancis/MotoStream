package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public interface zabs {
    void a();

    boolean b(SignInConnectionListener signInConnectionListener);

    void c();

    void d();

    void disconnect();

    void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    ConnectionResult e();

    boolean isConnected();

    <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T l0(T t);

    <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T m0(T t);
}
