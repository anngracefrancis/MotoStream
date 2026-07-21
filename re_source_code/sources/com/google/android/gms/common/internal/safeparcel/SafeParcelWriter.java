package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public class SafeParcelWriter {
    private SafeParcelWriter() {
    }

    private static void A(Parcel parcel, int i2) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i2 - 4);
        parcel.writeInt(iDataPosition - i2);
        parcel.setDataPosition(iDataPosition);
    }

    private static void B(Parcel parcel, int i2, int i3) {
        parcel.writeInt(i2 | (i3 << 16));
    }

    private static void C(Parcel parcel, Parcelable parcelable, int i2) {
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int iDataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i2);
        int iDataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition3 - iDataPosition2);
        parcel.setDataPosition(iDataPosition3);
    }

    public static int a(Parcel parcel) {
        return z(parcel, 20293);
    }

    public static void b(Parcel parcel, int i2) {
        A(parcel, i2);
    }

    public static void c(Parcel parcel, int i2, boolean z) {
        B(parcel, i2, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void d(Parcel parcel, int i2, Boolean bool, boolean z) {
        if (bool != null) {
            B(parcel, i2, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z) {
            B(parcel, i2, 0);
        }
    }

    public static void e(Parcel parcel, int i2, Bundle bundle, boolean z) {
        if (bundle == null) {
            if (z) {
                B(parcel, i2, 0);
            }
        } else {
            int iZ = z(parcel, i2);
            parcel.writeBundle(bundle);
            A(parcel, iZ);
        }
    }

    public static void f(Parcel parcel, int i2, byte[] bArr, boolean z) {
        if (bArr == null) {
            if (z) {
                B(parcel, i2, 0);
            }
        } else {
            int iZ = z(parcel, i2);
            parcel.writeByteArray(bArr);
            A(parcel, iZ);
        }
    }

    public static void g(Parcel parcel, int i2, double d2) {
        B(parcel, i2, 8);
        parcel.writeDouble(d2);
    }

    public static void h(Parcel parcel, int i2, Double d2, boolean z) {
        if (d2 != null) {
            B(parcel, i2, 8);
            parcel.writeDouble(d2.doubleValue());
        } else if (z) {
            B(parcel, i2, 0);
        }
    }

    public static void i(Parcel parcel, int i2, float f2) {
        B(parcel, i2, 4);
        parcel.writeFloat(f2);
    }

    public static void j(Parcel parcel, int i2, Float f2, boolean z) {
        if (f2 != null) {
            B(parcel, i2, 4);
            parcel.writeFloat(f2.floatValue());
        } else if (z) {
            B(parcel, i2, 0);
        }
    }

    public static void k(Parcel parcel, int i2, IBinder iBinder, boolean z) {
        if (iBinder == null) {
            if (z) {
                B(parcel, i2, 0);
            }
        } else {
            int iZ = z(parcel, i2);
            parcel.writeStrongBinder(iBinder);
            A(parcel, iZ);
        }
    }

    public static void l(Parcel parcel, int i2, int i3) {
        B(parcel, i2, 4);
        parcel.writeInt(i3);
    }

    public static void m(Parcel parcel, int i2, int[] iArr, boolean z) {
        if (iArr == null) {
            if (z) {
                B(parcel, i2, 0);
            }
        } else {
            int iZ = z(parcel, i2);
            parcel.writeIntArray(iArr);
            A(parcel, iZ);
        }
    }

    public static void n(Parcel parcel, int i2, List<Integer> list, boolean z) {
        if (list == null) {
            if (z) {
                B(parcel, i2, 0);
                return;
            }
            return;
        }
        int iZ = z(parcel, i2);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeInt(list.get(i3).intValue());
        }
        A(parcel, iZ);
    }

    public static void o(Parcel parcel, int i2, Integer num, boolean z) {
        if (num != null) {
            B(parcel, i2, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            B(parcel, i2, 0);
        }
    }

    public static void p(Parcel parcel, int i2, long j2) {
        B(parcel, i2, 8);
        parcel.writeLong(j2);
    }

    public static void q(Parcel parcel, int i2, Long l, boolean z) {
        if (l != null) {
            B(parcel, i2, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            B(parcel, i2, 0);
        }
    }

    public static void r(Parcel parcel, int i2, Parcel parcel2, boolean z) {
        if (parcel2 == null) {
            if (z) {
                B(parcel, i2, 0);
            }
        } else {
            int iZ = z(parcel, i2);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            A(parcel, iZ);
        }
    }

    public static void s(Parcel parcel, int i2, Parcelable parcelable, int i3, boolean z) {
        if (parcelable == null) {
            if (z) {
                B(parcel, i2, 0);
            }
        } else {
            int iZ = z(parcel, i2);
            parcelable.writeToParcel(parcel, i3);
            A(parcel, iZ);
        }
    }

    public static void t(Parcel parcel, int i2, short s) {
        B(parcel, i2, 4);
        parcel.writeInt(s);
    }

    public static void u(Parcel parcel, int i2, String str, boolean z) {
        if (str == null) {
            if (z) {
                B(parcel, i2, 0);
            }
        } else {
            int iZ = z(parcel, i2);
            parcel.writeString(str);
            A(parcel, iZ);
        }
    }

    public static void v(Parcel parcel, int i2, String[] strArr, boolean z) {
        if (strArr == null) {
            if (z) {
                B(parcel, i2, 0);
            }
        } else {
            int iZ = z(parcel, i2);
            parcel.writeStringArray(strArr);
            A(parcel, iZ);
        }
    }

    public static void w(Parcel parcel, int i2, List<String> list, boolean z) {
        if (list == null) {
            if (z) {
                B(parcel, i2, 0);
            }
        } else {
            int iZ = z(parcel, i2);
            parcel.writeStringList(list);
            A(parcel, iZ);
        }
    }

    public static <T extends Parcelable> void x(Parcel parcel, int i2, T[] tArr, int i3, boolean z) {
        if (tArr == null) {
            if (z) {
                B(parcel, i2, 0);
                return;
            }
            return;
        }
        int iZ = z(parcel, i2);
        parcel.writeInt(tArr.length);
        for (T t : tArr) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                C(parcel, t, i3);
            }
        }
        A(parcel, iZ);
    }

    public static <T extends Parcelable> void y(Parcel parcel, int i2, List<T> list, boolean z) {
        if (list == null) {
            if (z) {
                B(parcel, i2, 0);
                return;
            }
            return;
        }
        int iZ = z(parcel, i2);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            T t = list.get(i3);
            if (t == null) {
                parcel.writeInt(0);
            } else {
                C(parcel, t, 0);
            }
        }
        A(parcel, iZ);
    }

    private static int z(Parcel parcel, int i2) {
        parcel.writeInt(i2 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }
}
