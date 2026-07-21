package androidx.lifecycle;

import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.savedstate.SavedStateRegistry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SavedStateHandle.java */
/* JADX INFO: loaded from: classes.dex */
public final class u {
    private static final Class[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Map<String, Object> f1768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Map<String, SavedStateRegistry.b> f1769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, ?> f1770d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SavedStateRegistry.b f1771e;

    /* JADX INFO: compiled from: SavedStateHandle.java */
    class a implements SavedStateRegistry.b {
        a() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.b
        public Bundle a() {
            for (Map.Entry entry : new HashMap(u.this.f1769c).entrySet()) {
                u.this.c((String) entry.getKey(), ((SavedStateRegistry.b) entry.getValue()).a());
            }
            Set<String> setKeySet = u.this.f1768b.keySet();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>(setKeySet.size());
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(arrayList.size());
            for (String str : setKeySet) {
                arrayList.add(str);
                arrayList2.add(u.this.f1768b.get(str));
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("keys", arrayList);
            bundle.putParcelableArrayList("values", arrayList2);
            return bundle;
        }
    }

    static {
        Class[] clsArr = new Class[29];
        clsArr[0] = Boolean.TYPE;
        clsArr[1] = boolean[].class;
        clsArr[2] = Double.TYPE;
        clsArr[3] = double[].class;
        Class<SizeF> cls = Integer.TYPE;
        clsArr[4] = cls;
        clsArr[5] = int[].class;
        clsArr[6] = Long.TYPE;
        clsArr[7] = long[].class;
        clsArr[8] = String.class;
        clsArr[9] = String[].class;
        clsArr[10] = Binder.class;
        clsArr[11] = Bundle.class;
        clsArr[12] = Byte.TYPE;
        clsArr[13] = byte[].class;
        clsArr[14] = Character.TYPE;
        clsArr[15] = char[].class;
        clsArr[16] = CharSequence.class;
        clsArr[17] = CharSequence[].class;
        clsArr[18] = ArrayList.class;
        clsArr[19] = Float.TYPE;
        clsArr[20] = float[].class;
        clsArr[21] = Parcelable.class;
        clsArr[22] = Parcelable[].class;
        clsArr[23] = Serializable.class;
        clsArr[24] = Short.TYPE;
        clsArr[25] = short[].class;
        clsArr[26] = SparseArray.class;
        int i2 = Build.VERSION.SDK_INT;
        clsArr[27] = i2 >= 21 ? Size.class : cls;
        if (i2 >= 21) {
            cls = SizeF.class;
        }
        clsArr[28] = cls;
        a = clsArr;
    }

    public u(Map<String, Object> map) {
        this.f1769c = new HashMap();
        this.f1770d = new HashMap();
        this.f1771e = new a();
        this.f1768b = new HashMap(map);
    }

    static u a(Bundle bundle, Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return new u();
        }
        HashMap map = new HashMap();
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                map.put(str, bundle2.get(str));
            }
        }
        if (bundle == null) {
            return new u(map);
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
        if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
            throw new IllegalStateException("Invalid bundle passed as restored state");
        }
        for (int i2 = 0; i2 < parcelableArrayList.size(); i2++) {
            map.put((String) parcelableArrayList.get(i2), parcelableArrayList2.get(i2));
        }
        return new u(map);
    }

    private static void d(Object obj) {
        if (obj == null) {
            return;
        }
        for (Class cls : a) {
            if (cls.isInstance(obj)) {
                return;
            }
        }
        throw new IllegalArgumentException("Can't put value with type " + obj.getClass() + " into saved state");
    }

    SavedStateRegistry.b b() {
        return this.f1771e;
    }

    public <T> void c(String str, T t) {
        d(t);
        q qVar = (q) this.f1770d.get(str);
        if (qVar != null) {
            qVar.n(t);
        } else {
            this.f1768b.put(str, t);
        }
    }

    public u() {
        this.f1769c = new HashMap();
        this.f1770d = new HashMap();
        this.f1771e = new a();
        this.f1768b = new HashMap();
    }
}
