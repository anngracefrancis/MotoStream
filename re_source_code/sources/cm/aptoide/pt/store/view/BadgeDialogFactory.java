package cm.aptoide.pt.store.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.themes.ThemeManager;

/* JADX INFO: loaded from: classes.dex */
public class BadgeDialogFactory {
    public static final float MEDAL_SCALE = 1.25f;
    private final Context context;
    private int normalMedalSize;
    private int selectedMedalSize;
    private final ThemeManager themeManager;

    /* JADX INFO: renamed from: cm.aptoide.pt.store.view.BadgeDialogFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$store$view$GridStoreMetaWidget$HomeMeta$Badge;

        static {
            int[] iArr = new int[GridStoreMetaWidget.HomeMeta.Badge.values().length];
            $SwitchMap$cm$aptoide$pt$store$view$GridStoreMetaWidget$HomeMeta$Badge = iArr;
            try {
                iArr[GridStoreMetaWidget.HomeMeta.Badge.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$store$view$GridStoreMetaWidget$HomeMeta$Badge[GridStoreMetaWidget.HomeMeta.Badge.BRONZE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$store$view$GridStoreMetaWidget$HomeMeta$Badge[GridStoreMetaWidget.HomeMeta.Badge.SILVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$store$view$GridStoreMetaWidget$HomeMeta$Badge[GridStoreMetaWidget.HomeMeta.Badge.GOLD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$store$view$GridStoreMetaWidget$HomeMeta$Badge[GridStoreMetaWidget.HomeMeta.Badge.PLATINUM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public BadgeDialogFactory(Context context, ThemeManager themeManager) {
        this.context = context;
        this.themeManager = themeManager;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x03c9  */
    /* JADX WARN: Code duplicated, block: B:37:0x03d8  */
    /* JADX WARN: Code duplicated, block: B:40:0x0483  */
    /* JADX WARN: Code duplicated, block: B:41:0x04a5  */
    private void createViewModel(final GridStoreMetaWidget.HomeMeta.Badge badge, final Resources resources, GridStoreMetaWidget.HomeMeta.Badge badge2, final View view, final boolean z) {
        int i2;
        int i3;
        int i4;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i5;
        int i6;
        int i7;
        int i8;
        ImageView imageView = (ImageView) view.findViewById(R.id.header_background);
        View viewFindViewById = view.findViewById(R.id.followers_background);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.medal_icon);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.tin_medal);
        ImageView imageView4 = (ImageView) view.findViewById(R.id.bronze_medal);
        ImageView imageView5 = (ImageView) view.findViewById(R.id.silver_medal);
        ImageView imageView6 = (ImageView) view.findViewById(R.id.gold_medal);
        ImageView imageView7 = (ImageView) view.findViewById(R.id.platinum_medal);
        View viewFindViewById2 = view.findViewById(R.id.tin_medal_layout);
        View viewFindViewById3 = view.findViewById(R.id.bronze_medal_layout);
        View viewFindViewById4 = view.findViewById(R.id.silver_medal_layout);
        View viewFindViewById5 = view.findViewById(R.id.gold_medal_layout);
        View viewFindViewById6 = view.findViewById(R.id.platinum_medal_layout);
        TextView textView = (TextView) view.findViewById(R.id.medal_title);
        TextView textView2 = (TextView) view.findViewById(R.id.congratulations_message);
        TextView textView3 = (TextView) view.findViewById(R.id.uploaded_apps);
        TextView textView4 = (TextView) view.findViewById(R.id.downloads);
        TextView textView5 = (TextView) view.findViewById(R.id.followers);
        TextView textView6 = (TextView) view.findViewById(R.id.reviews);
        View viewFindViewById7 = view.findViewById(R.id.progress1);
        View viewFindViewById8 = view.findViewById(R.id.progress2);
        View viewFindViewById9 = view.findViewById(R.id.progress3);
        View viewFindViewById10 = view.findViewById(R.id.progress4);
        int i9 = AnonymousClass1.$SwitchMap$cm$aptoide$pt$store$view$GridStoreMetaWidget$HomeMeta$Badge[badge2.ordinal()];
        int i10 = R.color.grey_fog_dark;
        if (i9 != 2) {
            if (i9 != 3) {
                if (i9 == 4) {
                    if (isRankLocked(badge, badge2)) {
                        imageView2.setImageResource(R.drawable.lock_medal_gradient);
                        i6 = 0;
                        textView2.setText(resources.getString(R.string.badgedialog_message_gold_lock, " 💪"));
                        i7 = R.color.grey_fog_light;
                    } else {
                        i6 = 0;
                        imageView2.setImageResource(R.drawable.gold_medal_gradient);
                        i10 = R.color.gold_medal;
                        textView2.setText(resources.getString(R.string.badgedialog_message_gold, "🎉"));
                        i7 = R.color.gold_medal_secodary;
                    }
                    textView.setText(resources.getString(R.string.badgedialog_title_gold));
                    textView3.setText(resources.getString(R.string.badgedialog_message_gold_1));
                    textView3.setVisibility(i6);
                    textView4.setVisibility(i6);
                    textView5.setVisibility(i6);
                    viewFindViewById.setVisibility(i6);
                    textView6.setVisibility(i6);
                    textView4.setText(resources.getString(R.string.badgedialog_message_gold_2));
                    textView5.setText(resources.getString(R.string.badgedialog_message_gold_3));
                    textView6.setText(resources.getString(R.string.badgedialog_message_gold_4));
                    i3 = i7;
                    i4 = i10;
                    z2 = true;
                    z3 = false;
                } else if (i9 != 5) {
                    i3 = R.color.tin_medal_secodary;
                    imageView2.setImageResource(R.drawable.tin_medal_gradient);
                    textView.setText(resources.getString(R.string.badgedialog_title_tin));
                    z4 = false;
                    textView2.setText(resources.getString(R.string.badgedialog_message_tin, "🎉"));
                    textView3.setText(resources.getString(R.string.badgedialog_message_tin_1));
                    textView3.setVisibility(0);
                    textView4.setVisibility(8);
                    textView5.setVisibility(8);
                    viewFindViewById.setVisibility(8);
                    textView6.setVisibility(8);
                    imageView3 = imageView3;
                    z2 = false;
                    z3 = false;
                    i4 = R.color.tin_medal;
                    z5 = true;
                    z6 = false;
                } else {
                    if (isRankLocked(badge, badge2)) {
                        imageView2.setImageResource(R.drawable.lock_medal_gradient);
                        textView2.setText(resources.getString(R.string.badgedialog_message_platinum_lock, " 💪"));
                        i8 = R.color.grey_fog_light;
                    } else {
                        imageView2.setImageResource(R.drawable.platinum_medal_gradient);
                        i10 = R.color.platinum_medal;
                        textView2.setText(resources.getString(R.string.badgedialog_message_platinum, "🎉"));
                        i8 = R.color.platinum_medal_secodary;
                    }
                    textView.setText(resources.getString(R.string.badgedialog_title_platinum));
                    textView3.setText(resources.getString(R.string.badgedialog_message_platinum_1));
                    textView3.setVisibility(0);
                    textView4.setVisibility(0);
                    textView5.setVisibility(0);
                    viewFindViewById.setVisibility(0);
                    textView6.setVisibility(0);
                    textView4.setText(resources.getString(R.string.badgedialog_message_platinum_2));
                    textView5.setText(resources.getString(R.string.badgedialog_message_platinum_3));
                    textView6.setText(resources.getString(R.string.badgedialog_message_platinum_4));
                    i3 = i8;
                    i4 = i10;
                    z2 = false;
                    z3 = false;
                    z4 = false;
                    z5 = false;
                    z6 = true;
                }
                boolean z7 = z2;
                boolean z8 = z3;
                int i11 = i4;
                boolean z9 = z4;
                int i12 = i3;
                boolean z10 = z5;
                int progressColor = getProgressColor(i11, i12, badge, badge2, GridStoreMetaWidget.HomeMeta.Badge.NONE);
                int progressColor2 = getProgressColor(i11, i12, badge, badge2, GridStoreMetaWidget.HomeMeta.Badge.BRONZE);
                int progressColor3 = getProgressColor(i11, i12, badge, badge2, GridStoreMetaWidget.HomeMeta.Badge.SILVER);
                int progressColor4 = getProgressColor(i11, i12, badge, badge2, GridStoreMetaWidget.HomeMeta.Badge.GOLD);
                int progressColor5 = getProgressColor(i11, i12, badge, badge2, GridStoreMetaWidget.HomeMeta.Badge.PLATINUM);
                imageView.setBackgroundColor(resources.getColor(i4));
                if (isRankLocked(badge, badge2)) {
                    setDrawableColor(resources, R.color.grey_fog_light, textView3);
                    setDrawableColor(resources, R.color.white, textView4);
                    setDrawableColor(resources, R.color.grey_fog_light, textView5);
                    setDrawableColor(resources, R.color.white, textView6);
                } else {
                    setDrawableColor(resources, i4, textView3);
                    setDrawableColor(resources, i4, textView4);
                    setDrawableColor(resources, i4, textView5);
                    setDrawableColor(resources, i4, textView6);
                }
                setupMedal(imageView3, z10, progressColor, resources);
                setupMedal(imageView4, z9, progressColor2, resources);
                setupMedal(imageView5, z8, progressColor3, resources);
                setupMedal(imageView6, z7, progressColor4, resources);
                setupMedal(imageView7, z6, progressColor5, resources);
                viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.store.view.t
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        this.f7725f.a(badge, resources, view, z, view2);
                    }
                });
                viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.store.view.u
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        this.f7741f.b(badge, resources, view, z, view2);
                    }
                });
                viewFindViewById4.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.store.view.v
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        this.f7751f.c(badge, resources, view, z, view2);
                    }
                });
                viewFindViewById5.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.store.view.s
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        this.f7717f.d(badge, resources, view, z, view2);
                    }
                });
                viewFindViewById6.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.store.view.w
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        this.f7758f.e(badge, resources, view, z, view2);
                    }
                });
                viewFindViewById7.setBackgroundColor(resources.getColor(progressColor2));
                viewFindViewById8.setBackgroundColor(resources.getColor(progressColor3));
                viewFindViewById9.setBackgroundColor(resources.getColor(progressColor4));
                viewFindViewById10.setBackgroundColor(resources.getColor(progressColor5));
                if (z) {
                    textView2.setVisibility(0);
                    viewFindViewById2.setVisibility(0);
                    viewFindViewById3.setVisibility(0);
                    viewFindViewById4.setVisibility(0);
                    viewFindViewById5.setVisibility(0);
                    viewFindViewById6.setVisibility(0);
                    viewFindViewById7.setVisibility(0);
                    viewFindViewById8.setVisibility(0);
                    viewFindViewById9.setVisibility(0);
                    viewFindViewById10.setVisibility(0);
                    return;
                }
                textView2.setVisibility(8);
                viewFindViewById2.setVisibility(8);
                viewFindViewById3.setVisibility(8);
                viewFindViewById4.setVisibility(8);
                viewFindViewById5.setVisibility(8);
                viewFindViewById6.setVisibility(8);
                viewFindViewById7.setVisibility(8);
                viewFindViewById8.setVisibility(8);
                viewFindViewById9.setVisibility(8);
                viewFindViewById10.setVisibility(8);
            }
            if (isRankLocked(badge, badge2)) {
                imageView2.setImageResource(R.drawable.lock_medal_gradient);
                textView2.setText(resources.getString(R.string.badgedialog_message_silver_lock, " 💪"));
                i5 = R.color.grey_fog_light;
            } else {
                imageView2.setImageResource(R.drawable.silver_medal_gradient);
                i10 = R.color.silver_medal;
                textView2.setText(resources.getString(R.string.badgedialog_message_silver, "🎉"));
                i5 = R.color.silver_medal_secodary;
            }
            textView.setText(resources.getString(R.string.badgedialog_title_silver));
            textView3.setText(resources.getString(R.string.badgedialog_message_silver_1));
            textView4.setText(resources.getString(R.string.badgedialog_message_silver_2));
            textView5.setText(resources.getString(R.string.badgedialog_message_silver_3));
            textView6.setText(resources.getString(R.string.badgedialog_message_silver_4));
            textView3.setVisibility(0);
            textView4.setVisibility(0);
            textView5.setVisibility(0);
            viewFindViewById.setVisibility(0);
            textView6.setVisibility(0);
            i3 = i5;
            i4 = i10;
            z2 = false;
            z3 = true;
            z4 = false;
        } else {
            imageView3 = imageView3;
            if (isRankLocked(badge, badge2)) {
                imageView2.setImageResource(R.drawable.lock_medal_gradient);
                textView2.setText(resources.getString(R.string.badgedialog_message_bronze_lock, " 💪"));
                i2 = R.color.grey_fog_light;
            } else {
                imageView2.setImageResource(R.drawable.bronze_medal_gradient);
                i10 = R.color.bronze_medal;
                textView2.setText(resources.getString(R.string.badgedialog_message_bronze, "🎉"));
                i2 = R.color.bronze_medal_secodary;
            }
            textView.setText(resources.getString(R.string.badgedialog_title_bronze));
            textView3.setText(resources.getString(R.string.badgedialog_message_bronze_1));
            textView4.setText(resources.getString(R.string.badgedialog_message_bronze_2));
            textView5.setText(resources.getString(R.string.badgedialog_message_bronze_3));
            textView6.setText(resources.getString(R.string.badgedialog_message_bronze_4));
            textView3.setVisibility(0);
            textView4.setVisibility(0);
            textView5.setVisibility(0);
            viewFindViewById.setVisibility(0);
            textView6.setVisibility(0);
            i3 = i2;
            i4 = i10;
            z2 = false;
            z3 = false;
            z4 = true;
        }
        z5 = false;
        z6 = false;
        boolean z11 = z2;
        boolean z12 = z3;
        int i13 = i4;
        boolean z13 = z4;
        int i14 = i3;
        boolean z14 = z5;
        int progressColor6 = getProgressColor(i13, i14, badge, badge2, GridStoreMetaWidget.HomeMeta.Badge.NONE);
        int progressColor7 = getProgressColor(i13, i14, badge, badge2, GridStoreMetaWidget.HomeMeta.Badge.BRONZE);
        int progressColor8 = getProgressColor(i13, i14, badge, badge2, GridStoreMetaWidget.HomeMeta.Badge.SILVER);
        int progressColor9 = getProgressColor(i13, i14, badge, badge2, GridStoreMetaWidget.HomeMeta.Badge.GOLD);
        int progressColor10 = getProgressColor(i13, i14, badge, badge2, GridStoreMetaWidget.HomeMeta.Badge.PLATINUM);
        imageView.setBackgroundColor(resources.getColor(i4));
        if (isRankLocked(badge, badge2)) {
            setDrawableColor(resources, i4, textView3);
            setDrawableColor(resources, i4, textView4);
            setDrawableColor(resources, i4, textView5);
            setDrawableColor(resources, i4, textView6);
        } else {
            setDrawableColor(resources, R.color.grey_fog_light, textView3);
            setDrawableColor(resources, R.color.white, textView4);
            setDrawableColor(resources, R.color.grey_fog_light, textView5);
            setDrawableColor(resources, R.color.white, textView6);
        }
        setupMedal(imageView3, z14, progressColor6, resources);
        setupMedal(imageView4, z13, progressColor7, resources);
        setupMedal(imageView5, z12, progressColor8, resources);
        setupMedal(imageView6, z11, progressColor9, resources);
        setupMedal(imageView7, z6, progressColor10, resources);
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.store.view.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f7725f.a(badge, resources, view, z, view2);
            }
        });
        viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.store.view.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f7741f.b(badge, resources, view, z, view2);
            }
        });
        viewFindViewById4.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.store.view.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f7751f.c(badge, resources, view, z, view2);
            }
        });
        viewFindViewById5.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.store.view.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f7717f.d(badge, resources, view, z, view2);
            }
        });
        viewFindViewById6.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.store.view.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f7758f.e(badge, resources, view, z, view2);
            }
        });
        viewFindViewById7.setBackgroundColor(resources.getColor(progressColor7));
        viewFindViewById8.setBackgroundColor(resources.getColor(progressColor8));
        viewFindViewById9.setBackgroundColor(resources.getColor(progressColor9));
        viewFindViewById10.setBackgroundColor(resources.getColor(progressColor10));
        if (z) {
            textView2.setVisibility(0);
            viewFindViewById2.setVisibility(0);
            viewFindViewById3.setVisibility(0);
            viewFindViewById4.setVisibility(0);
            viewFindViewById5.setVisibility(0);
            viewFindViewById6.setVisibility(0);
            viewFindViewById7.setVisibility(0);
            viewFindViewById8.setVisibility(0);
            viewFindViewById9.setVisibility(0);
            viewFindViewById10.setVisibility(0);
            return;
        }
        textView2.setVisibility(8);
        viewFindViewById2.setVisibility(8);
        viewFindViewById3.setVisibility(8);
        viewFindViewById4.setVisibility(8);
        viewFindViewById5.setVisibility(8);
        viewFindViewById6.setVisibility(8);
        viewFindViewById7.setVisibility(8);
        viewFindViewById8.setVisibility(8);
        viewFindViewById9.setVisibility(8);
        viewFindViewById10.setVisibility(8);
    }

    private int getProgressColor(int i2, int i3, GridStoreMetaWidget.HomeMeta.Badge badge, GridStoreMetaWidget.HomeMeta.Badge badge2, GridStoreMetaWidget.HomeMeta.Badge badge3) {
        int i4 = this.themeManager.getAttributeForTheme(R.attr.storeBadgeDialogProgress).resourceId;
        if (badge3.ordinal() > badge.ordinal() || badge3.ordinal() > badge2.ordinal()) {
            return badge3.ordinal() <= badge.ordinal() ? i3 : i4;
        }
        return i2;
    }

    private boolean isRankLocked(GridStoreMetaWidget.HomeMeta.Badge badge, GridStoreMetaWidget.HomeMeta.Badge badge2) {
        return badge.ordinal() < badge2.ordinal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$createViewModel$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(GridStoreMetaWidget.HomeMeta.Badge badge, Resources resources, View view, boolean z, View view2) {
        createViewModel(badge, resources, GridStoreMetaWidget.HomeMeta.Badge.NONE, view, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$createViewModel$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(GridStoreMetaWidget.HomeMeta.Badge badge, Resources resources, View view, boolean z, View view2) {
        createViewModel(badge, resources, GridStoreMetaWidget.HomeMeta.Badge.BRONZE, view, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$createViewModel$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(GridStoreMetaWidget.HomeMeta.Badge badge, Resources resources, View view, boolean z, View view2) {
        createViewModel(badge, resources, GridStoreMetaWidget.HomeMeta.Badge.SILVER, view, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$createViewModel$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(GridStoreMetaWidget.HomeMeta.Badge badge, Resources resources, View view, boolean z, View view2) {
        createViewModel(badge, resources, GridStoreMetaWidget.HomeMeta.Badge.GOLD, view, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$createViewModel$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(GridStoreMetaWidget.HomeMeta.Badge badge, Resources resources, View view, boolean z, View view2) {
        createViewModel(badge, resources, GridStoreMetaWidget.HomeMeta.Badge.PLATINUM, view, z);
    }

    private void setBackground(ImageView imageView, int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(i2);
        if (Build.VERSION.SDK_INT >= 16) {
            imageView.setBackground(gradientDrawable);
        } else {
            imageView.setBackgroundDrawable(gradientDrawable);
        }
    }

    private void setDrawableColor(Resources resources, int i2, TextView textView) {
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        int length = compoundDrawables.length;
        for (int i3 = 0; i3 < length; i3++) {
            Drawable drawable = compoundDrawables[i3];
            if (drawable != null) {
                drawable.mutate();
                drawable.setColorFilter(new PorterDuffColorFilter(resources.getColor(i2), PorterDuff.Mode.SRC_IN));
                compoundDrawables[i3] = drawable;
            }
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
    }

    private void setupMedal(ImageView imageView, boolean z, int i2, Resources resources) {
        if (z) {
            imageView.getLayoutParams().width = this.selectedMedalSize;
            imageView.getLayoutParams().height = this.selectedMedalSize;
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.requestLayout();
        } else {
            imageView.getLayoutParams().width = this.normalMedalSize;
            imageView.getLayoutParams().height = this.normalMedalSize;
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.requestLayout();
        }
        Drawable drawable = imageView.getDrawable();
        setDrawableColor(resources, i2, drawable);
        imageView.setImageDrawable(drawable);
        setBackground(imageView, resources.getColor(R.color.white));
    }

    public Dialog create(GridStoreMetaWidget.HomeMeta.Badge badge, boolean z) {
        View viewInflate = LayoutInflater.from(new ContextThemeWrapper(this.context, this.themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId)).inflate(R.layout.store_badge_dialog, (ViewGroup) null);
        int i2 = ((ImageView) viewInflate.findViewById(R.id.bronze_medal)).getLayoutParams().width;
        this.normalMedalSize = i2;
        this.selectedMedalSize = (int) (i2 * 1.25f);
        createViewModel(badge, viewInflate.getContext().getResources(), badge, viewInflate, z);
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(this.context).setView(viewInflate).create();
        viewInflate.findViewById(R.id.ok_button).setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.store.view.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                alertDialogCreate.dismiss();
            }
        });
        return alertDialogCreate;
    }

    private void setDrawableColor(Resources resources, int i2, Drawable... drawableArr) {
        for (Drawable drawable : drawableArr) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(resources.getColor(i2), PorterDuff.Mode.SRC_IN));
            }
        }
    }
}
