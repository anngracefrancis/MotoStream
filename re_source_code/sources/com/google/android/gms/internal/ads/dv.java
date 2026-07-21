package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdno;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
abstract class dv<T extends zzdno> {
    private static final Logger a = Logger.getLogger(zzdni.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f12487b = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    dv() {
    }

    static <T extends zzdno> T b(Class<T> cls) {
        String str;
        ClassLoader classLoader = dv.class.getClassLoader();
        if (cls.equals(zzdno.class)) {
            str = f12487b;
        } else {
            if (!cls.getPackage().equals(dv.class.getPackage())) {
                throw new IllegalArgumentException(cls.getName());
            }
            str = String.format("%s.BlazeGenerated%sLoader", cls.getPackage().getName(), cls.getSimpleName());
        }
        try {
            try {
                try {
                    try {
                        return cls.cast(((dv) Class.forName(str, true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0])).a());
                    } catch (IllegalAccessException e2) {
                        throw new IllegalStateException(e2);
                    }
                } catch (InvocationTargetException e3) {
                    throw new IllegalStateException(e3);
                }
            } catch (InstantiationException e4) {
                throw new IllegalStateException(e4);
            } catch (NoSuchMethodException e5) {
                throw new IllegalStateException(e5);
            }
        } catch (ClassNotFoundException unused) {
            Iterator it = ServiceLoader.load(dv.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    arrayList.add(cls.cast(((dv) it.next()).a()));
                } catch (ServiceConfigurationError e6) {
                    Logger logger = a;
                    Level level = Level.SEVERE;
                    String simpleName = cls.getSimpleName();
                    logger.logp(level, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", simpleName.length() != 0 ? "Unable to load ".concat(simpleName) : new String("Unable to load "), (Throwable) e6);
                }
            }
            if (arrayList.size() == 1) {
                return (T) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (T) cls.getMethod("combine", Collection.class).invoke(null, arrayList);
            } catch (IllegalAccessException e7) {
                throw new IllegalStateException(e7);
            } catch (NoSuchMethodException e8) {
                throw new IllegalStateException(e8);
            } catch (InvocationTargetException e9) {
                throw new IllegalStateException(e9);
            }
        }
    }

    protected abstract T a();
}
