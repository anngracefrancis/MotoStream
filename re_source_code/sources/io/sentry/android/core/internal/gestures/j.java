package io.sentry.android.core.internal.gestures;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.util.q;
import java.util.Iterator;
import java.util.LinkedList;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: ViewUtils.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class j {
    static io.sentry.internal.gestures.b a(SentryAndroidOptions sentryAndroidOptions, View view, float f2, float f3, io.sentry.internal.gestures.b.a aVar) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(view);
        io.sentry.internal.gestures.b bVar = null;
        while (linkedList.size() > 0) {
            View view2 = (View) q.c((View) linkedList.poll(), "view is required");
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    linkedList.add(viewGroup.getChildAt(i2));
                }
            }
            Iterator<io.sentry.internal.gestures.a> it = sentryAndroidOptions.getGestureTargetLocators().iterator();
            while (it.hasNext()) {
                io.sentry.internal.gestures.b bVarA = it.next().a(view2, f2, f3, aVar);
                if (bVarA != null) {
                    if (aVar != io.sentry.internal.gestures.b.a.CLICKABLE) {
                        return bVarA;
                    }
                    bVar = bVarA;
                }
            }
        }
        return bVar;
    }

    public static String b(View view) throws Resources.NotFoundException {
        int id = view.getId();
        if (id == -1 || c(id)) {
            throw new Resources.NotFoundException();
        }
        Resources resources = view.getContext().getResources();
        return resources != null ? resources.getResourceEntryName(id) : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    private static boolean c(int i2) {
        return ((-16777216) & i2) == 0 && (i2 & 16777215) != 0;
    }
}
