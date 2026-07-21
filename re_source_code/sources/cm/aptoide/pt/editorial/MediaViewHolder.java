package cm.aptoide.pt.editorial;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.networking.image.ImageLoader;

/* JADX INFO: loaded from: classes.dex */
class MediaViewHolder extends RecyclerView.c0 {
    private TextView description;
    private ImageView image;
    private rx.s.b<EditorialEvent> uiEventListener;
    private ImageView videoThumbnail;
    private FrameLayout videoThumbnailContainer;

    public MediaViewHolder(View view, rx.s.b<EditorialEvent> bVar) {
        super(view);
        this.uiEventListener = bVar;
        this.image = (ImageView) view.findViewById(R.id.image_item);
        this.videoThumbnail = (ImageView) view.findViewById(R.id.editorial_video_thumbnail);
        this.videoThumbnailContainer = (FrameLayout) view.findViewById(R.id.editorial_video_thumbnail_container);
        this.description = (TextView) view.findViewById(R.id.editorial_image_description);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setVisibility$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(EditorialMedia editorialMedia, View view) {
        this.uiEventListener.onNext(new EditorialEvent(EditorialEvent.Type.MEDIA, editorialMedia.getUrl()));
    }

    public void setDescriptionVisible() {
        this.description.setVisibility(0);
    }

    public void setVisibility(final EditorialMedia editorialMedia) {
        if (editorialMedia.hasUrl()) {
            if (editorialMedia.isVideo()) {
                if (editorialMedia.getThumbnail() != null) {
                    ImageLoader.with(this.itemView.getContext()).load(editorialMedia.getThumbnail(), this.videoThumbnail);
                }
                this.videoThumbnailContainer.setVisibility(0);
                this.videoThumbnailContainer.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.editorial.p6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f5438f.a(editorialMedia, view);
                    }
                });
            } else {
                ImageLoader.with(this.itemView.getContext()).load(editorialMedia.getUrl(), this.image);
                this.image.setVisibility(0);
            }
            this.description.setText(editorialMedia.getDescription());
        }
    }
}
