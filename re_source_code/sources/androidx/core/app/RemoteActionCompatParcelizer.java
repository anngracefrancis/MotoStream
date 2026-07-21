package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(VersionedParcel versionedParcel) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.a = (IconCompat) versionedParcel.v(remoteActionCompat.a, 1);
        remoteActionCompat.f840b = versionedParcel.l(remoteActionCompat.f840b, 2);
        remoteActionCompat.f841c = versionedParcel.l(remoteActionCompat.f841c, 3);
        remoteActionCompat.f842d = (PendingIntent) versionedParcel.r(remoteActionCompat.f842d, 4);
        remoteActionCompat.f843e = versionedParcel.h(remoteActionCompat.f843e, 5);
        remoteActionCompat.f844f = versionedParcel.h(remoteActionCompat.f844f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, VersionedParcel versionedParcel) {
        versionedParcel.x(false, false);
        versionedParcel.M(remoteActionCompat.a, 1);
        versionedParcel.D(remoteActionCompat.f840b, 2);
        versionedParcel.D(remoteActionCompat.f841c, 3);
        versionedParcel.H(remoteActionCompat.f842d, 4);
        versionedParcel.z(remoteActionCompat.f843e, 5);
        versionedParcel.z(remoteActionCompat.f844f, 6);
    }
}
