package com.example.dam_parcial1;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class EntityParcial implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String texto;
    private Boolean booleano;

    public static final Creator<EntityParcial> CREATOR = new Creator<EntityParcial>() {
        @Override
        public EntityParcial createFromParcel(Parcel in) {
            return new EntityParcial(in);
        }

        @Override
        public EntityParcial[] newArray(int size) {
            return new EntityParcial[size];
        }
    };

    public EntityParcial(){
        super();
    }

    public EntityParcial(String text, Boolean bool){
        super();
        texto = text;
        booleano = bool;
    }

    protected EntityParcial(Parcel in) {
        super();
        id = in.readInt();
        texto = in.readString();
        booleano = in.readBoolean();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Boolean getBooleano() {
        return booleano;
    }

    public void setBooleano(Boolean booleano) {
        this.booleano = booleano;
    }

    public static Creator<EntityParcial> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(texto);
        dest.writeBoolean(booleano);
    }
}
