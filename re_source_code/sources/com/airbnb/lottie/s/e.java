package com.airbnb.lottie.s;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: KeyPath.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    private final List<String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f f8706b;

    public e(String... strArr) {
        this.a = Arrays.asList(strArr);
    }

    private boolean b() {
        List<String> list = this.a;
        return list.get(list.size() - 1).equals("**");
    }

    private boolean f(String str) {
        return str.equals("__container");
    }

    public e a(String str) {
        e eVar = new e(this);
        eVar.a.add(str);
        return eVar;
    }

    public boolean c(String str, int i2) {
        if (i2 >= this.a.size()) {
            return false;
        }
        boolean z = i2 == this.a.size() - 1;
        String str2 = this.a.get(i2);
        if (!str2.equals("**")) {
            return (z || (i2 == this.a.size() + (-2) && b())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.a.get(i2 + 1).equals(str)) {
            return i2 == this.a.size() + (-2) || (i2 == this.a.size() + (-3) && b());
        }
        if (z) {
            return true;
        }
        int i3 = i2 + 1;
        if (i3 < this.a.size() - 1) {
            return false;
        }
        return this.a.get(i3).equals(str);
    }

    public f d() {
        return this.f8706b;
    }

    public int e(String str, int i2) {
        if (f(str)) {
            return 0;
        }
        if (this.a.get(i2).equals("**")) {
            return (i2 != this.a.size() - 1 && this.a.get(i2 + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public boolean g(String str, int i2) {
        if (f(str)) {
            return true;
        }
        if (i2 >= this.a.size()) {
            return false;
        }
        return this.a.get(i2).equals(str) || this.a.get(i2).equals("**") || this.a.get(i2).equals("*");
    }

    public boolean h(String str, int i2) {
        return str.equals("__container") || i2 < this.a.size() - 1 || this.a.get(i2).equals("**");
    }

    public e i(f fVar) {
        e eVar = new e(this);
        eVar.f8706b = fVar;
        return eVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.a);
        sb.append(",resolved=");
        sb.append(this.f8706b != null);
        sb.append('}');
        return sb.toString();
    }

    private e(e eVar) {
        this.a = new ArrayList(eVar.a);
        this.f8706b = eVar.f8706b;
    }
}
