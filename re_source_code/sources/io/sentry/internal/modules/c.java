package io.sentry.internal.modules;

import io.sentry.s4;
import io.sentry.util.h;
import io.sentry.w1;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: ManifestModulesLoader.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
@ApiStatus.Experimental
public final class c extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Pattern f22444d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Pattern f22445e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ClassLoader f22446f;

    /* JADX INFO: compiled from: ManifestModulesLoader.java */
    private static final class a {
        private final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f22447b;

        public a(String str, String str2) {
            this.a = str;
            this.f22447b = str2;
        }
    }

    public c(w1 w1Var) {
        this(c.class.getClassLoader(), w1Var);
    }

    private a d(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = this.f22445e.matcher(str);
        if (matcher.matches() && matcher.groupCount() == 2) {
            return new a(matcher.group(1), matcher.group(2));
        }
        return null;
    }

    private List<a> e() {
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<URL> resources = this.f22446f.getResources("META-INF/MANIFEST.MF");
            while (resources.hasMoreElements()) {
                a aVarD = d(f(resources.nextElement()));
                if (aVarD != null) {
                    arrayList.add(aVarD);
                }
            }
        } catch (Throwable th) {
            this.f22448b.b(s4.ERROR, "Unable to detect modules via manifest files.", th);
        }
        return arrayList;
    }

    private String f(URL url) {
        Matcher matcher = this.f22444d.matcher(url.toString());
        if (matcher.matches() && matcher.groupCount() == 1) {
            return matcher.group(1);
        }
        return null;
    }

    @Override // io.sentry.internal.modules.d
    protected Map<String, String> b() {
        HashMap map = new HashMap();
        for (a aVar : e()) {
            map.put(aVar.a, aVar.f22447b);
        }
        return map;
    }

    c(ClassLoader classLoader, w1 w1Var) {
        super(w1Var);
        this.f22444d = Pattern.compile(".*/(.+)!/META-INF/MANIFEST.MF");
        this.f22445e = Pattern.compile("(.*?)-(\\d+\\.\\d+.*).jar");
        this.f22446f = h.a(classLoader);
    }
}
