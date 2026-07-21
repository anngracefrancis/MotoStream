package androidx.core.app;

import android.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: Person.java */
/* JADX INFO: loaded from: classes.dex */
public class m {
    CharSequence a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    IconCompat f929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f933f;

    public IconCompat a() {
        return this.f929b;
    }

    public String b() {
        return this.f931d;
    }

    public CharSequence c() {
        return this.a;
    }

    public String d() {
        return this.f930c;
    }

    public boolean e() {
        return this.f932e;
    }

    public boolean f() {
        return this.f933f;
    }

    public String g() {
        String str = this.f930c;
        if (str != null) {
            return str;
        }
        if (this.a == null) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        return "name:" + ((Object) this.a);
    }

    public Person h() {
        return new Person.Builder().setName(c()).setIcon(a() != null ? a().p() : null).setUri(d()).setKey(b()).setBot(e()).setImportant(f()).build();
    }
}
