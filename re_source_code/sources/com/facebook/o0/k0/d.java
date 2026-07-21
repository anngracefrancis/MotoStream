package com.facebook.o0.k0;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import cm.aptoide.pt.root.execution.Command;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.text.Regex;
import kotlin.text.v;

/* JADX INFO: compiled from: MetadataMatcher.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final d a = new d();

    private d() {
    }

    public static final List<String> a(View view) {
        m.f(view, "view");
        ArrayList arrayList = new ArrayList();
        com.facebook.o0.m0.n.f fVar = com.facebook.o0.m0.n.f.a;
        ViewGroup viewGroupJ = com.facebook.o0.m0.n.f.j(view);
        if (viewGroupJ != null) {
            for (View view2 : com.facebook.o0.m0.n.f.b(viewGroupJ)) {
                if (view != view2) {
                    arrayList.addAll(a.c(view2));
                }
            }
        }
        return arrayList;
    }

    public static final List<String> b(View view) {
        m.f(view, "view");
        ArrayList<String> arrayList = new ArrayList();
        com.facebook.o0.m0.n.f fVar = com.facebook.o0.m0.n.f.a;
        arrayList.add(com.facebook.o0.m0.n.f.i(view));
        Object tag = view.getTag();
        if (tag != null) {
            arrayList.add(tag.toString());
        }
        CharSequence contentDescription = view.getContentDescription();
        if (contentDescription != null) {
            arrayList.add(contentDescription.toString());
        }
        try {
            if (view.getId() != -1) {
                String resourceName = view.getResources().getResourceName(view.getId());
                m.e(resourceName, "resourceName");
                Object[] array = new Regex("/").d(resourceName, 0).toArray(new String[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                String[] strArr = (String[]) array;
                if (strArr.length == 2) {
                    arrayList.add(strArr[1]);
                }
            }
        } catch (Resources.NotFoundException unused) {
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str : arrayList) {
            if ((str.length() > 0) && str.length() <= 100) {
                String lowerCase = str.toLowerCase();
                m.e(lowerCase, "(this as java.lang.String).toLowerCase()");
                arrayList2.add(lowerCase);
            }
        }
        return arrayList2;
    }

    private final List<String> c(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof EditText) {
            return arrayList;
        }
        if (!(view instanceof TextView)) {
            com.facebook.o0.m0.n.f fVar = com.facebook.o0.m0.n.f.a;
            Iterator<View> it = com.facebook.o0.m0.n.f.b(view).iterator();
            while (it.hasNext()) {
                arrayList.addAll(c(it.next()));
            }
            return arrayList;
        }
        String string = ((TextView) view).getText().toString();
        if ((string.length() > 0) && string.length() < 100) {
            String lowerCase = string.toLowerCase();
            m.e(lowerCase, "(this as java.lang.String).toLowerCase()");
            arrayList.add(lowerCase);
        }
        return arrayList;
    }

    private final boolean d(String str, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (v.J(str, it.next(), false, 2, null)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean e(List<String> list, List<String> list2) {
        m.f(list, "indicators");
        m.f(list2, "keys");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (a.d(it.next(), list2)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean f(String str, String str2) {
        m.f(str, Command.CommandHandler.TEXT);
        m.f(str2, "rule");
        return new Regex(str2).b(str);
    }
}
