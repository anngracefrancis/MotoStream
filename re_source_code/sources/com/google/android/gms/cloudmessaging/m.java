package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class m<T> {
    final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final TaskCompletionSource<T> f11600b = new TaskCompletionSource<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f11601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Bundle f11602d;

    m(int i2, int i3, Bundle bundle) {
        this.a = i2;
        this.f11601c = i3;
        this.f11602d = bundle;
    }

    abstract void a(Bundle bundle);

    final void b(zzp zzpVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String strValueOf = String.valueOf(this);
            String strValueOf2 = String.valueOf(zzpVar);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 14 + strValueOf2.length());
            sb.append("Failing ");
            sb.append(strValueOf);
            sb.append(" with ");
            sb.append(strValueOf2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.f11600b.b(zzpVar);
    }

    final void c(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String strValueOf = String.valueOf(this);
            String strValueOf2 = String.valueOf(t);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 16 + strValueOf2.length());
            sb.append("Finishing ");
            sb.append(strValueOf);
            sb.append(" with ");
            sb.append(strValueOf2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.f11600b.c(t);
    }

    abstract boolean d();

    public String toString() {
        int i2 = this.f11601c;
        int i3 = this.a;
        boolean zD = d();
        StringBuilder sb = new StringBuilder(55);
        sb.append("Request { what=");
        sb.append(i2);
        sb.append(" id=");
        sb.append(i3);
        sb.append(" oneWay=");
        sb.append(zD);
        sb.append("}");
        return sb.toString();
    }
}
