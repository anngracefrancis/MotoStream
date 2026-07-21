package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.RetainForClient;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@RetainForClient
@KeepForSdk
public final class ObjectWrapper<T> extends IObjectWrapper.Stub {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f12190f;

    private ObjectWrapper(Object obj) {
        this.f12190f = obj;
    }

    @KeepForSdk
    public static <T> IObjectWrapper E0(T t) {
        return new ObjectWrapper(t);
    }

    @KeepForSdk
    public static <T> T k0(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper instanceof ObjectWrapper) {
            return (T) ((ObjectWrapper) iObjectWrapper).f12190f;
        }
        IBinder iBinderAsBinder = iObjectWrapper.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        Field field = null;
        int i2 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i2++;
                field = field2;
            }
        }
        if (i2 != 1) {
            throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
        }
        Preconditions.k(field);
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return (T) field.get(iBinderAsBinder);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e2);
        } catch (NullPointerException e3) {
            throw new IllegalArgumentException("Binder object is null.", e3);
        }
    }
}
