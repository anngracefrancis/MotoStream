package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdcf {
    private static final Logger a = Logger.getLogger(zzdcf.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentMap<String, zzdbs> f15866b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentMap<String, Boolean> f15867c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ConcurrentMap<String, zzdbk> f15868d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ConcurrentMap<Class<?>, zzdcc<?>> f15869e = new ConcurrentHashMap();

    private static <T> T a(T t) {
        t.getClass();
        return t;
    }

    private static <P> zzdbs<P> b(String str, Class<P> cls) throws GeneralSecurityException {
        zzdbs<P> zzdbsVar = f15866b.get(str);
        if (zzdbsVar == null) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 78);
            sb.append("No key manager found for key type: ");
            sb.append(str);
            sb.append(".  Check the configuration of the registry.");
            throw new GeneralSecurityException(sb.toString());
        }
        if (cls == null || zzdbsVar.a().equals(cls)) {
            return zzdbsVar;
        }
        String name = zzdbsVar.a().getName();
        String name2 = cls.getName();
        StringBuilder sb2 = new StringBuilder(name.length() + 80 + String.valueOf(str).length() + name2.length());
        sb2.append("Primitive type ");
        sb2.append(name);
        sb2.append(" of keymanager for type ");
        sb2.append(str);
        sb2.append(" does not match requested primitive type ");
        sb2.append(name2);
        throw new GeneralSecurityException(sb2.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <P> zzdca<P> c(zzdbu zzdbuVar, zzdbs<P> zzdbsVar, Class<P> cls) throws GeneralSecurityException {
        Class cls2 = (Class) a(cls);
        cr.b(zzdbuVar.b());
        zzdca<P> zzdcaVar = (zzdca<P>) zzdca.a(cls2);
        for (zzdha.zzb zzbVar : zzdbuVar.b().y()) {
            if (zzbVar.A() == zzdgu.ENABLED) {
                zzdcb zzdcbVarB = zzdcaVar.b(g(zzbVar.z().B(), zzbVar.z().C(), cls2), zzbVar);
                if (zzbVar.B() == zzdbuVar.b().x()) {
                    zzdcaVar.c(zzdcbVarB);
                }
            }
        }
        return zzdcaVar;
    }

    public static synchronized zzdgr d(zzdgw zzdgwVar) throws GeneralSecurityException {
        zzdbs zzdbsVarB;
        zzdbsVarB = b(zzdgwVar.x(), null);
        if (!f15867c.get(zzdgwVar.x()).booleanValue()) {
            String strValueOf = String.valueOf(zzdgwVar.x());
            throw new GeneralSecurityException(strValueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(strValueOf) : new String("newKey-operation not permitted for key type "));
        }
        return zzdbsVarB.e(zzdgwVar.y());
    }

    public static synchronized zzdpk e(String str, zzdpk zzdpkVar) throws GeneralSecurityException {
        zzdbs zzdbsVarB;
        zzdbsVarB = b(str, null);
        if (!f15867c.get(str).booleanValue()) {
            String strValueOf = String.valueOf(str);
            throw new GeneralSecurityException(strValueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(strValueOf) : new String("newKey-operation not permitted for key type "));
        }
        return zzdbsVarB.c(zzdpkVar);
    }

    public static <P> P f(zzdca<P> zzdcaVar) throws GeneralSecurityException {
        zzdcc<?> zzdccVar = f15869e.get(zzdcaVar.d());
        if (zzdccVar != null) {
            return (P) zzdccVar.b(zzdcaVar);
        }
        String name = zzdcaVar.d().getName();
        throw new GeneralSecurityException(name.length() != 0 ? "No wrapper found for ".concat(name) : new String("No wrapper found for "));
    }

    private static <P> P g(String str, zzdmr zzdmrVar, Class<P> cls) throws GeneralSecurityException {
        return (P) b(str, cls).g(zzdmrVar);
    }

    public static <P> P h(String str, zzdpk zzdpkVar, Class<P> cls) throws GeneralSecurityException {
        return (P) b(str, (Class) a(cls)).d(zzdpkVar);
    }

    public static <P> P i(String str, byte[] bArr, Class<P> cls) throws GeneralSecurityException {
        return (P) g(str, zzdmr.D(bArr), (Class) a(cls));
    }

    public static synchronized <P> void j(zzdbs<P> zzdbsVar) throws GeneralSecurityException {
        k(zzdbsVar, true);
    }

    public static synchronized <P> void k(zzdbs<P> zzdbsVar, boolean z) throws GeneralSecurityException {
        try {
            if (zzdbsVar == null) {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
            String strB = zzdbsVar.b();
            ConcurrentMap<String, zzdbs> concurrentMap = f15866b;
            if (concurrentMap.containsKey(strB)) {
                zzdbs zzdbsVarB = b(strB, null);
                boolean zBooleanValue = f15867c.get(strB).booleanValue();
                if (!zzdbsVar.getClass().equals(zzdbsVarB.getClass()) || (!zBooleanValue && z)) {
                    Logger logger = a;
                    Level level = Level.WARNING;
                    String strValueOf = String.valueOf(strB);
                    logger.logp(level, "com.google.crypto.tink.Registry", "registerKeyManager", strValueOf.length() != 0 ? "Attempted overwrite of a registered key manager for key type ".concat(strValueOf) : new String("Attempted overwrite of a registered key manager for key type "));
                    throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", strB, zzdbsVarB.getClass().getName(), zzdbsVar.getClass().getName()));
                }
            }
            concurrentMap.put(strB, zzdbsVar);
            f15867c.put(strB, Boolean.valueOf(z));
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized <P> void l(zzdcc<P> zzdccVar) throws GeneralSecurityException {
        try {
            if (zzdccVar == null) {
                throw new IllegalArgumentException("wrapper must be non-null");
            }
            Class<P> clsA = zzdccVar.a();
            ConcurrentMap<Class<?>, zzdcc<?>> concurrentMap = f15869e;
            if (concurrentMap.containsKey(clsA)) {
                zzdcc<?> zzdccVar2 = concurrentMap.get(clsA);
                if (!zzdccVar.getClass().equals(zzdccVar2.getClass())) {
                    Logger logger = a;
                    Level level = Level.WARNING;
                    String strValueOf = String.valueOf(clsA.toString());
                    logger.logp(level, "com.google.crypto.tink.Registry", "registerPrimitiveWrapper", strValueOf.length() != 0 ? "Attempted overwrite of a registered SetWrapper for type ".concat(strValueOf) : new String("Attempted overwrite of a registered SetWrapper for type "));
                    throw new GeneralSecurityException(String.format("SetWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", clsA.getName(), zzdccVar2.getClass().getName(), zzdccVar.getClass().getName()));
                }
            }
            concurrentMap.put(clsA, zzdccVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized void m(String str, zzdbk<?> zzdbkVar) throws GeneralSecurityException {
        ConcurrentMap<String, zzdbk> concurrentMap = f15868d;
        if (concurrentMap.containsKey(str.toLowerCase())) {
            if (!zzdbkVar.getClass().equals(concurrentMap.get(str.toLowerCase()).getClass())) {
                a.logp(Level.WARNING, "com.google.crypto.tink.Registry", "addCatalogue", str.length() != 0 ? "Attempted overwrite of a catalogueName catalogue for name ".concat(str) : new String("Attempted overwrite of a catalogueName catalogue for name "));
                StringBuilder sb = new StringBuilder(str.length() + 47);
                sb.append("catalogue for name ");
                sb.append(str);
                sb.append(" has been already registered");
                throw new GeneralSecurityException(sb.toString());
            }
        }
        concurrentMap.put(str.toLowerCase(), zzdbkVar);
    }

    public static synchronized zzdpk n(zzdgw zzdgwVar) throws GeneralSecurityException {
        zzdbs zzdbsVarB;
        zzdbsVarB = b(zzdgwVar.x(), null);
        if (!f15867c.get(zzdgwVar.x()).booleanValue()) {
            String strValueOf = String.valueOf(zzdgwVar.x());
            throw new GeneralSecurityException(strValueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(strValueOf) : new String("newKey-operation not permitted for key type "));
        }
        return zzdbsVarB.f(zzdgwVar.y());
    }

    public static zzdbk<?> o(String str) throws GeneralSecurityException {
        if (str == null) {
            throw new IllegalArgumentException("catalogueName must be non-null.");
        }
        zzdbk<?> zzdbkVar = f15868d.get(str.toLowerCase());
        if (zzdbkVar != null) {
            return zzdbkVar;
        }
        String strConcat = String.format("no catalogue found for %s. ", str);
        if (str.toLowerCase().startsWith("tinkaead")) {
            strConcat = String.valueOf(strConcat).concat("Maybe call AeadConfig.register().");
        }
        if (str.toLowerCase().startsWith("tinkdeterministicaead")) {
            strConcat = String.valueOf(strConcat).concat("Maybe call DeterministicAeadConfig.register().");
        } else if (str.toLowerCase().startsWith("tinkstreamingaead")) {
            strConcat = String.valueOf(strConcat).concat("Maybe call StreamingAeadConfig.register().");
        } else if (str.toLowerCase().startsWith("tinkhybriddecrypt") || str.toLowerCase().startsWith("tinkhybridencrypt")) {
            strConcat = String.valueOf(strConcat).concat("Maybe call HybridConfig.register().");
        } else if (str.toLowerCase().startsWith("tinkmac")) {
            strConcat = String.valueOf(strConcat).concat("Maybe call MacConfig.register().");
        } else if (str.toLowerCase().startsWith("tinkpublickeysign") || str.toLowerCase().startsWith("tinkpublickeyverify")) {
            strConcat = String.valueOf(strConcat).concat("Maybe call SignatureConfig.register().");
        } else if (str.toLowerCase().startsWith("tink")) {
            strConcat = String.valueOf(strConcat).concat("Maybe call TinkConfig.register().");
        }
        throw new GeneralSecurityException(strConcat);
    }
}
