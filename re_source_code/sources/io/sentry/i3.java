package io.sentry;

import java.lang.reflect.InvocationTargetException;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: OptionsContainer.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class i3<T> {
    private final Class<T> a;

    private i3(Class<T> cls) {
        this.a = cls;
    }

    public static <T> i3<T> a(Class<T> cls) {
        return new i3<>(cls);
    }

    public T b() throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        return this.a.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    }
}
