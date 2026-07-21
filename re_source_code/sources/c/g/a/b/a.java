package c.g.a.b;

import android.view.View;

/* JADX INFO: compiled from: Debug.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String a(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }
}
