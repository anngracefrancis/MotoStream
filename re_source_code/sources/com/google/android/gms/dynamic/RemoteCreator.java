package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public abstract class RemoteCreator<T> {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f12191b;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    @KeepForSdk
    public static class RemoteCreatorException extends Exception {
        @KeepForSdk
        public RemoteCreatorException(String str) {
            super(str);
        }

        @KeepForSdk
        public RemoteCreatorException(String str, Throwable th) {
            super(str, th);
        }
    }

    @KeepForSdk
    protected RemoteCreator(String str) {
        this.a = str;
    }

    @KeepForSdk
    protected abstract T a(IBinder iBinder);

    @KeepForSdk
    protected final T b(Context context) throws RemoteCreatorException {
        if (this.f12191b == null) {
            Preconditions.k(context);
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            if (remoteContext == null) {
                throw new RemoteCreatorException("Could not get remote context.");
            }
            try {
                this.f12191b = a((IBinder) remoteContext.getClassLoader().loadClass(this.a).newInstance());
            } catch (ClassNotFoundException e2) {
                throw new RemoteCreatorException("Could not load creator class.", e2);
            } catch (IllegalAccessException e3) {
                throw new RemoteCreatorException("Could not access creator.", e3);
            } catch (InstantiationException e4) {
                throw new RemoteCreatorException("Could not instantiate creator.", e4);
            }
        }
        return (T) this.f12191b;
    }
}
