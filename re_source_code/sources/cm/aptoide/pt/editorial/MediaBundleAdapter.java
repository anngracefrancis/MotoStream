package cm.aptoide.pt.editorial;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class MediaBundleAdapter extends RecyclerView.g<MediaViewHolder> {
    private List<EditorialMedia> media;
    private rx.s.b<EditorialEvent> uiEventListener;

    public MediaBundleAdapter(List<EditorialMedia> list, rx.s.b<EditorialEvent> bVar) {
        this.media = list;
        this.uiEventListener = bVar;
    }

    public void add(List<EditorialMedia> list) {
        this.media.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.media.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(MediaViewHolder mediaViewHolder, int i2) {
        mediaViewHolder.setVisibility(this.media.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public MediaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new MediaViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.media_layout, viewGroup, false), this.uiEventListener);
    }
}
