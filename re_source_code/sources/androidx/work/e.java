package androidx.work;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: Data.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    private static final String a = n.f("Data");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f2327b = new a().a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Map<String, Object> f2328c;

    /* JADX INFO: compiled from: Data.java */
    public static final class a {
        private Map<String, Object> a = new HashMap();

        public e a() throws Throwable {
            e eVar = new e((Map<String, ?>) this.a);
            e.l(eVar);
            return eVar;
        }

        public a b(String str, Object obj) {
            if (obj == null) {
                this.a.put(str, null);
            } else {
                Class<?> cls = obj.getClass();
                if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                    this.a.put(str, obj);
                } else if (cls == boolean[].class) {
                    this.a.put(str, e.a((boolean[]) obj));
                } else if (cls == byte[].class) {
                    this.a.put(str, e.b((byte[]) obj));
                } else if (cls == int[].class) {
                    this.a.put(str, e.e((int[]) obj));
                } else if (cls == long[].class) {
                    this.a.put(str, e.f((long[]) obj));
                } else if (cls == float[].class) {
                    this.a.put(str, e.d((float[]) obj));
                } else {
                    if (cls != double[].class) {
                        throw new IllegalArgumentException(String.format("Key %s has invalid type %s", str, cls));
                    }
                    this.a.put(str, e.c((double[]) obj));
                }
            }
            return this;
        }

        public a c(e eVar) {
            d(eVar.f2328c);
            return this;
        }

        public a d(Map<String, Object> map) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                b(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public a e(String str, boolean z) {
            this.a.put(str, Boolean.valueOf(z));
            return this;
        }

        public a f(String str, String str2) {
            this.a.put(str, str2);
            return this;
        }
    }

    e() {
    }

    public static Boolean[] a(boolean[] zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i2 = 0; i2 < zArr.length; i2++) {
            boolArr[i2] = Boolean.valueOf(zArr[i2]);
        }
        return boolArr;
    }

    public static Byte[] b(byte[] bArr) {
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = Byte.valueOf(bArr[i2]);
        }
        return bArr2;
    }

    public static Double[] c(double[] dArr) {
        Double[] dArr2 = new Double[dArr.length];
        for (int i2 = 0; i2 < dArr.length; i2++) {
            dArr2[i2] = Double.valueOf(dArr[i2]);
        }
        return dArr2;
    }

    public static Float[] d(float[] fArr) {
        Float[] fArr2 = new Float[fArr.length];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr2[i2] = Float.valueOf(fArr[i2]);
        }
        return fArr2;
    }

    public static Integer[] e(int[] iArr) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            numArr[i2] = Integer.valueOf(iArr[i2]);
        }
        return numArr;
    }

    public static Long[] f(long[] jArr) {
        Long[] lArr = new Long[jArr.length];
        for (int i2 = 0; i2 < jArr.length; i2++) {
            lArr[i2] = Long.valueOf(jArr[i2]);
        }
        return lArr;
    }

    /* JADX WARN: Code duplicated, block: B:55:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static e g(byte[] bArr) throws Throwable {
        Throwable th;
        ObjectInputStream objectInputStream;
        Throwable e2;
        if (bArr.length > 10240) {
            throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
        }
        HashMap map = new HashMap();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ObjectInputStream objectInputStream2 = null;
        try {
            try {
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    try {
                        for (int i2 = objectInputStream.readInt(); i2 > 0; i2--) {
                            map.put(objectInputStream.readUTF(), objectInputStream.readObject());
                        }
                        try {
                            objectInputStream.close();
                        } catch (IOException e3) {
                            Log.e(a, "Error in Data#fromByteArray: ", e3);
                        }
                        byteArrayInputStream.close();
                    } catch (IOException e4) {
                        e2 = e4;
                        Log.e(a, "Error in Data#fromByteArray: ", e2);
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e5) {
                                Log.e(a, "Error in Data#fromByteArray: ", e5);
                            }
                        }
                        byteArrayInputStream.close();
                    } catch (ClassNotFoundException e6) {
                        e2 = e6;
                        Log.e(a, "Error in Data#fromByteArray: ", e2);
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        byteArrayInputStream.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (0 != 0) {
                        try {
                            objectInputStream2.close();
                        } catch (IOException e7) {
                            Log.e(a, "Error in Data#fromByteArray: ", e7);
                        }
                    }
                    try {
                        byteArrayInputStream.close();
                        throw th;
                    } catch (IOException e8) {
                        Log.e(a, "Error in Data#fromByteArray: ", e8);
                        throw th;
                    }
                }
            } catch (IOException e9) {
                e = e9;
                Throwable th3 = e;
                objectInputStream = null;
                e2 = th3;
                Log.e(a, "Error in Data#fromByteArray: ", e2);
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                byteArrayInputStream.close();
                return new e(map);
            } catch (ClassNotFoundException e10) {
                e = e10;
                Throwable th4 = e;
                objectInputStream = null;
                e2 = th4;
                Log.e(a, "Error in Data#fromByteArray: ", e2);
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                byteArrayInputStream.close();
                return new e(map);
            } catch (Throwable th5) {
                th = th5;
                if (0 != 0) {
                    objectInputStream2.close();
                }
                byteArrayInputStream.close();
                throw th;
            }
        } catch (IOException e11) {
            Log.e(a, "Error in Data#fromByteArray: ", e11);
        }
        return new e(map);
    }

    public static byte[] l(e eVar) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream2.writeInt(eVar.k());
                    for (Map.Entry<String, Object> entry : eVar.f2328c.entrySet()) {
                        objectOutputStream2.writeUTF(entry.getKey());
                        objectOutputStream2.writeObject(entry.getValue());
                    }
                    try {
                        objectOutputStream2.close();
                    } catch (IOException e2) {
                        Log.e(a, "Error in Data#toByteArray: ", e2);
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e3) {
                        Log.e(a, "Error in Data#toByteArray: ", e3);
                    }
                    if (byteArrayOutputStream.size() <= 10240) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
                } catch (IOException e4) {
                    e = e4;
                    objectOutputStream = objectOutputStream2;
                    Log.e(a, "Error in Data#toByteArray: ", e);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e5) {
                            Log.e(a, "Error in Data#toByteArray: ", e5);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e6) {
                        Log.e(a, "Error in Data#toByteArray: ", e6);
                    }
                    return byteArray;
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e7) {
                            Log.e(a, "Error in Data#toByteArray: ", e7);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                        throw th;
                    } catch (IOException e8) {
                        Log.e(a, "Error in Data#toByteArray: ", e8);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e9) {
            e = e9;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        Set<String> setKeySet = this.f2328c.keySet();
        if (!setKeySet.equals(eVar.f2328c.keySet())) {
            return false;
        }
        for (String str : setKeySet) {
            Object obj2 = this.f2328c.get(str);
            Object obj3 = eVar.f2328c.get(str);
            if (!((obj2 == null || obj3 == null) ? obj2 == obj3 : ((obj2 instanceof Object[]) && (obj3 instanceof Object[])) ? Arrays.deepEquals((Object[]) obj2, (Object[]) obj3) : obj2.equals(obj3))) {
                return false;
            }
        }
        return true;
    }

    public boolean h(String str, boolean z) {
        Object obj = this.f2328c.get(str);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
    }

    public int hashCode() {
        return this.f2328c.hashCode() * 31;
    }

    public Map<String, Object> i() {
        return Collections.unmodifiableMap(this.f2328c);
    }

    public String j(String str) {
        Object obj = this.f2328c.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public int k() {
        return this.f2328c.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Data {");
        if (!this.f2328c.isEmpty()) {
            for (String str : this.f2328c.keySet()) {
                sb.append(str);
                sb.append(" : ");
                Object obj = this.f2328c.get(str);
                if (obj instanceof Object[]) {
                    sb.append(Arrays.toString((Object[]) obj));
                } else {
                    sb.append(obj);
                }
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public e(e eVar) {
        this.f2328c = new HashMap(eVar.f2328c);
    }

    public e(Map<String, ?> map) {
        this.f2328c = new HashMap(map);
    }
}
