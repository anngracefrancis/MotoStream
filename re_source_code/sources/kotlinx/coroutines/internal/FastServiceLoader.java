package kotlinx.coroutines.internal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.internal.k, reason: from Kotlin metadata */
/* JADX INFO: compiled from: FastServiceLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\t\u001a\u00020\u0004H\u0082\bJ1\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\bH\u0002¢\u0006\u0002\u0010\u0010J*\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0012\"\u0004\b\u0000\u0010\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0000¢\u0006\u0002\b\u0014J/\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0012\"\u0004\b\u0000\u0010\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\b2\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J,\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e*\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u0002H\u001e0!H\u0082\b¢\u0006\u0002\u0010\"R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lkotlinx/coroutines/internal/FastServiceLoader;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "PREFIX", HttpUrl.FRAGMENT_ENCODE_SET, "createInstanceOf", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "baseClass", "Ljava/lang/Class;", "serviceClass", "getProviderInstance", "S", "name", "loader", "Ljava/lang/ClassLoader;", "service", "(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/Object;", "load", HttpUrl.FRAGMENT_ENCODE_SET, "loadMainDispatcherFactory", "loadMainDispatcherFactory$kotlinx_coroutines_core", "loadProviders", "loadProviders$kotlinx_coroutines_core", "parse", "url", "Ljava/net/URL;", "parseFile", "r", "Ljava/io/BufferedReader;", "use", "R", "Ljava/util/jar/JarFile;", "block", "Lkotlin/Function1;", "(Ljava/util/jar/JarFile;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FastServiceLoader {
    public static final FastServiceLoader a = new FastServiceLoader();

    private FastServiceLoader() {
    }

    private final <S> S a(String str, ClassLoader classLoader, Class<S> cls) throws ClassNotFoundException {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    private final <S> List<S> b(Class<S> cls, ClassLoader classLoader) {
        try {
            return d(cls, classLoader);
        } catch (Throwable unused) {
            return kotlin.collections.c0.E0(ServiceLoader.load(cls, classLoader));
        }
    }

    private final List<String> e(URL url) throws IOException {
        String string = url.toString();
        if (!kotlin.text.u.E(string, "jar", false, 2, null)) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            try {
                List<String> listF = a.f(bufferedReader);
                kotlin.io.a.a(bufferedReader, null);
                return listF;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    kotlin.io.a.a(bufferedReader, th);
                    throw th2;
                }
            }
        }
        String strL0 = kotlin.text.v.L0(kotlin.text.v.G0(string, "jar:file:", null, 2, null), '!', null, 2, null);
        String strG0 = kotlin.text.v.G0(string, "!/", null, 2, null);
        JarFile jarFile = new JarFile(strL0, false);
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(strG0)), "UTF-8"));
            try {
                List<String> listF2 = a.f(bufferedReader2);
                kotlin.io.a.a(bufferedReader2, null);
                jarFile.close();
                return listF2;
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    kotlin.io.a.a(bufferedReader2, th3);
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                try {
                    jarFile.close();
                    throw th6;
                } catch (Throwable th7) {
                    kotlin.b.a(th5, th7);
                    throw th5;
                }
            }
        }
    }

    private final List<String> f(BufferedReader bufferedReader) throws IOException {
        boolean z;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return kotlin.collections.c0.E0(linkedHashSet);
            }
            String string = kotlin.text.v.O0(kotlin.text.v.M0(line, "#", null, 2, null)).toString();
            int i2 = 0;
            while (true) {
                if (i2 >= string.length()) {
                    z = true;
                    break;
                }
                char cCharAt = string.charAt(i2);
                if (!(cCharAt == '.' || Character.isJavaIdentifierPart(cCharAt))) {
                    z = false;
                    break;
                }
                i2++;
            }
            if (!z) {
                throw new IllegalArgumentException(("Illegal service provider class name: " + string).toString());
            }
            if (string.length() > 0) {
                linkedHashSet.add(string);
            }
        }
    }

    public final List<MainDispatcherFactory> c() {
        MainDispatcherFactory mainDispatcherFactory;
        if (!l.a()) {
            return b(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            MainDispatcherFactory mainDispatcherFactory2 = null;
            try {
                mainDispatcherFactory = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused) {
                mainDispatcherFactory = null;
            }
            if (mainDispatcherFactory != null) {
                arrayList.add(mainDispatcherFactory);
            }
            try {
                mainDispatcherFactory2 = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused2) {
            }
            if (mainDispatcherFactory2 == null) {
                return arrayList;
            }
            arrayList.add(mainDispatcherFactory2);
            return arrayList;
        } catch (Throwable unused3) {
            return b(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        }
    }

    public final <S> List<S> d(Class<S> cls, ClassLoader classLoader) {
        ArrayList list = Collections.list(classLoader.getResources("META-INF/services/" + cls.getName()));
        kotlin.jvm.internal.m.e(list, "list(this)");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            kotlin.collections.z.z(arrayList, a.e((URL) it.next()));
        }
        Set setI0 = kotlin.collections.c0.I0(arrayList);
        if (!(!setI0.isEmpty())) {
            throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.v.u(setI0, 10));
        Iterator it2 = setI0.iterator();
        while (it2.hasNext()) {
            arrayList2.add(a.a((String) it2.next(), classLoader, cls));
        }
        return arrayList2;
    }
}
