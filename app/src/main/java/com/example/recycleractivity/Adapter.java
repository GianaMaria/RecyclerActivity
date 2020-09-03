package com.example.recycleractivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolderInfo> {

    private List<User> users;

    public Adapter(List<User> users) {
        this.users = users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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
        holder.bind(users.get(position));
    }

    // сколько всего элементов в списке
    @Override
    public int getItemCount() {
        if (users == null) {
            return 0;
        }
        return users.size();
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
        void bind(User users) {
            textView.setText(users);
        }
    }
}
