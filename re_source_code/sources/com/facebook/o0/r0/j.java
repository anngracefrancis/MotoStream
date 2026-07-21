package com.facebook.o0.r0;

import android.text.TextUtils;
import com.facebook.a0;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.m;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j {
    public static final j a = new j();

    private j() {
    }

    public static final File a() {
        a0 a0Var = a0.a;
        File file = new File(a0.c().getFilesDir(), "facebook_ml/");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    public static final Map<String, f> c(File file) {
        m.f(file, "file");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int iAvailable = fileInputStream.available();
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            byte[] bArr = new byte[iAvailable];
            dataInputStream.readFully(bArr);
            dataInputStream.close();
            if (iAvailable < 4) {
                return null;
            }
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, 0, 4);
            byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
            int i2 = byteBufferWrap.getInt();
            int i3 = i2 + 4;
            if (iAvailable < i3) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(new String(bArr, 4, i2, Charsets.f25054b));
            JSONArray jSONArrayNames = jSONObject.names();
            int length = jSONArrayNames.length();
            String[] strArr = new String[length];
            int i4 = length - 1;
            if (i4 >= 0) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    strArr[i5] = jSONArrayNames.getString(i5);
                    if (i6 > i4) {
                        break;
                    }
                    i5 = i6;
                }
            }
            kotlin.collections.m.o(strArr);
            HashMap map = new HashMap();
            int i7 = 0;
            while (i7 < length) {
                String str = strArr[i7];
                i7++;
                if (str != null) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    int length2 = jSONArray.length();
                    int[] iArr = new int[length2];
                    int i8 = length2 - 1;
                    int i9 = 1;
                    if (i8 >= 0) {
                        int i10 = 0;
                        while (true) {
                            int i11 = i10 + 1;
                            iArr[i10] = jSONArray.getInt(i10);
                            i9 *= iArr[i10];
                            if (i11 > i8) {
                                break;
                            }
                            i10 = i11;
                        }
                    }
                    int i12 = i9 * 4;
                    int i13 = i3 + i12;
                    if (i13 > iAvailable) {
                        return null;
                    }
                    ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(bArr, i3, i12);
                    byteBufferWrap2.order(ByteOrder.LITTLE_ENDIAN);
                    f fVar = new f(iArr);
                    byteBufferWrap2.asFloatBuffer().get(fVar.a(), 0, i9);
                    map.put(str, fVar);
                    i3 = i13;
                }
            }
            return map;
        } catch (Exception unused) {
            return null;
        }
    }

    public final String b(String str) {
        m.f(str, "str");
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = m.h(str.charAt(!z ? i2 : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i2++;
            } else {
                z = true;
            }
        }
        Object[] array = new Regex("\\s+").d(str.subSequence(i2, length + 1).toString(), 0).toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        String strJoin = TextUtils.join(" ", (String[]) array);
        m.e(strJoin, "join(\" \", strArray)");
        return strJoin;
    }

    public final int[] d(String str, int i2) {
        m.f(str, "texts");
        int[] iArr = new int[i2];
        String strB = b(str);
        Charset charsetForName = Charset.forName("UTF-8");
        m.e(charsetForName, "forName(\"UTF-8\")");
        if (strB == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = strB.getBytes(charsetForName);
        m.e(bytes, "(this as java.lang.String).getBytes(charset)");
        if (i2 > 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 < bytes.length) {
                    iArr[i3] = bytes[i3] & 255;
                } else {
                    iArr[i3] = 0;
                }
                if (i4 >= i2) {
                    break;
                }
                i3 = i4;
            }
        }
        return iArr;
    }
}
