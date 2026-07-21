package com.facebook.o0.q0;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.a0;

/* JADX INFO: compiled from: SourceApplicationInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class o {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f10439c;

    /* JADX INFO: compiled from: SourceApplicationInfo.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final void a() {
            a0 a0Var = a0.a;
            SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(a0.c()).edit();
            editorEdit.remove("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage");
            editorEdit.remove("com.facebook.appevents.SourceApplicationInfo.openedByApplink");
            editorEdit.apply();
        }

        public final o b() {
            a0 a0Var = a0.a;
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(a0.c());
            kotlin.jvm.internal.g gVar = null;
            if (defaultSharedPreferences.contains("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage")) {
                return new o(defaultSharedPreferences.getString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", null), defaultSharedPreferences.getBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", false), gVar);
            }
            return null;
        }
    }

    private o(String str, boolean z) {
        this.f10438b = str;
        this.f10439c = z;
    }

    public /* synthetic */ o(String str, boolean z, kotlin.jvm.internal.g gVar) {
        this(str, z);
    }

    public final void a() {
        a0 a0Var = a0.a;
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(a0.c()).edit();
        editorEdit.putString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", this.f10438b);
        editorEdit.putBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", this.f10439c);
        editorEdit.apply();
    }

    public String toString() {
        String str = this.f10439c ? "Applink" : "Unclassified";
        if (this.f10438b == null) {
            return str;
        }
        return str + '(' + ((Object) this.f10438b) + ')';
    }
}
