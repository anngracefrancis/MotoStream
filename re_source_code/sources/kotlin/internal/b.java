package kotlin.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.text.v;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: PlatformImplementations.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0001\u001a\"\u0010\b\u001a\u0002H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0083\b¢\u0006\u0002\u0010\f\u001a\b\u0010\r\u001a\u00020\u0005H\u0002\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;", "apiVersionIsAtLeast", HttpUrl.FRAGMENT_ENCODE_SET, "major", HttpUrl.FRAGMENT_ENCODE_SET, "minor", "patch", "castToBaseType", "T", HttpUrl.FRAGMENT_ENCODE_SET, "instance", "(Ljava/lang/Object;)Ljava/lang/Object;", "getJavaVersion", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class b {
    public static final PlatformImplementations a;

    /* JADX WARN: Code duplicated, block: B:35:0x00c0 A[Catch: ClassCastException -> 0x00c5, ClassNotFoundException -> 0x00fb, TRY_ENTER, TryCatch #2 {ClassCastException -> 0x00c5, blocks: (B:35:0x00c0, B:38:0x00c7, B:39:0x00cc), top: B:62:0x00be, outer: #7 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00c7 A[Catch: ClassCastException -> 0x00c5, ClassNotFoundException -> 0x00fb, TryCatch #2 {ClassCastException -> 0x00c5, blocks: (B:35:0x00c0, B:38:0x00c7, B:39:0x00cc), top: B:62:0x00be, outer: #7 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x00b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        PlatformImplementations platformImplementations;
        Object objNewInstance;
        int iA = a();
        if (iA >= 65544 || iA < 65536) {
            try {
                Object objNewInstance2 = Class.forName("kotlin.z.e.a").newInstance();
                m.e(objNewInstance2, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    try {
                        if (objNewInstance2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        platformImplementations = (PlatformImplementations) objNewInstance2;
                    } catch (ClassNotFoundException unused) {
                        if (iA < 65543) {
                            try {
                                objNewInstance = Class.forName("kotlin.z.d.a").newInstance();
                                m.e(objNewInstance, "forName(\"kotlin.internal…entations\").newInstance()");
                                try {
                                    try {
                                        if (objNewInstance == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                                        }
                                        platformImplementations = (PlatformImplementations) objNewInstance;
                                    } catch (ClassCastException e2) {
                                        ClassLoader classLoader = objNewInstance.getClass().getClassLoader();
                                        ClassLoader classLoader2 = PlatformImplementations.class.getClassLoader();
                                        if (m.a(classLoader, classLoader2)) {
                                            throw e2;
                                        }
                                        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e2);
                                    }
                                } catch (ClassNotFoundException unused2) {
                                    platformImplementations = new PlatformImplementations();
                                }
                            } catch (ClassNotFoundException unused3) {
                                Object objNewInstance3 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                                m.e(objNewInstance3, "forName(\"kotlin.internal…entations\").newInstance()");
                                try {
                                    if (objNewInstance3 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                                    }
                                    platformImplementations = (PlatformImplementations) objNewInstance3;
                                } catch (ClassCastException e3) {
                                    ClassLoader classLoader3 = objNewInstance3.getClass().getClassLoader();
                                    ClassLoader classLoader4 = PlatformImplementations.class.getClassLoader();
                                    if (m.a(classLoader3, classLoader4)) {
                                        throw e3;
                                    }
                                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, e3);
                                }
                            }
                        } else {
                            objNewInstance = Class.forName("kotlin.z.d.a").newInstance();
                            m.e(objNewInstance, "forName(\"kotlin.internal…entations\").newInstance()");
                            if (objNewInstance == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                            }
                            platformImplementations = (PlatformImplementations) objNewInstance;
                        }
                    }
                } catch (ClassCastException e4) {
                    ClassLoader classLoader5 = objNewInstance2.getClass().getClassLoader();
                    ClassLoader classLoader6 = PlatformImplementations.class.getClassLoader();
                    if (m.a(classLoader5, classLoader6)) {
                        throw e4;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, e4);
                }
            } catch (ClassNotFoundException unused4) {
                Object objNewInstance4 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                m.e(objNewInstance4, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    if (objNewInstance4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    platformImplementations = (PlatformImplementations) objNewInstance4;
                } catch (ClassCastException e5) {
                    ClassLoader classLoader7 = objNewInstance4.getClass().getClassLoader();
                    ClassLoader classLoader8 = PlatformImplementations.class.getClassLoader();
                    if (m.a(classLoader7, classLoader8)) {
                        throw e5;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, e5);
                }
            }
        } else if (iA < 65543 || iA < 65536) {
            objNewInstance = Class.forName("kotlin.z.d.a").newInstance();
            m.e(objNewInstance, "forName(\"kotlin.internal…entations\").newInstance()");
            if (objNewInstance == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            }
            platformImplementations = (PlatformImplementations) objNewInstance;
        } else {
            platformImplementations = new PlatformImplementations();
        }
        a = platformImplementations;
    }

    private static final int a() {
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return 65542;
        }
        int iV = v.V(property, '.', 0, false, 6, null);
        if (iV < 0) {
            try {
                return Integer.parseInt(property) * 65536;
            } catch (NumberFormatException unused) {
                return 65542;
            }
        }
        int i2 = iV + 1;
        int iV2 = v.V(property, '.', i2, false, 4, null);
        if (iV2 < 0) {
            iV2 = property.length();
        }
        String strSubstring = property.substring(0, iV);
        m.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        String strSubstring2 = property.substring(i2, iV2);
        m.e(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
        try {
            return (Integer.parseInt(strSubstring) * 65536) + Integer.parseInt(strSubstring2);
        } catch (NumberFormatException unused2) {
            return 65542;
        }
    }
}
