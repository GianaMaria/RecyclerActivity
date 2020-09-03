package com.example.recycleractivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolderInfo> {

    private List<String> info;

    public Adapter(List<String> info) {
        this.info = info;
    }

    // сеттер
    public void setInfo(List<String> info) {
        this.info = info;
        notifyDataSetChanged();
    }

    // создание ресайкла
    @NonNull
    @Override
    public ViewHolderInfo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // создание вьюхолдера
        return new ViewHolderInfo(
                // переводим макет
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false)
        );
    }


    // наполнение данными
    @Override
    public void onBindViewHolder(@NonNull ViewHolderInfo holder, int position) {
        holder.bind(info.get(position));
    }

    // сколько всего элементов в списке
    @Override
    public int getItemCount() {
        if (info == null) {
            return 0;
        }
        return info.size();
    }

    // создание холдера
    static class ViewHolderInfo extends RecyclerView.ViewHolder {

        //для получения текствью
        private final TextView textView;

        // конструктор
        public ViewHolderInfo(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewInfo);
        }

        // метод наполнения информацией
        void bind(String info) {
            textView.setText(info);
        }
    }
}
