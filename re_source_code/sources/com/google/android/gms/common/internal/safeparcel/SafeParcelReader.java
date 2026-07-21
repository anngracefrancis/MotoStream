package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public class SafeParcelReader {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public static class ParseException extends RuntimeException {
        public ParseException(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    private SafeParcelReader() {
    }

    public static float A(Parcel parcel, int i2) {
        N(parcel, i2, 4);
        return parcel.readFloat();
    }

    public static Float B(Parcel parcel, int i2) {
        int iJ = J(parcel, i2);
        if (iJ == 0) {
            return null;
        }
        M(parcel, i2, iJ, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static int C(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder D(Parcel parcel, int i2) {
        int iJ = J(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iJ == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iJ);
        return strongBinder;
    }

    public static int E(Parcel parcel, int i2) {
        N(parcel, i2, 4);
        return parcel.readInt();
    }

    public static Integer F(Parcel parcel, int i2) {
        int iJ = J(parcel, i2);
        if (iJ == 0) {
            return null;
        }
        M(parcel, i2, iJ, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static long G(Parcel parcel, int i2) {
        N(parcel, i2, 8);
        return parcel.readLong();
    }

    public static Long H(Parcel parcel, int i2) {
        int iJ = J(parcel, i2);
        if (iJ == 0) {
            return null;
        }
        M(parcel, i2, iJ, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static short I(Parcel parcel, int i2) {
        N(parcel, i2, 4);
        return (short) parcel.readInt();
    }

    public static int J(Parcel parcel, int i2) {
        return (i2 & (-65536)) != -65536 ? (char) (i2 >> 16) : parcel.readInt();
    }

    public static void K(Parcel parcel, int i2) {
        parcel.setDataPosition(parcel.dataPosition() + J(parcel, i2));
    }

    public static int L(Parcel parcel) {
        int iC = C(parcel);
        int iJ = J(parcel, iC);
        int iDataPosition = parcel.dataPosition();
        if (v(iC) != 20293) {
            throw new ParseException("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(iC))), parcel);
        }
        int i2 = iJ + iDataPosition;
        if (i2 >= iDataPosition && i2 <= parcel.dataSize()) {
            return i2;
        }
        throw new ParseException("Size read is invalid start=" + iDataPosition + " end=" + i2, parcel);
    }

    private static void M(Parcel parcel, int i2, int i3, int i4) {
        if (i3 == i4) {
            return;
        }
        throw new ParseException("Expected size " + i4 + " got " + i3 + " (0x" + Integer.toHexString(i3) + ")", parcel);
    }

    private static void N(Parcel parcel, int i2, int i3) {
        int iJ = J(parcel, i2);
        if (iJ == i3) {
            return;
        }
        throw new ParseException("Expected size " + i3 + " got " + iJ + " (0x" + Integer.toHexString(iJ) + ")", parcel);
    }

    public static BigDecimal a(Parcel parcel, int i2) {
        int iJ = J(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iJ == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        int i3 = parcel.readInt();
        parcel.setDataPosition(iDataPosition + iJ);
        return new BigDecimal(new BigInteger(bArrCreateByteArray), i3);
    }

    public static BigDecimal[] b(Parcel parcel, int i2) {
        int iJ = J(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iJ == 0) {
            return null;
        }
        int i3 = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            byte[] bArrCreateByteArray = parcel.createByteArray();
            bigDecimalArr[i4] = new BigDecimal(new BigInteger(bArrCreateByteArray), parcel.readInt());
        }
        parcel.setDataPosition(iDataPosition + iJ);
        return bigDecimalArr;
    }

    public static BigInteger c(Parcel parcel, int i2) {
        int iJ = J(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iJ == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iJ);
        return new BigInteger(bArrCreateByteArray);
    }

    public static BigInteger[] d(Parcel parcel, int i2) {
        int iJ = J(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iJ == 0) {
            return null;
        }
        int i3 = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            bigIntegerArr[i4] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(iDataPosition + iJ);
        return bigIntegerArr;
    }

    public static boolean[] e(Parcel parcel, int i2) {
        int iJ = J(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iJ == 0) {
            return null;
        }
        boolean[] zArrCreateBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(iDataPosition + iJ);
        return zArrCreateBooleanArray;
    }

    public static Bundle f(Parcel parcel, int i2) {
        int iJ = J(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iJ == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iJ);
        return bundle;
    }

    public static byte[] g(Parcel parcel, int i2) {
        int iJ = J(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iJ == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iJ);
        return bArrCreateByteArray;
    }

    public static double[] h(Parcel parcel, int i2) {
        int iJ = J(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iJ == 0) {
            return null;
        }
        double[] dArrCreateDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(iDataPosition + iJ);
        return dArrCreateDoubleArray;
    }

    public static float[] i(Parcel parcel, int i2) {
        int iJ = J(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iJ == 0) {
            return null;
        }
        float[] fArrCreateFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(iDataPosition + iJ);
        return fArrCreateFloatArray;
    }

    public static int[] j(Parcel parcel, int i2) {
        int iJ = J(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iJ == 0) {
            return null;
        }
        int[] iArrCreateIntArray = parcel.createIntArray();
        parcel.setDataPosition(iDataPosition + iJ);
        return iArrCreateIntArray;
    }

    public static ArrayList<Integer> k(Parcel parcel, int i2) {
        int iJ = J(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iJ == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i3 = parcel.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(iDataPosition + iJ);
        return arrayList;
    }

    public static long[] l(Parcel parcel, int i2) {
        int iJ = J(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iJ == 0) {
            return null;
        }
        long[] jArrCreateLongArray = parcel.createLongArray();
        parcel.setDataPosition(iDataPosition + iJ);
        return jArrCreateLongArray;
    }

    public static Parcel m(Parcel parcel, int i2) {
        int iJ = J(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iJ == 0) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.appendFrom(parcel, iDataPosition, iJ);
        parcel.setDataPosition(iDataPosition + iJ);
        return parcelObtain;
    }

    public static Parcel[] n(Parcel parcel, int i2) {
        int iJ = J(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iJ == 0) {
            return null;
        }
        int i3 = parcel.readInt();
        Parcel[] parcelArr = new Parcel[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = parcel.readInt();
            if (i5 != 0) {
                int iDataPosition2 = parcel.dataPosition();
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.appendFrom(parcel, iDataPosition2, i5);
                parcelArr[i4] = parcelObtain;
                parcel.setDataPosition(iDataPosition2 + i5);
            } else {
                parcelArr[i4] = null;
            }
        }
        parcel.setDataPosition(iDataPosition + iJ);
        return parcelArr;
    }

    public static <T extends Parcelable> T o(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int iJ = J(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iJ == 0) {
            return null;
        }
        T tCreateFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iJ);
        return tCreateFromParcel;
    }

    public static String p(Parcel parcel, int i2) {
        int iJ = J(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iJ == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iJ);
        return string;
    }

    public static String[] q(Parcel parcel, int i2) {
        int iJ = J(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iJ == 0) {
            return null;
        }
        String[] strArrCreateStringArray = parcel.createStringArray();
        parcel.setDataPosition(iDataPosition + iJ);
        return strArrCreateStringArray;
    }

    public static ArrayList<String> r(Parcel parcel, int i2) {
        int iJ = J(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iJ == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iDataPosition + iJ);
        return arrayListCreateStringArrayList;
    }

    public static <T> T[] s(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int iJ = J(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iJ == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iJ);
        return tArr;
    }

    public static <T> ArrayList<T> t(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int iJ = J(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iJ == 0) {
            return null;
        }
        ArrayList<T> arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iJ);
        return arrayListCreateTypedArrayList;
    }

    public static void u(Parcel parcel, int i2) {
        if (parcel.dataPosition() == i2) {
            return;
        }
        throw new ParseException("Overread allowed size end=" + i2, parcel);
    }

    public static int v(int i2) {
        return (char) i2;
    }

    public static boolean w(Parcel parcel, int i2) {
        N(parcel, i2, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean x(Parcel parcel, int i2) {
        int iJ = J(parcel, i2);
        if (iJ == 0) {
            return null;
        }
        M(parcel, i2, iJ, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static double y(Parcel parcel, int i2) {
        N(parcel, i2, 8);
        return parcel.readDouble();
    }

    public static Double z(Parcel parcel, int i2) {
        int iJ = J(parcel, i2);
        if (iJ == 0) {
            return null;
        }
        M(parcel, i2, iJ, 8);
        return Double.valueOf(parcel.readDouble());
    }
}
