package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import cm.aptoide.pt.database.room.RoomNotification;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: LegacyTokenHelper.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f0 {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f9704b = f0.class.getSimpleName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f9705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SharedPreferences f9706d;

    /* JADX INFO: compiled from: LegacyTokenHelper.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private final Date b(Bundle bundle, String str) {
            if (bundle == null) {
                return null;
            }
            long j2 = bundle.getLong(str, Long.MIN_VALUE);
            if (j2 == Long.MIN_VALUE) {
                return null;
            }
            return new Date(j2);
        }

        public final String a(Bundle bundle) {
            kotlin.jvm.internal.m.f(bundle, "bundle");
            return bundle.getString("com.facebook.TokenCachingStrategy.ApplicationId");
        }

        public final Date c(Bundle bundle) {
            kotlin.jvm.internal.m.f(bundle, "bundle");
            return b(bundle, "com.facebook.TokenCachingStrategy.ExpirationDate");
        }

        public final Date d(Bundle bundle) {
            kotlin.jvm.internal.m.f(bundle, "bundle");
            return b(bundle, "com.facebook.TokenCachingStrategy.LastRefreshDate");
        }

        public final w e(Bundle bundle) {
            kotlin.jvm.internal.m.f(bundle, "bundle");
            if (bundle.containsKey("com.facebook.TokenCachingStrategy.AccessTokenSource")) {
                return (w) bundle.getSerializable("com.facebook.TokenCachingStrategy.AccessTokenSource");
            }
            return bundle.getBoolean("com.facebook.TokenCachingStrategy.IsSSO") ? w.FACEBOOK_APPLICATION_WEB : w.WEB_VIEW;
        }

        public final String f(Bundle bundle) {
            kotlin.jvm.internal.m.f(bundle, "bundle");
            return bundle.getString("com.facebook.TokenCachingStrategy.Token");
        }

        public final boolean g(Bundle bundle) {
            String string;
            if (bundle == null || (string = bundle.getString("com.facebook.TokenCachingStrategy.Token")) == null) {
                return false;
            }
            return ((string.length() == 0) || bundle.getLong("com.facebook.TokenCachingStrategy.ExpirationDate", 0L) == 0) ? false : true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0016  */
    public f0(Context context, String str) {
        kotlin.jvm.internal.m.f(context, "context");
        if (str != null) {
            str = str.length() == 0 ? "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY" : str;
        }
        this.f9705c = str;
        Context applicationContext = context.getApplicationContext();
        SharedPreferences sharedPreferences = (applicationContext != null ? applicationContext : context).getSharedPreferences(str, 0);
        kotlin.jvm.internal.m.e(sharedPreferences, "context.getSharedPreferences(this.cacheKey, Context.MODE_PRIVATE)");
        this.f9706d = sharedPreferences;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void b(String str, Bundle bundle) throws JSONException {
        String str2;
        String string;
        String string2 = this.f9706d.getString(str, "{}");
        if (string2 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        JSONObject jSONObject = new JSONObject(string2);
        String string3 = jSONObject.getString("valueType");
        if (string3 != null) {
            int i2 = 0;
            switch (string3.hashCode()) {
                case -1573317553:
                    if (string3.equals("stringList")) {
                        JSONArray jSONArray = jSONObject.getJSONArray("value");
                        int length = jSONArray.length();
                        ArrayList<String> arrayList = new ArrayList<>(length);
                        if (length > 0) {
                            while (true) {
                                int i3 = i2 + 1;
                                Object obj = jSONArray.get(i2);
                                if (obj == JSONObject.NULL) {
                                    str2 = null;
                                } else {
                                    if (obj == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    str2 = (String) obj;
                                }
                                arrayList.add(i2, str2);
                                if (i3 < length) {
                                    i2 = i3;
                                }
                            }
                        }
                        bundle.putStringArrayList(str, arrayList);
                        return;
                    }
                    return;
                case -1383386164:
                    if (string3.equals("bool[]")) {
                        JSONArray jSONArray2 = jSONObject.getJSONArray("value");
                        int length2 = jSONArray2.length();
                        boolean[] zArr = new boolean[length2];
                        int i4 = length2 - 1;
                        if (i4 >= 0) {
                            while (true) {
                                int i5 = i2 + 1;
                                zArr[i2] = jSONArray2.getBoolean(i2);
                                if (i5 <= i4) {
                                    i2 = i5;
                                }
                            }
                        }
                        bundle.putBooleanArray(str, zArr);
                        return;
                    }
                    return;
                case -1374008726:
                    if (string3.equals("byte[]")) {
                        JSONArray jSONArray3 = jSONObject.getJSONArray("value");
                        int length3 = jSONArray3.length();
                        byte[] bArr = new byte[length3];
                        int i6 = length3 - 1;
                        if (i6 >= 0) {
                            while (true) {
                                int i7 = i2 + 1;
                                bArr[i2] = (byte) jSONArray3.getInt(i2);
                                if (i7 <= i6) {
                                    i2 = i7;
                                }
                            }
                        }
                        bundle.putByteArray(str, bArr);
                        return;
                    }
                    return;
                case -1361632968:
                    if (string3.equals("char[]")) {
                        JSONArray jSONArray4 = jSONObject.getJSONArray("value");
                        int length4 = jSONArray4.length();
                        char[] cArr = new char[length4];
                        int i8 = length4 - 1;
                        if (i8 >= 0) {
                            int i9 = 0;
                            while (true) {
                                int i10 = i9 + 1;
                                String string4 = jSONArray4.getString(i9);
                                if (string4 != null && string4.length() == 1) {
                                    cArr[i9] = string4.charAt(0);
                                }
                                if (i10 <= i8) {
                                    i9 = i10;
                                }
                            }
                        }
                        bundle.putCharArray(str, cArr);
                        return;
                    }
                    return;
                case -1325958191:
                    if (string3.equals("double")) {
                        bundle.putDouble(str, jSONObject.getDouble("value"));
                        return;
                    }
                    return;
                case -1097129250:
                    if (string3.equals("long[]")) {
                        JSONArray jSONArray5 = jSONObject.getJSONArray("value");
                        int length5 = jSONArray5.length();
                        long[] jArr = new long[length5];
                        int i11 = length5 - 1;
                        if (i11 >= 0) {
                            while (true) {
                                int i12 = i2 + 1;
                                jArr[i2] = jSONArray5.getLong(i2);
                                if (i12 <= i11) {
                                    i2 = i12;
                                }
                            }
                        }
                        bundle.putLongArray(str, jArr);
                        return;
                    }
                    return;
                case -891985903:
                    if (string3.equals("string")) {
                        bundle.putString(str, jSONObject.getString("value"));
                        return;
                    }
                    return;
                case -766441794:
                    if (string3.equals("float[]")) {
                        JSONArray jSONArray6 = jSONObject.getJSONArray("value");
                        int length6 = jSONArray6.length();
                        float[] fArr = new float[length6];
                        int i13 = length6 - 1;
                        if (i13 >= 0) {
                            while (true) {
                                int i14 = i2 + 1;
                                fArr[i2] = (float) jSONArray6.getDouble(i2);
                                if (i14 <= i13) {
                                    i2 = i14;
                                }
                            }
                        }
                        bundle.putFloatArray(str, fArr);
                        return;
                    }
                    return;
                case 104431:
                    if (string3.equals("int")) {
                        bundle.putInt(str, jSONObject.getInt("value"));
                        return;
                    }
                    return;
                case 3029738:
                    if (string3.equals("bool")) {
                        bundle.putBoolean(str, jSONObject.getBoolean("value"));
                        return;
                    }
                    return;
                case 3039496:
                    if (string3.equals("byte")) {
                        bundle.putByte(str, (byte) jSONObject.getInt("value"));
                        return;
                    }
                    return;
                case 3052374:
                    if (string3.equals("char") && (string = jSONObject.getString("value")) != null && string.length() == 1) {
                        bundle.putChar(str, string.charAt(0));
                        return;
                    }
                    return;
                case 3118337:
                    if (string3.equals("enum")) {
                        try {
                            bundle.putSerializable(str, Enum.valueOf(Class.forName(jSONObject.getString("enumType")), jSONObject.getString("value")));
                            return;
                        } catch (ClassNotFoundException | IllegalArgumentException unused) {
                            return;
                        }
                    }
                    return;
                case 3327612:
                    if (string3.equals("long")) {
                        bundle.putLong(str, jSONObject.getLong("value"));
                        return;
                    }
                    return;
                case 97526364:
                    if (string3.equals("float")) {
                        bundle.putFloat(str, (float) jSONObject.getDouble("value"));
                        return;
                    }
                    return;
                case 100361105:
                    if (string3.equals("int[]")) {
                        JSONArray jSONArray7 = jSONObject.getJSONArray("value");
                        int length7 = jSONArray7.length();
                        int[] iArr = new int[length7];
                        int i15 = length7 - 1;
                        if (i15 >= 0) {
                            while (true) {
                                int i16 = i2 + 1;
                                iArr[i2] = jSONArray7.getInt(i2);
                                if (i16 <= i15) {
                                    i2 = i16;
                                }
                            }
                        }
                        bundle.putIntArray(str, iArr);
                        return;
                    }
                    return;
                case 109413500:
                    if (string3.equals("short")) {
                        bundle.putShort(str, (short) jSONObject.getInt("value"));
                        return;
                    }
                    return;
                case 1359468275:
                    if (string3.equals("double[]")) {
                        JSONArray jSONArray8 = jSONObject.getJSONArray("value");
                        int length8 = jSONArray8.length();
                        double[] dArr = new double[length8];
                        int i17 = length8 - 1;
                        if (i17 >= 0) {
                            while (true) {
                                int i18 = i2 + 1;
                                dArr[i2] = jSONArray8.getDouble(i2);
                                if (i18 <= i17) {
                                    i2 = i18;
                                }
                            }
                        }
                        bundle.putDoubleArray(str, dArr);
                        return;
                    }
                    return;
                case 2067161310:
                    if (string3.equals("short[]")) {
                        JSONArray jSONArray9 = jSONObject.getJSONArray("value");
                        int length9 = jSONArray9.length();
                        short[] sArr = new short[length9];
                        int i19 = length9 - 1;
                        if (i19 >= 0) {
                            while (true) {
                                int i20 = i2 + 1;
                                sArr[i2] = (short) jSONArray9.getInt(i2);
                                if (i20 <= i19) {
                                    i2 = i20;
                                }
                            }
                        }
                        bundle.putShortArray(str, sArr);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void a() {
        this.f9706d.edit().clear().apply();
    }

    public final Bundle c() {
        Bundle bundle = new Bundle();
        for (String str : this.f9706d.getAll().keySet()) {
            try {
                kotlin.jvm.internal.m.e(str, RoomNotification.KEY);
                b(str, bundle);
            } catch (JSONException e2) {
                com.facebook.internal.j0.a aVar = com.facebook.internal.j0.a;
                g0 g0Var = g0.CACHE;
                String str2 = f9704b;
                kotlin.jvm.internal.m.e(str2, "TAG");
                aVar.a(g0Var, 5, str2, "Error reading cached value for key: '" + ((Object) str) + "' -- " + e2);
                return null;
            }
        }
        return bundle;
    }

    public /* synthetic */ f0(Context context, String str, int i2, kotlin.jvm.internal.g gVar) {
        this(context, (i2 & 2) != 0 ? null : str);
    }
}
