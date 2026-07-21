package androidx.work.impl.n;

import android.net.Uri;
import android.os.Build;
import androidx.work.x;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;

/* JADX INFO: compiled from: WorkTypeConverters.java */
/* JADX INFO: loaded from: classes.dex */
public class v {

    /* JADX INFO: compiled from: WorkTypeConverters.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f2551b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f2552c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final /* synthetic */ int[] f2553d;

        static {
            int[] iArr = new int[androidx.work.r.values().length];
            f2553d = iArr;
            try {
                iArr[androidx.work.r.RUN_AS_NON_EXPEDITED_WORK_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2553d[androidx.work.r.DROP_WORK_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[androidx.work.o.values().length];
            f2552c = iArr2;
            try {
                iArr2[androidx.work.o.NOT_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2552c[androidx.work.o.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2552c[androidx.work.o.UNMETERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2552c[androidx.work.o.NOT_ROAMING.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2552c[androidx.work.o.METERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[androidx.work.a.values().length];
            f2551b = iArr3;
            try {
                iArr3[androidx.work.a.EXPONENTIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2551b[androidx.work.a.LINEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr4 = new int[x.a.values().length];
            a = iArr4;
            try {
                iArr4[x.a.ENQUEUED.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[x.a.RUNNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[x.a.SUCCEEDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[x.a.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[x.a.BLOCKED.ordinal()] = 5;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[x.a.CANCELLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public static int a(androidx.work.a aVar) {
        int i2 = a.f2551b[aVar.ordinal()];
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2) {
            return 1;
        }
        throw new IllegalArgumentException("Could not convert " + aVar + " to int");
    }

    /* JADX WARN: Code duplicated, block: B:59:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static androidx.work.d b(byte[] bArr) throws Throwable {
        ObjectInputStream objectInputStream;
        Throwable th;
        IOException e2;
        androidx.work.d dVar = new androidx.work.d();
        if (bArr == null) {
            return dVar;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    try {
                        for (int i2 = objectInputStream.readInt(); i2 > 0; i2--) {
                            dVar.a(Uri.parse(objectInputStream.readUTF()), objectInputStream.readBoolean());
                        }
                        try {
                            objectInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        byteArrayInputStream.close();
                    } catch (IOException e4) {
                        e2 = e4;
                        e2.printStackTrace();
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        byteArrayInputStream.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    try {
                        byteArrayInputStream.close();
                        throw th;
                    } catch (IOException e7) {
                        e7.printStackTrace();
                        throw th;
                    }
                }
            } catch (IOException e8) {
                e8.printStackTrace();
            }
        } catch (IOException e9) {
            objectInputStream = null;
            e2 = e9;
        } catch (Throwable th3) {
            objectInputStream = null;
            th = th3;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            throw th;
        }
        return dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public static byte[] c(androidx.work.d dVar) throws Throwable {
        boolean zHasNext;
        ?? r1 = 0;
        ObjectOutputStream objectOutputStream = null;
        r1 = 0;
        if (dVar.c() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                try {
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                    try {
                        objectOutputStream2.writeInt(dVar.c());
                        Iterator<androidx.work.d.a> it = dVar.b().iterator();
                        while (true) {
                            zHasNext = it.hasNext();
                            if (zHasNext) {
                                androidx.work.d.a next = it.next();
                                objectOutputStream2.writeUTF(next.a().toString());
                                objectOutputStream2.writeBoolean(next.b());
                            } else {
                                try {
                                    break;
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        objectOutputStream2.close();
                        byteArrayOutputStream.close();
                        r1 = zHasNext;
                    } catch (IOException e3) {
                        e = e3;
                        objectOutputStream = objectOutputStream2;
                        e.printStackTrace();
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        byteArrayOutputStream.close();
                        r1 = objectOutputStream;
                    } catch (Throwable th) {
                        th = th;
                        r1 = objectOutputStream2;
                        if (r1 != 0) {
                            try {
                                r1.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        try {
                            byteArrayOutputStream.close();
                            throw th;
                        } catch (IOException e6) {
                            e6.printStackTrace();
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e7) {
                e = e7;
            }
        } catch (IOException e8) {
            e8.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static androidx.work.a d(int i2) {
        if (i2 == 0) {
            return androidx.work.a.EXPONENTIAL;
        }
        if (i2 == 1) {
            return androidx.work.a.LINEAR;
        }
        throw new IllegalArgumentException("Could not convert " + i2 + " to BackoffPolicy");
    }

    public static androidx.work.o e(int i2) {
        if (i2 == 0) {
            return androidx.work.o.NOT_REQUIRED;
        }
        if (i2 == 1) {
            return androidx.work.o.CONNECTED;
        }
        if (i2 == 2) {
            return androidx.work.o.UNMETERED;
        }
        if (i2 == 3) {
            return androidx.work.o.NOT_ROAMING;
        }
        if (i2 == 4) {
            return androidx.work.o.METERED;
        }
        if (Build.VERSION.SDK_INT >= 30 && i2 == 5) {
            return androidx.work.o.TEMPORARILY_UNMETERED;
        }
        throw new IllegalArgumentException("Could not convert " + i2 + " to NetworkType");
    }

    public static androidx.work.r f(int i2) {
        if (i2 == 0) {
            return androidx.work.r.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        }
        if (i2 == 1) {
            return androidx.work.r.DROP_WORK_REQUEST;
        }
        throw new IllegalArgumentException("Could not convert " + i2 + " to OutOfQuotaPolicy");
    }

    public static x.a g(int i2) {
        if (i2 == 0) {
            return x.a.ENQUEUED;
        }
        if (i2 == 1) {
            return x.a.RUNNING;
        }
        if (i2 == 2) {
            return x.a.SUCCEEDED;
        }
        if (i2 == 3) {
            return x.a.FAILED;
        }
        if (i2 == 4) {
            return x.a.BLOCKED;
        }
        if (i2 == 5) {
            return x.a.CANCELLED;
        }
        throw new IllegalArgumentException("Could not convert " + i2 + " to State");
    }

    public static int h(androidx.work.o oVar) {
        int i2 = a.f2552c[oVar.ordinal()];
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2) {
            return 1;
        }
        if (i2 == 3) {
            return 2;
        }
        if (i2 == 4) {
            return 3;
        }
        if (i2 == 5) {
            return 4;
        }
        if (Build.VERSION.SDK_INT >= 30 && oVar == androidx.work.o.TEMPORARILY_UNMETERED) {
            return 5;
        }
        throw new IllegalArgumentException("Could not convert " + oVar + " to int");
    }

    public static int i(androidx.work.r rVar) {
        int i2 = a.f2553d[rVar.ordinal()];
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2) {
            return 1;
        }
        throw new IllegalArgumentException("Could not convert " + rVar + " to int");
    }

    public static int j(x.a aVar) {
        switch (a.a[aVar.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            default:
                throw new IllegalArgumentException("Could not convert " + aVar + " to int");
        }
    }
}
