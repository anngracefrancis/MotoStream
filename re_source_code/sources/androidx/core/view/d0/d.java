package androidx.core.view.d0;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: AccessibilityNodeProviderCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private final Object a;

    /* JADX INFO: compiled from: AccessibilityNodeProviderCompat.java */
    static class a extends AccessibilityNodeProvider {
        final d a;

        a(d dVar) {
            this.a = dVar;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i2) {
            androidx.core.view.d0.c cVarB = this.a.b(i2);
            if (cVarB == null) {
                return null;
            }
            return cVarB.x0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i2) {
            List<androidx.core.view.d0.c> listC = this.a.c(str, i2);
            if (listC == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = listC.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(listC.get(i3).x0());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i2, int i3, Bundle bundle) {
            return this.a.f(i2, i3, bundle);
        }
    }

    /* JADX INFO: compiled from: AccessibilityNodeProviderCompat.java */
    static class b extends a {
        b(d dVar) {
            super(dVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i2) {
            androidx.core.view.d0.c cVarD = this.a.d(i2);
            if (cVarD == null) {
                return null;
            }
            return cVarD.x0();
        }
    }

    /* JADX INFO: compiled from: AccessibilityNodeProviderCompat.java */
    static class c extends b {
        c(d dVar) {
            super(dVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i2, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.a.a(i2, androidx.core.view.d0.c.y0(accessibilityNodeInfo), str, bundle);
        }
    }

    public d() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            this.a = new c(this);
            return;
        }
        if (i2 >= 19) {
            this.a = new b(this);
        } else if (i2 >= 16) {
            this.a = new a(this);
        } else {
            this.a = null;
        }
    }

    public void a(int i2, androidx.core.view.d0.c cVar, String str, Bundle bundle) {
    }

    public androidx.core.view.d0.c b(int i2) {
        return null;
    }

    public List<androidx.core.view.d0.c> c(String str, int i2) {
        return null;
    }

    public androidx.core.view.d0.c d(int i2) {
        return null;
    }

    public Object e() {
        return this.a;
    }

    public boolean f(int i2, int i3, Bundle bundle) {
        return false;
    }

    public d(Object obj) {
        this.a = obj;
    }
}
