package androidx.core.app;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.graphics.drawable.IconCompat;
import cm.aptoide.pt.database.room.RoomInstalled;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: compiled from: NotificationCompatJellybean.java */
/* JADX INFO: loaded from: classes.dex */
class k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f908c;
    private static final Object a = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f909d = new Object();

    public static SparseArray<Bundle> a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            Bundle bundle = list.get(i2);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i2, bundle);
            }
        }
        return sparseArray;
    }

    static Bundle b(i.a aVar) {
        Bundle bundle = new Bundle();
        IconCompat iconCompatE = aVar.e();
        bundle.putInt(RoomInstalled.ICON, iconCompatE != null ? iconCompatE.e() : 0);
        bundle.putCharSequence("title", aVar.i());
        bundle.putParcelable("actionIntent", aVar.a());
        Bundle bundle2 = aVar.d() != null ? new Bundle(aVar.d()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", e(aVar.f()));
        bundle.putBoolean("showsUserInterface", aVar.h());
        bundle.putInt("semanticAction", aVar.g());
        return bundle;
    }

    public static Bundle c(Notification notification) {
        synchronized (a) {
            if (f908c) {
                return null;
            }
            try {
                if (f907b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f908c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f907b = declaredField;
                }
                Bundle bundle = (Bundle) f907b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f907b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f908c = true;
                return null;
            } catch (NoSuchFieldException e3) {
                Log.e("NotificationCompat", "Unable to access notification extras", e3);
                f908c = true;
                return null;
            }
        }
    }

    private static Bundle d(n nVar) {
        new Bundle();
        throw null;
    }

    private static Bundle[] e(n[] nVarArr) {
        if (nVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[nVarArr.length];
        for (int i2 = 0; i2 < nVarArr.length; i2++) {
            bundleArr[i2] = d(nVarArr[i2]);
        }
        return bundleArr;
    }

    public static Bundle f(Notification.Builder builder, i.a aVar) {
        IconCompat iconCompatE = aVar.e();
        builder.addAction(iconCompatE != null ? iconCompatE.e() : 0, aVar.i(), aVar.a());
        Bundle bundle = new Bundle(aVar.d());
        if (aVar.f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", e(aVar.f()));
        }
        if (aVar.c() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", e(aVar.c()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        return bundle;
    }
}
