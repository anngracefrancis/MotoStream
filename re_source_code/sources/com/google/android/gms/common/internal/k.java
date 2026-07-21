package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class k extends com.google.android.gms.internal.common.zzi {
    final /* synthetic */ BaseGmsClient a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(BaseGmsClient baseGmsClient, Looper looper) {
        super(looper);
        this.a = baseGmsClient;
    }

    private static final void a(Message message) {
        zzc zzcVar = (zzc) message.obj;
        zzcVar.b();
        zzcVar.e();
    }

    private static final boolean b(Message message) {
        int i2 = message.what;
        return i2 == 2 || i2 == 1 || i2 == 7;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.a.zzd.get() != message.arg1) {
            if (b(message)) {
                a(message);
                return;
            }
            return;
        }
        int i2 = message.what;
        if ((i2 == 1 || i2 == 7 || ((i2 == 4 && !this.a.enableLocalFallback()) || message.what == 5)) && !this.a.isConnecting()) {
            a(message);
            return;
        }
        int i3 = message.what;
        if (i3 == 4) {
            this.a.zzB = new ConnectionResult(message.arg2);
            if (BaseGmsClient.zzo(this.a)) {
                BaseGmsClient baseGmsClient = this.a;
                if (!baseGmsClient.zzC) {
                    baseGmsClient.zzp(3, null);
                    return;
                }
            }
            BaseGmsClient baseGmsClient2 = this.a;
            ConnectionResult connectionResult = baseGmsClient2.zzB != null ? baseGmsClient2.zzB : new ConnectionResult(8);
            this.a.zzc.a(connectionResult);
            this.a.onConnectionFailed(connectionResult);
            return;
        }
        if (i3 == 5) {
            BaseGmsClient baseGmsClient3 = this.a;
            ConnectionResult connectionResult2 = baseGmsClient3.zzB != null ? baseGmsClient3.zzB : new ConnectionResult(8);
            this.a.zzc.a(connectionResult2);
            this.a.onConnectionFailed(connectionResult2);
            return;
        }
        if (i3 == 3) {
            Object obj = message.obj;
            ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
            this.a.zzc.a(connectionResult3);
            this.a.onConnectionFailed(connectionResult3);
            return;
        }
        if (i3 == 6) {
            this.a.zzp(5, null);
            BaseGmsClient baseGmsClient4 = this.a;
            if (baseGmsClient4.zzw != null) {
                baseGmsClient4.zzw.H(message.arg2);
            }
            this.a.onConnectionSuspended(message.arg2);
            BaseGmsClient.zzn(this.a, 5, 1, null);
            return;
        }
        if (i3 == 2 && !this.a.isConnected()) {
            a(message);
            return;
        }
        if (b(message)) {
            ((zzc) message.obj).c();
            return;
        }
        Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
    }
}
