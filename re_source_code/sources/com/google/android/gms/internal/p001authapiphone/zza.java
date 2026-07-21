package com.google.android.gms.internal.p001authapiphone;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes2.dex */
public class zza implements IInterface {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final IBinder f17017f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f17018g;

    protected zza(IBinder iBinder, String str) {
        this.f17017f = iBinder;
        this.f17018g = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f17017f;
    }
}
