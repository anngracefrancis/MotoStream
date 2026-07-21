package com.facebook.o0.m0.n;

import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.root.execution.Command;
import cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment;
import java.util.Arrays;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PathComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f10323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f10324d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f10325e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f10326f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f10327g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f10328h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f10329i;

    /* JADX INFO: compiled from: PathComponent.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: PathComponent.kt */
    public enum b {
        ID(1),
        TEXT(2),
        TAG(4),
        DESCRIPTION(8),
        HINT(16);

        private final int l;

        b(int i2) {
            this.l = i2;
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static b[] valuesCustom() {
            b[] bVarArrValuesCustom = values();
            return (b[]) Arrays.copyOf(bVarArrValuesCustom, bVarArrValuesCustom.length);
        }

        public final int k() {
            return this.l;
        }
    }

    public c(JSONObject jSONObject) throws JSONException {
        m.f(jSONObject, "component");
        String string = jSONObject.getString("class_name");
        m.e(string, "component.getString(PATH_CLASS_NAME_KEY)");
        this.f10322b = string;
        this.f10323c = jSONObject.optInt("index", -1);
        this.f10324d = jSONObject.optInt(DeepLinkIntentReceiver.DeepLinksKeys.ID);
        String strOptString = jSONObject.optString(Command.CommandHandler.TEXT);
        m.e(strOptString, "component.optString(PATH_TEXT_KEY)");
        this.f10325e = strOptString;
        String strOptString2 = jSONObject.optString(StoreTabGridRecyclerFragment.BundleCons.TAG);
        m.e(strOptString2, "component.optString(PATH_TAG_KEY)");
        this.f10326f = strOptString2;
        String strOptString3 = jSONObject.optString("description");
        m.e(strOptString3, "component.optString(PATH_DESCRIPTION_KEY)");
        this.f10327g = strOptString3;
        String strOptString4 = jSONObject.optString("hint");
        m.e(strOptString4, "component.optString(PATH_HINT_KEY)");
        this.f10328h = strOptString4;
        this.f10329i = jSONObject.optInt("match_bitmask");
    }

    public final String a() {
        return this.f10322b;
    }

    public final String b() {
        return this.f10327g;
    }

    public final String c() {
        return this.f10328h;
    }

    public final int d() {
        return this.f10324d;
    }

    public final int e() {
        return this.f10323c;
    }

    public final int f() {
        return this.f10329i;
    }

    public final String g() {
        return this.f10326f;
    }

    public final String h() {
        return this.f10325e;
    }
}
