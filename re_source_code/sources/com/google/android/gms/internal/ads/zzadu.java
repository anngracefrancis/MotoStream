package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzadu extends RelativeLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float[] f13838f = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AnimationDrawable f13839g;

    public zzadu(Context context, zzadt zzadtVar, RelativeLayout.LayoutParams layoutParams) {
        super(context);
        Preconditions.k(zzadtVar);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(f13838f, null, null));
        shapeDrawable.getPaint().setColor(zzadtVar.i7());
        setLayoutParams(layoutParams);
        zzk.zzli().c(this, shapeDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(zzadtVar.m1())) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            textView.setLayoutParams(layoutParams3);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(zzadtVar.m1());
            textView.setTextColor(zzadtVar.j7());
            textView.setTextSize(zzadtVar.k7());
            zzyt.a();
            int iA = zzazt.a(context, 4);
            zzyt.a();
            textView.setPadding(iA, 0, zzazt.a(context, 4), 0);
            addView(textView);
            layoutParams2.addRule(1, textView.getId());
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams2);
        imageView.setId(1195835394);
        List<zzadw> listL7 = zzadtVar.l7();
        if (listL7 != null && listL7.size() > 1) {
            this.f13839g = new AnimationDrawable();
            Iterator<zzadw> it = listL7.iterator();
            while (it.hasNext()) {
                try {
                    this.f13839g.addFrame((Drawable) ObjectWrapper.k0(it.next().t4()), zzadtVar.m7());
                } catch (Exception e2) {
                    zzbad.c("Error while getting drawable.", e2);
                }
            }
            zzk.zzli().c(imageView, this.f13839g);
        } else if (listL7.size() == 1) {
            try {
                imageView.setImageDrawable((Drawable) ObjectWrapper.k0(listL7.get(0).t4()));
            } catch (Exception e3) {
                zzbad.c("Error while getting drawable.", e3);
            }
        }
        addView(imageView);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        AnimationDrawable animationDrawable = this.f13839g;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
        super.onAttachedToWindow();
    }
}
