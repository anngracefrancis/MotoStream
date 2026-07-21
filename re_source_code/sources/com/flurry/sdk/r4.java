package com.flurry.sdk;

import android.os.Bundle;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public final class r4 implements f7<p> {
    r4() {
    }

    private static void b(p pVar) {
        Bundle bundle;
        Bundle bundle2 = pVar.f10968b;
        if (bundle2 == null || (bundle = bundle2.getBundle("launch_options")) == null) {
            return;
        }
        d1.c(3, "LifecycleObserver", "Launch Options Bundle is present " + bundle.toString());
        for (String str : bundle.keySet()) {
            if (str != null) {
                Object obj = bundle.get(str);
                String string = obj != null ? obj.toString() : "null";
                ArrayList arrayList = new ArrayList();
                arrayList.add(string);
                if (str.isEmpty()) {
                    d1.c(2, "LaunchOptionsFrame", "Launch option key is empty, do not send the frame.");
                } else if (arrayList.size() == 0) {
                    d1.c(2, "LaunchOptionsFrame", "Launch option values is empty, do not send the frame.");
                } else {
                    m2.a().b(new v5(new w5(str, arrayList)));
                }
                d1.c(3, "LifecycleObserver", "Launch options Key: " + str + ". Its value: " + string);
            }
        }
    }

    @Override // com.flurry.sdk.f7
    public final /* synthetic */ void a(p pVar) {
        Bundle bundle;
        p pVar2 = pVar;
        if (p.a.APP_ORIENTATION_CHANGE.equals(pVar2.a) && (bundle = pVar2.f10968b) != null && bundle.containsKey("orientation_name")) {
            int i2 = bundle.getInt("orientation_name");
            f5.h(i2);
            d1.c(5, "LifecycleObserver", pVar2.a.name() + " orientation: " + i2);
        }
        if (p.a.CREATED.equals(pVar2.a)) {
            b(pVar2);
        }
    }
}
